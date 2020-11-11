<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post JMS Message Success</title>
<style>
div.topDiv {
	margin: 5px;
	border: 1px solid #515151;
	width: 100%;
	float: left;
	text-align: center;
	-moz-border-radius: 15px;
	border-radius: 15px;
}

div.outerDiv {
	margin: 5px;
	border: 1px solid #515151;
	width: 100%;
	float: left;
	-moz-border-radius: 15px;
	border-radius: 15px;
}
input[type=submit] {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="topDiv">
		<h2>POST Message to JMS Succeeded!</h2>
	</div>
	<form:form action="postJmsMessage" method="get">
		<div class="outerDiv">
			<table style="width: 100%; padding: 15px;">
				<tr>
					<td colspan="2" align="center">
						<h3>Here's the review of your details:</h3>
					</td>
				</tr>
				<tr>
					<td>Environment:</td>
					<td>${jmsDetails.environment}</td>
				</tr>
				<tr>
					<td>Name:</td>
					<td>${jmsDetails.name}</td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td>${jmsDetails.username}</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td>${jmsDetails.password}</td>
				</tr>
				<tr>
					<td>Content:</td>
					<td>${jmsDetails.content}</td>
				</tr>
			</table>
		</div>
		<input type="submit" style="margin-left:40%;width:20%; border-radius: 15px; border: 1px solid #515151" value="Back" />
	</form:form>
</body>
</html>