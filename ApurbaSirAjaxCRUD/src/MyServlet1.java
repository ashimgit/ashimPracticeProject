
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import emp.Employee;

/**
 * Servlet implementation class MyServlet1
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		System.out.println("Hi, this is from ajax");

		String token = request.getParameter("token");
		if (token.equals("GET")) {//if the button is from GET/FETCH
			
			
			response.setContentType("application/json");

			/**/
			List<Employee> employees = getEmployee();

			Gson gson = new Gson();
			String jsonString = gson.toJson(employees);
			response.setCharacterEncoding("UTF-8");
			System.out.println("json: " + jsonString);
			response.getWriter().write(jsonString);
			/**/
			/*
			 * Map<String, String> lift = new LinkedHashMap<String, String>();
			 * 
			 * lift.put("t1", "subho"); lift.put("t2", "ashim"); lift.put("t3",
			 * "sudeep");
			 * 
			 * String json = null; json = new Gson().toJson(lift);
			 * 
			 * response.setContentType("application/json");
			 * response.setCharacterEncoding("UTF-8"); System.out.println(
			 * "lift :: " + lift); response.getWriter().write(json);
			 */
		}//end if
		else if(token.equals("INSERT")){
			//code to insert into database
			String txtItem = request.getParameter("textItem");
			String radioItem = request.getParameter("radioItem");
			System.out.println(txtItem + " *** " + radioItem);

			try{
				//Connection con=DriverManager.getConnection(url);
				
			}catch(Exception e){}
		}
	}

	List<Employee> getEmployee() {
		Employee e1 = new Employee();
		e1.setEmpid("e1");
		e1.setSex("male");

		Employee e2 = new Employee();
		e2.setEmpid("e2");
		e2.setSex("female");
		Employee e3 = new Employee();
		e3.setEmpid("e3");
		e3.setSex("other");

		List<Employee> l1 = new ArrayList<Employee>();
		l1.add(e1);
		l1.add(e2);

		return l1;

	}

}
