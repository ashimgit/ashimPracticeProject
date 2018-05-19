<%@page import="db.manager.DBManager"%>
<%@page import="master.fruitmaster.FruitMaster"%>
<%@page import="sale.pojo.SaleItemDetail"%>
<%@page import="java.util.List"%>
<%@page import="customer.Customer"%>
<%@page import="sale.pojo.Sale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill-Halder Fruit Shop</title>
<style type="text/css">
* {margin: 0px; padding: 0px;}
body {background-color: #EEE; margin: 0px; padding : 0px;}
#container {width: 700px; height: 920px; margin: 0 auto; background-color: #FFF; border: 1px solid black;}
#heading {width: 100%; height: 80px;};
#Contents {with: 100% top: 50px; position: relative;}
#content_id {width: 680px; margin: 0 auto;}
#sale {width: 340px; height: 50px; display: inline-block;}
#customer {width: 335px; height: 50px; display: inline-block;}
#details {height: 500px;}
#bill td {text-align: center;}
.description {text-align: left;}
#grt {border-collapse: collapse;}
#grt td {font-size: 1em; border: 1px solid #EEE; padding: 3px 7px 2px 7px; text-align: right;}
</style>
<%
	Sale sale = (Sale) request.getAttribute("SaleDetails");
	Customer customer = (Customer) request.getAttribute("customerDetail");
	List<SaleItemDetail> itemList = sale.getSaleIteamList();
%>
</head>
<body>
<div id="container">
<div id="heading">
<h1 style="text-align: center;">Halder Fruit Shop</h1>
</div>
<div id="Contents">
<div id="content_id">
<div id="sale">
<table>
	<tr>
		<td><b>Sell ID :</b></td>
		<td><b><%= sale.getSaleNo() %></b></td>
	</tr>
	<tr>
		<td><b>Sell Date :</b></td>
		<td><b><%= sale.getSaleDate() %>(YYYY-MM-DD)</b></td>
	</tr>
</table>
</div>
<div id="customer">
<table>
	<tr>
		<td><b>Customer ID :</b></td>
		<td><b><%= sale.getCustomerNo() %></b></td>
	</tr>
	<tr>
		<td><b>Customer Name :</b></td>
		<td><b><%= customer.getCustomerName()+" [Ph No: "+customer.getCustomerphoneNo1()+"]" %></b></td>
	</tr>
</table>
</div>
</div>
<span style="width: 100%; height: 10px; display: block;"></span>
<hr>
<div id="content_details">
<div id="details">
<table>
<tr>
	<th width="450px">Description</th>
	<th width="80px">Rate</th>
	<th width="80px">Discount</th>
	<th width="80px">Amount</th>
</tr>
</table>
<hr>
<table id="bill">

<%
for(int i=0; i<itemList.size(); i++){
	SaleItemDetail item = itemList.get(i);
	List<FruitMaster> fruitList = new DBManager().getFruitUnitByFruit(item.getFruitId());
	FruitMaster fruit = fruitList.get(0);
	String description = (i+1)+". "+fruit.getFruitName()+"["+item.getFruitId()+"] "+item.getQuantity()+" "+item.getSaleUnit()+" (Tag No: "+item.getTagId()+")";
%>
<tr>
<td width="450px" class="description"><%= description %></td>
<td width="80px"><%= item.getSaleItemRate() %></td>
<td width="80px"><%= item.getSaleItemDiscount() %></td>
<td width="80px"><%= item.getSaleIteamTotal() %></td>
</tr>
<% } %>
</table>
</div>
<div id="gross&total">
<table id="grt">
<tr height="40px">
	<td width="450px"><b>Total :</b></td>
	<td width="240px"><%= sale.getGrossAmount() %></td>
</tr>
<tr height="40px">
	<td width="450px"><b>Tax :</b></td>
	<td width="240px"><%= sale.getTaxAmount() %></td>
</tr>
<tr height="40px">
	<td width="450px"><b>Grand Total :</b></td>
	<td width="240px"><%= sale.getNetAmount() %></td>
</tr>
<tr height="40px">
	<td width="450px"><b>Customer Paid :</b></td>
	<td width="240px"><%= sale.getCustomerpaidAmount() %></td>
</tr>
</table>
</div>
<div id="gross&total">
<table id="grt">
<tr height="80px">
	
	<td width="690px">Authorised Signatory <br> For Halder Fruit Shop</td>
</tr>
<tr height="25px" align="left">
	
	<td width="690px">Note: Goods sold ones can't return back.</td>
</tr>

</table>
</div>
</div>
</div>
</div>
</body>
</html>