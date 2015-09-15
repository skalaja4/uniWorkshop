<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="eu.unicorneducation.model.EvaluationPlanPartsModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
	tr.red {background-color: #ff8766;}
	
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PlannedEvaluation</title>
</head>
<body>
	<%@ include file="menu.jspf"%>
<h2>Hodnocení</h2>
	<br>
	<br>
	<h3>Nevyplněná hodnocení</h3>
	

	<table border="1" id="afterDate" class="" cellpadding="5" width="800">
		<tr>
			<td width="200">Datum</td>
			<td width="200">Názav</td>
			<td width="200">Uni. Kód</td>
			<td width="50">Vyplnit</td>
		</tr>

		<%
			List<EvaluationPlanPartsModel> plansAfter = (List<EvaluationPlanPartsModel>) request
					.getAttribute("plansAfter");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			for (int i = 0; i < plansAfter.size(); i++) {
		%>
		<tr class="red">
			<td><%=dateFormat.format(plansAfter.get(i).getExpiration())%></td>
			<td><%=plansAfter.get(i).getName()%></td>
			<td><%=plansAfter.get(i).getBranchName()%></td>
			<td>
				<form action="/workshop/fillEvaluation">
				<input type="hidden" name="idOfPlan" value=<%=plansAfter.get(i).getId()%>>
					<input type="submit" value="Vyplnit">
				</form>
			</td>
			</tr>
			<%}
			List<EvaluationPlanPartsModel> plansBefore = (List<EvaluationPlanPartsModel>) request
					.getAttribute("plansBefore");

			for (int i = 0; i < plansBefore.size(); i++) {
		%>
		<tr >
			<td><%=dateFormat.format(plansBefore.get(i).getExpiration())%></td>
			<td><%=plansBefore.get(i).getName()%></td>
			<td><%=plansBefore.get(i).getBranchName()%></td>
			<td>
				<form action="/workshop/fillEvaluation">
				<input type="hidden" name="idOfPlan" value=<%=plansBefore.get(i).getId()%>>
					<input type="submit" value="Vyplnit">
				</form>
		</tr>
		<%
			}
		%>

	</table>
<br><br>
<h3>Vyplněná hodnocení</h3>
	<table border="1" id="beforeDate" cellpadding="5" width="800">
		<tr>
			<td width="200">Datum</td>
			<td width="200">Názav</td>
			<td width="200">Pobočka</td>
			
		</tr>

		<%
			List<EvaluationPlanPartsModel> plansCompleted = (List<EvaluationPlanPartsModel>) request.getAttribute("plansCompleted");
			for (int i = 0; i < plansCompleted.size(); i++) {
		%>
		<tr>
			<td><%=dateFormat.format(plansCompleted.get(i).getExpiration())%></td>
			<td><%=plansCompleted.get(i).getName()%></td>
			<td><%=plansCompleted.get(i).getBranchName()%></td>
			
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