package login;

import java.sql.*;
import java.util.*;

import connection.*;

class LoginPojo implements LoginInterface 
{
	java.util.Date dt = new java.util.Date();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateTime = sdf.format(dt);
	
	
	public ArrayList getDynamicMenu(String usertype_id) 
	{
		ArrayList menu=new ArrayList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select permission_head from permission_head where user_type_id='"+usertype_id+"'";
	    		System.out.println(q);
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			LoginAction la1=new LoginAction();
	    			la1.setHead(rs.getString(1));
	    			q="select * from (select svh.sub col1,images,links from sub_vs_head svh where svh.head='"+rs.getString(1)+"') haddi inner join user_vs_sub uvs on haddi.col1=uvs.sub where uvs.user_id='"+usertype_id+"'";
		    		//System.out.println(" q1 :: "+q);
		    		Statement stmt1=con1.createStatement();
		    		ResultSet rs1=stmt1.executeQuery(q);
		    		ArrayList temp=new ArrayList();
		    		while(rs1.next())
		    		{
		    			LoginAction la2=new LoginAction();
		    			la2.setSub(rs1.getString(1));
		    			la2.setImage(rs1.getString(2));
		    			la2.setLinks(rs1.getString(3));
		    			temp.add(la2);
		    			
		    		}
		    		la1.setAl1(temp);
		    		menu.add(la1);

	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return menu;
		}

	}
	
	public LinkedList message_send_tillnow() 
	{
		LinkedList message_send_list = new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q = "select count(scheduled_req_id) from scheduled_req_master where interface_type = 'WEB' UNION select count(scheduled_req_id) from scheduled_req_master where interface_type = 'Mobile' UNION select count(unscheduled_req_id) from unscheduled_req_master where interface_type = 'WEB' UNION select count(unscheduled_req_id) from unscheduled_req_master where interface_type = 'Mobile' ";
	    		System.out.println(q);
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			message_send_list.add(rs.getString(1));
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return message_send_list;
		}

	}
	
	public LinkedList logincheck(String username, String password) 
	{
		LinkedList userdetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		//String q="select um.user_id,um.user_mobile,um.name,utm.usertype_name,um.serviceprovider_id,ld.login_time,ld.ip from user_master as um,user_type_master as utm,log_details as ld where um.usertype_id=utm.usertype_id and um.user_name= '"+ username +"' and um.password= '"+ password +"' and utm.active= 'Y' and um.active= 'Y' and um.user_id = ld.user_id ";  
	    		String q=" select temp.*,ifnull(ld.login_time,'First Time'),ifnull(ld.ip,'User') from (select um.user_id a,um.user_mobile b,um.name c,um.usertype_id d,um.serviceprovider_id e from user_master as um,user_type_master as utm where um.usertype_id=utm.usertype_id and um.user_name= '"+ username +"' and um.password= '"+ password +"' and utm.active= 'Y' and um.active= 'Y') temp left outer join log_details ld on temp.a = ld.user_id ";
	    		System.out.println(q);
	    		ResultSet rs=stmt.executeQuery(q);
	    		if(rs.next())
	    		{
	    			userdetails.add(Integer.valueOf(rs.getInt(1)));//System.out.println(eid);
	    			userdetails.add(rs.getString(2));
	    			userdetails.add(rs.getString(3));
	    			userdetails.add(rs.getString(4));
	    			userdetails.add(rs.getString(5));
	    			userdetails.add(rs.getString(6));
	    			userdetails.add(rs.getString(7));
	    			//userdetails.add(rs.getString(8));
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return userdetails;
		}

	}
	public int insert_log_details(int userid, String ip) 
	{
		LinkedList userdetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		int t = 0;
		try{
			String q = "insert into log_details(user_id,ip,login_time) values(?,?,?) ";
			PreparedStatement pst = con1.prepareStatement(q);
			pst.setInt(1, userid);
			pst.setString(2, ip);
			pst.setString(3, dateTime);
			t = pst.executeUpdate();
			if(t>0)
				t=1;
			else
				t=0;
			con1.commit();
			con1.close();
    	}
		catch (Exception e) 
		{
			t = 2;
			e.printStackTrace();
		} 
		finally 
		{
			return t;
		}

	}

	
}
