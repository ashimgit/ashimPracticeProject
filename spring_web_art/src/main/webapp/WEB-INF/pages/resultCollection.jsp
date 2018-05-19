<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Here, Key 1 : ${key1}</h1><br>
<c:if test="${key1=='hit'}">
	<c:out value="This is if/else test, college=  ${key1 }"></c:out>
</c:if>

**********************testing c:when *************************************<br />
<c:choose>
	<c:when test="${key1=='hit' }"> This is c:choose:when test, college= <i>${key1}</i> </c:when>
	
	<c:otherwise>This is c:otherwise</c:otherwise>

</c:choose>
<br />************************* for each Object *****************************************************<br>
<c:forEach items="${key2 }" var="dept">
	<c:out value="${dept.deptName }">
		
	</c:out>
	<br />
</c:forEach>

</body>
</html>