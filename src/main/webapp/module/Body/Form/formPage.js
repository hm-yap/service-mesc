// Header page module

define([
		'jquery',
		'underscore',
		'Backbone',
		'Model',
		'Ajax',
		'Global',

		//HTML template loaded with hbs
		'hbs!Body/Form/form',
		'dataviewPage',
		'bootstrap'
	],
	function(
		$,
		_,
		Backbone,
		Model,
		Ajax,
		Global,
		formpage,
		dataviewPage
	){

	var FormPage = Backbone.View.extend({
		//Define main container
		el: '.formview-block',

		events: {
			"click #form-submit" : "submitForm",
			"click #form-clear" : "clearForm"
		},

		//Initialize backbone view for form
		initialize: function(){
			this.dataviewPage = dataviewPage;
			this.dataTable = Ajax.getData({
				dataType: 'json',
				url: Global.tableContent
			});
		},

		//Render form template
		render: function(display){
			//Define this to be used in other context
			var self = this;

			(this.dataTable).success(function(data){
				this.formpage = formpage(data);
				self.$el.append(this.formpage);
			});

			this.$el.css('display', display);
		},


		/***********************************************************/
		/* 						EVENTS FUNCTION 					*/
		/***********************************************************/

		submitForm: function(){
			console.log('Submitting form now!');
			var formData = {};
			$('.form-group').each(function(){
				formData[$(this).find('input').attr('id')] = $(this).find('input').val();
			});

			//Mechanism to test save value in localstorage
			var tableData = JSON.parse(localStorage.tableData);
			tableData.rows.push(formData);
			localStorage.setItem('oldTableData', localStorage.tableData);
			localStorage.setItem('tableData', JSON.stringify(tableData));

			//Reroute back form to table page after successful submission *temporary method*
			$('.formview-block').hide();
			$('.dataview-block').show();
			this.dataviewPage.reloadTable();
		},

		clearForm: function(){
			$('.form-group').each(function(){
				$(this).find('input').val('');
			});
		}
	});

	return new FormPage();
});