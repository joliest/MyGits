<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<title>Attribute Page</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="js/Attribute.js"></script>
	</head>
	<body>
		<div id="AttributeListBox">
			<ul id="RoleList">
				<li>Value 1</li>
			</ul>
			
		</div>
		
		<div id="AttributeGroupTextFieldBox">
			<table>
				<tr>
					<td>Group Name</td>
					<td><input type="text" id="attribGroupName"></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="button" id="addAttributeGroup">Add Attribute Group</button>
						<button type="button" id="cancel">Cancel</button></td>
				</tr>
			</table>
		</div>
		
		<div id="AttributeTextFieldBox">
			<table>
				<tr>
					<td>Group</td>
					<td><input type="text" id="attribGroup"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" id="attribName"></td>
				</tr>
				<tr>
					<td>Data Type</td>
					<td><input type="text" id="attribDataType"></td>
				</tr>
				<tr>
					<td>Length</td>
					<td><input type="text" id="attribLength"></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="button" id="addAttribute">Add Attribute</button>
						<input type="button" value="Cancel">
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>