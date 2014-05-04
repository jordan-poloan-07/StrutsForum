<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<sj:head jqueryui="true" compressed="true" />
<script type="text/javascript" src="../../javascript/strutsforum.js"></script>
<script type="text/javascript"
	src="../../javascript/strutsforum.login.js"></script>
<s:include value="../../webcomp/includes.jsp" />
<title>Forum Login</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<s:form id="loginForm">
				<s:textfield name="user.username" label="Username" />
				<s:password name="user.password" label="Password" />
				<s:submit value="Login" />
			</s:form>
		</div>
		<div id="resultDiv" class="row"></div>
		<div class="row">
			<s:a action="Register/form">Register</s:a>
		</div>

	</div>

</body>
</html>