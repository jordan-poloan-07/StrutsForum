<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Register here</title>
</head>
<body>
	<s:form action="Register/submit">
		<s:textfield name="user.username" label="Desired Username" />
		<s:textfield name="user.email" label="Email address" />
		<s:password name="user.password" label="Password" />
		<s:password name="cpassword" label="Confirm Password" />
		<s:submit value="Register" />
	</s:form>
</body>
</html>