<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:url action="Topic/showReplies/%{reply.topic.t_id}" includeContext="true" var="linkBack"/>
<meta http-equiv="refresh" content="0.5;url=<s:property value="%{linkBack}" />"> 
<title>Reply deleted</title>
</head>
<body>
<div>Reply deleted!! Redirecting in 0.5 seconds</div>
</body>
</html>