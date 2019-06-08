<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<meta name="viewport" content="width=device-width, initial-scale=1">


<style>
 
 body
 {
 background-color: silver;
 }
 
.topnav {
  overflow: hidden;
  background-color:black;
}

.topnav a {
  float: left;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: orange;
  color: black;
}

.topnav a.active {
  background-color: green;
  color: white;
}		
.error {
	        color: red;
          }
</style>

 <style>
.error {
color: red;

}
</style> 
<title>${title}</title>
</head>
<body>

<!-- nav bar -->

<div class="topnav">
  <a class="active" href="${contextPath}/home">Home</a>
  <a href="${contextPath}/regform">New Employee Registration</a>
  <a href="${contextPath}/listofemp">List Of Employee</a>
</div>


<!-- page content -->


	<h2 style="color: purple;" align="center">ALL EMPLOYEES INFORMATION</h2>
	
	<c:if test="${UserClickForm==true}">

		<%@include file="regform.jsp"%>

	</c:if>
	<c:if test="${UserClickEmployeeList==true}">

		<%@include file="emplist.jsp"%>

	</c:if>
     <c:if test="${UserClickModifyEmployee==true}">

	<%@include file="updateform.jsp"%>

	</c:if> 
	
	<c:if test="${UserClickDeleteEmployee==true}">

	<%@include file="updateform.jsp"%>

	</c:if>
	
	<c:if test="${UserClickEditEmployee==true}">

		<%@include file="updateform.jsp"%>

	</c:if>
	<c:if test="${UserClickModifyForm==true}">

		<%@include file="updateform.jsp"%>

	</c:if>
	
	
	<h1 style="color: blue;">${success}</h1>
    <h1 style="color: teal;">${autoid}</h1>
     <h1 style="color: teal;">${iderror}</h1>
    

</body>
</html>