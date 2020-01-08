<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
<style type="text/css">
.container {
	max-width: 540px;
	width: 400px;
	border: 1px solid blue;
	border-radius: 7px;
	box-shadow: 5px 17px 10px #956d6d;
	background: #fff;
	height: 280px;
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

.form-control{
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
			$('form[id="searchForm"]').validate({
				rules : {
					regNum : {
						required: true,
						minlength: 7,
						maxlength: 7,
						}
				},
				messages : {
					regNum : {
						reuired : "Registration Number Required..",
						minlength: 'Invalid Registration Number',
						maxlength: 'Invalid Registration Number'
					}
				},
				submitHandler : function(form) {
					form.submit();
				}
			});
		});
	});
</script>
<title>Search Vehicle</title>
</head>
<body>
	<div class="back" style="margin-top: 38px;">
		<div class="container">
			<h2 class="text-center h4 text-secondary">Vehicle Search Page</h2><br>
			<span class="h5  text-danger"> ${msg} </span>
			<form  id="searchForm" action="searchVhclDtls" method="post">
				<label for="regNum" class="text-info">Enter Vehicle Number</label>
				<input type="text" name="regNum" id="regNum" class="form-control"placeholder="Enter Vehicle Number"/>
				<br>
				<div align="center">
					<input id="submitBtn" type="submit" value="Search"
						class="btn btn-outline-success" />
				</div>				
			</form>
			<div align="center">
			<c:if test="${vhclSummary ne null}">
				<br>
				<strong>
				VehicleCompany: ${vhclSummary.vhclDtls.companyName}<br>
				 VehicleType&emsp;: ${vhclSummary.vhclDtls.vehicleType}<br>
				</strong><br>
				<a href="#" class="btn btn-outline-warning">Proceed To Purchase &gt;</a>
			</c:if>
		</div>
	</div>
</div>	
	<div class="footer"><p>
		&copy; All rights reserved,Hyderabad&emsp;<a
			href="https://github.com/rawatrituraj653" style="color: #fff">Contact
			Us</a></p>
	</div>	
</body>
<c:if test="${vhclSummary ne null}">
<style>
.container{
	height: 393px;

}
</style>	
</c:if>
</html>