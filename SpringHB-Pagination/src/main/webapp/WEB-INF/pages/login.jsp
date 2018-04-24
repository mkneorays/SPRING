<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title> Login Form</title>
      <%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css"> --%>
      <link  rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
 <h2 style="text-align: center;color: red"> ${data}<h2>
 <h2 style="text-align: center;color: red"> ${authorise}<h2>
  <div class="login-page">
  
  <div class="form">
    <form class="register-form" action="register.htm" method="get">
    <h6 style="text-align: center;color: red">CREATE ACCOUNT</h6>
      <input type="text" name="name" placeholder="name" required="required"/>
      <input type="text" name="psw" placeholder="password" required="required"/>
      <input type="email" name="email" placeholder="email address" required="required"/>
      <!-- <button>create</button> -->
      <input type="submit" value="CREATE"> 
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
    <form class="login-form" action="login.htm" method="get">
    <h6 style="text-align: center;color: red">LOGIN PAGE</h6>
      <input type="text" name="user" placeholder="USERNAME" required="required"/>
      <input type="text" name="psw" placeholder="PASSWORD" required="required"/>
      <!-- <button>login</button> -->
      <input type="submit" value="LOGIN"> 
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="js/index.js"></script>

</body>
</html>
