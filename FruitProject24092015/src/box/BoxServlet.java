package box;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.manager.DBManager;
import flexjson.JSONSerializer;

/**
 * Servlet implementation class BoxServlet
 */
@WebServlet("/BoxServlet")
public class BoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		String reqType = request.getParameter("reqType");
		
		if(reqType.equalsIgnoreCase("GetBox")){
			
			String customerId = request.getParameter("customerId");
			int noOfBox = new DBManager().getNoOfBoxByCustomerId(customerId);
			String boxJsonStr = new JSONSerializer().exclude("*.class").serialize(String.valueOf(noOfBox));
			response.getWriter().write(boxJsonStr);
		}
		if(reqType.equalsIgnoreCase("saveBox")){
			String customerId = request.getParameter("cname");
			String operation = request.getParameter("operation");
			String noOfBox = request.getParameter("box");
			
			boolean flag = new DBManager().saveBoxByCustomer(noOfBox, customerId, operation);
			String msg = "";
			if(flag){
				msg ="Sucessfully Saved.";
			}else{
				msg ="Failed.";
			}
			
			request.setAttribute("msg", msg);
		    RequestDispatcher view = request.getRequestDispatcher("box.jsp");
		    view.forward(request, response);
		}
		
	}
}
