<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
	<h1 style="text-align: center; color: red">EMPLOYEE LIST DETAILS</h1>

	    <c:choose>
	<c:when test="${!empty empList }">
		<table border="2" align="center">

			<tr style="te">
				<th><font color="red">EMP_ID</font></th>
				<th><font color="red">NAME</font></th>
				<th><font color="red">JOB</font></th>
				<th><font color="red">MGR</font></th>
				<th><font color="red">HIREDATE</font></th>
				<th><font color="red">SALARY</font></th>
				<th><font color="red">COMM</font></th>
				<th><font color="red">dEPT_ID</font></th>
			</tr>

			<c:forEach var="emp" items="${empList }">
				<tr style="color:green;">
					<td>${emp.empId }</td>
					<td>${emp.name }</td>
					<td>${emp.job }</td>
					<td>${emp.mgr }</td>
					<td>${emp.hiredate }</td>
					<td>${emp.sal }</td>
					<td>${emp.comm }</td>
					<td>${emp.deptId }</td>
						</tr>
				
			</c:forEach>
		

		</table>
	</c:when>
	<c:otherwise>
   DATA NOT FOUND
   </c:otherwise>
     </c:choose> 


	<br>
	<br>
	<br>
	<br>
	<a href="jsp/home.jsp">home page</a>

</body>
</html>