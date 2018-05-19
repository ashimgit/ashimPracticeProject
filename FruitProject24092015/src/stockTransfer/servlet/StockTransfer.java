package stockTransfer.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sale.pojo.SaleItemDetail;
import db.manager.DBManager;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * Servlet implementation class StockTransfer
 */
@WebServlet("/StockTransfer")
public class StockTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StockTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String reqType = request.getParameter("reqType");
		System.out.println("reqType:::" + reqType);
		if (reqType.equalsIgnoreCase("GetFruit")) {
			String fruitId = request.getParameter("fruitId");
			String fromGodown = request.getParameter("fromGodown");
			System.out.println("fruitId::" + fruitId);
			System.out.println("fromGodown::" + fromGodown);
			List<SaleItemDetail> fruitList = new DBManager().getFruitDetailsByFruitIdAndGodown(fruitId, fromGodown);
			String fruitDetailsJsonStr = new JSONSerializer()
					.exclude("*.class").serialize(fruitList);
			System.out.println("fruitDetailsJsonStr::" + fruitDetailsJsonStr);
			response.getWriter().write(fruitDetailsJsonStr);
			
		}else if(reqType.equalsIgnoreCase("saveStockTransfer")){
			String fruitListJsonStr = request.getParameter("itemsJsonStr");
			String fromGodown = request.getParameter("fromGodown");
			String toGodown = request.getParameter("toGodown");
			System.out.println("fruitListJsonStr:::"+fruitListJsonStr);
			List<SaleItemDetail> itemList = new JSONDeserializer<List<SaleItemDetail>>().use("values",  SaleItemDetail.class).deserialize(fruitListJsonStr);
			boolean status = new DBManager().updateStocktransfer(itemList, fromGodown, toGodown);
			System.out.println("status::"+status);
			if(status){
			String transferDetailsJsonStr = new JSONSerializer().exclude("*.class").serialize(new String("Successfully Transfer."));
			System.out.println("fruitDetailsJsonStr::" + transferDetailsJsonStr);
			response.getWriter().write(transferDetailsJsonStr);
			}else{
				String transferDetailsJsonStr = new JSONSerializer().exclude("*.class").serialize(new String("Transfer Failed."));
				System.out.println("fruitDetailsJsonStr::" + transferDetailsJsonStr);
				response.getWriter().write(transferDetailsJsonStr);
			}
			
		}else {
			System.out.print("Out of Scope"); 
		}
	}

}
