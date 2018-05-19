package serviceprovider;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import category.CategoryInterface;
import category.CategoryPojo;

import clustermanager.ClusterManagerInterface;
import clustermanager.ClusterManagerPojo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;

import district.DistrictAction;
import district.DistrictInterface;
import district.DistrictPojo;

import state.StateInterface;
import state.StatePojo;

public class ServiceProviderAction extends ActionSupport{
	
	private String serviceprovider_name="";
	private int serviceprovider_id;
	private LinkedList serviceprovider_list;

	
	private int category_id=-1;
	private String category_name="";
	
	private LinkedList message1;
	private String outputtext = "";
	
	private InputStream inputStream;
	private String flag;
	
	private String message_vs_table;
	private String act="";
	private String search="";


	//LinkedLists
	private LinkedList category_details;
	
	public String dummyLink()
	 { 
		
		ServiceProviderInterface obj = new ServiceProviderPojo();
		category_details = obj.execute();//Getting Category Name
		serviceprovider_list=obj.generateServiceProviderList(null,null);//Getting Service Provider List
		//System.out.println("category_details :: "+category_details);
		if (category_details.size()==0)
		{
			outputtext = "Please Refer To Category Section And Enter Category First Before Entering Service provider.....";
			addActionMessage(outputtext);
			return "home";
		}
		else if(category_details.size()!=0 && serviceprovider_list.size()==0)
		{

			outputtext = "No Service Provider Present Till Now.....";
			message_vs_table="0";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if(category_details.size()!=0 && serviceprovider_list.size()!=0)
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
	
	public String serviceProviderAddition()
	 { 

		ServiceProviderInterface obj=new ServiceProviderPojo();
		category_details = obj.execute();//Getting Category Name
		serviceprovider_name=internalTrimming(serviceprovider_name.trim());
		
		if(act.equals("Delete?")) // code for deletion
		{
			
			
			int message=serviceProviderDeletion(serviceprovider_id);
			serviceprovider_list=obj.generateServiceProviderList(null,null);//Getting Service Provider List
			category_id = -1;
			serviceprovider_name = "";
			if (message == 1 )
			{
				outputtext = "Service Provider Deleted Successfully.....";
				addActionMessage(outputtext);
				message_vs_table="1";
				return "success"; 
			}
			else
			{
				outputtext = "WARNING!!!!!!!!!! Something Went Wrong, Please try again later........";
				message_vs_table="1";
				return "success"; 
			}
			
		}
			
		
		else if(act.equals("Save")) // code for updation
		{
			//System.out.println("serviceprovider_id:: "+serviceprovider_id);
			
			int message=serviceProviderModification(serviceprovider_id,category_id,serviceprovider_name);
			serviceprovider_list=obj.generateServiceProviderList(null,null);//Getting Service Provider List
			category_id = -1;
			serviceprovider_name = "";
			if (message == 1 )
			{
				outputtext = "Service Provider Updated Successfully.....";
				addActionMessage(outputtext);
				message_vs_table="1";
				return "success"; 
			}
			else if (message == 1001 )
			{
				outputtext = "WARNING!!!!!!!!!! Service Provider Name Already Present........";
				addActionMessage(outputtext);
				message_vs_table="1";
				return "success"; 
			}
			else
			{
				outputtext = "WARNING!!!!!!!!!! Something Went Wrong, Please try again later........";
				message_vs_table="1";
				return "success"; 
			}
		}

		else { // code for addition
		int message=obj.addServiceProvider(category_id,serviceprovider_name);
		serviceprovider_list=obj.generateServiceProviderList(null,null);//Getting Service Provider List
		category_id = -1;
		serviceprovider_name = "";
		if (message == 1 )
		{
			outputtext = "Service Provider Inserted Successfully.....";
			addActionMessage(outputtext);
			message_vs_table="1";
			return "success"; 
		}
		else if (message == 1001 )
		{
			outputtext = "WARNING!!!!!!!!!! Service Provider Name Already Present........";
			addActionMessage(outputtext);
			message_vs_table="1";
			return "success"; 
		}
		else
		{
			outputtext = "WARNING!!!!!!!!!! Something Went Wrong, Please try again later........";
			message_vs_table="1";
			return "success"; 
		}
		}
	}
	
	public String generateServiceProviderList()
	{
		ServiceProviderInterface obj=new ServiceProviderPojo();
		serviceprovider_list=obj.generateServiceProviderList(null,null);
		message1 = obj.execute();
		if (serviceprovider_list != null && message1 != null)
			return "success";
		else
			return "home";
		
	}
	
	public int serviceProviderModification(int serviceprovider_id,int category_id,String serviceprovider_name)
	{
		//System.out.println("in serviceprovider modification "+serviceprovider_id);
		ServiceProviderInterface obj=new ServiceProviderPojo();
		int t=obj.serviceProviderModification(serviceprovider_id,serviceprovider_name,category_id);
		
		return t;
	}
	
	public int serviceProviderDeletion(int serviceprovider_id)
	{
		ServiceProviderInterface obj=new ServiceProviderPojo();
		int t=obj.serviceproviderDeletion(serviceprovider_id);
		
		
		return t;
	}
	
	public String serviceProviderSearch()
	{
		//System.out.println("in MEGAHUNT megahuntserviceprovider "+serviceprovider_name+" act"+act+" category_id "+category_id);
		ServiceProviderInterface obj=new ServiceProviderPojo();
	
		serviceprovider_list=obj.megaHuntServiceProvider(serviceprovider_name,category_id);
		category_details = obj.execute();
		if(serviceprovider_list.size()==0)
			message_vs_table="0";
		else
			message_vs_table="1";



		
		return "success";
	}
	
	public String megaHuntServiceProviderReport() throws DocumentException
	{
		//System.out.println("in sp megahuntreport "+serviceprovider_name+"flag :: "+flag);
		ServiceProviderInterface obj=new ServiceProviderPojo();
	
		serviceprovider_list=obj.megaHuntServiceProvider(serviceprovider_name,category_id);
		
			
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
			Document document = new Document(PageSize.A4,30,30,30,30);
			PdfWriter.getInstance(document, buffer);

			document.open();
			
			//Inserting Image in PDF
	        //Image image = Image.getInstance ("/home/rtizen04/workspace/IndusGatePass/src/export/d.jpg");
	        //image.scaleAbsolute(120f, 60f);//image width,height  
	        
	        
	       PdfPTable table=new PdfPTable(3);
	        
	       PdfPCell cell = new PdfPCell (new Paragraph ("Service Provider Details"));

	       cell.setColspan (3);
	       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
	       cell.setPadding (10.0f);
	       cell.setBackgroundColor (BaseColor.ORANGE);                                   

	       table.addCell(cell); 
	       table.addCell("Service Provider Id");
	       table.addCell("Service Provider Name");
	       table.addCell("Category");


	       //System.out.println(serviceprovider_list);
	       ListIterator li=serviceprovider_list.listIterator();
	       while(li.hasNext())
	       {
	    	   ServiceProviderAction temp=(ServiceProviderAction)li.next();
	    	   table.addCell(String.valueOf(temp.getServiceprovider_id()));
	    	   table.addCell(temp.getServiceprovider_name());
	    	   table.addCell(temp.getCategory_name());

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
				
				ServiceProviderInterface obj = new ServiceProviderPojo();
				category_details = obj.execute();//Getting Category Name
				serviceprovider_list=obj.generateServiceProviderList(null,null);//Getting Service Provider List
				message_vs_table="1";

				
				if (category_id == -1)
				{
					addFieldError("category_id","Please Select category");
				}
				
				if (serviceprovider_name.trim().equals(""))
				{
					addFieldError("serviceprovider_name","Please Enter Service Provider no");
				}
			}
	   }
	

	public String getServiceprovider_name() {
		return serviceprovider_name;
	}

	public void setServiceprovider_name(String serviceprovider_name) {
		this.serviceprovider_name = serviceprovider_name;
	}

	public int getServiceprovider_id() {
		return serviceprovider_id;
	}

	public void setServiceprovider_id(int serviceprovider_id) {
		this.serviceprovider_id = serviceprovider_id;
	}

	public LinkedList getServiceprovider_list() {
		return serviceprovider_list;
	}

	public void setServiceprovider_list(LinkedList serviceprovider_list) {
		this.serviceprovider_list = serviceprovider_list;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	
	public LinkedList getCategory_details() {
		return category_details;
	}

	public void setCategory_details(LinkedList category_details) {
		this.category_details = category_details;
	}

	public LinkedList getMessage1() {
		return message1;
	}

	public void setMessage1(LinkedList message1) {
		this.message1 = message1;
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

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}