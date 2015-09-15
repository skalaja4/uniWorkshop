<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import=" java.text.DateFormat"%>

<%@page import="eu.unicorneducation.model.EmployeeModel"%>
<%
	
	List<EmployeeModel> employees = (List)request.getAttribute("listofemployees");
	DateFormat format = new SimpleDateFormat("d.MM.yyyy");
	String branchid = (String)request.getAttribute("branchid");
	

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
<title>Employees of specific branch</title>
</head>
<body>
<%@ include file="menu.jspf" %>

<br>
<br>

Vyhledávání : <input type=text name=lastName value="Příjmení"></input>
  <%
        String last = request.getParameter("lastName");
  		
 
  %>





<a href="/workshop/employees?branchid=<%= branchid %>&lastname=<%= last %>"><button>Vyhledat</button></a>
<br>
<br>
<table border="1" cellpadding="5" width="800">
<tr>
<td width="200">Jméno</td>
<td width="200">Příjmení</td>
<td width="200">Datum narození</td>
<td width="200">Kategorie</td>
<td width="50">Detail zaměstnance</td>
</tr>

<% for(EmployeeModel e : employees) { %>
           <tr> <td> <%= e.getFirstName()%></td> 
           <td> <%= e.getLastName()%> </td> 
           <td> <%= format.format(e.getBirthDate())%> </td>
           <td> <%= e.getCategory()%> </td>
           
   
           
            <td> <a href="/workshop/detail?id=<%=(e.getId())%>"><button>Detail</button></a></td>
           
           </tr>
        <% } %>










 



</table>


</body>
</html>