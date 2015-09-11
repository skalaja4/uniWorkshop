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
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/themes/ui-lightness/jquery-ui.css" rel="stylesheet" type="text/css" />
<script>
	$(document).ready(function () {
		$("#datepicker").datepicker();
	});
</script>
<title><%=prop.getProperty("title")%></title>
</head>
<body>
	<%@ include file="menu.jspf"%>

	<table border="1" cellpadding="5" width="800">
		<tr>
			<td width="200"><%=prop.getProperty("branch")%><br></td>
			<td width="200"><%=prop.getProperty("category")%><br></td>
			<td width="200"><%=prop.getProperty("date")%><br></td>
		</tr>
		<tr>
			<td>
				<select id="category" name="branch">
					<%
						for (int i = 0; i < branches.size(); i++) {
					%>
					<option value="${branches.get(i).getId()}">${branches.get(i).getName()}</option>
					<%
						}
					%>
				</select>
			</td>
			<td>
				<select id="category" name="category">
					<option value="ALL"><%=prop.getProperty("ALL")%></option>
					<option value="ALL"><%=prop.getProperty("NEW")%></option>
					<option value="ALL"><%=prop.getProperty("STABLE")%></option>
					<option value="ALL"><%=prop.getProperty("SENIOR")%></option>
					<option value="ALL"><%=prop.getProperty("OTHER")%></option>
				</select>
			</td>
			<td>
				<input id="datepicker" type="text"/>
			</td>
		</tr>
	</table>
	<input id="prechod" type="submit">
</body>
</html>