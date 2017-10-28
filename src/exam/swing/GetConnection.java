package exam.swing;
import java.sql.*;

public class GetConnection {

	public Connection getConnection() throws Exception {
		

	Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "onlineexam";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url+dbName, "root","pp04111998");
		}
	catch (Exception e) {
		e.printStackTrace();
	}
		return con;
		}
	public static void main(String[] args) {
		GetConnection con = new GetConnection();
		System.out.println("Connection"+" " + con);
	}

}
