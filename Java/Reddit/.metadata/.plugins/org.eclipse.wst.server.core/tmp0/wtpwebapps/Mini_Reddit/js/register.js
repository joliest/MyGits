$(document).ready(function(){
	$("form").submit(function(){
		
		var username = $("#register_username").val();
		var password = $("#register_password").val();
		var confirmPassword = $("#register_confirm_password").val();
		
		if(passwordMatched(password, confirmPassword)) {
			return true;
		} else {
			alert("Password didn't match");
			return false;
		}
	})	
})

function passwordMatched(password, confirm) {
		if(password == confirm) {
			return true;
		} else {
			return false;
		}
	}