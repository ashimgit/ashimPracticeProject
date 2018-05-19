package pop;

import java.util.LinkedList;
import java.sql.*;

import connection.*;

public class TowerInfoPojo implements TowerInfoInterface{
	
	public LinkedList towerInfo(String tower_id)
	{
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=null;
		try 
		{
			String q = "select indus_tower_id,tower_site,tower_address,tower_type,district_name,state_name from tower_master tm,district_master dm,state_master stm where tm.district_id=dm.district_id and dm.state_id=stm.state_id and tm.indus_tower_id='"+tower_id+"'";
			System.out.println("row :: "+q);
			PreparedStatement pst = con11.prepareStatement(q);
			//pst.setString(1, tower_id);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				ll=new LinkedList();
				
				ll.add(new TowerInfoBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
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
