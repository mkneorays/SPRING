<%@ page import="java.sql.*" %>

<%
response.setContentType("text/xml");
//read form data
int no=Integer.parseInt(request.getParameter("dno"));
//write jdbc code
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select ename from emp where deptno="+no);

out.println("<emp>");
 while(rs.next())
 {
  out.println("<ename>"+rs.getString(1)+" </ename>");
 }
out.println("</emp>");
con.close();
%>