package sale.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.Customer;
import db.manager.DBManager;
import sale.pojo.Sale;

/**
 * Servlet implementation class BillPrint
 */
@WebServlet("/BillPrint")
public class BillPrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillPrint() {
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
		
		String saleId = request.getParameter("saleId");
		Sale sale = new DBManager().getSaleDetailsBySaleId(saleId);
		Customer customer = new DBManager().getCustomerDetailsByCustomerId(sale.getCustomerNo());
		sale.setCustomerpaidAmount(new DBManager().getCustomerPaidAmountBySale(saleId));
		request.setAttribute("customerDetail", customer);
		request.setAttribute("SaleDetails", sale);
		RequestDispatcher view = request.getRequestDispatcher("bill.jsp");
		view.forward(request, response);
		
	}

}
