<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery-ui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/additional-methods.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/userRegPage.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/AdminReg.js"></script>
<style>
body {
	background-image:
		url("${pageContext.request.contextPath}/images/backg5.jpg");
}
</style>


<meta charset="ISO-8859-1">
<title>User Reg</title>
</head>
<body>
	<div class="back">
		<div class="container">
			<h2 class="text-center h3 text-secondary">User Registration Form</h2>
			<span class="text-success h5"> ${succMsg} </span>
			<form:form id="userDtls"
				action="${pageContext.request.contextPath}/admin/register"
				modelAttribute="atsUserMod" method="post" cssClass="form-group">
				<label for="fname" class="text-info">Enter your First Name</label>
				<form:input path="fname" cssClass="form-control" />
				<br>
				<label for="lname" class="text-info">Enter your Last Name</label>
				<form:input path="lname" cssClass="form-control" />
				<br>
				<label for="dob" class="text-info">Enter your Date Of Birth</label>
				<form:input path="dob" cssClass="form-control"
					placeholder="mm/dd/yyyy" />
				<br>
				<label for="gender" class="text-info">Choose gender:: </label>
				&ensp;
				<form:radiobutton path="gender" value="Male" checked="true" />Male &emsp;
				<form:radiobutton path="gender" value="Female" />Female
				<br>
				<label for="email" class="text-info">Enter your Mail Address</label>
				<form:input path="email" cssClass="form-control" />
				<span id="emailErr"></span>
				<br>
				<label for="phno" class="text-info">Enter Your Mobile Number</label>
				<form:input path="phno" cssClass="form-control" />
				<br>
				<label for="zzn" class="text-info">Enter your SSN Id</label>
				<form:input path="zzn" cssClass="form-control"
					placeholder="123-45-6789" maxlength="11" />
				<br>
				<label for="roleType" class="text-info">Select Role Type</label>
				<form:select path="roleType" cssClass="form-control" cssStyle="height: 35px;">
					<option value="-1">Select Any Role</option>
					<option value="USER">USER</option>
					<option value="AGENCY">AGENCY</option>
					<option value="ADMIN">ADMIN</option>
				</form:select>
				<br>
				<div align="center" class="text-info">
					<input type="reset" value="clear"
						class="btn btn-outline-danger btn-sm" onclick="return clearConf()" />
					<input type="submit" value=" Sign Up" id="submitBtn"
						class="btn btn-outline-success btn-sm" />
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