<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.error {
	color: red;
}

    .required input:after 
    { 
    content:"*";
     }

</style>
<title>${title}</title>
</head>
<body>
	<h2 style="color:teal;">Employee Registration</h2>



	<springform:form action="${contextPath}/regformsubmit" method="post" commandName="employee" enctype="multipart/form-data">

		<table>
			<tr>
				<td><springform:label path="id" >Employee Id : </springform:label></td>
				<td><springform:input path="id" /></td>
				<td><springform:errors path="id" cssClass="error" /></td>
			</tr>
			<tr>
			
				<td><springform:label path="name" class="required">Employee Name: <span style="color:red">*</span></springform:label></td>
				<td><springform:input path="name" /></td>
				<td><springform:errors path="name" cssClass="error" /></td>
				
			</tr>

			<tr>
				<td><springform:label path="dob">Employee D.O.B: <span style="color:red">*</span></springform:label></td>
				<td><springform:input type="date" path="dob"></springform:input></td>
				<td><font color="red"><springform:errors path="dob"></springform:errors></font></td>
			</tr>
			<tr>
				<td><springform:label path="qualification">Employee Qualification : <span style="color:red">*</span></springform:label></td>
				<td><springform:select path="qualification">
						<springform:option value="btech">B.Tech</springform:option>
						<springform:option value="bsc">B.Sc</springform:option>
						<springform:option value="mca">M.C.A</springform:option>
						<springform:option value="mtech">M.Tech</springform:option>
						</springform:select></td>
					<td><springform:errors path="qualification" cssClass="error"></springform:errors></td>
					
			</tr>
			<tr>
				<td><springform:label path="salary">Employee SALARY : <span style="color:red">*</span></springform:label></td>
				<td><springform:input path="salary" /></td>
				<td><springform:errors path="salary" cssClass="error"></springform:errors></td>
			</tr>
			<tr>
				<td><springform:label path="address">Employee ADDRESS : <span style="color:red">*</span></springform:label></td>
				<td><springform:input path="address" /></td>
				<td><springform:errors path="address" cssClass="error"></springform:errors></td>
			</tr>
			
				<tr>
				<td><springform:label path="pic">Employee Pic : <span style="color:red">*</span></springform:label></td>
				 <td><input type="file" name="file" id="file" /></td>
				
                    <c:out value = "${codeError}" />            
    				
			</tr>
		<tr>
				<td><springform:label path="getpic" ></springform:label></td>
				<td><springform:input path="getpic" type="hidden" /></td>
				
			</tr>
			 
			
			
			
<tr>
				<td>Please Fill Mandatory ( <span style="color:red">*</span>)Symbol Fields</td>
</tr>

			<tr>
				<td><input type='submit' value='Submit' /></td>
			</tr>
		</table>
	</springform:form>

</body>
</html>