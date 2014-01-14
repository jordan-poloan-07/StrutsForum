<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Profile Pic</title>
</head>
<body>
	<s:form action="EditProfile/submit" enctype="multipart/form-data"
		method="POST">
		<s:file name="profPic" label="Profile Pic" />
		<s:submit value="Submit" />
	</s:form>
</body>
</html>