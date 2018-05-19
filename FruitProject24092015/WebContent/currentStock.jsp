<%@page import="db.manager.DBManager"%>
<%@page import="customer.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="home.jsp" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	//List<String[]> catagoryList = new DBManager().getAllFruitCatagory();
	List<Customer> goDownList = new DBManager().getAllGoDown();
%>
<title>Show Stock</title>
<script src="js/jquery-latest.js"></script>
<script src="js/custom/stock.js"></script>
<style type="text/css">
#pheader {	Width: 675px; height: 40px; display: block; background-color: #008B8B; color: #FFF; 
			font-size: 25px; font-weight: bold; line-height: 40px; margin-left: 2px;			
}
fieldset {	Width: 650px;	display: block;	margin-left: 2px; margin-right: 2px; padding-top: 0.35em;
			padding-bottom: 0.625em; padding-left: 0.75em; padding-right: 0.75em;	
			border: 2px groove(internal value); border-width: 2px;
}
#f_details {border-collapse: collapse;}
#f_details td, #f_details th {font-size: 1em; border: 1px solid black;}
#f_details td {text-align: center;}
</style>
</head>
<body>
<div id="pheader">
Current Stock
</div>
<div>
<fieldset>
<legend style="color: blue; font-size: 20px; font-weight: bold;">Select Go-down</legend>
<table>
<tr>
<td>Select Go-Down</td>
<td><select name="godownId" id="godownId">
<option value="">Select Go - Down</option>
<option value="OnShop">On Shop Stock</option>
<%
						for (int i = 0; i < goDownList.size(); i++) {
							Customer goDown = (Customer) goDownList.get(i);
					%>
					<option value="<%=goDown.getCustomerCode()%>" ><%=goDown.getCustomerName()%></option>
					<%
						}
					%>
</select>
</td>
<td><input type="button" name="showStock" value="Show Stock" onclick="showStockDetails()" /></td>
</tr>
</table>
</fieldset>
<div style="margin-left: 2px;">
<table id="f_details">
<tr>
<th width="60px">Sl. No</th>
<th width="127px">Fruit Name</th>
<th width="120px">Quantity</th>
<th width="120px">Unit</th>
<th width="120px">Rate</th>
<th width="120px">Tag No</th>
</tr>
<tbody id="showStockDetails">

</tbody>
</table>
</div>
</div>
<div style="width: 100%; height: 50px; display: block;" >
</div>
</body>
</html>