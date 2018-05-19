package connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class connection
{

	private Connection con = null;
	public Connection Connect() 
    {    
		String url2 = "jdbc:mysql://localhost:3306/indusgatepass";
		//String url1 = "jdbc:mysql:https://111.118.212.97:3306/indusgatepass";
        try
        {
        	String userName = "indus";
			String password = "x8i4fFsQm";
            Class.forName("com.mysql.jdbc.Driver");
            try
            {
            	//System.out.println("try");
            	//con = DriverManager.getConnection(url2, userName, password);
            	con = DriverManager.getConnection(url2, "root", "root" );
            	con.setAutoCommit(false);
            }
            catch(Exception ex)
            {
            	//System.out.println("catch");
            	con = DriverManager.getConnection(url2, "root", "");
            	con.setAutoCommit(false);
            }
        }
        catch (Exception e) 
        {
            //System.out.println("exide.Utils: Connection:-->"+e);
        	e.printStackTrace();
        }
        finally
        {
        	
        }
        return con;
    }
   
    public void connectClose() throws Exception 
    {
		
			if (!con.isClosed()) 
			{
				con.close();
			}
	}


}