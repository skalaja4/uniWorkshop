<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import=" java.text.DateFormat"%>

<%@page import="eu.unicorneducation.model.EmployeeModel"%>
<%
	
	List<EmployeeModel> employees = (List)request.getAttribute("listofemployees");
	DateFormat format = new SimpleDateFormat("d.MM.yyyy");
	List<EmployeeModel> employeesfound = new ArrayList<>();
	String last = (String)request.getAttribute("lastName");
			
	for(EmployeeModel e : employees) {
		if(e.getLastName().equals(last))
		{
			employeesfound.add(e);
			
		}
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% for(EmployeeModel e : employeesfound) { %>
           <tr> <td> <%= e.getFirstName()%></td> 
           <td> <%= e.getLastName()%> </td> 
           <td> <%= format.format(e.getBirthDate())%> </td>
           <td> <%= e.getCategory()%> </td>
           
   
           
            <td> <a href="/workshop/detail?id=<%=(e.getId())%>"><button>Detail</button></a></td>
           
           </tr>
        <% } %>

</body>
</html>