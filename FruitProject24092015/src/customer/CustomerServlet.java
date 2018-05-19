package customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.manager.DBManager;

/**
 * 
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
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
		
		RequestDispatcher rd=null;
		String msg = "";
		
		String sType=request.getParameter("s_type");
		System.out.println(sType);
		String customerName = request.getParameter("customerName");
		String customerAddress1 = request.getParameter("customerAddress1");
		String customerAddress2 = request.getParameter("customerAddress2");
		String customerPhone1 = request.getParameter("customerPhone1");
		String customerPhone2 = request.getParameter("customerPhone2");
		
		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setCustomerAddress1(customerAddress1);
		customer.setCustomerAddress2(customerAddress2);
		customer.setCustomerphoneNo1(customerPhone1);
		customer.setCustomerphoneNo2(customerPhone2);
		
		String flag = new DBManager().setCustomerDetails(customer,sType);
		if(flag.length()>0){	//flag contains customer code
			//msg
			//response.getWriter().println("Inserted Successfully");
			System.out.println("Inserted....");
			
			//response.sendRedirect("addCustomer.jsp");
			
			msg="Inserted Successfully. Please Note Down the <br>Name : "+customerName+"[ "+flag+" ]";
			request.setAttribute("msg", msg);
			rd=request.getRequestDispatcher("addCustomer.jsp");
		}
		else{
			//msg
			System.out.println("Failed.");
			//response.sendRedirect("addCustomer.jsp?flag="+"Insertion Failed");
			
			msg="Insertion Failed";
			request.setAttribute("msg", msg);
			rd=request.getRequestDispatcher("addCustomer.jsp");
		}
		rd.forward(request, response);
		
		
	}

}
