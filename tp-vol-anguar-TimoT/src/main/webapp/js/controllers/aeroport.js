(function() {
	var app = angular.module("aeroport", []);

	
	app.directive('aeroport', function($http) {
		return {
			restrict: 'E',
			templateUrl: 'aeroport.html',
			controller: function() {
				var self = this;
				
				self.aeroports = [];
				
				self.aeroport = null;
				
				self.list = function() {
					$http({
						method : 'GET',
						url : 'services/aeroport/'
					}).then(function successCallback(response) {
						self.aeroports = response.data;
					}, function errorCallback(response) {

					});

				}; 
				
				
				self.add = function() {
					self.aeroport={};
					
				}; 
				
				
				self.save = function() {
					if(self.aeroport.idAer) {
						$http({
							method : 'PUT',
							url : 'services/aeroport/' + self.aeroport.idAer,
							data : self.aeroport
						}).then(function successCallback(response) {
							self.list();
							self.aeroport=null;
						}, function errorCallback(response) {
			
						});
					} else {
						$http({
							method : 'POST',
							url : 'services/aeroport/',
							data : self.aeroport
						}).then(function successCallback(response) {
							self.list();
							self.aeroport=null;
						}, function errorCallback(response) {
			
						});
					}

				}; 
				
				
				self.edit = function(idAer) {
					$http({
						method : 'GET',
						url : 'services/aeroport/' + idAer
					}).then(function successCallback(response) {
						self.aeroport = response.data;
					}, function errorCallback(response) {

					});

				}; 
				
				
				self.remove = function(idAer) {
					$http({
						method : 'DELETE',
						url : 'services/aeroport/' + idAer
					}).then(function successCallback(response) {
						self.list();
					}, function errorCallback(response) {

					});

				}; 
				
				self.list();
			},
			controllerAs: 'aeroportCtrl',
		};
	});
	

})(); 