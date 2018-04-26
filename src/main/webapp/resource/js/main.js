var app = angular.module('app', [ 'ngTouch', 'ui.grid' ]);

app.service('dataService', function($http) {
	delete $http.defaults.headers.common['X-Requested-With'];
	this.getData = function(part) {
		// $http() returns a $promise that we can add handlers with .then()
		return $http({
			method : 'GET',
			url : '/rwdapp/rest/get/parts/'
					+ part
		});
	}
});



app.controller('MainCtrl', function($scope, dataService) {
	$scope.myData = null;
	$scope.part =0;
	dataService.getData($scope.part).then(function(dataResponse) {
		$scope.myData = dataResponse.data;
	});
	
	$scope.getParts = function() {
		dataService.getData($scope.part).then(function(dataResponse) {
			$scope.myData = dataResponse.data;
		});
	}
});