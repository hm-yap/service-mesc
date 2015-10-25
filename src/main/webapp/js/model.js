// Generic Backbone model setup to be used by various components

define([
	'jquery', 
	'Backbone', 
	'underscore'
	], 
	function(
	$,
	Backbone,
	_
	){
		
	var Model = Backbone.Model.extend({});
	return Model;
});
