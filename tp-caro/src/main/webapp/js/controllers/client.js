(function() {
	var app = angular.module("client", []);

	
	app.directive('client', function($http) {
		return {
			restrict: 'E',
			templateUrl: 'client.html',
			controller: function() {
				var self = this;
				
				self.clients = [];
				
				self.client = null;
				
				self.list = function() {
					$http({
						method : 'GET',
						url : 'services/client/'
					}).then(function successCallback(response) {
						self.clients = response.data;
					}, function errorCallback(response) {

					});
//					self.clients = [ {
//						id : 1,
//						civilite : 'Madame',
//						nom : 'DE LANSALUT',
//						prenom : 'Perrine',
//						dtNaissance : Date.now(),
//						email : 'perrine.delansalut@gmail.com',
//						telephone : '0606060606',
//						professionnel : true,
//						adresse : {
//							rue : '1 rue Sainte-Catherine',
//							codePostal : '33000',
//							ville : 'Bordeaux'
//						}
//					}, {
//						id : 2,
//						civilite : 'Monsieur',
//						nom : 'DE LANSALUT',
//						prenom : 'Aymeric',
//						dtNaissance : Date.now(),
//						email : 'aymeric.delansalut@gmail.com',
//						telephone : '0707070707',
//						professionnel : true,
//						adresse : {
//							rue : '1 rue Sainte-Catherine',
//							codePostal : '33000',
//							ville : 'Bordeaux'
//						}
//					} ];
				}; 
				
				
				self.add = function() {
					self.client={};
					
				}; 
				
				
				self.save = function() {
					if(self.client.id) {
						$http({
							method : 'PUT',
							url : 'services/client/' + self.client.id,
							data : self.client
						}).then(function successCallback(response) {
							self.list();
							self.client=null;
						}, function errorCallback(response) {
			
						});
					} else {
						$http({
							method : 'POST',
							url : 'services/client/',
							data : self.client
						}).then(function successCallback(response) {
							self.list();
							self.client=null;
						}, function errorCallback(response) {
			
						});
					}
//					var exist = false;
//					for(var currentClient of self.clients) {
//						if(currentClient.id == self.client.id) {
//							exist=true;
//						} 	
//					}
//					
//					if(!exist) {
//						self.clients.push(self.client);
//					}
//					
//					self.client=null;
				}; 
				
				
				self.edit = function(id) {
					$http({
						method : 'GET',
						url : 'services/client/' + id
					}).then(function successCallback(response) {
						self.client = response.data;
						self.client.dtNaissance = new Date(self.client.dtNaissance);
					}, function errorCallback(response) {

					});
//					for(var currentClient of self.clients) {
//						if(currentClient.id == id) {
//							self.client = currentClient;
//							break;
//						}
//					}
				}; 
				
				
				self.remove = function(id) {
					$http({
						method : 'DELETE',
						url : 'services/client/' + id
					}).then(function successCallback(response) {
						self.list();
					}, function errorCallback(response) {

					});
//					var index = 0;
//					for(var currentClient of self.clients) {
//						if(currentClient.id == id) {
//							break;
//						}
//						index++;
//					}
//					
//					self.clients.splice(index, 1);
				}; 
				
				self.list();
			},
			controllerAs: 'clientCtrl',
		};
	});
	
	
//	app.controller("ClientController", function() {
//		var self = this;
//		
//		self.clients = [];
//		
//		self.client = null;
//		
//		self.list = function() {
//			self.clients = [ {
//				id : 1,
//				civilite : 'Madame',
//				nom : 'DE LANSALUT',
//				prenom : 'Perrine',
//				dtNaissance : Date.now(),
//				email : 'perrine.delansalut@gmail.com',
//				telephone : '0606060606',
//				professionnel : true,
//				adresse : {
//					rue : '1 rue sainte Catherine',
//					codePostal : '33000',
//					ville : 'Bordeaux'
//				}
//			}, {
//				id : 2,
//				civilite : 'Monsieur',
//				nom : 'DE LANSALUT',
//				prenom : 'Aymeric',
//				dtNaissance : Date.now(),
//				email : 'aymeric.delansalut@gmail.com',
//				telephone : '0707070707',
//				professionnel : true,
//				adresse : {
//					rue : '1 rue sainte Catherine',
//					codePostal : '33000',
//					ville : 'Bordeaux'
//				}
//			} ];
//		};
//		
//		self.add = function() {
//			self.client={};
//			
//		}; 
//		
//		self.save = function() {
//			var exist = false;
//			for(var currentClient of self.clients) {
//				if(currentClient.id == self.client.id) {
//					exist=true;
//				} 	
//			}
//			
//			if(!exist) {
//				self.clients.push(self.client);
//			}
//			
//			self.client=null;
//		}; 
//		
//		self.edit = function(id) {
//			
//			for(var currentClient of self.clients) {
//				if(currentClient.id == id) {
//					self.client = currentClient;
//					break;
//				}
//			}
//		
//			
//		}; 
//		
//		self.remove = function(id) {
//			var index = 0;
//			for(var currentClient of self.clients) {
//				if(currentClient.id == id) {
//					break;
//				}
//				index++;
//			}
//			
//			self.clients.splice(index, 1);
//		}; 
//		
//		self.list();
//	});
})(); 