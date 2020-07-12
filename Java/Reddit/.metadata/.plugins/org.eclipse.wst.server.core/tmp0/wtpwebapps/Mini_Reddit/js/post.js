$(document).ready(function(){
	
	//displayRecentPosts();
	
	$("#home_next_post").click(function(){
		displayRecentPosts();
	})
	
	$("#home_previous_post").click(function(){
		displayPreviousPosts();
	})
	
	 displayRecentPosts();
	 
	//adds new post
	$("#post_button").click(function(){
		
		var controller = "/Mini_Reddit/post";
		var functionality = "add_post";
		var title = $("#post_title").val();
		var body = $("#post_body").val();
		
		$.post(controller,
			   { 
					functionality : functionality, 
					"post_title" : title, 
					"post_body" : body
			   },
			   function(data, status){})
	})
	
	//next posts
	function displayRecentPosts() {
		$.post("/Mini_Reddit/post",
				   { 
						functionality : "display_recent_posts"
				   },
				   function(data, status){
					   $("#home_recent_posts").html(data)
				   })
	}
	
	//previous posts
	function displayPreviousPosts() {
		$.post("/Mini_Reddit/post",
				   { 
						functionality : "display_previous_posts"
				   },
				   function(data, status){
					   $("#home_recent_posts").html(data)
				   })
	}
	
	//upvoting
	$(this).on("click", "#post_up_arrow", function() {
		var controller = "/Mini_Reddit/post";
		var postId = $(this).attr("postId");
		$.post(controller,
				   { 
						functionality : "post_up_arrow",
						postId : postId
				   },
				   function(data, status){
					   //updates upvote label
					   $("#post_upVote_label[postId='" + postId +"']").html(data);
				   })
	})
	
	//downvoting
	$(this).on("click", "#post_down_arrow", function() {
		var controller = "/Mini_Reddit/post";
		var postId = $(this).attr("postId");
		$.post(controller,
				   { 
						functionality : "post_down_arrow",
						postId : postId
				   },
				   function(data, status){
					 //updates downvote label
					   $("#post_downVote_label[postId='" + postId +"']").html(data);
				   })
	})
	
	
	
})


