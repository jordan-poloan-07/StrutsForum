<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<title>Home</title>
</head>
<body>
	<%@include file="/webcomp/header.html"%>

	<div id="page">

		Welcome

		<div>
			<s:set name="profilePic" value="user.usersInfo.profilePic" />

			<!-- URL for the user's profile pic -->
			<s:url includeContext="true" value="%{#profilePic}" var="picUrl" />
			
			<img src="<s:property value="#picUrl"/>" border="1" height="75"
				width="75" />

		</div>

		<div>
			<s:property value="#session['user'].username" />
			,
			<s:property value="#session['user'].email" />

			<s:a action="EditProfile/input">Edit Profile</s:a>
		</div>
	</div>

	<%@include file="/webcomp/footer.html"%>
</body>
</html>