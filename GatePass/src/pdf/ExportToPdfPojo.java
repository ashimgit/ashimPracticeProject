package pdf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import connection.connection;

public class ExportToPdfPojo implements ExportToPdfInterface{
	
	public ArrayList exportToPdf(String flag)
	{
		
		int t = 0;
		String q="";
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		ArrayList ar=new ArrayList();
		try 
		{
			if(flag.equals("1")){
			q = "select * from category_master where active='Y'";
			}
			else if(flag.equals("2")){
				q = "select * from state_master where active='Y'";
			}
			
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				ar.add(rs.getString(1));
				ar.add(rs.getString(2));
			}
			con11.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return ar;
		}
		
	}

}
