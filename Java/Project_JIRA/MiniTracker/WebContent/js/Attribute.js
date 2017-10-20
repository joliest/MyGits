
/*
 	Add validation that detects blank values
 */

$(document).ready(function(){
	
	var controller = "/MiniTracker/Attribute.do";

	loadAttributePage();
	
	
	$(this).on("click", "#attributeListRow", function(index) {
		$(this).css("color", "red");
		$(this).css("border", "1px solid red");		
	})
	
	$(this).on("mouseenter", "#attributeListRow", function(index) {
		$(this).css("color", "blue");
		$(this).css("border", "0px solid blue");	
	})
	
	$(this).on("mouseleave", "#attributeListRow", function(index) {
		$(this).css("color", "black");
		$(this).css("border", "0px solid blue");	
	})
	
	/*
	$(this).on("click", "#attributeListRow", function(index) {
		$(this).on({
			mouseenter : function() {
				$(this).css("color", "blue");
				$(this).css("border", "0px solid blue");	
			},
			click : function() {
				$(this).css("color", "red");
				$(this).css("border", "1px solid red");	
			}			
		})	
	})
	*/
	
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