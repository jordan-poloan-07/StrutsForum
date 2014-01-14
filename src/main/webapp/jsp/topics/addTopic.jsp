<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<title>Add a topic</title>
</head>
<body>
	<!-- should ajax this shit -->
	<%-- <s:form id="addTopicForm" action="topicModifier/addTopic/%{param}"> --%>
	<s:form id="addTopicForm">
		<s:hidden id="topicCat" value="%{param}" />
		<s:textfield name="topic.t_title" size="30" label="Title" />
		<s:textarea name="topic.t_desc" label="Description" cols="30"
			rows="10" />
		<s:submit value="Submit" />
	</s:form>
</body>
</html>