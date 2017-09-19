(function(){
	'use strict';
	
	angular.module("landpageapp", []);

	angular.module("landpageapp").controller("interessadosCtrl", interessadosCtrl);

	interessadosCtrl.$inject = [ 'interessadosAPI' ];

	function interessadosCtrl(interessadosAPI) {

		var vm = this;
		vm.interessadosList = [];
		vm.save = salvar;

		function buscarInteressados(){
			interessadosAPI.buscarInteressados().then(function(result) {
				vm.interessadosList = result.data;
			});
		};

		function salvar(interessado){
			interessadosAPI.salvarInteressado(interessado).then(function (data) {
				console.log('Interessado gravado com sucesso!');
				buscarInteressados();
			}, function (erro) { console.log(erro); });
		};

		function init() {
			console.log('Init interessados ctrl...');
			buscarInteressados();
		};

		init();
	};

	angular.module("landpageapp").factory("interessadosAPI", function ($http) {

		var _urlService = "http://localhost:8080/landpage/rest/interessados";

		var _buscarInteressados = function () {
			return $http.get(_urlService);
		};

		var _salvarInteressado = function (interessado) {
			return $http.post(_urlService, interessado);
		};

		return {
			buscarInteressados: _buscarInteressados,
			salvarInteressado: _salvarInteressado
		};
	});

})();