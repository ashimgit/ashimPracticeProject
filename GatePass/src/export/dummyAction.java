package export;
import java.sql.*;

public class dummyAction {
	
public String execute() throws Exception
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	Statement stmt=con.createStatement();
	int t=stmt.executeUpdate("insert into t1 values(9,'suman')",Statement.RETURN_GENERATED_KEYS);
	if(t>0)
	{
		System.out.println("inserted");
	}
	ResultSet rs=stmt.getGeneratedKeys();
	if(rs.next())
	{
		System.out.println("key :: "+rs.getString(1));
	}
	
	
	return "success";
}
}
