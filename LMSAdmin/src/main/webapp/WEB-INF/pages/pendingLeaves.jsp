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

	<h2>Employees Applied / Pending Leaves:</h2>

	<br />

	<table border="2" width="95%" cellpadding="2" align="center">
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
			<td>Action</td>
		</tr>
		<c:forEach var="pending" items="${pendingLeaveList}">
			<tr>
				<td>${pending.emp_id}</td>
				<td>${pending.emp_name}</td>
				<td>${pending.leave_type_name}</td>
				<td>${pending.total_leaves}</td>
				<td>${pending.leave_taken}</td>
				<td>${pending.current_balance}</td>
				<td>${pending.start_date}</td>
				<td>${pending.end_date}</td>
				<td>${pending.totalNoOfDays}</td>
				<td>
					<a href="approveLeaves/${pending._id}"> Approve </a>
					<a href="rejectLeaves/${pending._id}"> Reject </a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>