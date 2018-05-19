<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="db.manager.DBManager"%>
<%@page import="java.util.List"%>
<%@page import="customer.Customer"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase</title>
<script src="js/jquery-latest.js"></script>
<script src="js/custom/purchase.js"></script>
<script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script>
var app = angular.module('myAPP', []);
app.controller('x', function($scope,$http) {
var empid = 1;
var data;
$scope.allPurchaseDetails = [
];
$scope.fruitList = [
];

    $scope.saveRecord = function () {
        if ($scope.newItem.id == null) {
            $scope.newItem.id = empid++;
            $scope.fruitList.push($scope.newItem);
            
        } else {

            for (i in $scope.fruitList) {
                if ($scope.fruitList[i].id == $scope.newItem.id) {
                    $scope.fruitList[i] = $scope.newItem;
                }
            }
        }
        $scope.newItem = {};
    }

    $scope.delete = function (id) {

        for (i in $scope.fruitList) {
            if ($scope.fruitList[i].id == id) {
                $scope.fruitList.splice(i, 1);
                $scope.newItem = {};
            }
        }

    }

    $scope.edit = function (id) {
        for (i in $scope.fruitList) {
           if ($scope.fruitList[i].id == id) {
                $scope.newItem = angular.copy($scope.fruitList[i]);
            }
        }
    }

    $scope.save = function () {
        alert("===$scope.employees==="+$scope.fruitList);
        $scope.allPurchaseDetails[0]=$scope.purchaseDetails;
        //$scope.allPurchaseDetails[0].totalPurchaseAmount = parseFloat($scope.purchaseDetails.totalPurchaseAmount);
        alert("===$scope.purchaseDetails==="+$scope.allPurchaseDetails)
        var data2 = $scope.allPurchaseDetails;
        var data = $scope.fruitList;
        var responsePromise = $http.get("PurchaseEntryServlet",{
            params : {
                reqType : "savePurchase",
                callUsing : "ANGULAR",
                fruitDetailList : data,
                purchaseDetail : data2
            },
            headers : {
                'Content-Type' : 'application/x-www-form-urlencoded'
            }
        });
        responsePromise.success(function(data, status, headers, config) {
            alert('HI');
            //$scope.gridOptions.addAllRows(data, status, headers, config);
        });
        responsePromise.error(function(data, status, headers, config) {
            alert("AJAX failed! ");
        });
    }
});

</script>

<%
	List<String[]> catagoryList = new DBManager().getAllFruitCatagory();
	List<Customer> supplierist = new DBManager().getAllSuppier();
	List<Customer> goDownList = new DBManager().getAllGoDown();
%>
</head>
<body>
<form id="form1" runat="server">
	 <div ng-app="myAPP" ng-controller="x">
	<table>
		<tr>
			<td>Purcahse Bill No</td>
			<td><input type="text" name="purchaseBillNo" id="purchaseBillNo" ng-model="purchaseDetails.purchaseBillNo" required></td>
			<td>Purchase Date</td>
			<td><input type="text" name="purchaseDate" id="purchaseDate" ng-model="purchaseDetails.purchaseDate" ></td>
		</tr>
		<tr>
			<td>From Godown</td>
			<td><select id="goDownNo" name="goDownNo" ng-model="purchaseDetails.goDownNo" >
					<option value="">Select GoDown</option>
					<%
						for (int i = 0; i < goDownList.size(); i++) {
							Customer goDown = (Customer) goDownList.get(i);
					%>
					<option value="<%=goDown.getCustomerCode()%>" ><%=goDown.getCustomerName()%></option>
					<%
						}
					%>
					
					
				</select></td>
			<td>Supplier</td>
			<td>
				<select id="supplierNo" name="supplierNo" ng-model="purchaseDetails.supplierNo" >
					<option value="">Select Supplier</option>
					<%
						for (int i = 0; i < supplierist.size(); i++) {
							Customer supplier = (Customer) supplierist.get(i);
					%>
					<option value="<%=supplier.getCustomerCode()%>" ><%=supplier.getCustomerName()%></option>
					<%
						}
					%>
					
					
				</select>
			</td>
		</tr>
		<tr>
			<td>Purchage Amount</td>
			<td><input type="number" name="totalPurchaseAmount" id="totalPurchaseAmount" ng-model="purchaseDetails.totalPurchaseAmount" ></td>
			
		</tr>
		
	</table>
	<!-- ******************************************************************************* -->
	<hr>
	
	<table>
		<tr>
			<td>Fruit Category</td>
			<td>
				<select id="fruitCatagoryId"  name="fruitCatagoryId" onchange="f_f_cat()" ng-model="newItem.fruitCatId">
					<option value="">Select Fruit Catagory</option>
					<%
						for (int i = 0; i < catagoryList.size(); i++) {
								String[] catagory = (String[]) catagoryList.get(i);
					%>
					<option value="<%=catagory[0]%>" ><%=catagory[1]%></option>
					<%
						}
					%>
					
					
				</select>
			</td>
			<td>Fruit Name</td>
			<td>
				<select id="fruitId" ng-model="newItem.fruitId">
					<option value="">Select Fruit</option>
					
				</select>
			</td>
		</tr>
		<tr>
			<td>Fruit Rate</td>
			<td>
				<input type="number" name="itemRate" id="itemRate" ng-model="newItem.purchaseItemRate" >
				
			</td>
			<td>Quantity</td>
			<td><input type="text" name="quantity" id="quantity" ng-model="newItem.quantity" ></td>
		</tr>
		<tr>
			<td>Purchage Amount</td>
			<td><input type="number" name="purchaseItemAmt id="purchaseItemRate" ng-model="newItem.purchaseItemTotal" ></td>
	 <input type="hidden" ng-model="newItem.id" />
		</tr>
	</table>
	<input type="button" value="Save" ng-click="saveRecord()" class="btn btn-primary"/>
        <br />
        <br />
        <table border="1" bordercolor="blue">
            <tr style="color:blue">
                <th style="width:150px">Catagory</th>
                <th style="width:150px">Fruit</th>
                <th style="width:150px">Rate</th>
                <th style="width:150px">Quantity</th>
                <th style="width:150px">Amount</th>
                <th>Action</th>
            </tr>
            <tr style="color:pink" ng-repeat="fruit in fruitList">
                <td>{{ fruit.fruitCatId }}</td>
                <td>{{ fruit.fruitId }}</td>
                <td>{{ fruit.purchaseItemRate }}</td>
                <td>{{ fruit.quantity }}</td>
                <td>{{ fruit.purchaseItemTotal }}</td>
                <td>
                    
                    <a href="#" ng-click="delete(fruit.id)">delete</a>
                </td>
                <input type="button" value="Save to Server" ng-click="save()" />
            </tr>
        </table>
	</div>
	</form>
</body>
</html>