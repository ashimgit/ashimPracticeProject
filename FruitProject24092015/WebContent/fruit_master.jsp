<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="db.manager.DBManager"%>
<%@page import="java.util.List"%>
<%@ include file="home.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fruit Entry</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	
}

#pheader {	Width: 525px; height: 40px; display: block; background-color: #008B8B; color: #FFF; 
			font-size: 25px; font-weight: bold; line-height: 40px; margin-left: 2px;			
}

fieldset {
	Width: 500px;
	display: block;
	margin-left: 2px;
	margin-right: 2px;
	padding-top: 0.35em;
	padding-bottom: 0.625em;
	padding-left: 0.75em;
	padding-right: 0.75em;
	border: 2px groove(internal value);
	border-width:2px;
}

.input {
	width: 210px;
	height: 26px;
}

.s_input {
	width: 214px;
	height: 28px;
}
.subBtn {
	Width: 100px;
	height: 30px;
}
</style>
<script type="text/javascript" src="js/jquery-latest.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#new_fruit :input').hide();

	});
	function toggleStatus() {
		if ($('#toggleElement').is(':checked')) {
			$('#new_fruit :input').show();
			$('#catId').prop('disabled', 'disabled');

		} else {
			$('#new_fruit :input').hide();
			$('#catId').prop('disabled', false);

		}
	}

	function subChk() {
		//$("input").prop('required',true);
		//alert("Hiiii");
		$("#idForm").validate();

		return true;
	}
</script>
<%
	List<String[]> catagoryList = new DBManager().getAllFruitCatagory();
%>
<%
			String flag=(String) request.getAttribute("msg");
    		if(flag==null){
    			flag="";
    		}
			
		%>
		
		
</head>
<body>
	<div id="pheader">
		Fruit Master Entry 
	</div>
	<div>
		<fieldset>
			<legend style="color: blue; font-size: 20px; font-weight: bold;">General
				Information</legend>
			<form action="FruitMasterEntryServlet" method="post" id="idForm">
				<table>
					<tr height="30px">
						<td><select id="catId" name="catId"
							class="s_input" required>
								<option value="">Select a Category</option>
								<%
									for (int i = 0; i < catagoryList.size(); i++) {

										String[] catagory = (String[]) catagoryList.get(i);
								%>
								<option value="<%=catagory[0]%>" ><%=catagory[1]%></option>
								<%
									}
								%>
						</select></td>
						<td><input id="toggleElement" type="checkbox"
							onchange="toggleStatus()" /> Not in List ?</td>
					</tr>
				</table>
				<div id="new_fruit">
					<table>
						<tr>
							<td><input type="text" id="mainCat"
								name="mainCat" placeholder="Category Name" class="input"
								required></td>
							<td><input type="text" id="mainCatDesc"
								name="mainCatDesc" placeholder="Category Description"
								class="input" required></td>
						</tr>
					</table>
				</div>
				<table>
					<tr>
						<td><input type="text" id="fName" name="fName"
							placeholder="Sub-Category Name" class="input" required></td>
						<td><input type="text" id="fDesc" name="fDesc"
							placeholder="Sub-Category Description" class="input" required></td>
					</tr>
				</table>
				<table>
					<tr>
						
							<!-- <input type="text" id="fUnit" name="fUnit" placeholder="Unit" class="input" required> -->
							<td>UNIT :&nbsp;</td>
							<td><input type="radio" name="unit" value="kg"> KG</td> 
							<td><input	type="radio" name="unit" value="box"> BOX</td>
							<td><input	type="radio" name="unit" value="piece"> PIECE</td>

					</tr>
				</table>
				<table>
					<tr>
						<td><input type="submit" name="submit" value="Submit"
							id="subBtn" class="subBtn" onclick="subChk()"></td>
					</tr>
				</table>
				<!-- 		<input type="submit" name="submit" value="submit" id="subBtn" onclick="subChk()"> -->
			</form>
		</fieldset>
		<%=flag %>
	</div>
</body>
</html>