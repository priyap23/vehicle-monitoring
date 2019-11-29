var app = angular.module("VehicleManagement", []);

//Controller Part
app.controller("VehicleController", function($scope, $http,  $interval) {
 
 
    $scope.vehicles = [];
    $scope.vehicleForm = {
    	strVehicleNumber: "",
    	strVehicleName: "",
    	strCustName: "",
    	strVehicleStatus: ""
    };
 
    // Now load the data from server
     _refreshVehicleData();
    
    _updateVehicleStatusData();
    
    _loadVehicleData();
    
    function _loadVehicleData() {
        var auto = $interval(function() {
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
     }, 61000);
     
   }
     
        
    //It loads the data once user hit URL
    //Calls: http://localhost:8080/home
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
 
    //It updates the status of vehicle after a minute
    //Calls: http://localhost:8080/updateStatus
    function _updateVehicleStatusData() {
        var auto = $interval(function() {
       	 var method = "";
            var url = "";
	        $http({
	            method: 'GET',
	            url: '/updateStatus'
	        }).then(
	              function(res) { // error
	                console.log("Error: " + res.status + " : " + res.data);
	            }
	        );
	       
	     }, 60000);
        
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
    
    //For changing the status color as per value
    //For example: Disconnect : Red color, Connect: green color
    $scope.getStatusClass = function (strVehicleStatus) {
    	  if (strVehicleStatus == 'Connected') {
    	    return 'text-success';
    	  } else {
    	    return 'text-danger';
    	  }
    	};
 
   
});