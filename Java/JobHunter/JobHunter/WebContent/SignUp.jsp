<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="ISO-8859-1">
		
		<jsp:include page="chunks/header.jsp">
			<jsp:param name="theTitle" value="Sign Up" />
		</jsp:include>
	</head>
<body>
	<div class="container">
		<h2>Create an account</h2>
		<div class="form-group">
			<form method="POST" action="/JobHunter/SignUp">
				<label for="SignUpEmailAdd">Email Address:</label>
				<input type="text" class="form-control" id="SignUpEmailAdd" name="email">
				<label for="SignUpPassword">Password</label>
				<input type="password" class="form-control" id="SignUpPassword" name="password">
				<label for="SignUpConfirmPassword">Confirm Password</label>
				<input type="password" class="form-control" id="SignUpConfirmPassword">
				<br>
				<div class="pull-right">
					<button type="submit" class="btn btn-default">Sign Up</button>
					<button type="button" class="btn btn-default">Cancel</button>
				</div>
			</form>
		</div>	
	</div>
</body>
</html>