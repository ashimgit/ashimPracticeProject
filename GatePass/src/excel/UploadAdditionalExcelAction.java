package excel;

import gatekeeper.*;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import tower.*;
import district.*;

import com.opensymphony.xwork2.*;

public class UploadAdditionalExcelAction  extends ActionSupport implements ServletRequestAware
{
	private File excel;
	private HttpServletRequest request;
	private String excelContentType;  
	private String excelFileName;
	private String supervisor_name = "";
	private String supervisor_mobile = "";
	private String outputtext = "";
	private String message_vs_table;
	private String reason = "";
	private String designation = "";
	private String value = "";
     
	public String execute() throws Exception 
	{
		return "success";
	}
	
	public String uploadadditionalexcel() throws Exception 
	{
		String insertvalue = "NULL";
		System.out.println("in uploadExcell :: "+excel+" "+excelContentType+" "+excelFileName);
		System.out.println("1st request :: "+ServletActionContext.getRequest().getServletContext().getRealPath("/"));
		//String filepath=ServletActionContext.getRequest().getServletContext().getRealPath("/").concat("userImages");
		//File fileToCreate = new File(filepath, this.excelFileName);  
        //FileUtils.copyFile(excel, fileToCreate);
		Long t1 = System.currentTimeMillis();
        FileInputStream file = new FileInputStream(excel); // Input Buffer (Stream) for Excel
        XSSFWorkbook workbook = new XSSFWorkbook(file); // Creating Virtual excel file
        
/******************************************************************************************************************
        WorkBook
        sheet
        Row
        Column
        Value
******************************************************************************************************************/

        XSSFSheet sheet = workbook.getSheetAt(0); // 0 means first sheet
        //System.out.println("** :: "+sheet.getPhysicalNumberOfRows()+" ** "+sheet.getLastRowNum());
        int count = 0;
        int i = 0;
        Iterator rowIterator = sheet.rowIterator();
        while(rowIterator.hasNext()) // Getting a whole row
        {
        	ArrayList insert_value = new ArrayList();
        	XSSFRow row = (XSSFRow)rowIterator.next();
        	if(count == 0)
        	{
        		System.out.println("First Row : "+ count);
        		while(i < row.getLastCellNum()) // Getting the value of each cell
            	{
        			XSSFCell cell= row.getCell(i);
            		DataFormatter df = new DataFormatter();
            		value = df.formatCellValue(cell);
            		System.out.println("First Row Value: "+ value);
            		i++;
            	}
        		i = 0;
        	}
        	else
        	{
        		
        		System.out.println("From Second Row : "+ count);
        		while(i < row.getLastCellNum()) // Getting the value of each cell
            	{
            		
            		XSSFCell cell= row.getCell(i);
            		DataFormatter df = new DataFormatter();
            		value = df.formatCellValue(cell);
            		value = value.replace('\'', ' ');
            		//if(value.length() > 100)
                		//value = value.substring(0, 100);
            		i++;
            	}
        		i = 0;
            }
        	
            System.out.println("value : "+value);
            count++;
            
            UploadAdditionalExcelPojo uaep = new UploadAdditionalExcelPojo();
            int addadditionalexcel = uaep.tower_vs_supervisor(value, supervisor_name, supervisor_mobile, designation, reason);
            if(addadditionalexcel == 1)
            {
            	System.out.println("count :: "+count +":::Done ::::"+addadditionalexcel);
            }
            else
            {
            	System.out.println("count :: "+count);
            }
        }
        Long t2=System.currentTimeMillis();
		System.out.println("time :: "+(t2-t1));
		outputtext = "Total Time Taken = "+(t2-t1);
		designation = "";
		supervisor_name = "";
		supervisor_mobile = "";
		reason = "";
		return "success";
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	public File getExcel() {
		return excel;
	}

	public void setExcel(File excel) {
		this.excel = excel;
	}

	public String getExcelContentType() {
		return excelContentType;
	}

	public void setExcelContentType(String excelContentType) {
		this.excelContentType = excelContentType;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public String getSupervisor_name() {
		return supervisor_name;
	}

	public void setSupervisor_name(String supervisor_name) {
		this.supervisor_name = supervisor_name;
	}

	public String getSupervisor_mobile() {
		return supervisor_mobile;
	}

	public void setSupervisor_mobile(String supervisor_mobile) {
		this.supervisor_mobile = supervisor_mobile;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

	
	
}
