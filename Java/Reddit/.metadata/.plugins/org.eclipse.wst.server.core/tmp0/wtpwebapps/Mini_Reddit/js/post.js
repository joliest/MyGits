$(document).ready(function(){
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
})