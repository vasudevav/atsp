<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/passwordCreation.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/passwordCreation.js"></script>	
<style type="text/css">
body {
	background-image:
		url("${pageContext.request.contextPath}/images/backg5.jpg");
	min-height:579px;	
}
</style>
<title>passWord creation</title>
</head>
<body>
	<div class="back" style="margin-top: 30px;">
		<div class="container">
			<span class="h5  text-danger"> ${msg} </span>
			<h2 class="text-center h4 text-secondary">Password Creation Page</h2>
			<form:form id="pwdForm" action="pwdCreate"
				modelAttribute="userhelper" method="post" cssClass="form-group">
				<label for="email" class="text-info">Email Id</label>
				<form:input path="email" cssClass="form-control" readonly="true" />
				<br>
				<label for="tempPwd" class="text-info">Enter Temporary
					Password</label>
				<form:password path="tempPwd" cssClass="form-control" />
				<br>
				<label for="pazzword" class="text-info">Enter New Password</label>
				<form:password path="pazzword" cssClass="form-control" />
				<br>
				<label for="confirmPazzword" class="text-info">Confirm
					Password</label>
				<form:password path="confirmPazzword" cssClass="form-control" />
				<br>
				<div align="center">
					<input id="submitBtn" type="submit" value="Un-Lock/Change"
						class="btn btn-outline-success" />
				</div>
			</form:form>
		</div>
	</div>
	<div class="footer">
		<p>&copy; All rights reserved,Hyderabad&emsp;<a
			href="https://github.com/rawatrituraj653" style="color: #fff">Contact
			Us</a></p>
	</div>
	
</body>
</html>