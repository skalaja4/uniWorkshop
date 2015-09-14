<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Queue"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import=" java.text.DateFormat"%>
<%@page import="eu.unicorneducation.model.BranchTreeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
List<BranchTreeModel> branches = (List<BranchTreeModel>) request.getAttribute("branches");
%>

<html>
<head>
<title>Branches</title>
</head>
<body>
	<div id="header">
		<%@ include file="menu.jspf"%>



		<h1>Pobočky</h1>
		<br>
		
		<%for(BranchTreeModel branchTree:branches){
			
			%>
			<br>	<%=branchTree.getThisBranch().getName()%>	
		<%
		for(BranchTreeModel branchTree2:branchTree.getChildrens()){%>
		<br>
			&nbsp;&nbsp;&nbsp;&nbsp; <%=branchTree2.getThisBranch().getName()%>
			<%for(BranchTreeModel branchTree3:branchTree2.getChildrens()){%>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=branchTree3.getThisBranch().getName()%>
			<%
		}}
		}%>
		
		<ul>
			<li><a href="/workshop/employees?branchid=BB_BRANCH_001">
					prvni hlavni pobocka</a></li>
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
		</ul>
</body>
</html>