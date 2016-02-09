var app = angular.module('app', ['ngTouch', 'ui.grid']);

app.service('dataService', function($http) {
	delete $http.defaults.headers.common['X-Requested-With'];
	this.getData = function() {
	    // $http() returns a $promise that we can add handlers with .then()
	    return $http({
	        method: 'GET',
	        url: 'http://10.81.208.173:8080/rwdapp/rest/get/parts/4',
	     });
	 }
	});
app.controller('MainCtrl', function($scope, dataService){

	  $scope.myData = null;
	  dataService.getData().then(function(dataResponse){
		  $scope.myData=dataResponse.data;
	  });
	});