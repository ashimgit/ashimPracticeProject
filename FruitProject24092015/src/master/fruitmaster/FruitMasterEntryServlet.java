package master.fruitmaster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.manager.DBManager;

/**
 * Servlet implementation class FruitMasterEntryServlet
 */
// @WebServlet("/FruitMasterEntryServlet")
public class FruitMasterEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FruitMasterEntryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		RequestDispatcher rd = null;
		String msg = "";

		String catId = request.getParameter("catId");
		System.out.println(catId);
		// pw.println(catId);

		String mainCat = request.getParameter("mainCat");
		String mainCatDesc = request.getParameter("mainCatDesc");
		String fName = request.getParameter("fName");
		String fDesc = request.getParameter("fDesc");
		String unit = request.getParameter("unit");

		System.out.println(mainCat + " " + mainCatDesc + "  " + fName + " "
				+ fDesc + " " + unit);

		FruitMaster fruit = new FruitMaster();
		fruit.setFruitName(fName);
		fruit.setFruitDesc(fDesc);
		fruit.setFruitUnit(unit);
		fruit.setMainCatName(mainCat);
		fruit.setMainCatDesc(mainCatDesc);

		String insertType = "new";

		if (catId != null) {
			fruit.setMainCatId(Integer.parseInt(catId));
			insertType = "old";
		}

		String fruitCode = new DBManager().insertFruitMaster(fruit, insertType);
		System.out.println("fruitCode:::" + fruitCode);

		if (fruitCode.length() > 0) {

			msg = "Insertion Successful<br> Fruit Name :"+fName+ " ["+fruitCode+" ]";
			request.setAttribute("msg", msg);
			rd = request.getRequestDispatcher("fruit_master.jsp");
		} else {
			msg = "Insertion Failed";
			request.setAttribute("msg", msg);
			rd = request.getRequestDispatcher("fruit_master.jsp");

		}
		rd.forward(request, response);
	}
	

}
