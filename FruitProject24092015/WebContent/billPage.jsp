<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="home.jsp" %>
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
Bill Details		
</div>
<span style="height: 10px; display: block;" ></span>
<div style="margin-left: 2px;" >
<form action="BillPrint" method="post">
	<table id="f_details">
		<thead>
			<tr align="center">
				<td colspan="2">
					<h2>Enter Bill Details</h2>
				</td>				
			</tr>
		</thead>
		<tr>
			<td>Enter the Bill No : </td><td><input type="text" name="saleId" style="Width: 250px; height: 25px;" required></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Get Bill" class="function">&nbsp;
			<input type="reset" value="Cancel" class="function"></td>
		</tr>
		
	</table>
	</form>
</div>
</div>	
</body>
</html>