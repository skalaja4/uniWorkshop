<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Properties"%>
<%@ page import="java.util.List"%>
<%@ page import="eu.unicorneducation.model.EmployeeModel"%>

<%
	Properties fill = (Properties) request.getAttribute("fill");
	Properties quest = (Properties) request.getAttribute("quest");
	String name =(String) request.getAttribute("plan_name");
	String date =(String) request.getAttribute("plan_date");
	String branch = (String) request.getAttribute("plan_branch");
	Long id = Long.valueOf( (String)request.getAttribute("plan_id"));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$(function() {
		    $( ".accordion" ).accordion({
		        collapsible: true,
		        clearStyle: true,
		        active: false,
		    })
		});
	});
</script>

<title><%=fill.get("pagetitle")%></title>
</head>
<body>
	<%@ include file="menu.jspf"%>
	<h2><%=branch%></h2>
	<h3><%=fill.get("title1")%>  <%=name%> <%=fill.get("title2")%> <%=date%></h3>
	<br>



	<form action="/workshop/">
		<input type="hidden" id="plan" value=<%=id%>>
		<%
			List<EmployeeModel> plans = (List<EmployeeModel>) request.getAttribute("plan_employees");
			for (int j = 1; j < plans.size(); j++) {
		%>
		<div class="accordion">		
			<h3><%=plans.get(j).getFirstName()+" "+plans.get(j).getLastName()%></h3>
			<div>
				<input type="hidden" id="employeeIds" value=<%=plans.get(j).getId()%>>	
				<%
					for (int i = 1; i < 10; i++) {
						String key = "q"+i;
				%>
				<br>
					<label>
						<%=quest.get(key)%>
					</label>
				<select id=<%=i%>>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>

				<%
					}
				%>
				<br>
				<textarea id="info" rows="4" cols="50"></textarea>
			</div>
		</div>
		<%
			}
		%>
		<br> <br> <input type="submit" value="Odeslat">
	</form>
</body>
</html>
