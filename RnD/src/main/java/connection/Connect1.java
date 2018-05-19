package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect1 {
	

	public static void main(String[] args) {
	
	try {
		System.out.println("OKk");

		String connect_url = "jdbc:oracle:thin:@10.0.2.99:5500/ORCL";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class c = Class.forName(driver);
		Connection con = DriverManager.getConnection(connect_url,"subhajit","admin"); 
		System.out.println("Con obj for Oracle = "+con);
		con.setAutoCommit(false);
		
		
		//Statement stmt = con.createStatement();
		//ResultSet rs = stmt.executeQuery("select * from test");
		
		/*while(rs.next()) {
			System.out.println(rs.getString(1)+" ---  "+rs.getString(2));
		}*/
		
	} catch (Exception ex) {
		
		ex.printStackTrace();
		
	}
	
}

}
