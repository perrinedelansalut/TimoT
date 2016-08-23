(function() {
	var app = angular.module("ville", []);

	
	app.directive('ville', function($http) {
		return {
			restrict: 'E',
			templateUrl: 'ville.html',
			controller: function() {
				var self = this;
				
				self.villes = [];
				
				self.ville = null;
				
				self.list = function() {
					$http({
						method : 'GET',
						url : 'services/ville/'
					}).then(function successCallback(response) {
						self.villes = response.data;
					}, function errorCallback(response) {

					});
//					self.villes = [ {
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
					self.ville={};
					
				}; 
				
				
				self.save = function() {
					if(self.ville.idVil) {
						$http({
							method : 'PUT',
							url : 'services/ville/' + self.ville.idVil,
							data : self.ville
						}).then(function successCallback(response) {
							self.list();
							self.ville=null;
						}, function errorCallback(response) {
			
						});
					} else {
						$http({
							method : 'POST',
							url : 'services/ville/',
							data : self.ville
						}).then(function successCallback(response) {
							self.list();
							self.ville=null;
						}, function errorCallback(response) {
			
						});
					}
//					var exist = false;
//					for(var currentClient of self.villes) {
//						if(currentClient.id == self.ville.id) {
//							exist=true;
//						} 	
//					}
//					
//					if(!exist) {
//						self.villes.push(self.ville);
//					}
//					
//					self.ville=null;
				}; 
				
				
				self.edit = function(id) {
					$http({
						method : 'GET',
						url : 'services/ville/' + idVil
					}).then(function successCallback(response) {
						self.ville = response.data;
					}, function errorCallback(response) {

					});
//					for(var currentClient of self.villes) {
//						if(currentClient.id == id) {
//							self.ville = currentClient;
//							break;
//						}
//					}
				}; 
				
				
				self.remove = function(idVil) {
					$http({
						method : 'DELETE',
						url : 'services/ville/' + idVil
					}).then(function successCallback(response) {
						self.list();
					}, function errorCallback(response) {

					});
//					var index = 0;
//					for(var currentClient of self.villes) {
//						if(currentClient.id == id) {
//							break;
//						}
//						index++;
//					}
//					
//					self.villes.splice(index, 1);
				}; 
				
				self.list();
			},
			controllerAs: 'villeCtrl',
		};
	});
	
	
//	app.controller("ClientController", function() {
//		var self = this;
//		
//		self.villes = [];
//		
//		self.ville = null;
//		
//		self.list = function() {
//			self.villes = [ {
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
//			self.ville={};
//			
//		}; 
//		
//		self.save = function() {
//			var exist = false;
//			for(var currentClient of self.villes) {
//				if(currentClient.id == self.ville.id) {
//					exist=true;
//				} 	
//			}
//			
//			if(!exist) {
//				self.villes.push(self.ville);
//			}
//			
//			self.ville=null;
//		}; 
//		
//		self.edit = function(id) {
//			
//			for(var currentClient of self.villes) {
//				if(currentClient.id == id) {
//					self.ville = currentClient;
//					break;
//				}
//			}
//		
//			
//		}; 
//		
//		self.remove = function(id) {
//			var index = 0;
//			for(var currentClient of self.villes) {
//				if(currentClient.id == id) {
//					break;
//				}
//				index++;
//			}
//			
//			self.villes.splice(index, 1);
//		}; 
//		
//		self.list();
//	});
})(); 