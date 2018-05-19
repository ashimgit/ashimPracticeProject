package connection;

import java.sql.*;

public class TestDBOraclePool3Thread {

    private int noThread = 0;
    private static int count = 0;

    TestDBOraclePool3Thread(int n) {
        noThread = n;
    }

    public void run() {
        System.out.println("Starting Thread " + noThread);
        while (true) {
            try {
                Connection conn = JDBCUtils.getConnection("env " + noThread);
               


                conn.setAutoCommit(false);
                Statement stmt = conn.createStatement();
                ResultSet rset =
                   stmt.executeQuery("select * from test");
                while (rset.next())
                   System.out.println (rset.getString(1)+" ---- "+rset.getString(2));
                stmt.close();
                System.out.println ("Ok.");
                count++;
                System.out.println("COUNT ::::::::::::::::::::::: "+count);
                conn.close();
                JDBCUtils.listCacheInfos();

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println ("Sleep... " + noThread);
                try {
                    //Thread.sleep(1000);
                }
                catch(Exception e) { }
            }
        }
    }

}