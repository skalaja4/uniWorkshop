<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="menu.jspf"%>
	<h3>Hodnocení z 15.02.2015 jménem Hodnocení1</h3>
	<br>


	<form action="/workshop/">
	<%
			for (int j = 1; j < 10; j++) {
		%>
		<br>
		<br>
		Jaroslav Dvořák:
		<%
			for (int i = 1; i < 10; i++) {
		%>
		<br>
		Otazka<%=i %>
		<select>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>
		<%
			}}
		%>
		<br> <br> <input type="submit" value="Odeslat">
	</form>
</body>
</html>