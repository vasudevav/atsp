<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/owl.carousel.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/homePage.css" />
	
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/homePage.js"></script>
<style type="text/css">
body{
background-image: url("${pageContext.request.contextPath}/images/backg5.jpg") ;
}
</style>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

	<div class="row">
		<div class="col-md-3">
			<img src="${pageContext.request.contextPath}/images/atslogo.png"
				width="290px" height="90px" class="logo">
		</div>
		<div class="col-md-8 brandText">Automated TollPayment System</div>

	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="owl-carousel owl-theme">
					<div class="item">
						<img src="${pageContext.request.contextPath}/images/toll.jpg"
							alt="tollPlaza">
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/images/car.jpg"
							alt="Car">
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/images/bike.jpg"
							alt="Bike">
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/images/bus.jpg"
							alt="Bus">
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/images/truck.jpg"
							alt="Truck">
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-container">
					<h3 class="text-center h3 text-primary">Login Page</h3>
					<span class="text-danger h6">${msg}</span>
					<form:form id="signInForm"
						action="${pageContext.request.contextPath}/userReg/handleSignIn"
						modelAttribute="atsUserMod" cssClass="form-group">
						<label for="email" class="h4 text-info">Enter Email Id</label>
						<form:input path="email" cssClass="form-control" />
						<br>
						<label for="pazzword" class="h4 text-info">Enter Password</label>
						<form:password path="pazzword" cssClass="form-control" />
						<br>
						<input type="submit" value="Sign In" class="btn  btn-primary" />
					</form:form>
					<a href="${pageContext.request.contextPath}/unlock/forPage"
						class="text-left link">Forgot Password</a> <a
						href="${pageContext.request.contextPath}/userReg/index"
						class="text-right link" style="margin: 96px;">Sign Up</a>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		&copy; All rights reserved,Hyderabad&emsp;<a
			href="https://github.com/rawatrituraj653" style="color: #fff">Contact
			Us</a>
	</div>

</body>
</html>