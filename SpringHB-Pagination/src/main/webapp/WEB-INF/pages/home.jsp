<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee page</title>
<title>Registration Form</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/emp_css.css"></link>
<script type="text/javascript" src="js/emp_js.js"></script>
</head>

<body>
	<a href="logout.htm"><button id="logout">LOGOUT</button> </a>
	<p>
		<b id="login">${insert}</b>
	</p>
	<a href="cred.htm"><button class="cred">LOGIN CREDENTIALS</button>
	</a>
	<br>
	<br>
	

	<form name="emp" action="insert.htm" onsubmit="return validate_form()"
		method="get">
		<b class="regd">Employee Registration</b>

		<table id="emplist" border="5">

               <!--  <tr>
                <th><b class="rd">Employee Registration</b></th>
                </tr> -->

			<tr>
				<td>Employee Name</td>

				<td><input type="text" name="ename" size="24"></td>
			</tr>
			<tr>
				<td>Employee Age</td>
				<td><input type="text" name="eage"
					onkeypress="return isNumberKey(event)" size="24"></td>
			</tr>
			<tr>
				<td>Address</td>

				<td><input type="text" name="address" size="24"></td>
			<tr>

				<td>Contact Number</td>
				<td><input type="text" onkeypress="return isNumberKey(event)"
					name="mobile" size="24" pattern="[0-9]{10}"></td>
			</tr>
			<tr>
				<td>Job Location</td>
				<td><select name="location">

						<option value="Chennai">Chennai</option>
						<option value="Bangalore" selected>Bangalore</option>
						<option value="Chennai">Pune</option>
						<option value="Bangalore">Mysore</option>
						<option value="Chennai">Chandigarh</option>

				</select></td>


			</tr>

			<tr>
				<td>Designation</td>
				<td><select name="designation">

						<option value="Systems Engineer">Systems Engineer</option>
						<option value="Senior Systems Engineer">Senior Systems
							Engineer</option>
						<option value="Technology Analyst">Technology Analyst</option>
						<option value="Technology Lead">Technology Lead</option>
						<option value="Project Manager" selected>Project Manager</option>


				</select></td>


			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" size="24"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="reset" value="  Reset All   " name="reset"></td>
			</tr>

		</table>
	</form>
	<a href="select.htm?pageNo=1"><button id="getEmp">Get Employee
			Details</button> </a>



</body>