package ar.com.codo24101.AdminConn;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdminConn {
	public static Connection connection() {
		String url = "jdbc:mysql://localhost:3306/24101_movies?serverTimeZone=UTC&userSSL=false";
		String user = "root";
		String password = "admin";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			System.err.println(e);
		}
		
		return con;
	}
	public static void disconnect(Connection con) {
		try {
			con.close();
		}catch(Exception e){
			System.err.println(e);
		}
	}
	
}
