<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="./js/jquery-latest.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//alert("hi there");
	});
	
		
	function f1(){
		//alert("This is function");
		var radioItem=$('input[name=gender]:checked').val();
		//alert(radioItem);
		
		var textItem=$('#idN1').val();
		//alert(textItem);
		$.get('MyServlet1', {
			textItem:textItem,
			radioItem:radioItem,
			token:'INSERT'
		}, function(responseJson) {
			//alert("hello ajax");
			
		});
	}

	function f2(){
		
		/**/$.get('MyServlet1', {
			token:'GET'
		}, function(responseJson) {
			//alert("hello ajax");
			$.each(responseJson, function(k, v) {
			    //display the key and value pair
			    //alert("key= " + k + "and value= "+ v);
			    $.each(v,function(key,val){
			    	alert("key="+key+" and val="+val);
			    });
			});
		});
		/**/
		/*$.ajax({
			type : "GET",
			contentType : 'application/json',
			dataType : 'json',
			url : "MyServlet1",
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
		*/

		
	}//end f2()

</script>

<title>Insert title here</title>
</head>
<body>
	<h1>This is theFirst Page of Ajax</h1>
	Enter Your Name:
	<input type="text" name="n1" id="idN1">
	<br>
	<input type="radio" name="gender" value="male"> Male
	<br>
	<input type="radio" name="gender" value="female"> Female
	<br>
	<input type="radio" name="gender" value="other"> Other

<input type="button" name="ClickHere" value="INSERT" onclick="f1()">
<input type="button" name="ClickHereGET" value="GET RESULT" onclick="f2()">


</body>
</html>