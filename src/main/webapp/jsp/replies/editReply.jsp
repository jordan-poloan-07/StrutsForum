<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Reply</title>
</head>
<body>
	<s:form action="replyModifier/edit/%{reply.topic.t_id}">
		<s:textarea id="replyContentArea" name="reply.t_reply_content"
			label="Reply" labelposition="top" cols="30" rows="5" />
		<s:submit value="Edit Reply" />
	</s:form>
</body>
</html>