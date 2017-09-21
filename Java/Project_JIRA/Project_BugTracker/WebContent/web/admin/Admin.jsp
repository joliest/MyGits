<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<title>Administrator</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="Admin.js"></script>
	</head>
	<body>
		<div id="role">
			<form>
				<table>
					<tr>
						<td>Role Name</td>
						<td><input type="text" id="roleName"></td>
					</tr>
					<tr>
						<td></td>
						<td><button id="addRole" type="button">Add Role</button></td>
					</tr>
				</table>
			</form>		
		</div>		
		<div id="user">
			<form>
				<table>
					<tr>
						<td>Role</td>
						<td>
							<select id="role" type="text">
								
							</select>															
						</td>
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
						<td><input id="addUser" type="button" value="Add User"></td>
					</tr>
				</table>
			</form>
		</div>	
		
		
	</body>
</html>