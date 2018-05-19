package pop;

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
	
	private String serviceprovider_id;
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
	private LinkedList clustermanager_list=null;
	private LinkedList gatekeeper_list=null;




	
	public String execute() throws Exception
	{
		return "link";
	}
	
	public String towerDetails() throws Exception
	{
		System.out.println("action");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		
		TowerInfoInterface obj=new TowerInfoPojo();
		LinkedList ll=obj.towerInfo(tower_id);
		if(ll==null)
		pw.println("1");
		else{
		Iterator itr=ll.iterator();
		while(itr.hasNext())
		pw.println(itr.next());
		}
		
		return null;
	}
	
	public String generateData()
	{
		if(flag.equals("1")){
		CategoryInterface obj=new CategoryPojo();
		ll=obj.generateCategoryList(category_id,flag);
		return "success1";
		}
		
		else if(flag.equals("2")){
			StateInterface obj=new StatePojo();
			ll=obj.generateStateList(state_id,flag);
			return "success2";
		}
		
		else if(flag.equals("3")){
			System.out.println("look :: "+purpose_id+"  "+flag);
			PurposeInterface obj=new PurposePojo();
			ll=obj.generatePurposeList(purpose_id,flag);
			return "success3";
		}
		
		else if(flag.equals("4")){
			System.out.println("look :: "+serviceprovider_id+"  "+flag);
			ServiceProviderInterface obj=new ServiceProviderPojo();
			ll=obj.generateServiceProviderList(serviceprovider_id,flag);
			
			CategoryInterface obj1=new CategoryPojo();
			c=obj1.generateCategoryList(category_id,null);
			
			return "success4";
		}
		
		else if(flag.equals("5")){
			System.out.println("look :: "+district_id+"  "+flag);
			DistrictInterface obj=new DistrictPojo();
			ll=obj.generateDistrictList(district_id,flag);
			
			StateInterface obj1=new StatePojo();
			c=obj1.generateStateList(state_id,null);
			
			return "success5";
		}
		
		else if(flag.equals("6")){
			System.out.println("look :: "+smetype_id+"  "+flag);
			SMETypeInterface obj=new SMETypePojo();
			ll=obj.generateSMETypeList(smetype_id,flag);
			return "success6";
		}
		
		else if(flag.equals("7")){
			System.out.println("look :: "+sme_id+"  "+flag);
			SMEInterface obj=new SMEPojo();
			ll=obj.generateSMEList(sme_id,flag);
			
			ServiceProviderInterface obj1=new ServiceProviderPojo();
			serviceprovider_list=obj1.generateServiceProviderList(null,null);
			
			SMETypeInterface obj2=new SMETypePojo();
			smetype_list=obj2.generateSMETypeList(null,null);
			
			return "success7";
		}
		
		else if(flag.equals("8")){
			System.out.println("look :: "+user_id+"  "+flag);
			UserInterface obj=new UserPojo();
			ll=obj.generateUserList(Integer.parseInt(user_id),flag,null);
			
			ServiceProviderInterface obj1=new ServiceProviderPojo();
			serviceprovider_list=obj1.generateServiceProviderList(null,null);
			
			UserTypeInterface obj2=new UserTypePojo();
			usertype_list=obj2.generateUserTypeList(null,null);
			
			return "success8";
		}
		
		else if(flag.equals("9")){
			System.out.println("look :: "+tower_id+"  "+flag);
			
			TowerInterface obj=new TowerPojo();
			ll=obj.generateTowerList(tower_id,flag);
			
			StateInterface obj1=new StatePojo();
			state_list=obj1.generateStateList(null,null);
			
			DistrictInterface obj2=new DistrictPojo();
			district_list=obj2.generateDistrictList(state_id,"100");
			
			ServiceProviderInterface obj3=new ServiceProviderPojo();
			serviceprovider_list=obj3.generateServiceProviderList(null,null);
			
			ClusterManagerInterface obj4=new ClusterManagerPojo();
			clustermanager_list=obj4.generateClusterManagerList(null,null);
			
			GateKeeperInterface obj5=new GateKeeperPojo();
			gatekeeper_list=obj5.generateGateKeeperList(null,null);
			
			return "success9";
		}
		
		else if(flag.equals("10")){
			System.out.println("look :: "+cm_mobile_no+"  "+flag);
			
			ClusterManagerInterface obj=new ClusterManagerPojo();
			clustermanager_list=obj.generateClusterManagerList(cm_mobile_no,flag);
			
			return "success10";
		}
		
		else if(flag.equals("11")){
			System.out.println("look :: "+gp_mobile_no+"  "+flag);
			
			GateKeeperInterface obj=new GateKeeperPojo();
			gatekeeper_list=obj.generateGateKeeperList(gp_mobile_no,flag);
			
			ServiceProviderInterface obj3=new ServiceProviderPojo();
			serviceprovider_list=obj3.generateServiceProviderList(null,null);
			
			return "success11";
		}

		return "success";
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

	public String getServiceprovider_id() {
		return serviceprovider_id;
	}

	public void setServiceprovider_id(String serviceprovider_id) {
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

	public LinkedList getClustermanager_list() {
		return clustermanager_list;
	}

	public void setClustermanager_list(LinkedList clustermanager_list) {
		this.clustermanager_list = clustermanager_list;
	}

	public LinkedList getGatekeeper_list() {
		return gatekeeper_list;
	}

	public void setGatekeeper_list(LinkedList gatekeeper_list) {
		this.gatekeeper_list = gatekeeper_list;
	}

	
}
