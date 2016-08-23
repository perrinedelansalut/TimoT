(function() {
	var app = angular.module("agence", []);
	
	app.directive('agence', function($http) {
		return {
			restrict: 'E',
			templateUrl: 'agence.html',
			controller: function() {
				var self = this;
				
				self.agences = [];
				
				self.mode=null;
				
				self.agence = null;
				
				self.list = function() {
					$http({
						method : 'GET',
						url : 'services/agence/'
					}).then(function successCallback(response) {
						self.agences = response.data;
					}, function errorCallback(response) {

					});
//					self.agences = [ {
//						numBanque : 25,
//						numAgence : 253301,
//						libelle : 'La Banque Postale',
//						horaires : '9h - 12h | 14h - 19h',
//						adresse : {
//							rue : '1 avenue de l\'Yser',
//							codePostal : '33700',
//							ville : 'Merignac'
//						}
//					}, {
//						numBanque : 16,
//						numAgence : 163301,
//						libelle : 'LCL',
//						horaires : '9h - 12h | 14h - 19h',
//						adresse : {
//							rue : '7 place Charles de Gaulles',
//							codePostal : '33700',
//							ville : 'Merignac'
//						}
//					} ];
				};
				
				
				self.add = function() {
					self.agence={};
					self.mode="add";
					
				}; 
				
				
				self.save = function() {
					if(self.mode=="edit") {
						$http({
							method : 'PUT',
							url : 'services/agence/' + self.agence.numBanque +"&"+ self.agence.numAgence,
							data : self.agence
						}).then(function successCallback(response) {
							self.list();
							self.agence=null;
						}, function errorCallback(response) {
			
						});
					} else {
						$http({
							method : 'POST',
							url : 'services/agence/',
							data : self.agence
						}).then(function successCallback(response) {
							self.list();
							self.agence=null;
						}, function errorCallback(response) {
			
						});
					}
					self.mode=null;
					
//					var exist = false;
//					for(var currentAgence of self.agences) {
//						if(currentAgence.numBanque == self.agence.numBanque && currentAgence.numAgence == self.agence.numAgence) {
//							exist=true;
//						} 	
//					}
//					
//					if(!exist) {
//						self.agences.push(self.agence);
//					}
//					
//					self.agence=null;
				}; 
				
				
				self.edit = function(numBanque, numAgence) {
					$http({
						method : 'GET',
						url : 'services/agence/' + numBanque +"&"+ numAgence
					}).then(function successCallback(response) {
						self.agence = response.data;
						self.mode="edit";
					}, function errorCallback(response) {

					});
//					for(var currentAgence of self.agences) {
//						if(currentAgence.numBanque == numBanque && currentAgence.numAgence == numAgence) {
//							self.agence = currentAgence;
//							break;
//						}
//					}
				}; 
				
				
				self.remove = function(numBanque, numAgence) {
					$http({
						method : 'DELETE',
						url : 'services/agence/' + numBanque +"&"+ numAgence
					}).then(function successCallback(response) {
						self.list();
					}, function errorCallback(response) {

					});
//					var index = 0;
//					for(var currentAgence of self.agences) {
//						if(currentAgence.numBanque == numBanque && currentAgence.numAgence == numAgence) {
//							break;
//						}
//						index++;
//					}
//					
//					self.agences.splice(index, 1);
				}; 
				
				
				self.list();
			},
			controllerAs: 'agenceCtrl'
		};
	});

//	app.controller("AgenceController", function() {
//		var self = this;
//		
//		self.agences = [];
//		
//		self.agence = null;
//		
//		self.list = function() {
//			self.agences = [ {
//				numBanque : 25,
//				numAgence : 253301,
//				libelle : 'La Banque Postale',
//				horaires : '9h - 12h | 14h - 19h',
//				adresse : {
//					rue : '1 avenue de l\'Yser',
//					codePostal : '33700',
//					ville : 'Merignac'
//				}
//			}, {
//				numBanque : 16,
//				numAgence : 163301,
//				libelle : 'LCL',
//				horaires : '9h - 12h | 14h - 19h',
//				adresse : {
//					rue : '7 place Charles de Gaulles',
//					codePostal : '33700',
//					ville : 'Merignac'
//				}
//			} ];
//		};
//		
//		self.add = function() {
//			self.agence={};
//			
//		}; 
//		
//		self.save = function() {
//			var exist = false;
//			for(var currentAgence of self.agences) {
//				if(currentAgence.numBanque == self.agence.numBanque && currentAgence.numAgence == self.agence.numAgence) {
//					exist=true;
//				} 	
//			}
//			
//			if(!exist) {
//				self.agences.push(self.agence);
//			}
//			
//			self.agence=null;
//		}; 
//		
//		self.edit = function(numBanque, numAgence) {
//			
//			for(var currentAgence of self.agences) {
//				if(currentAgence.numBanque == numBanque && currentAgence.numAgence == numAgence) {
//					self.agence = currentAgence;
//					break;
//				}
//			}
//		
//			
//		}; 
//		
//		self.remove = function(numBanque, numAgence) {
//			var index = 0;
//			for(var currentAgence of self.agences) {
//				if(currentAgence.numBanque == numBanque && currentAgence.numAgence == numAgence) {
//					break;
//				}
//				index++;
//			}
//			
//			self.agences.splice(index, 1);
//		}; 
//		
//		self.list();
//	});
})(); 