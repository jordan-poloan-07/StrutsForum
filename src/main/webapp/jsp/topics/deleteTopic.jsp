<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Delete Topic</title>
</head>
<body>
	<p>
		Do you want to delete
		"<s:property value="topic.t_title" />"
	</p>
	<s:form id="deleteTopicForm">
		<s:hidden id="topicId" name="param" value="%{param}" />
		<s:submit id="yesBtn" value="Yes" />
		<s:submit id="noBtn" value="No" />
	</s:form>
</body>
</html>