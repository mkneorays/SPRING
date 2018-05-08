<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/stylesheet.css">
<title>edite page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="image/back2.jpg">
<div class="editbox">


<form action="update" metod="post">
 
 <h3 style="color: white; text-align:center;">Edit User Here</h3> 
 <br><br>
<input type="hidden" name="id" value="${userData.userId }">
 
<br><br>
<p>Enter New Name</p>
<input type="text" name="name" class="form-control" paleceholder="enter new name">
<br><br>
<p>Enter New Password</p>
<input type="password" name="pass" class="form-control" placeholder="enter new password"> 
<br><br>

<!-- <input type="button" class="btn btn-success" value="SAVE"> -->
 <button type="submit" class="btn btn-success" >SAVE</button>
<a href="select" class="btn btn-danger" style="float: right;">Cancel</a></td>
 </form>
</div>

</body>
</html>