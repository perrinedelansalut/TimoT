//closure auto-exécutée
(function() {
	var app = angular.module("banque",["client", "agence"]);
	
	app.controller("PanelController", function() {
		var self=this;
		self.tab=null;
		
		self.titre = 'Gestion';
		
		self.setTab = function(currentTab, titre) {
			self.tab = currentTab;
			self.titre = titre;
		};
		
		self.isSet = function(currentTab) {
			return self.tab == currentTab;
		};
	});
	
	
//	app.directive('client', function() {
//		return {
//			restrict: 'E',
//			templateUrl: 'client.html'
//		}
//	});
	
	
//	app.directive('agence', function() {
//		return {
//			restrict: 'E',
//			templateUrl: 'agence.html'
//		}
//	});
	
	
})();