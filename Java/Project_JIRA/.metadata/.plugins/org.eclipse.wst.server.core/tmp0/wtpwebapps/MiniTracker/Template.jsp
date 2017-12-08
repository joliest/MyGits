<html>
	<head>
		<title>Template Page</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="js/Template.js"></script>
		<style>
			ul {
				list-style-type : none;
			}
		</style>
	</head>
	<body>
		<p> All Templates </p>
		<ul id = "templateList">
			<li>Report a bug</li>
			<li>Report an enhancement</li>
			<li>New User</li>
		</ul>
		
		<input type="text" id="templateName">
		<input type="button" id="addTemplateButton" value="Add Form">
		
		<br>
		<fieldset>
		<legend>General</legend>
		<table>
			<tr> 
				<td> ID </td>
				<td><input type="text"></td>
			</tr>
			<tr> 
				<td> Name </td>
				<td><input type="text"></td>
			</tr>
		</table>
		</fieldset>
		
		<fieldset>
		<legend>Network</legend>
		<table>
			<tr> 
				<td> Ip Address </td>
				<td><input type="text"></td>
			</tr>
		</table>
		</fieldset>
		
		<div id = "attributeListBox">
			<ul>
				<li id="attributeGroupList" attributeGroupId="1"><b>General</b> 
					<ul>
						<li><input type="checkbox" attributeGroupId="12" attributeId="11"> Name </li>
					</ul>
				</li>
				<li><input type="button" id="OkAdd" value="Ok"> 
					<input type="button" id="CancelAdd" value="Cancel">
				</li>
			</ul>
		</div>
		
		<input type="button" id="addAttributeButton" value="Add Attributes">
		<input type="button" id="deleteAttributeButton" value="Delete Attributes">
		<input type="button" value="Save Changes">
		<input type="button" value="Cancel">
		
	</body>
</html>