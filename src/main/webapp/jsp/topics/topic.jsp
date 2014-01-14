<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" type="text/css" href="../../css/main.css" />
<link rel="stylesheet" type="text/css" href="../../css/topic.css" />
<title><s:property value="topic.t_title" /></title>
</head>
<body>
	<%@include file="/webcomp/header.html"%>

	<div id="page">

		<table id="replies">

			<tr class="topicInfo">
				<td id="topicPictureCell"><center>
						<s:set name="profilePic" value="topic.user.usersInfo.profilePic" />

						<!-- URL for the user's profile pic -->
						<s:url includeContext="true" value="%{#profilePic}" var="picUrl" />

						<img src="<s:property value="#picUrl"/>" height="75" width="75" />
					</center></td>
				<td id="topicInfoCell">
					<h1 id="topicTitle">
						<s:property value="topic.t_title" />
					</h1>
					<div id="topicPoster">
						posted by:
						<s:property value="topic.user.username" />
					</div>
					<div id="topicDesc">
						<s:property value="topic.t_desc" />
					</div>
				</td>
			</tr>

			<s:if test="topic.topicreply.size() != 0">
				<s:iterator value="topic.topicreply">
					<tr class="replyRow">
						<td class="replyUserCell">
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

						<td class="replyContentCell">
							<div class="date">
								<s:property value="t_reply_date" />
							</div>
							<div class="content">
								<s:property value="t_reply_content" />
							</div> <s:if test="user.user_id == #session['user'].user_id">
								<div class="controls">
									<s:a action="replyModifier/editInput/%{t_reply_id}">Edit</s:a>
									<s:a action="replyModifier/delete/%{t_reply_id}">Delete</s:a>
								</div>
							</s:if>
						</td>

					</tr>
				</s:iterator>
			</s:if>
			<s:else>
				<tr>
					<td></td>
					<td><div id="noReply">No replies yet</div></td>
				</tr>
			</s:else>

			<tr>
				<td></td>
				<td><s:form action="replyModifier/addReply/%{topicId}">
						<s:textarea id="replyContentArea" name="reply.t_reply_content"
							label="Reply" labelposition="top" cols="30" rows="5" />
						<s:submit value="Post Reply" />
					</s:form></td>
			</tr>
		</table>

	</div>

	<%@include file="/webcomp/footer.html"%>
</body>
</html>