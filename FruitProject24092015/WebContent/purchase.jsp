<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@page import="db.manager.DBManager"%>
<%@page import="java.util.List"%>
<%@page import="customer.Customer"%>
	
    
<!DOCTYPE html>
<%@ include file="home.jsp" %>
<html>
<head>

<%
	List<String[]> catagoryList = new DBManager().getAllFruitCatagory();
	List<Customer> supplierist = new DBManager().getAllSuppier();
	List<Customer> goDownList = new DBManager().getAllGoDown();
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Entry</title>
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
</style>

<script src="js/jquery-latest.js"></script>
<script src="js/custom/purchase.js"></script>
</head>
<body>
<div id="pheader">
Purchase Entry
</div>
<span style="height: 10px; display: block;"></span>
<div>
<form>
<fieldset>
<legend style="color: blue; font-size: 20px; font-weight: bold;">Purchase Information</legend>
<table>
		<tr>
			<td>Purchase Bill No</td>
			<td><input type="text" name="purchaseBillNo" id="purchaseBillNo"  required></td>
			<td>Purchase Date</td>
			<td><input type="date" name="purchaseDate" id="purchaseDate" required ></td>
		</tr>
		<tr>
			<td>From Go-down</td>
			<td><select id="goDownNo" name="goDownNo" >
					<option value="">Select Go-Down</option>
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
			<td>Supplier</td>
			<td>
				<select id="supplierNo" name="supplierNo" >
					<option value="">Select Supplier</option>
					<%
						for (int i = 0; i < supplierist.size(); i++) {
							Customer supplier = (Customer) supplierist.get(i);
					%>
					<option value="<%=supplier.getCustomerCode()%>" ><%=supplier.getCustomerName()%></option>
					<%
						}
					%>
					
					
				</select>
			</td>
		</tr>
		<tr>
			<td>Purchase Amount</td>
			<td><input type="number" name="totalPurchaseAmount" id="totalPurchaseAmount"></td>
			<td> <input type="button" value="Save Purchase" onclick="savePurchaseDetails()"/></td>
			<td> <input type="button" value="Clear" /></td>
		</tr>
		
	</table>
	</fieldset>
	<!-- ******************************************************************************* -->
	<fieldset>
	<legend style="color: blue; font-size: 20px; font-weight: bold;">Fruit Information</legend>
	<table>
		<tr>
			<td>Fruit Category</td>
			<td>
				<select id="fruitCatagoryId"  name="fruitCatagoryId" onchange="f_f_cat()" >
					<option value="">Select Fruit Catagory</option>
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
				<select name="fruitId" id="fruitId" >
					<option value="">Select Fruit</option>
					
				</select>
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Fruit Rate</td>
			<td>
				<input type="number" name="itemRate" id="itemRate" >
			</td>
			<td>Quantity</td>
			<td><input type="number" name="quantity" id="quantity" ></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Purchase Amount</td>
			<td><input type="number" name="purchaseItemAmt" id="purchaseItemRate" /></td>
			<td><input type="button" name="addItem" id="addItem" value="Add Item" onclick="addFruitItem()" /></td>
			<td><input type="button" name="clear" id="clear" value="Clear" /></td>
		</tr>
	</table>
	</fieldset>
	<div style="margin-left: 2px;">
	<table id="f_details">
	<tr>
	<th width="118px">Fruit Name</th>
	<th width="120px">Fruit Unit</th>
	<th width="120px">Fruit Rate</th>
	<th width="120px">Fruit Quantity</th>
	<th width="120px">Fruit Item Total</th>
	<th width="120px">Action</th>
	</tr>
		<tbody id="purchaseItemList">

		</tbody>
	</table>
	</div>
	</form>
	
</div>
<div style="width: 100%; height: 50px; display: block;" >
</div>	
</body>
</html>