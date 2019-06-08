<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
<style type="text/css">
		.error {
	        color: red;
            }
		</style>
</head>
<body>

<h1>Employees List</h1>
<div>
<a style="color: green;" href="${contextPath}/modifyemployee">MODIFY EMPLOYEE DETAILS</a>
</div>
<table align="left" border="1">

		<tr>
		    <th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee DOB</th>
			<th>Employee Qualification</th>
			<th>Employee Salary</th>
			<th>Employee Address</th>
			<th>Employee ProfilePic</th>
			
			
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
		    	<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.dob}</td>
				<td>${employee.qualification}</td>
				<td>${employee.salary}</td>
				<td>${employee.address}</td>
				<td><img src="data:image/jpeg;base64,${employee.getpic}" width="150px" height="150px"></td> 
		
			</tr>
		
	
</c:forEach>



</table>



</body>
</html>