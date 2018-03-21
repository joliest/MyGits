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
					showPostComments();
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
	
	//upvoting
	$(this).on("click", "#comment_up_arrow", function() {
		var controller = "/Mini_Reddit/commentController";
		var commentId = $(this).attr("commentId");
		$.post(controller,
				   { 
						functionality : "comment_up_arrow",
						commentId : commentId
				   },
				   function(data, status){
					   //updates upvote label
					   $("#comment_upVote_label[commentId='" + commentId +"']").html(data);
				   })
	})
	
	//downvoting
	$(this).on("click", "#comment_down_arrow", function() {
		var controller = "/Mini_Reddit/commentController";
		var commentId = $(this).attr("commentId");
		$.post(controller,
				   { 
						functionality : "comment_down_arrow",
						commentId : commentId
				   },
				   function(data, status){
					 //updates downvote label
					   $("#comment_downVote_label[commentId='" + commentId +"']").html(data);
				   })
	})
})