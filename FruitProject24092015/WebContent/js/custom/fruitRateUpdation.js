function populateFruitDetailsByCatagory() {

	var catagoryId = $('#CatagotyId').val();
	if (catagoryId != null && catagoryId != "") {
		var date = new Date();
		var reqType = "GetFruit";
		
		$.get('SaleRate', {
			reqType : reqType,
			catagoryId : catagoryId

		}, function(responseJson) {
			alert("responseJson::->" + responseJson.toString());
			populateFruitDetailsinJsp(responseJson);
		});

	}
}

function populateFruitDetailsinJsp(data) {

	var htmlRow = "<tr><td>Fruit Name</td><td>Sale Rate</td><td>Action</td></tr>";
	$.each(data, function(index, item){
		htmlRow+="<tr class="+item.fruitId+"><td>"+item.fruitName+"</td><td><input type='text' id='fruitRate' value='"+item.fruitSaleRate+"' /> </td><td><input type='button' value='Save' onclick='changeFruitSaleRate(\""+item.fruitId+"\")' /> </td></tr>";
	});

	$("#fruitDetails").html(htmlRow);
}

function changeFruitSaleRate(fruitId){
	
	var fruitRate = $("."+fruitId+" #fruitRate").val();
	alert(fruitId+"---"+fruitRate);
	
	//call ajax to save data into database
	if (fruitId != null && fruitId != "" && parseFloat(fruitRate)>0.00) {
		var date = new Date();
		var reqType = "saveFruitRate";
		var url = "SaleRate?refresh=" + date.getMilliseconds();

		$.get('SaleRate', {
			reqType : reqType,
			fruitRate : fruitRate,
			fruitId : fruitId

		}, function(data) {
			alert('hi');
			alert(data.toString());
			

		});

	}
	else {
		alert("Invalid Data.");
	}
}