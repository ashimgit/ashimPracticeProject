package district;

import java.sql.*;
import java.util.*;

import serviceprovider.ServiceProviderAction;
import tower.TowerAction;

import connection.*;

public class DistrictPojo implements DistrictInterface 
{
	public LinkedList execute()
	{
		
		LinkedList statedetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select state_id,state_name from state_master where active= 'Y' order by state_name";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			DistrictAction obj=new DistrictAction();
	    			obj.setState_id(rs.getInt(1));
	    			obj.setState_name(rs.getString(2));
	    			statedetails.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return statedetails;
		}
		
	}
	
	public LinkedList mahaMethod()
	{
		
		LinkedList statedetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select state_id,state_name from state_master where active= 'Y' order by state_name";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		

	    		while(rs.next())
	    		{
	    			TowerAction obj=new TowerAction();
	    			obj.setState_id(rs.getInt(1));
	    			obj.setState_name(rs.getString(2));
	    			
	    			LinkedList ll=new LinkedList();
	    			
	    			
					q="select dm.district_id,dm.district_name from district_master dm where dm.active='Y' and dm.state_id="+rs.getString(1);
	    			Statement stmt1=con1.createStatement();
					ResultSet rs1=stmt1.executeQuery(q);
		    		
		    		while(rs1.next())
		    		{
		    			DistrictAction da=new DistrictAction();
		    			da.setDistrict_id(rs1.getInt(1));
		    			da.setDistrict_name(rs1.getString(2));
		    			ll.add(da);
		    			
		    		}
		    		obj.setDistrict_list(ll);

					statedetails.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return statedetails;
		}
		
	}
	
	public int adddistrict(int State_id,String District_name) 
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into district_master(state_id,district_name) values(?,?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setInt(1, State_id);
			pst.setString(2, District_name);
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
	
	public LinkedList generateDistrictList(String district_id,String flag)
	{
		System.out.println("in generateDistrictList :: "+district_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		String q="",q1="";
		try 
		{
			if(flag!=null)
			{
				if(flag.equals("100"))
					q="select dm.district_id,dm.district_name,sm.state_id,sm.state_name from district_master dm,state_master sm where dm.active='Y' and dm.state_id=sm.state_id and dm.state_id="+Integer.parseInt(district_id);
				else
					q="select dm.district_id,dm.district_name,sm.state_id,sm.state_name from district_master dm,state_master sm where dm.active='Y' and dm.state_id=sm.state_id and dm.district_id="+Integer.parseInt(district_id);
			}
			else
				q = "select dm.district_id,dm.district_name,sm.state_id,sm.state_name from district_master dm,state_master sm where dm.active='Y' and dm.state_id=sm.state_id order by dm.district_name";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			
			System.out.println("****************q :: "+q);
			
			while(rs.next())
			{
				DistrictAction obj=new DistrictAction();
    			obj.setDistrict_id(rs.getInt(1));
    			obj.setDistrict_name(rs.getString(2));
    			obj.setState_id(rs.getInt(3));
    			obj.setState_name(rs.getString(4));
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
	
	public int districtModification(int district_id,String district_name,int state_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update district_master set district_name='"+district_name+"', state_id="+state_id+" where district_id="+district_id;
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
	
	public int districtDeletion(int district_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update district_master set active='N' where district_id="+district_id;
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
	
	public LinkedList megaHuntDistrict(String district_name,int state_id)
	{
		if(district_name.equals(""))
		{System.out.println("hmm");
			district_name = null;
		}
		else
			district_name="'"+district_name+"%'";
		System.out.println("in megaHunt pojo :: "+district_name);
		String state_id_temp=String.valueOf(state_id);
		
		if(state_id==-1)
		{
			state_id_temp=null;
		}
		else
			state_id_temp="'"+state_id_temp+"'";

		
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		try 
		{
			String q = "select dm.district_id,dm.district_name,sm.state_id,sm.state_name from district_master dm,state_master sm where dm.active='Y' and dm.state_id=sm.state_id and dm.district_name like ifnull("+district_name+",'%') and dm.state_id=ifnull("+state_id_temp+",dm.state_id)";
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			System.out.println(q);
			while(rs.next())
			{
				DistrictAction obj=new DistrictAction();
    			obj.setDistrict_id(rs.getInt(1));
    			obj.setDistrict_name(rs.getString(2));
    			obj.setState_id(rs.getInt(3));
    			obj.setState_name(rs.getString(4));
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

	@Override
	public int searchdistrict(String district_name) 
	{
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		int t = 0;
		try
		{
			Statement stmt = con11.createStatement();
			String query = "select district_id from district_master where district_name like '%"+district_name+"%' ";
			System.out.println("query : "+query);
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
			{
				t = rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			try {
				con11.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return t;
		}
	}

}
