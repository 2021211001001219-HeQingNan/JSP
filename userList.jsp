
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@page import="java.sql.ResultSet"%>
<h1>User List</h1>
<table border=1>
	<tr><td>ID</td><td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td></tr>
	<%
		ResultSet rs=(ResultSet) request.getAttribute("rsname");
	if(rs==null){
		
	
	%>
	
	<tr>
		<td>No Data</td>
	</tr>
	<%}else{
	    while(rs.next()) {
    	out.write("<tr>");
    	out.write("<td>"+rs.getString("id")+"</td>");
    	out.write("<td>"+rs.getString("UserName")+"</td>");
    	out.write("<td>"+rs.getString("PASSWORD")+"</td>");
    	out.write("<td>"+rs.getString("Email")+"</td>");
    	out.write("<td>"+rs.getString("Gender")+"</td>");
    	out.write("<td>"+rs.getString("Birthdate")+"</td>");
    	out.write("</tr>");
		}
	}
	%>
</table>

<%@include file="footer.jsp"%>