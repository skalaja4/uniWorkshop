<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="eu.unicorneducation.model.EvaluationPlanModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PlannedEvaluation</title>
</head>
<body>
	<%@ include file="menu.jspf"%>

	<br>
	<br>

	<table border="1" id="afterDate" class="" cellpadding="5" width="800">
		<tr>
			<td width="200">Datum</td>
			<td width="200">Názav</td>
			<td width="200">Uni. Kód</td>
			<td width="50">Vyplnit</td>
		</tr>

		<%  List<EvaluationPlanModel> plansAfter = (List<EvaluationPlanModel>)
			request.getAttribute("plansAfter");
		
			for(int i = 0; i <plansAfter.size(); i++) {%>
		<tr>
			<td>${plansAfter.get(i).getExpiration()}</td>
			<td>${plansAfter.get(i).getName()}</td>
			<td>${plansAfter.get(i).getBranch()}</td>
			<td>
				<form action="http://localhost:8085/workshop/fillEvaluation">
					<input type="submit" value="Vyplnit">
				</form>
			</td>
		</tr>
		<%
			}
		%>

	</table>

	<table border="1" id="beforeDate" cellpadding="5" width="800">
		<tr>
			<td width="200">Datum</td>
			<td width="200">Názav</td>
			<td width="200">Uni. Kód</td>
			<td width="50">Vyplnit</td>
		</tr>

		<%
			List<EvaluationPlanModel> plansBefore = (List<EvaluationPlanModel>) request
					.getAttribute("plansBefore");
			for (int i = 0; i < plansBefore.size(); i++) {
		%>
		<tr>
			<td>${plansBefore.get(i).getFestivalName()}</td>
			<td>${plansBefore.get(i).getLocation()}</td>
			<td>${plansBefore.get(i).getStartDate()}</td>
			<td>
				<form action="http://localhost:8085/workshop/fillEvaluation">
					<input type="submit" value="Vyplnit">
				</form>
			</td>
		</tr>
		<%
			}
		%>


	</table>
	<form action="http://localhost:8085/workshop/addEvaluation">
		<input type="submit" value="Přidat hodnocení">
	</form>
</body>
</html>