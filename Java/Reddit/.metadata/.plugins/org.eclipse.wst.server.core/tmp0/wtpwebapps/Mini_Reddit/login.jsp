<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <!-- <script src="js/login.js"></script>   -->
  <title>Log In</title>
 </head>
 <body>
 <form method="POST" action="/Mini_Reddit/login">
 
 
  	Username: <input type="text" id="login_username" name="login_username"/> <br />
  	Password: <input type="password" id="login_password" name="login_password" /> <br />
  	<input type="submit" value="Sign in" /> |
  	
  	<a href="/Mini_Reddit/register.jsp">register</a>
  </form>
 </body>
</html>