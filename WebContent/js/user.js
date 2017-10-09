userMain
		.controller(
				'user',
				function($scope, userFactory, $uibModal, $log, ngDialog) {

					$scope.dataNotPresent = false;
					$scope.dataPresent = false;
					$scope.userList=[];

					userFactory.getAllUser().then(function(result) {
						if (result == null || result.data.data.length == 0) {
							$scope.dataNotPresent = true;
							$scope.dataPresent = false;
						} else {
							$scope.dataNotPresent = false;
							$scope.dataPresent = true;
							var gridUserInfo = [];
							var allUsers = result.data.data;
							for (var i = 0; i < allUsers.length; i++) {
								var usr = {
									"User Id" : allUsers[i].id,
									"Name" : allUsers[i].name,
									"Mobile Number" : allUsers[i].mobileNumber,
									"Email Id" : allUsers[i].emailId,
									"DOB" : allUsers[i].dob,
									"City" : allUsers[i].addressVo.city.name
								};
								gridUserInfo.push(usr);
							}
							$scope.userList = gridUserInfo;
						}
					});

					$scope.open = function(size) {

						var modalInstance = $uibModal.open({
							animation : true,
							ariaLabelledBy : 'modal-title',
							ariaDescribedBy : 'modal-body',
							templateUrl : '/html/userAdd.html',
							controller : 'userAdd',
							size : size
						});

						modalInstance.result
								.then(
										function(userAdded) {
											if (userAdded == null) {
												var dialog = ngDialog
														.open({
															template : '<p align="center">User addition failed</p>',
															plain : true
														});
												setTimeout(function() {
													dialog.close();
												}, 2000);
											} else {
												var usr = {
													"User Id" : userAdded.id,
													"Name" : userAdded.name,
													"Mobile Number" : userAdded.mobileNumber,
													"Email Id" : userAdded.emailId,
													"DOB" : userAdded.dob,
													"City" : userAdded.addressVo.city.name
												};
												$scope.userList.push(usr);
												var dialog=ngDialog
														.open({
															template : '<p align="center">User addition successful</p>',
															plain : true
														});
												setTimeout(function() {
													dialog.close();
												}, 2000);
												$scope.dataNotPresent = false;
												$scope.dataPresent = true;

											}
										}, function() {
											$log.info('Modal dismissed at: '
													+ new Date());
										});
					};

				});
