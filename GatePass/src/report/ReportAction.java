package report;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFTextbox;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import state.StateAction;
import state.StateInterface;
import state.StatePojo;
import user.UserInterface;
import user.UserPojo;

import approval.ApprovalInterface;
import approval.ApprovalPojo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.*;
import java.util.Date;

public class ReportAction{
	
	private LinkedList message;
	private LinkedList message1;
	private LinkedList message11;
	private LinkedList message2;
	private LinkedList message3;
	private int sme_id;
	private String smetype_name;
	private String serviceprovider_name;
	private String modified_time;
	private String modified_by;
	private int unscheduled_req_id;
	private String unsme_mobile;
	private String datetime;
	private String name;
	private String purpose_name;
	private String sme_type="";
	private String GatePass="";
	private String outputtext = "";
	/* Appended */
	
	private String indus_tower_id;
	private String sme_mobile;
	private String interface_type;
	private String sme_schedule_type;
	private String sme_name;
	private String company_name;
	private String from;
	private String to;
	private String report;
	
	private InputStream inputStream;
	private String flag;
    private PdfContentByte tempalteBytes;
    private String bp="ss";
    private int serviceprovider_id;





	
    public String execute() throws Exception 
	{
		ReportInterface obj=new ReportPojo();
		String serviceprovider_id1 = ActionContext.getContext().getSession().get("serviceprovider_id").toString();
		serviceprovider_id = Integer.parseInt(serviceprovider_id1);
		message=obj.fetchSMEJoiningList(serviceprovider_id);
		if (message != null )
			return "link";
		else
			return "home";
		
	}
	public String SMEVisitApprovalList() throws Exception 
	{
		ReportInterface obj=new ReportPojo();
		message1=obj.fetchSMEVisitApprovalList();
		if (message1 != null)
			return "link";
		else
			return "home";
		
	}
	public String SMSSendReport() throws Exception 
	{
		ReportInterface obj=new ReportPojo();
		UserInterface obj1 = new UserPojo();
		String serviceprovider_id1 = ActionContext.getContext().getSession().get("serviceprovider_id").toString();
		serviceprovider_id = Integer.parseInt(serviceprovider_id1);
		message11 = obj1.execute(2);//Service Provider type
		message2=obj.fetchSMSSendReport(serviceprovider_id);
		if (message2 != null && (message11 != null))
			return "link";
		else
			return "home";
		
	}
	
	public String megaHuntReport() throws Exception 
	{
		System.out.println("in magahunt report :: "+report);
		
		ReportInterface obj=new ReportPojo();
		String serviceprovider_id1 = ActionContext.getContext().getSession().get("serviceprovider_id").toString();
		serviceprovider_id = Integer.parseInt(serviceprovider_id1);
		
		System.out.println("tower id :: "+indus_tower_id+" mobile :: "+sme_mobile+" interface :: "+interface_type+" schedule :: "+sme_schedule_type+" sme_name :: "+sme_name+" company_name :: "+company_name+" to :: "+to+" "+from);
		message2=obj.megaHuntSendSMS(indus_tower_id,sme_mobile,interface_type,sme_schedule_type,sme_name,company_name,from,to,serviceprovider_id);
			
		if(flag.equals("1")){
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
			Document document = new Document(PageSize.A4.rotate(),10,10,10,10);
			PdfWriter pages=PdfWriter.getInstance(document, buffer);

			document.open();
			document.addAuthor("Subhajit Kar");
		
			Float top=document.top();
			Float right=document.right();
			Float bottom=document.bottom();
			Float left=document.left();

			
			Paragraph p=new Paragraph();
			p.setAlignment(Element.ALIGN_CENTER);
			
			Chunk underline=new Chunk("REPORT ON SME VISIT");
			underline.setUnderline(0.5f,-2f);
			p.add(Chunk.NEWLINE);
			p.add(underline);
			
			Paragraph p1=new Paragraph();
			p1.add(Chunk.NEWLINE);
			p1.add("Report Generation Date :: "+new Date().toLocaleString());

	        /*    Criteria */
			PdfPTable criteria=new PdfPTable(8);
		    criteria.setWidthPercentage(100);
		    float[] columnWidths_criteria = {0.80f, 0.80f, 1.25f,1.5f,1f,1f,0.80f,0.80f};
		    criteria.setWidths(columnWidths_criteria);
		    
		    PdfPCell cell_c = new PdfPCell (new Paragraph ("Searching Criteria"));

		       cell_c.setColspan (8);
		       cell_c.setHorizontalAlignment (Element.ALIGN_CENTER);
		       cell_c.setPadding (10.0f);
		       cell_c.setBackgroundColor (BaseColor.PINK);                                   
		       criteria.addCell(cell_c); 
		       
		       
		       String tempo_c[]={"Tower Id","SME Mobile","Interface","SME Type","Name","Company","From","To"};
		       for(String t : tempo_c)
		       {
			       PdfPCell cell1_c = new PdfPCell (new Paragraph (t));
			       cell1_c.setHorizontalAlignment (Element.ALIGN_CENTER);
			       cell1_c.setPadding (10.0f);
			       cell1_c.setBackgroundColor (BaseColor.CYAN); 
			       criteria.addCell(cell1_c);
		       }
		       
		       criteria.addCell((indus_tower_id == null || indus_tower_id.equals(""))?"---":indus_tower_id);
		       criteria.addCell((sme_mobile == null || sme_mobile.equals(""))?"---":sme_mobile);
		       criteria.addCell((interface_type == null || interface_type.equals("") || interface_type.equals("undefined"))?"---":interface_type);
		       criteria.addCell((sme_schedule_type == null || sme_schedule_type.equals("") || sme_schedule_type.equals("undefined"))?"---":sme_schedule_type);
		       criteria.addCell((sme_name == null || sme_name.equals(""))?"---":sme_name);
		       criteria.addCell((company_name == null || company_name.equals("0"))?"---":company_name);
		       criteria.addCell((from == null || from.equals(""))?"---":from);
		       criteria.addCell((to == null || to.equals(""))?"---":to);

	       
		   /* Main Table */     
		   PdfPTable table=new PdfPTable(8);
	       table.setWidthPercentage(100);
	       float[] columnWidths = {0.80f, 0.80f, 1.25f,1.5f,1f,1f,0.80f,0.80f};
	       table.setWidths(columnWidths);


	        
	       PdfPCell cell = new PdfPCell (new Paragraph ("Send SMS Report"));

	       cell.setColspan (8);
	       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
	       cell.setPadding (10.0f);
	       cell.setBackgroundColor (BaseColor.LIGHT_GRAY);                                   

	       table.addCell(cell); 
	       String tempo[]={"Tower Id","SME Mobile","Request Date","SME Name","Company","Purpose","Interface","Type"};
	       for(String t : tempo)
	       {
		       PdfPCell cell1 = new PdfPCell (new Paragraph (t));
		       cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
		       cell1.setPadding (10.0f);
		       cell1.setBackgroundColor (BaseColor.CYAN); 
		       table.addCell(cell1);
	       }
	       table.setHeaderRows(2);
	       
	       /*table.addCell("Tower Id");
	       table.addCell("SME Mobile");
	       table.addCell("Request Date");
	       table.addCell("SME Name");
	       table.addCell("Company");
	       table.addCell("Purpose");
	       table.addCell("Interface");
	       table.addCell("Type");*/

	       int rows=0;
	       ListIterator li=message2.listIterator();
	       while(li.hasNext())
	       {
	    	   rows++;
	    	   ReportAction temp=(ReportAction)li.next();
	    	   table.addCell(temp.getIndus_tower_id());
	    	   table.addCell(temp.getUnsme_mobile());
	    	   table.addCell(temp.getDatetime());
	    	   table.addCell(temp.getName());
	    	   table.addCell(temp.getCompany_name());
	    	   table.addCell(temp.getPurpose_name());
	    	   table.addCell(temp.getInterface_type());
	   		   table.addCell(temp.getSme_type());
	       }
	       //table.setTotalWidth(30);
	       

	       document.add(p);
	       document.add(Chunk.NEWLINE);

	       document.add(p1);

	       document.add(Chunk.NEWLINE);
	       document.add(Chunk.NEWLINE);
	       document.add(criteria);
	       
	       document.add(Chunk.NEWLINE);
	       document.add(Chunk.NEWLINE);

	       document.add(table);
	       document.close();
			
			
		   inputStream = new ByteArrayInputStream(buffer.toByteArray());
		   
		   PdfReader haddi=new PdfReader(inputStream);
	       PdfStamper stamp = new PdfStamper(haddi,buffer);
	       
	       int noOfPages = haddi.getNumberOfPages();
	        int i = 0;
	        System.out.println("basepath is :: "+bp+" flag "+flag);
	        Image templateImage = Image.getInstance(bp+"ll.png");
	        templateImage.setAbsolutePosition(0, 0);
	        while (i < noOfPages)
	        {
	            i++;
	            tempalteBytes = stamp.getUnderContent(i);
	            tempalteBytes.addImage(templateImage);
	        }
	        
	       PdfContentByte cbq;
	        Font headerFont = new Font(FontFamily.COURIER, 15, Font.UNDERLINE);
	        for (int ii = 1; ii <= noOfPages; ii++) {
	            cbq = stamp.getOverContent(ii);
	            ColumnText ct = new ColumnText( cbq );
	            ct.setSimpleColumn(0,0,50,50);
	            ct.addElement( new Paragraph( String.valueOf(ii), headerFont ) );
	            ct.go();
	        }
	        
	        
	        stamp.close();
	        
	        
			inputStream = new ByteArrayInputStream(buffer.toByteArray());


	       return "success";
		}
			
		else
		{
			  HSSFWorkbook myWorkBook = new HSSFWorkbook();
			  HSSFSheet mySheet = myWorkBook.createSheet();
			  
			  try {
			 
			   Row headerRow = mySheet.createRow(0);
			   headerRow.setHeightInPoints(50);
			
			   
			   CellStyle cts1=myWorkBook.createCellStyle();
			   
			   cts1.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			   cts1.setFillPattern(CellStyle.SOLID_FOREGROUND);
			   
			   cts1.setBorderBottom(CellStyle.BORDER_THICK);
			   cts1.setBorderLeft(CellStyle.BORDER_THICK);
			   cts1.setBorderTop(CellStyle.BORDER_THICK);
			   cts1.setBorderRight(CellStyle.BORDER_THICK);
			   
			   cts1.setAlignment(CellStyle.ALIGN_CENTER);
			   cts1.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			   

			   Cell titleCell = headerRow.createCell(3);
			   mySheet.addMergedRegion(new CellRangeAddress(0,0,3,5));
			   titleCell.setCellStyle(cts1);
			   

			   
			  
			   titleCell.setCellValue("REPORT ON SME VISIT");
			   
			   setStudentAllInfo(mySheet,myWorkBook);
	
			 
			   try 
			   {
				   ByteArrayOutputStream boas = new ByteArrayOutputStream();
				   myWorkBook.write(boas);
				   setInputStream(new ByteArrayInputStream(boas.toByteArray()));
			   } 
			   catch (IOException e) 
			   {
				   e.printStackTrace();
			   }
			   
			  }
			  
			  
			  catch (Exception e) 
			  {
			   e.printStackTrace();
			  }
			  return "success1";
		}
	}
			
			
			

	private void setStudentAllInfo(HSSFSheet mySheet,HSSFWorkbook myWorkBook) 
	{
			  int rowNum = 2;
			  
			  HSSFRow myRowSC = null;
			  final String[] errorSourceSC = {"Tower Id","SME Mobile","Interface","SME Type","SME Name","Company","From","To"};
			  
			  HSSFRow myRow = null;
			  final String[] errorSource = {"Tower Id","SME Mobile","Request Date","SME Name","Company","Purpose","Interface","Type"};
			  try {
				  
				 CellStyle cts1 = myWorkBook.createCellStyle();
				 cts1.setFillForegroundColor(IndexedColors.GOLD.getIndex());
				 cts1.setFillPattern(CellStyle.SOLID_FOREGROUND);
				 org.apache.poi.ss.usermodel.Font font = myWorkBook.createFont();
			     font.setColor(IndexedColors.RED.getIndex());
			     cts1.setFont(font);
				  
			     
			     cts1.setAlignment(CellStyle.ALIGN_CENTER);
				 cts1.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
				   
				 cts1.setBorderBottom(CellStyle.BORDER_THICK);
				 cts1.setBorderLeft(CellStyle.BORDER_THICK);
				 cts1.setBorderTop(CellStyle.BORDER_THICK);
				 cts1.setBorderRight(CellStyle.BORDER_THICK);
				 
				 CellStyle cts5=myWorkBook.createCellStyle();
				   
				   cts5.setFillForegroundColor(IndexedColors.AQUA.getIndex());
				   cts5.setFillPattern(CellStyle.SOLID_FOREGROUND);
				   cts5.setAlignment(CellStyle.ALIGN_CENTER);
					 cts5.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
					 cts5.setBorderBottom(CellStyle.BORDER_THICK);
					 cts5.setBorderLeft(CellStyle.BORDER_THICK);
					 cts5.setBorderTop(CellStyle.BORDER_THICK);
					 cts5.setBorderRight(CellStyle.BORDER_THICK);
					 
					 mySheet.addMergedRegion(new CellRangeAddress(4,4,0,7));
					 mySheet.addMergedRegion(new CellRangeAddress(9,9,0,7));
				 
				 Row headerSC = mySheet.createRow(4);
				  headerSC.setHeightInPoints(40);
				   
				   /*for (int i = 0; i < errorSourceSC.length; i++) {
					    Cell monthCell = headerSC.createCell(i);
					    if(i==3)
					    	monthCell.setCellValue("Searching Criteria");
					    else
						    monthCell.setCellValue("");

					    monthCell.setCellStyle(cts5);

					   }*/
				  {
				    Cell monthCell = headerSC.createCell(0);
			    	monthCell.setCellValue("Searching Criteria");
				    monthCell.setCellStyle(cts5);
				  }



				  


				 
				 headerSC = mySheet.createRow(5);
				  headerSC.setHeightInPoints(40);
				   
				   for (int i = 0; i < errorSourceSC.length; i++) {
					    Cell monthCell = headerSC.createCell(i);
					    monthCell.setCellValue(errorSourceSC[i]);
					    monthCell.setCellStyle(cts1);

					   }
				   
				   myRowSC = mySheet.createRow(6);	   
					myRowSC.setHeightInPoints(25);
					
				    myRowSC.createCell(0).setCellValue(((indus_tower_id == null || indus_tower_id.equals(""))?"---":indus_tower_id));
				    myRowSC.createCell(1).setCellValue((sme_mobile == null || sme_mobile.equals(""))?"---":sme_mobile);
				    myRowSC.createCell(2).setCellValue((interface_type == null || interface_type.equals("") || interface_type.equals("undefined"))?"---":interface_type);
				    myRowSC.createCell(3).setCellValue((sme_schedule_type == null || sme_schedule_type.equals("") || sme_schedule_type.equals("undefined"))?"---":sme_schedule_type.equals("S")?"Scheduled":"Unscheduled");
				    myRowSC.createCell(4).setCellValue((sme_name == null || sme_name.equals(""))?"---":sme_name);
				    myRowSC.createCell(5).setCellValue((company_name == null || company_name.equals("0"))?"---":company_name);
				    myRowSC.createCell(6).setCellValue((from == null || from.equals(""))?"---":from);
				    myRowSC.createCell(7).setCellValue((to == null || to.equals(""))?"---":to);



				   
				   
					   
				    Row header = mySheet.createRow(9);
					   header.setHeightInPoints(40);
					   
					   /*for (int i = 0; i < errorSource.length; i++) {
					    Cell monthCell = header.createCell(i);
					    if(i==3)
					    	monthCell.setCellValue("Generated Report");
					    else
					    	monthCell.setCellValue("");

					    monthCell.setCellStyle(cts5);

					   }  */
					   {
						    Cell monthCell = header.createCell(0);
					    	monthCell.setCellValue("Generated Report");
						    monthCell.setCellStyle(cts5);

					   }
					   
				   
			   header = mySheet.createRow(10);
			   header.setHeightInPoints(40);
			   
			   for (int i = 0; i < errorSource.length; i++) {
			    Cell monthCell = header.createCell(i);
			    monthCell.setCellValue(errorSource[i]);
			    monthCell.setCellStyle(cts1);

			   }
			   
			   ListIterator li=message2.listIterator();
			   int i=11;
		       while(li.hasNext())
		       {
			   
			    myRow = mySheet.createRow(i++);	   
				myRow.setHeightInPoints(25);

		    	   ReportAction temp=(ReportAction)li.next();

			
			    myRow.createCell(0).setCellValue(temp.getIndus_tower_id());
			    myRow.createCell(1).setCellValue(temp.getUnsme_mobile());
			    myRow.createCell(2).setCellValue(temp.getDatetime());
			    myRow.createCell(3).setCellValue(temp.getName());
			    myRow.createCell(4).setCellValue(temp.getCompany_name());
			    myRow.createCell(5).setCellValue(temp.getPurpose_name());
			    myRow.createCell(6).setCellValue(temp.getInterface_type());
			    myRow.createCell(7).setCellValue(temp.getSme_type());


			   
			  } 
			  mySheet.autoSizeColumn(0);
			  mySheet.autoSizeColumn(1);
			  mySheet.autoSizeColumn(2);
			  mySheet.autoSizeColumn(3);
			  mySheet.autoSizeColumn(4);
			  mySheet.autoSizeColumn(5);
			  mySheet.autoSizeColumn(6);
			  mySheet.autoSizeColumn(7);
			  

			  }
			  catch (Exception e) {
			   e.printStackTrace();
			  }
			 
 }
	
	public String CheckGatePass() throws Exception 
	{
		return "link";
		
	}
	public String ValidatingGatePass() throws Exception 
	{
		ReportInterface obj=new ReportPojo();
		message3=obj.ValidatingGatePass(GatePass);
		if (message3 != null)
		{
			ListIterator itr = message3.listIterator();
			while(itr.hasNext())
			{
				ReportAction obj1 = (ReportAction)itr.next();
				unsme_mobile = obj1.getUnsme_mobile();
				indus_tower_id = obj1.getIndus_tower_id();
				datetime = obj1.getDatetime();
			}
			
			outputtext = "This GatePass is Valid and has been requested from Mobile No: "+unsme_mobile+" for Tower Code: "+indus_tower_id+" at "+datetime;
			return "success";
		}
		else
		{
			outputtext = "This GatePass is Not Valid";
			return "notvalid";
		}
	}
	
	
	public String megaHuntSendSMS() throws Exception 
	{
		ReportInterface obj=new ReportPojo();
		UserInterface obj1 = new UserPojo();
		String serviceprovider_id1 = ActionContext.getContext().getSession().get("serviceprovider_id").toString();
		serviceprovider_id = Integer.parseInt(serviceprovider_id1);
		
		message11 = obj1.execute(2);//Service Provider type
		System.out.println("tower id :: "+indus_tower_id+" mobile :: "+sme_mobile+" interface :: "+interface_type+" schedule :: "+sme_schedule_type+" sme_name :: "+sme_name+" company_name :: "+company_name+" to :: "+to+" "+from);
		message2=obj.megaHuntSendSMS(indus_tower_id,sme_mobile,interface_type,sme_schedule_type,sme_name,company_name,from,to,serviceprovider_id);
		//if (message2 != null)
			//return "link";
		//else
			return "success";
		
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
	public LinkedList getMessage11() {
		return message11;
	}
	public void setMessage11(LinkedList message11) {
		this.message11 = message11;
	}
	public LinkedList getMessage2() {
		return message2;
	}
	public void setMessage2(LinkedList message2) {
		this.message2 = message2;
	}
	public LinkedList getMessage3() {
		return message3;
	}
	public void setMessage3(LinkedList message3) {
		this.message3 = message3;
	}
	public int getSme_id() {
		return sme_id;
	}
	public void setSme_id(int sme_id) {
		this.sme_id = sme_id;
	}
	public String getSmetype_name() {
		return smetype_name;
	}
	public void setSmetype_name(String smetype_name) {
		this.smetype_name = smetype_name;
	}
	public String getServiceprovider_name() {
		return serviceprovider_name;
	}
	public void setServiceprovider_name(String serviceprovider_name) {
		this.serviceprovider_name = serviceprovider_name;
	}
	public String getModified_time() {
		return modified_time;
	}
	public void setModified_time(String modified_time) {
		this.modified_time = modified_time;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public int getUnscheduled_req_id() {
		return unscheduled_req_id;
	}
	public void setUnscheduled_req_id(int unscheduled_req_id) {
		this.unscheduled_req_id = unscheduled_req_id;
	}
	public String getUnsme_mobile() {
		return unsme_mobile;
	}
	public void setUnsme_mobile(String unsme_mobile) {
		this.unsme_mobile = unsme_mobile;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPurpose_name() {
		return purpose_name;
	}
	public void setPurpose_name(String purpose_name) {
		this.purpose_name = purpose_name;
	}
	public String getSme_type() {
		return sme_type;
	}
	public void setSme_type(String sme_type) {
		this.sme_type = sme_type;
	}
	public String getGatePass() {
		return GatePass;
	}
	public void setGatePass(String gatePass) {
		GatePass = gatePass;
	}
	public String getIndus_tower_id() {
		return indus_tower_id;
	}
	public void setIndus_tower_id(String indus_tower_id) {
		this.indus_tower_id = indus_tower_id;
	}
	public String getSme_mobile() {
		return sme_mobile;
	}
	public void setSme_mobile(String sme_mobile) {
		this.sme_mobile = sme_mobile;
	}
	public String getInterface_type() {
		return interface_type;
	}
	public void setInterface_type(String interface_type) {
		this.interface_type = interface_type;
	}
	public String getSme_schedule_type() {
		return sme_schedule_type;
	}
	public void setSme_schedule_type(String sme_schedule_type) {
		this.sme_schedule_type = sme_schedule_type;
	}
	public String getSme_name() {
		return sme_name;
	}
	public void setSme_name(String sme_name) {
		this.sme_name = sme_name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
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
	public PdfContentByte getTempalteBytes() {
		return tempalteBytes;
	}
	public void setTempalteBytes(PdfContentByte tempalteBytes) {
		this.tempalteBytes = tempalteBytes;
	}
	public String getBp() {
		return bp;
	}
	public void setBp(String bp) {
		this.bp = bp;
	}
	public int getServiceprovider_id() {
		return serviceprovider_id;
	}
	public void setServiceprovider_id(int serviceprovider_id) {
		this.serviceprovider_id = serviceprovider_id;
	}
	public String getOutputtext() {
		return outputtext;
	}
	public void setOutputtext(String outputtext) {
		this.outputtext = outputtext;
	}

	
}

