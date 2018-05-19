var fruitDetailsJsonStr = "";
var jsonStr;
var fruitList = [];
function Fruit() {
	var self = this;
	self.purchaseNo = null;
	self.fruitId = null;
	self.fruitName = null;
	self.quantity = null;
	self.fruitUnit = null;
	self.purchaseItemRate = null;
	self.purchaseItemTotal = null;
}
function addFruitItem() {
	var fruit = getFruit();
	if(fruit.fruitId !=null && fruit.fruitId.length>0 &&
			fruit.quantity !=null && fruit.quantity.length>0 &&
			fruit.purchaseItemRate !=null && fruit.purchaseItemRate>0 &&
			fruit.purchaseItemTotal !=null && fruit.purchaseItemTotal>0 ){
		
		fruitList.push(fruit);
		pupulateData(fruitList);
		
	}else{
		alert("Invalid fruit details.");
	}
	
	
	
	
}

function removeItem(id) {
	fruitList.splice(id, 1);
	pupulateData(fruitList);
}


function getFruit() {
	//var data = ($("#fruitId").val()).split('-');
	var fruit = new Fruit();
	fruit.fruitId = $("#fruitId").val().split("|")[0];
	fruit.fruitName = $("#fruitId").val().split("|")[1];
	fruit.quantity = $("#quantity").val();
	fruit.fruitUnit = $("#fruitId").val().split("|")[2];
	fruit.purchaseItemRate = parseFloat($("#itemRate").val());
	fruit.purchaseItemTotal = parseFloat($("#purchaseItemRate").val());
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
								+ item.fruitUnit
								+ "</td><td>"
								+ item.purchaseItemRate
								+ "</td><td>"+item.quantity+"</td><td>"+item.purchaseItemTotal+"</td><td><input type='button' name='remove' value='Remove' onclick='removeItem(\""
								+ index + "\")' /></td><</tr>";
						grandTotal+=item.purchaseItemTotal;
					});
	htmlData += "<tr><td></td><td><td></td></td><td>Grand Total:</td><td>"+grandTotal+"/-</td><td><input type='hidden' name='grandTotal' id='grandTotal' value='"+grandTotal+"' /></td></tr>"
	$("#purchaseItemList").html(htmlData);
	//setTotalSaleAmount();
}

function setTotalSaleAmount(){
	var discount=0;
	var tax = 0;
	var grandTotal = 0;
	if($("#grandTotal").val() != null && !(isNaN($("#grandTotal").val()))){
		grandTotal = parseFloat($("#grandTotal").val());
	}
	
	if($("#totalDiscount").val() != null && !isNaN($("#totalDiscount").val())){
		discount = parseFloat($("#totalDiscount").val());
	}
	
	if($("#totalTax").val() != null && !isNaN($("#totalTax").val())){
		tax = parseFloat($("#totalTax").val());
	}
	
	var totalSaleAmt = (grandTotal-discount)+tax;
	$("#totalSaleAmount").val(totalSaleAmt);
}

function f_f_cat() {
	
	var catagoryId = $("#fruitCatagoryId").val();
	$.get('PurchaseEntryServlet', {
		catagoryId : catagoryId,
		reqType : "getFruitByCatagory"
	// PARAM
	}, function(responseJson) {
		$("#fruitId option").remove();
		$("#fruitId").append($('<option>', {value:"", text:"Select Fruit"}));
		$.each(responseJson, function (i, item) {
			var itemId = item.fruitId+"|"+item.fruitName+"|"+item.fruitUnit;
			var itemName = item.fruitName + " ("+item.fruitUnit+")"
			$("#fruitId").append($('<option>', {value:itemId, text:itemName}));
		});
	}); // end of post
}

function Purchase(){
	var self = this;
	self.purchaseNo = null;
	self.purchaseDate = null;
	self.purchaseBillNo = null;
	self.supplierNo = null;
	self.goDownNo = null;
	self.totalPurchaseAmount = null;
	self.purchaseIteamList = null;
}

function getPurchase(){
	
	var purchase = new Purchase();
	purchase.purchaseNo = null;
	purchase.purchaseDate = $("#purchaseDate").val();
	purchase.purchaseBillNo = $("#purchaseBillNo").val();
	purchase.supplierNo = $("#supplierNo").val();
	purchase.goDownNo = $("#goDownNo").val();
	purchase.totalPurchaseAmount = parseFloat($("#totalPurchaseAmount").val());
	purchase.purchaseIteamList = null;
	return purchase;
}


function savePurchaseDetails() {
	
	var purchase = getPurchase();
	var purchaseJsonStr = JSON.stringify(purchase);
	var itemList = fruitList;
	var itemsJsonStr = JSON.stringify(itemList);
	if(validatePurchase() && fruitList.length >0){
	$.post('PurchaseEntryServlet', {
		purchaseJsonStr : purchaseJsonStr,
		itemsJsonStr : itemsJsonStr,
		reqType : "savePurchase"
	}, function(responseJson) {
		alert(responseJson);
		window.location.reload(true);
	}); // end of post
 }else{
	 alert("Not a valid purchase details.");
 }
}



function validatePurchase(){
	var flag = false;
	var errorField= [];
	var purchaseBill =$("#purchaseBillNo").val();
	var purchaseDate = $("#purchaseDate").val();
	var goDownId = $("#goDownNo").val();
	var supplierId = $("#supplierNo").val();
	var totalPurchaseAmount =parseFloat($("#totalPurchaseAmount").val());
	if(purchaseBill == null || purchaseBill.length == 0){
		errorField.push("Purchase Bill");
	}
	if(purchaseDate == null || purchaseDate.length == 0){
		errorField.push("Purchase Date");
	}
	if(goDownId == null || goDownId.length == 0){
		errorField.push("Go Down Id");
	}
	if(supplierId == null || supplierId.length == 0){
		errorField.push("SupplierId");
	}
	if(totalPurchaseAmount == null || supplierId == 0.00){
		errorField.push("Total Purchase Amount");
	}
	
	if(errorField.length == 0){
		flag = true;
	}
	
	//alert(flag);
	return flag;
}