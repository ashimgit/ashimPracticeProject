<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<!--  <script  src="../resources/js/library/jquery321.js"></script> -->
<script src="./resources/js/library/jquery-latest.js"></script>
<!-- <script  src="./jquery-latest.js"></script> -->
<%--  <script src='<c:url value="resources/jquery-latest.js"/>'></script>
 --%>
<script type="text/javascript">
	$(document).ready(function() {
		alert("hi there");

		/* $.get('myAjax', {
			name : "This is my AJAX"
		}, function(responseJson) {
			alert("hello ajax");
		}); 
		*/
		$.ajax({
			type : "GET",
			contentType : 'application/json',
			dataType : 'json',
			url : "myAjax",
			data : JSON.stringify([ "JQUERY data" ]),
			//data : "This is jquery data",
			success : function(result) {
				//var x = document.getElementById("selectVessel");

				alert("This is ajax");
				for (var j = 0; j < result.length; j++) {
					alert("This is ajax");
				}
			},
			error : function() {
				console.log();
				alert('error in ajax');

			}
		});
	});
</script>
</head>
<body>
	<h2>Hello World!</h2>
</body>
<form action="url1">
	Enter your name : <input type="text" name="n1" id="i1"> <input
		type="submit" value="Click Here"> <br>**************************************<br>
	<a href=${pageContext.request.contextPath}/findSimpleLogin>Click
		Here for Simple Login Page </a> <br> <a
		href=${pageContext.request.contextPath}/transferToviewToReturnCollection>Click
		Here for Collection Return test Page </a>



</form>
</html>
