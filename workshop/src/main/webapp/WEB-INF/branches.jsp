
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<%@ include file="menu.jspf"%>

		<br>
		<ul>
			<li><a href="/workshop/employees"> prvni hlavni pobocka</a></li>
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
			<li><a href="/workshop/employees"> treti hlavni pobocka</a>
				
			</li>
		</ul>
</body>
</html>