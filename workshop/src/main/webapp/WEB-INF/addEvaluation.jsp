<%@page import="java.text.DateFormat"%>
<%@ page import="java.util.List"%>
<%@ page import="eu.unicorneducation.model.BranchModel"%>
<%@ page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.1.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
<link
	href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script>
	$(document).ready(function() {
		$("#datepicker").datepicker();
	});
</script>
<%-- <title><%=prop.getProperty("title")%></title> --%>
<title>Přidat Hodnocení</title>
</head>
<body>
	<%@ include file="menu.jspf"%>
	<form action="/workshop/chooseEmployees" method="get">
		<table border="0" cellpadding="5" width="400">
			<tr>
				<td width="100"><label>Název plánu:</label></td>
				<td><input id="category" type="text" name="name" /></td>
			</tr>

			<tr>
				<td width="100"><label>Pobočka: </label></td>
				<td><select id="category" name="branch">
						<%
							List<BranchModel> branches = (List<BranchModel>) request.getAttribute("branches");
							for (int i = 0; i < branches.size(); i++) {
								String id = branches.get(i).getId();
								String name = branches.get(i).getName();
						%>
						<option value="<%=id%>"><%=name%></option>
						<%
							}
						%>
				</select></td>
			</tr>

			<tr>
				<td width="100"><label>Kategorie: </label></td>
				<td><select id="category" name="category">

						<option value="OTHER"></option>
						<option value="NEW">New</option>
						<option value="STABLE">Stable</option>
						<option value="SENIOR">Senior</option>
						
				</select></td>
			</tr>
			<tr>
				<td width="100"><label>Datum: </label></td>
				<td>
					<%
						Calendar cal = Calendar.getInstance();
						DateFormat tipe = new SimpleDateFormat("MM/dd/YYYY");
					%> 
					
					
					<input id="datepicker" type="text" name="datepicker" value=<%=tipe.format(cal.getTime())%>/>

				</td>
			</tr>
		</table>


		<input id="prechod" type="submit" value="Přejít" />
	</form>
</body>
</html>