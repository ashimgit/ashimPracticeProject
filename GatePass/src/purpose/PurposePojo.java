package purpose;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import state.StateAction;

import category.CategoryAction;

import connection.connection;

public class PurposePojo implements PurposeInterface
{
	public int addpurpose(String purpose_name,String purpose_code) 
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into purpose_master(purpose_name,purpose_code) values(?,?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, purpose_name);
			pst.setString(2, purpose_code);
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
	
	public LinkedList generatePurposeList(String purpose_id,String flag)
	{
		System.out.println("in generatePurposeList :: "+purpose_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		String q="";
		try 
		{
			if(flag!=null)
				q="select purpose_id,purpose_name,purpose_code from purpose_master where active='Y' and purpose_id="+Integer.parseInt(purpose_id);
			else
				q = "select purpose_id,purpose_name,purpose_code from purpose_master where active='Y' order by purpose_name";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				PurposeAction obj=new PurposeAction();
    			obj.setPurpose_id(rs.getInt(1));
    			obj.setPurpose_name(rs.getString(2));
    			obj.setPurpose_code(rs.getString(3));
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
	
	
	public int purposeModification(int purpose_id,String purpose_name,String purpose_code)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update purpose_master set purpose_name='"+purpose_name+"',purpose_code='"+purpose_code+"' where purpose_id="+purpose_id;
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
	
	public int purposeDeletion(int purpose_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update purpose_master set active='N' where purpose_id="+purpose_id;
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
	
	public LinkedList megaHuntPurpose(String purpose_name,String purpose_code)
	{
		if(purpose_name.equals("") || purpose_name==null)
		{System.out.println("hmm");
			purpose_name = null;
		}
		else
			purpose_name="'"+purpose_name+"%'";
		
		if(purpose_code.equals("") || purpose_code==null)
		{System.out.println("hmm");
			purpose_code = null;
		}
		else
			purpose_code="'"+purpose_code+"%'";
		
		System.out.println("in megaHunt pojo :: "+purpose_name);

		
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		try 
		{
			String q = "select pm.purpose_id,pm.purpose_name,pm.purpose_code from purpose_master pm where pm.active='Y' and pm.purpose_name like ifnull("+purpose_name+",'%') and pm.purpose_code like ifnull("+purpose_code+",'%')";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			System.out.println(q);
			while(rs.next())
			{
				PurposeAction obj=new PurposeAction();
    			obj.setPurpose_id(rs.getInt(1));
    			obj.setPurpose_name(rs.getString(2));
    			obj.setPurpose_code(rs.getString(3));
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
