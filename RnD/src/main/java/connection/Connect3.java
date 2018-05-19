package connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect3 {
	
public static void main(String[] args) {
		
		try {
			

			String connect_url = "jdbc:oracle:thin:@localhost:1521/XE";  // Connection URL
			String driver = "oracle.jdbc.driver.OracleDriver";           // Driver CLass 
			
			Driver myDriver = new oracle.jdbc.driver.OracleDriver();     // For non-JDK compliant JVM, such as the one provided by Microsoft.	
			DriverManager.registerDriver( myDriver );
			   
			   
			Connection con = DriverManager.getConnection(connect_url,"subhajit","lion"); //Giving Connection URL, user/schema name and password
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
