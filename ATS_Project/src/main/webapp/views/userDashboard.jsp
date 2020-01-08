<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>	
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/popper.min.js"></script>	
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>	

<title>Project DashBoard</title>
<style type="text/css">
	.footer{
		position: absolute;
		bottom: 0px;
	}
.footerp{
	color:#fff;
	text-align: center !important;
	min-width: 1280px;
}
.nav{
font-weight: bold;
}
body{
background-image: url("${pageContext.request.contextPath}/images/backg5.jpg") ;
}
.headerContent{
    color: #212529;
    background-color: #ffc107;
    border-color: #ffc107;
}
.brand{
    padding-top: 7px;
    font-weight: bold;
    padding-left: 51px;
}
.dropdown-item:hover{
	background-color: pink;
	color: blue;
}
</style>
<script>
	$(document).ready(function(){
		let role=$("#roleCheck").val();
		if(role=='ADMIN'){
			$("#dropdown").show();
				$("#dropdown").removeClass("disabled");
			}
		else{
			$("#dropdown").hide();
			}
		$('#myTab #dropdown').on('mouseover', function (e) {
				console.log('mouser over')
			  e.preventDefault();
			  $('#myTab #dropdown').attr({'aria-expanded':'true'});
			  $("#myTab .nav-item.dropdown").addClass('show');
			  $("#myTab .dropdown-menu").addClass('show');
			})
			$("#myTab .dropdown-menu").on('mouseleave', function (e) {
				console.log('mouser out')
			  e.preventDefault();
			  $('#myTab #dropdown').attr({'aria-expanded':'false'});
			  $("#myTab .nav-item.dropdown").removeClass('show');
			  $("#myTab .dropdown-menu").removeClass('show');
			})

		})
</script>
</head>
<body>
<div class="row headerContent">
<div class="col-2 brand">ATS DashBoard</div>
<div class="offset-md-5 col-md-5 ">	
<ul class="nav justify-content-center" id="myTab">
  <li class="nav-item">
    <a class="nav-link" href="#">My Tag</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/tag/index">Purchase Tag</a>
  </li>
    <li class="nav-item dropdown">
    <input type="hidden" value="${role}" id="roleCheck">
    <a class="nav-link dropdown dropdown-toggle disabled" id="dropdown" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Admin</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/index">Create Account</a>
      <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/findAgencies/AGENCY">View Agencies</a>
      <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/findAgencies/ADMIN">view Admin`s</a>
      <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/findAgencies/USER">view Users</a>
      <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/unlockAccs">Active/De-active Account</a>
      <a class="dropdown-item" href="#">view Tags</a>
      <a class="dropdown-item" href="#">Active/De-active Agency</a>
    </div>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/atsuser/index">Logout</a>
  </li>
</ul>
</div>
</div><br>
	<div align="center">
		<img src="${pageContext.request.contextPath}/images/maintain.jpg" style="width:800px">
	</div>
	<div class="footer"><p class="footerp">
		&copy; All rights reserved,Hyderabad&emsp;<a
			href="https://github.com/rawatrituraj653" style="color:#fff;">Contact
			Us</a><p>
	</div>
</body>
</html>