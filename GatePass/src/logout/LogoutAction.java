package logout;

import java.util.*;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;

public class LogoutAction extends ActionSupport
 {

 public String execute() throws Exception 
 {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession ses=request.getSession();
		ses.invalidate();
		//sessionmap.invalidate();
		return "success";
 }

 }

