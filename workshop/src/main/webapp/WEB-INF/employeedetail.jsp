<%@page import="eu.unicorneducation.model.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import=" java.text.DateFormat"%>
<%@page import=" java.util.List"%>
<%@page import="eu.unicorneducation.model.EvaluationModel"%>
<%
	List<EvaluationModel> evList = (List)request.getAttribute("evList");
	EmployeeModel emp = (EmployeeModel)request.getAttribute("employee");
	DateFormat format = new SimpleDateFormat("d.MM.yyyy");
	String branches =(String) request.getAttribute("branches");
	
	Properties prop = (Properties) request.getAttribute("properties");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>

</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= prop.get("title") %></title>
</head>
<body>
<%@ include file="menu.jspf" %>
<h2><%= prop.get("title") %></h2>
<br>
<br>
<%=branches %>
<table border="1" cellpadding="5" width="600">
<tr>
<td width="120"><%= prop.get("name") %> :<br> <%= emp.getFirstName()%></td>
<td width="120"><%= prop.get("surname") %>: <br><%= emp.getLastName()%></td>
<td width="120"><%= prop.get("birthDate") %> : <br><%= format.format(emp.getBirthDate())%></td>
<td width="120"><%= prop.get("category") %> : <br><%= emp.getCategory() %></td></tr>
</table>
<h2><%= prop.get("evaluation") %></h2>
<br>



<% for(EvaluationModel e : evList) { %>
<br>

 <h3><%= prop.get("nameOfEva") %> : <i> <%= e.getName() %></i> </h3>

<table border="1" cellpadding="5" width="600">
<tr>
<td width="160"><%= prop.get("question") %></td>
<td width="160"><%= prop.get("evaluation") %></td>

</tr>

           	<tr> <td>  Jakou známkou byste ohodnotil/a komunikační dovednosti poradce?</td> 
           <td> <%= e.getQuestion1()%> </td> </tr>
            <tr> <td> Jak byste ohodnotil/a pořádek na pracovišti poradce?</td> 
           <td> <%= e.getQuestion2() %></td> </tr>
            <tr> <td>  Jak byste ohodnotil/a schopnost poradce pracovat v týmu?</td> 
           <td> <%= e.getQuestion3() %> </td> </tr>
            <tr> <td>  Jak byste ohodnotil/a schopnost poradce zvládat stres?</td> 
           <td> <%= e.getQuestion4() %> </td> </tr>
            <tr> <td> Jak byste ohodnotil/a schopnost poradce si efektivně organizovat práci(schůzky, telefony s klienty, atd.)?</td> 
           <td> <%= e.getQuestion5() %> </td> </tr>
            <tr> <td> Jak byste ohodnotil/a znalost angličtiny poradce?</td> 
           <td> <%= e.getQuestion6() %> </td> </tr>
            <tr> <td> Jakou známku dostal poradce z testu „Znalost produktů“?</td> 
           <td> <%= e.getQuestion7() %>  </td> </tr>
            <tr> <td> Jakou známku dostal poradce z testu „Znalost IS“?</td> 
           <td> <%= e.getQuestion8() %> </td> </tr>
            <tr> <td> Jakou známkou byste ohodnotila schopnost se učit a dále se rozvíjet?</td> 
           <td> <%= e.getQuestion9() %> </td> </tr>
            <tr> <td>Poznámka: (jak bylo řečeno na konzultacích – zde můžeme zadávat libovolný text)</td> 
           <td> <%= e.getQuestion10() %> </td> </tr>
           
     
</table>

 <% } %>
<form action="/workshop/exportPdf">
<input type="hidden" name="id" value="<%=emp.getId() %>">
<input type="submit" name="exportPdf" value="Exportovat do PDF">
</form>


</body>
</html>