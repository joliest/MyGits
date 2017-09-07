<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administrator</title>
	</head>
	<body>
		<div id="role">
			<form method="GET" action="/Project_BugTracker/Role.do" target="_BLANK">
				<table>
					<tr>
						<td>Role Name</td>
						<td><input type="text" name="roleName"></td>
					</tr>
					<tr>
						<td><button type="submit">Add Role</button></td>
					</tr>
				</table>
			</form>		
		</div>		
		<div id="user">
			<form method="POST" action="/Project_BugTracker/User.do">
				<table>
					<tr>
						<td>Role</td>
						<td><input type="text" name="role"></td>
					</tr>
					<tr>
						<td>Username </td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password </td>
						<td><input type="text" name="password"></td>
					</tr>
					<tr>
						<td>Confirm Password </td>
						<td><input type="text" name="cPassword"></td>
					</tr>
					<tr>
						<td>First Name</td>
						<td><input type="text" name="firstName"></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lastName"></td>
					</tr>
					<tr>
						<td>Mobile Number</td>
						<td><input type="text" name="mobileNumber"></td>
					</tr>
					<tr>
						<td>Email Address</td>
						<td><input type="text" name="emailAddress"></td>
					</tr>
					<tr>
						<td>
						</td>
						<td><input type="submit" value="Add User"></td>
					</tr>
				</table>
			</form>
		</div>	
		
	</body>
</html>