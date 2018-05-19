<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="home.jsp" %>
<!DOCTYPE html>

<html>
    <head>
    
    	<%
			String flag=(String) request.getAttribute("msg");
    		if(flag==null){
    			flag="";
    		}
			
		%>
		
		
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COMS-Add Customer</title>
		<style type="text/css">
			body {}	
			#pheader {	Width: 495px; height: 40px; display: block; background-color: #008B8B; color: #FFF; 
						font-size: 25px; font-weight: bold; line-height: 40px; margin-left: 2px;			
			}		
			h3 {font-size: 25px; line-height: 40px; color: #fff;}
			#form_container {Width: 500px;}			
			#heading {width: 100%; height: 40px; background-color: #A4A4A4;}
			fieldset {Width: 470px;	display: block;	margin-left: 2px; margin-right: 2px; padding-top: 0.35em; padding-bottom: 0.625em; padding-left: 0.75em; padding-right: 0.75em;	border: 2px groove(internal value); border-width: 2px;}
			#form_doc {}
			.input {width: 240px; height: 25px;}
			.input_text {width: 242px; height: 70px;}
			.input_select {width: 244px; height: 25px;}
			.submit {width: 100px; height: 30px; background-color: black; color: #fff}
		</style>
    </head>
    <body>
    <div id="pheader">
		Add Customer / Go-Down / Supplier
	</div>	
	<div id="form_container">
    <form  action="CustomerServlet" method="post">	
	<div id="form_doc">
	<fieldset>
	<legend style="color: blue; font-size: 20px; font-weight: bold;">Information</legend>
        <table>
            <tr>
            	<td>Enter Type :</td>
            	<td>
					<select name="s_type" id="s_type" class="input_select" required>
						<option  value="">Select</option>
            		    <option  value="customer">Customer</option>
            			<option  value="supplier">Supplier</option>            			
            			<option  value="godown">Go-down</option>
            			
            		</select>
            	</td>
            </tr>
            <tr>
                <td width="150px">Name :</td>
                <td width="250px"><input type="text" name="customerName" id="customerName" class="input" pattern="[A-Za-z][a-zA-Z\s]{2,35}" title="Must contains 2-35 alphabets incuding spaces" required></td>
            </tr>
            <tr>
                <td width="150px">Address Line 1 :</td>
                <td width="250px"><textarea name="customerAddress1" id="customerAddress1" class="input_text" required></textarea></td>
            </tr>
            <tr>
                <td width="150px">Address Line 2 :</td>
                <td width="250px"><textarea name="customerAddress2" id="customerAddress2" class="input_text"></textarea></td>
            </tr>
            <tr>
                <td width="150px">Phone No 1 :</td>
                <td width="250px"><input type="text" name="customerPhone1" id="customerPhone1" pattern="[0-9]{10,12}" title="Must contain 10-12 digits" class="input" required></td>
            </tr>
			<tr>
                <td width="150px">Phone No 2 :</td>
                <td width="250px"><input type="text" name="customerPhone2" id="customerPhone2" pattern="[0-9]{10,12}" title="Must contain 10-12 digits" class="input"></td>
            </tr>
        </table>
        <table>
		<tr height="10px">
		</tr>
		 <tr>
                <td width="150px"></td>
                <td><input type="submit" name="submit" value="SUBMIT" class="submit"></td>
            </tr>
		</table>
		</fieldset>
		</div>
		 <%=flag %>
		 
		
        </form>
		</div>
    </body>
</html>
