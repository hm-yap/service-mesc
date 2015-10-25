// Settings page module

define([
		'jquery',
		'underscore',
		'Backbone',
		'Model',
		'Ajax',

		//HTML template loaded with hbs
		'hbs!Body/Settings/settings',
		'bootstrap'
	],
	function(
		$,
		_,
		Backbone,
		Model,
		Ajax,
		settings
	){

	var Settings = Backbone.View.extend({
		
		//Define main container
		el: '.settings-block',

		events: {},

		//Initialize backbone view for settings
		initialize: function(){

		},

		//Render settings template
		render: function(){

		}

		/***********************************************************/
		/* 						EVENTS FUNCTION 					*/
		/***********************************************************/
	});

	return new Settings();
});