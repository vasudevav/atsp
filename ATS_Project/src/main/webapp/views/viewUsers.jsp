<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
 <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/viewUsers.js"></script> 	
<title>User List</title>
<style type="text/css">
.avtiveBtn {
	width: 98px;
}
</style>
</head>
<body style="background-color: lightyellow;">
	<a href="${pageContext.request.contextPath}/admin/index?role=USER"
		class="btn btn-outline-secondary btn-lg">+ ADD More Users </a>
	<div class="conatianer">
		<h2 class="h4 text-center text-primary">View All User Data</h2>
		<br>
		<c:if test="${msg ne null}">
			<div class="text-center text-danger h2">${msg}</div>
		</c:if>
		<c:if test="${roleList ne null}">
			<div class="form-group">
				<select class="form-control" id="adminSelect" style="width: 218px;">
					<option value="">-Select User Status-</option>
					<option value="active">Only Active Users</option>
					<option value="deactive">Only De-Activate Users</option>
				</select>
			</div>
			<br>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>S.NO.</th>
						<th>User Id</th>
						<th>User Name</th>
						<th>DOB</th>
						<th>Gender</th>
						<th>Email Id</th>
						<th>Phone Number</th>
						<th>SSN ID</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${roleList}" var="user" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${user.userId}</td>
							<td>${user.fname}&nbsp;${user.lname}</td>
							<td>${user.dob}</td>
							<td>${user.gender}</td>
							<td>${user.email}</td>
							<td>${user.phno}</td>
							<td>${user.zzn}</td>
							<td><c:choose>
									<c:when test="${user.activeSwitch eq '78'}">
										<a
											href="../actvRole?uid=${user.userId}&role=${user.roleType}"
											class="btn btn-outline-success avtiveBtn"
											onclick="return activateConfirm()">Active</a>
									</c:when>
									<c:otherwise>
										<a
											href="../deactvRole?uid=${user.userId}&role=${user.roleType}"
											class="btn btn-outline-danger"
											onclick="return deActivateConfirm()">De-Active</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>