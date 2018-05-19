package sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import connection.connection;
import district.DistrictAction;

public class SMSPojo implements SMSInterface
{
	java.util.Date dt = new java.util.Date();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateTime = sdf.format(dt);
	
	public ArrayList tower_supervisor(String indus_tower_id)
	{
		ArrayList al = new ArrayList();
		connection con = new connection();
		Connection con1 = con.Connect();
		try 
		{
			Statement stmt = con1.createStatement();
			String q = "select supervisor_mobile from tower_vs_supervisor where indus_tower_id = '"+indus_tower_id+"' ";
			ResultSet rs = stmt.executeQuery(q);
    		while(rs.next())
    		{
    			al.add(rs.getString(1));
    		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			try {
				con1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return al;
		}
		
	}
	public int addUnScheduleSMS(String indus_tower_id, String mobile_no,String datepicker, int purpose_id, String gatepass_no,String sms_generated, String interface_type, String name,String company_name,String gatekeeper_mobile,String clustermanager_mobile,String message_text)
	{
		
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "insert into unscheduled_req_master(indus_tower_id,unsme_mobile,gatepass_no,sms_generated,datetime,purpose_id,interface_type,name,company_name,gatekeeper_mobile,clustermanager_mobile,message_text,request_datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, indus_tower_id);
			pst.setString(2, mobile_no);
			pst.setString(3, gatepass_no);
			pst.setString(4, sms_generated);
			pst.setString(5, datepicker);
			pst.setInt(6, purpose_id);
			pst.setString(7, interface_type);
			pst.setString(8, name);
			pst.setString(9, company_name);
			pst.setString(10, gatekeeper_mobile);
			pst.setString(11, clustermanager_mobile);
			pst.setString(12, message_text);
			pst.setString(13, dateTime);
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
			return t;
		}

		
	}
	public int addScheduleSMS(String indus_tower_id,String mobile_no,String datepicker,int purpose,String gatepass_no,String sms_generated,String interface_type,String gatekeeper_mobile,String clustermanager_mobile,String message_text)
	{
		
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "insert into scheduled_req_master(indus_tower_id,sme_mobile,gatepass_no,sms_generated,datetime,purpose_id,interface_type,gatekeeper_mobile,clustermanager_mobile,message_text,request_datetime) values(?,?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, indus_tower_id);
			pst.setString(2, mobile_no);
			pst.setString(3, gatepass_no);
			pst.setString(4, sms_generated);
			pst.setString(5, datepicker);
			pst.setInt(6, purpose);
			pst.setString(7, interface_type);
			pst.setString(8, gatekeeper_mobile);
			pst.setString(9, clustermanager_mobile);
			pst.setString(10, message_text);
			pst.setString(11, dateTime);
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
			return t;
		}

		
	}
	public LinkedList execute()
	{
		
		LinkedList purposedetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select purpose_id,purpose_name,purpose_code from purpose_master where active= 'Y' and purpose_id !=8";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			SMSAction obj=new SMSAction();
	    			obj.setPurpose_id(rs.getInt(1));
	    			obj.setPurpose_name(rs.getString(2));
	    			obj.setPurpose_code(rs.getString(3));
	    			purposedetails.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return purposedetails;
		}
		
	}
	public LinkedList purpose(String purpose_code)
	{
		
		LinkedList purposedetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select purpose_id,purpose_name,purpose_code from purpose_master where active= 'Y' and purpose_code = '"+purpose_code+"'";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		System.out.println(q);
	    		while(rs.next())
	    		{
	    			purposedetails.add(rs.getInt(1));
	    			purposedetails.add(rs.getString(2));
	    			purposedetails.add(rs.getString(3));
	    				
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return purposedetails;
		}
		
	}
	public LinkedList check_tower_sp(String indus_tower_id)
	{
		
		LinkedList tower_details=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select tm.tower_id,tm.gatekeeper_mobile,tm.clustermanager_mobile,tm.serviceprovider_id,tm.district_id,gm.gatekeeper_name from tower_master as tm,gatekeeper_master as gm where tm.active= 'Y' and tm.indus_tower_id= '"+indus_tower_id+"' and tm.gatekeeper_mobile = gm.gatekeeper_mobile ";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		System.out.println("************** q1 :: "+q);
	    		while(rs.next())
	    		{
	    			tower_details.add(Integer.valueOf(rs.getInt(1)));//System.out.println(eid);
	    			tower_details.add(rs.getString(2));
	    			tower_details.add(rs.getString(3));
	    			tower_details.add(rs.getString(4));
	    			tower_details.add(Integer.valueOf(rs.getInt(5)));
	    			tower_details.add(rs.getString(6));
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return tower_details;
		}
		
	}
	public LinkedList check_gatepass_no(String gatepass_no,int VitorType)
	{
		String q = "";
		LinkedList tower_details=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		if(VitorType == 1)
	    			q="select sme_mobile,gatekeeper_mobile,clustermanager_mobile,scheduled_req_id from scheduled_req_master where cancel= 'N' and gatepass_no = '"+gatepass_no+"' ";  
	    		else
	    			q="select unsme_mobile,gatekeeper_mobile,clustermanager_mobile,unscheduled_req_id from unscheduled_req_master where cancel= 'N' and gatepass_no = '"+gatepass_no+"' ";
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			tower_details.add(rs.getString(1));//System.out.println(eid);
	    			tower_details.add(rs.getString(2));
	    			tower_details.add(rs.getString(3));
	    			tower_details.add(Integer.valueOf(rs.getInt(4)));
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return tower_details;
		}
		
	}
	public int getserviceprovider_id(String mobile_no) 
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		Statement stmt = null;
		try 
		{
			stmt=con11.createStatement();
    		String q="select serviceprovider_id from sme_master where active= 'Y' and sme_mobile= '"+mobile_no+"' ";  
    		ResultSet rs=stmt.executeQuery(q);
    		System.out.println(q);
    		while(rs.next())
    		{
    			t=rs.getInt(1);
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
	public int requestcheck(String indus_tower_id,String mobile_no,String date) 
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		Statement stmt = null;
		try 
		{
			stmt=con11.createStatement();
    		String q="select unscheduled_req_id from unscheduled_req_master where indus_tower_id = '"+indus_tower_id+"' and unsme_mobile = '"+mobile_no+"' and datetime = '"+date+"' and active= 'N' ";  
    		ResultSet rs=stmt.executeQuery(q);
    		System.out.println(q);
    		while(rs.next())
    		{
    			t=rs.getInt(1);
    		}
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

	public int addcancelSMS(int scheduled_id,int VitorType) 
	{
		int t = 0;
		String q= "";
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		Statement stmt = null;
		try 
		{
			stmt=con11.createStatement();
			if(VitorType == 1)
				q="update scheduled_req_master set cancel= 'Y' where scheduled_req_id = "+scheduled_id+" ";  
			else
				q="update unscheduled_req_master set cancel= 'Y' where unscheduled_req_id = "+scheduled_id+" ";
			PreparedStatement pst = con11.prepareStatement(q);
    		t = pst.executeUpdate();
			con11.commit();
			if(t>0)
				t=1;
			else
				t=0;
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
	public int addconfirmationSMS(int scheduled_id,int VitorType) 
	{
		int t = 0;
		String q= "";
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		Statement stmt = null;
		try 
		{
			stmt=con11.createStatement();
			if(VitorType == 1)
				q="update scheduled_req_master set visit_conf_txt = 'Y',act_date = '"+dateTime+"' where scheduled_req_id = "+scheduled_id+" ";  
			else
				q="update unscheduled_req_master set visit_conf_txt = 'Y',act_date = '"+dateTime+"' where unscheduled_req_id = "+scheduled_id+" ";
			PreparedStatement pst = con11.prepareStatement(q);
    		t = pst.executeUpdate();
			con11.commit();
			if(t>0)
				t=1;
			else
				t=0;
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
	public String getpurpose_name(int purpose_id)
	{
		String purpose_name = "";
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select purpose_name from purpose_master where active= 'Y' and purpose_id = "+purpose_id+" ";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			purpose_name = rs.getString(1);
	    			
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return purpose_name;
		}
		
	}
	public LinkedList getsme_details(String mobile_no)
	{
		
		LinkedList tower_details=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select s.sme_name,sp.serviceprovider_name from sme_master as s,serviceprovider_master as sp where s.serviceprovider_id = sp.serviceprovider_id and s.sme_mobile = '"+mobile_no+"' ";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			tower_details.add(rs.getString(1));
	    			tower_details.add(rs.getString(2));
	    			
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return tower_details;
		}
		
	}
	
}
