<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import=" java.text.DateFormat"%>
<%@page import="eu.unicorneducation.model.BranchTreeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Integer size=(Integer) request.getAttribute("branches");

Properties prop = (Properties) request.getAttribute("properties");

%>

<html>
<head>
<title><%= prop.get("title") %></title>
</head>
<body>
	<div id="header">
		<%@ include file="menu.jspf"%>
		<h2><%= prop.get("strana") %></h2>
		
		<%for(int i=0;i<size;i++){ %>
<%= request.getAttribute("branche"+i) %>
<%} %>
</body>
</html>