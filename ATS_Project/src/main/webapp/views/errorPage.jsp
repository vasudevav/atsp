<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<style type="text/css">
img{
width:850px;	
}
.footer {
	text-align: center;
	color: #fff;
	position: absolute;
	bottom: 0px;
}
body {
	min-height: 594px;
}
.footer p{
    min-width: 1271px;
}
</style>
</head>
<body >
	<div align="center"><font size="5">Some Problem Occurred  Try Again After Some Time</font><br> 
	<img alt="Error Page" src="${pageContext.request.contextPath}/images/error.png"> 
	
	</div>
	<div class="footer">
		<p>&copy; All rights reserved,Hyderabad&emsp;<a
			href="https://github.com/rawatrituraj653" style="color: #fff">Contact
			Us</a></p>
	</div>
	
</body>
</html>