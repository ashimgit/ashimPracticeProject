package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import connection.connection;

public class UserTypePojo implements UserTypeInterface{
	
	public LinkedList generateUserTypeList(String usertype_id,String flag)
	{
		System.out.println("in generateUserTypeList :: "+usertype_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		
		try 
		{
			String q="",q1="";
			
			if(flag!=null)
				q="select utm.usertype_id,utm.usertype_name from user_type_master utm where utm.active='Y' and utm.usertype_id="+Integer.parseInt(usertype_id);
			else
				q="select utm.usertype_id,utm.usertype_name from user_type_master utm where utm.active='Y'";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				UserTypeAction obj=new UserTypeAction();
    			obj.setUsertype_id(rs.getInt(1));
    			obj.setUsertype_name(rs.getString(2));

    			
    			ll.add(obj);
			}
			System.out.println("count :: "+q);
			
			
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
