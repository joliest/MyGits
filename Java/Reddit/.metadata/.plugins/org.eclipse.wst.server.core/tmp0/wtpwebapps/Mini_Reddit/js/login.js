$(document).ready(function(){
	$("form").submit(function(){
		var username = $("#login_username").val();
		var password = $("#login_password").val();
		
		if(username == "") {
			alert("Username is blank");
			return false;
		} else if(password == "") {
			alert("Password is blank");
			return false;
		} else if(password == "" && username == "") {
			alert("Login details are blank");
			return false;
		} else {
			return true;
		}
			
	})
})

