<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jspf" %>

<br>
<br>

<table border="1" cellpadding="5" width="800">
<tr>
<td width="200">Datum</td>
<td width="200">Názav</td>
<td width="200">Uni. Kód</td>
<td width="50">Vyplnit</td>
</tr>
 <!-- <% //for(int i = 0; i < employees.size(); i+=1) { %>
            <tr>      
                <td>${allFestivals.get(i).getFestivalName()}</td>
                <td>${allFestivals.get(i).getLocation()}</td>
                <td>${allFestivals.get(i).getStartDate()}</td>
                <td>${allFestivals.get(i).getEndDate()}</td>
                <td>${allFestivals.get(i).getURL()}</td>  
            </tr>
        <% //} %> -->



</table>
</body>
</html>