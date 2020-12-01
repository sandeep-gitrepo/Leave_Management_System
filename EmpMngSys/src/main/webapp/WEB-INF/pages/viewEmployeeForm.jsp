<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 align="center">Employee Management System</h1>
<h2>Employees List</h2>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Salary</th>
		<th>Designation</th>
		<th>Department</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="emp" items="${empList}">
		<tr>
			<td>${emp.empId}</td>
			<td>${emp.empName}</td>
			<td>${emp.ctc}</td>
			<td>${emp.designation}</td>
			<td>${emp.department}</td>
			<td><a href="editEmpForm">Edit</a></td>
			<td><a href="<c:url value='/deleteEmpForm/${emp.empId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
</table>

<br />
<br />

<a href="addemp">Add New Employee</a>