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
		<h1 align="center">Employee Management System</h1>
		<br />
		<br />
		<h2 id="article_header" class="text-warning" align="center">Add New Employee Record</h2>
		<div></div>
		<div></div>
		<form:form method="post" action="addEmpAction">
			<table id="users_table" class="table">
				<tr>
					<td>Name :</td>
					<td><form:input path="empName" /></td>
				</tr>
				<tr>
					<td>CTC :</td>
					<td><form:input path="ctc" /></td>
				</tr>
				<tr>
					<td>Designation :</td>
					<td><form:input path="designation" /></td>
				</tr>
				<tr>
					<td>Department :</td>
					<td><form:input path="department" /></td>
				</tr>
				<tr>
					<td>Email ID :</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:input path="password" /></td>
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