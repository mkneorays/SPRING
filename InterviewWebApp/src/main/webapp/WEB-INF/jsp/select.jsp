<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@page session="false" %>
    
    <%@page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show all user page</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h1 style="text-align: center; color: cyan;">All Users  Details</h1>
    <div class="row">
		<div class="col-md-4"><button class="btn btn-danger">CRUD OPERATIONS</button></div>
		
		<div class="col-md-4">
		<form action="search" method="post" class="form-inline">
		<input type="text" name="s" class="form-control"  placeholder="Search here" style="width: 320px;">
		<button type="submit" class=" btn btn-info btn-sm">search</button>
		</form></div>
		
		<div class="col-md-4"><a href="addnewuser" class="btn btn-success" style="float: right;">
		Add New User</a></div>
		<br><br><br>    
    
    
    </div>
    
    
    <c:choose>
      <c:when test="${!empty list_users}">
        <table class="table table-bordered">
        <thead>
          <tr><th>USER_ID</th> <th>NAME</th> <th>PASSWORD</th><th>OPERATIONS</th></tr>
          </thead>
        
           <c:forEach var="us" items="${list_users }">
           <tr>
           <td>${us.userId}</td>
           <td>${us.name }</td>
           <td>${us.pass}</td>
           <th><a href="edit?user_id=${us.userId}" class="btn btn-primary">Edit</a>
                <a href="delete?user_id=${us.userId}" class="btn btn-danger">Delete</a>
           </th>
           </tr>
           
           </c:forEach>
        
        </table>
      </c:when>
    
    
    <c:otherwise> 
       DATA NOT FOUND
    </c:otherwise>
    </c:choose>
    
    <br><br><br><br><br>
    
       <a href="Logout" class="btn btn-info">Logout</a>
    
</body>
</html>