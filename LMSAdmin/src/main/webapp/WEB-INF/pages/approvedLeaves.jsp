<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>LMS Core Application</title>
</head>
<body>
	<br />
	<br />

	<h3 align="center">Welcome Admin,</h3>

	<br />
	<br />

	<h2>Employees Approved Leaves</h2>

	<br />

	<table border="2" width="80%" cellpadding="2" align="center">
		<tr>
			<th>Emp ID</th>
			<th>Emp Name</th>
			<th>Applied Leave</th>
			<th>Total Leaves</th>
			<th>Leaves Taken</th>
			<th>Leaves Balance</th>
			<th>Leave Start Date</th>
			<th>Leave End Date</th>
			<th>Total Days</th>
		</tr>
		<c:forEach var="approved" items="${approvedLeaveList}">
			<tr>
				<td>${approved.emp_id}</td>
				<td>${approved.emp_name}</td>
				<td>${approved.leave_type_name}</td>
				<td>${approved.total_leaves}</td>
				<td>${approved.leave_taken}</td>
				<td>${approved.current_balance}</td>
				<td>${approved.start_date}</td>
				<td>${approved.end_date}</td>
				<td>${approved.totalNoOfDays}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>