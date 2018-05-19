package connection;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class Connect8 {
	
	public static void main(String[] args) {
		

	    String DATASOURCE_CONTEXT = "java:comp/env/jdbc/TestDB";
	    
	    Connection con = null;
	    try {
	      Context initialContext = new InitialContext();
	      
	      DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
	      
	      if (datasource != null) {
	        con = datasource.getConnection();
	      }
	      
	      Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery("select * from test");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" ---  "+rs.getString(2));
			}
			
			con.close();
	     
	    }
	   catch(Exception e){e.printStackTrace();}
	
	}

}
