<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="db.manager.DBManager"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-latest.js" type="text/javascript"></script>
<script src="js/custom/fruitRateUpdation.js" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sale Rate Updation Form</title>
<%
	List<String[]> catagoryList = new DBManager().getAllFruitCatagory();
%>
</head>
<body>
	<table>
		<tr>
			<td>Select Catagory :</td>
			<td><select name="CatagotyId" id="CatagotyId" onchange="populateFruitDetailsByCatagory()" >
				<option value="">Select One</option>
				<%
						for (int i = 0; i < catagoryList.size(); i++) {
								String[] catagory = (String[]) catagoryList.get(i);
					%>
					<option value="<%=catagory[0]%>" ><%=catagory[1]%></option>
					<%
						}
					%>
				
			</select></td>
			<td></td>
		</tr>
		<tbody id="fruitDetails" >
		<tr>
			<td>Fruit Name</td>
			<td>Sale Rate</td>
			<td>Action</td>
		</tr>
		</tbody>
	</table>
</body>
</html>