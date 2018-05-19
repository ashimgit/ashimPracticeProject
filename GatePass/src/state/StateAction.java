package state;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import category.CategoryInterface;
import category.CategoryPojo;

import clustermanager.ClusterManagerInterface;
import clustermanager.ClusterManagerPojo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.*;

import district.DistrictInterface;
import district.DistrictPojo;

public class StateAction extends ActionSupport
{
	private int state_id;
	private String state_name="";
	private LinkedList state_list=null;
	private String outputtext = "";
	private InputStream inputStream;
	private String flag;
	private String act="";


	public String dummyLink() throws Exception 
	{
		StateInterface obj=new StatePojo();
		state_list=obj.generateStateList(null,null);//Getting State List
		
		if (state_list.size()==0)
		{
			outputtext = "No State Present.....";
			addActionMessage(outputtext);
			return "success";
		}
		else if(state_list.size()!=0)
		{
			//outputtext = "Here is the List.....";
			//addActionMessage(outputtext);
			return "success";
		}
		else
		{
			outputtext = "Something Wrong Happened, Pls try after some time.....";
			addActionMessage(outputtext);
			return "failure";
		}
	}
	
	public String Addition()
	{
		StateInterface obj = new StatePojo();
		
		state_name = internalTrimming(state_name.trim());
		
		if(act.equals("Add")){
		int message = obj.addstate(state_name);
		
		state_name = "";
		state_list=obj.generateStateList(null,null);//Getting State List
		
		if (message == 1 )
		{
			outputtext = "State Inserted Successfully.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if (message == 1001 )
		{
			outputtext = "State Name Already Present";
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
			
			int message = obj.stateModification(state_id,state_name);
			
			state_name = "";
			state_list=obj.generateStateList(null,null);//Getting State List
			
			if (message == 1 )
			{
				outputtext = "State Updated Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else if (message == 1001 )
			{
				outputtext = "WARNING!!!!!!!!!! State Name Already Present.....";
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
			
			int message = obj.stateDeletion(state_id);
			
			state_name = "";
			state_list=obj.generateStateList(null,null);//Getting State List
			
			if (message == 1 )
			{
				outputtext = "State Deleted Successfully.....";
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
	
	public String generateStateList() throws Exception
	{
		StateInterface obj=new StatePojo();
		state_list=obj.generateStateList(null,null);

		if (state_list != null)
			return "success";
		else
			return "home";
		
	}
	
	public int stateModification(int state_id,String state_name) throws Exception
	{
		StateInterface obj=new StatePojo();
		int result=obj.stateModification(state_id,state_name);
		
		
		return result;
	}
	
	public int stateDeletion(int state_id) throws Exception
	{
		StateInterface obj=new StatePojo();
		int result=obj.stateDeletion(state_id);
		
		
		return result;
	}
	
	public String Search() throws Exception
	{
		System.out.println("in state megahunt "+state_name+"flag :: "+flag);
		StateInterface obj=new StatePojo();
	
		state_list=obj.megaHuntState(state_name);
		
		if(state_list.size()==0)
			addActionMessage("No States are present.....");
		
		return "success";
	}
	
	public String megaHuntStateReport() throws Exception
	{
		System.out.println("in state megahuntreport "+state_name+"flag :: "+flag);
		StateInterface obj=new StatePojo();
	
		state_list=obj.megaHuntState(state_name);
		
			
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
			Document document = new Document(PageSize.A4,30,30,30,30);
			PdfWriter.getInstance(document, buffer);

			document.open();
			
			Paragraph p=new Paragraph();
			//p.add("*****************************************************************************************************")
	        
	       PdfPTable table=new PdfPTable(2);
	        
	       PdfPCell cell = new PdfPCell (new Paragraph ("State Details"));

	       cell.setColspan (2);
	       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
	       cell.setPadding (10.0f);
	       cell.setBackgroundColor (BaseColor.CYAN);                                   

	       table.addCell(cell); 
	       table.addCell("State Id");
	       table.addCell("State Name");

	       System.out.println(state_list);
	       ListIterator li=state_list.listIterator();
	       while(li.hasNext())
	       {
	    	   StateAction temp=(StateAction)li.next();
	    	   table.addCell(String.valueOf(temp.getState_id()));
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
				
				StateInterface obj=new StatePojo();
				state_list=obj.generateStateList(null,null);//Getting State List
				
				
				if(state_name.trim().equals(""))
				{
					addFieldError("state_name","Please enter State Name.....");
				}
				
			}
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

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}
	
}