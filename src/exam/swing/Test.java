package exam.swing;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Test {

	static GetConnection gc = new GetConnection();
	static ResultSet rs;
	static PreparedStatement pst;
	static String sql = null;
	static String [][] questionlist = new String [25][6];
	static String [] correctAnswers = new String [25];
	static String [] stats = new String [2];
	static String [][] userdata = new String [5][3];
	static String [] columnNames = new String [10];
	
	
	public static Boolean checkLogin (String username, String password) {

		try {
			
		sql = "select Username,Password from userauthentication where binary Username=? and binary Password=? and SuperUser = 'N';";
		pst=gc.getConnection().prepareStatement(sql);
		
		pst.setString(1, username);
		pst.setString(2, password);
		
		rs = pst.executeQuery();
		
		if (rs.next()) {
			return true;
		}
		
		else {
			return false;
		}
	} 
		
	catch (Exception e) {
		System.out.println("Error while authenticating " + e);
		e.printStackTrace(System.err);
		return false;
		
	}
		
}

	public static String [][] ImportTestQuestions(String subject) {
			try { 
			sql= "select Question, AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, AnswerChoice5 FROM questionbank WHERE QuestionType='" +subject+ "' order by rand();";
			pst=gc.getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			rs.first();
			int i = 0;	
			do {	

				questionlist[i][0] = rs.getString("Question");
				questionlist[i][1] = rs.getString("AnswerChoice1");
				questionlist[i][2] = rs.getString("AnswerChoice2");
				questionlist[i][3] = rs.getString("AnswerChoice3");
				questionlist[i][4] = rs.getString("AnswerChoice4");
				questionlist[i][5] = rs.getString("AnswerChoice5");
				++i;	
			
			} while (rs.next());
		}
		
		catch (Exception e){
		 System.err.print("SQLException: ");
	        System.err.println("gg" + e.getMessage());
	        System.out.println(e.getStackTrace()+"");
	        return questionlist;
	    }
	
		return questionlist;
	}

public static void ExportResults (String q) {
	Statement stmt;
	try {
	stmt = gc.getConnection().createStatement();
	String questions  = "insert into userperformance (ExamType,QuestionID,CorrectAnswer) select QuestionType, QuestionID, CorrectAnswer from questionbank where Question=" +"'"+q.trim()+"';";
	stmt.addBatch(questions);
	stmt.executeBatch();
		
	} 
	catch (SQLException e) {
		
		System.out.print("h\n");
			e.printStackTrace();
		} 
	catch (Exception e) {
			 	System.out.print("i\n");
		
			e.printStackTrace();
		}
		
	}

public static void TimeStarted () {
	try {
		sql = "update userstats set TimeStarted = current_timestamp where TimeStarted is null;";
		pst.executeUpdate(sql);
		} 
		catch (Exception e) {
			System.out.print("k\n");
			
				e.printStackTrace();
			}
			
		}
public static void TimeStopped() {
	Statement statement;
	try {
		statement = gc.getConnection().createStatement();
		String timeStopped = "update userstats set TimeStopped = current_timestamp where TimeStopped is null and Counter = (select max(Counter) from (select Counter from userstats) as a);";
		String timeTaken =	"update userstats set TimeTaken = TimeStopped - TimeStarted where TimeTaken is null and Counter = (select max(Counter) from (select Counter from userstats) as a);";
		statement.addBatch(timeStopped);
		statement.executeBatch();
		statement.addBatch(timeTaken);
		statement.executeBatch();
	}
	catch (SQLException e) {
		System.out.println("pp" + e);
		e.printStackTrace();
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
}

public static void UserID (String username, String password) {
	Statement stmt;
	try {
		stmt = gc.getConnection().createStatement();
			String userstats =  "insert into userstats (UserID) select UserID from userauthentication where username =" +"'"+username+"'"+"and password="+"'"+password+"';";
			stmt.addBatch(userstats);
			stmt.executeBatch();
	} catch (Exception e) {
		System.out.print("n\n");
		
		e.printStackTrace();
	}
}

public static void UpdateUserInfo() {
	Statement stmt;
	try {
		stmt = gc.getConnection().createStatement();
		String update = "update userperformance set UserID=(select UserID from userstats where Counter=(select max(Counter) from userstats)) where UserID is null;";
		stmt.addBatch(update);
			stmt.executeBatch();
	} catch (Exception e) {
		System.out.print("n\n");
		
		e.printStackTrace();
	}
}

public static void ExamType(String subject) {
		
	try {
		sql = "update userstats set ExamType ='" + subject +"'where Counter = (select max(Counter) from (select Counter from userstats )as c);";
		pst.executeUpdate(sql);
	}
	catch (SQLException e) {
		System.out.print("l\n");	
	
			e.printStackTrace();
		} 
	}
public static void WindowClosed () {
	Statement stmt;
			try {
			stmt = gc.getConnection().createStatement();
			String attempt = "update userstats set AttemptNumber = (select count(UserID) from (select UserID from userstats as d where ExamType = (select ExamType from userstats as f where Counter = (select max(Counter) from (select Counter from userstats) as e))) as a where UserID = (select UserID from (select * from userstats) as b where Counter = (select max(Counter) from (select * from userstats )as c))) where AttemptNumber is null;";
			stmt.addBatch(attempt);
			stmt.executeBatch();
			} catch (Exception e) {
			e.printStackTrace();
		}	
		
			
	}

public static void storeResults (String [] usableanswers) {
	Statement stmt;
 for (String t: usableanswers) {
		
		try {

		stmt = gc.getConnection().createStatement();
		String update = "update userperformance set GivenAnswer= '" + t.trim().charAt(0)+"' where Counter =(select min(Counter) from (select Counter from userperformance where GivenAnswer is null) as a);";
				stmt.addBatch(update);
				stmt.executeBatch();
			}
 
		catch (Exception e) {
			System.out.print("n\n");
			e.printStackTrace();
		}	
 }
		}
 

public static String[] RemoveNull(String[] t) {
	
	List<String> list = new ArrayList<String>(Arrays.asList(t));
	System.out.println("point c: " + list);
	list.removeAll(Arrays.asList("", null));
	String [] newArray = new String [list.size()];
	System.out.println("point d: " + list);
	newArray = list.toArray(newArray);
		
		return newArray;
		
}

public static void Score (String [] t) {
Statement stmt;
	try { 
		
		sql= "select CorrectAnswer from (select * from userperformance order by Counter desc limit " + t.length +")sub order by Counter asc;";
		stmt=gc.getConnection().prepareStatement(sql);
		rs = stmt.executeQuery(sql);
		rs.first();
		int i = 0;	
		do {	
			correctAnswers[i] = rs.getString("CorrectAnswer");
			System.out.println(correctAnswers[i]);
			++i;
			
		}while (rs.next());
	}
	
		catch (Exception e){
			 System.err.print("SQLException: ");
		        System.err.println("ee\n" + e.getMessage());
		
		    }

	int a = 0;
	
	String [] newAnswers=Test.RemoveNull(correctAnswers);
	
	for (int d = 0; d < newAnswers.length; d++) {
		if (newAnswers[d].trim().charAt(0)==(t[d].trim().charAt(0))) {
			a++;
		}
	}
	Statement statement;
	try {
	statement = gc.getConnection().createStatement();
	String attempt = "update userstats set Score ='"+a+"/"+newAnswers.length+"'where Score is null;";
	statement.addBatch(attempt);
	statement.executeBatch();
	} 
	catch (Exception e) {

	e.printStackTrace();
	}
}	

public static String[] resultspage () {
	
			try {
				sql= "select Score, TimeTaken FROM userstats where Counter = (select max(Counter) from userstats as a);";
				pst=gc.getConnection().prepareStatement(sql);
				rs = pst.executeQuery();
				
				rs.first();
				do {
					stats[0] = "Score:\t" + rs.getString("Score");
					stats[1] = "Time Taken:\t" + rs.getString("TimeTaken");
					
				} while(rs.next());
			}
								
				
	catch (SQLException e) {
		System.out.println("omg");
		e.printStackTrace();
		
	} catch (Exception e) {

		e.printStackTrace();
	}
			
			return stats;

}
	
public static boolean adminLogin(String username, String password) {
	try {
		
	sql = "select Username,Password from userauthentication where binary Username=? and binary Password=? and SuperUser = 'Y';";
	pst=gc.getConnection().prepareStatement(sql);
	
	pst.setString(1, username);
	pst.setString(2, password);
	
	rs = pst.executeQuery();
	
	if (rs.next()) {
		return true;
	}
	
	else {
		return false;
	}
} 
	
catch (Exception e) {
	System.out.println("Error while authenticating " + e);
	e.printStackTrace(System.err);
	return false;
	
}
	
}

public static String [][] adminSearch () {

	try {
		
		String user = "select Name, UserID from userauthentication where SuperUser = 'N';";
		pst=gc.getConnection().prepareStatement(user);
		rs = pst.executeQuery();
		rs.first();
		int e= 0;
		do {
			userdata [e][0] = rs.getString("Name");
			userdata [e][1] = rs.getString("UserID");
			++e;
		} while (rs.next());
		
		
		String tests =	"select distinct QuestionType from questionbank;";
		pst=gc.getConnection().prepareStatement(tests);
		rs= pst.executeQuery();
		int f =0;
		rs.first();
		
		do {
			userdata [f][2] = rs.getString("QuestionType");
			++f;
		} while (rs.next());
	}
	
catch (SQLException e) {
		System.out.println("z" + e);
		e.printStackTrace();
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
	
	return userdata;
	
}

public static ResultSet nametable(Object selectedItem) {
	try { 
		sql= "select b.Name, a.ExamType, a.AttemptNumber, a.Score, a.TimeTaken from userstats as a inner join userauthentication as b on a.UserID=b.UserID where b.Name = '"+ selectedItem.toString().trim() +"';";
		pst=gc.getConnection().prepareStatement(sql);
		rs = pst.executeQuery();	
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return rs;
	}
	

public static ResultSet useridtable(Object selectedItem) {
	try { 
		sql= "select b.UserID, a. ExamType, a. AttemptNumber, a. Score, a. TimeTaken from userstats as a inner join userauthentication as b on a.UserID = b.UserID where b.UserID = '"+ selectedItem.toString().trim() +"';";
		pst=gc.getConnection().prepareStatement(sql);
		rs = pst.executeQuery();	
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return rs;
	}

	


public static ResultSet examtypetable(Object selectedItem) {
	try { 
		sql= "select  a.ExamType, b.Name, a.UserID, a.AttemptNumber, a.Score, a.TimeTaken from userstats as a inner join userauthentication as b on a.UserID = b.UserID where a.ExamType = '"+ selectedItem.toString().trim() +"';";
		pst=gc.getConnection().prepareStatement(sql);
		rs = pst.executeQuery();	
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return rs;
	}
public static DefaultTableModel FillTable(ResultSet rs) throws SQLException{

	ResultSetMetaData metaData = rs.getMetaData();
	int count = metaData.getColumnCount(); 
	columnNames = new String[count];

for (int i = 1; i <= count; i++)
{
   columnNames[i-1] = metaData.getColumnLabel(i);
  }


	
	String a = null;
	String b = null;
	String c = null;
	String d = null;
	String e = null;
	
	
		
		
		DefaultTableModel model = new DefaultTableModel(columnNames, columnNames.length);

		int rows = model.getRowCount();
		for(int i = rows - 1; i >=0; i--){
		   model.removeRow(i); 
		}
		
		Test.RemoveNull(columnNames);
		
		
		while (rs.next()){
			
			a = rs.getString(columnNames[0]);
			b = rs.getString(columnNames[1]);
			c = rs.getString(columnNames[2]);
			d = rs.getString(columnNames[3]);
			e = rs.getString(columnNames[4]);
	
			
			if (a!=null && b!=null &&c!=null&&d!=null&&e!=null){
			model.addRow(new Object [] {a,b,c,d,e,});
		}
		}
		
			return model;

    
	
}
public static DefaultTableModel FillExamTypeTable(ResultSet rs) throws SQLException{

	ResultSetMetaData metaData = rs.getMetaData();
	int count = metaData.getColumnCount(); 
	columnNames = new String[count];

for (int i = 1; i <= count; i++)
{
   columnNames[i-1] = metaData.getColumnLabel(i);
  }


	
	String a = null;
	String b = null;
	String c = null;
	String d = null;
	String e = null;
	String f = null;
	
		
		
		DefaultTableModel model = new DefaultTableModel(columnNames, columnNames.length);

		int rows = model.getRowCount();
		for(int i = rows - 1; i >=0; i--){
		   model.removeRow(i); 
		}
		
		Test.RemoveNull(columnNames);
		
		while (rs.next()){
			
			a = rs.getString(columnNames[0]);
			b = rs.getString(columnNames[1]);
			c = rs.getString(columnNames[2]);
			d = rs.getString(columnNames[3]);
			e = rs.getString(columnNames[4]);
			f = rs.getString(columnNames[5]);
			
			if (a!=null && b!=null &&c!=null&&d!=null&&e!=null&&f!=null){
			model.addRow(new Object [] {a,b,c,d,e,f});
			
			}
		}
		
			return model;

    
	
}
}


			



	






