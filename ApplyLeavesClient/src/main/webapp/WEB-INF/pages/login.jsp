<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome</title>
<style>
.errorblock {
 color: #ff0000;
 background-color: #ffEEEE;
 border: 3px solid #ff0000;
 padding: 8px;
 margin: 16px;
}
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body onload='document.f.j_username.focus();'>
	<div class="container">
		<br />
		<h1 align="center">Welcome to ApplyLeavesClient Application</h1>
		<br />
		<br />
		<h2 id="article_header" class="text-warning" align="center"></h2>

<c:if test="${not empty error}">
  <div class="errorblock">
   Your login attempt was not successful, try again.<br /> Caused :
   ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
  </div>
 </c:if>
 
		<form:form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
			<table>
   <tr>
    <td>User:</td>
    <td><input type='text' name='j_email' value='' />
    </td>
   </tr>
   <tr>
    <td>Password:</td>
    <td><input type='password' name='j_password' />
    </td>
   </tr>
   <tr>
    <td colspan='2'><input name="submit" type="submit"
     value="submit" />
    </td>
   </tr>
   <tr>
    <td colspan='2'><input name="reset" type="reset" />
    </td>
   </tr>
  </table>
		</form:form>
	</div>
</body>
</html>