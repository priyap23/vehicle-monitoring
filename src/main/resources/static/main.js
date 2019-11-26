var app = angular.module("VehicleManagement", []);

//Controller Part
app.controller("VehicleController", function($scope, $http) {
 
 
    $scope.vehicles = [];
    $scope.vehicleForm = {
    	strVehicleNumber: "",
    	strVehicleName: "",
    	strCustName: "",
    	strVehicleStatus: ""
    };
 
    // Now load the data from server
    _refreshVehicleData();
   
   
 
    // Private Method  
    // Call: http://localhost:8080/home
    function _refreshVehicleData() {
    	 var method = "";
         var url = "";
        $http({
            method: 'GET',
            url: '/home'
        }).then(
            function(res) { // success
                $scope.vehicles = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
    	_refreshVehicleData();
        
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
   
});