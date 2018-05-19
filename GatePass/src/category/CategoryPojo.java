package category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import purpose.PurposeAction;

import report.ReportAction;

import connection.connection;

public class CategoryPojo implements CategoryInterface{
	
	public int addCategory(String category_name)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into category_master(category_name) values(?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, category_name);
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
			t=1002;
			e.printStackTrace();
		} 
		finally 
		{
			System.out.println("t :: "+t);
			return t;
		}

	}
	
	public LinkedList generateCategoryList(String category_id,String flag)
	{
		System.out.println("in generateCategoryList :: "+category_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		String q = "";
		try 
		{
			if(flag!=null)
				q="select category_id,category_name from category_master where active='Y' and category_id="+Integer.parseInt(category_id);
			else
				q = "select category_id,category_name from category_master where active='Y' order by category_id";  
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				CategoryAction obj=new CategoryAction();
    			obj.setCategory_id(rs.getInt(1));
    			obj.setCategory_name(rs.getString(2));
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
	
	public int categoryModification(int category_id,String category_name)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update category_master set category_name='"+category_name+"' where category_id="+category_id;
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
			t=1002;
			e.printStackTrace();
		} 
		finally 
		{
			return t;
		}
	}
	
	
	public int categoryDeletion(int category_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update category_master set active='N' where category_id="+category_id;
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
	
	public LinkedList megaHuntCategory(String category_name)
	{
		if(category_name.equals("") || category_name==null)
		{System.out.println("hmm");
			category_name = null;
		}
		else
			category_name="'"+category_name+"%'";
		System.out.println("in megaHunt pojo :: "+category_name);

		
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		try 
		{
			String q = "select cm.category_id,cm.category_name from category_master cm where cm.active='Y' and cm.category_name like ifnull("+category_name+",'%') order by category_id";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			System.out.println(q);
			while(rs.next())
			{
				CategoryAction obj=new CategoryAction();
    			obj.setCategory_id(rs.getInt(1));
    			obj.setCategory_name(rs.getString(2));
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
