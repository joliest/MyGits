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
			<ul id="attributeGroupList">
				<li>Value 1
					<ul> 
						<li> sub value 1</li>
						<li> sub value 2</li>
					</ul>
				</li>
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
					<td><button type="button" id="addAttributeGroup">Add</button>
					<button type="button" id="deleteAttributeGroup">Delete</button>
					<button type="button" id="editAttributeGroup">Save Changes</button>
						<button type="button" id="cancel">Cancel</button></td>
				</tr>
			</table>
		</div>
		
		<div id="AttributeTextFieldBox">
			<table>
				<tr>
					<td>Group</td>
					<td>
						<select id="selectAttributeGroup">
							
						</select>						
					</td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" id="attribName"></td>
				</tr>
				<tr>
					<td>Data Type</td>
					<td>
						<select id="attribDataType">
							<option attribDataTypeId="0" >Alpha</option>
							<option attribDataTypeId="1" >AlphaNumeric</option>
							<option attribDataTypeId="2" >Numeric</option>
							<option attribDataTypeId="3" >Date</option>
							<option attribDataTypeId="4" >Selection</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Length</td>
					<td><input type="text" id="attribLength"></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="button" id="addAttribute">Add</button>
					<button type="button" id="editAttribute">Edit</button>
					<button type="button" id="deleteAttribute">Delete</button>
					<button type="button" id="addAttribute">Save Changes</button>
						<input type="button" id="clear" value="Cancel">
					</td>
				</tr>
			</table>
		</div>
		
		
	</body>
</html>