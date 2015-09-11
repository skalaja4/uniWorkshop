<%@ page import="java.util.Properties" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Properties prop = (Properties) request.getAttribute("properties");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicializace BAES</title>
</head>
<body>
	<%@ include file="menu.jspf"%>

	<form action="/workshop/inicialization"  method="post">
		<p>
			<%= prop.getProperty("enterEmployees") %><br>
			<input type="file" name="branchfile" size="40">
		</p>
		<div>
			<input type="submit" value="Importovat pobočky">
		</div>
	</form>
	<hr>
	<form action="/workshop/inicialization"  method="post">
		<p>
			Vložte soubor se zaměstnanci:<br> <input type="file"
				name="employeesfile" size="40">
		</p>
		<div>
			<input type="submit" value="Importovat zákazníky">
		</div>
	</form>

</body>
</html>