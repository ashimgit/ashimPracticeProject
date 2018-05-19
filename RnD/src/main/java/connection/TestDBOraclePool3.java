package connection;


import java.net.URL;
import java.sql.*;

public class TestDBOraclePool3 {

    public static void main(String[] args) throws SQLException {
        //new Thread( new TestDBOraclePool3Thread(1)).start();
        /*new Thread( new TestDBOraclePool3Thread(2)).start();
        new Thread( new TestDBOraclePool3Thread(3)).start();
        new Thread( new TestDBOraclePool3Thread(4)).start();
        new Thread( new TestDBOraclePool3Thread(5)).start();
        new Thread( new TestDBOraclePool3Thread(6)).start();
        new Thread( new TestDBOraclePool3Thread(7)).start();*/
    	new TestDBOraclePool3Thread(1).run();
    }
}