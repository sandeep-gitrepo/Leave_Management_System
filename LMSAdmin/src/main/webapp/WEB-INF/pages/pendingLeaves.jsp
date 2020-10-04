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

	<h2>Employees Applied Pending Leaves:</h2>

	<br />

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Employee Name</th>
			<th>Applied Leave</th>
			<th>Leave Balance</th>
			<th>Negative Balance</th>
			<th>Leave Taken</th>
			<th>Leave Start Date</th>
			<th>Leave End Date</th>
			<th>Total Days</th>
		</tr>
		<c:forEach var="pending" items="${pendingLeaveList}">
			<tr>
				<td>${pending.emp_id}</td>
				<td>${pending.leave_id}</td>
				<td>${pending.opening_balance}</td>
				<td>${pending.negative_balance}</td>
				<td>${pending.leave_taken}</td>
				<td>${pending.start_date}</td>
				<td>${pending.end_date}</td>
				<td>${pending.totalNoOfDays}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>