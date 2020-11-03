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
		<h1 align="center">Apply Leave</h1>
		<br />
		<br />
		<h2 id="article_header" class="text-warning" align="center"></h2>
		<div></div>
		<div></div>
		<form:form id="applyLeaveForm" method="post" action="submitApplyLeave">
			<table id="apply_leave_table" class="table">
				<tr>
					<td>Enter Employee ID :</td>
					<td><form:input path="emp_id" /></td>
				</tr>
				<tr>
					<td>Select Leave Type :</td>
					<td>
						<form:select path="leave_id">
							<form:option value="1" label="Annual Leave" />
							<form:option value="2" label="Medical Leave" />
							<form:option value="3" label="Casual Leave" />
							<form:option value="4" label="Paternity Leave" />
							<form:option value="5" label="Adoption Leave" />
							<form:option value="6" label="Bereavement Leave" />
							<form:option value="7" label="Maternity Leave" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Enter Start Date :</td>
					<td><form:input type="date" path="start_date" /></td>
				</tr>
				<tr>
					<td>Enter Date Date :</td>
					<td><form:input type="date" path="end_date" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="SAVE" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>