package login;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		RequestDispatcher view;
		//PrintWriter pw=response.getWriter();
		HttpSession session = null;
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		if(password.equals(new db.manager.DBManager().getPasswordByUsername(uname))){
			//pw.println("Username = "+uname+" and password= "+password);
			view = request.getRequestDispatcher("welcome.jsp");
			session = request.getSession();
			session.setAttribute("userId", uname);
		}
		else{
			//pw.println("not the valid user");
			view = request.getRequestDispatcher("index.jsp");
			session = request.getSession(false);
			if(session!=null){
				session.invalidate();
			}
		}
		view.forward(request, response);
		
	}

}
