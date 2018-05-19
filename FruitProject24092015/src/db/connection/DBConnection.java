package db.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	
	public static Connection getConnection(){
		Connection con=null;
		
		String username="root";
		String password="admin";
		String dbName="fruitshopdb";
		//String url = "jdbc:mysql://192.168.2.79:3306/"+dbName;
		String url = "jdbc:mysql://localhost:3306/"+dbName;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
		con.setAutoCommit(false);
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
//	public static void main(String args[]){
//		
//		System.out.println("conn:"+DBConnection.getConnection());
//	}
}
