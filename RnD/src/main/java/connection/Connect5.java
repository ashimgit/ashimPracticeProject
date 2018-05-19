package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Connect5 {
	
	
public static void main(String[] args) {
		
		try {
			
			Properties info = new Properties( );   // Using Properties Object to wrap all the Database Credentials
			info.put("user", "subhajit");
			info.put("password", "lion");

			String connect_url = "  ";  // Connection URL with user/schema and password
			String driver = "oracle.jdbc.driver.OracleDriver";           // Driver CLass 
			
			Class c = Class.forName(driver);	   
			Connection con = DriverManager.getConnection(connect_url,info); //Giving Connection URL
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
