<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<title>Categories</title>
</head>
<body>
	<%@include file="/webcomp/header.html"%>

	<div id="page">
		<s:iterator value="categories">

			<div>
				<s:a action="Category/showTopics/%{t_cat_id}">
					<s:property value="t_cat_name" />
				</s:a>
			</div>
			<div>
				<s:property value="t_cat_desc" />
			</div>

		</s:iterator>
	</div>
	<%@include file="/webcomp/footer.html"%>
</body>
</html>