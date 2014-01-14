<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Topic</title>
</head>
<body>
	<%-- <s:form id="editTopicForm" action="topicModifier/edit/%{topic.t_cat_id}"> --%>
	<s:form id="editTopicForm">
		<s:hidden id="topicId" value="%{param}" />
		<s:textfield name="topic.t_title" size="30" label="Title" />
		<s:textarea name="topic.t_desc" label="Description" cols="30"
			rows="10" />
		<s:submit value="Edit" />
	</s:form>
</body>
</html>