<html>
<head>
<title>LMS Core Application</title>
</head>
<body>
	<br />
	<br />
	<h1 align="center">Applied Leave has been Approved Successfully</h1>

	<br />

	<table border="2" width="50%" cellpadding="2" align="center">
		<tr>
			<th>Emp ID</th>
			<td>${leaveDtlDTO.emp_id}</td>
		</tr>
		<tr>
			<th>Employee Name</th>
			<td>${leaveDtlDTO.emp_name}</td>
		</tr>
		<tr>
			<th>Applied Leave</th>
			<td>${leaveDtlDTO.leave_type_name}</td>
		</tr>
		<tr>
			<th>Total Leaves</th>
			<td>${leaveDtlDTO.total_leaves}</td>
		</tr>
		<tr>
			<th>Leave Balance</th>
			<td>${leaveDtlDTO.current_balance}</td>
		</tr>
		<tr>
			<th>Leave Taken</th>
			<td>${leaveDtlDTO.leave_taken}</td>
		</tr>
		<tr>
			<th>Leave Start Date</th>
			<td>${leaveDtlDTO.start_date}</td>
		</tr>
		<tr>
			<th>Leave End Date</th>
			<td>${leaveDtlDTO.end_date}</td>
		</tr>
		<tr>
			<th>Total Days</th>
			<td>${leaveDtlDTO.totalNoOfDays}</td>
		</tr>
		<tr>
			<th>Status</th>
			<td>${leaveDtlDTO.status}</td>
		</tr>
	</table>

	<br />
	<br />

	<a href="getAllPendingLeaves">View All Pending Leaves</a>

	<br />
	<br />

	<a href="getAllApprovedLeaves">View All Approved Leaves</a>

	<br />
	<br />

	<a href="getAllRejectedLeaves">View All Rejected Leaves</a>

	<br />
	<br />

</body>
</html>