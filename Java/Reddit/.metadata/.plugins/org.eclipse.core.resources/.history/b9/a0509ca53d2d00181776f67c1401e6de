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
				<span id="post_up_arrow" postId="${post.id}">&#11165;</span> <br>
				<span id="post_down_arrow" postId="${post.id}">&#11167;</span>
			</td>
			<td>${post.title} <br>
				by: ${post.account} <br>
				&#11165; <span id="post_upVote_label" postId="${post.id}">${post.upVotes}</span>
				| 
				&#11167; <span id="post_downVote_label" postId="${post.id}">${post.downVotes}</span>
				
			
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
	
	<strong id="show_more_comments">Show more comments</strong>
   
 </body>
</html>