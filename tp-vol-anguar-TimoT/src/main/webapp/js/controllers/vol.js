(function() {
	var app = angular.module("vol", []);

	
	app.directive('vol', function($http) {
		return {
			restrict: 'E',
			templateUrl: 'vol.html',
			controller: function() {
				var self = this;
				
				self.vols = [];
				
				self.vol = null;
				
				self.list = function() {
					$http({
						method : 'GET',
						url : 'services/vol/'
					}).then(function successCallback(response) {
						self.vols = response.data;
					}, function errorCallback(response) {

					});
				}; 
				
				
				self.add = function() {
					self.vol={};					
				}; 
				
				
				self.save = function() {
					console.log(self.vol);
					if(self.vol.idVol) {
						$http({
							method : 'PUT',
							url : 'services/vol/' + self.vol.idVol,
							data : self.vol
						}).then(function successCallback(response) {
							self.list();
							self.vol=null;
						}, function errorCallback(response) {
			
						});
					} else {
						$http({
							method : 'POST',
							url : 'services/vol/',
							data : self.vol
						}).then(function successCallback(response) {
							self.list();
							self.vol=null;
						}, function errorCallback(response) {
			
						});
					}
				}; 
				
				
				self.edit = function(idVol) {
					$http({
						method : 'GET',
						url : 'services/vol/' + idVol
					}).then(function successCallback(response) {
						self.vol = response.data;
						self.vol.dateDepart = new Date(self.vol.dateDepart);
						self.vol.dateArrivee = new Date(self.vol.dateArrivee);
//						self.vol.heureDepart = new Date(self.vol.heureDepart);
//						self.vol.heureArrivee = new Date(self.vol.heureArrivee);
					}, function errorCallback(response) {

					});
				}; 
				
				
				self.remove = function(idVol) {
					$http({
						method : 'DELETE',
						url : 'services/vol/' + idVol
					}).then(function successCallback(response) {
						self.list();
					}, function errorCallback(response) {

					});
				}; 
				
				self.list();
			},
			controllerAs: 'volCtrl',
		};
	});
})(); 