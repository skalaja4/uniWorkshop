<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import=" java.text.DateFormat"%>

<%@page import="eu.unicorneducation.model.EmployeeModel"%>
<%
	
	List<EmployeeModel> employees = (List)request.getAttribute("listofemployees");
	DateFormat format = new SimpleDateFormat("d.MM.yyyy");
	String branchid = (String)request.getAttribute("branchid");
	String lastn = (String)request.getAttribute("lastname");
	List<EmployeeModel> employeesfound = new ArrayList<>();
	
	
	
	if(lastn != null)
	{
		for(EmployeeModel e : employees)
		{
			if(e.getLastName().equals(lastn)){
				
				employeesfound.add(e);
				
			}
			
		}
		
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
<title>Employees of specific branch</title>
</head>
<body>
<%@ include file="menu.jspf" %>

<br>
<br>

<form  method="get" action="/workshop/employees">

Vyhledávání : <input type=text name=lastname value="Příjmení"></input>
 
<%
String last=request.getParameter("lastname");
%>
<input type="submit" value="Potvrdit">
<a href="/workshop/employeefinder?lastname=<%=lastn%>"><button>Vyhledat</button></a>
<br>
<br>
</form>
<table border="1" cellpadding="5" width="800">
<tr>
<td width="200">Jméno</td>
<td width="200">Příjmení</td>
<td width="200">Datum narození</td>
<td width="200">Kategorie</td>
<td width="50">Detail zaměstnance</td>
</tr>

<% 
if(employeesfound.size()>0){
	for(EmployeeModel e : employeesfound) { %>
    <tr> <td> <%= e.getFirstName()%></td> 
    <td> <%= e.getLastName()%> </td> 
    <td> <%= format.format(e.getBirthDate())%> </td>
    <td> <%= e.getCategory()%> </td>
    

    
     <td> <a href="/workshop/detail?id=<%=(e.getId())%>"><button>Detail</button></a></td>
    
    </tr>
 <% }}
	else{


for(EmployeeModel e : employees) { %>
           <tr> <td> <%= e.getFirstName()%></td> 
           <td> <%= e.getLastName()%> </td> 
           <td> <%= format.format(e.getBirthDate())%> </td>
           <td> <%= e.getCategory()%> </td>
           
   
           
            <td> <a href="/workshop/detail?id=<%=(e.getId())%>"><button>Detail</button></a></td>
           
           </tr>
        <% }} %>










 



</table>


</body>
</html>