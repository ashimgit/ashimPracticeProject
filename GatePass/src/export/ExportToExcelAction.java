package export;

import java.io.*;
import com.opensymphony.xwork2.ActionSupport;
 
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExportToExcelAction extends ActionSupport{
	
	private InputStream inputStream;
	private String reportFile;
	
	
	public String execute() throws Exception
	{
		  HSSFWorkbook myWorkBook = new HSSFWorkbook();
		  HSSFSheet mySheet = myWorkBook.createSheet();
		  HSSFSheet mySheet1 = myWorkBook.createSheet();
		  
		  try {
		  
		   reportFile = "Haddi.xls";
		 
		   Row headerRow = mySheet.createRow(0);
		   headerRow.setHeightInPoints(100);
		   Cell titleCell = headerRow.createCell(0);
		   titleCell.setCellValue("Haddi's First Excel Report");
		   
		   Row headerRow1 = mySheet1.createRow(0);
		   headerRow1.setHeightInPoints(100);
		   Cell titleCell1 = headerRow1.createCell(0);
		   titleCell.setCellValue("Haddi's Second Excel Report");
		 
		   setStudentAllInfo(mySheet);
		   setStudentAllInfo(mySheet1);
		 
		   try {
		    ByteArrayOutputStream boas = new ByteArrayOutputStream();
		    myWorkBook.write(boas);
		    setInputStream(new ByteArrayInputStream(boas.toByteArray()));
		   } catch (IOException e) {
		    e.printStackTrace();
		   }
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return "success";
		 }
	

	private void setStudentAllInfo(HSSFSheet mySheet) 
	{
			  int rowNum = 2;
			  HSSFRow myRow = null;
			  final String[] errorSource = { "Id", "Name" };
			  try {
				  
			   Row header = mySheet.createRow(1);
			   for (int i = 0; i < errorSource.length; i++) {
			    Cell monthCell = header.createCell(i);
			    monthCell.setCellValue(errorSource[i]);
			   }
			   
			    myRow = mySheet.createRow(2);
			    myRow.createCell(0).setCellValue("1");
			    myRow.createCell(1).setCellValue("Subhajit");
			   
			  } 
			  catch (Exception e) {
			   e.printStackTrace();
			  }
			 
			 }
	
	
	public String getReportFile() {
		  return reportFile;
		 }
		 
		 public void setReportFile(String reportFile) {
		  this.reportFile = reportFile;
		 }
		 
		 public InputStream getInputStream() {
		  return inputStream;
		 }
		 
		 public void setInputStream(InputStream inputStream) {
		  this.inputStream = inputStream;
		 }
		 
}
