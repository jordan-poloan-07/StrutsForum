<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:s="http://jboss.com/products/seam/taglib">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" type="text/css" href="../../css/main.css" />
<link rel="stylesheet" type="text/css" href="../../css/category.css" />
<sj:head jqueryui="true" compressed="true" />
<title><s:property value="topicCategory.t_cat_name" /></title>
<script type="text/javascript" src="../../../javascript/strutsforum.js"></script>
<script type="text/javascript"
	src="../../../javascript/strutsforum.category.js"></script>
</head>
<body>
	<%@include file="/webcomp/header.html"%>

	<div id="page">

		<div id="topCategoryControls">
			<s:url action="topicModifier/addTopicInput/%{categoryId}"
				var="addTopicUrl" />

			<sj:a href="%{#addTopicUrl}" openDialog="addTopicDialog">Add Topic</sj:a>

			<%-- add topic dialog declared here --%>

			<sj:dialog id="addTopicDialog" href="%{#addTopicUrl}" modal="true"
				autoOpen="false" width="550" title="Add Topic"></sj:dialog>
		</div>

		<s:if test="topicCategory.topics.size() != 0">

			<%-- edit topic dialog declared here --%>

			<sj:dialog id="editTopicDialog" modal="true" autoOpen="false"
				width="550" title="Edit Topic"></sj:dialog>

			<%-- delete topic dialog declared here --%>

			<sj:dialog id="deleteTopicDialog" modal="true" autoOpen="false"
				width="550" title="Delete Topic" />

			<table id="topics">

				<s:iterator value="topicCategory.topics">

					<tr class="topicRow">

						<td class="topicUserCell">
							<center>
								<s:set name="profilePic" value="user.usersInfo.profilePic" />

								<!-- URL for the user's profile pic -->
								<s:url includeContext="true" value="%{#profilePic}" var="picUrl" />

								<img src="<s:property value="#picUrl"/>" height="75" width="75" />
							</center>
							<center class="username">
								<s:property value="user.username" />
							</center>
						</td>

						<td class="topicInfoCell">
							<div class="title">
								<s:a action="Topic/showReplies/%{t_id}">
									<s:property value="t_title" />
								</s:a>
							</div>
							<div class="description">
								<s:property value="t_desc" />
							</div> <s:if test="user.user_id == #session['user'].user_id">
								<div class="controls">
									<s:url action="topicModifier/editInput/%{t_id}"
										var="editTopicUrl" />
									<%-- <s:a action="topicModifier/editInput/%{t_id}">Edit</s:a> --%>
									<sj:a href="%{#editTopicUrl}" openDialog="editTopicDialog"
										targets="editTopicDialog">Edit</sj:a>
									<s:url action="topicModifier/deleteInput/%{t_id}"
										var="deleteTopicUrl" />
									<%-- <sj:a action="topicModifier/delete/%{t_id}">Delete</sj:a> --%>
									<sj:a href="%{#deleteTopicUrl}" openDialog="deleteTopicDialog">Delete</sj:a>
								</div>
							</s:if>
						</td>

					</tr>

				</s:iterator>

			</table>
		</s:if>

		<s:else>
			<div>No Topics Yet for this Category</div>
		</s:else>
	</div>

	<%@include file="/webcomp/footer.html"%>
</body>
</html>