package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import sme.SMEAction;

import connection.connection;
import district.DistrictAction;

public class UserPojo implements UserInterface{
	
	public String addUser(String user_name)
	{
		System.out.println("in GateKeeperPojo addGateKeeper function, GateKeeper inputted :: "+user_name);
		return "success";
	}
	
	public LinkedList execute(int flag)
	{
		if(flag==1)
		{
		LinkedList usertypedetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select usertype_id,usertype_name from user_type_master where active= 'Y' order by usertype_name";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			UserAction obj=new UserAction();
	    			obj.setUsertype_id(rs.getInt(1));
	    			obj.setUsertype_name(rs.getString(2));
	    			usertypedetails.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return usertypedetails;
		}
		}
		else
		{
			LinkedList serviceproviderdetails=new LinkedList();
			connection con=new connection();
			Connection con1=con.Connect();
			try{
		    		Statement stmt=con1.createStatement();
		    		String q="select serviceprovider_id,serviceprovider_name from serviceprovider_master where active= 'Y' order by serviceprovider_name";  
		    		ResultSet rs=stmt.executeQuery(q);
		    		while(rs.next())
		    		{
		    			UserAction obj=new UserAction();
		    			obj.setServiceprovider_id(rs.getInt(1));
		    			obj.setServiceprovider_name(rs.getString(2));
		    			serviceproviderdetails.add(obj);	
		    		}
		    		con1.close();
	    	}
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				return serviceproviderdetails;
			}
		}
		
	}
	public int adduser(String mobile_no,String user_name,int usertype_id,String password,int serviceprovider_id,String name) 
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into user_master(user_mobile,user_name,usertype_id,password,serviceprovider_id,Name) values(?,?,?,?,?,?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, mobile_no);
			pst.setString(2, user_name);
			pst.setInt(3, usertype_id);
			pst.setString(4, password);
			pst.setInt(5, serviceprovider_id);
			pst.setString(6, name);
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
	
	public LinkedList generateUserList(int user_id,String flag,String usertype_id)
	{
		//System.out.println("in generateUserList :: "+user_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		String q="",q1="";
		try 
		{
			if((Integer.parseInt(flag) != 70) && (Integer.parseInt(usertype_id) != 5)) // For NON-INDUS User PLUS NON-Normal User
			{
				//System.out.println("if");
				q="select um.user_id,um.user_mobile,um.user_name,um.name,um.password,um.serviceprovider_id,spm.serviceprovider_name,um.usertype_id,utm.usertype_name from user_master um,serviceprovider_master spm,user_type_master utm where um.active='Y' and um.serviceprovider_id=spm.serviceprovider_id and um.usertype_id=utm.usertype_id and um.serviceprovider_id="+Integer.parseInt(flag)+" order by um.name";
			}
			else if((Integer.parseInt(flag) == 70) && (Integer.parseInt(usertype_id) != 5)) // For INDUS User
			{
				//System.out.println("else if");
				q="select um.user_id,um.user_mobile,um.user_name,um.name,um.password,um.serviceprovider_id,spm.serviceprovider_name,um.usertype_id,utm.usertype_name from user_master um,serviceprovider_master spm,user_type_master utm where um.active='Y' and um.serviceprovider_id=spm.serviceprovider_id and um.usertype_id=utm.usertype_id order by um.name";
			}
			else // For NON-INDUS User PLUS Normal User
			{
				//System.out.println("else");
				q="select um.user_id,um.user_mobile,um.user_name,um.name,um.password,um.serviceprovider_id,spm.serviceprovider_name,um.usertype_id,utm.usertype_name from user_master um,serviceprovider_master spm,user_type_master utm where um.active='Y' and um.serviceprovider_id=spm.serviceprovider_id and um.usertype_id=utm.usertype_id and um.user_id="+user_id+" and um.serviceprovider_id="+Integer.parseInt(flag)+" order by um.name";
			}
			
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			//System.out.println(q);
			while(rs.next())
			{
				UserAction obj=new UserAction();
    			obj.setUser_id(rs.getInt(1));
    			obj.setMobile_no(rs.getString(2));
    			obj.setUser_name(rs.getString(3));
    			obj.setName(rs.getString(4));
    			obj.setPassword(rs.getString(5));
    			obj.setServiceprovider_id(rs.getInt(6));
    			obj.setServiceprovider_name(rs.getString(7));
    			obj.setUsertype_id(rs.getInt(8));
    			obj.setUsertype_name(rs.getString(9));
    			//System.out.println("count :: "+obj+" "+rs.getString(7));

    			
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
	
	public int UserModification(int user_id,String mobile_no,String user_name,String name,String password,int serviceprovider_id,int usertype_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update user_master set user_mobile='"+mobile_no+"', user_name='"+user_name+"', name='"+name+"', password='"+password+"', serviceprovider_id="+serviceprovider_id+", usertype_id="+usertype_id+" where user_id="+user_id;
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			if(t > 0){
				t=1;
				
			}
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
	
	public int userDeletion(int user_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update user_master set active='N' where user_id="+user_id;
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			if(t > 0){
				t=1;
				
			}
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
	
	public LinkedList megaHuntUser(String name,String mobile_no,int serviceprovider_id,int usertype_id)
	{
		
		if(name!=null)
			name="'"+name+"%'";
		
		if(mobile_no!=null)
			mobile_no="'"+mobile_no+"%'";
		
		System.out.println("in megaHuntuser pojo :: "+name);
		String sp_id=String.valueOf(serviceprovider_id);
		String ut_id=String.valueOf(usertype_id);

		
		if(serviceprovider_id==-1)
		{
			sp_id=null;
		}
		else
			sp_id="'"+sp_id+"'";
		
		if(usertype_id==-1)
		{
			ut_id=null;
		}
		else
			ut_id="'"+ut_id+"'";


		
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		try 
		{
			String q = "select um.user_id,um.user_mobile,um.user_name,um.password,um.name,sm.serviceprovider_name,utm.usertype_name from user_master um,serviceprovider_master sm,user_type_master utm where um.active='Y' and um.serviceprovider_id=sm.serviceprovider_id and um.usertype_id=utm.usertype_id and um.name like ifnull("+name+",'%') and um.user_mobile like ifnull("+mobile_no+",'%') and um.serviceprovider_id=ifnull("+sp_id+",um.serviceprovider_id) and um.usertype_id=ifnull("+ut_id+",um.usertype_id)";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			System.out.println(q);
			while(rs.next())
			{
				UserAction obj=new UserAction();
    			obj.setUser_id(rs.getInt(1));
    			obj.setMobile_no(rs.getString(2));
    			obj.setUser_name(rs.getString(3));
    			obj.setPassword(rs.getString(4));
    			obj.setName(rs.getString(5));
    			obj.setServiceprovider_name(rs.getString(6));
    			obj.setUsertype_name(rs.getString(7));
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
	
}
