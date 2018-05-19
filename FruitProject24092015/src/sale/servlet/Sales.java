package sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

import puchase.pojo.Purchase;
import sale.pojo.Sale;
import sale.pojo.SaleItemDetail;
import db.manager.DBManager;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * Servlet implementation class Sales
 */
@WebServlet("/Sales")
public class Sales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sales() {
        super();
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
		System.out.println("reqType:::"+reqType);
		if(reqType.equalsIgnoreCase("getFruit")){
			String fruitId = request.getParameter("fruitId");
			System.out.println("fruitId::"+fruitId);
			List<SaleItemDetail> fruitDetails = new DBManager().getFruitDetails(fruitId);
			String fruitDetailsJsonStr = new JSONSerializer().exclude("*.class").serialize(fruitDetails);
			System.out.println("fruitDetailsJsonStr::"+fruitDetailsJsonStr);
			response.getWriter().write(fruitDetailsJsonStr);
		}else
		
		if(reqType.equalsIgnoreCase("saveSales")){
			String saleJsonStr = request.getParameter("saleJsonStr");
			System.out.println("saleJsonStr::"+saleJsonStr);
			Sale sale = new JSONDeserializer<Sale>().deserialize(saleJsonStr, Sale.class);
			
			String itemsJsonStr = request.getParameter("itemsJsonStr");
			System.out.println("itemsJsonStr::"+itemsJsonStr);
			List<SaleItemDetail> saleItemList = new JSONDeserializer<List<SaleItemDetail>>().use("values",  SaleItemDetail.class).deserialize(itemsJsonStr);
			System.out.println("saleItemList  size::"+saleItemList.size());
			sale.setSaleIteamList(saleItemList);
			String saleId = new DBManager().insertSale(sale);
			System.out.println("saleId::"+saleId);
			String saleIdJsonStr = new JSONSerializer().exclude("*.class").serialize(new String(saleId));
			System.out.println("saleIdJsonStr"+saleIdJsonStr);
		    response.getWriter().write(saleIdJsonStr);
		    
		    
		  
		}
		
	}

}
