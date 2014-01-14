$(function() {

	$("#loginForm").submit(

	function(event) {

		event.preventDefault();

		var redirectUrl = "/StrutsForum/secure/Forum/home";

		$(this).redirectingPost("submit.action", redirectUrl, function(data) {
			$("#resultDiv").html(data.message);
		});

	});

});