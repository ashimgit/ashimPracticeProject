function showStockDetails() {
	var godownId = $("#godownId").val();

	$.post('ShowStock', {
		godownId : godownId,
	// PARAM
	}, function(responseJson) {
		//alert(responseJson);
		populateStockDetails(responseJson);
	});
}

function populateStockDetails(responseJson){
	//alert('hi');
	var htmlData = "";
	var grandTotal = 0;
	$("#showStockDetails").html(htmlData);
	$.each(responseJson,function(index, item) {
		var fruitName = item.fruitName +"("+item.fruitId+")";
		var data = (item.tagId).split('-');
		var rate = data[1];
		htmlData = htmlData + "<tr><td>"+(index+1)+"</td><td>"+fruitName+"</td><td>"+item.quantity+"</td><td>"+item.unit+"</td><td>"+rate+"</td><td>"+item.tagId+"</td></tr>";
	});
	$("#showStockDetails").html(htmlData);
} 