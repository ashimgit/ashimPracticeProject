package serviceprovider;

import java.sql.*;
import java.util.*;

import state.StateAction;

import connection.*;
import pop.*;
import category.*;
import district.DistrictAction;


public class ServiceProviderPojo implements ServiceProviderInterface
{
	public LinkedList execute()
	{
		LinkedList categorydetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select category_id,category_name from category_master where active= 'Y' order by category_name";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			ServiceProviderAction obj=new ServiceProviderAction();
	    			obj.setCategory_id(rs.getInt(1));
	    			obj.setCategory_name(rs.getString(2));
	    			categorydetails.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return categorydetails;
		}
		
	}
	public int addServiceProvider(int Category_id,String ServiceProvider_name)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into serviceprovider_master(category_id,serviceprovider_name) values(?,?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setInt(1, Category_id);
			pst.setString(2, ServiceProvider_name);
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
			//System.out.println("Message ::"+message);
			message1 = message.substring(0, 9);
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
	
	public LinkedList generateServiceProviderList(String serviceprovider_id,String flag)
	{
		//System.out.println("in generateServiceproviderList :: "+serviceprovider_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		String q="",q1="";
		try 
		{
			if(flag != null)
				q = "select sm.serviceprovider_id,sm.serviceprovider_name,cm.category_id,cm.category_name from serviceprovider_master sm,category_master cm where sm.active='Y' and sm.category_id=cm.category_id and sm.serviceprovider_id="+Integer.parseInt(serviceprovider_id);
			else
				q = "select sm.serviceprovider_id,sm.serviceprovider_name,cm.category_id,cm.category_name from serviceprovider_master sm,category_master cm where sm.active='Y' and sm.category_id=cm.category_id order by sm.serviceprovider_name";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				ServiceProviderAction obj=new ServiceProviderAction();
    			obj.setServiceprovider_id(rs.getInt(1));
    			obj.setServiceprovider_name(rs.getString(2));
    			obj.setCategory_id(rs.getInt(3));
    			obj.setCategory_name(rs.getString(4));
    			ll.add(obj);
			}
			//System.out.println("count :: "+q);
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

	public LinkedList megaHuntServiceProvider(String serviceprovider_name,int category_id)
	{
		if(serviceprovider_name.equals(""))
		{
			//System.out.println("hmm");
			serviceprovider_name = null;
		}
		else
			serviceprovider_name="'"+serviceprovider_name+"%'";
		//System.out.println("in megaHunt pojo :: "+serviceprovider_name);
		String category_id_temp=String.valueOf(category_id);
		
		if(category_id==-1)
		{
			category_id_temp=null;
		}
		else
			category_id_temp="'"+category_id_temp+"'";

		
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		try 
		{
			String q = "select sm.serviceprovider_id,sm.serviceprovider_name,cm.category_id,cm.category_name from serviceprovider_master sm,category_master cm where sm.active='Y' and sm.category_id=cm.category_id and sm.serviceprovider_name like ifnull("+serviceprovider_name+",'%') and sm.category_id=ifnull("+category_id_temp+",sm.category_id)";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			//System.out.println(q);
			while(rs.next())
			{
				ServiceProviderAction obj=new ServiceProviderAction();
    			obj.setServiceprovider_id(rs.getInt(1));
    			obj.setServiceprovider_name(rs.getString(2));
    			obj.setCategory_id(rs.getInt(3));
    			obj.setCategory_name(rs.getString(4));
    			ll.add(obj);
			}
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
	
	public int serviceProviderModification(int serviceprovider_id,String serviceprovider_name,int category_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update serviceprovider_master set serviceprovider_name='"+serviceprovider_name+"',category_id="+category_id+" where serviceprovider_id="+serviceprovider_id;
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			con11.commit();
			con11.close();
		} 
		catch(SQLException ex)
		{
			String message = ex.getMessage();
			//System.out.println("Message ::"+message);
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


	public int serviceproviderDeletion(int serviceprovider_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update serviceprovider_master set active='N' where serviceprovider_id="+serviceprovider_id;
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			con11.commit();
			con11.close();
		} 
		
		catch (Exception e) 
		{
			t=1001;
			e.printStackTrace();
		} 
		finally 
		{
			return t;
		}
	}
	

}
