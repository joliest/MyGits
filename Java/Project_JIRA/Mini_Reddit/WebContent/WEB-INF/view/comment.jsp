<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.miforum.components.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="js/post.js"></script>
 <script src="js/comment.js"></script>
<title>Comments : ${post.title}</title>
</head>
 <body>
  <table border="1">
		<tr>
			<td rowspan="2">
				&#11165; <br>
				&#11167;
			</td>
			<td>${post.title} <br>
				by: ${post.account} <br>
				&#11165; ${post.upVotes} | &#11167; ${post.downVotes}
			
			</td>
		</tr>
		<tr>
			<td>${post.body}</td>
		</tr>
	</table>
	
	Add Comments:
	
	<table border="1">
		<tr>
			<td><input type="text" id="new_comment" name="new_comment" /></td>
		</tr>
		<tr>
			<td><input type="button" id="add_comment" value="Add Comment" /></td>
		</tr>
	</table>
	
	Comments:
	
	<table id="post_recent_comments" border="1">
   
   </table>
	
	<input type="button" value="&lt;" id="home_previous_post" />
   <input type="button" value="&gt;" id="home_next_post" />
   
 </body>
</html>