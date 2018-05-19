<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Halder Fruits</title>
<style type="text/css">
* {margin: 0; padding: 0;}
body {font-family: Arial, sans-serif; background-color: #fff; font-size: 14px; color: #404040;}
#text1 {Width: 600px; height: 40px; margin: 0 auto; top: 80px; position: relative; display: block; text-align: center;}
#text2 {Width: 400px; height: 20px; margin: 0 auto; top: 100px; position: relative; display: block; text-align: center;}
#form {Width: 400px; height: 300px; margin: 0 auto; top: 130px; position: relative; display: block; background-color: #F7F7F7; border: 0.5px solid #EEE; border-radious: 3px; box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);}
#footer {left: 0px; right: 0px; bottom: 30px; position: absolute;}
form {margin: 0 auto;}
.input {width: 175px; height: 26px;}
#text1 h1 {font-family: 'Open Sans', arial; font-size: 40px; color: #555; font-weight: 350;}
#text2 h2 {font-family: 'Open Sans', arial; font-size: 18px; color: #555; font-weight: 400;}
</style>
</head>
<body>
<div id="text1">
<h1 class="text1">Halder Fruit Shop</h1>
</div>
<div id="text2">
<h2 class="text">Please Login to Continue</h2>
</div>
<div id="form">
<form action="LoginServlet" method="post">
<span style="width: 100%; height: 20px; display: block"></span>
	<div style="width: 380px; margin: 0 auto;">
		<img alt="" src="images/header.png" width="380px" height="80px">
	</div>
<span style="width: 100%; height: 30px; display: block"></span>
<div style=" width: 390px; margin: 0 auto;">	
	<table>
		<tr height="30px">
			<td width="100px"></td>
			<td width="180px"><input type="text" name="uname" placeholder="Enter username" class="input" required></td>
		</tr>
		<tr height="30px">
			<td width="100px"></td>
			<td width="180px"><input type="password" name="password" placeholder="Enter password" class="input" required></td>
		</tr>
	</table>
	<br>
	<table>	
		<tr>
			<td width="155px"></td>
			<td><input type="submit" value="Sign in" style="width: 80px; height: 30px; background-color: blue; color: #FFF;"></td>
		</tr>		
	</table>
</div>	
</form>
</div>
<div id="footer">
<hr>
<div style="right: 25px; position: absolute;">
<h5>&copy;&nbsp;ashimPedia 2015</h5>
</div>
</div>
</body>
</html>