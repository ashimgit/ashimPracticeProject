package pop1;

import java.util.LinkedList;
import java.sql.*;

import connection.*;

public class TowerInfoPojo implements TowerInfoInterface{
	
	public LinkedList towerInfo(int serviceprovider_id)
	{
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=null;
		try 
		{
			String q = "select serviceprovider_id,serviceprovider_name from serviceprovider_master where serviceprovider_id = "+serviceprovider_id+"";
			System.out.println("row :: "+q);
			PreparedStatement pst = con11.prepareStatement(q);
			//pst.setString(1, tower_id);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				ll=new LinkedList();
				
				ll.add(new TowerInfoBean(rs.getInt(1),rs.getString(2)));
			}
			con11.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return ll;
		}
		
	}

}
