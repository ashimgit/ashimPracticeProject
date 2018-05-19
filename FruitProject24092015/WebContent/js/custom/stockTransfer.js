$(document).ready(function(){
	//alert('Hi');
	$("#fromGodown").change(function(){
		if($("#fromGodown").val() == $("#toGodown").val() || $("#fromGodown").val() =="" ){
			alert("From and To Godown Cannot be Same or Select Godown Correctly.");
			$("#fromGodown").val("");
		}else{
			$("#fromGodown").attr('disabled',true);
		}
	});
	
	$("#toGodown").change(function(){
		if($("#fromGodown").val() == $("#toGodown").val() || $("#toGodown").val() ==""){
			alert("From and To Godown Cannot be Same or Select Godown Correctly.");
			$("#toGodown").val("");
		}else{
			$("#toGodown").attr('disabled',true);
		}
	});
	
	$("#clearButton").click(function(){
		$("#toGodown").attr('disabled',false);
		$("#fromGodown").attr('disabled',false);
		$("#toGodown").val("");
		$("#fromGodown").val("");
		var fruitList = [];
		//pupulateData(fruitList)
		$("#saleItemList").html("");
		clearSaleFruitDetails();
	});
	
	$("#makeTransfer").click(function(){
		saveStockTransfer();
	});
});
var fruitDetailsJsonStr = "";
var jsonStr;
var fruitList = [];
function Fruit() {
	var self = this;
	self.tagId = null;
	self.fruitId = null;
	self.fruitName = null;
	self.quantity = null;
	self.saleUnit = null;
	self.saleItemRate = null;
	self.saleIteamTotal = null;
	self.saleItemDiscount = null;
}
function addFruitItem() {
//	var fruit = getFruit();
//	fruitList.push(fruit);
//	pupulateData(fruitList);
	var fruit = getFruit();
	var newTagId = fruit.tagId;
	var newQty = parseInt(fruit.quantity);
	var flag = 0;
	if (newTagId != null && newTagId.length > 0) {
		
		$.each(fruitList, function(index, item) {

			if (item.tagId == newTagId) {
				flag = 1;
			}

		});
		
		
	}else{
		flag = 1;
		//alert("Not valid Fruit.");
	}
	
	
	
	if (flag == 0) {
		if(newQty>0){
			fruitList.push(fruit);
			clearSaleFruitDetails();
		}
		else{
			alert("Selected Quantity is not Valid.");
		}
		
	} else {
		alert("Fruit Already Exists in List Or Not valid Fruit.");
		clearSaleFruitDetails();
	}
	pupulateData(fruitList);
}

function removeItem(id) {
	fruitList.splice(id, 1);
	pupulateData(fruitList);
}


function getFruit() {
	var fruit = new Fruit();
	var data = ($("#fruitRate").val()).split('-');
	var fruit = new Fruit();
	fruit.tagId = $("#fruitRate").val();
	fruit.fruitId = $("#fruitId").val().split("|")[0];
	fruit.fruitName = $("#fruitId").val().split("|")[1];
	fruit.quantity = $("#fruitQuantity").val();
	fruit.saleUnit = $("#fruitUnit").val();
	fruit.saleItemRate = parseFloat(data[1]);
	fruit.saleIteamTotal = parseFloat($("#fruitItemTotal").val());
	return fruit;
}


function pupulateData(fruitList) {

	var htmlData = "";
	var grandTotal = 0;
	$("#saleItemList").html(htmlData);
	$
			.each(
					fruitList,
					function(index, item) {
						htmlData += "<tr><td>"+item.fruitName+"("+item.fruitId+") </td><td>"
								+ item.saleUnit
								+ "</td><td>"
								+ item.saleItemRate
								+ "</td><td>"+item.quantity+"</td><td>"+item.saleIteamTotal+"</td><td><input type='button' name='remove' value='Remove' onclick='removeItem(\""
								+ index + "\")' /></td><</tr>";
						grandTotal+=item.saleIteamTotal;
					});
	htmlData += "<tr><td></td><td></td><td></td><td>Grand Total:</td><td>"+grandTotal+"/-</td><td><input type='hidden' name='grandTotal' id='grandTotal' value='"+grandTotal+"' /></td></tr>"
	$("#saleItemList").html(htmlData);
	//setTotalSaleAmount();
}


function f_f_cat() {
	// alert($("#fruitCatagoryId").val());
	var catagoryId = $("#fruitCategory").val();
	$.get('PurchaseEntryServlet', {
		catagoryId : catagoryId,
		reqType : "getFruitByCatagory"
	// PARAM
	}, function(responseJson) {
		$("#fruitId option").remove();
		$("#fruitId").append($('<option>', {
			value : "",
			text : "Select Fruit"
		}));
		$.each(responseJson, function(i, item) {
			var fruitIdName = item.fruitId + "|" + item.fruitName;
			// alert();
//			$("#fruitId").append($('<option>', {
//				value : fruitIdName,
//				text : item.fruitName
//			}));
			var itemId = item.fruitId+"|"+item.fruitName+"|"+item.fruitUnit;
			var itemName = item.fruitName + " ("+item.fruitUnit+")"
			$("#fruitId").append($('<option>', {value:itemId, text:itemName}));
		});
	}); // end of post
}


function f_f_unit_rate() {
	
	var fruitId = $("#fruitId").val().split("|")[0];
	var fromGodown =  $("#fromGodown").val();
	$.get('StockTransfer', {
		fruitId : fruitId,
		reqType : "getFruit",
		fromGodown : fromGodown
	}, function(responseJson) {
		fruitDetailsJsonStr=responseJson;
		$("#fruitRate option").remove();
		$("#fruitRate").append($('<option>', {
			value : "",
			text : "Select Fruit Rate"
		}));
		$.each(responseJson, function (i, item) {
			//$("#fruitUnit").val(item.saleUnit);
			//$("#fruitRate").val(item.saleItemRate);
			//$("#currentStock").val(item.quantity);
			var data = (item.tagId).split('-');
			var msg = '@ '+data[1]+' /'+item.saleUnit;
			$("#fruitRate").append($('<option>', {
				value : item.tagId,
				text : msg
			}));
			
		});
	}); // end of post
}


function showStock(){
	$.each(fruitDetailsJsonStr, function (i, item) {
		//$("#fruitUnit").val(item.saleUnit);
		var tagId = $("#fruitRate").val();
		//$("#currentStock").val(item.quantity);
		if(tagId==item.tagId){
			$("#fruitUnit").val(item.saleUnit);
			$("#currentStock").val(item.quantity);
		}
		
		
	});
}


function setItemTotal(){
	var rate = 0;
	var qty = 0;
	if($("#fruitQuantity").val() != null && !(isNaN($("#fruitQuantity").val()))){
		qty = parseFloat($("#fruitQuantity").val());
		var currentStock = parseFloat($("#currentStock").val());
		if(currentStock < qty || qty<0){
			alert('Please Enter Right Quanttity.');
			qty = 0;
			$("#fruitQuantity").val(0)
		}
	}
	if($("#fruitRate").val() != null && (isNaN($("#fruitRate").val()))){
		var tagId = $("#fruitRate").val();
		var temp = tagId.split('-');
		rate = temp[1];
		//alert(rate);
	}
	
	var totalAmt = rate*qty;
	$("#fruitItemTotal").val(totalAmt);
}


function saveStockTransfer() {
	var fromGodown = $("#fromGodown").val();
	var toGodown = $("#toGodown").val();
	var itemList = fruitList;
	var itemsJsonStr = JSON.stringify(itemList);
	if(fromGodown !=null && fromGodown.length > 0 && toGodown !=null && toGodown.length > 0 && toGodown!=fromGodown && fruitList.length >0){
		
	
	$.post('StockTransfer', {
		fromGodown : fromGodown,
		toGodown : toGodown,
		itemsJsonStr : itemsJsonStr,
		reqType : "saveStockTransfer"
	}, function(responseJson) {
		   alert(responseJson);
		   window.location.reload(true);
	}); // end of post
	
	}else{
		alert("Not a Valid Transfer Details");
	}
}

function clearSaleFruitDetails() {
	// $("#fruitRate").val("");
	// $("#fruitId").val("")
	$("#fruitQuantity").val(0);
	$("#fruitUnit").val("");
	$("#fruitItemTotal").val(0.00);
	$("#fruitCategory").val("");
	$("#currentStock").val(0);
	$("#fruitId option").remove();
	$("#fruitId").append($('<option>', {
		value : "",
		text : "Select Fruit"
	}));

	$("#fruitRate option").remove();

	$("#fruitRate").append($('<option>', {
		value : "",
		text : "Select Rate"
	}));
}