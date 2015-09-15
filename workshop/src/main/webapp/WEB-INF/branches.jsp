<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import=" java.text.DateFormat"%>
<%@page import="eu.unicorneducation.model.BranchTreeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Integer size=(Integer) request.getAttribute("branches");

%>

<html>
<head>
<title>Branches</title>
</head>
<body>
	<div id="header">
		<%@ include file="menu.jspf"%>
		
		<%for(int i=0;i<size;i++){ %>
<%= request.getAttribute("branche"+i) %>
<%} %>
<%-- 
		<h1>Pobočky</h1>
		<br>
		<ul>
<<<<<<< HEAD
			<li><a href="link.employees?branchid=BB_BRANCH_012"> prvni hlavni pobocka</a></li>
=======
			<%
				for (BranchTreeModel branchTree : branches) {
			%>
			<li><a href="/workshop/employees?branchid=BB_BRANCH_001"> <%=branchTree.getThisBranch().getName()%></a></li>
			
			<ul>
				<%
					for (BranchTreeModel branchTree2 : branchTree.getChildrens()) {
				%>


				<li><a href="/workshop/employees?branchid=BB_BRANCH_001"> <%=branchTree2.getThisBranch().getName()%></a></li>


<ul>
				<%
					for (BranchTreeModel branchTree3 : branchTree2
									.getChildrens()) {
				%>
				
					<li><a href="/workshop/employees?branchid=BB_BRANCH_001">
							<%=branchTree3.getThisBranch().getName()%></a></li>

					<%
						for (BranchTreeModel branchTree4 : branchTree3
											.getChildrens()) {
					%>

					<li><a href="/workshop/employees?branchid=BB_BRANCH_001">
							<%=branchTree4.getThisBranch().getName()%></a></li>

				</ul>
			
		
		<%
			}
					}%>
				
				<ul>
				<%}%>
				
				</ul>
<%}%>
		


		</ul>





		<ul>
			<li><a href="/workshop/employees?branchid=BB_BRANCH_001">
					prvni hlavni pobocka</a></li>
>>>>>>> d16eda273ba6a3e226b2bf4ff829c5a5b93e1f92
			<ol>
				<li><a href="/workshop/employees"> pobocka1</a></li>
				<li><a href="/workshop/employees"> pobocka2</a></li>
				<li><a href="/workshop/employees"> pobocka3</a></li>
			</ol>
			<li><a href="/workshop/employees"> druha hlavni pobocka</a> <!-- Look, the closing </li> tag is not placed here! -->
				<ol>
					<li><a href="/workshop/employees"> pobocka4</a>
						<ol>
							<li><a href="/workshop/employees"> pobocka5</a></li>
							<li><a href="/workshop/employees"> pobocka6</a></li>
							<li><a href="/workshop/employees"> pobocka7</a></li>
						</ol></li>
					<li><a href="/workshop/employees"> pobocka8</a></li>
					<li><a href="/workshop/employees"> pobocka9</a></li>
				</ol></li>
			<!-- Here is the closing </li> tag -->
			<li><a href="/workshop/employees"> treti hlavni pobocka</a></li>
		</ul> --%>
</body>
</html>