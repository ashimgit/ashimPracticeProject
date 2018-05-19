package customer.account;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.manager.DBManager;
import flexjson.JSONSerializer;

/**
 * Servlet implementation class CustomerAccount
 */
@WebServlet("/CustomerAccount")
public class CustomerAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		
		String reqType = request.getParameter("reqType");
		
		if(reqType.equalsIgnoreCase("GetCustomerAccount")){
			
			String customerId = request.getParameter("customerId");
			
			String toDate = request.getParameter("toDate");
			
			System.out.println("toDate::"+toDate);
			
			String fromDate = request.getParameter("fromDate");
			
			List<CAccount> accountDetails = new DBManager().getCustomerAccountDetailsByDate(customerId, toDate, fromDate);
			CAccount acc = new DBManager().getPreviousAccountDue(customerId);
			accountDetails.add(acc);
			
			String accountDetailsJsonStr = new JSONSerializer().exclude("*.class").serialize(accountDetails);
			
			response.getWriter().write(accountDetailsJsonStr);
		}
		else if(reqType.equalsIgnoreCase("SaveCustomerAccount")){
			

			String customerId = request.getParameter("customerId");
			
			String toDate = request.getParameter("toDate");
			
			System.out.println("save - toDate::"+toDate);
			
			String fromDate = request.getParameter("fromDate");
			
			Double paidAmt =Double.parseDouble(request.getParameter("paidAmt"));
			
			boolean flag = new DBManager().saveCustomerAccountDetails(customerId, fromDate, toDate, paidAmt);
			System.out.println("flag::"+flag);
			
			String accountDetailsJsonStr = new JSONSerializer().exclude("*.class").serialize(new String ("Success."));
			
			response.getWriter().write(accountDetailsJsonStr);
		}
		else if(reqType.equalsIgnoreCase("GetAllCustomerAccountDetails")){
			
			String customerId = request.getParameter("customerId");
			
			String toDate = request.getParameter("toDate");
			
			System.out.println("toDate::"+toDate);
			
			String fromDate = request.getParameter("fromDate");
			
			List<CAccount> accountDetails = new DBManager().getCustomerAllAccountDetailsByDate(customerId, toDate, fromDate);
			accountDetails = new DBManager().getCustomerAllAccountPaymentDetailsByDate(accountDetails,customerId, toDate, fromDate);
			CAccount acc = new DBManager().getPreviousAccountDue(customerId);
			accountDetails.add(acc);
			
			String accountDetailsJsonStr = new JSONSerializer().exclude("*.class").serialize(accountDetails);
			
			response.getWriter().write(accountDetailsJsonStr);
		}
	}

}
