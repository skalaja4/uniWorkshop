<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<%@page import="eu.unicorneducation.model.EmployeeModel"%>
<%
	
	List<EmployeeModel> employees = (List)request.getAttribute("listofemployees");

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
<title>Employees of branch</title>
</head>
<body>
<%@ include file="menu.jspf" %>

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
 <% for(int i = 0; i < employees.size(); i++) { %>
            <tr>      
                <td>${employees.get(i).getFirstName()}</td>
                <td>${employees.get(i).getLastName()}</td>
                <td>${employees.get(i).getBirthDate()}</td>
                <td>${employees.get(i).getCategory()}</td>
                <td><form action="employee.jsp"><input type="submit" value="Detail"></form></td>  
            </tr>
        <% } %> 

 <!-- <% //for(int i = 0; i < 5; i++) { %>
            <tr>      
                <td>Petr</td>
                <td>Kupka</td>
                <td>1.1.1900</td>
                <td>NEW</td>
                <td><form action="http://localhost:8085/workshop/detail"><input type="submit" value="Detail"></form></td>  
            </tr>
        <% //} %> -->

</table>


</body>
</html>