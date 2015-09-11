<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>

<title>Insert title here</title>
</head>
<body>
	<%@ include file="menu.jspf"%>
	<h3>Hodnocení z 15.02.2015 jménem Hodnocení1</h3>
	<br>


	<form action="/workshop/">
		<div id="accordion">
		<%
			for (int j = 1; j < 10; j++) {
		%>
		  <h3>Jaroslav Dvořák:</h3>
		  <div>
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
					}
				%>
				<br>
					<textarea rows="4" cols="50"></textarea>
			</div>
				<%
					}
				%>

		</div>
		<br> <br> <input type="submit" value="Odeslat">
	</form>
</body>
</html>