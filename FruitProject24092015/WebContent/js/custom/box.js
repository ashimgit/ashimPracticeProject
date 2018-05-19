$(document).ready(function(){
	//alert('Hi');
	$("#cname").change(function(){
		//alert('Hiiiiii');
		var customerId = $('#cname').val();
		$.post('BoxServlet', {
			customerId : customerId,
			reqType : "GetBox"
		}, function(responseJson) {
			$('#status').val(responseJson.toString());
		});
	});
	

	
//	$("#makeTransfer").click(function(){
//		saveStockTransfer();
//	});
});