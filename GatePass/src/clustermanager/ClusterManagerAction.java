package clustermanager;


import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import serviceprovider.ServiceProviderInterface;
import serviceprovider.ServiceProviderPojo;

import com.opensymphony.xwork2.ActionSupport;

public class ClusterManagerAction extends ActionSupport{
	
private String clustermanager_name;
private int clustermanager_id;

private String mobile_no;
private String towerid = "IN-007" ;
private String indus_tower_id="";
private LinkedList clustermanager_list=null;
private LinkedList tower_list=null;
private String outputtext = "";
private String act="";

	public String dummyLink() throws Exception
	 { 
		ClusterManagerInterface obj=new ClusterManagerPojo();
		clustermanager_list=obj.generateClusterManagerList(null,null);//Getting Cluster Manager List
		
		if(clustermanager_list.size()==0)
		{
			outputtext="No Cluster Managers.....";
			addActionMessage(outputtext);
			return "success";
		}
		else
		{
			//outputtext = "Here is the List.....";
			//addActionMessage(outputtext);
			return "success";
		}	
	 } 
	
	public String Addition() throws Exception
	 { 
		ClusterManagerInterface obj=new ClusterManagerPojo();
		
		mobile_no=internalTrimming(mobile_no.trim());
		clustermanager_name = internalTrimming(clustermanager_name.trim());
		
		if(act.equals("Add")){
		int message=obj.addClusterManager(mobile_no,clustermanager_name);
		clustermanager_name = "";
		mobile_no = "";
		clustermanager_list=obj.generateClusterManagerList(null,null);//Getting Cluster Manager List
		
		if (message == 1 )
		{
			outputtext = "Cluster Manager Inserted Successfully.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if (message == 1001 )
		{
			outputtext = "Warning!!!!!! Cluster Manager Mobile No. Already Present.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		else
		{
			outputtext = "WARNING!!!!!!!!!! Something Went Wrong, Please try again later........";
			addActionMessage(outputtext);
			return "success"; 
		}
		}
		
		else if(act.equals("Save")){
			int message=obj.clusterManagerModification(clustermanager_id,mobile_no,clustermanager_name);
			clustermanager_name = "";
			mobile_no = "";
			clustermanager_list=obj.generateClusterManagerList(null,null);//Getting Cluster Manager List
			
			if (message == 1 )
			{
				outputtext = "Cluster Manager Updated Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else if (message == 1001 )
			{
				outputtext = "Warning!!!!!! Cluster Manager Mobile No. Already Present.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else
			{
				outputtext = "WARNING!!!!!!!!!! Something Went Wrong, Please try again later........";
				addActionMessage(outputtext);
				return "success"; 
			}
			}
		
		else if(act.equals("Delete?")){
			int message=obj.clustermanagerDeletion(clustermanager_id);
			clustermanager_name = "";
			mobile_no = "";
			clustermanager_list=obj.generateClusterManagerList(null,null);//Getting Cluster Manager List
			
			if (message == 1 )
			{
				outputtext = "Cluster Manager Deleted Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else
			{
				outputtext = "WARNING!!!!!!!!!! Something Went Wrong, Please try again later........";
				addActionMessage(outputtext);
				return "success"; 
			}
			}
		
		else
			return "success";
	}
	
	public String generateClusterManagerList() throws Exception
	{
		ClusterManagerInterface obj=new ClusterManagerPojo();
		clustermanager_list=obj.generateClusterManagerList(null,null);

		if (clustermanager_list != null)
			return "success";
		else
			return "home";
		
	}
	
	
	
	public String Search() throws Exception
	{
		ClusterManagerPojo obj=new ClusterManagerPojo();
		clustermanager_list=obj.search(mobile_no,clustermanager_name);
		if(clustermanager_list.size()==0)
			addActionMessage("No Cluster Managers Found According to searching criteria.....");
		return "success";
		
		
	}
	
	
	public int clustermanagerDeletion(int clustermanagerDeletion) throws Exception
	{
		System.out.println("in clustermanager deletion "+clustermanager_id);
		ClusterManagerInterface obj=new ClusterManagerPojo();
		int result=obj.clustermanagerDeletion(clustermanager_id);
		
		
		return result;
	}
	
	public int clusterManagerModification(int clustermanager_id,String mobile_no,String clustermanager_name) throws Exception
	{
		System.out.println("in clustermanager modification "+clustermanager_id+" "+mobile_no+" "+clustermanager_name);
		ClusterManagerInterface obj=new ClusterManagerPojo();
		int result=obj.clusterManagerModification(clustermanager_id,mobile_no,clustermanager_name);
		
		
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
			if(act.equals("Add")){
				
				ClusterManagerInterface obj=new ClusterManagerPojo();
				clustermanager_list=obj.generateClusterManagerList(null,null);//Getting Cluster Manager List
				
				
				if(clustermanager_name.trim().equals(""))
				{
					addFieldError("clustermanager_name","Please enter Cluster Manager Name");
				}
				if(mobile_no.trim().equals(""))
				{
					addFieldError("mobile_no","Please enter Cluster Manager Mobile Number");
				}
				
				
			}
	   }
	

	public String getClustermanager_name() {
		return clustermanager_name;
	}

	public void setClustermanager_name(String clustermanager_name) {
		this.clustermanager_name = clustermanager_name;
	}

	public int getClustermanager_id() {
		return clustermanager_id;
	}

	public void setClustermanager_id(int clustermanager_id) {
		this.clustermanager_id = clustermanager_id;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
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

	public LinkedList getClustermanager_list() {
		return clustermanager_list;
	}

	public void setClustermanager_list(LinkedList clustermanager_list) {
		this.clustermanager_list = clustermanager_list;
	}

	public LinkedList getTower_list() {
		return tower_list;
	}

	public void setTower_list(LinkedList tower_list) {
		this.tower_list = tower_list;
	}
	public String getOutputtext() {
		return outputtext;
	}
	public void setOutputtext(String outputtext) {
		this.outputtext = outputtext;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}
	
	
	
	
}
