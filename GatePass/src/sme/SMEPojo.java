package sme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import serviceprovider.ServiceProviderAction;
import connection.connection;
import district.DistrictAction;

public class SMEPojo implements SMEInterface
{
	java.util.Date dt = new java.util.Date();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateTime = sdf.format(dt);
	
	public int checkSMEMobile(String mobile)
	{
		connection con=new connection();
		Connection con1=con.Connect();
		int count=0;
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select count(*) from smetype_master where sme_mobile='"+mobile+"' and active='Y'";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		if(rs.next())
	    		{
	    			count=Integer.parseInt(rs.getString(1));
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return count;
		}
	}
	
	public LinkedList execute()
	{
		LinkedList smetypedetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select smetype_id,smetype_name from smetype_master where active= 'Y' order by smetype_name";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			SMEAction obj=new SMEAction();
	    			obj.setSmetype_id(rs.getInt(1));
	    			obj.setSmetype_name(rs.getString(2));
	    			smetypedetails.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return smetypedetails;
		}
		
	}
	
	public int addSME(String mobile,String SME_name,int serviceprovider_id,int smetype_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		String message = "";
		String message1 = "";
		try 
		{
			String q = "insert into sme_master(sme_mobile,sme_name,serviceprovider_id,smetype_id) values(?,?,?,?) ";
			PreparedStatement pst = con11.prepareStatement(q);
			pst.setString(1, mobile);
			pst.setString(2, SME_name);
			pst.setInt(3, serviceprovider_id);
			pst.setInt(4, smetype_id);
			t = pst.executeUpdate();
			/*if(t > 0){
				q="insert into sme_master_trace(sme_id,action,actor,action_date,ip) values((select sme_id from sme_master where sme_mobile='"+mobile+"' and active='Y'),'Addition','"+actor+"',NOW(),'"+ip+"')";
				System.out.println("q :: "+q);
				Statement stmt=con11.createStatement();
				t = stmt.executeUpdate(q);
				if(t>0){
					t = 1;
					con11.commit();
				}
				else{
					t = 0;
					con11.rollback();
				}
			}
			else
				t=0;
		} 
		catch (Exception e) 
		{
			t = 2;
			try{
				con11.rollback();
			}
			catch (Exception ee){ee.printStackTrace();}


			e.printStackTrace();
		} 
			finally{
				try{
					con11.close();
				}
				catch (Exception ee){ee.printStackTrace();}

			finally{
			return t;}
			}*/
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
	
	public LinkedList generateSMEList(String sme_id, String flag)
	{
		System.out.println("in generateSMEList :: "+sme_id+"   "+flag);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		String q="",q1="";
		try 
		{
			if(flag != null && sme_id != null)
			{
				System.out.println("if");
				//q="select sm.sme_id,sm.sme_mobile,sm.sme_name,sm.serviceprovider_id,spm.serviceprovider_name,sm.smetype_id,stm.smetype_name from sme_master sm,serviceprovider_master spm,smetype_master stm where sm.active='Y' and sm.serviceprovider_id=spm.serviceprovider_id and sm.smetype_id=stm.smetype_id and sm.sme_id="+Integer.parseInt(sme_id);
				q="select sm.sme_id,sm.sme_mobile,sm.sme_name,sm.serviceprovider_id,spm.serviceprovider_name,sm.smetype_id,stm.smetype_name,case sm.active when 'Y' then 'Active' else 'Inactive' end from sme_master sm,serviceprovider_master spm,smetype_master stm where sm.serviceprovider_id=spm.serviceprovider_id and sm.smetype_id=stm.smetype_id and sm.sme_id="+Integer.parseInt(sme_id);
			}
			else if(Integer.parseInt(flag) == 70)
			{
				System.out.println("else if");
				q="select sm.sme_id,sm.sme_mobile,sm.sme_name,sm.serviceprovider_id,spm.serviceprovider_name,sm.smetype_id,stm.smetype_name,case sm.active when 'Y' then 'Active' else 'Inactive' end from sme_master sm,serviceprovider_master spm,smetype_master stm where sm.serviceprovider_id=spm.serviceprovider_id and sm.smetype_id=stm.smetype_id order by sm.sme_name ";
			}
			else
			{
				System.out.println("else");
				//q="select sm.sme_id,sm.sme_mobile,sm.sme_name,sm.serviceprovider_id,spm.serviceprovider_name,sm.smetype_id,stm.smetype_name from sme_master sm,serviceprovider_master spm,smetype_master stm where sm.active='Y' and sm.serviceprovider_id=spm.serviceprovider_id and sm.smetype_id=stm.smetype_id order by sm.sme_id desc limit 0,30";
				q="select sm.sme_id,sm.sme_mobile,sm.sme_name,sm.serviceprovider_id,spm.serviceprovider_name,sm.smetype_id,stm.smetype_name,case sm.active when 'Y' then 'Active' else 'Inactive' end from sme_master sm,serviceprovider_master spm,smetype_master stm where sm.serviceprovider_id=spm.serviceprovider_id and sm.smetype_id=stm.smetype_id and sm.serviceprovider_id="+Integer.parseInt(flag)+" order by sm.sme_name ";
			
			}
			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			//System.out.println(q);
			while(rs.next())
			{
				SMEAction obj=new SMEAction();
    			obj.setSme_id(rs.getInt(1));
    			obj.setMobile(rs.getString(2));
    			obj.setSme_name(rs.getString(3));
    			obj.setServiceprovider_id(rs.getInt(4));
    			obj.setServiceprovider_name(rs.getString(5));
    			obj.setSmetype_id(rs.getInt(6));
    			obj.setSmetype_name(rs.getString(7));
    			obj.setStatus(rs.getString(8));
    			//System.out.println("count :: "+obj+" "+rs.getString(7));

    			
    			ll.add(obj);
			}
			//System.out.println("count :: "+ll);
			
			
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
	
	
	
	public LinkedList generateSMEListHaddi(String sme_name,String mobile,int serviceprovider_id,int smetype_id)
	{
		//System.out.println("in generateSMEList :: "+sme_name+"   "+mobile+" "+serviceprovider_id+" "+smetype_id);
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		LinkedList ll=new LinkedList();
		
		try 
		{
			String q="",q1="";
			
				q="select sm.sme_id,sm.sme_mobile,sm.sme_name,sm.serviceprovider_id,spm.serviceprovider_name,sm.smetype_id,stm.smetype_name,case sm.active when 'Y' then 'Active' else 'Inactive' end from sme_master sm,serviceprovider_master spm,smetype_master stm where sm.active='Y' and sm.serviceprovider_id=spm.serviceprovider_id and sm.smetype_id=stm.smetype_id and sm.sme_name like case '"+sme_name+"' when '' then sm.sme_name else '%"+sme_name+"%' end and sm.sme_mobile like case '"+mobile+"' when '' then sm.sme_mobile else '%"+mobile+"%' end and sm.serviceprovider_id=case '"+serviceprovider_id+"' when '-1' then sm.serviceprovider_id else '"+serviceprovider_id+"' end and sm.smetype_id=case '"+smetype_id+"' when '-1' then sm.smetype_id else '"+smetype_id+"' end order by sm.sme_id desc";
				System.out.println(q);

			PreparedStatement pst = con11.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
			//System.out.println(q);
			while(rs.next())
			{
				SMEAction obj=new SMEAction();
    			obj.setSme_id(rs.getInt(1));
    			obj.setMobile(rs.getString(2));
    			obj.setSme_name(rs.getString(3));
    			obj.setServiceprovider_id(rs.getInt(4));
    			obj.setServiceprovider_name(rs.getString(5));
    			obj.setSmetype_id(rs.getInt(6));
    			obj.setSmetype_name(rs.getString(7));
    			obj.setStatus(rs.getString(8));
    			//System.out.println("count :: "+obj+" "+rs.getString(7));

    			
    			ll.add(obj);
			}
			//System.out.println("count :: "+ll);
			
			
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
	
	
	public int SMEModification(int sme_id,String mobile,String sme_name,int serviceprovider_id,int smetype_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{	
			String q = "update sme_master set sme_mobile='"+mobile+"', sme_name='"+sme_name+"', serviceprovider_id="+serviceprovider_id+", smetype_id="+smetype_id+" where sme_id="+sme_id;
			System.out.println("*********************q :: "+q);
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			
			
			if(t > 0){
				t=1;
				con11.commit();
			}
			else
				t=0;
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
	
	public int smeDeletion(int sme_id)
	{
		int t = 0;
		connection con1 = new connection();
		Connection con11 = con1.Connect();
		try 
		{
			String q = "update sme_master set active='N' where sme_id="+sme_id;
			PreparedStatement pst = con11.prepareStatement(q);
			t = pst.executeUpdate();
			if(t > 0){
				con11.commit();
				t=1;
			}
			else
				t=0;
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
