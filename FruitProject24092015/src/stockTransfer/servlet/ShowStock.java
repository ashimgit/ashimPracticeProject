package stockTransfer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.manager.DBManager;
import flexjson.JSONSerializer;
import stockTransfer.pojo.Stock;

/**
 * Servlet implementation class ShowStock
 */
@WebServlet("/ShowStock")
public class ShowStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStock() {
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
		response.setContentType("application/json"); 
		String godownId = request.getParameter("godownId");
		
		 List<Stock> stockList = new DBManager().getCurrentStock(godownId);
		 
		 String stockDetailsJsonStr = new JSONSerializer().exclude("*.class").serialize(stockList);
		 System.out.println("stockDetailsJsonStr::" + stockDetailsJsonStr);
			response.getWriter().write(stockDetailsJsonStr);
	}

}
