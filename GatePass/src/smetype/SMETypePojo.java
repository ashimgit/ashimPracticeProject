package smetype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import purpose.PurposeAction;

import state.StateAction;

import connection.connection;

public class SMETypePojo implements SMETypeInterface{
	
	public int addSMEType(String smetype_name)
	{
		
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into smetype_master(smetype_name) values(?) ";
			System.out.println(q);
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, smetype_name);
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
	
	public LinkedList generateSMETypeList(String smetype_id,String flag)
	{
		System.out.println("in generateSMETypeList :: "+smetype_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		String q="";
		try 
		{
			if(flag!=null)
				q="select * from smetype_master where active='Y' and smetype_id="+Integer.parseInt(smetype_id);
			else
				q = "select * from smetype_master where active='Y' order by smetype_name";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				SMETypeAction obj=new SMETypeAction();
    			obj.setSmetype_id(rs.getInt(1));
    			obj.setSmetype_name(rs.getString(2));
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

	public int smetypeModification(int smetype_id,String smetype_name)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update smetype_master set smetype_name='"+smetype_name+"' where smetype_id="+smetype_id;
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
	
	public int smetypeDeletion(int smetype_id)
	{
		System.out.println("in deletion "+smetype_id);
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update smetype_master set active='N' where smetype_id="+smetype_id;
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
	
	public LinkedList megaHuntSMEType(String smetype_name)
	{
		if(smetype_name.equals("") || smetype_name==null)
		{System.out.println("hmm");
			smetype_name = null;
		}
		else
			smetype_name="'"+smetype_name+"%'";
		System.out.println("in megaHunt pojo :: "+smetype_name);

		
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		try 
		{
			String q = "select stm.smetype_id,stm.smetype_name from smetype_master stm where stm.active='Y' and stm.smetype_name like ifnull("+smetype_name+",'%')";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			System.out.println(q);
			while(rs.next())
			{
				SMETypeAction obj=new SMETypeAction();
    			obj.setSmetype_id(rs.getInt(1));
    			obj.setSmetype_name(rs.getString(2));
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
