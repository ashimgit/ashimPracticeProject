package gatekeeper;

import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import clustermanager.ClusterManagerInterface;
import clustermanager.ClusterManagerPojo;

import user.UserInterface;
import user.UserPojo;
import serviceprovider.*;
import state.StateInterface;
import state.StatePojo;

public class GateKeeperAction extends ActionSupport
{

	private int gatekeeper_id;

	private String gatekeeper_name;
	
	private int serviceprovider_id;
	private String serviceprovider_name;
	private String message_vs_table;
	private String act="";
	private String search="";

	private String mobile_no="";
	private LinkedList message1;
	private String gatekeeper_type;
	private String towerid;
	private String indus_tower_id="";
	private LinkedList gatekeeper_list=null;
	private LinkedList tower_list=null;
	private LinkedList serviceprovider_list=null;
	private String outputtext = "";
	
	public String dummyLink() throws Exception 
	{
		UserInterface obj1 = new UserPojo();
		serviceprovider_list = obj1.execute(2);// Getting Service Provider List
		
		GateKeeperInterface obj=new GateKeeperPojo();
		gatekeeper_list=obj.generateGateKeeperList(null,null);// Getting GateKeeper List
		
		
		if (serviceprovider_list.size()==0)
		{
			outputtext = "WARNING!!!!! No Service Providers present... Pls refer to Service Provider link.....";
			addActionMessage(outputtext);
			return "home";
		}
		
		else if (gatekeeper_list.size()==0 && serviceprovider_list.size()!=0)
		{
			outputtext = "WARNING!!!!! No Gatekeepers Present.....";
			addActionMessage(outputtext);
			return "success";
		}
		
		else if(serviceprovider_list.size()!=0 && gatekeeper_list.size()!=0)
		{
			return "success"; 
		}
		else
		{
			outputtext = "WARNING!!!!! Something Went Wrong.... Pls try again Later.....";
			addActionMessage(outputtext);		
			return "success";
		}
	}

	public String Addition() throws Exception 
	{
		UserInterface obj1 = new UserPojo();
		serviceprovider_list = obj1.execute(2);// Getting Service Provider List
		
		mobile_no = internalTrimming(mobile_no.trim());
		gatekeeper_name = internalTrimming(gatekeeper_name.trim());
		
		GateKeeperInterface obj=new GateKeeperPojo();
		
		
		if(act.equals("Add")){
			
		int message = obj.addGateKeeper(mobile_no,gatekeeper_name,gatekeeper_type,serviceprovider_id);
		gatekeeper_list=obj.generateGateKeeperList(null,null);// Getting GateKeeper List
		serviceprovider_id = -1;
		gatekeeper_type = "-1";
		gatekeeper_name = "";
		mobile_no = "";
		
		if (message == 1 )
		{
			outputtext = "GateKeeper Inserted Successfully.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if (message == 1001 )
		{
			outputtext = "WARNING!!!!! GateKeeper Mobile Number Already Present.....";
			return "success"; 
		}
		else
		{
			outputtext = "WARNING!!!!! Something Went Wrong.... Pls try again Later.....";
			addActionMessage(outputtext);		
			return "success";
		}
		}
		
		else if(act.equals("Save")){
			
		int message = obj.gateKeeperModification(gatekeeper_id,mobile_no,gatekeeper_name,gatekeeper_type,serviceprovider_id);
		gatekeeper_list=obj.generateGateKeeperList(null,null);// Getting GateKeeper List
		serviceprovider_id = -1;
		gatekeeper_type = "-1";
		gatekeeper_name = "";
		mobile_no = "";
		
		if (message == 1 )
		{
			outputtext = "GateKeeper Updated Successfully.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if (message == 1001 )
		{
			outputtext = "WARNING!!!!! GateKeeper Mobile Number Already Present.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		else
		{
			outputtext = "WARNING!!!!! Something Went Wrong.... Pls try again Later.....";
			addActionMessage(outputtext);		
			return "success";
		}
		}
		
		else if(act.equals("Delete?")){
			
			int message = obj.gateKeeperDeletion(gatekeeper_id);
			gatekeeper_list=obj.generateGateKeeperList(null,null);// Getting GateKeeper List
			serviceprovider_id = -1;
			gatekeeper_type = "-1";
			gatekeeper_name = "";
			mobile_no = "";
			
			if (message == 1 )
			{
				outputtext = "GateKeeper Deleted Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else
			{
				outputtext = "WARNING!!!!! Something Went Wrong.... Pls try again Later.....";
				addActionMessage(outputtext);		
				return "success";
			}
			}
		else
			return "success";
	}
	
	public String generateGateKeeperList() throws Exception
	{
		GateKeeperInterface obj=new GateKeeperPojo();
		gatekeeper_list=obj.generateGateKeeperList(null,null);
		
		ServiceProviderInterface obj1=new ServiceProviderPojo();
		serviceprovider_list=obj1.generateServiceProviderList(null,null);

		if (gatekeeper_list != null)
			return "success";
		else
			return "home";
		
	}
	
	public int gateKeeperDeletion(int gatekeeper_id) throws Exception
	{
		GateKeeperInterface obj=new GateKeeperPojo();
		int result=obj.gateKeeperDeletion(gatekeeper_id);
		
		return result;
	}
	
	public int gateKeeperModification(int gatekeeper_id,String mobile_no,String gatekeeper_name,String gatekeeper_type,int serviceprovider_id) throws Exception
	{
		GateKeeperInterface obj=new GateKeeperPojo();
		int result=obj.gateKeeperModification(gatekeeper_id,mobile_no,gatekeeper_name,gatekeeper_type,serviceprovider_id);
		return result;
	}
	
	public String Search() throws Exception
	{
		UserInterface obj1 = new UserPojo();
		serviceprovider_list = obj1.execute(2);
		
		GateKeeperInterface obj=new GateKeeperPojo();
		gatekeeper_list=obj.megeHuntGateKeeper(gatekeeper_id,mobile_no,gatekeeper_name,gatekeeper_type,serviceprovider_id);
		return "success";
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
			if(act.equals("Add")){
				

				UserInterface obj1 = new UserPojo();
				serviceprovider_list = obj1.execute(2);// Getting Service Provider List
				
				GateKeeperInterface obj=new GateKeeperPojo();
				gatekeeper_list=obj.generateGateKeeperList(null,null);// Getting GateKeeper List
				
				
				
				if(gatekeeper_name.trim().equals(""))
				{
					addFieldError("gatekeeper_name","Please enter Gatekeeper Name");
				}
				
				if(gatekeeper_type.trim().equals("-1"))
				{
					addFieldError("gatekeeper_type","Please select Gatekeeper Type");
				}
				
				if(serviceprovider_id==-1)
				{
					addFieldError("serviceprovider_id","Please select Service Provider");
				}
				
				if(mobile_no.trim().equals(""))
				{
					addFieldError("mobile_no","Please enter Mobile Number");
				}
				
			}
	   }
	
	
	public int getGatekeeper_id() {
		return gatekeeper_id;
	}

	public void setGatekeeper_id(int gatekeeper_id) {
		this.gatekeeper_id = gatekeeper_id;
	}

	public String getGatekeeper_name() {
		return gatekeeper_name;
	}

	public void setGatekeeper_name(String gatekeeper_name) {
		this.gatekeeper_name = gatekeeper_name;
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

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public LinkedList getMessage1() {
		return message1;
	}

	public void setMessage1(LinkedList message1) {
		this.message1 = message1;
	}

	public String getGatekeeper_type() {
		return gatekeeper_type;
	}

	public void setGatekeeper_type(String gatekeeper_type) {
		this.gatekeeper_type = gatekeeper_type;
	}

	public String getTowerid() {
		return towerid;
	}

	public void setTowerid(String towerid) {
		this.towerid = towerid;
	}

	public String getIndus_tower_id() {
		return indus_tower_id;
	}

	public void setIndus_tower_id(String indus_tower_id) {
		this.indus_tower_id = indus_tower_id;
	}

	public LinkedList getGatekeeper_list() {
		return gatekeeper_list;
	}

	public void setGatekeeper_list(LinkedList gatekeeper_list) {
		this.gatekeeper_list = gatekeeper_list;
	}

	public LinkedList getTower_list() {
		return tower_list;
	}

	public void setTower_list(LinkedList tower_list) {
		this.tower_list = tower_list;
	}

	public LinkedList getServiceprovider_list() {
		return serviceprovider_list;
	}

	public void setServiceprovider_list(LinkedList serviceprovider_list) {
		this.serviceprovider_list = serviceprovider_list;
	}

	public String getMessage_vs_table() {
		return message_vs_table;
	}

	public void setMessage_vs_table(String message_vs_table) {
		this.message_vs_table = message_vs_table;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getOutputtext() {
		return outputtext;
	}

	public void setOutputtext(String outputtext) {
		this.outputtext = outputtext;
	}

	
}
