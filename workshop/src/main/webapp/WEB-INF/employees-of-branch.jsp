<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import=" java.text.DateFormat"%>

<%@page import="eu.unicorneducation.model.EmployeeModel"%>
<%
	
	
	String id = request.getParameter("branchid");
	List<EmployeeModel> employees = (List)request.getAttribute("listofemployees");
	Properties prop = (Properties) request.getAttribute("properties");
	DateFormat format = new SimpleDateFormat("d.MM.yyyy");
		String lastn = (String)request.getAttribute("lastname");
		String branchid = "";
		if(!employees.isEmpty())
		{
			branchid = employees.get(0).getBranch().getId();
			
		}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
table {
    text-align: center;
    color: maroon;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= prop.get("title") %></title>
</head>
<body>
<%@ include file="menu.jspf" %>
<h2><%= prop.get("employees") %></h2>
<br>
<br>

<form  method="post" action="/workshop/employees">

<%= prop.get("enterNameOrSurname") %> :
 <input type=text name=lastname value=""></input>
 <input type="hidden" name="branchid" value=<%= branchid %>>
<input type="submit" value="Vyhledat">

<br>
<br>
</form>
<table border="1" cellpadding="5" width="800">
<tr>
<td width="200"><%= prop.get("name") %></td>
<td width="200"><%= prop.get("surname") %></td>
<td width="200"><%= prop.get("birthDate") %></td>
<td width="200"><%= prop.get("category") %></td>
<td width="50"><%= prop.get("detail") %></td>
</tr>

<%
	for(EmployeeModel e : employees) { %>
    <tr> <td> <%= e.getFirstName()%></td> 
    <td> <%= e.getLastName()%> </td> 
    <td> <%= format.format(e.getBirthDate())%> </td>
    <td> <%= e.getCategory()%> </td>
    

    
     <td> <a href="/workshop/detail?id=<%=(e.getId())%>"><button><%= prop.get("smallDetail") %></button></a></td>
    
    </tr>
 <% } %>


</table>


</body>
</html>
