package tower;

import gatekeeper.GateKeeperAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import connection.connection;

public class TowerPojo implements TowerInterface 
{
	@SuppressWarnings("finally")
	public int addTower(String site_name,String address,String tower_type,int district_id,String height,String latitude,String longitude,String indus_tower_code,String gatekeeper_mobile,String clustermanager_mobile)
	{
			int t = 0;
			connection con1 = new connection();
			Connection con11 = con1.Connect();
			try 
			{
				String q = "insert into tower_master(tower_site,tower_address,tower_type,district_id,tower_height,tower_latitude,tower_longitude,indus_tower_id,gatekeeper_mobile,clustermanager_mobile,serviceprovider_id,cm_id) values(?,?,?,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement pst = con11.prepareStatement(q);
				pst.setString(1, site_name);
				pst.setString(2, address);
				pst.setString(3, tower_type);
				pst.setInt(4, district_id);
				pst.setString(5, height);
				pst.setString(6, latitude);
				pst.setString(7, longitude);
				pst.setString(8, indus_tower_code);
				pst.setString(9, gatekeeper_mobile);
				pst.setString(10, clustermanager_mobile);
				pst.setString(11, "70");
				pst.setString(12, "1");

				t = pst.executeUpdate();
				con11.commit();
				
			} 
			catch(SQLException ex)
			{
				String message = ex.getMessage();
				System.out.println("Message ::"+message);
				String message1 = message.substring(0, 9);
				if(message1.equals("Duplicate"))
				{
					t = 1001;
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			
			finally 
			{
				try {
					con11.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return t;
			}
		}
	
	
	public LinkedList generateTowerList(String tower_id,String flag)
	{
		System.out.println("in generateTowerList :: "+tower_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		
		try 
		{
			String q="",q1="";
			
			if(flag!=null)
				q = "select tm.tower_id,tm.indus_tower_id,tm.tower_site,tm.tower_address,tm.tower_type,tm.tower_height,tm.tower_latitude,tm.tower_longitude,dm.district_name,stm.state_name,sm.serviceprovider_name,gm.gatekeeper_name,dm.state_id,tm.district_id,gm.gatekeeper_mobile,tm.clustermanager_mobile,tm.serviceprovider_id from tower_master tm,gatekeeper_master gm,serviceprovider_master sm,district_master dm,state_master stm where tm.gatekeeper_mobile=gm.gatekeeper_mobile and tm.serviceprovider_id=sm.serviceprovider_id and tm.district_id=dm.district_id and dm.state_id=stm.state_id and tm.active='Y' and tm.indus_tower_id="+tower_id+" order by tm.tower_id";

			else
				q = "select tm.tower_id,tm.indus_tower_id,tm.tower_site,tm.tower_address,tm.tower_type,tm.tower_height,tm.tower_latitude,tm.tower_longitude,dm.district_name,stm.state_name,sm.serviceprovider_name,gm.gatekeeper_name,dm.state_id,tm.district_id,gm.gatekeeper_mobile,tm.clustermanager_mobile,tm.serviceprovider_id from tower_master tm,gatekeeper_master gm,serviceprovider_master sm,district_master dm,state_master stm where tm.gatekeeper_mobile=gm.gatekeeper_mobile and tm.serviceprovider_id=sm.serviceprovider_id and tm.district_id=dm.district_id and dm.state_id=stm.state_id and tm.active='Y' order by tm.tower_id";
			System.out.println("tower : " +q);
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next())
			{
				TowerAction obj=new TowerAction();
    			obj.setTower_id(rs.getInt(1));
    			obj.setIndus_tower_code(rs.getString(2));
    			obj.setSite_name(rs.getString(3));
    			obj.setAddress(rs.getString(4));
    			obj.setTower_type(rs.getString(5));
    			obj.setHeight(rs.getString(6));
    			obj.setLatitude(rs.getString(7));
    			obj.setLongitude(rs.getString(8));
    			obj.setDistrict_name(rs.getString(9));
    			obj.setState_name(rs.getString(10));
    			obj.setServiceprovider_name(rs.getString(11));
    			obj.setGatekeeper_name(rs.getString(12));
    			obj.setState_id(rs.getInt(13)); 
    			obj.setDistrict_id(rs.getInt(14)); 
    			obj.setGatekeeper_mobile(rs.getString(15)); 
    			obj.setClustermanager_mobile(rs.getString(16)); 
    			obj.setServiceprovider_id(rs.getInt(17)); 

    			ll.add(obj);
			}
			//System.out.println("count :: "+ll);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try {
				con11.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ll;
		}
		
	}
	
	public String towerModification(int tower_id,String indus_tower_code,String site_name,String address,String tower_type,String height,String latitude,String longitude,int district_id,String gatekeeper_mobile,String clustermanager_mobile,int serviceprovider_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update tower_master set tower_site='"+site_name+"',tower_address='"+address+"',tower_type='"+tower_type+"',district_id="+district_id+",tower_height='"+height+"',tower_latitude='"+latitude+"',tower_longitude='"+longitude+"',indus_tower_id='"+indus_tower_code+"',gatekeeper_mobile='"+gatekeeper_mobile+"',clustermanager_mobile='"+clustermanager_mobile+"',serviceprovider_id="+serviceprovider_id+" where tower_id="+tower_id;
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			con11.commit();
			con11.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if(t>0)
				return "success";
			else
				return "failure";
		}
	}
	
	
	public int towerModification(String indus_tower_code,String site_name,String address,String tower_type,String height,String latitude,String longitude,int district_id,String gatekeeper_mobile,String clustermanager_mobile)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update tower_master set tower_site='"+site_name+"',tower_address='"+address+"',tower_type='"+tower_type+"',district_id="+district_id+",tower_height='"+height+"',tower_latitude='"+latitude+"',tower_longitude='"+longitude+"',gatekeeper_mobile='"+gatekeeper_mobile+"',clustermanager_mobile='"+clustermanager_mobile+"',serviceprovider_id=70 where indus_tower_id='"+indus_tower_code+"' ";
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			if(t > 0)
				t = 1;
			else
				t = 0;
			con11.commit();
			
		} 
		catch(SQLException ex)
		{
			String message = ex.getMessage();
			System.out.println("Message ::"+message);
			String message1 = message.substring(0, 6);
			//System.out.println("Message1 ::"+message1);
			if(message1.equals("Cannot"))
			{
				t = 1001;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		finally 
		{
			try {
				con11.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return t;
		}
	}
	
	public int towerModification(int tower_id,String indus_tower_code,String site_name,String address,String tower_type,String height,String latitude,String longitude,int district_id,String gatekeeper_mobile,String clustermanager_mobile)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update tower_master set tower_site='"+site_name+"',tower_address='"+address+"',tower_type='"+tower_type+"',district_id="+district_id+",tower_height='"+height+"',tower_latitude='"+latitude+"',tower_longitude='"+longitude+"',indus_tower_id='"+indus_tower_code+"',gatekeeper_mobile='"+gatekeeper_mobile+"',clustermanager_mobile='"+clustermanager_mobile+"',serviceprovider_id=70 where tower_id="+tower_id;
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			if(t > 0)
				t = 1;
			else
				t = 0;
			con11.commit();
			con11.close();
		} 
		catch(SQLException ex)
		{
			String message = ex.getMessage();
			System.out.println("Message ::"+message);
			String message1 = message.substring(0, 6);
			//System.out.println("Message1 ::"+message1);
			if(message1.equals("Cannot"))
			{
				t = 1001;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		finally 
		{
			return t;
		}
	}

	public int towerDeletion(int tower_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update tower_master set active='N' where tower_id="+tower_id;
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			if(t > 0)
				t = 1;
			else
				t = 0;
			con11.commit();
			con11.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return t;
		}
	}
	
	public String unassignTower(int tower_id,String flag)
	{
		System.out.println("in unassignTowerPojo :: "+tower_id);

		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q="";
			if(flag.equals("c"))
				q = "update tower_master set clustermanager_mobile=null where tower_id="+tower_id;
			else
				q = "update tower_master set gatekeeper_mobile=null where tower_id="+tower_id;
			System.out.println(q);
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			con11.commit();
			con11.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if(t>0)
				return "Unassigned Successfully.....";
			else
				return "failure";
		}
	}
	public LinkedList checkTowerList(String indus_tower_id,String flag)
	{
		//System.out.println("in generateTowerList :: "+tower_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		
		try 
		{
			String q = "select tower_id from tower_master where active='Y' and indus_tower_id="+indus_tower_id+" ";
			System.out.println("tower : " +q);
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next())
			{
				TowerAction obj=new TowerAction();
    			obj.setTower_id(rs.getInt(1));
    			ll.add(obj);
			}
			//System.out.println("count :: "+ll);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try {
				con11.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ll;
		}
		
	}

	

}
