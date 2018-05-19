package state;

import java.sql.*;
import java.util.LinkedList;

import category.CategoryAction;
import connection.*;
import district.DistrictAction;

public class StatePojo implements StateInterface 
{

	public int addstate(String State_name) 
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into state_master(state_name) values(?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, State_name);
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
	
	
	public LinkedList generateStateList(String state_id,String flag)
	{
		System.out.println("in generateStateList :: "+state_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		String q="";
		try 
		{
			if(flag!=null)
				q="select * from state_master where active='Y' and state_id="+Integer.parseInt(state_id);
			else
				q = "select * from state_master where active='Y' order by state_name";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				StateAction obj=new StateAction();
    			obj.setState_id(rs.getInt(1));
    			obj.setState_name(rs.getString(2));
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
	
	
	public int stateModification(int state_id,String state_name)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update state_master set state_name='"+state_name+"' where state_id="+state_id;
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			con11.commit();
			con11.close();
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
	
	public int stateDeletion(int state_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update state_master set active='N' where state_id="+state_id;
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
			return t;
		}
	}
	
	public LinkedList megaHuntState(String state_name)
	{
		if(state_name.equals("") || state_name==null)
		{System.out.println("hmm");
			state_name = null;
		}
		else
			state_name="'"+state_name+"%'";
		System.out.println("in megaHunt pojo :: "+state_name);

		
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		try 
		{
			String q = "select sm.state_id,sm.state_name from state_master sm where sm.active='Y' and sm.state_name like ifnull("+state_name+",'%')";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			System.out.println(q);
			while(rs.next())
			{
				StateAction obj=new StateAction();
    			obj.setState_id(rs.getInt(1));
    			obj.setState_name(rs.getString(2));
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
