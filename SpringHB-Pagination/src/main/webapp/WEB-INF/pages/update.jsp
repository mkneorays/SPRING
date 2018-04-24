<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1 style="text-align: center; color: red">EMPLOYEE UPDATE PAGE</h1>
   
	    <c:choose>
	<c:when test="${!empty EmployeeList }">
		<table border="2" align="center">

			<tr style="te">
				<th><font color="red">EMP_ID</font></th>
				<th><font color="red">NAME</font></th>
				<th><font color="red">ADDRESS</font></th>
				<th><font color="red">DESIGNATION</font></th>
				<th><font color="red">AGE</font></th>
				<th><font color="red">EMAIL</font></th>
				<th><font color="red">LOCATION</font></th>
				<th><font color="red">MOBILE</font></th>
				
			</tr>
                
                <c:if test="${!empty EmployeeList}">
                <tr>
					<td  style="color:green;">${ EmployeeList[0].eid }</td>
					<td  style="color:green;">${EmployeeList[0].ename }</td>
					<td  style="color:green;">${EmployeeList[0].address}</td>
					<td  style="color:green;">${EmployeeList[0].designation}</td>
					<td  style="color:green;">${EmployeeList[0].eage}</td>
					<td  style="color:green;">${EmployeeList[0].email}</td>
					<td  style="color:green;">${EmployeeList[0].location}</td>
					<td  style="color:green;">${EmployeeList[0].mobile}</td>
			</tr>	
			</c:if>
			<%-- <c:forEach var="emp" items="${EmployeeList }">
				<tr>
					<td  style="color:green;">${emp.eid }</td>
					<td  style="color:green;">${emp.ename }</td>
					<td  style="color:green;">${emp.address}</td>
					<td  style="color:green;">${emp.designation}</td>
					<td  style="color:green;">${emp.eage}</td>
					<td  style="color:green;">${emp.email}</td>
					<td  style="color:green;">${emp.location}</td>
					<td  style="color:green;">${emp.mobile}</td>
					<td ><a href="update.htm?eid=${emp.eid}&name=${emp.ename}&add=${emp.address}" style="color:blue;">update</a></td>
					<td><a href="delete.htm?eid=${emp.eid}" style="color:red;">delete</a></td>
					
						</tr>	
			</c:forEach> --%>
		</table>
	</c:when>
	<c:otherwise>
   DATA NOT FOUND
   </c:otherwise>
     </c:choose> 
 FFF==  ${id} <br>
	<br>
  RRR=${eeid}
	<br>
	<br>
	<br>
	<br>
	
</body>
</html>


<a href="login.htm">home page</a>

