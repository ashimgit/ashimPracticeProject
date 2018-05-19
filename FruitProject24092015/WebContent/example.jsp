<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head runat="server">
    <title>Insert title here</title>
    <script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    <script>
        var app = angular.module('myAPP', []);
        app.controller('x', function($scope,$http) {
        var empid = 1;
        var data;
        $scope.employees = [
            { id: 0, 'name': 'Anubhav', 'address': 'Ghaziabad', 'dept': 'Developer', 'remarks': 'Y' }
        ];

            $scope.saveRecord = function () {
                if ($scope.newEmployee.id == null) {
                    $scope.newEmployee.id = empid++;
                    $scope.employees.push($scope.newEmployee);
                } else {

                    for (i in $scope.employees) {
                        if ($scope.employees[i].id == $scope.newEmployee.id) {
                            $scope.employees[i] = $scope.newEmployee;
                        }
                    }
                }
                $scope.newEmployee = {};
            }

            $scope.delete = function (id) {

                for (i in $scope.employees) {
                    if ($scope.employees[i].id == id) {
                        $scope.employees.splice(i, 1);
                        $scope.newEmployee = {};
                    }
                }

            }

            $scope.edit = function (id) {
                for (i in $scope.employees) {
                    if ($scope.employees[i].id == id) {
                        $scope.newEmployee = angular.copy($scope.employees[i]);
                    }
                }
            }

            $scope.save = function () {
                alert("===$scope.employees==="+$scope.employees)
                var data = $scope.employees;
                var responsePromise = $http.get("SaleRate",{
                    params : {
                        reqType : "getLocationRoleAddress",
                        callUsing : "ANGULAR",
                        EMPLOYEES : data
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
</head>
<body>
<form id="form1" runat="server">
    <div ng-app="myAPP" ng-controller="x">
        <label>Name</label>
        <input type="text" name="name" ng-model="newEmployee.name"/>
        <label>Address</label>
        <input type="text" name="address" ng-model="newEmployee.address"/>
        <label>Dept.</label>
        <input type="text" name="dept" ng-model="newEmployee.dept"/>
        <label>Remarks</label>
        <select name="remarks" ng-model="newEmployee.remarks">
            <option value="Y">Yes</option>
            <option value="N">No</option>
        </select>
        <br/>
        <input type="hidden" ng-model="newEmployee.id" />
        <input type="button" value="Save" ng-click="saveRecord()" class="btn btn-primary"/>
        <br />
        <br />
        <table border="1" bordercolor="blue">
            <tr style="color:blue">
                <th style="width:150px">Name</th>
                <th style="width:150px">Address</th>
                <th style="width:150px">Dept</th>
                <th style="width:150px">Remarks</th>
                <th>Action</th>
            </tr>
            <tr style="color:pink" ng-repeat="employee in employees">
                <td>{{ employee.name }}</td>
                <td>{{ employee.address }}</td>
                <td>{{ employee.dept }}</td>
                <td>{{ employee.remarks }}</td>
                <td>
                    <a href="#" ng-click="delete(employee.id)">delete</a>
                </td>
                <input type="button" value="Save to Server" ng-click="save()" />
            </tr>
        </table>
    </div>

</form>
</body>
</html>