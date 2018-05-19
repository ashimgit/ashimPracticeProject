<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="customer.Customer"%>
<%@page import="db.manager.DBManager"%>
<!DOCTYPE html>
<%@ include file="home.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Transfer</title>
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
.input {width: 60px;}
</style>
<script src="js/jquery-latest.js"></script>
<script src="js/custom/stockTransfer.js"></script>
<%
	List<String[]> catagoryList = new DBManager().getAllFruitCatagory();
	List<Customer> goDownList = new DBManager().getAllGoDown();
%>
</head>
<body>
<div id="pheader">
Transfer Stock
</div>
<div>
<fieldset>
<legend style="color: blue; font-size: 20px; font-weight: bold;">Go-down Information</legend>
<table>
<tr>
<td>From Go-down</td>
<td><select name="fromGodown" id="fromGodown" >
<option value="">Select Go-down From</option>
<option value="OnShop">On Shop Stock</option>
<%
						for (int i = 0; i < goDownList.size(); i++) {
							Customer goDown = (Customer) goDownList.get(i);
					%>
					<option value="<%=goDown.getCustomerCode()%>" ><%=goDown.getCustomerName()%></option>
					<%
						}
					%>
</select></td>
<td>To Go-down</td>
<td><select name="toGodown" id="toGodown" >
<option value="">Select Go-down From</option>
<option value="OnShop">On Shop Stock</option>
<%
						for (int i = 0; i < goDownList.size(); i++) {
							Customer goDown = (Customer) goDownList.get(i);
					%>
					<option value="<%=goDown.getCustomerCode()%>" ><%=goDown.getCustomerName()%></option>
					<%
						}
					%>
</select></td>
<td><input type="button" name="makeTransfer" id="makeTransfer" value="Transfer" />
<input type="button" name="clearButton" id="clearButton" value="Clear" />
</td>
</tr>
</table>
</fieldset>
<fieldset>
<legend style="color: blue; font-size: 20px; font-weight: bold;">Fruit Information</legend>
	<table id="design">
			<tr>
				<td>Fruit Category</td>
				<td><select name="fruitCategory" id="fruitCategory" onblur="f_f_cat()" onchange="f_f_cat()">
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
				<td><select name="fruitId" id="fruitId" onchange="f_f_unit_rate()" onblur="f_f_unit_rate()">
						<option value="" >Select Fruit Name</option>

				</select></td>
				<td>Current Stock</td>
				<td><input type="text" name="currentStock" id="currentStock" class="input" readonly />
					<input type="text" name="fruitUnit" id="fruitUnit" class="input" readonly />
				</td>
			</tr>
			<tr>
				<td>Fruit Rate</td>
				<td><select name ="fruitRate" id="fruitRate" onchange="showStock();">
					<option value="">Select One Rate</option>
				</select></td>
				<td>Sale Quantity</td>
				<td><input type="number" name="fruitQuantity"
					id="fruitQuantity" value="0.00" class="input" onkeyup="setItemTotal()" onblur="setItemTotal()" /></td>
				<td>Item Total</td>
				<td><input type="number" name="fruitItemTotal" value="0.00"
					id="fruitItemTotal" /></td>
				<td>
				<input type="button" value="Add Item" onclick="addFruitItem();" />
				<input type="button" name="clearButton" id="clearButton" value="Clear" onclick="clearSaleFruitDetails()" />
				</td>
			</tr>
			</table>
			</fieldset>
			<div style="margin-left: 2px;">
			<table id="f_details">
			<tr>
				<th width="118">Fruit Name</th>
				<th width="120">Fruit Unit</th>
				<th width="120">Fruit Rate</th>
				<th width="120">Fruit Quantity</th>
				<th width="120">Fruit Item Total</th>
				<th width="120">Action</th>
			</tr>
		<tbody id="saleItemList">

		</tbody>
	</table>
	</div>
</div>
<div style="width: 100%; height: 50px; display: block;" >
</div>	
</body>
</html>