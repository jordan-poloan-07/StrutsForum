$(function() {

	$("#addTopicDialog").delegate(
			"#addTopicForm",
			"submit",
			function(event) {

				event.preventDefault();

				var redirectUrl = window.location.toString();

				var topicCategoryId = $("#topicCat").val();

				var targetUrl = "/StrutsForum/secure/topicModifier/addTopic/"
						+ topicCategoryId;

				$(this).redirectingPost(targetUrl, redirectUrl, function(data) {
					alert(data.message);
				});
			});

	$("#editTopicDialog").delegate("#editTopicForm", "submit", function(event) {

		event.preventDefault();

		var redirectUrl = window.location.toString();

		var topicId = $("#topicId").val();

		var targetUrl = "/StrutsForum/secure/topicModifier/edit/" + topicId;

		$(this).redirectingPost(targetUrl, redirectUrl, function(data) {
			alert(data.message);
		});
	});

	$("#deleteTopicDialog").delegate("#deleteTopicForm", "submit", function(event) {

		event.preventDefault();
		
		var redirectUrl = window.location.toString();

		var topicId = $("#topicId").val();
		
		// i wanted to know what input submit button was pressed
		// i tried event.target but then it returns the #deleteTopicForm form, since
		// it initiated submission after a submit was clicked
		// event.originalEvent.explicitOriginalTarget.id was used to get the id of submit button clicked
		
		var submitButtonClicked = event.originalEvent.explicitOriginalTarget.id;
		var noBtn = $("#noBtn").attr("id");
		
		// it is compared to noBtn, because if #noBtn was clicked, this method shall return
				
		if( submitButtonClicked === noBtn ){
			$("#deleteTopicDialog").dialog('close');
			return;
		}
		
		var targetUrl = "/StrutsForum/secure/topicModifier/delete/" + topicId;

		$(this).redirectingPost(targetUrl, redirectUrl, function(data) {
			alert(data.message);	
		});
	});
});
