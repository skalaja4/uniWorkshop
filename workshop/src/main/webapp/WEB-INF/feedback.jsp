<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%String message = request.getParameter("message"); %>
<html>
<head>
<title>Odezva</title>
</head>
<body>
	<div id="header">
		<%@ include file="menu.jspf"%>
	</div>
	<h2>Akce provedena</h2>
	<br>
	<%=message %>>

</body>
</html>
