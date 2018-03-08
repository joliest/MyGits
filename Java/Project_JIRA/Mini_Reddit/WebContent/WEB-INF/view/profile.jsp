<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="miforum-custom-tags" prefix="d"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="js/post.js"></script>
 <title>Profile</title>
</head>
 <body>
 	Hi: ${activeAccount.username}
 	
 	
 	<br />
 	
 	Ask <br />
 	<table>
 		<tr>
 			<td>Subject</td>
 		</tr>
 		<tr>
 			<td><input type="text" id="post_title"></td>
 		</tr>
 		<tr>
 			<td>Details</td>
 		</tr>
 		<tr>
 			<td><textarea rows="2" cols="40" id="post_body"></textarea></td>
 		</tr>
 		<tr>
 			<td></td>
 		</tr>
 		<tr>
 			<td><input type="button" value="Post" id="post_button"/></td>
 		</tr>
 	</table>
 	
 	 <br />
 	 
 	 Posts by ${activeAccount.username} :<br />
 	 <table id="profile_post">
 	 	<d:displayUserPosts currentUser="${activeAccount.username}" numberOfRows="5"/>
 	 </table>
 	
 	<a href="/Mini_Reddit/home"> Home </a>
 	 	
 </body>
</html>