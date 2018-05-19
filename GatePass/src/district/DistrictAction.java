package district;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import serviceprovider.ServiceProviderInterface;
import serviceprovider.ServiceProviderPojo;
import state.StateAction;
import state.StateInterface;
import state.StatePojo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.*;

public class DistrictAction extends ActionSupport
{
	private int district_id;
	private String district_name="";
	private LinkedList district_list;
	
	private int state_id;
	private String state_name="";
	private String outputtext = "";
	private LinkedList state_list;
	
	private InputStream inputStream;
	private String flag;
	private String message_vs_table="0";
	private String act="";

	
	public String dummyLink() throws Exception 
	{
		DistrictInterface obj = new DistrictPojo();
		state_list = obj.execute();//Getting State Name
		district_list=obj.generateDistrictList(null,null);//Getting District List
		
		if (state_list.size()==0)
		{
			outputtext = "Please Refer To State Section And Enter State First Before Entering District.....";
			addActionMessage(outputtext);
			return "home";
		}
		else if(state_list.size()!=0 && district_list.size()==0)
		{

			outputtext = "No District Present Till Now.....";
			message_vs_table="0";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if(state_list.size()!=0 && district_list.size()!=0)
		{
			message_vs_table="1";
			return "success"; 
		}
		else
		{
			outputtext = "Something Wrong Happened, Pls try after some time.....";
			addActionMessage(outputtext);
			return "home";
		}
	}
	 
	public String Addition()
	{
		DistrictInterface obj = new DistrictPojo();
		state_list = obj.execute();//Getting State Name
		district_name = internalTrimming(district_name.trim());
		
		if(act.equals("Add")){
		int message = obj.adddistrict(state_id,district_name);
		district_list = obj.generateDistrictList(null,null);//Getting District List
		System.out.println("district_list"+district_list);
		state_id = -1;
		district_name = "";
		if (message == 1 )
		{
			outputtext = "District Inserted Successfully.....";
			addActionMessage(outputtext);
			message_vs_table="1";
			return "success"; 
		}
		else if (message == 1001 )
		{
			outputtext = "WARNING!!!!! District Name Already Present.....";
			message_vs_table="1";
			addActionMessage(outputtext);
			return "success"; 
		}
		else
		{
			outputtext = "Something Wrong Happened, Pls try after some time.....";
			message_vs_table="1";
			addActionMessage(outputtext);
			return "success"; 
		}
		}
		
		else if(act.equals("Save")){
				int message = obj.districtModification(district_id,district_name,state_id);
				district_list = obj.generateDistrictList(null,null);//Getting District List
				state_id = -1;
				district_name = "";
				
				if (message == 1 )
				{
					outputtext = "District Updated Successfully.....";
					addActionMessage(outputtext);
					message_vs_table="1";
					return "success"; 
				}
				else if (message == 1001 )
				{
					outputtext = "WARNING!!!!! District Name Already Present.....";
					addActionMessage(outputtext);
					message_vs_table="1";
					return "success"; 
				}
				else
				{
					outputtext = "Something Wrong Happened, Pls try after some time.....";
					addActionMessage(outputtext);
					message_vs_table="1";
					return "success"; 
				}
			}
		
		else if(act.equals("Delete?")){
			int message = obj.districtDeletion(district_id);
			district_list = obj.generateDistrictList(null,null);//Getting District List
			state_id = -1;
			district_name = "";
			
			if (message == 1 )
			{
				outputtext = "District Deleted Successfully.....";
				addActionMessage(outputtext);
				message_vs_table="1";
				return "success"; 
			}
			else
			{
				outputtext = "Something Wrong Happened, Pls try after some time.....";
				addActionMessage(outputtext);
				message_vs_table="1";
				return "success"; 
			}
		}
		else
			return "success";
				
	}
	
	public String generateDistrictList() throws Exception
	{
		DistrictInterface obj=new DistrictPojo();
		district_list=obj.generateDistrictList(null,null);
		state_list = obj.execute();
		if (district_list != null && state_list != null)
			return "success";
		else
			return "home";
		
	}
	
	public String districtList() throws Exception
	{
		DistrictInterface obj=new DistrictPojo();
		district_list=obj.generateDistrictList(String.valueOf(state_id),"100");
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		
		ListIterator li=district_list.listIterator();
		while(li.hasNext())
		pw.println(li.next());
		return null;
		
	}
	
	public int districtModification(int district_id,String district_name,int state_id) throws Exception
	{
		DistrictInterface obj=new DistrictPojo();
		int result=obj.districtModification(district_id,district_name,state_id);
		
		
		return result;
	}
	
	public int districtDeletion(int district_id) throws Exception
	{
		DistrictInterface obj=new DistrictPojo();
		int result=obj.districtDeletion(district_id);
		
		return result;
	}
	
	public String Search() throws Exception
	{
		System.out.println("in district megahuntdistrict "+district_name);
		DistrictInterface obj=new DistrictPojo();
	
		district_list=obj.megaHuntDistrict(district_name,state_id);
		state_list = obj.execute();
		message_vs_table="1";

		
		return "success";
	}
	
	public String megaHuntDistrictReport() throws Exception
	{
		System.out.println("in state megahuntreport "+district_name+"flag :: "+flag);
		DistrictInterface obj=new DistrictPojo();
	
		district_list=obj.megaHuntDistrict(district_name,state_id);
		
			
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
				
				DistrictInterface obj = new DistrictPojo();
				state_list = obj.execute();//Getting State Name
				district_list=obj.generateDistrictList(null,null);//Getting District List
				message_vs_table="1";

				
				if (state_id == -1)
				{
					addFieldError("state_id","Please Select State");
				}
				
				if (district_name.trim().equals(""))
				{
					addFieldError("district_name","Please Enter District Name");
				}
			}
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
	public LinkedList getDistrict_list() {
		return district_list;
	}
	public void setDistrict_list(LinkedList district_list) {
		this.district_list = district_list;
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
	
	public LinkedList getState_list() {
		return state_list;
	}
	public void setState_list(LinkedList state_list) {
		this.state_list = state_list;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getOutputtext() {
		return outputtext;
	}
	public void setOutputtext(String outputtext) {
		this.outputtext = outputtext;
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
	@Override
	public String toString() {
		return "<option value="+district_id+">"+district_name+"</option>";
	}
	
	
}
