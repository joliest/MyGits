<!-- Instructions to test: Paste this URL on a browser: http://localhost:9888/Basic_JSPs/standard-action.do -->
<!-- Using directive -->
<%@  page import="com.example.packages.*" %>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>My Standard Action JSP</title>
 </head>
 <body>
 	<!-- getting property -->
	<jsp:useBean id="person" class="com.example.packages.Person" scope="request"/>
	The name of the forwarded person is: <jsp:getProperty name="person" property="name" />
	
	<br>
	
	<!-- creating new bean and setting its properties -->
	<jsp:useBean id="person2" class="com.example.packages.Person" scope="request">
		<jsp:setProperty name="person2" property="name" value="Joliver" />
	</jsp:useBean>
	His friend is: <jsp:getProperty name="person2" property="name" />
	
	<!-- using bean's type attribute -->
	<jsp:useBean id="employee" class="com.example.packages.Employee" type="com.example.packages.Person" scope="request">
		<jsp:setProperty name="employee" property=
	</jsp:useBean>
 </body>
</html>