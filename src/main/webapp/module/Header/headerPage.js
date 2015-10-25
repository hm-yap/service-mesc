// Header page module

define([
		'jquery',
		'underscore',
		'Backbone',
		'Ajax',
		'Global',

		//HTML template loaded with hbs
		'hbs!Header/header',
		'dataviewPage',
		'formPage',
		'footerPage',
		'bootstrap'
	],
	function(
		$,
		_,
		Backbone,
		Ajax,
		Global,
		headerPage,
		dataviewPage,
		formPage,
		footerPage
	){

	//Components to refer to in functions
	var	body = '.app-body',
		formView = '.formview-block',
		dataView = '.dataview-block',
		settingsView = '.settings-block',

		//Navigation buttons
		dataviewBtn = 'ul.nav>li>a.data',
		formBtn = 'ul.nav>li>a.form',
		settingsBtn = 'ul.nav>li>a.settings';


	var Header = Backbone.View.extend({
		//Define main container
		el: '.app-header',

		//Button events
		events: {
			"click ul.nav>li>a.data": "openData",
			"click ul.nav>li>a.form": "openForm",
			"click ul.nav>li>a.settings": "openSettings"
		},

		//Initialize backbone view for headerpage
		initialize: function(){
			this.headerPage = headerPage;
			this.dataviewPage = dataviewPage;
			this.formPage = formPage;
			this.headerPage = '';

			this.menuData = Ajax.getData({
				dataType: 'json',
				url: Global.navigationBar
			});
		},

		//Render header template
		render: function(){
			//Define this in another variable for usage in other context
			var self = this;

			(this.menuData).success(function(data){
			
				//Adding class key to the obj
				$.each(data.navigation, function(){
					this['class'] = this['name'].toLowerCase();
				});

				this.headerPage = headerPage(data);
				self.$el.append(this.headerPage);
			});
		},

		/***********************************************************/
		/* 						EVENTS FUNCTION 					*/
		/***********************************************************/

		openData: function(){
			$(dataView).show();
			$(formView).hide();
			$(settingsView).hide();
			$(dataviewBtn).addClass('active');
			$(formBtn).removeClass('active');
			$(settingsBtn).removeClass('active');

			//Call to reload new data in dataview page *temporary method only*
			this.dataviewPage.reloadTable();

			//Collapse back the menu dropdown
			$('.navbar-toggle').addClass('collapsed').attr('aria-expanded', false);
			$('#navbar').removeClass('in').attr('aria-expanded', false);
		},

		openForm: function(){
			$(dataView).hide();
			$(formView).show();
			$(settingsView).hide();
			$(dataviewBtn).removeClass('active');
			$(formBtn).addClass('active');
			$(settingsBtn).removeClass('active');

			//Collapse back the menu dropdown
			$('.navbar-toggle').addClass('collapsed').attr('aria-expanded', false);
			$('#navbar').removeClass('in').attr('aria-expanded', false);
		},

		openSettings: function(){
			$(dataView).hide();
			$(formView).hide();
			$(settingsView).show();
			$(dataviewBtn).removeClass('active');
			$(formBtn).removeClass('active');
			$(settingsBtn).addClass('active');

			//Collapse back the menu dropdown
			$('.navbar-toggle').addClass('collapsed').attr('aria-expanded', false);
			$('#navbar').removeClass('in').attr('aria-expanded', false);
		}
	});

	return new Header();
});