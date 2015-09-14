<%@page import="eu.unicorneducation.model.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import=" java.text.DateFormat"%>
<%
	
	EmployeeModel emp = (EmployeeModel)request.getAttribute("employee");
	DateFormat format = new SimpleDateFormat("d.MM.yyyy");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>

</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee detail</title>
</head>
<body>
<%@ include file="menu.jspf" %>
<br>
<br>

<table border="1" cellpadding="5" width="600">
<tr>
<td width="120">Jméno :<br> <%= emp.getFirstName()%></td>
<td width="120">Příjmení: <br><%= emp.getLastName()%></td>
<td width="120">Datum narození : <br><%= format.format(emp.getBirthDate())%></td>
<td width="120">Kategorie : <br><%= emp.getCategory() %></td></tr>
</table>
<h2>Hodnocení</h2>
<br>
 Název hodnocení :   <br>
 <br>
<table border="1" cellpadding="5" width="600">
<tr>
<td width="160">Číslo otázky</td>
<td width="160">Hodnocení</td>

</tr>

           	<tr> <td> Otázka č.1</td> 
           <td>  </td> </tr>
            <tr> <td> Otázka č.2</td> 
           <td>  </td> </tr>
            <tr> <td> Otázka č.3</td> 
           <td>  </td> </tr>
            <tr> <td> Otázka č.4</td> 
           <td>  </td> </tr>
            <tr> <td> Otázka č.5</td> 
           <td>  </td> </tr>
            <tr> <td> Otázka č.6</td> 
           <td>  </td> </tr>
            <tr> <td> Otázka č.7</td> 
           <td>  </td> </tr>
            <tr> <td> Otázka č.8</td> 
           <td>  </td> </tr>
            <tr> <td> Otázka č.9</td> 
           <td>  </td> </tr>
            <tr> <td> Otázka č.10</td> 
           <td>  </td> </tr>
           
     
</table>





</body>
</html>