<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: red; text-align: center">Select files to upload</h1>

<form:form method="POST" enctype="multipart/form-data"
	commandName="uploadCmd">
 Select File1:: <input type="file" name="file1">
	<br>
 Select File2:: <input type="file" name="file2">
	<br>
	<input type="submit" value="upload">
</form:form>


