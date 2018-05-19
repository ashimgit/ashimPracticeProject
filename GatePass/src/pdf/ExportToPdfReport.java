package pdf;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Element;
import com.itextpdf.text.BaseColor;
import com.opensymphony.xwork2.ActionContext;

import connection.connection;


public class ExportToPdfReport {
	
	private InputStream inputStream;
	private String flag;


	
	
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




	public String execute() throws Exception 
	{
		System.out.println("in pdf section");
			
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		
		Document document = new Document(PageSize.A4,30,30,30,30);
		PdfWriter.getInstance(document, buffer);

		document.open();
		
		
        
        PdfPTable table=new PdfPTable(2);
        
       PdfPCell cell = new PdfPCell (new Paragraph ("catgory Details"));

       cell.setColspan (2);
       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
       cell.setPadding (10.0f);
       cell.setBackgroundColor (new BaseColor (140, 221, 8));                                   

       table.addCell(cell);    
       table.addCell("ID");
       table.addCell("Name");
       
       ExportToPdfInterface obj=new ExportToPdfPojo();
       ArrayList al=obj.exportToPdf(flag);
       
       for(int i=0;i<al.size();i++)
    	   table.addCell(al.get(i).toString());
				
			

		
		//document.add(p)
		document.add(table);
		document.close();
		
		
		inputStream = new ByteArrayInputStream(buffer.toByteArray());
		
		return "success";
		
	}
}
