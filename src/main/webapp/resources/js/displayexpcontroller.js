var app = angular.module('myApp', [ 'ui.bootstrap' ]);

var modalTemplate = 
		"<div class='modal-header'>"
		+ "<button ng-click='x()'type='button' class='close' data-dismiss='modal'>x</button>"
		+ "<h4 class='modal-title'>Warning!</h4>"
		+ "</div>"
		+ "<div class='modal-body'>Your current session will  5 minutes{{s.id}}</div>"
		+ "<div class='modal-footer'>"
		+ "<button ng-click='cancel()' type='button' class='btn btn-default' data-dismiss='modal'>Close</button>"
		+

		"<button ng-click='delete()' type='button' class='btn btn-primary' data-dismiss='modal'>Delete changes</button>	</div>";

app.controller('PatientTrailCtrl', function($scope, $http, $uibModal) {
	$http.get('list2?page=1').then(function(response) {
		$scope.names = response.data;
	});

	$http.get('pageCount2').then(function(response) {
		$scope.pagecount = response.data;
		console.log('Page count', response.data)
		$scope.numlist = new Array($scope.pagecount);
	
	});

	$scope.openDeleteModal = function(id) {
		var modalInstance = $uibModal.open({
			template : modalTemplate,
			controller : 'deleteModalController',
			resolve : {
				id : function() {
					return id;
				}
			}

		});
		
	
		
	  };
	
	$scope.goToPage = function(pageNumber) {
		console.log('GOIN TO A NEW PAGE');
		$scope.currentPage = pageNumber;
		$http.get('list2?page=' + pageNumber).then(function(response) {
			$scope.names = response.data;
			$scope.currentPage = 1;
		
		});
	}
});

app.controller('deleteModalController', function($scope, $http, $uibModalInstance, id) {
	console.log('VEDHAAA ID modal', id, 153);

	$scope.id = id;
	$scope.delete = function() {
		var body = { userId: $scope.id };
		console.log('VEDHA deleting', body);
		$http.post('delete_patientTrail?id=' + $scope.id).then(function(response) {
			console.log('VEDHAAA HEREE DELETED');
			$uibModalInstance.close('deleted');	
			location.reload();
		
			
			
		});
	};
	$scope.cancel = function() {
		$uibModalInstance.dismiss('cancel');

	};
	$scope.x = function() {
		$uibModalInstance.dismiss('x');
	};
});
