<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<h1>Search!!!---2021211001001205YangJile</h1>
<form method="get" target="_blank" action="search">
	<input type="text" name="txt" size=30/>
	<select name="search">
		<option value="baidu">Baidu</option>
		<option value="bing">Bing</option>
		<option value="google">Google</option>
	</select>
	<input type="submit" value="Search"/>
</form>

<%@include file="footer.jsp"%>