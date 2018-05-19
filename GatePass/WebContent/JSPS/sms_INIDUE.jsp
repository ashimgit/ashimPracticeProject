<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ov" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Un-Scheduled Message VIA Mobile</title>
</head>
<!--  http://localhost:8080/GatePass/JSPS/sms_INIDUE.jsp?mob=917278403639&text=INIDUE 1055555 11.05.2015 11.05 RTIZEN ABCD -->
<body>

<ov:action name = "UnScheduleSMSviamobile!UnScheduleSMSviamobile" ignoreContextParams = "true" executeResult = "true">
	<ov:param name = "mobile_no" value = "%{#parameters.mob}"/> 
	<ov:param name = "msg_txt" value = "%{#parameters.text}"/>
</ov:action>

</body>
</html>