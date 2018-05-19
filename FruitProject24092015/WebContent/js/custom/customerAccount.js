function getCustomerAccountDetails(){
	//alert('hi');
	
	var customerId = $("#customerId").val();
	var fromDate = $("#fromDate").val();
	var toDate = $("#toDate").val();
	if(customerId !=null && customerId.length > 0 && fromDate !=null && fromDate.length > 0 && toDate !=null && toDate.length > 0){
	$.post('CustomerAccount', {
		reqType : "GetCustomerAccount",
		customerId : customerId,
		fromDate : fromDate,
		toDate : toDate

	}, function(responseJson) {
		//alert("responseJson::->" + responseJson.toString());
		populateAccountDetails(responseJson);
	});
	}else{
		alert("Entered Invalid Details");
	}
}

function populateAccountDetails(responseJson){
	
	var htmlData = "";
	var totalBillAmt = 0;
	var totalPaidAmt = 0;
	var needToPaidAmt = 0;
	$("#customerAccountDetails").html(htmlData);
	$.each(responseJson,function(index, item) {
		htmlData +="<tr><td>"+(index+1)+".</td><td>"+item.saleId+"</td><td>"+item.saleDate+"</td><td>"+item.saleAmt+"</td><td>"+item.paidAmt+"</td></tr>";
		totalBillAmt+=item.saleAmt;
		totalPaidAmt+=item.paidAmt;
	});
	needToPaidAmt = totalBillAmt - totalPaidAmt;
	htmlData +="<tr><td></td><td></td><td><b>Grand Total :</b></td><td><b>"+totalBillAmt+"/-</b></td><td><b>"+totalPaidAmt+"/-</b></td></tr>";
	htmlData +="<tr><td></td><td></td><td><b>Due :</b></td><td><input type='text' name='paidAmt' id='paidAmt' value='"+needToPaidAmt+"' /></td><td><input type='button' name='Paid' value='Paid' onclick='saveCustomerAccountPaidDetails()' /></td></tr>";
	//htmlData +="<tr><td></td><td></td><td><b>Previous Due :</b></td><td><input type='text' name='paidAmt' id='paidAmt' value='"+needToPaidAmt+"' /></td><td><input type='button' name='Paid' value='Paid' onclick='saveCustomerAccountPaidDetails()' /></td></tr>";
	$("#customerAccountDetails").html(htmlData);
}



function saveCustomerAccountPaidDetails(){
	//alert('hi');
	
	var customerId = $("#customerId").val();
	var fromDate = $("#fromDate").val();
	var toDate = $("#toDate").val();
	var paidAmt = $("#paidAmt").val();
	
	$.post('CustomerAccount', {
		reqType : "SaveCustomerAccount",
		customerId : customerId,
		fromDate : fromDate,
		toDate : toDate,
		paidAmt : paidAmt

	}, function(responseJson) {
		alert("responseJson::->" + responseJson.toString());
		//populateAccountDetails(responseJson);
	});
}



// all transaction 
function getCustomerAllAccountDetails(){
	//alert('hi');
	
	var customerId = $("#customerId").val();
	var fromDate = $("#fromDate").val();
	var toDate = $("#toDate").val();
	if(customerId !=null && customerId.length > 0 && fromDate !=null && fromDate.length > 0 && toDate !=null && toDate.length > 0){
	$.post('CustomerAccount', {
		reqType : "GetAllCustomerAccountDetails",
		customerId : customerId,
		fromDate : fromDate,
		toDate : toDate

	}, function(responseJson) {
		//alert("responseJson::->" + responseJson.toString());
		populateAllAccountDetails(responseJson);
	});
	}else{
		alert("Entered Invalid Details");
	}
}

function populateAllAccountDetails(responseJson){
	alert(responseJson);
	var htmlData = "";
	var totalBillAmt = 0;
	var totalPaidAmt = 0;
	var needToPaidAmt = 0;
	$("#customerAllAccountDetails").html(htmlData);
	$.each(responseJson,function(index, item) {
		var remarks ="";
		if(item.status=='F'){
			remarks="Bill Payment Due."
		}
		else if (item.status=='T'){
			remarks="Bill Adjusted."
		}
		else{
			remarks=item.status;
		}
		htmlData +="<tr><td>"+(index+1)+".</td><td>"+item.saleId+"</td><td>"+item.saleDate+"</td><td>"+item.saleAmt+"</td><td>"+item.paidAmt+"</td><td>"+remarks+"</td></tr>";
		//totalBillAmt+=item.saleAmt;
		//totalPaidAmt+=item.paidAmt;
	});
	//needToPaidAmt = totalBillAmt - totalPaidAmt;
	//htmlData +="<tr><td></td><td></td><td><b>Grand Total :</b></td><td><b>"+totalBillAmt+"/-</b></td><td><b>"+totalPaidAmt+"/-</b></td></tr>";
	//htmlData +="<tr><td></td><td></td><td><b>Due :</b></td><td><input type='text' name='paidAmt' id='paidAmt' value='"+needToPaidAmt+"' /></td><td><input type='button' name='Paid' value='Paid' onclick='saveCustomerAccountPaidDetails()' /></td></tr>";
	//htmlData +="<tr><td></td><td></td><td><b>Previous Due :</b></td><td><input type='text' name='paidAmt' id='paidAmt' value='"+needToPaidAmt+"' /></td><td><input type='button' name='Paid' value='Paid' onclick='saveCustomerAccountPaidDetails()' /></td></tr>";
	$("#customerAllAccountDetails").html(htmlData);
}