

$(document).ready(function(){
	
	var roleController = "/Project_BugTracker/Role.do";
	var adminController = "/Project_BugTracker/Admin.do";
	
	//load Role select
	$.get(adminController, function(data, status){
		$("select#role").html(data);
	})
	
	
	
	//add role
	$("#addRole").click(function(){
		$.post(roleController, 
			   {roleName : $("#roleName").val()},
				function(data, status) {
				   //erase data in add role name textbox
				   $("input#roleName").val("");
					alert(data);
				})			
	});
	
	
	
	
	/*
	
	$("select#role").click(function() {
		$.get(adminController, function(data, status){
			$("select#role").html(data);
		})
	});
	
	*/
	

	/*
	$("#addRole").click(function() {
		alert($("p#test").text());
	})
	*/
});