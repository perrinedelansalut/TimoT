//closure auto-exécutée
(function() {
	var app = angular.module("agence",["vol", "compagnieAerienne", "aeroport", "ville" ]);
	
	app.controller("PanelController", function() {
		var self=this;
		self.tab=null;
		
//		self.titre = 'Gestion';
		
		self.setTab = function(currentTab) {
			self.tab = currentTab;
//			self.titre = titre;
		};
		
		self.isSet = function(currentTab) {
			return self.tab == currentTab;
		};
	});
	
	
	
	
})();