<%@page import="db.manager.DBManager"%>
<%@page import="java.util.List"%>
<%@page import="customer.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<%@ include file="home.jsp" %>
<head>

<%
	List<Customer> customerList = new DBManager().getAllCustomer();
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="js/jquery-latest.js"></script>
<script src="js/custom/customerAccount.js"></script>
<title>Transaction Details</title>
<style type="text/css">
#pheader {	Width: 725px; height: 40px; display: block; background-color: #008B8B; color: #FFF; 
			font-size: 25px; font-weight: bold; line-height: 40px; margin-left: 2px;			
}
fieldset {	Width: 700px;	display: block;	margin-left: 2px; margin-right: 2px; padding-top: 0.35em;
			padding-bottom: 0.625em; padding-left: 0.75em; padding-right: 0.75em;	
			border: 2px groove(internal value); border-width: 2px;
}
#f_details {border-collapse: collapse;}
#f_details td, #f_details th {font-size: 1em; border: 1px solid black;}
#f_details td {text-align: center;}
.selectbox {width: 150px;}
</style>
</head>
<body>
<div id="pheader">
Customer Transaction Details
</div>
<div>
<fieldset>
<legend style="color: blue; font-size: 20px; font-weight: bold;">Customer Information</legend>
<table>
<tr>
<td>Customer Id</td>
<td><select name="customerId" id="customerId" class="selectbox">
<option value="">Select Customer Id</option>
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
<td>From Date</td>
<td><input type="date" name="fromDate" id="fromDate" /></td>
<td>To Date</td>
<td><input type="date" name="toDate" id="toDate"  /></td>
<td><input type="button" name="search" value="Search" onclick="getCustomerAllAccountDetails()"/></td>
</tr>
</table>
</fieldset>
<div style="margin-left: 2px;">
<table id="f_details">
<tr>
<th width="68px">SL No.</th>
<th width="150px">Reference Id</th>
<th width="150px">Reference Date</th>
<th width="100px">Bill Amount</th>
<th width="150px">Bill Amount Paid</th>
<th width="100px">Remarks</th>
</tr>
<tbody id="customerAllAccountDetails">
</tbody>
</table>
</div>
</div>
<div style="width: 100%; height: 50px; display: block;" >
</div>
</body>
</html>