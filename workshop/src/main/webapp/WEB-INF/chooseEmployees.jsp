<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="eu.unicorneducation.model.EmployeeModel"%>

<%
	List<EmployeeModel> selectedEmployees = (List) request.getAttribute("selectedEmployee");
	List<EmployeeModel> unselectedEmployees = (List) request.getAttribute("unselectedEmployee");
	String branch = (String) request.getAttribute("branch");
	String date = (String) request.getAttribute("datepicker");
	String name = (String) request.getAttribute("name");
	Properties prop = (Properties) request.getAttribute("properties");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= prop.get("titel") %></title>
</head>
<body>
	<%@ include file="menu.jspf"%>
	<h2><%= prop.get("strana") %></h2>

	<form ACTION="/workshop/chooseEmployees" method=POST>

		<h3>
			<%= prop.get("nameOfPlan") %>
			<%=name%>
			<br> <%= prop.get("branch") %>:
			<%=branch%>
			<br><%= prop.get("date") %>:
			<%=date%>
		</h3>
<input type="hidden" name="name" value=<%=name%>>
<input type="hidden" name="branch" value=<%=branch%>>
<input type="hidden" name="datepicker" value=<%=date%>>
		<table border="1" cellpadding="5" width="800">
			<tr>
				<td width="200"><%= prop.get("name") %></td>
				<td width="200"><%= prop.get("surname") %></td>
				<td width="200"><%= prop.get("birthDate") %></td>
				<td width="200"><%= prop.get("category") %></td>
				<td width="50"><%= prop.get("chosen") %></td>
			</tr>

			<%
				for (EmployeeModel e : selectedEmployees) {
			%>
			<tr>
				<td><%=e.getFirstName()%></td>
				<td><%=e.getLastName()%></td>
				<td><%=e.getBirthDate()%></td>
				<td><%=e.getCategory()%></td>
				<td><input type="checkbox" name="id" value=<%=e.getId()%>
					checked><BR></td>
			</tr>
			<%
				}
			%>
			<%
				for (EmployeeModel e : unselectedEmployees) {
			%>
			<tr>
				<td><%=e.getFirstName()%></td>
				<td><%=e.getLastName()%></td>
				<td><%=e.getBirthDate()%></td>
				<td><%=e.getCategory()%></td>
				<td><input type="checkbox" name="id" value=<%=e.getId()%>><BR></td>
			</tr>
			<%
				}
			%>


		</table>
		<br> <input type="submit" value="Odeslat">
	</form>
	

</body>
</html>