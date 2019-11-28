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
   //var auto = $interval(function() {
   // $ timeout(function(){
       
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
        
   // },30000)
    	
   // }, 5000);
   
        
    // Private Method  
    // Call: http://localhost:8080/home
    function _refreshVehicleData() {
        // var auto = $interval(function() {
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
	     //}, 65000);
      
    }
 
    function _updateVehicleStatusData() {
        var auto = $interval(function() {
       	 var method = "";
            var url = "";
	        $http({
	            method: 'GET',
	            url: '/updateStatus'
	        }).then(
	            function(res) { // success
	                //$scope.vehicles = res.data;
	            },
	            function(res) { // error
	                console.log("Error: " + res.status + " : " + res.data);
	            }
	        );
	       
	     }, 60000);
        
       // _refreshVehicleData();
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
    
    $scope.getStatusClass = function (strVehicleStatus) {
    	  if (strVehicleStatus == 'Connected') {
    	    return 'text-success';
    	  } else {
    	    return 'text-danger';
    	  }
    	};
 
   
});