<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/pages/template/home.jsp"%>
<%-- <jsp:include page=${pageContext.request.contextPath}/pages/home.jsp></jsp:include> --%>

<html>
<body>

	<h2>Enter Your Login Credentials</h2>
	<form action="login" method="get">
		<table>
			<tr>
				<td>User Name</td>
				<td>
			<input type="text" name="username">
				<td></tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" Value="Login"></td>
				<td><input type="reset" Value="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>
