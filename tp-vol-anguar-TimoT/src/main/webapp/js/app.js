//closure auto-exécutée
(function() {
	var app = angular.module("agence",["vol", "compagnieAerienne", "aeroport", "vol" ]);
	
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
	
	
	
	
})();