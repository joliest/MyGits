<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="ISO-8859-1">
		<jsp:include page="chunks/header.jsp">
			<jsp:param name="theTitle" value="Sign In" />
		</jsp:include>
</head>
<body>
	<div class="container">
		<h2>Sign In</h2>
		<div class="form-group">
			<form method="POST" action="/JobHunter/login">
				<label for="SignInEmailAdd">Email Address:</label>
				<input type="text" class="form-control" id="SignInEmailAdd" name="email">
				<label for="SignInPassword">Password</label>
				<input type="password" class="form-control" id="SignInPassword" name="password">
				<br>
				<button type="submit" class="btn btn-primary btn-lg btn-block">Sign In</button>
			</form>
		</div>	
	</div>
</body>
</html>