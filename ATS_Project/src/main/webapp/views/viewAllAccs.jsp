<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<title>All Roles List</title>
<script type="text/javascript">
	function activateConfirm() {
		return confirm("Do you want to Activate this User....!!");
	}

	function deActivateConfirm() {
		return confirm("Do you want to De-Activate this User....!!");
	}
</script>
<style type="text/css">
.avtiveBtn {
	width: 98px;
}
</style>
</head>
<body style="background-color: lightyellow;">
	<a href="${pageContext.request.contextPath}/admin/index"
		class="btn btn-outline-secondary btn-lg">+ ADD More Accounts </a>
	<div class="conatianer">
		<h2 class="h4 text-center text-primary">View All Roles Data</h2>
		<br>
		<c:if test="${msg ne null}">
			<div class="text-center text-danger h2">${msg}</div>
		</c:if>
		<c:if test="${roleList ne null}">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>S.NO.</th>
						<th>User Id</th>
						<th>User Name</th>
						<th>Gender</th>
						<th>Email Id</th>
						<th>Phone Number</th>
						<th>Role</th>
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
							<td>${user.gender}</td>
							<td>${user.email}</td>
							<td>${user.phno}</td>
							<td>${user.roleType}</td>
							<td>${user.zzn}</td>
							<td><c:choose>
									<c:when test="${user.activeSwitch eq '78'}">
										<a
											href="${pageContext.request.contextPath}/admin/actvRole?uid=${user.userId}"
											class="btn btn-outline-success avtiveBtn"
											onclick="return activateConfirm()">Active</a>
									</c:when>
									<c:otherwise>
										<a
											href="${pageContext.request.contextPath}/admin/deactvRole?uid=${user.userId}"
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