package excel;

import java.sql.*;

import connection.*;

public class UploadAdditionalExcelPojo 
{
	public int tower_vs_supervisor(String indus_tower_id, String supervisor_name,String supervisor_mobile,String designation,String reason)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into tower_vs_supervisor(indus_tower_id,supervisor_name,supervisor_mobile,designation,reason) values(?,?,?,?,?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, indus_tower_id);
			pst.setString(2, supervisor_name);
			pst.setString(3, supervisor_mobile);
			pst.setString(4, designation);
			pst.setString(5, reason);
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
}
