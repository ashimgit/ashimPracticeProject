package approval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.*;

import sme.SMEInterface;
import sme.SMEPojo;
import sms.SMSInterface;
import sms.SMSPojo;
import user.UserInterface;
import user.UserPojo;

import com.opensymphony.xwork2.*;

import connection.SMSEngine;
import connection.connection;

public class ApprovalAction extends ActionSupport
{
	private LinkedList message;
	private LinkedList message1;
	private LinkedList message2;
	private int sme_id;
	private String sme_mobile;
	private String sme_name;
	private String smetype_name;
	private String serviceprovider_name;
	private String user_id;
	private int unscheduled_req_id;
	private String indus_tower_id;
	private String unsme_mobile;
	private String datetime;
	private String interface_type;
	private String name;
	private String company_name;
	private String purpose_name;
	private LinkedList check_tower_sp;
	private LinkedList getunscheduledsmedetails;
	private String messagesent;
	private String gatepass;
	private String smsgenerated;
	private ArrayList tower_supervisor = new ArrayList();
	
	public String dummyLink() throws Exception {
		
		ApprovalInterface obj = new ApprovalPojo();
		SMEInterface obj2=new SMEPojo();
		UserInterface obj1 = new UserPojo();
		
		//message2 = obj2.execute();//SME Type
		//message1 = obj1.execute(2);//Service Provider type
		message = obj.execute();
		
		/*if ((message != null) && (message2 != null) && (message1 != null))
			return "success";
		else
			return "home";*/
		if(message.size()==0){
			addActionMessage("No SME Joining Requests.....");
			return "home";
		}
		else
			return "success";
	}

	public String SMEVisitApprovalList() throws Exception {
		ApprovalInterface obj = new ApprovalPojo();
		message = obj.fetchSMEVisitList();
		if(message.size()==0)
		{
			addActionMessage("No SME Visit Requests.....");
			return "home";
		}
		
		else{
			return "success";
		}
	}

	public String approvalSME() throws Exception {
		user_id = ActionContext.getContext().getSession().get("userid")
				.toString();
		
		ApprovalInterface obj = new ApprovalPojo();
		int message1 = obj.SMEApproval(sme_id);
		ApprovalInterface obj1 = new ApprovalPojo();
		message = obj1.execute();
		
		if (message1 > 0){
			addActionMessage("Joining Request has been Approved.....");
			return "success";
		}
		else{
			addActionMessage("Approval Failed, Pls try after sometime.....");
			return "success";
		}
	}
	
	public String approvalAllSME() throws Exception {
		
		ApprovalInterface obj = new ApprovalPojo();
		int message1 = obj.approvalAllSME();
		message = obj.execute();
		
		if (message1 > 0){
			addActionMessage("All Joining Requests has been Approved.....");
			return "success";
		}
		else{
			addActionMessage("Approval Failed, Pls try after sometime.....");
			return "success";
		}
	}
	
	

	public String SMEVisitApproval() throws Exception
	 { 
		ArrayList toList = new ArrayList();
		
		SMSInterface obj1 = new SMSPojo();
		ApprovalInterface obj=new ApprovalPojo();
		UserInterface obj2 = new UserPojo();
		
		message = obj.fetchSMEVisitList();

		message1 = obj2.execute(2);//Service Provider type
		SMSEngine vd = new SMSEngine();
		
		getunscheduledsmedetails = obj.getsmedetails(unscheduled_req_id);
		
		String indus_tower_id1 = (String) getunscheduledsmedetails.get(0);
		String sme_mobile1 = (String) getunscheduledsmedetails.get(1);
		String messagesent1 = (String) getunscheduledsmedetails.get(2);
		
		check_tower_sp = obj1.check_tower_sp(indus_tower_id1);
		int size = check_tower_sp.size();
		System.out.println("********size :: "+size);
		if (size == 0){
			addActionMessage("SMS Sending Failed.....");
			return "success";
		}
		else 
		{
			String gatekeeper_mobile = (String) check_tower_sp.get(1);
			String clustermanager_mobile = (String) check_tower_sp.get(2);
			if (gatekeeper_mobile.equals("0") )
			{
				addActionMessage("SMS Sending Failed.....");
				return "success";			
			}
			
			else 
			{
				user_id= ActionContext.getContext().getSession().get("userid").toString();
				int message1=obj.SMEVisitApproval(unscheduled_req_id,user_id);
				System.out.println("***********message1 :: "+message1);
				if (message1 > 0)
				{
					
					tower_supervisor = obj1.tower_supervisor(indus_tower_id1);
					System.out.println("tower_supervisor : " +tower_supervisor);
					for(int tower_supervisor_size = 0; tower_supervisor_size < tower_supervisor.size(); tower_supervisor_size++)
					{
						toList.add(tower_supervisor.get(tower_supervisor_size));
					}
					
					toList.add(sme_mobile1);
					toList.add(gatekeeper_mobile);
					toList.add(clustermanager_mobile);
		
/* -------------------------- Sending Confirmation SMS Starts -------------------------------------------*/
		
					if(toList.size()>1)
					{
						System.out.println("message sent");
						vd.sendSMS("Indus", toList, vd.encodeHTML(messagesent1));
						message = obj.fetchSMEVisitList();
						return "success";
					}
					else
					{
						System.out.println("message not sent");
						addActionMessage("SMS Sending Failed.....");
						return "success";
	                 /*reply to message sender if he has put a wrong tower code*/
	        //vd.sendSMS("Indus", toList, vd.encodeHTML("Wrong Message sent"));
					}

/* -------------------------- Sending Confirmation SMS Ends -------------------------------------------*/
		
		
				}
				
				else{
					addActionMessage("SMS Sending Failed.....");
					return "success";
				}
					
			}
		}
	}

	public String SMEVisitApprovalall() throws Exception
	 { 
		SMSInterface obj1 = new SMSPojo();
		ApprovalInterface obj=new ApprovalPojo();
		SMSEngine vd = new SMSEngine();
		int flag = 0;
		connection con9=new connection();
		Connection ov=con9.Connect();
		try{
    			Statement stmt=ov.createStatement();
    			String q="select u.unscheduled_req_id,u.indus_tower_id,u.unsme_mobile,u.sms_generated,u.gatekeeper_mobile,u.clustermanager_mobile from unscheduled_req_master as u where u.active= 'N' ";
    			ResultSet rs=stmt.executeQuery(q);
    			while(rs.next())
    			{
    				ArrayList toList = new ArrayList();

    				
    				toList.clear();
    				int unscheduled_req_id = rs.getInt(1);System.out.println("unscheduled_req_id=="+unscheduled_req_id);
    				String indus_tower_id1 = rs.getString(2);System.out.println("indus_tower_id1=="+indus_tower_id1);
    				String sme_mobile1 = rs.getString(3);System.out.println("sme_mobile1=="+sme_mobile1);
    				String messagesent1 = rs.getString(4);System.out.println("messagesent1=="+messagesent1);
		
    				check_tower_sp = obj1.check_tower_sp(indus_tower_id1);
    				int size = check_tower_sp.size();

    				if (size == 0){
    					addActionMessage("SMS sending for "+sme_mobile1+" failed.....");
    					flag = 0;
    				}

    				else 
    				{
    					String gatekeeper_mobile = (String) check_tower_sp.get(1);
    					String clustermanager_mobile = (String) check_tower_sp.get(2);
    					if (gatekeeper_mobile.equals("0") )//|| clustermanager_mobile.equals("0")) // Gate Keeper or Cluster Manager Not Added
    					{
        					addActionMessage("SMS sending for "+sme_mobile1+" failed.....");
    						flag = 0;
    					} 
    					else 
    					{	System.out.println("size =="+size);
    						user_id= ActionContext.getContext().getSession().get("userid").toString();
    						int message1=obj.SMEVisitApproval(unscheduled_req_id,user_id);
    						System.out.println("message1 =="+message1);
    						if (message1 > 0)
    						{
    							tower_supervisor = obj1.tower_supervisor(indus_tower_id1);
    							System.out.println("tower_supervisor : " +tower_supervisor);
    							for(int tower_supervisor_size = 0; tower_supervisor_size < tower_supervisor.size(); tower_supervisor_size++)
    							{
    								toList.add(tower_supervisor.get(tower_supervisor_size));
    							}
    							
    							toList.add(sme_mobile1);
    							toList.add(gatekeeper_mobile);
    							toList.add(clustermanager_mobile);
		
/* -------------------------- Sending Confirmation SMS Starts -------------------------------------------*/
		
    							if(toList.size()>1)
    							{
    								System.out.println("message sent");
    								vd.sendSMS("Indus", toList, vd.encodeHTML(messagesent1));
    								flag = 1;
    								//TimeUnit.SECONDS.sleep(40);
    								//toList.clear();
    								//return "success";
    							}
    							else
    							{
    								System.out.println("message not sent");
    		    					addActionMessage("SMS sending for "+sme_mobile1+" failed.....");

    								//return "notvalid";
	                 /*reply to message sender if he has put a wrong tower code*/
	        //vd.sendSMS("Indus", toList, vd.encodeHTML("Wrong Message sent"));
    							}

/* -------------------------- Sending Confirmation SMS Ends -------------------------------------------*/
		
		
    						}
    						else{
    							return "success";
    						}
    					}
    				}
    			}
    			ov.close();
		}
    	catch(Exception e){System.out.println(e);}
		
		finally{
			return "success";
		}
	}
	
	
	public LinkedList getMessage() {
		return message;
	}

	public void setMessage(LinkedList message) {
		this.message = message;
	}

	public int getSme_id() {
		return sme_id;
	}

	public void setSme_id(int sme_id) {
		this.sme_id = sme_id;
	}

	public String getSme_mobile() {
		return sme_mobile;
	}

	public void setSme_mobile(String sme_mobile) {
		this.sme_mobile = sme_mobile;
	}

	public String getSme_name() {
		return sme_name;
	}

	public void setSme_name(String sme_name) {
		this.sme_name = sme_name;
	}

	public String getSmetype_name() {
		return smetype_name;
	}

	public void setSmetype_name(String smetype_name) {
		this.smetype_name = smetype_name;
	}

	public String getServiceprovider_name() {
		return serviceprovider_name;
	}

	public void setServiceprovider_name(String serviceprovider_name) {
		this.serviceprovider_name = serviceprovider_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getUnscheduled_req_id() {
		return unscheduled_req_id;
	}

	public void setUnscheduled_req_id(int unscheduled_req_id) {
		this.unscheduled_req_id = unscheduled_req_id;
	}

	public String getIndus_tower_id() {
		return indus_tower_id;
	}

	public void setIndus_tower_id(String indus_tower_id) {
		this.indus_tower_id = indus_tower_id;
	}

	public String getUnsme_mobile() {
		return unsme_mobile;
	}

	public void setUnsme_mobile(String unsme_mobile) {
		this.unsme_mobile = unsme_mobile;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getInterface_type() {
		return interface_type;
	}

	public void setInterface_type(String interface_type) {
		this.interface_type = interface_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getPurpose_name() {
		return purpose_name;
	}

	public void setPurpose_name(String purpose_name) {
		this.purpose_name = purpose_name;
	}

	public LinkedList getCheck_tower_sp() {
		return check_tower_sp;
	}

	public void setCheck_tower_sp(LinkedList check_tower_sp) {
		this.check_tower_sp = check_tower_sp;
	}

	public LinkedList getGetunscheduledsmedetails() {
		return getunscheduledsmedetails;
	}

	public void setGetunscheduledsmedetails(LinkedList getunscheduledsmedetails) {
		this.getunscheduledsmedetails = getunscheduledsmedetails;
	}

	public String getMessagesent() {
		return messagesent;
	}

	public void setMessagesent(String messagesent) {
		this.messagesent = messagesent;
	}

	public String getGatepass() {
		return gatepass;
	}

	public void setGatepass(String gatepass) {
		this.gatepass = gatepass;
	}

	public String getSmsgenerated() {
		return smsgenerated;
	}

	public void setSmsgenerated(String smsgenerated) {
		this.smsgenerated = smsgenerated;
	}

	public LinkedList getMessage1() {
		return message1;
	}

	public void setMessage1(LinkedList message1) {
		this.message1 = message1;
	}

	public LinkedList getMessage2() {
		return message2;
	}

	public void setMessage2(LinkedList message2) {
		this.message2 = message2;
	}
	public ArrayList getTower_supervisor() {
		return tower_supervisor;
	}

	public void setTower_supervisor(ArrayList tower_supervisor) {
		this.tower_supervisor = tower_supervisor;
	}
}
