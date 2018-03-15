$(document).ready(function(){
	
	displayRecentPosts();
			   
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
	
	$("#home_next_post").click(function(){
		displayRecentPosts();
	})
	
	$("#home_previous_post").click(function(){
		displayPreviousPosts();
	})
	
	function displayRecentPosts() {
		$.post("/Mini_Reddit/post",
				   { 
						functionality : "display_recent_posts"
				   },
				   function(data, status){
					   $("#home_recent_posts").html(data)
				   })
	}
	
	function displayPreviousPosts() {
		$.post("/Mini_Reddit/post",
				   { 
						functionality : "display_previous_posts"
				   },
				   function(data, status){
					   $("#home_recent_posts").html(data)
				   })
	}
})


