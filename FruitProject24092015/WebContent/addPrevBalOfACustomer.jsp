<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="home.jsp" %>
<%@page import="java.util.List"%>
<%@page import="customer.Customer"%>

<%@page import="db.manager.DBManager"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sale - Bill</title>
<style type="text/css">
#pheader {	Width: 506px; height: 40px; display: block; background-color: #008B8B; color: #FFF; 
			font-size: 25px; font-weight: bold; line-height: 40px; margin-left: 2px;			
}
.function {width: 80px; height: 25px; align: center;}
#f_details {border-collapse: collapse;}
#f_details td, #f_details th {font-size: 1em; border: 1px solid black;}
#f_details td {width: 250px; height: 30px;}
</style>
</head>
<body>
<div>
<div id="pheader">
Old Customer Balance		
</div>
<span style="height: 10px; display: block;" ></span>
<div style="margin-left: 2px;" >
<%
//////////////////////////////////
List<Customer> customerList = new DBManager().getAllCustomer();
/////////////////////////////////
%>

<form action="OldCustomerBal" method="post">
	<table id="f_details">
		<thead>
			<tr align="center">
				<td colspan="2">
					<h2>Adding Old Customer Balance</h2>
				</td>				
			</tr>
		</thead>
		<tr>
			<td>Customer Name</td>
			<td><select name="customerName" id="customerName" class="selectbox" required>
					<option value="">Select Customer</option>
					<%
						for (int i = 0; i < customerList.size(); i++) {
							Customer customer = (Customer) customerList.get(i);
					%>
					<option value="<%=customer.getCustomerCode()%>" ><%=customer.getCustomerName()+"-["+customer.getCustomerCode()+"]-Ph:"+customer.getCustomerphoneNo1()%></option>
					<%
						}
					%>
			</select></td>
		</tr>
		<tr>
			<td>Enter Previous Balance</td><td><input type="text" name="txt_preBal" required></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Insert Details" class="function">&nbsp;
			<input type="reset" value="Cancel" class="function"></td>
		</tr>
		
	</table>
	</form>
</div>
</div>	
</body>
</html>