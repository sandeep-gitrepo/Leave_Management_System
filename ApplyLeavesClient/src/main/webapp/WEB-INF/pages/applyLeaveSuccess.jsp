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
		<h1 align="center">Your Leaves have been applied successfully...</h1>
		<br />
		<br />
		
		<table id="apply_leave_table" class="table">
				<tr>
					<td>Leave Type :</td>
					<td></td>
				</tr>
				<tr>
					<td>Leave Start Date :</td>
					<td><form:input type="date" path="start_date" /></td>
				</tr>
				<tr>
					<td>Leave End Date :</td>
					<td><form:input type="date" path="end_date" /></td>
				</tr>
				<tr>
					<td>No of Days Applied Leave :</td>
					<td><form:input type="date" path="end_date" /></td>
				</tr>
				<tr>
					<td>Leave Remaining :</td>
					<td><form:input type="date" path="end_date" /></td>
				</tr>
				<tr>
					<td>Remarks :</td>
					<td><form:input type="text" path="remarks" /></td>
				</tr>
				<tr>
					<td>Leave Status :</td>
					<td><form:input type="date" path="end_date" /></td>
				</tr>
		</table>		
		
		<br />
		<br />
		
		<a href="#">Click here to Goto Leave Apply Page</a>
		
	</div>
</body>
</html>