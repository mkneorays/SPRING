<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>

<script type="text/javascript">
 function validateForm(){
	 if(document.myForm.userId.value==""){
		 alert("UserId cannot be empty");
		 return false;
	 }	 
	 if(document.myForm.name.value==""){
		 alert("Name cannot be empty");
		 return false;
	 }	 	 
	 if(document.myForm.pass.value==""){
		 alert("Password cannot be empty");
		 return false;
	 }	 
	 
 }
</script>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="image/back2.jpg">
	<h3 style="color: white; text-align: center;">Welcome to Users Page</h3>
	<div class="loginbox">
	<br><br>
		<form action="usersave" method="post" name="myForm" onsubmit=" return validateForm()" >
			<p>UserId</p>
			<input type="text" name="userId" class="form-control"  style="width: 320px"><br>
			<p>Name</p>
			<input type="text" name="name" class="form-control"  style="width: 320px"><br>
			<p>Password</p>
			<input type="password" name="pass" class="form-control"  style="width: 320px"> <br>
			<br>
			<button type="submit" class="btn btn-success">Add</button>
			<button type="reset" class="btn bnt-info" style="float: right;">reset</button>
		</form>

	
<br><br>
   <a href="select" class="btn btn-info">Get All Details</a>
   	</div>

</body>
</html>