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
<h1 style="text-align: center; color: red">LOGIN CREDENTIALS LIST</h1>
<!-- for login credentails list -->
	<c:choose>
		<c:when test="${!empty loginList}">
			<table id="login" border="1" align="center">
				<tr>
					<th><font color="red">USERNAME </font></th>
					<th><font color="red">PASSWORD </font></th>
					<th><font color="red">EMAIL </font></th>
				</tr>

				<c:forEach var="dto" items="${loginList}">
					<tr>
						<td style="color: green;">${dto.name}</td>
						<td style="color: green;">${dto.psw}</td>
						<td style="color: green;">${dto.email}</td>
					</tr>

				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<b style="color: red"> RECORDS ARE NOT FOUND </b>
		</c:otherwise>
	</c:choose>

	<br>
	<br>
	<br>
	<br>
<a href="login.htm">home page</a>


</body>
</html>