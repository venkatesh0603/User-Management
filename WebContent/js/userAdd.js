userMain.controller('userAdd', function ($uibModalInstance,$scope,gioFactory,$log,userFactory) {

	$scope.user={"addressVo":{
		"city":{
			
		},"state":{
			
		},"country":{
			
		}
	}}
	
	$scope.countries= [];
	
	$scope.states= [];
	
	$scope.cities= [];
		
	$scope.getCounties=function(){
		gioFactory.getCountries().then(function(result){
			$scope.countries=result.data.data;
			$scope.states= [];
			$scope.cities= [];
		}).catch(function(result){
			$log.error('some thing went wrong while getting country list');
		});	
		
	};
	
	$scope.getCounties();
	
	$scope.getStates=function(){
		
		var countryId=$scope.user.addressVo.country.id;
		if(countryId!=-1){
		gioFactory.getStates(countryId).then(function(result){
			$scope.states= result.data.data;
			$scope.cities= [];
		}).catch(function(result){
			$log.error('some thing went wrong while getting state list');
		});	
		}
	};
	
	$scope.getCities=function(){
		var stateId=$scope.user.addressVo.state.id;
		if(stateId!=-1){
		gioFactory.getCities(stateId).then(function(result){
			$scope.cities= result.data.data;
		}).catch(function(result){
			$log.error('some thing went wrong while getting city list');
		});	
		}
	};
	
	  $scope.ok = function () {
		userFactory.saveUser($scope.user).then(function(result){
			if(result.data.statusCode==200){
			$log.info("Successfully added");
		    $uibModalInstance.close(result.data.data);
			}else{
				$log.error("Not able to add user. Some thing went wrong");
				$uibModalInstance.close(null);
			}
			
		}).catch(function(result){
			$log.error("Not able to add user. Some thing went wrong");
			$uibModalInstance.close(null);
		});

	  };

	  $scope.cancel = function () {
	    $uibModalInstance.dismiss('cancel');
	  };
	  
	  
	  $scope.today = function() {
	    $scope.user.dob = new Date();
	  };

	  $scope.clear = function() {
	    $scope.user.dob = null;
	  };

	  $scope.inlineOptions = {
	    customClass: getDayClass,
	    minDate: new Date(),
	    showWeeks: true
	  };

	  $scope.dateOptions = {
	    dateDisabled: disabled,
	    formatYear: 'yy',
	    maxDate: new Date(2020, 5, 22),
	    minDate: new Date(),
	    startingDay: 1
	  };

	  // Disable weekend selection
	  function disabled(data) {
	    var date = data.date,
	      mode = data.mode;
	    return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	  }

	  $scope.toggleMin = function() {
	    $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
	    $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
	  };

	  $scope.toggleMin();

	  $scope.dob = function() {
	    $scope.dob.opened = true;
	  };

	  $scope.setDate = function(year, month, day) {
	    $scope.user.dob = new Date(year, month, day);
	  };

	  $scope.formats = ['dd-MM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	  $scope.format = $scope.formats[0];
	  $scope.altInputFormats = ['dd-MM-yyyy'];

	  $scope.popup2 = {
	    opened: false
	  };

	  var tomorrow = new Date();
	  tomorrow.setDate(tomorrow.getDate() + 1);
	  var afterTomorrow = new Date();
	  afterTomorrow.setDate(tomorrow.getDate() + 1);
	  $scope.events = [
	    {
	      date: tomorrow,
	      status: 'full'
	    },
	    {
	      date: afterTomorrow,
	      status: 'partially'
	    }
	  ];

	  function getDayClass(data) {
	    var date = data.date,
	      mode = data.mode;
	    if (mode === 'day') {
	      var dayToCheck = new Date(date).setHours(0,0,0,0);

	      for (var i = 0; i < $scope.events.length; i++) {
	        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

	        if (dayToCheck === currentDay) {
	          return $scope.events[i].status;
	        }
	      }
	    }

	    return '';
	  }
	  
	});