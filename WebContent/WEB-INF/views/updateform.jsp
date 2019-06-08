<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>

<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h2 style="color: purple;">MODIFY Employee Data</h2>
	<form action="${contextPath}/updatesubmit" method="get" >



	<table>
			<tr>
				<td>Employee Id : </td>
				<td><input name="id" value="${employee.id}" readonly="readonly"/></td>
			
			</tr>
	<%-- 	<tr>
			
				<td>Employee Name: </td>
				<td><input name="name" value="${employee.name}"/></td>
			
				
			</tr>
 --%>
		<%-- 	<tr>
				<td>Employee D.O.B: </td>
				<td><input type="date" name="dob" value="${employee.dob}"></td>
			
			</tr> --%>
		<%-- 	<tr>
				<td>Employee Qualification : </td>
				<td><select name="qualification">
						<option value="${employee.qualification}">B.Tech</option>
						<option value="${employee.qualification}">B.Sc</option>
						<option value="${employee.qualification}">M.C.A</option>
						<option value="${employee.qualification}">M.Tech</option>
						</select></td>
					
					
			</tr>  --%>
			<tr>
				<td>Employee SALARY : </td>
				<td><input name="salary" value="${employee.salary}"/></td>
			
			</tr>
			 <tr>
				<td>Employee ADDRESS : </td>
				<td><input name="address" value="${employee.address}" /></td>
			
			</tr>
			
				<%-- <tr>
				<td>Employee Pic : </td>
				 <td><input type="hidden" name="pic" value="${employee.pic}"/></td>
				
			</tr> --%>
	      <%-- 	<tr>
			
				<td><input name="getpic" type="hidden" value="${employee.getpic}"/></td>
			</tr>  --%>
	
			<tr>
				<td><input type='submit' value='Submit' /></td>
			</tr>
		</table>

	</form>


	<c:if test="${!empty employees}">
		<h2>List Employees</h2>
		<table draggable="true" border="1">
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee DOB</th>
				<th>Employee Qualification</th>
				<th>Employee Salary</th>
				<th>Employee Address</th>
				<th style="background: red">MODIFICATIONS HERE</th>
			</tr>

			<c:forEach items="${employees}" var="employee">
				<tr>
					<td><c:out value="${employee.id}" /></td>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.dob}" /></td>
					<td><c:out value="${employee.qualification}" /></td>
					<td><c:out value="${employee.salary}" /></td>
					<td><c:out value="${employee.address}" /></td>
					<td align="center"><a
						href="${contextPath}/edit/${employee.id}">Edit</a> | <a
						href="${contextPath}/delete/${employee.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<div>
		<br>
		<h1 style="color: green;">${updatesuccess}</h1>
	</div>