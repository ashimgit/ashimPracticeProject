<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="home.jsp" %>
<%@page import="java.util.List"%>
<%@page import="customer.Customer"%>
<%@page import="db.manager.DBManager"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Transfer</title>
<style type="text/css">
.submit {width: 80px; height: 25px;}
fieldset {Width: 900px;	display: block;	margin-left: 2px; margin-right: 2px; padding-top: 0.35em; padding-bottom: 0.625em; padding-left: 0.75em; padding-right: 0.75em;	border: 2px groove(internal value); border-width: 2px;}
#f_details {border-collapse: collapse;}
#f_details td, #f_details th {font-size: 1em; border: 1px solid black;}
#f_details td {text-align: center;}
</style>
<script src="js/jquery-latest.js"></script>
<script src="js/custom/stockTransfer.js"></script>
<%
	List<String[]> catagoryList = new DBManager().getAllFruitCatagory();
	List<Customer> goDownList = new DBManager().getAllGoDown();
%>
</head>
<body>
<div>
<fieldset>
<legend style="color: blue; font-size: 20px; font-weight: bold;">Go-Down Information</legend>
<table>
<tr>
<td>From Go-down</td>
<td>
	<select name="fromGodown" id="fromGodown" >
		<option value="">Select Go-down From</option>
		<option value="onShop">On Shop Stock</option>
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
<td>To Go-down</td>
<td>
	<select name="toGodown" id="toGodown">
		<option value="">Select Go-down From</option>
		<option value="onShop">On Shop Stock</option>
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
<td></td>
<td><input type="button" name="makeTransfer" id="makeTransfer" value="Transfer" class="submit"/></td>
<td><input type="button" name="clearButton" id="clearButton" value="Clear" class="submit"/></td>
</tr>
</table>
</fieldset>
<fieldset>
<legend style="color: blue; font-size: 20px; font-weight: bold;">Fruit Information</legend>
<table>
<tr>
<td>Fruit Category</td>
<td>
	<select name="fruitCategory" id="fruitCategory" onblur="f_f_cat()" onchange="f_f_cat()">
		<option value="">Select Fruit Category</option>
		<%
			for (int i = 0; i < catagoryList.size(); i++) {
				String[] catagory = (String[]) catagoryList.get(i);
		%>
		<option value="<%=catagory[0]%>" ><%=catagory[1]%></option>
		<%
		}
		%>
	</select>
</td>
<td>Fruit Name</td>
<td>
	<select name="fruitId" id="fruitId" onchange="f_f_unit_rate()" onblur="f_f_unit_rate()">
		<option value="" >Select Fruit</option>

	</select>
</td>
<td>Current Stock</td>
<td><input type="text" name="currentStock" id="currentStock" readonly />
	<input type="text" name="fruitUnit" id="fruitUnit" readonly />
</td>
</tr>
<tr>
<td>Fruit Rate</td>
<td><input type="number" name="fruitRate" id="fruitRate" readonly /></td>
<td>Sale Quantity</td>
<td><input type="number" name="fruitQuantity"	id="fruitQuantity" value="0.00" onkeyup="setItemTotal()" onblur="setItemTotal()" /></td>
<td>Item Total</td>
<td><input type="number" name="fruitItemTotal" value="0.00" id="fruitItemTotal" />
<input type="button" value="Add Item" onclick="addFruitItem();" class="submit"/></td>
</tr>
</table>
</fieldset>
<span style="width: 100%; height: 5px; display: block;"></span>
<table id="f_details">
<tr>
<th width="152px">Fruit Name</th>
<th width="152px">Fruit Unit</th>
<th width="152px">Fruit Rate</th>
<th width="155px">Fruit Quantity</th>
<th width="155px">Fruit Item Total</th>
<th width="152px">Action</th>
</tr>	
<tbody id="saleItemList" >
</tbody>
</table>
</div>	
</body>
</html>