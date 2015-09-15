<%@ page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%
	Properties prop = (Properties) request.getAttribute("properties");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= prop.get("title") %></title>
</head>
<body>
	<%@ include file="menu.jspf"%>
	<h2><%= prop.get("addEmpl") %></h2>

	<sf:form action="/workshop/inicializate_branches" method="post"
		enctype="multipart/form-data">
		<p>
			<%= prop.get("enterEmployees") %><br>
			<input type="file" name="file" size="40">
		</p>
		<div>
			<input type="submit" value="<%= prop.get("submitEmployees") %>">
		</div>
	</sf:form>

</body>
</html>