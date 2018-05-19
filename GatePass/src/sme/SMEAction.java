package sme;

import smetype.SMETypeInterface;
import smetype.SMETypePojo;
import user.UserInterface;
import user.UserPojo;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import district.DistrictInterface;
import district.DistrictPojo;

public class SMEAction extends ActionSupport
{

	private String sme_name;
	private int serviceprovider_id;
	private String serviceprovider_name;

	private int smetype_id;
	private String mobile;
	private int sme_id;


	private LinkedList sme_type_list;
	private LinkedList serviceprovider_list;
	private String smetype_name;
	
	private LinkedList sme_list=null;
	private String act="";
	private String status;
	private String outputtext = "";

	
	
	public String dummyLink() throws Exception 
	{
		String serviceprovider_id1=(String)ActionContext.getContext().getSession().get("serviceprovider_id");
		
		SMEInterface obj = new SMEPojo();
		UserInterface obj1 = new UserPojo();
		
		sme_type_list = obj.execute();//SME Type List
		serviceprovider_list = obj1.execute(2);//Service Provider type List
		sme_list=obj.generateSMEList(null,serviceprovider_id1);//SME List
		
		if(sme_type_list.size()==0)
		{
			outputtext = "Please Enter SME Type First.....";
			addActionMessage(outputtext);
			return "success";
		}
		else if(serviceprovider_list.size()==0 && serviceprovider_id1.equals("70"))
		{
			outputtext = "Please Enter Service Provider.....";
			addActionMessage(outputtext);
			return "success";
		}
		else if(sme_list.size()==0)
		{
			outputtext = "No SMEs.....";
			addActionMessage(outputtext);
			return "success";
		}
		else
		{
			return "success";
		}
		
	}

	public String Addition() throws Exception 
	{
		SMEInterface obj = new SMEPojo();
		UserInterface obj1 = new UserPojo();
		System.out.println("ACT : "+act);
		sme_type_list = obj.execute();//SME Type List
		serviceprovider_list = obj1.execute(2);//Service Provider type List
		
		String serviceprovider_id1=(String)ActionContext.getContext().getSession().get("serviceprovider_id");
		
		if(act.equals("Add")){
		int message = obj.addSME(mobile,sme_name,serviceprovider_id,smetype_id);
		sme_list=obj.generateSMEList(null,serviceprovider_id1);//SME Type List
		serviceprovider_id = -1;
		smetype_id = -1;
		sme_name = "";
		mobile = "";
		if (message == 1 )
		{
			outputtext = "SME Inserted Successfully.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if (message == 1001 )
		{
			outputtext = "WARNING!!!!! SME Mobile Number Already Present.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		else
		{
			outputtext = "Something Wrong Happened, Pls try after some time.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		}
		
		else if(act.equals("Save")){
			int message = obj.SMEModification(sme_id,mobile,sme_name,serviceprovider_id,smetype_id);
			sme_list=obj.generateSMEList(null,serviceprovider_id1);//SME Type List
			serviceprovider_id = -1;
			smetype_id = -1;
			sme_name = "";
			mobile = "";
			if (message == 1 )
			{
				outputtext = "SME Inserted Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else if (message == 1001 )
			{
				outputtext = "WARNING!!!!! SME Mobile Number Already Present.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else
			{
				outputtext = "Something Wrong Happened, Pls try after some time.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			}
		
		else if(act.equals("Delete?")){
			int message = obj.smeDeletion(sme_id);
			sme_list=obj.generateSMEList(null,serviceprovider_id1);//SME Type List
			serviceprovider_id = -1;
			smetype_id = -1;
			sme_name = "";
			mobile = "";
			if (message == 1 )
			{
				outputtext = "SME Inserted Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else if (message == 1001 )
			{
				outputtext = "WARNING!!!!! SME Mobile Number Already Present.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else
			{
				outputtext = "Something Wrong Happened, Pls try after some time.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			}
		
		else
			return "success";
	}
	
	public String generateSMEList() throws Exception
	{
		SMEInterface obj=new SMEPojo();
		UserInterface obj1 = new UserPojo();
		sme_list=obj.generateSMEList(null,null);
		sme_type_list = obj.execute();
		serviceprovider_list = obj1.execute(2);
		if ((sme_list != null) && (sme_type_list != null) && (serviceprovider_list != null))
			return "success";
		else
			return "home";
		
	}
	
	public String Search() throws Exception
	{
		System.out.println("In Search");
		SMEInterface obj=new SMEPojo();
		UserInterface obj1 = new UserPojo();
		sme_list=obj.generateSMEListHaddi(sme_name,mobile,serviceprovider_id,smetype_id);
		sme_type_list = obj.execute();
		serviceprovider_list = obj1.execute(2);
		return "success";
		
	}
	
	public int SMEModification(int sme_id,String mobile,String sme_name,int serviceprovider_id,int smetype_id) throws Exception
	{
		SMEInterface obj=new SMEPojo();
		
		//String actor=(String)ActionContext.getContext().getSession().get("name");
		//System.out.println("actor :: "+actor+" "+action+" "+status);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String ip=request.getRemoteAddr();
		
		int result=obj.SMEModification(sme_id,mobile,sme_name,serviceprovider_id,smetype_id);		
		
		return result;
	}
	
	public int SMEDeletion(int sme_id) throws Exception
	{
		SMEInterface obj=new SMEPojo();
		
		int result=obj.smeDeletion(sme_id);
	
		return result;
	}
	
	private String internalTrimming(String temp)
	{
		String a[]=temp.split(" ");
		String temp1="";
		for(int i=0;i<a.length;i++)
		{
			//System.out.println("look "+a[i]);
			if(!a[i].equals(""))
				temp1=temp1+" "+a[i];
				
		}
		return temp1.trim();
	}
	
	public void validate()
	   {
		
		SMEInterface obj = new SMEPojo();
		UserInterface obj1 = new UserPojo();
		
		sme_type_list = obj.execute();//SME Type List
		serviceprovider_list = obj1.execute(2);//Service Provider type List
		
		String serviceprovider_id1=(String)ActionContext.getContext().getSession().get("serviceprovider_id");
		sme_list=obj.generateSMEList(null,serviceprovider_id1);//SME Type List
		
			if(act.equals("Add")){
				
				if(sme_name.trim().equals(""))
				{
					addFieldError("sme_name","Please enter SME Name");
				}
				if(smetype_id==-1)
				{
					addFieldError("smetype_name","Please enter SME Type Name");
				}
				if(mobile.trim().equals(""))
				{
					addFieldError("mobile","Please enter Mobile Number");
				}
				
				if(serviceprovider_id1.equals("70"))
				{
					if(serviceprovider_id==-1)
					{
						addFieldError("serviceprovider_id","Please select Service Provider");
					}
				}
				
			}
	   }
	
	
	public String getSme_name() {
		return sme_name;
	}

	public void setSme_name(String sme_name) {
		this.sme_name = sme_name;
	}

	public int getServiceprovider_id() {
		return serviceprovider_id;
	}

	public void setServiceprovider_id(int serviceprovider_id) {
		this.serviceprovider_id = serviceprovider_id;
	}

	public String getServiceprovider_name() {
		return serviceprovider_name;
	}

	public void setServiceprovider_name(String serviceprovider_name) {
		this.serviceprovider_name = serviceprovider_name;
	}

	public int getSmetype_id() {
		return smetype_id;
	}

	public void setSmetype_id(int smetype_id) {
		this.smetype_id = smetype_id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getSme_id() {
		return sme_id;
	}

	public void setSme_id(int sme_id) {
		this.sme_id = sme_id;
	}

	public LinkedList getSme_type_list() {
		return sme_type_list;
	}

	public void setSme_type_list(LinkedList sme_type_list) {
		this.sme_type_list = sme_type_list;
	}

	
	public LinkedList getServiceprovider_list() {
		return serviceprovider_list;
	}

	public void setServiceprovider_list(LinkedList serviceprovider_list) {
		this.serviceprovider_list = serviceprovider_list;
	}

	public String getOutputtext() {
		return outputtext;
	}

	public void setOutputtext(String outputtext) {
		this.outputtext = outputtext;
	}

	public String getSmetype_name() {
		return smetype_name;
	}

	public void setSmetype_name(String smetype_name) {
		this.smetype_name = smetype_name;
	}

	public LinkedList getSme_list() {
		return sme_list;
	}

	public void setSme_list(LinkedList sme_list) {
		this.sme_list = sme_list;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
