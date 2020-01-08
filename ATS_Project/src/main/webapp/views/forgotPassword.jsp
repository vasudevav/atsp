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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/additional-methods.min.js"></script>	
<style type="text/css">
.container {
	max-width: 540px;
	width: 400px;
	border: 1px solid blue;
	border-radius: 7px;
	box-shadow: 5px 17px 10px #956d6d;
	background: #fff;
}
.footer {
	text-align: center;
	color: #fff;
	position: absolute;
	bottom: 0px;
}
.text-info {
	color: #17a2b8 !important;
	font-weight: bold;
}

.form-control {
	color: black !important;
}

.error {
	color: red;
}
p{
 min-width: 1263px;
}
body {
	background-image:
		url("${pageContext.request.contextPath}/images/backg5.jpg");
	min-height: 571px;	
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$(function() {
			$('form[id="pwdForm"]').validate({
				rules : {
					email :{
						required :true,
						email: true
						},
					phno :{
						required: true,
						maxlength: 10,
						minlength: 10,
						number :true
						},	
				},
				messages : {
					email : {
						reuired : "*Email Required!",
						email:"*Enter valid Email Id"	
					},
					phno: {
						reqiured : "Moblie Number Required",
						maxlength : "phno should be 10 digit",
						minlength : "phno must be 10 digit",
						number : "*Only Number required"
					}
				},
				submitHandler : function(form) {
					form.submit();
				}
			});
		});
	});
</script>
<title>Forgot Pwd </title>
</head>
<body>
	<div class="back" style="margin-top: 38px;">
		<div class="container">
			<span class="h5  text-danger"> ${msg} </span>
			<h2 class="text-center h4 text-secondary">Forgot Password Page</h2>
			<form:form id="pwdForm" action="handleResetPwd"
				modelAttribute="atsUserMod" method="post" cssClass="form-group">
				<label for="email" class="text-info">Email Id</label>
				<form:input path="email" cssClass="form-control"/>
				<br>
				<label for="phno" class="text-info">Enter Phone Number</label>
				<form:input path="phno" cssClass="form-control"/>
				<br>
				<div align="center">
					<input id="submitBtn" type="submit" value="Reset Password"
						class="btn btn-outline-success" />
				</div>
			</form:form>
		</div>
	</div>
	<div class="footer"><p>
		&copy; All rights reserved,Hyderabad&emsp;<a
			href="https://github.com/rawatrituraj653" style="color: #fff">Contact
			Us</a></p>
	</div>
	
</body>
</html>