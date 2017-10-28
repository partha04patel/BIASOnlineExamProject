package exam.swing;

import java.sql.*;


public class TestFile {
	
	
	static GetConnection gc = new GetConnection();
	static ResultSet rs;
	static PreparedStatement pst;
	static String sql = null;
	public static void main(String[] args) {
		sql= "select Question, AnswerChoice1, AnswerChoice2, AnswerChoice3, AnswerChoice4, AnswerChoice5 FROM questionbank WHERE QuestionType='Math' order by rand() limit 10;";
		try {
			pst=gc.getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			String questions = rs.getString("Question") + "\n"+ rs.getString("AnswerChoice1") + " " + rs.getString("AnswerChoice2") + " " + rs.getString("AnswerChoice3") + " " + rs.getString("AnswerChoice4") + " " + rs.getString("AnswerChoice5");
			System.out.println(rs);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

}
}
