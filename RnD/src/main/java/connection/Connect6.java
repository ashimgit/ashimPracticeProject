package connection;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleConnectionCacheManager;
import oracle.jdbc.pool.OracleDataSource;

public class Connect6 {
	
	 private final  static String CACHE_NAME = "MYCACHE";
	 private  static OracleDataSource ods = null;
	 private static int count = 0;

	 public static void main(String[] args) {
		

         System.out.println("OracleDataSource Initialization");
         while(true) {
         try {
             ods = new OracleDataSource();
             //ods.setURL("jdbc:oracle:thin:@localhost:1521/XE");
             ods.setDriverType("thin");
             ods.setNetworkProtocol("tcp");
             ods.setDatabaseName("XE");
             ods.setServerName("localhost");
             ods.setPortNumber(1521);
             ods.setUser("subhajit");
             ods.setPassword("lion"); 
             ods.setConnectionCacheName(CACHE_NAME);

             
           
             
             
             Properties cacheProps = new Properties();
             cacheProps.setProperty("MinLimit", "1");
             cacheProps.setProperty("MaxLimit", "2");
             cacheProps.setProperty("InitialLimit", "1");
             cacheProps.setProperty("ConnectionWaitTimeout", "5");
             cacheProps.setProperty("ValidateConnection", "true");

             ods.setConnectionCacheProperties(cacheProps);
             
             
             OracleConnection ocon = (OracleConnection)ods.getConnection();
             Statement stmt = ocon.createStatement();
             ResultSet rs = stmt.executeQuery("select * from test");
 			
 			while(rs.next()) {
 				System.out.println(rs.getString(1)+" ---  "+rs.getString(2));
 			}
 			count++;
 			System.out.println("COUNT ::::::::::::::::::::::::::  "+count);
 			ocon.close();
 			
 			ods.close();
 			
 			

         }
         catch (Exception e) {
             e.printStackTrace();
         }
         }
     }

}
