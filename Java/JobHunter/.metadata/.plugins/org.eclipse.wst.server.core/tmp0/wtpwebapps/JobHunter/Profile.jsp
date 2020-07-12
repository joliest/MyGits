<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="chunks/header.jsp">
			<jsp:param name="theTitle" value="Profile" />
	</jsp:include>
</head>
<body>
	<div class="container">
  <h3>Personal Details</h3>
  <div class="well">
    <div class="pull-right">
    	<span class="glyphicon glyphicon-pencil"></span>
    	
    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-ok"></span> Save 
	        </button>
	    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-remove"></span> Cancel 
	        </button>
    </div>

	<table class=".table">
		<tr>
			<th>First Name Last Name</th>
		</tr>
		<tr>
			<td>Job Title</td>
		</tr>
		<tr>
			<td>123 Brgy. Address, City, Province, Country</td>
		</tr>
		<tr>
			<td>emailaddress@domain.com</td>
		</tr>
		<tr>
			<td>(000) 123 456 789</td>
		</tr>
	</table>
  </div>
  
  <h3>Job Preference</h3>
  
  <div class="well">
   <div class="pull-right">
    	<span class="glyphicon glyphicon-pencil"></span>
    	
    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-ok"></span> Save 
	        </button>
	    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-remove"></span> Cancel 
	        </button>
    </div>
	<table class=".table">
		<tr>
			<th>Desired Job Title</th>
		</tr>
		<tr>
			<td>job_preference</td>
		</tr>
		<tr>
			<td>(full_time)</td>
		</tr>
	</table>
  </div>
  
  <h3>Work Experience</h3>  
  <div class="well">
    <div class="pull-right">
    	<span class="glyphicon glyphicon-pencil"></span>
    	
    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-ok"></span> Save 
	        </button>
	    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-remove"></span> Cancel 
	        </button>
    </div>
	<table class=".table">
		<tr>
			<th>First Work Experience</th>
		</tr>
		<tr>
			<td>Company name</td>
		</tr>
		<tr>
			<td>2000-2000</td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td>Responsible for providing support and establishing a higher touch in all technical and operational support aspects of Cormant relationship with its customers.</td>
		</tr>
	</table>
  </div>
  
  <h3>Education</h3>  
  <div class="well">
   <div class="pull-right">
    	<span class="glyphicon glyphicon-pencil"></span>
    	
    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-ok"></span> Save 
	        </button>
	    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-remove"></span> Cancel 
	        </button>
    </div>
	<table class=".table">
		<tr>
			<th>College University</th>
		</tr>
		<tr>
			<td>BS. Course Degree</td>
		</tr>
		<tr>
			<td>2000-2000</td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td>Responsible for providing support and establishing a higher touch in all technical and operational support aspects of Cormant relationship with its customers.</td>
		</tr>
	</table>
  </div>
  <div class="well">
	<table class=".table">
	<div class="pull-right">
    	<span class="glyphicon glyphicon-pencil"></span>
    	
    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-ok"></span> Save 
	        </button>
	    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-remove"></span> Cancel 
	        </button>
    </div>
		<tr>
			<th>Skills</th>
		</tr>
		<tr>
			<td>Skill, Skill, Skill, Skill, Skill, Skill, Skill, Skill, Skill, Skill, </td>
		</tr>
	</table>
  </div>
</div>
	
</body>
</html>