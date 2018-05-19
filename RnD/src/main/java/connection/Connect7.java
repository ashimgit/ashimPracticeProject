package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.pool.OracleConnectionCacheManager;
import oracle.jdbc.pool.OracleDataSource;

class OracleConnect {
	private final static String CACHE_NAME = "MYCACHEFORORACLE";
	private static OracleDataSource ods = null;

	static {
		System.out.println("OracleDataSource Initialization.......");
		try {
			ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521/XE");
			ods.setUser("subhajit");
			ods.setPassword("lion");
			ods.setConnectionCachingEnabled(true);
			ods.setConnectionCacheName(CACHE_NAME);

			Properties cacheProps = new Properties();
			cacheProps.setProperty("MinLimit", "1");
			cacheProps.setProperty("MaxLimit", "4");
			cacheProps.setProperty("InitialLimit", "1");
			cacheProps.setProperty("ConnectionWaitTimeout", "5");
			cacheProps.setProperty("ValidateConnection", "true");

			ods.setConnectionCacheProperties(cacheProps);
		} catch (SQLException e) {
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

		if (ods != null) {
			ods.close();
		}

	}

}

public class Connect7 {

	public static void main(String[] args) {

		while (true) {
			try {
				Connection conn = new OracleConnect().getConnection();

				conn.setAutoCommit(false);
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery("select * from test");

				while (rset.next())
					System.out.println(rset.getString(1) + " ---- " + rset.getString(2));

				stmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}

	}

}
