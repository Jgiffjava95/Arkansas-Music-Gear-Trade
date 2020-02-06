var musicapp = angular.module('musicapp', [ 'ngRoute','ngFileUpload' ]);

musicapp.config(function($routeProvider) {
	$routeProvider.when('/trade', {
		templateUrl : 'trade.html'
	}).when('/tickets', {
		templateUrl : 'tickets.html'
	}).when('/services', {
		templateUrl : 'services.html'
	}).when('/login_register', {
		templateUrl : 'login_register.html'
	}).when('/addPost', {
		templateUrl : 'addPost.html',
		controller : 'itemAddController'
	}).when('/yourPosts', {
		templateUrl : 'yourPosts.html'
	}).otherwise({
		templateUrl : 'trade.html'
	});

});

musicapp.controller('tradeController', function($scope, $http) {
	
	$scope.itemCat = ["Guitar", "Bass", "Drums", "Piano", "Keyboard", "Synth", 
		"Microphone", "Classical", "Wind", "Recording", "Software", "Amp/Speaker", "Misc"]
	
	$scope.cities = ["Little Rock", 
		"North Little Rock", 
		"Fort Smith", 
		"Feyetteville", 
		"Springdale", 
		"Jonesboro", 
		"Conway", 
		"Rogers", 
		"Pine Bluff", 
		"Bentonville"
		]
	
	$scope.resetFilters = function() {
		
		$scope.filteritem.itemCat = null;
		
	}
	
	
	$scope.isPutDisabled = false;
	
	$scope.visible = true;
	$scope.visible2 = true;
	
	$scope.editItem = function(itemToView) {
		$scope.itemToView = angular.copy(itemToView);
		console.log('selectItem() called ' + angular.toJson(itemToView));
		$scope.visible2 = false;
		console.log('picFile: ' + $scope.picFile);
		$scope.picFile = undefined;
	}
	
	$scope.selectItem = function(itemToView) {
		$scope.itemToView = angular.copy(itemToView);
		console.log('selectItem() called ' + angular.toJson(itemToView));
		$scope.visible = false;
		console.log('picFile: ' + $scope.picFile);
	}
	
	$scope.returnToPosts = function() {
		window.location.reload();
		$scope.visible = true;
		$scope.getItems();
	}
	
	$scope.returnToPosts2 = function() {
		window.location.reload();
		$scope.isPutDisabled = false;
		$scope.visible2 = true;
		$scope.getItems();
	}

	$scope.getItems = function() {
		console.log('getItems() call test');
		$http.get("/MusicApp/API/item")
		.then(function(response) {
			$scope.visible = true;
			$scope.visible2 = true;
			$scope.isPutDisabled = false;
			$scope.items = response.data;
			$scope.updateStatus = "";
		}, function(response) {
			console.log('error http getItems: ' + response.status)
		});
	}
	
	$scope.deleteItem = function(itemId) {
		console.log('deleted item: ' + itemId);
		$http.delete("/MusicApp/API/item/removeItem/" + itemId)
		.then(function(response) {	
			$scope.isPutDisabled = true;
			$scope.updateStatus = 'Delete Successful.';			
		}, function(response) {
			console.log('error HTTP DELETE item: ' + response.status);
			$scope.updateStatus = 'Delete Error, ' + response.data.message;
		});
	}
	
	$scope.updateImage = function() {
	    var file = document.getElementById('file').files[0];
	    var fileReader = new FileReader();

	    fileReader.onload = function(e) {
	      var data = fileReader.result;	
	      if (data !== undefined && data.length > 0) {
		      $scope.itemToView.thumbnail = data.split(',')[1];
	      } else {
	    	  $scope.itemToView.thumbnail = '';
	      }
	      $scope.putItem();
	      $scope.removeImage();
	    }
	   
	    fileReader.readAsDataURL(file);
	}
	
	$scope.removeImage = function() {
		document.getElementById("file").value = "";
		
			$scope.picFile = undefined;
	};
	
	$scope.putItem = function() {
		$scope.jsonObject = angular.toJson($scope.itemToView, false);
		console.log('updated item: ' + $scope.jsonObject);

		$http.put("/MusicApp/API/item", $scope.jsonObject)
		.then(function success(response) {
					$scope.isPutDisabled = true;
					console.log('status: ' + response.status);
					$scope.updateStatus = 'Item Updated.';
				},
				function error(response) {
					console.log('error, return status: ' + response.status);
					$scope.updateStatus = 'update error, '
							+ response.data.message;
				});
	}
})	


	
	musicapp.controller('itemAddController', function($scope, $http ) {	
		
		$scope.successfulInsert = false;
		
		$scope.savePic = function(picFile) {
			console.log("save pic function called");
		}
		
		$scope.itemCat = ['Guitar', "Bass", "Drums", "Piano", "Keyboard", "Synth", 
			"Microphone", "Classical", "Wind", "Recording", "Software", "Amp/Speaker", "Misc"]
		
		$scope.add = function() {
		    var file = document.getElementById('file').files[0];
		    var fileReader = new FileReader();

		    fileReader.onload = function(e) {
		      var data = fileReader.result;	
		      if (data !== undefined && data.length > 0) {
			      $scope.newItem.thumbnail = data.split(',')[1];
		      } else {
		    	  $scope.newItem.thumbnail = '';
		      }
		      $scope.createItem();
		    }

		    fileReader.readAsDataURL(file);
		}
		
		
	$scope.createItem = function() {
		$scope.jsonObject = angular.toJson($scope.newItem, false);
		console.log('new item: ' + $scope.jsonObject);		
		
		$http.post("/MusicApp/API/item", $scope.jsonObject)
		.then(
				function success(response) {	
					$scope.successfulInsert = true;
					console.log('status: ' + response.status);
					$scope.createStatus = 'Item Posted.';
				},
				function error(response) {
					console.log('error, return status: ' + response.status);
					$scope.createStatus = 'insert error, ' + response.data.message;
				}
		);			
	};
})
