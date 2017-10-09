var myService = angular.module('myService', []);
myService.factory('userFactory', function($http) {
	return {
		getAllUser : function() {
			return $http({
				method : "GET",
				url : "/rest/user/getAll"
			}).success(function(response) {
				console.log("successfully get user info");
				return response;
			}).error(function(response, status) {
				console.error("getting all users failed");
				return null;
			});
		},
		saveUser : function(user){
			return $http({
				method:"PUT",
				url:"/rest/user/add",
				data:user
			}).success(function(response){
				console.log("user added successfully");
				return response;
			}).error(function(response,status){
				console.error("user not able to add. Something went wrong");
				return null;
			});
		}

	};
});