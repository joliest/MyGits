$(document).ready(function(){
	
	var roleController = "/Project_BugTracker/Role.do";
	
	$("#addRole").click(function(){
		$.post(roleController, 
			   {roleName : $("#roleName").val()},
				function(data, status) {
				   $("input#roleName").val("");
					alert(data);
				})			
	});
	
	

	/*
	$("#addRole").click(function() {
		alert($("p#test").text());
	})
	*/
});