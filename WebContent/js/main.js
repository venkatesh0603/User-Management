var userMain = angular.module('userMainApp', [ 'ngAnimate', 'ngTouch',
		'ui.grid', 'ngRoute', 'ngSanitize', 'ui.bootstrap','myService','ngDialog' ]);
userMain.controller('userMainCtrl', [ '$location', '$scope',
		function($location, $scope) {
			$location.path('/user');
		} ]);

userMain.config(function($routeProvider) {
	$routeProvider.when("/user", {
		templateUrl : "/html/user.html",
		controller : "user"
	});
});