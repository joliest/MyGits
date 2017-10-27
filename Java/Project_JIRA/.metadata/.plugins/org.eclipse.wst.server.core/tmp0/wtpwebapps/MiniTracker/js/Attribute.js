
/*
 	Add validation that detects blank values
 */

$(document).ready(function(){
	
	var attributeController = "/MiniTracker/Attribute.do";
	var attributeGroupController = "/MiniTracker/AttributeGroup.do";
	var attributeName;
	var attributeId;
	
	loadAttributePage();	
	disableTextFields();
	
	$("#editAttribute").click(function(){
		enableTextFields();
	})
	
	$(this).on("dblclick", "#attributeGroupListRow", function() {
		var rowValue = $(this).text();
		var rowId = $(this).attr("groupId");
		
		
		$(this).html("<input type='text' value='" + rowValue + "'>" +
					 "<button type='button' id='selectOk'>OK</button>" +
					 "<button type='button' id='selectCancel'>Cancel</button>"
		)
		$(this).on("click", "#selectCancel", function(){
			loadAttributePage();
		})
		$(this).on("click", "#selectOk", function(){
			loadAttributePage();
			alert("Row id " + rowId);
		})
	})
	
	$(this).on("click", "#attributeListRow", function(index) {
		$("li").css("color", "black");
		$(this).css("color", "red");
		
		//get attribute id
		attributeId = $(this).attr("attributeId");
		attributeName = $(this).text();
		
		$.post(attributeController, { category : "getAttributeGroup", attributeId : attributeId }, function(data, status){
			//change the selected value in <option>
			$("option[attributeId='" + data + "']").prop('selected', true);
		})
		
		getAttributeInfo("getAttributeName","#attribName");
		getAttributeInfo("getDataType","select#attribDataType");
		getAttributeInfo("getLength","#attribLength");
	})
	
	function getAttributeInfo(category, elementId) {
		$.post(attributeController, { category : category, attributeId : attributeId }, function(data, status){
			$(elementId).val(data);
		})	
	}
	
	$(this).on("click", "#deleteAttribute", function(){
		var confirmDelete = confirm("Are you sure you want to delete " + attributeName + " attribute?");
		if(confirmDelete == true) {
			$.post(attributeController, { category : "deleteAttribute", attributeId : attributeId }, function(data, status) {
				alert(data);
				loadAttributePage()
			})
		}		
	})
	
	$("#addAttribute").click(function(){
		$.post(attributeController,
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
		
		var attributeGroupName = $("#attribGroupName").val();
		
		if(attributeGroupName != '') {
			$.post(attributeGroupController, 
					{
						category : "addAttributeGroup",
						name : attributeGroupName
					},
					function(data, status) {
						alert(data);
						loadAttributePage();
						clearTextFields()
					})			
		} else {
			alert("Unable to add empty value");
		}
		
	})

	function loadAttributePage() {
	$.post(attributeGroupController, 
			{category : "loadAttributeGroups"},
			function(data, status) {
				$("#selectAttributeGroup").html(data);
			})
			
	$.post(attributeController,
			{category : "loadAttributesPanel"},
			function(data, status){
				$("#attributeGroupList").html(data);
			})
	}
	
	$("input#clear").click(function(){
		loadAttributePage()
		clearTextFields();
	})
	
	function clearTextFields() {
		$(":text").val("");
	}
	
	function disableTextFields() {
		$(":text").attr("readonly", true);
		$("select").attr("disabled", "disabled");
		$("select").css("color", "black");
		
	}
	
	function enableTextFields() {
		$(":text").attr("readonly", false);
		$("select").removeAttr("disabled");
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