// Footer page module

define([
		//Basic module utilities
		'jquery',
		'underscore',
		'Backbone',
		'Model',
		'Ajax',
		'Global',

		//HTML template loaded with hbs
		'hbs!Footer/footer',
		'bootstrap'
	],
	function(
		$,
		_,
		Backbone,
		Model,
		Ajax,
		Global,
		footer
	){

	var Footer = Backbone.View.extend({
		
		//Define main container
		el: '.app-footer',

		events: {},

		//Initialize backbone view for footer
		initialize: function(){

		},

		//Render footer template
		render: function(){

		}

		/***********************************************************/
		/* 						EVENTS FUNCTION 					*/
		/***********************************************************/
	});

	return new Footer();
});