
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/pages/template/home.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script src="resources/js/library/jquery-latest.js"></script> 
<script>
$(document).ready(function(){
	alert("Hi jquery");
	
	debugger;
	/*$.post('ProductHeader',{token:"getProductHeader"},function(res){
		alert(res);
		
		 /*  $.each(res,function(key,val){
			  
		    	resultString[i]=val;
		    	i++;
		    }); 
		  alert(resultString); ***
		    
	});*/
	/*$.ajax({
		type : "POST",
		contentType : 'application/json',
		dataType : 'json',
		url : "ProductHeader",
		data : JSON.stringify([ "JQUERY data" ]),
		//data : "This is jquery data",
		success : function(result) {
			//var x = document.getElementById("selectVessel");

			//alert("This is ajax");
			alert(result);
			//for (var j = 0; j < result.length; j++) {
				//alert("This is ajax");
			//}
		},
		error : function() {
			console.log();
			alert('error in ajax');

		}
	});
	*/
	/**/$.get('ProductHeader',{},function(res){
		alert(res);
		/*  $.each(res,function(key,val){
		    	if(key=='k1'){
		    		alert("this is "+key+" and value is="+val);
		    	}
		    }); */
		    alert("json");
	});
	/**/
});

</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Entry</title>
</head>
<body>
	<h1>Product Entry</h1>
	<br>
	 <form action="productEntry.do" method="get">
	
		<table>
			<tr><td>Enter Parent Product Name</td><td><input type="text" name="parProdName"></tr>
			<tr><td>Enter Addr1</td><td><input type="text" name="addr1"></tr>
			<tr><td>Enter Addr2</td><td><input type="text" name="addr2"></tr>
			<tr><td>Enter Addr3</td><td><input type="text" name="addr3"></tr>
			<tr><td>Enter pin</td><td><input type="text" name="pin"></tr>
			<tr><td>Enter state</td><td><input type="text" name="state"></tr>
			<tr><td>Enter Phone 1</td><td><input type="text" name="ph1"></tr>
			<tr><td>Enter phone 2</td><td><input type="text" name="ph2"></tr>
			<tr><td>Enter email</td><td><input type="text" name="email"></tr>
			<tr><td>Enter pan</td><td><input type="text" name="pan"></tr>
			<tr><td>Enter gstin</td><td><input type="text" name="gstin"></tr>
			<tr><td>Enter remarks</td><td><input type="text" name="remarks"></tr>
			<tr><td>Enter role</td><td><input type="text" name="role"></tr>
			<tr><td>Enter type</td><td><input type="text" name="type"></tr>
			<tr><td><input type="submit"value="Enter"></td><td><input type="reset" value="reset"></tr>
			
		</table>
	</form>
	
	
</body>
</html>