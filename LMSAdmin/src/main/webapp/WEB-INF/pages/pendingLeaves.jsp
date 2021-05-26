<!DOCTYPE html>
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

	<form action="/submitLeaves" method="post">
	<div>
	<table border="2" width="95%" cellpadding="2" align="center">
		<tr>
			<th>Emp ID</th>
			<th>Emp Name</th>
			<th>Applied Leave</th>
			<th>Leave Start Date</th>
			<th>Leave End Date</th>
			<th>Total Days</th>
			<th>Remarks</th>
			<th>Action</th>
		</tr>
		<c:forEach var="pending" items="${pendingLeaveList}">
			<tr>
				<td>${pending.emp_id}</td>
				<td>${pending.emp_name}</td>
				<td>${pending.leave_type}</td>
				<td>${pending.leave_start_date}</td>
				<td>${pending.leave_end_date}</td>
				<td>${pending.total_days}</td>
				<td><input type="text" value=${pending.remarks } /></td>
				<td><select name="status" id="status">
						<option value="">--- Select ---</option>
						<option value="approve">Approve</option>
						<option value="reject">Reject</option>
				</select></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10" align="center">
				<div>
					<button type="submit">Submit</button>
				</div>
			</td>
		</tr>
	</table>
	</div>
	</form>
	
</body>
</html>