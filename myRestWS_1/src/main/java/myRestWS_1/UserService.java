package myRestWS_1;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/UserService")

public class UserService {
	UserDao userDao = new UserDao();

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}

	// *********************************
	@GET
	@Path("/getUrl1")
	public String func_getUrl1() {
		return "Hi from getUrl1";
	}

	// ********************************* @PathParam
	@GET
	@Path("/getUrl2/{yourName}")
	public String func_getUrl2(@PathParam("yourName") String yourName) {
		return "Hi from getUrl2 = " + yourName;
	}

	// ********************************* @PathParam
	@GET
	@Path("/getUrl3/{yourName}")
	public Response func_getUrl3(@PathParam("yourName") String yourName) {
		return Response.ok("Response Object - " + yourName).build();
	}

	// ********************************* @MatrixParam :
	// http://localhost:12345/myRestWS_1/rest/UserService/getUrl4;yourName=Ashim;yourAge=29/
	@GET
	@Path("/getUrl4")
	public Response func_getUrl4(@MatrixParam("yourName") String yourName, @MatrixParam("yourAge") Integer yourAge) {
		return Response.ok("Response Object - " + yourName + " , Your Age = " + yourAge).build();
	}

	// ********************************* @QueryParam :
	// http://localhost:12345/myRestWS_1/rest/UserService/getUrl5?yourName=Ashim&yourAge=29
	@GET
	@Path("/getUrl5")
	public Response func_getUrl5(@QueryParam("yourName") String yourName, @QueryParam("yourAge") String yourAge) {
		return Response.ok("Response Object - " + yourName + " , Your Age = " + yourAge).build();
	}

	// ********************************* @MatrixParam :
	// http://localhost:12345/myRestWS_1/rest/UserService/getUrl4;yourName=Ashim;yourAge=29/
	@GET
	@Path("/getUrl4_1")
	public Response func_getUrl4_1(@MatrixParam("yourName") List<String> yourName) {
		return Response.ok("Response Object - " + yourName ).build();
	}

}