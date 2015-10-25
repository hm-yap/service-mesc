// Main page module

define([
		'jquery',
		'Backbone',
		'underscore',
		'headerPage',
		'dataviewPage',
		'formPage',
		'footerPage'
	],
	function(
		$,
		Backbone,
		_,
		headerPage,
		dataviewPage,
		formPage,
		footerPage
	){

	var Router = Backbone.Router.extend({
		//Initialize Backbone router function
		initialize: function(){
			this.headerPage = headerPage;
			this.dataviewPage = dataviewPage;
			this.formPage = formPage;
			Backbone.history.start();
		},

		//URL routing controller
		routes: {
			'' : 'home'
		},

		'home' : function(){
			this.headerPage.render();
			this.dataviewPage.render('block');
			this.formPage.render('none');
		}

	});

	return Router;
});