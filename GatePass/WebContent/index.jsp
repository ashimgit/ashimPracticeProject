<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ov" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Indus Towers Gatepass System</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/index.css" />
</head>
<body>
<img src="<%=basePath%>/images/header_bg.png"  align='center' width="100%" height="140px"/>
<div class="container">
<br>

	<section id="content">
<ov:form action="login" method="post">
			
			<h1>Login Form</h1>
			<h2><font color="red"><ov:property value="message"/></font></h2>
			<div>
				<ov:textfield name="username" label="User Name" placeholder="Username" theme = "simple"/>
				<br><font color="red"><ov:fielderror fieldName="username"/></font>
			</div>
			<div>
				<ov:password name="password" label="Password" placeholder="Password" theme = "simple"/>
				<br><font color="red"><ov:fielderror fieldName="password"/></font>
			</div>
			
			<div style="padding-left:110px; ">
				<ov:submit value="Log in" theme = "simple"/>
				
			</div>
		</ov:form><!-- form -->
		<div class="button">
			Powered by <a href="http://rtizen.com/">AARTSSPL</a>
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
</body>
</html>