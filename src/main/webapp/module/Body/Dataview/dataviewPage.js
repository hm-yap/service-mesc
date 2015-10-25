// Dataview page module

define([
		'jquery',
		'underscore',
		'Backbone',
		'Model',
		'Ajax',
		'Global',
		'footable',

		//HTML template loaded with hbs
		'hbs!Body/Dataview/dataview',
		'bootstrap'
	],
	function(
		$,
		_,
		Backbone,
		Model,
		Ajax,
		Global,
		footable,
		dataview
	){

	var DataView = Backbone.View.extend({
		
		//Define main container
		el: '.dataview-block',

		events: {},

		//Initialize backbone view for dataview
		initialize: function(){
			this.dataview = dataview;
			this.dataTable = Ajax.getData({
				dataType: 'json',
				url: Global.tableContent
			});
		},

		//Render dataview template
		render: function(display){
			//Defining this for use on other context
			var self = this;
			console.log('Rendering table here!');

			(this.dataTable).success(function(data){
				this.dataview = dataview;
				self.$el.append(this.dataview);
				self.createTable(data);
			});

			this.$el.css('display', display);
		},

		createTable: function(data){
			localStorage.setItem('tableData', JSON.stringify(data));

			//Set table to be generated using localstorage data. Newer data will be loaded through length checking between old and new data
			if (localStorage.tableData && ((JSON.parse(localStorage.tableData)).rows.length > (JSON.parse(localStorage.oldTableData)).rows.length)){
				$('.data-table').footable(JSON.parse(localStorage.tableData));
			}
			else {
				$('.data-table').footable(data);
			}

			//$('.data-table').footable(data);
			//console.log(JSON.parse(localStorage.tableData));
		},

		reloadTable: function(){
			//Temporary method only
			$('.data-table').remove();
			this.dataview = dataview;
			this.$el.append(this.dataview);

			//Reload table using newer data, or old data, depending on the data length
			if (localStorage.oldTableData && ((JSON.parse(localStorage.tableData)).rows.length > (JSON.parse(localStorage.oldTableData)).rows.length)){
				$('.data-table').footable(JSON.parse(localStorage.tableData));
			}
			else {
				$('.data-table').footable(JSON.parse(localStorage.oldTableData));
			}
		}

		/***********************************************************/
		/* 						EVENTS FUNCTION 					*/
		/***********************************************************/
	});

	return new DataView();
});