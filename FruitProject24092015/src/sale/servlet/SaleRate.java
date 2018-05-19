package sale.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.manager.DBManager;
import flexjson.JSONSerializer;

/**
 * Servlet implementation class SaleRate
 */
@WebServlet("/SaleRate")
public class SaleRate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleRate() {
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
		String reqType = request.getParameter("reqType");
		System.out.println("reqType:::"+reqType);
		if(reqType.equalsIgnoreCase("GetFruit")){
			String catagoryId = request.getParameter("catagoryId");
			System.out.println("catagoryId::"+catagoryId);
			List<Map<String,String>> fruitDetails = new DBManager().getAllFruitNameAndRateByCatagory(catagoryId);
			String fruitDetailsJsonStr = new JSONSerializer().exclude("*.class").serialize(fruitDetails);
			System.out.println("fruitDetailsJsonStr::"+fruitDetailsJsonStr);
			response.getWriter().write(fruitDetailsJsonStr);
		}
		else if(reqType.equalsIgnoreCase("saveFruitRate")){
			String fruitId = request.getParameter("fruitId");
			Double fruitRate = Double.parseDouble(request.getParameter("fruitRate"));
			System.out.println("fruitId::"+fruitId+" :::::fruitRate::"+fruitRate);
			boolean flag = new DBManager().setFruitRateByFruitId(fruitId, fruitRate);
			System.out.println("flag::"+flag);
			if(flag){
				response.getWriter().write("Success.");
			}
			else{
				response.getWriter().write("Failed.");
			}
		}
		else{
			System.out.println("Under Construction");
			
		}
	}

}
