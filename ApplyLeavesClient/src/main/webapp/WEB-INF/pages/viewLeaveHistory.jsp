<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<br />
		<h1 align="center">View Your Leaves History of this year</h1>
		<br /> <br />

		<table border="2" width="80%" cellpadding="2" align="center">
		<tr>
			<th>Leave Type</th>
			<th>Total Leaves</th>
			<th>Leaves Taken</th>
			<th>Leaves Balance</th>
			<th>Leave Start Date</th>
			<th>Leave End Date</th>
			<th>Total Days</th>
			<th>Remarks</th>
			<th>Status</th>
		</tr>
		<c:forEach var="approved" items="${approvedLeaveList}">
			<tr>
				<td>${approved.leave_type_name}</td>
				<td>${approved.total_leaves}</td>
				<td>${approved.leave_taken}</td>
				<td>${approved.current_balance}</td>
				<td>${approved.start_date}</td>
				<td>${approved.end_date}</td>
				<td>${approved.status}</td>
				<td>${approved.remarks}</td>
			</tr>
		</c:forEach>
	</table>	

	</div>
</body>
</html>