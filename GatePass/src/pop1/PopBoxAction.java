package pop1;

import javax.servlet.http.*;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;

import java.io.*;
import java.util.*;
import category.*;
import state.*;
import purpose.*;
import serviceprovider.*;
import district.*;
import smetype.*;
import sme.*;
import user.*;
import tower.*;
import clustermanager.*;
import gatekeeper.*;
 
public class PopBoxAction {
	
	private String tower_id;
	private String tower_name;

	
	private String category_id;
	private String category_name;
	
	private String state_id;
	private String state_name;
	
	private String purpose_id;
	private String purpose_name;
	
	private int serviceprovider_id;
	private String serviceprovider_name;
	
	private String district_id;
	private String district_name;
	
	private String smetype_id;
	private String smetype_name;
	
	private String sme_id;
	private String sme_name;
	
	private String user_id;
	private String user_name;
	
	private String clustermanager_id;
	private String cm_mobile_no;
	private String clustermanager_name;
	
	private String gatekeeper_id;
	private String gp_mobile_no;
	private String gatekeeper_name;
	
	private String flag;
	
	private LinkedList ll=null;
	private LinkedList c=null;
	
	
	private LinkedList serviceprovider_list=null;
	private LinkedList smetype_list=null;
	private LinkedList usertype_list=null;
	private LinkedList state_list=null;
	private LinkedList district_list=null;
	private LinkedList message=null;
	private LinkedList message1=null;




	
	public String execute() throws Exception
	{
		DistrictInterface obj = new DistrictPojo();
		UserInterface obj1 = new UserPojo();
		message = obj.execute();
		message1= obj1.execute(2);
		if ((message != null) && (message1 != null))
			return "link";
		else
			return "home";
	}
	
	public String ServiceProviderDetails() throws Exception
	{
		System.out.println("action");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		
		TowerInfoInterface obj=new TowerInfoPojo();
		LinkedList ll=obj.towerInfo(serviceprovider_id);
		if(ll==null)
		pw.println("1");
		else{
		Iterator itr=ll.iterator();
		while(itr.hasNext())
		pw.println(itr.next());
		}
		
		return null;
	}

	public String getTower_id() {
		return tower_id;
	}

	public void setTower_id(String tower_id) {
		this.tower_id = tower_id;
	}

	public String getTower_name() {
		return tower_name;
	}

	public void setTower_name(String tower_name) {
		this.tower_name = tower_name;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getPurpose_id() {
		return purpose_id;
	}

	public void setPurpose_id(String purpose_id) {
		this.purpose_id = purpose_id;
	}

	public String getPurpose_name() {
		return purpose_name;
	}

	public void setPurpose_name(String purpose_name) {
		this.purpose_name = purpose_name;
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

	public String getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(String district_id) {
		this.district_id = district_id;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getSmetype_id() {
		return smetype_id;
	}

	public void setSmetype_id(String smetype_id) {
		this.smetype_id = smetype_id;
	}

	public String getSmetype_name() {
		return smetype_name;
	}

	public void setSmetype_name(String smetype_name) {
		this.smetype_name = smetype_name;
	}

	public String getSme_id() {
		return sme_id;
	}

	public void setSme_id(String sme_id) {
		this.sme_id = sme_id;
	}

	public String getSme_name() {
		return sme_name;
	}

	public void setSme_name(String sme_name) {
		this.sme_name = sme_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getClustermanager_id() {
		return clustermanager_id;
	}

	public void setClustermanager_id(String clustermanager_id) {
		this.clustermanager_id = clustermanager_id;
	}

	public String getCm_mobile_no() {
		return cm_mobile_no;
	}

	public void setCm_mobile_no(String cm_mobile_no) {
		this.cm_mobile_no = cm_mobile_no;
	}

	public String getClustermanager_name() {
		return clustermanager_name;
	}

	public void setClustermanager_name(String clustermanager_name) {
		this.clustermanager_name = clustermanager_name;
	}

	public String getGatekeeper_id() {
		return gatekeeper_id;
	}

	public void setGatekeeper_id(String gatekeeper_id) {
		this.gatekeeper_id = gatekeeper_id;
	}

	public String getGp_mobile_no() {
		return gp_mobile_no;
	}

	public void setGp_mobile_no(String gp_mobile_no) {
		this.gp_mobile_no = gp_mobile_no;
	}

	public String getGatekeeper_name() {
		return gatekeeper_name;
	}

	public void setGatekeeper_name(String gatekeeper_name) {
		this.gatekeeper_name = gatekeeper_name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public LinkedList getLl() {
		return ll;
	}

	public void setLl(LinkedList ll) {
		this.ll = ll;
	}

	public LinkedList getC() {
		return c;
	}

	public void setC(LinkedList c) {
		this.c = c;
	}

	public LinkedList getServiceprovider_list() {
		return serviceprovider_list;
	}

	public void setServiceprovider_list(LinkedList serviceprovider_list) {
		this.serviceprovider_list = serviceprovider_list;
	}

	public LinkedList getSmetype_list() {
		return smetype_list;
	}

	public void setSmetype_list(LinkedList smetype_list) {
		this.smetype_list = smetype_list;
	}

	public LinkedList getUsertype_list() {
		return usertype_list;
	}

	public void setUsertype_list(LinkedList usertype_list) {
		this.usertype_list = usertype_list;
	}

	public LinkedList getState_list() {
		return state_list;
	}

	public void setState_list(LinkedList state_list) {
		this.state_list = state_list;
	}

	public LinkedList getDistrict_list() {
		return district_list;
	}

	public void setDistrict_list(LinkedList district_list) {
		this.district_list = district_list;
	}

	public LinkedList getMessage() {
		return message;
	}

	public void setMessage(LinkedList message) {
		this.message = message;
	}

	public LinkedList getMessage1() {
		return message1;
	}

	public void setMessage1(LinkedList message1) {
		this.message1 = message1;
	}
	
	
	
}
