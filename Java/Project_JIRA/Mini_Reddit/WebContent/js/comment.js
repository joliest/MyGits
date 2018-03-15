$(document).ready(function(){
	
	showPostComments();
	
	$("#add_comment").click(function() {
		
		var controller = "/Mini_Reddit/commentController";
		var functionality = "add_comment";
		var comment = $("#new_comment").val();
		var username = $("td#commentator").val();
		
		$.post(controller,
				{
					functionality : functionality,
					comment : comment,
					username : username
				}, function(data, status) {
					
				});
	});
	
	function showPostComments() {
		
		var controller = "/Mini_Reddit/commentController";
		var functionality = "show_post_comments";
		
		$.post(controller,
				{
					functionality : functionality
				}, 
				function(data, status) {
					$("#post_recent_comments").html(data);
				});
	}
})