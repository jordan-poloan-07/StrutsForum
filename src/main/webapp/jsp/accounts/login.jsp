<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true" compressed="true" />
<script type="text/javascript" src="../../javascript/strutsforum.js"></script>
<script type="text/javascript"
	src="../../javascript/strutsforum.login.js"></script>
<title>Forum Login</title>
</head>
<body>
	<s:form id="loginForm">
		<s:textfield name="user.username" label="Username" />
		<s:password name="user.password" label="Password" />
		<s:submit value="Login" />
	</s:form>

	<div id="resultDiv"></div>

	<s:a action="Register/form">Register</s:a>
</body>
</html>