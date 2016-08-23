(function() {
	var app = angular.module("compagnieAerienne", []);
	
	app.directive('compagnieAerienne', function($http) {
		return {
			restrict: 'E',
			templateUrl: 'compagnie-aerienne.html',
			controller: function() {
				var self = this;
				
				self.compagnieAeriennes = [];
				
				self.mode=null;
				
				self.compagnieAerienne = null;
				
				self.list = function() {
					$http({
						method : 'GET',
						url : 'services/compagnieAerienne/'
					}).then(function successCallback(response) {
						self.compagnieAeriennes = response.data;
					}, function errorCallback(response) {

					});
				};
				
				
				self.add = function() {
					self.compagnieAerienne={};
				}; 
				
				self.save = function() {
					if(self.compagnieAerienne.id) {
						$http({
							method : 'PUT',
							url : 'services/compagnieAerienne/' + self.compagnieAerienne.id,
							data : self.compagnieAerienne
						}).then(function successCallback(response) {
							self.list();
							self.compagnieAerienne=null;
						}, function errorCallback(response) {
			
						});
					} else {
						$http({
							method : 'POST',
							url : 'services/compagnieAerienne/',
							data : self.compagnieAerienne
						}).then(function successCallback(response) {
							self.list();
							self.compagnieAerienne=null;
						}, function errorCallback(response) {
			
						});
					}
				}; 
				
				
				self.edit = function(id) {
					$http({
						method : 'GET',
						url : 'services/compagnieAerienne/' + id
					}).then(function successCallback(response) {
						self.compagnieAerienne = response.data;
					}, function errorCallback(response) {

					});
				}; 
				
				
				self.remove = function(id) {
					$http({
						method : 'DELETE',
						url : 'services/compagnieAerienne/' + id
					}).then(function successCallback(response) {
						self.list();
					}, function errorCallback(response) {

					});
				}; 
				
				
				self.list();
			},
			controllerAs: 'compagnieAerienneCtrl'
		};
	});

})(); 