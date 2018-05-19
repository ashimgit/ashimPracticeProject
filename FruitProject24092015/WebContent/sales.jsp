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
<title>Sales - Billing</title>
<style type="text/css">
#pheader {	Width: 99.8%; height: 40px; display: block; background-color: #008B8B; color: #FFF; 
			font-size: 25px; font-weight: bold; line-height: 40px; margin-left: 2px;			
}
fieldset {	Width:100% display: block; margin-left: 2px; margin-right: 2px; padding-top: 0.35em;
			padding-bottom: 0.625em; padding-left: 0.75em; padding-right: 0.75em;	
			border: 2px groove(internal value); border-width: 2px;
}
#left{width: 48.5%; display: inline-block;}
#right{width: 51%; display: inline-block; float: right;}

#f_details {border-collapse: collapse;}
#f_details td {font-size: 1em; border: 1px solid black; text-align: center;}
#f_details th {font-size: 1em; border: 1px solid #A7C942; background-color: #A7C942; color: #ffffff;}
.selectbox {width: 150px;}
</style>
<script src="js/jquery-latest.js"></script>
<script src="js/custom/sales.js"></script>
<%
	List<String[]> catagoryList = new DBManager().getAllFruitCatagory();
	List<Customer> customerList = new DBManager().getAllCustomer();
	List<Customer> goDownList = new DBManager().getAllGoDown();
%>
</head>
</head>
<body>
<div id="container">
<div id="left">
<div id="pheader">
Sales
</div>
<span style="height: 10px; display: block;"></span>
	<div>
	<fieldset>
	<legend style="color: blue; font-size: 20px; font-weight: bold;">Sales Information</legend>
	<table>
		<tr>
			<td>Sale Date</td>
			<td><input type="date" name="saleDate" id="saleDate" required></td>
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
			<td>Sale From (Stock)</td>
			<td><select name="goDownId" id="goDownId">
					<option value="onShop">On Shop Stock</option>
					
			</select></td>
			<td>Discount</td>
			<td><input type="number" name="totalDiscount" id="totalDiscount" value="0.00" onkeyup="setTotalSaleAmount();"/></td>
		</tr>
		<tr>
			<td>Tax Amount</td>
			<td><input type="number" name="totalTax" id="totalTax" value="0.00" onkeyup="setTotalSaleAmount();" /></td>
			<td>Total Bill Amount</td>
			<td><input type="number" name="totalSaleAmount"	id="totalSaleAmount" value="0.00" required/></td>
		</tr>
		<tr>
			<td>Paid Amount</td>
			<td><input type="number" name="customerPaidAmount" id="customerPaidAmount" value="0.00" /></td>
			<td></td>
			<td><input type="button" value="Save Sales" onclick="saveSaleDetails()" /></td>
		</tr>
	</table>
	</fieldset>
	<fieldset>
	<legend style="color: blue; font-size: 20px; font-weight: bold;">Fruit Information</legend>
	<table>
			<tr>
				<td>Fruit Category</td>
				<td><select name="fruitCategory" id="fruitCategory" onchange="f_f_cat()">
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
						<option value="" >Select Fruit</option>
					</select>
				</td>
			</tr>
			<tr>	
				<td>Current Stock</td>
				<td><input type="text" name="currentStock" id="currentStock" readonly></td>				
				<td>Unit</td>
				<td><input type="text" name="fruitUnit" id="fruitUnit" readonly></td>
			</tr>
			<tr>	
				<td>Fruit Rate</td>
				<td>
					<select name ="fruitRate" id="fruitRate" onchange="showStock()" >
						<option value="">Select One</option>
					</select>				
					<input type="number" name="txt_sale_rate" id="txt_sale_rate" style="width: 50px;" />
				</td>
			</tr>
			<tr>	
				<td>Sale Quantity</td>
				<td><input type="number" name="fruitQuantity"
					id="fruitQuantity" value="0.00" onkeyup="setItemTotal()" onblur="setItemTotal()" /></td>
					<td>Discount</td>
				<td><input type="number" name="fruitItemDiscount" value="0.00"	id="fruitItemDiscount" onkeyup="setItemTotal()" onblur="setItemTotal()" /></td>
			</tr>
			<tr>	
				<td>Item Total</td>
				<td><input type="number" name="fruitItemTotal" value="0.00"	id="fruitItemTotal" /></td>
				<td>
				<input type="button" value="Add Item" onclick="addFruitItem();" />
				<input type="button" value="Clear" onclick="clearSaleFruitDetails()" />
				</td>
			</tr>
		</table>
		</fieldset>
		</div>
	</div>
	<div id="right">
		<table id="f_details">	
			<tr>
				<th width="15%">Fruit Name</th>
				<th width="10%">Fruit Unit</th>
				<th width="15%">Fruit Rate</th>
				<th width="15%">Fruit Quantity</th>
				<th width="15%">Discount</th>
				<th width="20%">Fruit Item Total</th>
				<th width="20%">Action</th>
			</tr>
		<tbody id="saleItemList">
		</tbody>
	</table>
</div>
</div>	
</body>
</html>