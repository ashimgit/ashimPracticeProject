package purpose;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import state.StateAction;
import state.StateInterface;
import state.StatePojo;

import clustermanager.ClusterManagerInterface;
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

import category.CategoryInterface;
import category.CategoryPojo;

public class PurposeAction extends ActionSupport
{
	private int purpose_id;
	private String purpose_name;
	private String purpose_code;
	private LinkedList purpose_list=null;
	private String outputtext = "";
	private InputStream inputStream;
	private String flag;
	private String act="";

	
	
	public String dummyLink() throws Exception 
	{
		PurposeInterface obj=new PurposePojo();
		purpose_list=obj.generatePurposeList(null,null);//Getting Purpose List
		if(purpose_list.size()==0)
		{
			outputtext="No Purposes.....";
			addActionMessage(outputtext);
			return "success";		}
		else
		{
			//outputtext = "Here is the List.....";
			//addActionMessage(outputtext);
			return "success";
		}	
		
	}
	
	public String Addition()
	{
		PurposeInterface obj = new PurposePojo();
		purpose_name = internalTrimming(purpose_name.trim());
		purpose_code = internalTrimming(purpose_code.trim());
		
		if(act.equals("Add")){
		int message = obj.addpurpose(purpose_name,purpose_code);
		purpose_name = "";
		purpose_code = "";
		purpose_list=obj.generatePurposeList(null,null);//Getting Purpose List
		if (message == 1 )
		{
			outputtext = "Purpose Inserted Successfully.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if (message == 1001 )
		{
			outputtext = "WARNING!!!!!!!!!! Purpose Name Already Present";
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
			int message = obj.purposeModification(purpose_id,purpose_name,purpose_code);
			purpose_name = "";
			purpose_code = "";
			purpose_list=obj.generatePurposeList(null,null);//Getting Purpose List
			if (message == 1 )
			{
				outputtext = "Purpose Updated Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else if (message == 1001 )
			{
				outputtext = "WARNING!!!!!!!!!! Purpose Name Already Present";
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
			int message = obj.purposeDeletion(purpose_id);
			purpose_name = "";
			purpose_code = "";
			purpose_list=obj.generatePurposeList(null,null);//Getting Purpose List
			if (message == 1 )
			{
				outputtext = "Purpose Deleted Successfully.....";
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
	
	public String generatePurposeList() throws Exception
	{
		PurposeInterface obj=new PurposePojo();
		purpose_list=obj.generatePurposeList(null,null);

		if (purpose_list != null)
			return "success";
		else
			return "home";
		
	}
	
	public int purposeModification(int purpose_id,String purpose_name,String purpose_code) throws Exception
	{
		PurposeInterface obj=new PurposePojo();
		int result=obj.purposeModification(purpose_id,purpose_name,purpose_code);
		return result;
	}
	
	
	public int purposeDeletion(int purpose_id) throws Exception
	{
		PurposeInterface obj=new PurposePojo();
		int result=obj.purposeDeletion(purpose_id);
		
		return result;
	}
	
	public String Search() throws Exception
	{
		PurposeInterface obj=new PurposePojo();
	
		purpose_list=obj.megaHuntPurpose(purpose_name,purpose_code);
		if(purpose_list.size()==0)
			addActionMessage("No Purpose Found According to searching criteria.....");
		
		return "success";
	}
	
	public String megaHuntPurposeReport() throws Exception
	{
		System.out.println("in purpose megahuntreport "+purpose_name+"flag :: "+flag);
		PurposeInterface obj=new PurposePojo();
	
		purpose_list=obj.megaHuntPurpose(purpose_name,purpose_code);
		
			
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
			Document document = new Document(PageSize.A4,30,30,30,30);
			PdfWriter.getInstance(document, buffer);

			document.open();
			
			//Inserting Image in PDF
	        //Image image = Image.getInstance ("/home/rtizen04/workspace/IndusGatePass/src/export/d.jpg");
	        //image.scaleAbsolute(120f, 60f);//image width,height  
	        
	        
	       PdfPTable table=new PdfPTable(2);
	        
	       PdfPCell cell = new PdfPCell (new Paragraph ("Purpose Details"));

	       cell.setColspan (2);
	       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
	       cell.setPadding (10.0f);
	       cell.setBackgroundColor (new BaseColor (200, 6, 8));                                   

	       table.addCell(cell); 
	       table.addCell("Purpose Id");
	       table.addCell("Purpose Name");

	       System.out.println(purpose_list);
	       ListIterator li=purpose_list.listIterator();
	       while(li.hasNext())
	       {
	    	   PurposeAction temp=(PurposeAction)li.next();
	    	   table.addCell(String.valueOf(temp.getPurpose_id()));
	    	   table.addCell(temp.getPurpose_name());

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
				
				ClusterManagerInterface obj=new ClusterManagerPojo();
				purpose_list=obj.generateClusterManagerList(null,null);//Getting Cluster Manager List
				
				
				if(purpose_name.trim().equals(""))
				{
					addFieldError("purpose_name","Please enter Purpose Name");
				}
				if(purpose_code.trim().equals(""))
				{
					addFieldError("purpose_code","Please enter Purpose Code");
				}
				
				
			}
	   }
	
	
	public int getPurpose_id() {
		return purpose_id;
	}
	public void setPurpose_id(int purpose_id) {
		this.purpose_id = purpose_id;
	}
	public String getPurpose_name() {
		return purpose_name;
	}
	public void setPurpose_name(String purpose_name) {
		this.purpose_name = purpose_name;
	}
	public LinkedList getPurpose_list() {
		return purpose_list;
	}
	public void setPurpose_list(LinkedList purpose_list) {
		this.purpose_list = purpose_list;
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
	public String getPurpose_code() {
		return purpose_code;
	}
	public void setPurpose_code(String purpose_code) {
		this.purpose_code = purpose_code;
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
