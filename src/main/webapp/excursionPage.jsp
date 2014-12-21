<%@ page import="transferObjects.Excursion" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Daria
  Date: 15.12.2014
  Time: 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        <%@include file='css/style.css' %>
    </style>
    <script type="text/JavaScript" src="js/jquery-1.9.1.min.js"> </script>
    <script type="text/JavaScript" src="js/reservePlace.js"></script>

</head>
<body>
<div align="right"><h1>${login}</h1></div>
<h3 id="resultReservePlace"></h3>

<form method="POST" action="privateOffice">
    <input type="hidden" name="login" value="${login}" />
    <div align="right"><input type="submit" name="privateOffice" value="Личный кабинет" class="demo" /></div>
</form>

<form method="POST" action="excursionPage">
    <input type="hidden" name="login" value="${login}" />
    <div align="right"><input type="submit" name="atHome" value="Домой" class="demo" /></div>
</form>
<%
    List<Excursion> excursions = ((List<Excursion>) request.getAttribute("excursions"));

    out.println("<table>");
    for (Excursion excursion : excursions){
        out.println("<tr><td>Место</td><td>" +excursion.getPlace()+"</td></tr> "+
                "<tr><td>Описание</td><td>" +excursion.getDescription()+"</td></tr> "+
                "<tr><td>Дата</td><td>"+excursion.getDate().toString("dd:MM:yy HH:mm")+"</td></tr>"+
                "<tr><td>Продолжительность(дни)</td><td>"+excursion.getDuration()+"</td></tr>"+
                "<tr><td>Цена(руб.)</td><td>"+excursion.getPrice()+"</td></tr>");
        out.println("<tr><td>Количество мест</td>");
        if (excursion.getAvailable()==0) out.println("<td><h2>Нет свободных мест</h2>");
        else
        { out.println("<td><select  id=\"numberPersons\">\n");
            for (int i = 1; i <= excursion.getAvailable(); i++) {
                out.println("<option  value=\""+i+"\">"+i+"</option>\n");
            }
            out.println("</select></td></tr>");
        }
        out.println("<tr><td colspan=\"2\"><input type=\"button\" id=\"sendRequest\" value=\"Отправить заявку\" onclick=\"reservePlace()\" class=\"demo\" /></td></tr>"+
                "</tr> <input type=\"hidden\" id=\"town\" value=\""+excursion.getTown()+"\" />"+
                "</tr> <input type=\"hidden\" id=\"idExcursion\" value=\""+excursion.getIdExcursion()+"\" />");

    }

    out.println("</table>");

%>
<input type="hidden" id="login" value="${login}" />

</body>
</html>
