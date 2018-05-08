<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@page session="false" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login Page</title>
<link type="text/css" rel="stylesheet" href="css/stylesheet.css">
<script type="text/javascript" src="./js/valid.js">

<script type="text/javascript">
/* function validateForm(){
	
	if(document.myForm.userId.value == "")
	{
	  alert("UserId cannot be left blank please pass some value!");
       return false;
	}//if
if(document.myForm.pass.value == "")
	{
	  alert(" Password cannot be left blank please pass some value!");
       return false;
	}//if
} */
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body background="image/back2.jpg">
<div class="loginbox">
<img src="image/img.png" >
<h3 style="text-align: center;"> Login Here</h3>
<br>



<form  name="myForm" action="login" method="post" onsubmit="return validateForm()">
<p>UserId</p>
<input type="text" name="userId" style="width: 320px" placeholder="userId atleast 6 characters" class="form-control"><span style="text-align: right;color: red" id="nameloc"></span> <b style="text-align: right;color: red"> ${user_error}</b>
<br><br>
<p>Password</p>
<input type="password" name="pass" style="width: 320px" placeholder="password atleast 6 characters" class="form-control"><span style="text-align: right;color: red" id="passloc"></span> <b style="text-align: right;color: red"> ${psw_error}</b>
<br><br>
<button type="submit" class="btn btn-success">login</button>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset" class="btn btn-success">reset</button>
</form>


</div>
<h4 style="color: white;">${message}</h4>
</body>
</html>