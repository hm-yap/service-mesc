//Ajax utility for fetching and returning data from backend

define([
		'jquery',
		'underscore'
	], 
	function(
		$,
		_
	){

	var ajax = {

		getData: function(params, target){

			//Call on setLoader to set load animation
			target ? setLoader(target) : '';

			//Main function to retrieve data from the backend
			return $.ajax({
				dataType: params.dataType,
				url: 'data/' + params.url,
			});
		},

		setLoader: function(target){
			//Create loading animation
			$(target).before('<div class="load-overlay"></div>');
		},

		removeLoader: function(target){
			//Remove loading animation
			$('.load-overlay').remove();
		}
		
	};

	return ajax;
});