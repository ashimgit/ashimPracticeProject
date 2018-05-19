package login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport implements ServletRequestAware
{
	
	private TestBean obj;
	HttpServletRequest req;
	
	
	public String India() throws Exception 
	{
		System.out.println("in india :: ");
		ActionContext.getContext().getSession().put("a", "A");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession ses=request.getSession();
		
		String a=(String)ActionContext.getContext().getSession().get("a");
		System.out.println("a :: "+a);
		return "success";
	}
	
	public String Pakistan() throws Exception 
	{
		System.out.println("in pak :: ");
		
		return "success";
	}
	
	public String Usa() throws Exception 
	{
		System.out.println("in usa :: ");
		
		return "success";
	}
	


	public TestBean getObj() {
		return obj;
	}


	public void setObj(TestBean obj) {
		this.obj = obj;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
req=arg0;	
	}
	
	
}
