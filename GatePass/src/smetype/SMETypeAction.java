package smetype;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;

import purpose.PurposeAction;
import purpose.PurposeInterface;
import purpose.PurposePojo;

import state.StateInterface;
import state.StatePojo;


public class SMETypeAction extends ActionSupport{
	
private String smetype_name;
private int smetype_id;
private LinkedList smetype_list=null;
private String outputtext = "";
private InputStream inputStream;
private String flag;
private String act="";




	
	public String dummyLink() throws Exception
	 { 
		SMETypeInterface obj=new SMETypePojo();
		smetype_list=obj.generateSMETypeList(null,null);
		
		if (smetype_list.size()==0)
		{
			outputtext = "No SME Type Present.....";
			addActionMessage(outputtext);
			return "success";
		}
		else if(smetype_list.size()!=0)
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
	
	public String Addition() throws Exception
	 { 
		SMETypeInterface obj=new SMETypePojo();	
		
		if(act.equals("Add")){
		int message=obj.addSMEType(smetype_name);
		smetype_list=obj.generateSMETypeList(null,null);
		if (message == 1 )
		{
			outputtext = "SME Type Inserted Successfully.....";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if (message == 1001 )
		{
			outputtext = "WARNING!!!!! SME Type Name Already Present.....";
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
			int message=obj.smetypeModification(smetype_id,smetype_name);
			smetype_list=obj.generateSMETypeList(null,null);
			
			if (message == 1 )
			{
				outputtext = "SME Type Updated Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			else if (message == 1001 )
			{
				outputtext = "WARNING!!!!! SME Type Name Already Present.....";
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
			int message=obj.smetypeDeletion(smetype_id);
			smetype_list=obj.generateSMETypeList(null,null);
			
			if (message == 1 )
			{
				outputtext = "SME Type Deleted Successfully.....";
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
	
	public String generateSMETypeList() throws Exception
	{
		SMETypeInterface obj=new SMETypePojo();
		smetype_list=obj.generateSMETypeList(null,null);

		if (smetype_list != null)
			return "success";
		else
			return "home";
		
	}
	
	public int smetypeModification(int smetype_id,String smetype_name) throws Exception
	{
		SMETypeInterface obj=new SMETypePojo();
		int result=obj.smetypeModification(smetype_id,smetype_name);
		
		return result;
	}
	
	public int smetypeDeletion(int smetype_id) throws Exception
	{
		System.out.println("in smetype deletion "+smetype_id);
		SMETypeInterface obj=new SMETypePojo();
		int result=obj.smetypeDeletion(smetype_id);
		
		
		return result;
	}
	
	public String Search() throws Exception
	{
		System.out.println("in smetype megahunt "+smetype_name);
		SMETypeInterface obj=new SMETypePojo();
	
		smetype_list=obj.megaHuntSMEType(smetype_name);
		
		return "success";
	}
	
	public String megaHuntSMETypeReport() throws Exception
	{
		System.out.println("in smetype megahuntreport "+smetype_name+"flag :: "+flag);
		SMETypeInterface obj=new SMETypePojo();
	
		smetype_list=obj.megaHuntSMEType(smetype_name);
		
			
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
			Document document = new Document(PageSize.A4,30,30,30,30);
			PdfWriter.getInstance(document, buffer);

			document.open();
			
			//Inserting Image in PDF
	        //Image image = Image.getInstance ("/home/rtizen04/workspace/IndusGatePass/src/export/d.jpg");
	        //image.scaleAbsolute(120f, 60f);//image width,height  
	        
	        
	       PdfPTable table=new PdfPTable(2);
	        
	       PdfPCell cell = new PdfPCell (new Paragraph ("SME Type Details"));

	       cell.setColspan (2);
	       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
	       cell.setPadding (10.0f);
	       cell.setBackgroundColor (new BaseColor (7, 6, 8));                                   

	       table.addCell(cell); 
	       table.addCell("SME Type Id");
	       table.addCell("SME Type Name");

	       System.out.println(smetype_list);
	       ListIterator li=smetype_list.listIterator();
	       while(li.hasNext())
	       {
	    	   SMETypeAction temp=(SMETypeAction)li.next();
	    	   table.addCell(String.valueOf(temp.getSmetype_id()));
	    	   table.addCell(temp.getSmetype_name());

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
		
		SMETypeInterface obj=new SMETypePojo();
		smetype_list=obj.generateSMETypeList(null,null);
		
			if(act.equals("Add")){
				
				if(smetype_name.trim().equals(""))
				{
					addFieldError("smetype_name","Please enter SME Type Name");
				}
				
			}
	   }

	public String getSmetype_name() {
		return smetype_name;
	}

	public void setSmetype_name(String smetype_name) {
		this.smetype_name = smetype_name;
	}

	public int getSmetype_id() {
		return smetype_id;
	}

	public void setSmetype_id(int smetype_id) {
		this.smetype_id = smetype_id;
	}

	public LinkedList getSmetype_list() {
		return smetype_list;
	}

	public void setSmetype_list(LinkedList smetype_list) {
		this.smetype_list = smetype_list;
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
