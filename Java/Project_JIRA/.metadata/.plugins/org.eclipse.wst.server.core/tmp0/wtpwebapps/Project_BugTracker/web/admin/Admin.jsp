<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Administrator</title>
	</head>
	<body>
		<div id="role">
			<form method="GET" action="/Project_BugTracker/Role.do">
				<table>
					<tr>
						<td>Role ID</td>
						<td><input type="text" name="roleID"></td>
					</tr>
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
	</body>
</html>