package category;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

import org.apache.struts2.ServletActionContext;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

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

import district.DistrictAction;
import district.DistrictInterface;
import district.DistrictPojo;

public class CategoryAction extends ActionSupport{
	
	private int category_id;
	private String category_name;
	private LinkedList category_list=null;
	private String outputtext = "";
	private String act = "";
	private ByteArrayInputStream inputStream;
	private String ComparatorClass;
	
	
	

	 public String Asc()
	 {
		 ComparatorClass="CategoryAcsComparator";
		 return "success";
	 }
	 
	 public String Dsc()
	 {
		 ComparatorClass="CategoryDscComparator";
		 return "success";
	 }

	
	 public String dummyLink()
	 { 
		CategoryInterface obj=new CategoryPojo();
		category_list=obj.generateCategoryList(null,null);//Getting Category List
		
		if (category_list.size()==0)
		{
			outputtext = "No Category Present";
			addActionMessage(outputtext);
			return "success";
		}
		else if(category_list.size()!=0)
		{
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
		
		CategoryInterface obj=new CategoryPojo();
		category_name=internalTrimming(category_name.trim());


		if(act.equals("Add")){

			int message=obj.addCategory(category_name);
			category_name = "";
			category_list=obj.generateCategoryList(null,null);//Getting Category Name
		
			if (message == 1 )
			{
				outputtext = "Category Inserted Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			
			else if (message == 1001 )
			{
				outputtext = "WARNING!!!!!!!!!! Category Name Already Present.....";
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
			
			int message=obj.categoryModification(category_id,category_name);
			category_name = "";
			category_list=obj.generateCategoryList(null,null);//Getting Category Name
		
			if (message == 1 )
			{
				outputtext = "Category Updated Successfully.....";
				addActionMessage(outputtext);
				return "success"; 
			}
			
			else if (message == 1001 )
			{
				outputtext = "WARNING!!!!!!!!!! Category Name Already Present.....";
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
			
			int message=obj.categoryDeletion(category_id);
			category_name = "";
			category_list=obj.generateCategoryList(null,null);//Getting Category Name
		
			if (message == 1 )
			{
				outputtext = "Category Deleted Successfully.....";
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
	
	public String generateCategoryList() throws Exception
	{
		CategoryInterface obj=new CategoryPojo();
		category_list=obj.generateCategoryList(null,null);

		if (category_list != null)
			return "success";
		else
			return "home";
		
	}
	
	public String ShowAll() throws Exception
	{
		CategoryInterface obj=new CategoryPojo();
		category_list=obj.generateCategoryList(null,null);
		category_name="";

		if (category_list.size()==0)
			addActionMessage("No Categories Present.....");
		return "success";
		
	}
	
	public int categoryModification(int category_id,String category_name) throws Exception
	{
		CategoryInterface obj=new CategoryPojo();
		int t=obj.categoryModification(category_id,category_name);
		
		
		return t;
	}
	
	
	public int categoryDeletion(int category_id) throws Exception
	{
		CategoryInterface obj=new CategoryPojo();
		int result=obj.categoryDeletion(category_id);
		
		
		return result;
	}
	
	public String Search() throws Exception
	{
		System.out.println("in category megahuntcategory "+category_name);
		CategoryInterface obj=new CategoryPojo();
	
		category_list=obj.megaHuntCategory(category_name);
		

		
		return "success";
	}
	
	public String Pdf() throws Exception
	{
		CategoryInterface obj=new CategoryPojo();
		category_list=obj.megaHuntCategory(category_name);
		
			
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
			Document document = new Document(PageSize.A4,30,30,30,30);
			PdfWriter.getInstance(document, buffer);

			document.open();
	        
	        
	       PdfPTable table=new PdfPTable(2);
	        
	       PdfPCell cell = new PdfPCell (new Paragraph ("Category Details"));

	       cell.setColspan (2);
	       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
	       cell.setPadding (10.0f);
	       cell.setBackgroundColor (new BaseColor (10, 221, 8));                                   

	       table.addCell(cell); 
	       table.addCell("Category Id");
	       table.addCell("Category Name");


	       ListIterator li=category_list.listIterator();
	       while(li.hasNext())
	       {
	    	   CategoryAction temp=(CategoryAction)li.next();
	    	   table.addCell(String.valueOf(temp.getCategory_id()));
	    	   table.addCell(temp.getCategory_name());

	       }
	       
	       document.add(table);
	       document.close();
			
			
		   inputStream = new ByteArrayInputStream(buffer.toByteArray());
	       return "pdf";
		
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
		CategoryInterface obj=new CategoryPojo();
		category_list=obj.generateCategoryList(null,null);//Getting Category List
		
			if(act.equals("Add")){
				
				category_list=obj.generateCategoryList(null,null);//Getting Category List				
				
				if(category_name.trim().equals(""))
				{
					addFieldError("category_name","Please enter Category Name");
				}
				
			}
	   }
	

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	

	public String getOutputtext() {
		return outputtext;
	}

	public void setOutputtext(String outputtext) {
		this.outputtext = outputtext;
	}

	public LinkedList getCategory_list() {
		return category_list;
	}

	public void setCategory_list(LinkedList category_list) {
		this.category_list = category_list;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getComparatorClass() {
		return ComparatorClass;
	}

	public void setComparatorClass(String comparatorClass) {
		ComparatorClass = comparatorClass;
	}

}