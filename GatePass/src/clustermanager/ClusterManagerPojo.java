package clustermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import sme.SMEAction;
import tower.*;

import connection.connection;

public class ClusterManagerPojo implements ClusterManagerInterface{
	
	public int addClusterManager(String mobile_no,String clustermanager_name)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into clustermanager_master(clustermanager_mobile,clustermanager_name) values(?,?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, mobile_no);
			pst.setString(2, clustermanager_name);
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
			String q = "update tower_master set clustermanager_mobile = '"+mobile_no+"' where indus_tower_id IN('"+indus_tower_id+"')";
			stmt=con11.createStatement();
    		t=stmt.executeUpdate(q);
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
	
	public LinkedList generateClusterManagerList(String clustermanager_mobile,String flag)
	{
		System.out.println("in generateCLusterManagerList :: "+clustermanager_mobile+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		
		try 
		{
			String q="",q1="";
			
			if(flag!=null)
				q="select cm.clustermanager_id,cm.clustermanager_name,cm.clustermanager_mobile from clustermanager_master cm where cm.active='Y' and cm.clustermanager_mobile='"+clustermanager_mobile+"'";
			else
				q="select cm.clustermanager_id,cm.clustermanager_name,cm.clustermanager_mobile from clustermanager_master cm where active='Y' order by cm.clustermanager_name";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				ClusterManagerAction obj=new ClusterManagerAction();
    			obj.setClustermanager_id(rs.getInt(1));
    			obj.setMobile_no(rs.getString(3));
    			obj.setClustermanager_name(rs.getString(2));
    			
    			/*q1="select tm.tower_id,tm.indus_tower_id from tower_master tm where tm.clustermanager_mobile='"+rs.getString(3)+"'";
    			System.out.println("q1 :: "+q1);
    			PreparedStatement pst1 = con11.prepareStatement(q1);
    			ResultSet rs1 = pst1.executeQuery();
    			LinkedList tower_list=new LinkedList();

    			
    			while(rs1.next())
    			{
    				TowerAction obj1=new TowerAction();
    				obj1.setTower_id(rs1.getInt(1));
    				obj1.setIndus_tower_code(rs1.getString(2));
        			tower_list.add(obj1);
        				
    				
    			}
    			obj.setTower_list(tower_list);*/
    			  			

    			
    			ll.add(obj);
			}
			System.out.println("count :: "+ll);
			
			
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
	
	public LinkedList search(String clustermanager_mobile,String clustermanager_name)
	{
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		
		try 
		{
			String q="select cm.clustermanager_id,cm.clustermanager_name,cm.clustermanager_mobile from clustermanager_master cm where active='Y' and cm.clustermanager_mobile like (case '"+clustermanager_mobile+"' when '' then cm.clustermanager_mobile else '%"+clustermanager_mobile+"%' end) and  cm.clustermanager_name like (case '"+clustermanager_name+"' when '' then cm.clustermanager_name else '%"+clustermanager_name+"%' end) order by cm.clustermanager_name";
			System.out.println("query :: "+q);
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				ClusterManagerAction obj=new ClusterManagerAction();
    			obj.setClustermanager_id(rs.getInt(1));
    			obj.setMobile_no(rs.getString(3));
    			obj.setClustermanager_name(rs.getString(2));
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
	
	public int clusterManagerModification(int clustermanager_id,String mobile_no,String clustermanager_name)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		Statement stmt=null;
		try 
		{
			String q = "update clustermanager_master set clustermanager_mobile = '"+mobile_no+"',clustermanager_name='"+clustermanager_name+"' where clustermanager_id="+clustermanager_id;
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
			t=1002;
			e.printStackTrace();
		} 
		finally 
		{
			return t;
		}
	}
	
	public int clustermanagerDeletion(int clustermanager_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update clustermanager_master set active='N' where clustermanager_id="+clustermanager_id;
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			con11.commit();
			con11.close();
		} 
		catch (Exception e) 
		{
			t=1002;
			e.printStackTrace();
		} 
		finally 
		{
			return t;
		}
	}

}
