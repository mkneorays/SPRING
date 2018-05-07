<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<html:html>
	<body bgcolor="458956">
		<html:form action="/login" method="get"> 
			<table>
				<tr>
					<td><bean:message key="login.EmpName"/></td>
					<td><html:text property="name"/></td>
				</tr>
				<tr>
					<td><bean:message key="login.EmpAge"/></td>
					<td><html:text property="age"/></td>
				</tr>
				<tr>
					<td><bean:message key="login.EmpAddress"/></td>
					<td><html:text property="address"/></td>
				</tr>
			</table>
			<html:submit property="method">submit</html:submit><br><br><br><br><br>
			<html:submit property="method">EmpDetails</html:submit>
			<%-- <html:submit property="method">update</html:submit> --%>
		</html:form>
	</body>
</html:html>