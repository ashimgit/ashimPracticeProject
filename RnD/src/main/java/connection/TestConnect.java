package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;


class OracleConnect1 {
	
    private final  static String CACHE_NAME = "MYCACHEFORORACLE";
    private  static OracleDataSource ods = null;
    
    
    static {
    	
    	try {
    		
         System.out.println("OracleDataSource Initialization in Static Block .......");
    		
         ods = new OracleDataSource();
    	 ods.setConnectionCachingEnabled(true);
         ods.setConnectionCacheName(CACHE_NAME);
         ods.setDriverType("thin");
         ods.setNetworkProtocol("tcp");
         
         Properties cacheProps = new Properties();
         cacheProps.setProperty("MinLimit", "1");
         cacheProps.setProperty("MaxLimit", "4");
         cacheProps.setProperty("InitialLimit", "1");
         cacheProps.setProperty("ConnectionWaitTimeout", "5");
         cacheProps.setProperty("ValidateConnection", "true");

         ods.setConnectionCacheProperties(cacheProps);
         
    	}
    	catch(Exception e) { e.printStackTrace();}
    	
    }

    
    OracleConnect1(){}

    OracleConnect1(String serverName,Integer portNumber,String databaseName,String userName,String password){
    	
    	 System.out.println("OracleDataSource Initialization.......");
         try {
             
        	 ods.setServerName(serverName);
        	 ods.setPortNumber(portNumber);
        	 ods.setDatabaseName(databaseName);
        	 ods.setUser(userName);
        	 ods.setPassword(password);
         }
         catch (Exception e) {
             e.printStackTrace();
         }
    	
    }
    
    public Connection getConnection() throws SQLException {
    	
      if (ods == null) {
          throw new SQLException("OracleDataSource is null.");
      }
      
      return ods.getConnection();
      
    }

    public static void closePooledConnections() throws SQLException {
    	
      if (ods != null ) {
          ods.close();
      }
      
    }
    
}

public class TestConnect {
	
	public static void main(String[] args) {
		
		while(true){
		try{
		 Connection conn = new OracleConnect1("localhost",1521,"XE","subhajit","lion").getConnection();
		 System.out.println("Connection :: "+conn);

         conn.setAutoCommit(false);
         Statement stmt = conn.createStatement();
         ResultSet rset = stmt.executeQuery("select * from test");
         
         while (rset.next())
            System.out.println (rset.getString(1)+" ---- "+rset.getString(2));
         
         stmt.close();
         conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		}
         
	}

}
