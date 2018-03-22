$(document).ready(function(){
	$("#register_button").click(function(){
		
		var controller = "/Mini_Reddit/register";
		var username = $("#register_username").val();
		var password = $("#register_password").val();
		var confirmPassword = $("#register_confirm_password").val();
		
		if(passwordMatched(password, confirmPassword)) {

				$.post(controller,
						{ username : username, password : password },
						function(data, status){
		
						}) 
		} else {
			alert("Password didn't match");
		}
	})
	
	function passwordMatched(password, confirm) {
		if(password == confirm) {
			return true;
		} else {
			return false;
		}
	}
})