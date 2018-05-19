$(document).ready(function() {
	// alert('hi');
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; // January is 0!

	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}
	var today = yyyy + '-' + mm + '-' + dd;
	$('#saleDate').val(today);
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
	var data = ($("#fruitRate").val()).split('-');
	var fruit = new Fruit();
	fruit.tagId = $("#fruitRate").val();
	fruit.fruitId = $("#fruitId").val().split("|")[0];
	fruit.fruitName = $("#fruitId").val().split("|")[1];
	fruit.quantity = $("#fruitQuantity").val();
	fruit.saleUnit = $("#fruitUnit").val();
	fruit.saleItemRate = parseFloat($("#txt_sale_rate").val());
	fruit.saleIteamTotal = parseFloat($("#fruitItemTotal").val());
	fruit.saleItemDiscount = parseFloat($("#fruitItemDiscount").val());
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
						htmlData += "<tr><td>"
								+ item.fruitName
								+ "("
								+ item.fruitId
								+ ") </td><td>"
								+ item.saleUnit
								+ "</td><td>"
								+ item.saleItemRate
								+ "</td><td>"
								+ item.quantity
								+ "</td><td>"
								+ item.saleItemDiscount
								+ "</td><td>"
								+ item.saleIteamTotal
								+ "</td><td><input type='button' name='remove' value='Remove' onclick='removeItem(\""
								+ index + "\")' /></td><td></td></tr>";
						grandTotal += item.saleIteamTotal;
					});
	htmlData += "<tr><td></td><td></td><td></td><td></td><td>Grand Total:</td><td>"
			+ grandTotal
			+ "/-</td><td><input type='hidden' name='grandTotal' id='grandTotal' value='"
			+ grandTotal + "' /></td><td></td><td></td></tr>"
	$("#saleItemList").html(htmlData);
	setTotalSaleAmount();
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
			// $("#fruitId").append($('<option>', {
			// value : fruitIdName,
			// text : item.fruitName
			// }));
			var itemId = item.fruitId + "|" + item.fruitName + "|"
					+ item.fruitUnit;
			var itemName = item.fruitName + " (" + item.fruitUnit + ")"
			$("#fruitId").append($('<option>', {
				value : itemId,
				text : itemName
			}));
		});
	}); // end of post
}

function f_f_unit_rate() {

	var fruitId = $("#fruitId").val().split("|")[0];
	$.get('Sales', {
		fruitId : fruitId,
		reqType : "getFruit"
	}, function(responseJson) {
		fruitDetailsJsonStr = responseJson;
		$("#fruitRate option").remove();
		$("#fruitRate").append($('<option>', {
			value : "",
			text : "Select Fruit Rate"
		}));
		$.each(responseJson, function(i, item) {
			// $("#fruitUnit").val(item.saleUnit);
			// $("#fruitRate").val(item.saleItemRate);
			// $("#currentStock").val(item.quantity);
			var data = (item.tagId).split('-');
			var msg = '@ ' + data[1] + ' /' + item.saleUnit;
			$("#fruitRate").append($('<option>', {
				value : item.tagId,
				text : msg
			}));

		});
	}); // end of post
}

function showStock() {
	$.each(fruitDetailsJsonStr, function(i, item) {
		// $("#fruitUnit").val(item.saleUnit);
		var tagId = $("#fruitRate").val();
		// $("#currentStock").val(item.quantity);
		if (tagId == item.tagId) {
			$("#fruitUnit").val(item.saleUnit);
			$("#currentStock").val(item.quantity);
			var sale_rate = 0;
			sale_rate = $("#fruitRate").val().split("-")[1];
			$("#txt_sale_rate").val(sale_rate);
		}

	});
}

function setTotalSaleAmount() {
	var discount = 0;
	var tax = 0;
	var grandTotal = 0;
	if ($("#grandTotal").val() != null && !(isNaN($("#grandTotal").val()))) {
		grandTotal = parseFloat($("#grandTotal").val());
	}

	if ($("#totalDiscount").val() != null && !isNaN($("#totalDiscount").val())) {
		discount = parseFloat($("#totalDiscount").val());
	}

	if ($("#totalTax").val() != null && !isNaN($("#totalTax").val())) {
		tax = parseFloat($("#totalTax").val());
	}

	var totalSaleAmt = (grandTotal - discount) + tax;
	$("#totalSaleAmount").val(totalSaleAmt);
	$("#customerPaidAmount").val(totalSaleAmt);
}

function setItemTotal() {
	var rate = 0;
	var qty = 0;
	var discount = 0;
	if ($("#fruitQuantity").val() != null
			&& !(isNaN($("#fruitQuantity").val()))) {
		qty = parseFloat($("#fruitQuantity").val());
		var currentStock = parseFloat($("#currentStock").val());
		if (currentStock < qty || qty < 0) {
			alert('Please Enter Right Quanttity.');
			qty = 0;
			$("#fruitQuantity").val(0)
		}
	}
	if ($("#txt_sale_rate").val() != null
			&& !(isNaN($("#txt_sale_rate").val()))) {
		var rate = $("#txt_sale_rate").val();
		// var temp = tagId.split('-');
		// rate = temp[1];
		// alert(rate);
	}
	if ($("#fruitItemDiscount").val() != null
			&& !(isNaN($("#fruitItemDiscount").val()))) {
		discount = parseFloat($("#fruitItemDiscount").val());

	}

	var totalAmt = (rate * qty) - discount;
	$("#fruitItemTotal").val(totalAmt);
}

function Sales() {
	var self = this;
	self.saleNo = null;
	self.saleDate = null;
	self.customerNo = null;
	self.grossAmount = null;
	self.discountAmount = null;
	self.taxAmount = null;
	self.netAmount = null;
	self.godownId = null;
	self.customerpaidAmount = null;
}

function getSales() {
	var sale = new Sales();
	sale.saleDate = $("#saleDate").val();
	sale.customerNo = $("#customerName").val();
	sale.godownId = $("#goDownId").val();
	sale.discountAmount = parseFloat($("#totalDiscount").val());
	sale.taxAmount = parseFloat($("#totalTax").val());
	sale.netAmount = parseFloat($("#totalSaleAmount").val());
	sale.grossAmount = parseFloat($("#grandTotal").val());
	sale.customerpaidAmount = parseFloat($("#customerPaidAmount").val());
	return sale;
}

function saveSaleDetails() {
	//alert('Hi');
	var sale = getSales();
	var customerId = $('#customerPaidAmount').val();
	var saleJsonStr = JSON.stringify(sale);
	var itemList = fruitList;
	var itemsJsonStr = JSON.stringify(itemList);
	if(sale != null && fruitList.length >0 && customerId.length >0 && customerId!=null){
	$.post('Sales', {
		saleJsonStr : saleJsonStr,
		itemsJsonStr : itemsJsonStr,
		reqType : "saveSales"
	}, function(responseJson) {
		//alert('Hi');
		//alert(responseJson);
		var saleId = responseJson.toString();
		alert("Sale Id: "+saleId);
		if (saleId != null) {
			window.open("BillPrint?saleId=" + saleId);
		}
		window.location.reload(true);
		
	}); // end of post
 }else{
	 alert("Not a Valid Sale Details.");
 }
}

function clearSaleDetail() {
	$("#saleDate").val("");
	$("#customerName").val("");
	$("#goDownId").val("");
	$("#totalDiscount").val("");
	$("#totalTax").val("");
	$("#totalSaleAmount").val("");
	$("#grandTotal").val("");
	$("#customerPaidAmount").val("");
}

function clearSaleFruitDetails() {
	// $("#fruitRate").val("");
	// $("#fruitId").val("")
	$("#fruitQuantity").val(0);
	$("#fruitUnit").val("");
	$("#fruitItemTotal").val(0.00);
	$("#fruitItemDiscount").val(0.00);
	$("#fruitCategory").val("");
	$("#currentStock").val(0);
	$("#txt_sale_rate").val(0.00);
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