<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Attribute</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="Attribute.js"></script>
	</head>
	<body>
		<div id="displayAttribute">
			<h3>View Attribute</h3>
		</div>
		<div id="createAttribute">
			<h3>Create Attribute</h3>
			<table>
				<tr>
					<td>Group</td>
					<!--  
					<td><select name="selectAttributeGroup"></select></td>
					-->
					<td><input type="text" id="selectAttributeGroup"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" id="attributeName"></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" id="attributeDescription"></td>
				</tr>
				<tr>
					<td>Data type</td>
					<!--  
					<td><select name="selectAttributeType"></td>
					-->
					<td><input type="text" id="selectAttributeType"></td>
				</tr>
				<tr>
					<td>Length</td>
					<td><input type="text" id="attributeLength"></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="button" name="addAttribute" id="addAttribute">Add Attribute</button>
					<button type="button" name="cancelAttribute">Cancel</button></td>
				</tr>
			</table>
		</div>
	</body>
</html>