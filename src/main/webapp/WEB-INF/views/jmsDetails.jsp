<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post JMS Message</title>
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

#leftpane tr td {
	color: #515151;
	font-weight: bold
}

#rightpane tr td {
	color: #515151;
	font-weight: bold
}
input[type=submit] {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="topDiv">
		<h2>POST JMS MESSAGE</h2>
	</div>
	<form:form action="postJmsMessage" method="post"
		commandName="jmsDetails">
		<div class="outerDiv">
			<table style="width: 100%; padding: 15px;">
				<tr>
					<td style="vertical-align: top; width: 20%">
						<table id="leftpane">
							<tbody>
								<tr>
									<td><span style="color: red">*</span> Environment</td>
								</tr>
								<tr>
									<td><form:select path="environment"
											items="${environmentList}" style="width:100%;" /></td>
								</tr>
								<tr>
									<td><span style="color: red">*</span> Queue or Topic Selector</td>
								</tr>
								<tr>
									<td><form:select path="queueOrTopic"
											items="${queueOrTopicSelector}" style="width:100%;" /></td>
								</tr>
								<tr>
									<td><span style="color: red">*</span> Queue/ Topic Name:</td>
								</tr>
								<tr>
									<td><form:input type="text" path="name"
											style="width:100%;" required="required" /></td>
								</tr>
								<tr>
									<td><span style="color: red">*</span> User Name:</td>
								</tr>
								<tr>
									<td><form:input type="text" path="username"
											style="width:100%;" required="required" /></td>
								</tr>
								<tr>
									<td><span style="color: red">*</span> Password:</td>
								</tr>
								<tr>
									<td><form:input type="password" path="password"
											style="width:100%;" required="required" /></td>
								</tr>
							</tbody>
						</table>
					</td>
					<td style="vertical-align: top;">
						<table width="100%" id="rightpane">
							<tr>
								<td><span style="color: red">*</span> Content</td>
							</tr>
							<tr>
								<td><textarea rows="12" name="content" style="width: 100%"
										required="required"></textarea></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<input type="submit" style="margin-left: 40%; width: 20%; border-radius: 15px; border: 1px solid #515151" value="Post" />
	</form:form>
</body>
</html>