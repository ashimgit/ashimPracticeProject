package export;

import java.io.*;
import java.sql.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Image;
import com.itextpdf.text.Element;
import com.itextpdf.text.BaseColor;

import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfContentByte;





public class ExportToPdfAction {
	
	private InputStream inputStream;


	public void setInputStream(InputStream inputStream) {
	this.inputStream = inputStream;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public String execute() throws Exception 
	{
		
			
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		
		Document document = new Document(PageSize.A5,30,30,30,30);
		PdfWriter.getInstance(document, buffer);

		document.open();
		
		//Inserting Image in PDF
        Image image = Image.getInstance ("/home/rtizen04/workspace/IndusGatePass/src/export/subha.png");
        image.scaleAbsolute(120f, 60f);//image width,height  
        
        
        PdfPTable table=new PdfPTable(2);
        
       PdfPCell cell = new PdfPCell (new Paragraph ("Details"));

       cell.setColspan (2);
       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
       cell.setPadding (10.0f);
       cell.setBackgroundColor (new BaseColor (140, 221, 8));                                   

       table.addCell(cell);    
       
       PdfPTable table1=new PdfPTable(1);
    
     /*table.addCell("1");
     table.addCell("2");
     table.addCell("3");
     table.addCell("4");
     table.addCell("5");
     table.addCell("United States");
     table.addCell("Haddi");*/
     //table.addCell("Haru");
     //table.setSpacingBefore(30.0f);       // Space Before table starts, like margin-top in CSS
     //table.setSpacingAfter(30.0f);      // Space After table starts, like margin-Bottom in CSS                                          
        
		//Paragraph p = new Paragraph();
		//p.add(" Haddi Come here lets dance ");
		//p.add("\n =============================================================");
		//try 
		//{
			/*p.add("\n Employee Id : 1");
			p.add("\n Name : Subhajit Kar");
			p.add("\n Salary :: 50000");
			p.add("\n Company :: IBM");
			p.add(image);
			p.add("\n =============================================================");*/
		/*} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}*/
		
       Class.forName("com.mysql.jdbc.Driver");
		try 
		{
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root" );
        	con.setAutoCommit(false);
			String q = "select distinct id from t";

			PreparedStatement pst = con.prepareStatement(q);
			ResultSet rs = pst.executeQuery();
		
			while(rs.next())
			{
				q="select * from t where id='"+rs.getString(1)+"'";
				
				PreparedStatement pst1 = con.prepareStatement(q);
				ResultSet rs1 = pst1.executeQuery();
				
				//int count=0;
				while(rs1.next())
				{
					table1.addCell(rs1.getString(2));
					//count++;
					
				}
				table.addCell(rs.getString(1));
				table.addCell(table1);
				table1.deleteBodyRows();
				
				
			}
			con.close();
		
		
		PdfReader reader = new PdfReader(buffer.toByteArray());
		System.out.println(reader.getNumberOfPages());

		PdfStamper stamp = new PdfStamper(reader, buffer);
		PdfContentByte under=stamp.getUnderContent(1);
		under.addImage(image);
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		document.setPageCount(5);
		//document.add(p);
		//document.add(image);
		document.add(table);
		document.close();
		
		
		inputStream = new ByteArrayInputStream(buffer.toByteArray());
		
		return "success";
		
	}
}

