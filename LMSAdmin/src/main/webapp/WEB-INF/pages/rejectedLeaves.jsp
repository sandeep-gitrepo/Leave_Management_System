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

	<h2>Employees Rejected Leaves</h2>

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
		<c:forEach var="rejected" items="${rejectedLeaveList}">
			<tr>
				<td>${rejected.emp_id}</td>
				<td>${rejected.emp_name}</td>
				<td>${rejected.leave_type_name}</td>
				<td>${rejected.total_leaves}</td>
				<td>${rejected.leave_taken}</td>
				<td>${rejected.current_balance}</td>
				<td>${rejected.start_date}</td>
				<td>${rejected.end_date}</td>
				<td>${rejected.totalNoOfDays}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>