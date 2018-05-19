package report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import approval.ApprovalAction;
import connection.connection;

public class ReportPojo implements ReportInterface
{
	public LinkedList fetchSMSSendReport(int serviceprovider_id)
	{
		String q="";
		System.out.println("In fetchSMSSendReport : "+serviceprovider_id);
		LinkedList smssendreport=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		if(serviceprovider_id == 70)
	    			q="select * from (select u.unscheduled_req_id,u.indus_tower_id,u.unsme_mobile,u.datetime,u.interface_type,u.name,u.company_name,p.purpose_name,u.modified_time,um.user_name,'Un-Schedule' from unscheduled_req_master as u,purpose_master as p,user_master as um where u.active= 'Y' and u.purpose_id=p.purpose_id and u.modified_by=um.user_id union select s.scheduled_req_id,s.indus_tower_id,s.sme_mobile,s.datetime,'WEB',sm.sme_name,srm.serviceprovider_name,p.purpose_name,'haddi','haru','Schedule' from scheduled_req_master as s,purpose_master as p,sme_master as sm,serviceprovider_master as srm where s.purpose_id=p.purpose_id and s.sme_mobile=sm.sme_mobile and sm.serviceprovider_id=srm.serviceprovider_id) haddi1 order by 1 desc limit 0,20 ";  
	    		else
	    			q="select s.scheduled_req_id,s.indus_tower_id,s.sme_mobile,s.datetime,'WEB',sm.sme_name,srm.serviceprovider_name,p.purpose_name,'haddi','haru','Schedule' from scheduled_req_master as s,purpose_master as p,sme_master as sm,serviceprovider_master as srm where s.purpose_id=p.purpose_id and s.sme_mobile=sm.sme_mobile and sm.serviceprovider_id=srm.serviceprovider_id and sm.serviceprovider_id = "+serviceprovider_id+" order by 1 desc limit 0,20";
	    		
	    		System.out.println(q);
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			ReportAction obj=new ReportAction();
	    			obj.setUnscheduled_req_id(rs.getInt(1));
	    			obj.setIndus_tower_id(rs.getString(2));
	    			obj.setUnsme_mobile(rs.getString(3));
	    			obj.setDatetime(rs.getString(4));
	    			obj.setInterface_type(rs.getString(5));
	    			obj.setName(rs.getString(6));
	    			obj.setCompany_name(rs.getString(7));
	    			obj.setPurpose_name(rs.getString(8));
	    			obj.setModified_time(rs.getString(9));
	    			obj.setModified_by(rs.getString(10));
	    			obj.setSme_type(rs.getString(11));

	    			smssendreport.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return smssendreport;
		}
		
	}
	public LinkedList fetchSMEVisitApprovalList()
	{
		
		LinkedList smevisitapprovaldetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q="select u.unscheduled_req_id,u.indus_tower_id,u.unsme_mobile,u.datetime,u.interface_type,u.name,u.company_name,p.purpose_name,u.modified_time,um.user_name from unscheduled_req_master as u,purpose_master as p,user_master as um where u.active= 'Y' and u.purpose_id=p.purpose_id and u.modified_by=um.user_id order by 4 desc ";  
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			ReportAction obj=new ReportAction();
	    			obj.setUnscheduled_req_id(rs.getInt(1));
	    			obj.setIndus_tower_id(rs.getString(2));
	    			obj.setUnsme_mobile(rs.getString(3));
	    			obj.setDatetime(rs.getString(4));
	    			obj.setInterface_type(rs.getString(5));
	    			obj.setName(rs.getString(6));
	    			obj.setCompany_name(rs.getString(7));
	    			obj.setPurpose_name(rs.getString(8));
	    			obj.setModified_time(rs.getString(9));
	    			obj.setModified_by(rs.getString(10));
	    			smevisitapprovaldetails.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return smevisitapprovaldetails;
		}
		
	}
	public LinkedList fetchSMEJoiningList(int serviceprovider_id)
	{
		String q="";
		LinkedList smedetails=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		//String q="select sm.sme_id,sm.sme_mobile,sm.sme_name,smt.smetype_name,sp.serviceprovider_name,sm.modified_time,um.user_name from sme_master as sm,smetype_master as smt,serviceprovider_master as sp,user_master as um where sm.active= 'Y' and sm.smetype_id=smt.smetype_id and sm.serviceprovider_id=sp.serviceprovider_id and sm.modified_by=um.user_id order by 6 desc limit 0,20";  
	    		if(serviceprovider_id == 70)
	    			q="select sm.sme_id,sm.sme_mobile,sm.sme_name,smt.smetype_name,sp.serviceprovider_name,sm.modified_time,um.user_name from sme_master as sm,smetype_master as smt,serviceprovider_master as sp,user_master as um where sm.active= 'Y' and sm.smetype_id=smt.smetype_id and sm.serviceprovider_id=sp.serviceprovider_id and sm.modified_by=um.user_id order by 1 desc limit 0,20";   
	    		else
	    			q="select sm.sme_id,sm.sme_mobile,sm.sme_name,smt.smetype_name,sp.serviceprovider_name,sm.modified_time,um.user_name from sme_master as sm,smetype_master as smt,serviceprovider_master as sp,user_master as um where sm.active= 'Y' and sm.smetype_id=smt.smetype_id and sm.serviceprovider_id=sp.serviceprovider_id and sm.modified_by=um.user_id and sm.serviceprovider_id = "+serviceprovider_id+"";
	    		
	    		//System.out.println("q"+q);
	    		ResultSet rs=stmt.executeQuery(q);
	    		//System.out.println(q);
	    		while(rs.next())
	    		{
	    			ReportAction obj=new ReportAction();
	    			obj.setSme_id(rs.getInt(1));
	    			obj.setSme_mobile(rs.getString(2));
	    			obj.setSme_name(rs.getString(3));
	    			obj.setSmetype_name(rs.getString(4));
	    			obj.setServiceprovider_name(rs.getString(5));
	    			obj.setModified_time(rs.getString(6));
	    			obj.setModified_by(rs.getString(7));
	    			smedetails.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return smedetails;
		}
		
	}
	public LinkedList ValidatingGatePass(String GatePass)
	{
		
		LinkedList gatepass=new LinkedList();
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		String q = "SELECT `indus_tower_id`,`unsme_mobile`,`datetime` FROM `unscheduled_req_master` WHERE `gatepass_no`= '"+GatePass+"' union SELECT `indus_tower_id`,`sme_mobile`,`datetime` FROM `scheduled_req_master` WHERE `gatepass_no`= '"+GatePass+"' "; 
	    		System.out.println("q validating gatepass ::: "+q);
	    		ResultSet rs=stmt.executeQuery(q);
	    		while(rs.next())
	    		{
	    			ReportAction obj = new ReportAction();
	    			obj.setIndus_tower_id(rs.getString(1));
	    			obj.setUnsme_mobile(rs.getString(2));
	    			obj.setDatetime(rs.getString(3));
	    			gatepass.add(obj);	
	    		}
	    		con1.close();
    	}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			return gatepass;
		}
		
	}
	
	
	public LinkedList megaHuntSendSMS(String indus_tower_id,String sme_mobile,String interface_type,String sme_schedule_type,String sme_name,String company_name,String from,String to,int serviceprovider_id)
	{
		LinkedList ll=new LinkedList();
		
		if(indus_tower_id.equals(""))
			indus_tower_id = null;
		else
			indus_tower_id="'"+indus_tower_id+"%'";
		
		if(sme_mobile.equals(""))
			sme_mobile = null;
		else
			sme_mobile="'"+sme_mobile+"%'";
		
		if(interface_type.equals("undefined"))
		{
			System.out.println("yes its caught interface_type");
			interface_type = null;
		}
		else
			interface_type="'"+interface_type+"'";
		
		if(sme_schedule_type.equals("undefined"))
		{
			System.out.println("yes its caught sme_schedule_type");

			sme_schedule_type = null;
		}
		else
			sme_schedule_type="'"+sme_schedule_type+"'";
		
		if(sme_name.equals(""))
			sme_name = null;
		else
			sme_name="'"+sme_name+"%'";
		
		if(company_name.equals("0"))
			company_name = null;
		else
			company_name="'"+company_name+"'";
		if(from.equals(""))
			from = null;
		else
			from="'"+from+"'";
		if(to.equals(""))
			to = null;
		else
			to="'"+to+"'";
		String q="";
		connection con=new connection();
		Connection con1=con.Connect();
		try{
	    		Statement stmt=con1.createStatement();
	    		//q="select sm.indus_tower_id, sm.sme_mobile,sm.request_datetime,sm.interface_type,sme.sme_name,spm.serviceprovider_name,pm.purpose_name,'Schedule' from scheduled_req_master sm,sme_master sme,serviceprovider_master spm,purpose_master pm where sm.sme_mobile=sme.sme_mobile and sme.serviceprovider_id=spm.serviceprovider_id and sm.purpose_id=pm.purpose_id and sm.indus_tower_id like ifnull("+indus_tower_id+",'%') and sm.sme_mobile like ifnull("+sme_mobile+",'%') and sm.interface_type=ifnull("+interface_type+",sm.interface_type) and sm.sch_type=ifnull("+sme_schedule_type+",'S') and sme.sme_name like ifnull("+sme_name+",'%') and spm.serviceprovider_id=ifnull("+company_name+",spm.serviceprovider_id) and sm.request_datetime between replace(ifnull("+from+",sm.request_datetime),'/','-') and replace(ifnull("+to+",sm.request_datetime),'/','-') union select usm.indus_tower_id, usm.unsme_mobile,usm.request_datetime,usm.interface_type,usm.name,usm.company_name,pm.purpose_name,'Un-Schedule' from unscheduled_req_master usm,purpose_master pm where usm.active='Y' and usm.purpose_id=pm.purpose_id and usm.indus_tower_id like ifnull("+indus_tower_id+",'%') and usm.unsme_mobile like ifnull("+sme_mobile+",'%') and usm.interface_type=ifnull("+interface_type+",usm.interface_type) and usm.sch_type=ifnull("+sme_schedule_type+",'U') and usm.name like ifnull("+sme_name+",'%') and usm.request_datetime between replace(ifnull("+from+",usm.request_datetime),'/','-') and replace(ifnull("+to+",usm.request_datetime),'/','-')";
	    		if(serviceprovider_id == 70)
	    			q="select sm.indus_tower_id, sm.sme_mobile,sm.request_datetime,sm.interface_type,sme.sme_name,spm.serviceprovider_name,pm.purpose_name,'Schedule' from scheduled_req_master sm,sme_master sme,serviceprovider_master spm,purpose_master pm where sm.sme_mobile=sme.sme_mobile and sme.serviceprovider_id=spm.serviceprovider_id and sm.purpose_id=pm.purpose_id and sm.indus_tower_id like ifnull("+indus_tower_id+",'%') and sm.sme_mobile like ifnull("+sme_mobile+",'%') and sm.interface_type=ifnull("+interface_type+",sm.interface_type) and sm.sch_type=ifnull("+sme_schedule_type+",'S') and sme.sme_name like ifnull("+sme_name+",'%') and spm.serviceprovider_id=ifnull("+company_name+",spm.serviceprovider_id) and sm.request_datetime between replace(ifnull("+from+",sm.request_datetime),'/','-') and replace(ifnull("+to+",sm.request_datetime),'/','-') union select usm.indus_tower_id, usm.unsme_mobile,usm.request_datetime,usm.interface_type,usm.name,usm.company_name,pm.purpose_name,'Un-Schedule' from unscheduled_req_master usm,purpose_master pm where usm.active='Y' and usm.purpose_id=pm.purpose_id and usm.indus_tower_id like ifnull("+indus_tower_id+",'%') and usm.unsme_mobile like ifnull("+sme_mobile+",'%') and usm.interface_type=ifnull("+interface_type+",usm.interface_type) and usm.sch_type=ifnull("+sme_schedule_type+",'U') and usm.name like ifnull("+sme_name+",'%') and usm.request_datetime between replace(ifnull("+from+",usm.request_datetime),'/','-') and replace(ifnull("+to+",usm.request_datetime),'/','-') order by 1 desc";
	    		else
	    			q="select sm.indus_tower_id, sm.sme_mobile,sm.request_datetime,sm.interface_type,sme.sme_name,spm.serviceprovider_name,pm.purpose_name,'Schedule' from scheduled_req_master sm,sme_master sme,serviceprovider_master spm,purpose_master pm where sm.sme_mobile=sme.sme_mobile and sme.serviceprovider_id=spm.serviceprovider_id and sm.purpose_id=pm.purpose_id and sm.indus_tower_id like ifnull("+indus_tower_id+",'%') and sm.sme_mobile like ifnull("+sme_mobile+",'%') and sm.interface_type=ifnull("+interface_type+",sm.interface_type) and sm.sch_type=ifnull("+sme_schedule_type+",'S') and sme.sme_name like ifnull("+sme_name+",'%') and spm.serviceprovider_id=ifnull("+company_name+",spm.serviceprovider_id) and sm.request_datetime between replace(ifnull("+from+",sm.request_datetime),'/','-') and replace(ifnull("+to+",sm.request_datetime),'/','-') and sme.serviceprovider_id = "+serviceprovider_id+" order by 1 desc";
	    		
	    		System.out.println("mahan query :: "+q);
	    		ResultSet rs=stmt.executeQuery(q);
	    		//System.out.println(q);
	    		while(rs.next())
	    		{
	    			ReportAction obj=new ReportAction();
	    			obj.setIndus_tower_id(rs.getString(1));
	    			obj.setUnsme_mobile(rs.getString(2));
	    			obj.setDatetime(rs.getString(3));
	    			obj.setInterface_type(rs.getString(4));
	    			obj.setName(rs.getString(5));
	    			obj.setCompany_name(rs.getString(6));
	    			obj.setPurpose_name(rs.getString(7));
	    			obj.setSme_type(rs.getString(8));

	    			ll.add(obj);	
	    		}
	    		con1.close();
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
