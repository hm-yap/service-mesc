// Require configuration file

require.config({

	baseUrl:"module",

	//Dependencies
	paths: {
		//Plugins
		jquery: '../bower_components/jquery/dist/jquery.min',
		Backbone: '../bower_components/backbone/backbone-min',
		underscore: '../bower_components/lodash/lodash.min',
		bootstrap: '../bower_components/bootstrap/dist/js/bootstrap.min',
		// handlebars: '../bower_components/require-handlebars-plugin/hbs/handlebars',
		hbs: '../bower_components/require-handlebars-plugin/hbs',
		text: '../bower_components/require/require-text',
		domready: '../bower_components/require/require-domready',
		footable: '../bower_components/footable/js/footable',

		//Backbone model
		Model: '../js/model',

		//Utilities
		Ajax : '../js/ajaxUtility',
		Global : '../js/global',

		//Modules path
		initApp: 'Init/initApp',
		headerPage: 'Header/headerPage',
		dataviewPage: 'Body/Dataview/dataviewPage',
		formPage: 'Body/Form/formPage',
		footerPage: 'Footer/footerPage'
	},

	//Shim
	shim: {
		'jquery': { exports: '$' },
		'underscore': { exports: '_' },
		'Backbone': { deps: ['underscore', 'jquery'], exports: 'Backbone' },
		'bootstrap': { deps: ['jquery'] },
		'footable' : { deps: ['jquery'] }
	},

	//Handlebars 
	hbs: {
		templateExtension : 'html',
		disableHelpers: true
	}
});

//To kick start the application
require([ 'initApp' ], 
	function( initApp ){
	this.initApp = new initApp();
});