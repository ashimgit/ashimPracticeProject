<%@page import="db.manager.DBManager"%>
<%@page import="customer.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Box - Send/Receive</title>
<style type="text/css">
* {margin: 0px; padding: 0px;}
body {}			
#pheader {	Width: 394px; height: 40px; display: block; background-color: #008B8B; color: #FFF; 
			font-size: 25px; font-weight: bold; line-height: 40px; margin-left: 2px;			
}
#form_container {Width: 500px;}			
#heading {width: 100%; height: 40px; background-color: #A4A4A4;}
fieldset {Width: 370px;	display: block;	margin-left: 2px; margin-right: 2px; padding-top: 0.35em; padding-bottom: 0.625em; padding-left: 0.75em; padding-right: 0.75em;	border: 2px groove(internal value); border-width: 2px;}
.iselect {width: 173px;}
</style>

<script src="js/jquery-latest.js"></script>
<script src="js/custom/box.js"></script>

<%
	List<String[]> catagoryList = new DBManager().getAllFruitCatagory();
	List<Customer> customerList = new DBManager().getAllCustomer();
	List<Customer> goDownList = new DBManager().getAllGoDown();
%>
</head>
<body>
<div id="form_container">
	<div id="pheader">
		Box - Send/Receive
	</div>
	<div id="form_doc">
	<fieldset>
	<legend style="color: blue; font-size: 20px; font-weight: bold;">Information</legend>
	<form action="BoxServlet?reqType=saveBox" method="post">
		<table>
			<tr>
				<td>Customer Name :</td>
				<td>
				<select id="cname" name="cname" class="iselect" required>
					<option value="">Select Customer</option>
					<%
						for (int i = 0; i < customerList.size(); i++) {
							Customer customer = (Customer) customerList.get(i);
					%>
					<option value="<%=customer.getCustomerCode()%>" ><%=customer.getCustomerName()+"-["+customer.getCustomerCode()+"]-Ph:"+customer.getCustomerphoneNo1()%></option>
					<%
						}
					%>
				</select>
				</td>
			</tr>
			<tr>
				<td>Present Status :</td>
				<td><input type="text" id="status" name="status"></td>
			</tr>
			<tr>
				<td>Send/Receive :</td>
				<td>
				<select id="operation" name="operation" class="iselect" required>
					<option value="">Select Operation</option>
					<option value="Send">Send</option>
					<option value="Receive">Receive</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>No. of Boxes :</td>
				<td><input type="number" min="1" id="box" name="box" required></td>
			</tr>
			<tr>
				<td>
				<td>
					<input type="submit" value="Submit">
					<input type="reset" value="Reset">
				</td>
			</tr>
		</table>
		<%
			String msg = (String) request.getAttribute("msg");
			if(msg !=null){
		%>
		<%=msg %>
		<%		
			}
		%>
	</form> 
    </fieldset>   
	</div>
</div>	
</body>
</html>