<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21.12.2014
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="transferObjects.Excursion" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <style>
    <%@include file='css/style.css' %>
  </style>
</head>
<body>
<div align="right"><h1>${login}</h1></div>
<%
  List<Excursion> excursions = ((List<Excursion>) request.getAttribute("excursions"));
    if(excursions.isEmpty()) out.print("<h2>Вы не записаны на экскурсии</h2>");
  out.println("<table>");
  for (Excursion excursion : excursions){
    out.println("<tr><td>Номер заявки</td><td>"+excursion.getIdExcursion()+"</td></tr> "+
            "<tr><td>Город</td><td>"+excursion.getTown()+"</td></tr> "+
            "<tr><td>Место</td><td>"+excursion.getPlace()+"</td></tr> "+
            "<tr><td>Дата</td><td>"+excursion.getDate().toString("dd:MM:yy HH:mm")+"</td></tr>"+
            "<tr><td>Продолжительность\n" + " (дни)</td><td>"+excursion.getDuration()+"</td></tr>"+
            "<tr><td>Стоимость</td><td>"+excursion.getPrice()+"</td></tr>"+
            "<tr><td>Количество \n" + "забронированных  +\n" + "  мест</td><td>"+excursion.getAvailable()+"</td></tr>"+
            "<tr><td>Гид</td><td>"+excursion.getName()+"</td></tr>"+
            "<tr><td>Email гида</td><td>"+excursion.getEmail()+"</td></tr>"+
            "<tr><td>Телефон гида</td><td>"+excursion.getPhone()+"</td></tr>");

  }
  out.println("</table>");

%>
</body>
</html>
