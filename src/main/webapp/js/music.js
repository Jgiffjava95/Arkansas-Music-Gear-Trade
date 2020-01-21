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
	
	$scope.itemCat = ["", "Guitar", "Bass", "Drums", "Piano", "Keyboard", "Synth", 
		"Microphone", "Classical", "Wind", "Recording", "Software", "Amp/Speaker", "Misc"]
	
	$scope.itemCat2 = ["Guitar", "Bass", "Drums", "Piano", "Keyboard", "Synth", 
		"Microphone", "Classical", "Wind", "Recording", "Software", "Amp/Speaker", "Misc"]
	
	$scope.cities = [
		'Adona',
		'Alexander',
		'Alicia',
		'Allport',
		'Alma',
		'Almyra',
		'Alpena',
		'Altheimer',
		'Altus',
		'Amagon',
		'Amity',
		'Anthonyville',
		'Antoine',
		'Arkadelphia',
		'Arkansas City',
		'Ashdown',
		'Ash Flat',
		'Atkins',
		'Aubrey',
		'Augusta',
		'Austin',
		'Avoca',
		'Bald Knob',
		'Banks',
		'Barling',
		'Bassett',
		'Batesville',
		'Bauxite',
		'Bay',
		'Bearden',
		'Beaver',
		'Beebe',
		'Beedeville',
		'Bella Vista',
		'Bellefonte',
		'Belleville',
		'Ben Lomond',
		'Benton',
		'Bentonville',
		'Bergman',
		'Berryville',
		'Bethel Heights',
		'Bigelow',
		'Big Flat',
		'Biggers',
		'Birdsong',
		'Black Oak',
		'Black Rock',
		'Black Springs',
		'Blevins',
		'Blue Eye',
		'Blue Mountain',
		'Bluff City',
		'Blytheville',
		'Bodcaw',
		'Bonanza',
		'Bono',
		'Booneville',
		'Bradford',
		'Bradley',
		'Branch',
		'Briarcliff',
		'Brinkley',
		'Brookland',
		'Bryant',
		'Buckner',
		'Bull Shoals',
		'Burdette',
		'Cabot',
		'Caddo Valley',
		'Caldwell',
		'Cale',
		'Calico Rock',
		'Calion',
		'Camden',
		'Cammack Village',
		'Campbell Station',
		'Caraway',
		'Carlisle',
		'Carthage',
		'Casa',
		'Cash',
		'Caulksville',
		'Cave City',
		'Cave Springs',
		'Cedarville',
		'Centerton',
		'Central City',
		'Charleston',
		'Cherokee Village',
		'Cherry Valley',
		'Chester',
		'Chidester',
		'Clarendon',
		'Clarksville',
		'Clinton',
		'Coal Hill',
		'College City',
		'College Station',
		'Colt',
		'Concord',
		'Conway',
		'Corinth',
		'Corning',
		'Cotter',
		'Cotton Plant',
		'Cove',
		'Coy',
		'Crawfordsville',
		'Crossett',
		'Cushman',
		'Daisy',
		'Damascus',
		'Danville',
		'Dardanelle',
		'Datto',
		'Decatur',
		'Delaplaine',
		'Delight',
		'Dell',
		'Denning',
		'De Queen',
		'Dermott',
		'Des Arc',
		'De Valls Bluff',
		'De Witt',
		'Diamond City',
		'Diaz',
		'Dierks',
		'Donaldson',
		'Dover',
		'Dumas',
		'Dyer',
		'Dyess',
		'Earle',
		'East Camden',
		'East End',
		'Edmondson',
		'Egypt',
		'Elaine',
		'El Dorado',
		'Elkins',
		'Elm Springs',
		'Emerson',
		'Emmet',
		'England',
		'Enola',
		'Etowah',
		'Eudora',
		'Eureka Springs',
		'Evening Shade',
		'Everton',
		'Fairfield Bay',
		'Fargo',
		'Farmington',
		'Fayetteville',
		'Felsenthal',
		'Fifty-Six',
		'Fisher',
		'Flippin',
		'Fordyce',
		'Foreman',
		'Forrest City',
		'Fort Smith',
		'Fouke',
		'Fountain Hill',
		'Fountain Lake',
		'Fourche',
		'Franklin',
		'Fredonia (Biscoe)',
		'Friendship',
		'Fulton',
		'Garfield',
		'Garland',
		'Garner',
		'Gassville',
		'Gateway',
		'Gentry',
		'Georgetown',
		'Gibson',
		'Gilbert',
		'Gillett',
		'Gillham',
		'Gilmore',
		'Glenwood',
		'Goshen',
		'Gosnell',
		'Gould',
		'Grady',
		'Grannis',
		'Gravel Ridge',
		'Gravette',
		'Greenbrier',
		'Green Forest',
		'Greenland',
		'Greenway',
		'Greenwood',
		'Greers Ferry',
		'Griffithville',
		'Grubbs',
		'Guion',
		'Gum Springs',
		'Gurdon',
		'Guy',
		'Hackett',
		'Hamburg',
		'Hampton',
		'Hardy',
		'Harrell',
		'Harrisburg',
		'Harrison',
		'Hartford',
		'Hartman',
		'Haskell',
		'Hatfield',
		'Havana',
		'Haynes',
		'Hazen',
		'Heber Springs',
		'Hector',
		'Helena',
		'Hensley',
		'Hermitage',
		'Hickory Ridge',
		'Higden',
		'Higginson',
		'Highfill',
		'Highland',
		'Hindsville',
		'Holland',
		'Holly Grove',
		'Hope',
		'Horatio',
		'Horseshoe Bend',
		'Horseshoe Lake',
		'Hot Springs',
		'Hot Springs Village',
		'Houston',
		'Hoxie',
		'Hughes',
		'Humnoke',
		'Humphrey',
		'Hunter',
		'Huntington',
		'Huntsville',
		'Huttig',
		'Imboden',
		'Jacksonport',
		'Jacksonville',
		'Jasper',
		'Jennette',
		'Jericho',
		'Jerome',
		'Johnson',
		'Joiner',
		'Jonesboro',
		'Judsonia',
		'Junction City',
		'Keiser',
		'Kensett',
		'Keo',
		'Kibler',
		'Kingsland',
		'Knobel',
		'Knoxville',
		'Lafe',
		'LaGrange',
		'Lake City',
		'Lake Hamilton',
		'Lakeview',
		'Lake View',
		'Lake Village',
		'Lamar',
		'Lavaca',
		'Leachville',
		'Lead Hill',
		'Leola',
		'Lepanto',
		'Leslie',
		'Letona',
		'Lewisville',
		'Lexa',
		'Lincoln',
		'Little Flock',
		'Little Rock',
		'Lockesburg',
		'London',
		'Lonoke',
		'Lonsdale',
		'Louann',
		'Lowell',
		'Luxora',
		'Lynn',
		'McAlmont',
		'McCaskill',
		'McCrory',
		'McDougal',
		'McGehee',
		'McNab',
		'McNeil',
		'McRae',
		'Madison',
		'Magazine',
		'Magness',
		'Magnolia',
		'Malvern',
		'Mammoth Spring',
		'Manila',
		'Mansfield',
		'Marianna',
		'Marie',
		'Marion',
		'Marked Tree',
		'Marmaduke',
		'Marshall',
		'Marvell',
		'Maumelle',
		'Mayflower',
		'Maynard',
		'Melbourne',
		'Mena',
		'Menifee',
		'Midland',
		'Mineral Springs',
		'Minturn',
		'Mitchellville',
		'Monette',
		'Monticello',
		'Montrose',
		'Moorefield',
		'Moro',
		'Morrilton',
		'Morrison Bluff',
		'Mountainburg',
		'Mountain Home',
		'Mountain Pine',
		'Mountain View',
		'Mount Ida',
		'Mount Pleasant',
		'Mount Vernon',
		'Mulberry',
		'Murfreesboro',
		'Nashville',
		'Newark',
		'Newport',
		'Nimmons',
		'Norfork',
		'Norman',
		'Norphlet',
		'North Crossett',
		'North Little Rock',
		'Oak Grove',
		'Oak Grove Heights',
		'Oakhaven',
		'Oden',
		'Ogden',
		'Oil Trough',
		'O-Kean',
		'Okolona',
		'Ola',
		'Omaha',
		'Oppelo',
		'Osceola',
		'Oxford',
		'Ozan',
		'Ozark',
		'Palestine',
		'Pangburn',
		'Paragould',
		'Paris',
		'Parkdale',
		'Parkers-Iron Springs',
		'Parkin',
		'Patmos',
		'Patterson',
		'Peach Orchard',
		'Pea Ridge',
		'Perla',
		'Perry',
		'Perrytown',
		'Perryville',
		'Piggott',
		'Pindall',
		'Pine Bluff',
		'Pineville',
		'Piney',
		'Plainview',
		'Pleasant Plains',
		'Plumerville',
		'Pocahontas',
		'Pollard',
		'Portia',
		'Portland',
		'Pottsville',
		'Powhatan',
		'Poyen',
		'Prairie Creek',
		'Prairie Grove',
		'Prattsville',
		'Prescott',
		'Pyatt',
		'Quitman',
		'Ratcliff',
		'Ravenden',
		'Ravenden Springs',
		'Reader',
		'Rector',
		'Redfield',
		'Reed',
		'Reyno',
		'Rison',
		'Rockport',
		'Rockwell',
		'Roe',
		'Rogers',
		'Rondo',
		'Rose Bud',
		'Rosston',
		'Rudy',
		'Russell',
		'Russellville',
		'St. Charles',
		'St. Francis',
		'St. Joe',
		'St. Paul',
		'Salem',
		'Salesville',
		'Scott',
		'Scranton',
		'Searcy',
		'Sedgwick',
		'Shannon Hills',
		'Sheridan',
		'Sherrill',
		'Sherwood',
		'Shirley',
		'Sidney',
		'Siloam Springs',
		'Smackover',
		'Smithville',
		'South Lead Hill',
		'Sparkman',
		'Springdale',
		'Springtown',
		'Stamps',
		'Star City',
		'Stephens',
		'Strawberry',
		'Strong',
		'Stuttgart',
		'Subiaco',
		'Success',
		'Sulphur Rock',
		'Sulphur Springs',
		'Summit',
		'Sunset',
		'Sweet Home',
		'Swifton',
		'Taylor',
		'Texarkana',
		'Thornton',
		'Tillar',
		'Tinsman',
		'Tollette',
		'Tontitown',
		'Traskwood',
		'Trumann',
		'Tuckerman',
		'Tull',
		'Tupelo',
		'Turrell',
		'Twin Groves',
		'Tyronza',
		'Ulm',
		'Valley Springs',
		'Van Buren',
		'Vandervoort',
		'Victoria',
		'Vilonia',
		'Viola',
		'Wabbaseka',
		'Waldenburg',
		'Waldo',
		'Waldron',
		'Walnut Ridge',
		'Ward',
		'Warren',
		'Washington',
		'Watson',
		'Weiner',
		'Weldon',
		'West Crossett',
		'Western Grove',
		'West Fork',
		'West Helena',
		'West Memphis',
		'West Point',
		'Wheatley',
		'Whelen Springs',
		'White Hall',
		'Wickes',
		'Widener',
		'Wiederkehr Village',
		'Williford',
		'Willisville',
		'Wilmar',
		'Wilmot',
		'Wilson',
		'Wilton',
		'Winchester',
		'Winslow',
		'Winthrop',
		'Woodson',
		'Wooster',
		'Wrightsville',
		'Wynne',
		'Yellville',
		'Zinc']
	
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
			$scope.item = response.data;
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
