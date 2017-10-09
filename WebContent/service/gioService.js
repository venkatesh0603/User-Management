myService.factory("gioFactory",function($http){
	return{

		getCountries : function() {

			return $http({
				method : "GET",
				url : "/rest/gio/countries"
			}).success(function(response) {
				console.log("successfully get country list");
				return response;
			}).error(function(response, status) {
				console.error("getting countries list failed");
				return {
					"data" : {
						"data" : []
					}
				};
			});
			
			
		},
		getStates : function(country) {

			return $http({
				method : "GET",
				url : "/rest/gio/states/"+country
			}).success(function(response) {
				console.log("successfully get state list");
				return response;
			}).error(function(response, status) {
				console.error("getting states list failed");
				return {
					"data" : {
						"data" : []
					}
				};
			});
			
			
		},
		getCities : function(state) {

			return $http({
				method : "GET",
				url : "/rest/gio/cities/"+state
			}).success(function(response) {
				console.log("successfully get city list");
				return response;
			}).error(function(response, status) {
				console.error("getting cities list failed");
				return {
					"data" : {
						"data" : []
					}
				};
			});
			
			
		}		
	}
});