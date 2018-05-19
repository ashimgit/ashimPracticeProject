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


public class UploadExcelAction extends ActionSupport implements ServletRequestAware
{
	private File excel;
	private HttpServletRequest request;
	private String excelContentType;  
	private String excelFileName;
	private String gatekeeper_name = "";
	private String mobile_no = "";
	private String outputtext = "";
	private String message_vs_table;
	private String site_name = "";
	private String address = "";
	private String tower_type = "";
	private int district_id = 21;
	private String height = "";
	private String latitude = "";
	private String longitude = "";
	private String indus_tower_code = "";
	private String gatekeeper_mobile = "";
	private String clustermanager_mobile = "";
     
	public String execute() throws Exception 
	{
		return "success";
	}
	
	public String uploadexcel() throws Exception 
	{
		String insertvalue = "NULL";
		int first_cell = 0;
		int second_cell = 0;
		int tower_not_present = 0;
		int gatekeeper_not_present = 0;
		
		LinkedList tower_list = new LinkedList();
		LinkedList gatekeeper_list = new LinkedList();
		TowerInterface ti = new TowerPojo();
		GateKeeperInterface gi = new GateKeeperPojo();
		DistrictInterface di = new DistrictPojo();
		
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
            		String value = df.formatCellValue(cell);
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
            		String value = df.formatCellValue(cell);
            		value = value.replace('\'', ' ');
            		//if(value.length() > 100)
                		//value = value.substring(0, 100);
            		if(first_cell == 0) // Checking the Tower ID Present or not
            		{
            			tower_list = ti.checkTowerList(value,"2");
            			System.out.println("tower_list : "+tower_list);
            			if(tower_list.size() == 0) // Tower Present
            			{
            				insert_value.add(value);
            				tower_not_present = 1;
            				System.out.println("tower_not_present : "+tower_not_present);
            			}
            			else // Tower Not Present
            			{
            				insert_value.add(value);
            				System.out.println("tower_present : "+tower_not_present);
            			}
            			first_cell = 1;
            		}
            		else if(second_cell == 0) // Checking the GateKeeper Present or not
            		{
            			gatekeeper_list = gi.generateGateKeeperList(value,"2");
            			if (gatekeeper_list.size() == 0) // GateKeeper Present
            			{
            				insert_value.add(value);
            				gatekeeper_not_present = 1;
            				System.out.println("gatekeeper_not_present : "+gatekeeper_not_present);
            			}
            			else // GateKeeper Not Present
            			{
            				insert_value.add(value);
            				System.out.println("gatekeeper_present : "+gatekeeper_not_present);
            			}
            			second_cell = 1;
            		}
            		else
            		{
            			insert_value.add(value);
            		}
            		
            		
            		i++;
            	}
        		i = 0;
            }
        	
            System.out.println("insert_value : "+insert_value);
            if(count != 0){
            indus_tower_code = (String) insert_value.get(0);
            gatekeeper_mobile = (String) insert_value.get(1);
            site_name = (String) insert_value.get(3);
            address = (String) insert_value.get(4);
            tower_type = (String) insert_value.get(5);
            String district_name = (String) insert_value.get(6);
            latitude = (String) insert_value.get(7);
            longitude = (String) insert_value.get(8);
            clustermanager_mobile = (String) insert_value.get(10);
            
            district_id = Integer.parseInt(district_name);
            //district_id = di.searchdistrict(district_name);
            System.out.println("district_id : "+district_id);
            
            if(district_id == 0)district_id = 21;
            if(gatekeeper_not_present == 1)
            {
            	System.out.println("gatekeeper_not_present : "+gatekeeper_not_present);
            	gatekeeper_name = (String) insert_value.get(2);
            	mobile_no = gatekeeper_mobile;
            	int message = gi.addGateKeeper(mobile_no,gatekeeper_name,"2",70);
            	if(message > 0)
            	{
            		System.out.println("gatekeeper_added : "+message);
            		if(tower_not_present == 1)
            		{
            			System.out.println("tower_not_present : "+tower_not_present);
            			int message1 = ti.addTower(site_name,address,tower_type,district_id,height,latitude,longitude,indus_tower_code,gatekeeper_mobile,clustermanager_mobile);
            			if(message1 > 0)
            			{
            				System.out.println("tower_added : "+message1);
            				System.out.println("Tower Id "+insert_value.get(0)+" Inserted Successfully.....");
            			}
            			else
            			{
            				System.out.println("tower_not_added : "+message1);
            				System.out.println("Tower Id "+insert_value.get(0)+" Can't be Inserted!!!!! Something Went Wrong.... Pls try again Later.....");
            			}
            		}
            		else
            		{
            			System.out.println("tower_present : "+tower_not_present);
            			int message2 = ti.towerModification(indus_tower_code,site_name,address,tower_type,height,latitude,longitude,district_id,gatekeeper_mobile,clustermanager_mobile);
            			if(message2 > 0)
            			{
            				System.out.println("tower_modified : "+message2);
            				System.out.println("Tower Id "+insert_value.get(0)+" Updated Successfully.....");
            			}
            			else
            			{
            				System.out.println("tower_not_modified : "+message2);
            				System.out.println("Tower Id "+insert_value.get(0)+" Can't be Updated!!!!! Something Went Wrong.... Pls try again Later.....");
            			}
            		}
            	}
            	else
            	{
            		System.out.println("gatekeeper_not_added : "+message);
            		System.out.println("GateKeeper Name : "+insert_value.get(2)+" GateKeeper Mobile : "+insert_value.get(1)+"Can't be Inserted!!!!! Something Went Wrong.... Pls try again Later.....");
            	}
            }
            else if(gatekeeper_not_present == 0)
            {
            	System.out.println("gatekeeper_present : "+gatekeeper_not_present);
            	if(tower_not_present == 1)
        		{
            		System.out.println("tower_not_present : "+tower_not_present);
            		int message1 = ti.addTower(site_name,address,tower_type,district_id,height,latitude,longitude,indus_tower_code,gatekeeper_mobile,clustermanager_mobile);
        			if(message1 > 0)
        			{
        				System.out.println("tower_added : "+message1);
        				System.out.println("Tower Id "+insert_value.get(0)+" Inserted Successfully.....");
        			}
        			else
        			{
        				System.out.println("tower_not_added : "+message1);
        				System.out.println("Tower Id "+insert_value.get(0)+" Can't be Inserted!!!!! Something Went Wrong.... Pls try again Later.....");
        			}
        		}
        		else
        		{
        			int message2 = ti.towerModification(indus_tower_code,site_name,address,tower_type,height,latitude,longitude,district_id,gatekeeper_mobile,clustermanager_mobile);
        			if(message2 > 0)
        			{
        				System.out.println("tower_modified : "+message2);
        				System.out.println("Tower Id "+insert_value.get(0)+" Updated Successfully.....");
        			}
        			else
        			{
        				System.out.println("tower_not_modified : "+message2);
        				System.out.println("Tower Id "+insert_value.get(0)+" Can't be Updated!!!!! Something Went Wrong.... Pls try again Later.....");
        			}
        		}
            }
            
            }
            tower_not_present = 0;
            gatekeeper_not_present = 0;
            first_cell = 0;
            second_cell = 0;
            //insert_value = null;
            count++;
            System.out.println("count :: "+count);
        }
        Long t2=System.currentTimeMillis();
		System.out.println("time :: "+(t2-t1));
		outputtext = "Total Time Taken = "+(t2-t1);
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

	public String getGatekeeper_name() {
		return gatekeeper_name;
	}

	public void setGatekeeper_name(String gatekeeper_name) {
		this.gatekeeper_name = gatekeeper_name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
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

	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTower_type() {
		return tower_type;
	}

	public void setTower_type(String tower_type) {
		this.tower_type = tower_type;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getIndus_tower_code() {
		return indus_tower_code;
	}

	public void setIndus_tower_code(String indus_tower_code) {
		this.indus_tower_code = indus_tower_code;
	}

	public String getGatekeeper_mobile() {
		return gatekeeper_mobile;
	}

	public void setGatekeeper_mobile(String gatekeeper_mobile) {
		this.gatekeeper_mobile = gatekeeper_mobile;
	}

	public String getClustermanager_mobile() {
		return clustermanager_mobile;
	}

	public void setClustermanager_mobile(String clustermanager_mobile) {
		this.clustermanager_mobile = clustermanager_mobile;
	}

	
}
