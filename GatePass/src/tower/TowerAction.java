package tower;


import gatekeeper.GateKeeperInterface;
import gatekeeper.GateKeeperPojo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import clustermanager.ClusterManagerPojo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;

import district.*;
import user.*;

public class TowerAction extends ActionSupport{
	
	private String indus_tower_code="";
	private int tower_id;
	
	private String tower_name="";
	private LinkedList message;
	private LinkedList message1;
	private String site_name="";
	private String message_vs_table;
	private int district_id;
	private String district_name;
	
	private int state_id;
	private String state_name;

	private int serviceprovider_id;
	private String serviceprovider_name;
	private String serviceprovider_id1;
	
	private int clustermanager_id;
	private String clustermanager_mobile;
	private String clustermanager_name;
	
	private int gatekeeper_id;
	private String gatekeeper_mobile;
	private String gatekeeper_name;
	private String act="";
	private String search="";
	private String tower_type="";
	private String address="";
	private String height="";
	private String longitude="";
	private String latitude="";
	
	private LinkedList tower_list=null;
	HashMap hm;
	
	private String flag;
	private InputStream inputStream;
	private LinkedList state_list=null;
	private LinkedList district_list=null;
	private LinkedList gatekeeper_list=null;
	private LinkedList clustermanager_list=null;
	private String outputtext = "";


	
	public String Search() throws Exception
	 { 
		DistrictInterface obj = new DistrictPojo();
		state_list = new DistrictPojo().mahaMethod();
		TowerInterface obj1=new TowerPojo();
		tower_list=obj1.generateTowerList(indus_tower_code,"1");// Getting Tower List
		
		if (tower_list.size()==0)
		{
			outputtext = "WARNING!!!!! No Tower present...";
			addActionMessage(outputtext);
			return "success";
		}
		else
		{
			message_vs_table = "1";
			return "success";
		}
	 } 
	
	public String dummyLink() throws Exception
	 { 
		DistrictInterface obj = new DistrictPojo();
		state_list = new DistrictPojo().mahaMethod();
		TowerInterface obj1=new TowerPojo();
		tower_list=obj1.generateTowerList(null,null);// Getting Tower List
		
		if (tower_list.size()==0)
		{
			outputtext = "WARNING!!!!! No Tower present...";
			addActionMessage(outputtext);
			return "success";
		}
		else
		{
			message_vs_table = "1";
			return "success";
		}
	 } 
	
	public String Addition() throws Exception
	 { 
		TowerInterface obj=new TowerPojo();
		indus_tower_code = internalTrimming(indus_tower_code.trim());
		gatekeeper_mobile = internalTrimming(gatekeeper_mobile.trim());
		clustermanager_mobile = internalTrimming(clustermanager_mobile.trim());
		state_list = new DistrictPojo().mahaMethod();
		if(act.equals("Add"))
		{
			//System.out.println("Coming in Validation");
			int message = obj.addTower(site_name,address,tower_type,district_id,height,latitude,longitude,indus_tower_code,gatekeeper_mobile,clustermanager_mobile);
			tower_list = obj.generateTowerList(null,null);
			site_name = "";
			address = "";
			tower_type = "-1";
			state_id = -1;
			district_id = -1;
			height = "";
			latitude = "";
			longitude = "";
			indus_tower_code = "";
			gatekeeper_mobile = "";
			clustermanager_mobile = "";
			
			if (message == 1 )
			{
				message_vs_table = "1";
				outputtext = "Tower Inserted Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else if (message == 1001 )
			{
				outputtext = "WARNING!!!!! Tower ID Already Present.....";
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
		else if(act.equals("Save"))
		{
			district_id = 1;
			int message = obj.towerModification(tower_id,indus_tower_code,site_name,address,tower_type,height,latitude,longitude,district_id,gatekeeper_mobile,clustermanager_mobile);
			tower_list = obj.generateTowerList(null,null);// Getting Tower List
			tower_id = 0;
			indus_tower_code = "";
			gatekeeper_mobile = "";
			clustermanager_mobile = "";
			site_name = "";
			address = "";
			state_id = -1;
			district_id = -1;
			tower_type = "-1";
			height = "";
			longitude = "";
			latitude = "";
			//System.out.println("Message ::"+message);
			if (message == 1 )
			{
				message_vs_table = "1";
				outputtext = "Tower Updated Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else if (message == 1001 )
			{
				outputtext = "WARNING!!!!! GateKeeper Mobile Number Not Present.....Please Enter GateKeeper First";
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
		else if(act.equals("Delete?"))
		{
			state_list = new DistrictPojo().mahaMethod();
			int message = obj.towerDeletion(tower_id);
			tower_list = obj.generateTowerList(null,null);// Getting Tower List
			tower_id = 0;
			indus_tower_code = "";
			gatekeeper_mobile = "";
			clustermanager_mobile = "";
			site_name = "";
			address = "";
			state_id = -1;
			district_id = -1;
			tower_type = "-1";
			height = "";
			longitude = "";
			latitude = "";
			
			if (message == 1 )
			{
				message_vs_table = "1";
				outputtext = "Tower Deleted Successfully.....";
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
	
	public String generateTowerList() throws Exception
	{
		TowerInterface obj=new TowerPojo();
		tower_list=obj.generateTowerList(null,null);

		if (tower_list != null)
			return "success";
		else
			return "home";
		
	}
	
	public String towerDeletion() throws Exception
	{
		System.out.println("in tower deletion "+tower_id+" "+tower_id);
		TowerInterface obj=new TowerPojo();
		int result=obj.towerDeletion(tower_id);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(result);
		return null;
	}
	
	public String towerModification() throws Exception
	{
		System.out.println("in tower modification "+tower_id+" "+indus_tower_code+" "+site_name+" "+address+" "+tower_type+" "+height+" "+latitude+" "+longitude+" "+district_id+" "+gatekeeper_id+" "+clustermanager_id+" "+serviceprovider_id);
		
		TowerInterface obj=new TowerPojo();
		String result=obj.towerModification(tower_id,indus_tower_code,site_name,address,tower_type,height,latitude,longitude,district_id,gatekeeper_mobile,clustermanager_mobile,serviceprovider_id);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(result);
		return null;
	}
	
	public String unassignTower() throws Exception
	{
		System.out.println("in unassignTower :: "+tower_id+" "+flag);
		TowerInterface obj=new TowerPojo();
		String result=obj.unassignTower(tower_id,flag);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(result);
		return null;
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
	
	/*public String megaHuntTowerReport() throws Exception
	{
		System.out.println("in state megahunt tower report "+tower_name+"flag :: "+flag);
		DistrictInterface obj=new DistrictPojo();
	
		tower_list=obj.megaHuntTower(district_name,state_id);
		
			
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
			Document document = new Document(PageSize.A4,30,30,30,30);
			PdfWriter.getInstance(document, buffer);

			document.open();
			
			//Inserting Image in PDF
	        //Image image = Image.getInstance ("/home/rtizen04/workspace/IndusGatePass/src/export/d.jpg");
	        //image.scaleAbsolute(120f, 60f);//image width,height  
	        
	        
	       PdfPTable table=new PdfPTable(3);
	        
	       PdfPCell cell = new PdfPCell (new Paragraph ("District Details"));

	       cell.setColspan (3);
	       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
	       cell.setPadding (10.0f);
	       cell.setBackgroundColor (new BaseColor (10, 221, 8));                                   

	       table.addCell(cell); 
	       table.addCell("District Id");
	       table.addCell("District Name");
	       table.addCell("State Name");


	       System.out.println(district_list);
	       ListIterator li=district_list.listIterator();
	       while(li.hasNext())
	       {
	    	   DistrictAction temp=(DistrictAction)li.next();
	    	   table.addCell(String.valueOf(temp.getDistrict_id()));
	    	   table.addCell(temp.getDistrict_name());
	    	   table.addCell(temp.getState_name());

	       }
	       
	       document.add(table);
	       document.close();
			
			
		   inputStream = new ByteArrayInputStream(buffer.toByteArray());
	       return "success";
		
	}*/
	
	public void validate()
	   {
			if(act.equals("Add")){
				

				DistrictInterface obj = new DistrictPojo();
				state_list = new DistrictPojo().mahaMethod();
				
				TowerInterface obj1=new TowerPojo();
				tower_list=obj1.generateTowerList(null,null);// Getting Tower List
				
				//System.out.println("Coming in Validation");
				
				if(indus_tower_code.trim().equals(""))
				{
					addFieldError("indus_tower_code","Please Enter Tower ID");
				}
				else if(indus_tower_code.length() != 7)
				{
					addFieldError("indus_tower_code","Please Enter Proper Tower ID");
				}
				
				//System.out.println("gatekeeper_mobile.length()"+gatekeeper_mobile.length());
				if(gatekeeper_mobile.trim().equals(""))
				{
					addFieldError("gatekeeper_mobile","Please Enter Gatekeeper Mobile Number");
				}
				else if(gatekeeper_mobile.length() != 10)
				{
					addFieldError("gatekeeper_mobile","Please Enter Proper Gatekeeper Mobile Number");
				}
				else if(gatekeeper_mobile.length() == 10)
				{
					//System.out.println("Coming in GateKeeper Validation");
					GateKeeperInterface obj2=new GateKeeperPojo();
					gatekeeper_list=obj2.generateGateKeeperList(gatekeeper_mobile,"2");
					if (gatekeeper_list.size() == 0)
						addFieldError("gatekeeper_mobile","Gatekeeper Mobile Number Doesn't Exists!!!!!Please Add Gatekeeper First");
					
				}
				
				if(clustermanager_mobile.trim().equals(""))
				{
					addFieldError("clustermanager_mobile","Please Enter ClusterManager Mobile Number");
				}
				else if(clustermanager_mobile.length() != 10)
				{
					addFieldError("clustermanager_mobile","Please Enter Proper ClusterManager Mobile Number");
				}
				
				if(state_id == -1)
				{
					addFieldError("state_id","Please Select State");
				}
				
				if(district_id == -1)
				{
					addFieldError("district_id","Please Select District");
				}
				
				if(tower_type.trim().equals("-1"))
				{
					addFieldError("tower_type","Please Select Tower Type");
				}
			}
	   }

	public String getIndus_tower_code() {
		return indus_tower_code;
	}

	public void setIndus_tower_code(String indus_tower_code) {
		this.indus_tower_code = indus_tower_code;
	}

	public int getTower_id() {
		return tower_id;
	}

	public void setTower_id(int tower_id) {
		this.tower_id = tower_id;
	}

	public String getTower_name() {
		return tower_name;
	}

	public void setTower_name(String tower_name) {
		this.tower_name = tower_name;
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

	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
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

	public int getClustermanager_id() {
		return clustermanager_id;
	}

	public void setClustermanager_id(int clustermanager_id) {
		this.clustermanager_id = clustermanager_id;
	}

	public String getClustermanager_mobile() {
		return clustermanager_mobile;
	}

	public void setClustermanager_mobile(String clustermanager_mobile) {
		this.clustermanager_mobile = clustermanager_mobile;
	}

	public String getClustermanager_name() {
		return clustermanager_name;
	}

	public void setClustermanager_name(String clustermanager_name) {
		this.clustermanager_name = clustermanager_name;
	}

	public int getGatekeeper_id() {
		return gatekeeper_id;
	}

	public void setGatekeeper_id(int gatekeeper_id) {
		this.gatekeeper_id = gatekeeper_id;
	}

	public String getGatekeeper_mobile() {
		return gatekeeper_mobile;
	}

	public void setGatekeeper_mobile(String gatekeeper_mobile) {
		this.gatekeeper_mobile = gatekeeper_mobile;
	}

	public String getGatekeeper_name() {
		return gatekeeper_name;
	}

	public void setGatekeeper_name(String gatekeeper_name) {
		this.gatekeeper_name = gatekeeper_name;
	}

	public String getTower_type() {
		return tower_type;
	}

	public void setTower_type(String tower_type) {
		this.tower_type = tower_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public LinkedList getTower_list() {
		return tower_list;
	}

	public void setTower_list(LinkedList tower_list) {
		this.tower_list = tower_list;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getServiceprovider_id1() {
		return serviceprovider_id1;
	}

	public void setServiceprovider_id1(String serviceprovider_id1) {
		this.serviceprovider_id1 = serviceprovider_id1;
	}

	public HashMap getHm() {
		return hm;
	}

	public void setHm(HashMap hm) {
		this.hm = hm;
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

	public LinkedList getGatekeeper_list() {
		return gatekeeper_list;
	}

	public void setGatekeeper_list(LinkedList gatekeeper_list) {
		this.gatekeeper_list = gatekeeper_list;
	}

	public LinkedList getClustermanager_list() {
		return clustermanager_list;
	}

	public void setClustermanager_list(LinkedList clustermanager_list) {
		this.clustermanager_list = clustermanager_list;
	}

	public String getMessage_vs_table() {
		return message_vs_table;
	}

	public void setMessage_vs_table(String message_vs_table) {
		this.message_vs_table = message_vs_table;
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

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
}

