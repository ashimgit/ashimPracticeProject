package user;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import purpose.PurposeAction;
import purpose.PurposeInterface;
import purpose.PurposePojo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import district.DistrictInterface;
import district.DistrictPojo;

import sme.SMEInterface;
import sme.SMEPojo;
import serviceprovider.*;

public class UserAction extends ActionSupport
{
	
	private int user_id;
	private String mobile_no = "";
	private String user_name = "";
	private String name = "";
	private String password = "";
	private int serviceprovider_id;
	private String serviceprovider_name = "";
	private String outputtext = "";
	private LinkedList usertype_list;
	private LinkedList serviceprovider_list;
	private int usertype_id;
	private String usertype_name = "";
	private String act="";
	private String status;
	
	
	private LinkedList user_list=null;
	
	private InputStream inputStream;
	private String flag;
	
	public String dummyLink() throws Exception 
	{
		String serviceprovider_id1=(String)ActionContext.getContext().getSession().get("serviceprovider_id");
		String usertype_id1=(String)ActionContext.getContext().getSession().get("usertypeid");
		int userid1=(Integer)ActionContext.getContext().getSession().get("userid");
		
		UserInterface obj = new UserPojo();
		usertype_list = obj.execute(1);//Getting User Type List
		serviceprovider_list= obj.execute(2);//Getting service Provider List
		
		user_list=obj.generateUserList(userid1,serviceprovider_id1,usertype_id1);//Getting User List
		if (serviceprovider_list == null && usertype_list == null)
		{
			outputtext = "Please Enter Service Provider First & User Type First";
			addActionMessage(outputtext);
			return "success";
		}
		else if(serviceprovider_list != null && usertype_list == null)
		{
			outputtext = "Please Enter User Type First";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if(serviceprovider_list == null && usertype_list != null)
		{
			outputtext = "Please Enter Service Provider First";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if(user_list == null)
		{
			outputtext = "No User Present";
			addActionMessage(outputtext);
			return "success";
		}
		else
		{
			addActionMessage(outputtext);
			return "success"; 
		}
	}

	public String Addition() throws Exception  
	{
		String serviceprovider_id1=(String)ActionContext.getContext().getSession().get("serviceprovider_id");
		String usertype_id1=(String)ActionContext.getContext().getSession().get("usertypeid");
		int userid1=(Integer)ActionContext.getContext().getSession().get("userid");
		UserInterface obj = new UserPojo();
		usertype_list = obj.execute(1);//Getting User Type List
		serviceprovider_list= obj.execute(2);//Getting service Provider List
		if(act.equals("Add")){
		int message = obj.adduser(mobile_no,user_name,usertype_id,password,serviceprovider_id,name);
		user_list=obj.generateUserList(userid1,serviceprovider_id1,usertype_id1);//Getting User List
		serviceprovider_id = -1;
		usertype_id = -1;
		user_name = "";
		mobile_no = "";
		name = "";
		if (message == 1 )
		{
			outputtext = "User Inserted Successfully";
			addActionMessage(outputtext);
			return "success"; 
		}
		else if (message == 1001 )
		{
			outputtext = "User Mobile Number Already Present";
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
			int message=obj.UserModification(user_id,mobile_no,user_name,name,password,serviceprovider_id,usertype_id);
			user_list=obj.generateUserList(userid1,serviceprovider_id1,usertype_id1);//Getting User List
			serviceprovider_id = -1;
			usertype_id = -1;
			user_name = "";
			mobile_no = "";
			name = "";
			if (message == 1 )
			{
				outputtext = "User Modified Successfully";
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
			int message = obj.userDeletion(user_id);
			user_list=obj.generateUserList(userid1,serviceprovider_id1,usertype_id1);//Getting User List
			serviceprovider_id = -1;
			usertype_id = -1;
			user_name = "";
			mobile_no = "";
			name = "";
			if (message == 1 )
			{
				outputtext = "User Deleted Successfully";
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
	
	public String generateUserList() throws Exception
	{
		UserInterface obj=new UserPojo();
		user_list=obj.generateUserList(0,null,null);
		usertype_list = obj.execute(1);
		serviceprovider_list= obj.execute(2);
		if ((usertype_list != null) && (serviceprovider_list != null) && (user_list != null))
			return "success";
		else
			return "home";
		
	}
	
	public String UserModification() throws Exception
	{
		UserInterface obj=new UserPojo();
		int result=obj.UserModification(user_id,mobile_no,user_name,name,password,serviceprovider_id,usertype_id);
		//System.out.println("ok bye ::"+sme_id+" "+sme_name+" "+mobile+" "+serviceprovider_id+" "+smetype_id);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(result);
		return null;
	}
	
	public String UserDeletion() throws Exception
	{
		System.out.println("in district deletion "+user_id);
		UserInterface obj=new UserPojo();
		int result=obj.userDeletion(user_id);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(result);
		return null;
	}
	
	public String megaHuntUser() throws Exception
	{
		UserInterface obj=new UserPojo();
	
		user_list=obj.megaHuntUser(name,mobile_no,serviceprovider_id,usertype_id);
		//System.out.println("action :: "+((DistrictAction)usertype_list.get(0)).getDistrict_name());
		
		ServiceProviderInterface obj1=new ServiceProviderPojo();
		serviceprovider_list = obj1.generateServiceProviderList(null,null);
		
		UserTypeInterface obj2=new UserTypePojo();
		usertype_list = obj2.generateUserTypeList(null,null);

		
		return "success";
	}
	
	
	public String megaHuntUserReport() throws Exception
	{
		System.out.println("in uwer megahuntreport "+name+"flag :: "+flag);
		UserInterface obj=new UserPojo();
	
		user_list=obj.megaHuntUser(name,mobile_no,serviceprovider_id,usertype_id);
		
			
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
			Document document = new Document(PageSize.A4,30,30,30,30);
			PdfWriter.getInstance(document, buffer);

			document.open();
			
			//Inserting Image in PDF
	        //Image image = Image.getInstance ("/home/rtizen04/workspace/IndusGatePass/src/export/d.jpg");
	        //image.scaleAbsolute(120f, 60f);//image width,height  
	        
	        
	       PdfPTable table=new PdfPTable(7);
	        
	       PdfPCell cell = new PdfPCell (new Paragraph ("User Details"));

	       cell.setColspan (7);
	       cell.setHorizontalAlignment (Element.ALIGN_CENTER);
	       cell.setPadding (10.0f);
	       cell.setBackgroundColor (BaseColor.PINK);                                   

	       table.addCell(cell);
	       table.addCell("Id");
	       table.addCell("User Id");
	       table.addCell("Mobile no");
	       table.addCell("Name");
	       table.addCell("Password");
	       table.addCell("Service Provider");
	       table.addCell("User Type");


	       System.out.println(user_list);
	       ListIterator li=user_list.listIterator();
	       while(li.hasNext())
	       {
	    	   UserAction temp=(UserAction)li.next();
	    	   table.addCell(String.valueOf(temp.getUser_id()));
	    	   table.addCell(temp.getUser_name());
	    	   table.addCell(temp.getMobile_no());
	    	   table.addCell(temp.getName());
	    	   table.addCell(temp.getPassword());
	    	   table.addCell(temp.getServiceprovider_name());
	    	   table.addCell(temp.getUsertype_name());

	       }
	       
	       document.add(table);
	       document.close();
			
			
		   inputStream = new ByteArrayInputStream(buffer.toByteArray());
	       return "success";
		
	}

	public void validate()
	   {
		
		String serviceprovider_id1=(String)ActionContext.getContext().getSession().get("serviceprovider_id");
		String usertype_id1=(String)ActionContext.getContext().getSession().get("usertypeid");
		int userid1=(Integer)ActionContext.getContext().getSession().get("userid");
		
		UserInterface obj = new UserPojo();
		usertype_list = obj.execute(1);//Getting User Type List
		serviceprovider_list= obj.execute(2);//Getting service Provider List
		user_list=obj.generateUserList(userid1,serviceprovider_id1,usertype_id1);//Getting User List
		
			if(act.equals("Add")){
				
				if(mobile_no.trim().equals(""))
				{
					addFieldError("mobile_no","Please Enter Mobile Number.....");
				}
				if(usertype_id==-1)
				{
					addFieldError("usertype_id","Please Select UserType.....");
				}
				if(user_name.trim().equals(""))
				{
					addFieldError("user_name","Please Enter User Name.....");
				}
				if(password.trim().equals(""))
				{
					addFieldError("password","Please Enter Password.....");
				}
				if(name.trim().equals(""))
				{
					addFieldError("name","Please Enter Name.....");
				}
				if(serviceprovider_id1.equals("70"))
				{
					if(serviceprovider_id==-1)
					{
						addFieldError("serviceprovider_id","Please select Service Provider.....");
					}
				}
				
			}
	   }
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getServiceprovider_id() {
		return serviceprovider_id;
	}

	public void setServiceprovider_id(int serviceprovider_id) {
		this.serviceprovider_id = serviceprovider_id;
	}

	public String getServiceprovider_name() {
		return serviceprovider_name;
	}

	public void setServiceprovider_name(String serviceprovider_name) {
		this.serviceprovider_name = serviceprovider_name;
	}

	

	public LinkedList getUsertype_list() {
		return usertype_list;
	}

	public void setUsertype_list(LinkedList usertype_list) {
		this.usertype_list = usertype_list;
	}

	public LinkedList getServiceprovider_list() {
		return serviceprovider_list;
	}

	public void setServiceprovider_list(LinkedList serviceprovider_list) {
		this.serviceprovider_list = serviceprovider_list;
	}

	public int getUsertype_id() {
		return usertype_id;
	}

	public void setUsertype_id(int usertype_id) {
		this.usertype_id = usertype_id;
	}

	public String getUsertype_name() {
		return usertype_name;
	}

	public void setUsertype_name(String usertype_name) {
		this.usertype_name = usertype_name;
	}

	public LinkedList getUser_list() {
		return user_list;
	}

	public void setUser_list(LinkedList user_list) {
		this.user_list = user_list;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
