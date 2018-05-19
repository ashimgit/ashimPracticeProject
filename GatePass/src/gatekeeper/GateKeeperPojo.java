package gatekeeper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import tower.TowerAction;
import clustermanager.ClusterManagerAction;

import connection.connection;

public class GateKeeperPojo implements GateKeeperInterface{

	public int addGateKeeper(String mobile_no,String gatekeeper_name,String gatekeeper_type,int serviceprovider_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into gatekeeper_master(gatekeeper_mobile,gatekeeper_name,gatekeeper_type,serviceprovider_id) values(?,?,?,?) ";
			System.out.println(q);
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, mobile_no);
			pst.setString(2, gatekeeper_name);
			pst.setString(3, gatekeeper_type);
			pst.setInt(4, serviceprovider_id);
			t = pst.executeUpdate();
			if(t > 0)
				t = 1;
			else
				t = 0;
			con11.commit();
			
		}
		catch(SQLException ex)
		{
			message = ex.getMessage();
			System.out.println("Message ::"+message);
			message1 = message.substring(0, 9);
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
	public int updateTower(String mobile_no,String indus_tower_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		Statement stmt=null;
		try 
		{
			String q = "update tower_master set gatekeeper_mobile = '"+mobile_no+"' where indus_tower_id IN('"+indus_tower_id+"')";
			stmt=con11.createStatement();
    		t=stmt.executeUpdate(q);
    		System.out.println(q);
			if(t>0)
				t=1;
			else
				t=0;
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
	
	public LinkedList generateGateKeeperList(String gatekeeper_mobile,String flag)
	{
		//System.out.println("in generateGateKeeperList :: "+gatekeeper_mobile+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		String q="",q1="";
		try 
		{
			if(flag!=null)
				q="select gm.gatekeeper_id,gm.gatekeeper_name,gm.gatekeeper_mobile,gm.serviceprovider_id,sm.serviceprovider_name,gm.gatekeeper_type from gatekeeper_master gm,serviceprovider_master sm where gm.active='Y' and gm.serviceprovider_id=sm.serviceprovider_id and gm.gatekeeper_mobile='"+gatekeeper_mobile+"'";
			else
				q="select gm.gatekeeper_id,gm.gatekeeper_name,gm.gatekeeper_mobile,gm.serviceprovider_id,sm.serviceprovider_name,gm.gatekeeper_type from gatekeeper_master gm,serviceprovider_master sm where gm.active='Y' and gm.serviceprovider_id=sm.serviceprovider_id order by gm.gatekeeper_name";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			System.out.println("see :: "+q);
			
			while(rs.next())
			{
				GateKeeperAction obj=new GateKeeperAction();
    			obj.setGatekeeper_id(rs.getInt(1));
    			obj.setMobile_no(rs.getString(3));
    			obj.setGatekeeper_name(rs.getString(2));
    			obj.setServiceprovider_id(rs.getInt(4));
    			obj.setServiceprovider_name(rs.getString(5));
    			obj.setGatekeeper_type(rs.getString(6));
    			ll.add(obj);
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
			return ll;
		}
		
	}
	
	
	public LinkedList megeHuntGateKeeper(int gatekeeper_id,String mobile_no,String gatekeeper_name,String gatekeeper_type,int serviceprovider_id)
	{
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		String q="";
		try 
		{
			q="select gm.gatekeeper_id,gm.gatekeeper_name,gm.gatekeeper_mobile,gm.serviceprovider_id,sm.serviceprovider_name,gm.gatekeeper_type from gatekeeper_master gm,serviceprovider_master sm where gm.active='Y' and gm.serviceprovider_id=sm.serviceprovider_id and gm.gatekeeper_name like case '"+gatekeeper_name+"' when '' then gm.gatekeeper_name else '%"+gatekeeper_name+"%' end and gm.gatekeeper_mobile like case '"+mobile_no+"' when '' then gm.gatekeeper_mobile else '"+mobile_no+"%' end and gm.gatekeeper_type like case '"+gatekeeper_type+"' when '-1' then gm.gatekeeper_type else '%"+gatekeeper_type+"%' end and gm.serviceprovider_id=case '"+serviceprovider_id+"' when '-1' then gm.serviceprovider_id else '"+serviceprovider_id+"' end order by gm.gatekeeper_name";
			System.out.println("see :: "+q);
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				GateKeeperAction obj=new GateKeeperAction();
    			obj.setGatekeeper_id(rs.getInt(1));
    			obj.setMobile_no(rs.getString(3));
    			obj.setGatekeeper_name(rs.getString(2));
    			obj.setServiceprovider_id(rs.getInt(4));
    			obj.setServiceprovider_name(rs.getString(5));
    			obj.setGatekeeper_type(rs.getString(6));
    			ll.add(obj);
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
	
	public int gateKeeperDeletion(int gatekeeper_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update gatekeeper_master set active='N' where gatekeeper_id="+gatekeeper_id;
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
	
	public int gateKeeperModification(int gatekeeper_id,String mobile_no,String gatekeeper_name,String gatekeeper_type,int serviceprovider_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		Statement stmt=null;
		try 
		{
			String q = "update gatekeeper_master set gatekeeper_mobile = '"+mobile_no+"',gatekeeper_name='"+gatekeeper_name+"', gatekeeper_type='"+gatekeeper_type+"',serviceprovider_id='"+serviceprovider_id+"' where gatekeeper_id="+gatekeeper_id;
			System.out.println("1st :: "+q);
			stmt=con11.createStatement();
    		t=stmt.executeUpdate(q);
    		con11.commit();
    		con11.close();
			
			if(t>0)
			{
				t=1;
			}
			else
				t=0;
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
			return t;
		}
	}
}
