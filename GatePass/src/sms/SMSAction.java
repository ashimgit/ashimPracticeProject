package sms;

import java.text.SimpleDateFormat;
import java.util.*;

import smetype.SMETypeInterface;
import smetype.SMETypePojo;

import com.opensymphony.xwork2.*;

import connection.*;
import district.DistrictInterface;
import district.DistrictPojo;

public class SMSAction extends ActionSupport
{
	private String indus_tower_id;
	private String mobile_no;
	private int purpose_id = 8;
	private LinkedList message;
	private LinkedList sme_details;
	private String purpose_name;
	private String purpose_code;
	private LinkedList check_tower_sp;
	private int tower_id;
	private String gatekeeper_mobile;
	private String clustermanager_mobile;
	private String interface_type="WEB";
	private String gatepass_no="G101";
	private String sms_generated="SMSTEST";
	private String name;
	private String company_name;
	private String sch_dt ="";
	private String sch_tm ="";
	private String datetimepicker = "";
	private int VitorType = 1;
	private String message_text = "NO Message due to WEB";
	private String outputtext = "";
	private String action = "";
	private String msg_txt = "";
	private ArrayList tower_supervisor = new ArrayList();
	
/*---------------------------- Example Of Scheduled Visitor SMS Format Starts -----------------------------

	http://184.106.63.136:8080/indus/JSPS/sms_INIDSE.jsp?mob=919758328346&text=INIDSE 0133333 11.05.2011 11.05 

	---------------------------- Example Of Scheduled Visitor SMS Format Ends --------------------------------- */
	
	public String execute() throws Exception 
	{
		SMSInterface obj = new SMSPojo();
		message = obj.execute(); // Getting Purpose List
		if (message != null)
			return "link";
		else
			return "home";
	}

	public String ScheduleSMS() throws Exception 
	{
		ArrayList toList = new ArrayList();
		SMSInterface obj1 = new SMSPojo();
		SMSEngine vd = new SMSEngine();
		message = obj1.execute(); // Getting Purpose List
				
/*-------------------------------------- Checking Indus Tower ID Starts -----------------------------------------*/

		check_tower_sp = obj1.check_tower_sp(indus_tower_id);
		int size = check_tower_sp.size();
		if (size == 0)
		{
			outputtext = "Tower Code Doesn't Exists";
			return "notvalid";
		}
		else 
		{	
			System.out.println("Level1 Pass/////////////Tower Exists");
			String gatekeeper_mobile = (String) check_tower_sp.get(1); //Getting Gate Keeper Number
			System.out.println("gatekeeper_mobile ==" +gatekeeper_mobile);
			
			String clustermanager_mobile = (String) check_tower_sp.get(2); //Getting Cluster Manager Number
			
			int district_id = (Integer) check_tower_sp.get(4); //Getting District ID
			
			String gatekeeper_name = (String) check_tower_sp.get(5); //Getting GateKeeper Name
			System.out.println("gatekeeper_name ==" +gatekeeper_name);
			
			if (gatekeeper_mobile.equals("0") )//|| clustermanager_mobile.equals("0")) // Gate Keeper or Cluster Manager Not Added
			{
				outputtext = "Gate Keeper Doesn't Exists";
				return "notvalid";
			} 
			else 
			{
				System.out.println("Level2 Pass/////////////Gate Keeper Exists");
				
				int flag = 1;
				
				int serviceprovider_id = obj1.getserviceprovider_id(mobile_no); //Getting Service Provider ID of SME
				System.out.println("serviceprovider_id of SME = "+serviceprovider_id);
				
				if(serviceprovider_id == 0)
					flag = 0; //Service Provider Not Present
				else
					flag = 1; //Service Provider Present
				
				String service_provider = (String) check_tower_sp.get(3); //Getting Service Provider ID of Tower
				System.out.println("service_provider of Tower = "+service_provider);
				
				//int a[] = {100};
				/*int i = 0;
				String[] parts = service_provider.split(",");
				int size1 = parts.length;
				System.out.println("size1"+size1);
				
				//String part1 = parts[0]; // 004
				//String part2 = parts[1]; // 034556
				int flag = 0;
				for(i = 0; i<= size1; i++)
				{	
					System.out.println("Integer.parseInt(parts[i]) == "+parts[i]);
					int part = Integer.parseInt(parts[i]);
					System.out.println("Part == "+part);
					
					if (part == serviceprovider_id) // Request Done for his/her own tower or not
					{
						System.out.println("Done");
						flag = 1;
						break;
					}
					else
					{
						System.out.println("Not Done");
						flag = 0;
						break;
					}
				}*/
				
				if(flag == 1)
				{
					
/* -------------------------- Generating GatePass Number Starts -------------------------------------------*/
					
					System.out.println("Level3 Pass/////////////Service Provider Exists");
					
					System.out.println("datetimepicker"+datetimepicker);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					Date date = formatter.parse(datetimepicker);
					System.out.println(date);
					
					
					java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateTime = sdf.format(date);
					System.out.println("dateTime----"+dateTime);
					
					System.out.println(formatter.format(date));
					String s = formatter.format(date);
					
					sch_dt=dateTime.substring(0,10);System.out.println("sch_dt======= "+sch_dt);
					sch_tm=dateTime.substring(11,16);System.out.println("sch_tm======= "+sch_tm);
					
					
/******************************* Generating GatePass ************************************************/					
					
					GenrateGatePass ob= new GenrateGatePass();
					String GatePass= ob.GetscheduledGatePass();
					System.out.println("GatePass======= "+GatePass);
					
/******************************* Generating GatePass ************************************************/
					
					sme_details = obj1.getsme_details(mobile_no);
					
					if(sme_details.size() == 0)
					{
						outputtext = "SME Doesn't Exists";
						return "notvalid";
					}
					else
					{
						System.out.println("Level4 Pass////////////////////SME Exists");
						String sme_name1 = (String) sme_details.get(0); // Getting SME Name
						String serviceprovider_name1 = (String) sme_details.get(1); // Getting SME's Service Provider Name
						String MessageSent = "";
					
						String purpose_name1 = obj1.getpurpose_name(purpose_id);
						MessageSent = ob.scheduledmsg(GatePass, indus_tower_id, sme_name1, mobile_no, serviceprovider_name1, sch_dt, sch_tm, purpose_name1, gatekeeper_name, gatekeeper_mobile);
						
						/*if(district_id == 21) // For KOLKATA
						{
							String purpose_name1 = obj1.getpurpose_name(purpose_id); 
							MessageSent = ob.scheduledtextmsg1(GatePass, indus_tower_id, sch_dt, sch_tm, purpose_name1, sme_name1,serviceprovider_name1,gatekeeper_mobile,mobile_no,gatekeeper_name);
						}
						else
						{
							MessageSent = ob.scheduledtextmsg2(GatePass, indus_tower_id, sch_dt, sch_tm,sme_name1,serviceprovider_name1,gatekeeper_mobile,mobile_no,gatekeeper_name);
						}*/
					
						System.out.println("MSG========= "+MessageSent);
						gatepass_no = GatePass;
						sms_generated = MessageSent;
					
/* -------------------------- Generating GatePass Number Ends -------------------------------------------*/
					
						tower_supervisor = obj1.tower_supervisor(indus_tower_id);
						System.out.println("tower_supervisor : " +tower_supervisor);
						for(int tower_supervisor_size = 0; tower_supervisor_size < tower_supervisor.size(); tower_supervisor_size++)
						{
							toList.add(tower_supervisor.get(tower_supervisor_size));
						}
						int addScheduleSMS = obj1.addScheduleSMS(indus_tower_id,mobile_no,dateTime,purpose_id,gatepass_no,sms_generated,interface_type,gatekeeper_mobile,clustermanager_mobile,message_text);
						if (addScheduleSMS > 0)
						{
							System.out.println("Level5 Pass////////////////////Inserted Into Scheduled_req_master Table");
							toList.add(mobile_no);
							toList.add(gatekeeper_mobile);
							toList.add(clustermanager_mobile);
						
/* -------------------------- Sending Confirmation SMS Starts -------------------------------------------*/
						
							if(toList.size()>1)
							{
								System.out.println("message sent");
							//int outputmessage = vd.sendSMS("Indus", toList, vd.encodeHTML(MessageSent));
							//System.out.println("outputmessage  "+outputmessage);
							
							//if(outputmessage == 007)
							//{
								vd.sendSMS("Indus", toList, vd.encodeHTML(MessageSent));
								outputtext = "GatePass Has Been Sent Successfully";
								return "success";
							//}
							/*else
							{
								outputtext = "GatePass Has Been Generated But Can't Be Sent Due To Some Problem In SMS Gateway";
						        return "notvalid";
							}*/
							}
							else
							{
								System.out.println("message not sent");
								outputtext = "Parameters Required GatePass Generation Not Found";
								return "notvalid";
					                 /*reply to message sender if he has put a wrong tower code*/
					        //vd.sendSMS("Indus", toList, vd.encodeHTML("Wrong Message sent"));
							}

/* -------------------------- Sending Confirmation SMS Ends -------------------------------------------*/
						
						
						}
						
						else
						{
							outputtext = "Record Not Inserted Into Database";
							return "notvalid";
						}
					}
				}
				else 
				{
					outputtext = "SME Doesn't Exists";
					return "notvalid";
				}
			}
		}
	}

	public String UnScheduleSMS() throws Exception 
	{
		SMSInterface obj1 = new SMSPojo();
		message = obj1.execute(); // Getting Purpose List
		
/* -------------------------- Generating GatePass Number Starts -------------------------------------------*/
		
		System.out.println("datetimepicker"+datetimepicker);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = formatter.parse(datetimepicker);
		System.out.println(date);
		
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = sdf.format(date);
		System.out.println("dateTime----"+dateTime);
		
/* -------------------------- Checking For Already Request Done or Not Starts ---------------------------------*/

		int checking = obj1.requestcheck(indus_tower_id,mobile_no,dateTime);
		if(checking == 0)
		{
/* -------------------------- Checking For Already Request Done or Not Ends -----------------------------------*/
		
			System.out.println(formatter.format(date));
			String s = formatter.format(date);
		
			sch_dt=dateTime.substring(0,10);
			sch_tm=dateTime.substring(11,16);
		
		
/* -------------------------- Generating GatePass Number Ends -------------------------------------------*/
		
			check_tower_sp = obj1.check_tower_sp(indus_tower_id);
			int size = check_tower_sp.size();
			if (size == 0)
			{
				outputtext = "Tower Code Doesn't Exists";
				return "notvalid";
			}
			else 
			{	
				System.out.println("Level1 Pass/////////////Tower Exists");
				String gatekeeper_mobile = (String) check_tower_sp.get(1);
				String clustermanager_mobile = (String) check_tower_sp.get(2);
				String gatekeeper_name = (String) check_tower_sp.get(5);
				if (gatekeeper_mobile.equals("0") )//|| clustermanager_mobile.equals("0")) // Gate Keeper or Cluster Manager Not Added
				{
					outputtext = "Gate Keeper Doesn't Exists";
					return "notvalid";
				} 
				else 
				{
					System.out.println("Level2 Pass/////////////Gate Keeper Exists");
					
					GenrateGatePass ob= new GenrateGatePass();
					String GatePass= ob.GetunscheduledGatePass();
					System.out.println("GatePass======= "+GatePass);
					
					/*String MessageSent = ob.scheduledtextmsg2(GatePass, indus_tower_id, sch_dt, sch_tm,name,company_name,gatekeeper_mobile,mobile_no,gatekeeper_name);
					System.out.println("MSG========= "+MessageSent);*/
				
					String purpose_name1 = obj1.getpurpose_name(purpose_id);
					String MessageSent = ob.scheduledmsg(GatePass, indus_tower_id, name, mobile_no, company_name, sch_dt, sch_tm, purpose_name1, gatekeeper_name, gatekeeper_mobile);
					System.out.println("MSG========= "+MessageSent);
					
					gatepass_no = GatePass;
					sms_generated = MessageSent;
				
					int addUnScheduleSMS = obj1.addUnScheduleSMS(indus_tower_id,mobile_no,dateTime,purpose_id,gatepass_no,sms_generated,interface_type,name,company_name,gatekeeper_mobile,clustermanager_mobile,message_text);
					if (addUnScheduleSMS > 0)
					{
						System.out.println("Level3 Pass////////////////////Inserted Into Un-Scheduled_req_master Table");
						outputtext = "GatePass Request Has Been Accepted Successfully & Has Been Sent For Approval";
						return "success";
					}
					else
					{
						outputtext = "Record Not Inserted Into Database";
						return "notvalid";
					}
		
				}
			}
		}
		else
		{
			outputtext = "Duplicate Request";
			return "notvalid";
		}
	}
	
	public String CancelSMS() throws Exception 
	{
		ArrayList toList = new ArrayList();
		SMSInterface obj1 = new SMSPojo();
		SMSEngine vd = new SMSEngine();
		
/*---------------------------- Checking GATEPASS No & Mobile No -------------------------------------------*/
		
		String gatepassindecimal=""+Long.parseLong(gatepass_no, 16);
		System.out.println("gatepassindecimal"+gatepassindecimal);
		
		VitorType=Integer.parseInt(gatepassindecimal.substring(6,7));
		System.out.println("VitorType===>"+VitorType);
		
		check_tower_sp = obj1.check_gatepass_no(gatepass_no,VitorType);
		int size = check_tower_sp.size();
		if (size == 0)
			return "notvalid";
		else 
		{
			String sme_mobile = (String) check_tower_sp.get(0);
			String gatekeeper_mobile = (String) check_tower_sp.get(1);
			String clustermanager_mobile = (String) check_tower_sp.get(2);
			int scheduled_id = (Integer) check_tower_sp.get(3);
			int addcancelSMS = obj1.addcancelSMS(scheduled_id,VitorType);
			if (addcancelSMS > 0)
			{
				toList.add(sme_mobile);
				toList.add(gatekeeper_mobile);
				toList.add(clustermanager_mobile);
						
/* -------------------------- Sending Confirmation SMS Starts -------------------------------------------*/
				String TextMsg="Gatepass:"+" "+gatepass_no+" "+"is Cancelled";
				if(toList.size()>1)
				{
					System.out.println("message sent");
					vd.sendSMS("Indus", toList, vd.encodeHTML(TextMsg));
					return "success";
				}
				else
				{
				    System.out.println("message not sent");
				    return "notvalid";
				   /*reply to message sender if he has put a wrong tower code*/
				   //vd.sendSMS("Indus", toList, vd.encodeHTML("Wrong Message sent"));
				}

/* -------------------------- Sending Confirmation SMS Ends -------------------------------------------*/
			}
			else
				return "notvalid";
		}
				
	}
	public String ConfirmSMS() throws Exception 
	{
		ArrayList toList = new ArrayList();
		SMSInterface obj1 = new SMSPojo();
		SMSEngine vd = new SMSEngine();
		
		String msg_txt="";
		String gatepassno="";
		String site_info="";		
		String txt="";
		String keyword="";
		int VitorType=1;//Schedule or Unschedule
		int begin=0;
		int end=0;
		int tm_id=0;
		int count=0;
		int flag=0;
		int visito_id=0;
		
/*---------------------------- Example Of Scheduled Visitor SMS Format Starts -----------------------------

http://184.106.63.136:8080/indus/JSPS/sms_INIDCN.jsp?mob=919758328346&text=INIDVC12345678910562 <piu meter reading>

---------------------------- Example Of Scheduled Visitor SMS Format Ends --------------------------------- */

				
/* -------------------------- Getting Message From SMS URL Starts ------------------------------------------*/
		
		
		msg_txt = gatepass_no;
		System.out.println("msg_txt"+msg_txt);
		
		

        for(int i=0;i<msg_txt.length();i++)
		{
			if(msg_txt.charAt(i)==' ')
			{
		  		count++;	 						System.out.println("count"+count);
		  		end=i;								System.out.println("end"+end);
		  		txt=msg_txt.substring(begin,end);	System.out.println("msg_txt"+txt);
			}
			if(count==1)
			{
		 		keyword=txt.trim();					System.out.println("keyword"+keyword);
		 		begin=end;							System.out.println("begin"+begin);
		 		flag=1;								System.out.println("flag"+flag);
			}
			if(count==2)
			{
				gatepassno=txt.trim();				System.out.println("gatepassno"+gatepassno);
				begin=end;							System.out.println("begin"+begin);
				flag=1;								System.out.println("flag"+flag);
			}
				
			if(flag==1)
			{
				site_info=msg_txt.substring(begin,msg_txt.length()).trim();
				System.out.println("<br><br>site_info=="+site_info);
			}
		}
        gatepassno = site_info;
		System.out.println("<br>keyword=="+keyword);
		System.out.println("<br>gatepassno=="+gatepassno);
		System.out.println("<br>visit_conf_txt=="+site_info);
		System.out.println("<br>VitorType=="+VitorType);
		
		
		//check schedule or unschedule and find gatepass no
		
		String gatepassindecimal=""+Long.parseLong(gatepassno, 16);
		System.out.println("gatepassindecimal"+gatepassindecimal);
		
		VitorType=Integer.parseInt(gatepassindecimal.substring(6,7));
		System.out.println("VitorType===>"+VitorType);
		//VitorType=Gatepass_No;
		//VitorType
		//end checking
/* -------------------------- Getting Message From SMS URL Ends -------------------------------------------*/
		
/* ----------------------- Checking & Insertion Into Database Starts ------------------------------------*/
		
		
            LinkedList check_tower_sp;
			check_tower_sp = obj1.check_gatepass_no(gatepassno, VitorType);
			int size = check_tower_sp.size();
			if (size == 0)
				return "notvalid";
			else 
			{
				String sme_mobile = (String) check_tower_sp.get(0);
				String gatekeeper_mobile = (String) check_tower_sp.get(1);
				String clustermanager_mobile = (String) check_tower_sp.get(2);
				int scheduled_id = (Integer) check_tower_sp.get(3);
				int addconfirmationSMS = obj1.addconfirmationSMS(scheduled_id, VitorType);
				if (addconfirmationSMS > 0)
				{
					toList.add(sme_mobile);
					toList.add(gatekeeper_mobile);
					toList.add(clustermanager_mobile);
						
/* -------------------------- Sending Confirmation SMS Starts -------------------------------------------*/
				String TextMsg="Visit for Gatepass:"+" "+gatepassno+" "+"has been Confirmed";
				if(toList.size()>1)
				{
					System.out.println("message sent");
					vd.sendSMS("Indus", toList, vd.encodeHTML(TextMsg));
					return "valid";
				}
				else
				{
				    System.out.println("message not sent");
				    return "notvalid";
				   /*reply to message sender if he has put a wrong tower code*/
				   //vd.sendSMS("Indus", toList, vd.encodeHTML("Wrong Message sent"));
				}

/* -------------------------- Sending Confirmation SMS Ends -------------------------------------------*/
			}
			else
				return "notvalid";
		}
/* ----------------------- Checking & Insertion Into Database Ends ------------------------------------*/


	}
	
	public String ScheduleSMSviamobile()
	{
		ArrayList toList = new ArrayList();
		SMSInterface obj1 = new SMSPojo();
		SMSEngine vd = new SMSEngine();
		interface_type="Mobile";
		mobile_no=mobile_no.substring(2,12);
		System.out.println("mobile_no:-"+mobile_no);
		System.out.println("msg_txt:-"+msg_txt);
		message_text = msg_txt;
		
		indus_tower_id=msg_txt.substring(7,14);
		sch_dt=msg_txt.substring(15,25);
		sch_tm=msg_txt.substring(26,31);
		System.out.println("indus_tower_id : "+indus_tower_id+"sch_dt : "+sch_dt+"sch_tm : "+sch_tm);
		
		
		
		check_tower_sp = obj1.check_tower_sp(indus_tower_id);
		int size = check_tower_sp.size();
		if (size == 0)
		{
			outputtext = "Tower Code Doesn't Exists";
			return "success";
		}
		else 
		{	
			System.out.println("Level1 Pass/////////////Tower Exists");
			String gatekeeper_mobile = (String) check_tower_sp.get(1); //Getting Gate Keeper Number
			System.out.println("gatekeeper_mobile ==" +gatekeeper_mobile);
			
			String clustermanager_mobile = (String) check_tower_sp.get(2); //Getting Cluster Manager Number
			
			int district_id = (Integer) check_tower_sp.get(4); //Getting District ID
			
			String gatekeeper_name = (String) check_tower_sp.get(5); //Getting GateKeeper Name
			System.out.println("gatekeeper_name ==" +gatekeeper_name);
			
			if (gatekeeper_mobile.equals("0") )//|| clustermanager_mobile.equals("0")) // Gate Keeper or Cluster Manager Not Added
			{
				outputtext = "Gate Keeper Doesn't Exists";
				return "success";
			} 
			else 
			{
				System.out.println("Level2 Pass/////////////Gate Keeper Exists");
				
				int flag = 1;
				
				int serviceprovider_id = obj1.getserviceprovider_id(mobile_no); //Getting Service Provider ID of SME
				System.out.println("serviceprovider_id of SME = "+serviceprovider_id);
				
				if(serviceprovider_id == 0)
					flag = 0; //Service Provider Not Present
				else
					flag = 1; //Service Provider Present
				
				String service_provider = (String) check_tower_sp.get(3); //Getting Service Provider ID of Tower
				System.out.println("service_provider of Tower = "+service_provider);
		
				if(flag == 1)
				{
					
/* -------------------------- Generating GatePass Number Starts -------------------------------------------*/
					
					System.out.println("Level3 Pass/////////////Service Provider Exists");
					
					String datepicker = msg_txt.substring(15,31);
					datetimepicker = sch_dt +" "+ sch_tm;
					System.out.println("datetimepicker == "+datetimepicker);
					String datetimepicker1 = datetimepicker;
					datetimepicker1 = datetimepicker1.substring(6,10)+"-"+datetimepicker1.substring(3,5)+"-"+datetimepicker1.substring(0,2)+" "+datetimepicker1.substring(11,13)+":"+datetimepicker1.substring(14,16)+":"+"00";
					System.out.println("datetimepicker1 == "+datetimepicker1);
					
					
					
/******************************* Generating GatePass ************************************************/					
					
					GenrateGatePass ob= new GenrateGatePass();
					String GatePass= ob.GetscheduledGatePass();
					System.out.println("GatePass======= "+GatePass);
					
/******************************* Generating GatePass ************************************************/
					
					sme_details = obj1.getsme_details(mobile_no);
					
					if(sme_details.size() == 0)
					{
						outputtext = "SME Doesn't Exists";
						return "success";
					}
					else
					{
						System.out.println("Level4 Pass////////////////////SME Exists");
						String sme_name1 = (String) sme_details.get(0); // Getting SME Name
						String serviceprovider_name1 = (String) sme_details.get(1); // Getting SME's Service Provider Name
						String MessageSent = "";
					
						/*if(district_id == 21) // For KOLKATA
						{
							LinkedList purpose = new LinkedList();
							int length = msg_txt.length();
							System.out.println("length"+length);
							String purpose_code = "";
							if(length < 34)
							{
								System.out.println("No Purpose Code");
								outputtext = "Purpose Code Not Found";
								return "success";
							}
							else
							{
								purpose_code = msg_txt.substring(32,length);
								System.out.println("purpose_code"+purpose_code);
							}
							purpose = obj1.purpose(purpose_code);
							Integer purpose_id1 = (Integer) purpose.get(0);
							String purpose_name1 = (String) purpose.get(1);
							MessageSent = ob.scheduledtextmsg1(GatePass, indus_tower_id, sch_dt, sch_tm, purpose_name1, sme_name1,serviceprovider_name1,gatekeeper_mobile,mobile_no,gatekeeper_name);
						}
						else
						{
							MessageSent = ob.scheduledtextmsg2(GatePass, indus_tower_id, sch_dt, sch_tm,sme_name1,serviceprovider_name1,gatekeeper_mobile,mobile_no,gatekeeper_name);
						}*/
					
						LinkedList purpose = new LinkedList();
						int length = msg_txt.length();
						System.out.println("length"+length);
						String purpose_code = "";
						if(length < 34)
						{
							System.out.println("No Purpose Code");
							outputtext = "Purpose Code Not Found";
							MessageSent = "Please Add Purpose Code";
							toList.add(mobile_no);
							vd.sendSMS("Indus", toList, vd.encodeHTML(MessageSent));
							return "success";
						}
						else
						{
							purpose_code = msg_txt.substring(32,length);
							System.out.println("purpose_code"+purpose_code);
						}
						purpose = obj1.purpose(purpose_code);
						String purpose_name1 = (String) purpose.get(1);
						MessageSent = ob.scheduledmsg(GatePass, indus_tower_id, sme_name1, mobile_no, serviceprovider_name1, sch_dt, sch_tm, purpose_name1, gatekeeper_name, gatekeeper_mobile);
						
						System.out.println("MSG========= "+MessageSent);
						gatepass_no = GatePass;
						sms_generated = MessageSent;
					
/* -------------------------- Generating GatePass Number Ends -------------------------------------------*/
					
						tower_supervisor = obj1.tower_supervisor(indus_tower_id);
						System.out.println("tower_supervisor : " +tower_supervisor);
						for(int tower_supervisor_size = 0; tower_supervisor_size < tower_supervisor.size(); tower_supervisor_size++)
						{
							toList.add(tower_supervisor.get(tower_supervisor_size));
						}
						
						int addScheduleSMS = obj1.addScheduleSMS(indus_tower_id,mobile_no,datetimepicker1,purpose_id,gatepass_no,sms_generated,interface_type,gatekeeper_mobile,clustermanager_mobile,message_text);
						if (addScheduleSMS > 0)
						{
							System.out.println("Level5 Pass////////////////////Inserted Into Scheduled_req_master Table");
							toList.add(mobile_no);
							toList.add(gatekeeper_mobile);
							toList.add(clustermanager_mobile);
						
/* -------------------------- Sending Confirmation SMS Starts -------------------------------------------*/
						
							if(toList.size()>1)
							{
								System.out.println("message sent");
							//int outputmessage = vd.sendSMS("Indus", toList, vd.encodeHTML(MessageSent));
							//System.out.println("outputmessage  "+outputmessage);
							
							//if(outputmessage == 007)
							//{
								vd.sendSMS("Indus", toList, vd.encodeHTML(MessageSent));
								outputtext = "GatePass Has Been Sent Successfully";
								return "success";
							//}
							/*else
							{
								outputtext = "GatePass Has Been Generated But Can't Be Sent Due To Some Problem In SMS Gateway";
						        return "notvalid";
							}*/
							}
							else
							{
								System.out.println("message not sent");
								outputtext = "Parameters Required GatePass Generation Not Found";
								return "success";
					                 /*reply to message sender if he has put a wrong tower code*/
					        //vd.sendSMS("Indus", toList, vd.encodeHTML("Wrong Message sent"));
							}

/* -------------------------- Sending Confirmation SMS Ends -------------------------------------------*/
						
						
						}
						
						else
						{
							outputtext = "Record Not Inserted Into Database";
							return "success";
						}
					}
				}
				else 
				{
					outputtext = "SME Doesn't Exists";
					return "success";
				}
			}
		}
	}
	
	public String UnScheduleSMSviamobile()
	{
		ArrayList toList = new ArrayList();
		SMSInterface obj1 = new SMSPojo();
		SMSEngine vd = new SMSEngine();
		interface_type = "Mobile";
		mobile_no = mobile_no.substring(2,12);
		msg_txt = msg_txt.trim();
		System.out.println("mobile_no:-"+mobile_no);
		System.out.println("msg_txt:-"+msg_txt);
		message_text = msg_txt;
		
		int begin=0;
		int end=0;
		int tm_id=0;
		int count=0;
		int flag=0;	
		String keyword="";
		String txt="";
		String com_name="";
		String visitor_name="";	
		
		for(int i=0;i<msg_txt.length();i++)
		{
			if(msg_txt.charAt(i)==' ')
			{
				count++;	 
				end=i;
				txt=msg_txt.substring(begin,end);
			}
			
			if(count==1)
			{
				keyword=txt.trim();
				begin=end;
			}
		
			if(count==2)
			{
				indus_tower_id=txt.trim();
				begin=end;
			}
		
			if(count==3)
			{
				sch_dt=txt.trim();
				begin=end;
			}
		
			if(count==4)
			{
				sch_tm=txt.trim();
				begin=end;
			}
		
			if(count==5)
			{
				com_name=txt.trim();
				begin=end;
				//flag=1;
			}
			
			if(count==6)
			{
				visitor_name=txt.trim();
				begin=end;
				flag=1;
			}
		
			if(flag==1)
			{
				purpose_name = msg_txt.substring(begin,msg_txt.length()).trim();
				//begin=end;
				break;
			}
		
		}
		
		System.out.println("indus_tower_id"+indus_tower_id+"sch_dt"+sch_dt+"sch_tm"+sch_tm+"com_name"+com_name+"name"+visitor_name);
		
		datetimepicker = sch_dt +" "+ sch_tm;
		System.out.println("datetimepicker"+datetimepicker);
		String datetimepicker1 = datetimepicker;
		datetimepicker1 = datetimepicker1.substring(6,10)+"-"+datetimepicker1.substring(3,5)+"-"+datetimepicker1.substring(0,2)+" "+datetimepicker1.substring(11,13)+":"+datetimepicker1.substring(14,16)+":"+"00";
		
/* -------------------------- Checking For Already Request Done or Not Starts ---------------------------------*/

		int checking = obj1.requestcheck(indus_tower_id,mobile_no,datetimepicker1);
		System.out.println("checking"+checking);
		if(checking == 0)
		{
/* -------------------------- Checking For Already Request Done or Not Ends -----------------------------------*/
		
			name =  visitor_name;
			company_name = com_name;
			
			
			check_tower_sp = obj1.check_tower_sp(indus_tower_id);
			int size = check_tower_sp.size();
			System.out.println("size====" +size);
			if (size == 0)
			{
				outputtext = "Tower Code Doesn't Exists";
				return "success";
			}
			else 
			{	
				System.out.println("Level1 Pass/////////////Tower Exists");
				String gatekeeper_mobile = (String) check_tower_sp.get(1);
				String clustermanager_mobile = (String) check_tower_sp.get(2);
				String gatekeeper_name = (String) check_tower_sp.get(5);
				if (gatekeeper_mobile.equals("0") )//|| clustermanager_mobile.equals("0")) // Gate Keeper or Cluster Manager Not Added
				{
					outputtext = "Gate Keeper Doesn't Exists";
					return "success";
				}  
				else 
				{
					System.out.println("Level2 Pass/////////////Gate Keeper Exists");
					GenrateGatePass ob= new GenrateGatePass();
					String GatePass= ob.GetunscheduledGatePass();
					System.out.println("GatePass======= "+GatePass);
					
					/*String MessageSent = ob.scheduledtextmsg2(GatePass, indus_tower_id, sch_dt, sch_tm,visitor_name,com_name,gatekeeper_mobile,mobile_no,gatekeeper_name);
					//String MessageSent = ob.unscheduledtextmsg(GatePass, indus_tower_id, sch_dt, sch_tm, visitor_name, com_name);
					System.out.println("MSG========= "+MessageSent);*/
					
					System.out.println("purpose_name : "+purpose_name);
					LinkedList purpose = new LinkedList();
					if(purpose_name == null)
					{
						System.out.println("No Purpose Code");
						outputtext = "Purpose Code Not Found";
						String MessageSent = "Please Add Purpose Code";
						toList.add(mobile_no);
						vd.sendSMS("Indus", toList, vd.encodeHTML(MessageSent));
						return "success";
					}
					else
					{
						purpose_code = purpose_name;
						System.out.println("purpose_code"+purpose_code);
					}
					purpose = obj1.purpose(purpose_code);
					Integer purpose_id1 = (Integer) purpose.get(0);
					String purpose_name1 = (String) purpose.get(1);
					String MessageSent = ob.scheduledmsg(GatePass, indus_tower_id, visitor_name, mobile_no, com_name, sch_dt, sch_tm, purpose_name1, gatekeeper_name, gatekeeper_mobile);
					
					System.out.println("MSG========= "+MessageSent);
					
					
					int addUnScheduleSMS = obj1.addUnScheduleSMS(indus_tower_id,mobile_no,datetimepicker1,purpose_id1,GatePass,MessageSent,interface_type,name,company_name,gatekeeper_mobile,clustermanager_mobile,message_text);
					System.out.println("addUnScheduleSMS"+addUnScheduleSMS);
					if (addUnScheduleSMS > 0)
					{
						System.out.println("Level3 Pass////////////////////Inserted Into Un-Scheduled_req_master Table");
						outputtext = "GatePass Request Has Been Accepted Successfully & Has Been Sent For Approval";
						return "success";
					}
					else
					{
						outputtext = "Record Not Inserted Into Database";
						return "success";
					}
		
				}
			}
		}
		else
		{
			outputtext = "Duplicate Request";
			return "success";
		}
	}

	public void validate()
	{
			if(action.equals("1"))
			{
				System.out.println("Scheduled MSG Validation");
				SMSInterface obj = new SMSPojo();
				message = obj.execute(); // Getting Purpose List
				
				if (indus_tower_id.trim().equals(""))
				{
					addFieldError("indus_tower_id","Please Enter Tower Id");
				}
				else if(indus_tower_id.trim().length() != 7)
				{
						addFieldError("indus_tower_id","Please Enter Correct Tower Id");
				}
				
				if (mobile_no.trim().equals(""))
				{
					addFieldError("mobile_no","Please Enter Mobile Number");
				}
				else if(mobile_no.trim().length() != 10)
				{
					addFieldError("mobile_no","Please Enter Correct Mobile Number");
				}
				
				if (purpose_id == 8)
				{
					addFieldError("purpose_id","Please Select A Purpose");
				}
				
				if (datetimepicker.trim().equals(""))
				{
					addFieldError("datetimepicker","Please Select DateTime");
				}
			}
			else if(action.equals("2"))
			{
				System.out.println("UnScheduled MSG Validation");
				
				if (indus_tower_id.trim().equals(""))
				{
					addFieldError("indus_tower_id","Please Enter Tower Id");
				}
				else if(indus_tower_id.trim().length() != 7)
				{
						addFieldError("indus_tower_id","Please Enter Correct Tower Id");
				}
				
				if (mobile_no.trim().equals(""))
				{
					addFieldError("mobile_no","Please Enter Mobile Number");
				}
				else if(mobile_no.trim().length() != 10)
				{
					addFieldError("mobile_no","Please Enter Correct Mobile Number");
				}
				
				if (name.trim().equals(""))
				{
					addFieldError("name","Please Enter Name");
				}
				
				if (company_name.trim().equals(""))
				{
					addFieldError("company_name","Please Enter Company Name");
				}
				
				if (datetimepicker.trim().equals(""))
				{
					addFieldError("datetimepicker","Please Select DateTime");
				}
			}
	 }
	
	public String getIndus_tower_id() {
		return indus_tower_id;
	}

	public void setIndus_tower_id(String indus_tower_id) {
		this.indus_tower_id = indus_tower_id;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public int getPurpose_id() {
		return purpose_id;
	}

	public void setPurpose_id(int purpose_id) {
		this.purpose_id = purpose_id;
	}

	public LinkedList getMessage() {
		return message;
	}

	public void setMessage(LinkedList message) {
		this.message = message;
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

	public int getTower_id() {
		return tower_id;
	}

	public void setTower_id(int tower_id) {
		this.tower_id = tower_id;
	}

	public String getGatekeeper_mobile() {
		return gatekeeper_mobile;
	}

	public void setGatekeeper_mobile(String gatekeeper_mobile) {
		this.gatekeeper_mobile = gatekeeper_mobile;
	}

	public String getClustermanager_mobile() {
		return clustermanager_mobile;
	}

	public void setClustermanager_mobile(String clustermanager_mobile) {
		this.clustermanager_mobile = clustermanager_mobile;
	}

	public String getInterface_type() {
		return interface_type;
	}

	public void setInterface_type(String interface_type) {
		this.interface_type = interface_type;
	}

	public String getGatepass_no() {
		return gatepass_no;
	}

	public void setGatepass_no(String gatepass_no) {
		this.gatepass_no = gatepass_no;
	}

	public String getSms_generated() {
		return sms_generated;
	}

	public void setSms_generated(String sms_generated) {
		this.sms_generated = sms_generated;
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

	public String getSch_dt() {
		return sch_dt;
	}

	public void setSch_dt(String sch_dt) {
		this.sch_dt = sch_dt;
	}

	public String getSch_tm() {
		return sch_tm;
	}

	public void setSch_tm(String sch_tm) {
		this.sch_tm = sch_tm;
	}

	public String getDatetimepicker() {
		return datetimepicker;
	}

	public void setDatetimepicker(String datetimepicker) {
		this.datetimepicker = datetimepicker;
	}

	public int getVitorType() {
		return VitorType;
	}

	public void setVitorType(int vitorType) {
		VitorType = vitorType;
	}

	public String getPurpose_code() {
		return purpose_code;
	}

	public void setPurpose_code(String purpose_code) {
		this.purpose_code = purpose_code;
	}

	public LinkedList getSme_details() {
		return sme_details;
	}

	public void setSme_details(LinkedList sme_details) {
		this.sme_details = sme_details;
	}

	public String getMessage_text() {
		return message_text;
	}

	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}

	public String getOutputtext() {
		return outputtext;
	}

	public void setOutputtext(String outputtext) {
		this.outputtext = outputtext;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMsg_txt() {
		return msg_txt;
	}

	public void setMsg_txt(String msg_txt) {
		this.msg_txt = msg_txt;
	}

	public ArrayList getTower_supervisor() {
		return tower_supervisor;
	}

	public void setTower_supervisor(ArrayList tower_supervisor) {
		this.tower_supervisor = tower_supervisor;
	}
	

	
	
}
