/**
 * 
 */
$(function() {
	// reusable function
	// arguments are string string method
	$.fn.redirectingPost = function(postTarget, redirectTarget, failMethod) {
		// this.serialize() is also equal to $(this).serialize()
		$.post(postTarget, this.serialize(), function(data) {
			if (data.successful == true) {
				window.location = redirectTarget;
			} else {
				failMethod(data);
			}
		}, "json");
	};
});
