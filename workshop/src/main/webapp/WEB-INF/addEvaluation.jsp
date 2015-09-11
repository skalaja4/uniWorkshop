<%@ page import="java.util.List" %>
<%@ page import="eu.unicorneducation.model.BranchModel" %>

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
	$(document).ready(function () {
		$("#datepicker").datepicker();
	});
</script>
<%-- <title><%=prop.getProperty("title")%></title> --%>
<title>Přidat Hodnocení</title>
</head>
<body>
	<%@ include file="menu.jspf"%>

	<table border="0" cellpadding="5" width="800">
		<tr>
			<td width="50"><label>Pobočka: </label></td>
			<td>
				<select id="category" name="branch">
					<%
						List<BranchModel> branches = (List<BranchModel>) request.getAttribute("branches");
						for (int i = 0; i < branches.size(); i++) {	
							String id=branches.get(i).getId();
							System.out.println(id);
							String name=branches.get(i).getId();
							System.out.println(name);
					%>				
					<option value="<%=id%>"><%=name%></option>
					<%
						}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td width="50"><label>Kategorie: </label></td>
			<td>
				<select id="category" name="category">
<%-- 					<option value="ALL"><%=prop.getProperty("ALL")%></option> --%>
<%-- 					<option value="NEW"><%=prop.getProperty("NEW")%></option> --%>
<%-- 					<option value="STABLE"><%=prop.getProperty("STABLE")%></option> --%>
<%-- 					<option value="SENIOR"><%=prop.getProperty("SENIOR")%></option> --%>
<%-- 					<option value="OTHER"><%=prop.getProperty("OTHER")%></option> --%>
					<option value="ALL">Vše</option>
					<option value="NEW">New</option>
					<option value="STABLE">Stable</option>
					<option value="SENIOR">Senior</option>
					<option value="OTHER">Ostatní</option>
				</select>
			</td>			
		</tr>			
		<tr>
			<td width="50"><label>Datum: </label></td>
			<td>
				<input id="datepicker" type="text"/>
			</td>
		</tr>		
	</table>
	<input id="prechod" type="submit" value="Přejít"/>
</body>
</html>