<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<form method="get" action="login">
		<table align="center">
			<caption>Login</caption>
			<%
				if(!(request.getAttribute("msg")==null)){
					out.print(request.getAttribute("msg"));
				}
			%>
			<tr>
				<td>user：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>password：</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td><input type="submit" value="login"></td>
				<td><input type="reset" value="reset"></td>
			</tr>

		</table>
	</form>
	<%@include file="footer.jsp"%>
</body>
</html>