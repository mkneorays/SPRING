<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>springMVC ajax</title>

<style type="text/css">
body {
	background-image:
		url('https://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>

<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
   var myVar;

   function myFunction(){
	   //alert("hiii");
	myVar = setInterval(ajaxFun, 3000);
  }

    function ajaxFun() {
    //alert("ajex call")
        $.ajax({
            url : '/SpringMVC-JQueryAjax-DateInterval/second.htm',
            success : function(data) {
                $('#result').html(data);
            }
        });
    }//function
</script>


</head>
<body>
	<h1 style="text-align: center; color: red">HOME PAGE</h1>
</head>

<body>

	<div align="center">
		<br> <br>
		<button onclick="myFunction()">click me</button>
		<br> <br>
		<div id="result"></div>
		<br>
		<p>
			by <a href="https://google.com">google.com</a>
		</p>
	</div>

</body>
</html>