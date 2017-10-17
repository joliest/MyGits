
/*
 	Add validation that detects blank values
 */

$(document).ready(function(){
	
	var controller = "/MiniTracker/Attribute.do";

	loadAttributePage();
	
	$("li").click(function(){
		$(this).css("background-color", "#ffff00");
	})
	
	$("#addAttribute").click(function(){
		$.post(controller,
				{
					category : "addAttribute",
					groupName : $("#attribGroup").val(),
					groupId : $("option:selected").attr("attributeid"),
					name : $("#attribName").val(),
					dataType : $("#attribDataType").val(),
					length : $("#attribLength").val()
				},
				function(data, status) {
					alert(data);
					loadAttributePage();
					clearTextFields()
				})				
	})
	
	$("#addAttributeGroup").click(function(){
		$.post(controller, 
				{
					category : "addAttributeGroup",
					name : $("#attribGroupName").val()
				},
				function(data, status) {
					alert(data);
					loadAttributePage();
					clearTextFields()
				})
	})

	function loadAttributePage() {
	$.post(controller, 
			{category : "loadAttributeGroups"},
			function(data, status) {
				$("#selectAttributeGroup").html(data);
			})
			
	$.post(controller,
			{category : "loadAttributesPanel"},
			function(data, status){
				$("#attributeGroupList").html(data);
			})
	}
	
	function clearTextFields() {
		$(":text").val("");
	}
})




/*
function addAttribute(value) {
	var buttonType = value;
	
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200) {
			alert("Ok");
		}
	};
	
	xhttp.open("POST", "MiniTracker/");
	xhttp.send();
}

*/