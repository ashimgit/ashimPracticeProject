package login;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.opensymphony.xwork2.*;

public class LoginAction extends ActionSupport implements ServletRequestAware
{
	private String username = "";
	private String password = "";
	private String message = "";
	SessionMap<String, String> sessionmap;
	HttpServletRequest req = null;
	ArrayList al=null;
	ArrayList al1=null;
	private String head = "";
	private String sub = "";
	private String image = "";
	private String links = "";
	LinkedList message_send_list = new LinkedList();
	private String outputtext1 = "";
	private String outputtext2 = "";
	private String outputtext3 = "";
	private String outputtext4 = "";
	private String outputtext5 = "";
	
	public String execute() throws Exception 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		LinkedList userdetails = null;
		LoginInterface obj = new LoginPojo();
		userdetails = obj.logincheck(username,password);
		System.out.println("userdetails :: "+userdetails);
		int size = userdetails.size();
		if(size > 0)
		{
			String ra = req.getRemoteAddr();
			System.out.println("ra :: "+ra);
			int userid = (Integer) userdetails.get(0);
			int log_details = obj.insert_log_details(userid,ra);
			if(log_details == 1)
			{
					ActionContext.getContext().getSession().put("userid", userdetails.get(0));
					ActionContext.getContext().getSession().put("mobile", userdetails.get(1));
					ActionContext.getContext().getSession().put("name", userdetails.get(2));
					ActionContext.getContext().getSession().put("usertypeid", userdetails.get(3));
					ActionContext.getContext().getSession().put("serviceprovider_id", userdetails.get(4));
					ActionContext.getContext().getSession().put("login_time", userdetails.get(5));
					ActionContext.getContext().getSession().put("ip", userdetails.get(6));
					
					al = obj.getDynamicMenu(userdetails.get(3).toString());
					if(al == null || al.size() == 0)
					{
						message = "Login Not Posssible Due to Some Technical Issue";
						return "failure";
					}
					if(Integer.parseInt((String)userdetails.get(3)) == 1) // Admin
					{	
						message_send_list = obj.message_send_tillnow();
						System.out.println("message_send_list : "+message_send_list);
						if(message_send_list.size() != 0)
						{
							outputtext1 = "Number Of Scheduled SMS Send Via Web = "+message_send_list.get(0);
							outputtext2 = "Number Of Scheduled SMS Send Via Mobile = "+message_send_list.get(1);
							outputtext3 = "Number Of UnScheduled SMS Send Via Web = "+message_send_list.get(2);
							outputtext4 = "Number Of UnScheduled SMS Send Via Mobile = "+message_send_list.get(3);
							outputtext5 = "Total SMS Send From 01.02.2015 to "+dateFormat.format(date)+" = "+((Integer.parseInt((String)message_send_list.get(0))) + (Integer.parseInt((String)message_send_list.get(1))) + (Integer.parseInt((String)message_send_list.get(2))) + (Integer.parseInt((String)message_send_list.get(3)))) ;
						}
					}
					
					ActionContext.getContext().getSession().put("dynamic_menu",al);
					return "success";
			}
			else
			{
				System.out.println("Insert into Log_Details Not Successfull");
				message = "Login Not Posssible Due to Some Technical Issue";
				return "failure";
			}
		}
		else
		{
			System.out.println("UserName & Password Not Matching");
			message = "Invalid User Name or Password";
			return "failure";
		}
			
	}
	
	public void setSession(Map map) 
	{
		sessionmap = (SessionMap) map;
		sessionmap.put("login", "true");
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void validate()
	{
	      if (username == null || username.trim().equals(""))
	      {
	         addFieldError("username","User name is required");
	      }
	      if (password == null || password.trim().equals(""))
	      {
	         addFieldError("password","Password is required");
	      }
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public ArrayList getAl() {
		return al;
	}

	public void setAl(ArrayList al) {
		this.al = al;
	}
	

	public SessionMap<String, String> getSessionmap() {
		return sessionmap;
	}

	public void setSessionmap(SessionMap<String, String> sessionmap) {
		this.sessionmap = sessionmap;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}


	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}


	public ArrayList getAl1() {
		return al1;
	}

	public void setAl1(ArrayList al1) {
		this.al1 = al1;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) 
	{
		// TODO Auto-generated method stub
		req = arg0;
		
	}

	public LinkedList getMessage_send_list() {
		return message_send_list;
	}

	public void setMessage_send_list(LinkedList message_send_list) {
		this.message_send_list = message_send_list;
	}

	public String getOutputtext1() {
		return outputtext1;
	}

	public void setOutputtext1(String outputtext1) {
		this.outputtext1 = outputtext1;
	}

	public String getOutputtext2() {
		return outputtext2;
	}

	public void setOutputtext2(String outputtext2) {
		this.outputtext2 = outputtext2;
	}

	public String getOutputtext3() {
		return outputtext3;
	}

	public void setOutputtext3(String outputtext3) {
		this.outputtext3 = outputtext3;
	}

	public String getOutputtext4() {
		return outputtext4;
	}

	public void setOutputtext4(String outputtext4) {
		this.outputtext4 = outputtext4;
	}

	public String getOutputtext5() {
		return outputtext5;
	}

	public void setOutputtext5(String outputtext5) {
		this.outputtext5 = outputtext5;
	}
	
}
