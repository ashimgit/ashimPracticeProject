package connection;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect4 {
	
public static void main(String[] args) {
		
		try {
			

			String connect_url = "jdbc:oracle:thin:subhajit/lion@localhost:1521/XE";  // Connection URL with user/schema and password
			String driver = "oracle.jdbc.driver.OracleDriver";           // Driver CLass 
			
			Class c = Class.forName(driver);	   
			Connection con = DriverManager.getConnection(connect_url); //Giving Connection URL
			System.out.println("Con obj for Oracle = "+con);
			con.setAutoCommit(false);
			
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from test");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" ---  "+rs.getString(2));
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	}


}
