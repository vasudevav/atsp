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
	src="${pageContext.request.contextPath}/js/viewAdmin.js"></script>
<title>Agency List</title>
<style type="text/css">
.avtiveBtn {
	width: 98px;
}
</style>
</head>
<body style="background-color: lightyellow;">
	<a href="${pageContext.request.contextPath}/admin/index?role=ADMIN"
		class="btn btn-outline-secondary btn-lg">+ ADD More Admin's </a>
	<div class="conatianer">
		<h2 class="h4 text-center text-primary">View All Admin Data</h2>
		<br>
		<c:if test="${msg ne null}">
			<div class="text-center text-danger h2">${msg}</div>
		</c:if>
		<c:if test="${roleList ne null}">
			<div class="form-group">
				<select class="form-control" id="adminSelect" style="width: 218px;">
					<option value="">-Select Admin Status-</option>
					<option value="active">Only Active Admins</option>
					<option value="deactive">Only De-Activate Admins</option>
				</select>
			</div>
			<br>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>S.NO.</th>
						<th>Admin Id</th>
						<th>Ad.Owner Name</th>
						<th>DOB</th>
						<th>Gender</th>
						<th>Email Id</th>
						<th>Phone Number</th>
						<th>SSN ID</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${roleList}" var="admin" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${admin.userId}</td>
							<td>${admin.fname}&nbsp;${admin.lname}</td>
							<td>${admin.dob}</td>
							<td>${admin.gender}</td>
							<td>${admin.email}</td>
							<td>${admin.phno}</td>
							<td>${admin.zzn}</td>
							<td><c:choose>
									<c:when test="${admin.activeSwitch eq '78'}">
										<a
											href="${pageContext.request.contextPath}/admin/actvRole?uid=${admin.userId}&role=${admin.roleType}"
											class="btn btn-outline-success avtiveBtn"
											onclick="return activateConfirm()">Active</a>
									</c:when>
									<c:otherwise>
										<a
											href="${pageContext.request.contextPath}/admin/deactvRole?uid=${admin.userId}&role=${admin.roleType}"
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