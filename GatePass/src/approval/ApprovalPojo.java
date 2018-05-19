package approval;

import java.sql.*;
import java.util.LinkedList;

import connection.connection;

public class ApprovalPojo implements ApprovalInterface
{
	java.util.Date dt = new java.util.Date();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateTime = sdf.format(dt);
	
	public LinkedList getsmedetails(int sme_id)
	{
		LinkedList smedetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select u.indus_tower_id,u.unsme_mobile,u.sms_generated from unscheduled_req_master as u where u.active= 'N' and u.unscheduled_req_id= "+ sme_id +" ";
	    		System.out.println("*******************q :: "+q);
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			smedetails.add(rs.getString(1));
	    			smedetails.add(rs.getString(2));
	    			smedetails.add(rs.getString(3));
	    				
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return smedetails;
		}
		
	}
	public LinkedList fetchSMEVisitList()
	{
		
		LinkedList smedetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select u.unscheduled_req_id,u.indus_tower_id,u.unsme_mobile,u.datetime,u.interface_type,u.name,u.company_name,p.purpose_name from unscheduled_req_master as u,purpose_master as p where u.active= 'N' and u.purpose_id=p.purpose_id ";
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			ApprovalAction obj=new ApprovalAction();
	    			obj.setUnscheduled_req_id(rs.getInt(1));
	    			obj.setIndus_tower_id(rs.getString(2));
	    			obj.setUnsme_mobile(rs.getString(3));
	    			obj.setDatetime(rs.getString(4));
	    			obj.setInterface_type(rs.getString(5));
	    			obj.setName(rs.getString(6));
	    			obj.setCompany_name(rs.getString(7));
	    			obj.setPurpose_name(rs.getString(8));
	    			smedetails.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return smedetails;
		}
		
	}
	public LinkedList execute()
	{
		
		LinkedList smedetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select sm.sme_id,sm.sme_mobile,sm.sme_name,smt.smetype_name,sp.serviceprovider_name from sme_master as sm,smetype_master as smt,serviceprovider_master as sp where sm.active= 'N' and sm.smetype_id=smt.smetype_id and sm.serviceprovider_id=sp.serviceprovider_id ";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			ApprovalAction obj=new ApprovalAction();
	    			obj.setSme_id(rs.getInt(1));
	    			obj.setSme_mobile(rs.getString(2));
	    			obj.setSme_name(rs.getString(3));
	    			obj.setSmetype_name(rs.getString(4));
	    			obj.setServiceprovider_name(rs.getString(5));
	    			smedetails.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return smedetails;
		}
		
	}
	public int SMEApproval(int sme_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		Statement stmt=null;
		try 
		{
			String q = "update sme_master set active='Y' where sme_id= "+ sme_id +" ";
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
	
	
	public int approvalAllSME()
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		Statement stmt=null;
		try 
		{
			String q = "update sme_master set active='Y' where active='N'";
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
	
	public int SMEVisitApproval(int sme_id,String user_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		Statement stmt=null;
		int user_id1=Integer.parseInt(user_id);
		try 
		{
			String q = "update unscheduled_req_master set active='Y',modified_time='"+ dateTime +"',modified_by= " +user_id1+ " where unscheduled_req_id= "+ sme_id +" ";
			System.out.println("*********q :: "+q);

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
}
