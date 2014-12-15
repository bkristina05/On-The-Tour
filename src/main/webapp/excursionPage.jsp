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
<h1>${login}</h1>
<h2 id="resultReservePlace"></h2>
<%
    List<Excursion> excursions = ((List<Excursion>) request.getAttribute("excursions"));

    out.println("<table><tr>\n" +
            "    <th>Место</th>\n" +
            "    <th>Дата</th>\n" +
            "    <th>Количество</br> " +
            "     свободных мест</th>\n" +
            "    <th>Продолжительность</br> " +
            "     экскурсии(час)</th>\n" +
            "    <th>Цена</br>" +
            "    (за 1 человека)</th>\n" +
            "    <th>Количество</br>" +
            "     человек</th>\n" +
            "    <th> </th>\n" +
            "   </tr>");
    for (Excursion excursion : excursions){
        out.println("<tr><td><input type='text' id=\"place\" size=\"50\"  value=\""+excursion.getPlace()+"\" readonly/></td> "+
                "<td><input type='text'  id=\"date\" value=\""+excursion.getDate().toString("dd:MM:yy HH:mm")+"\" readonly/></td>"+
                "<td><input type='text'  id=\"availablePlaces\"  value=\""+excursion.getAvailable()+"\" readonly/></td>"+
                "<td><input type='text'  id=\"duration\"  value=\""+excursion.getDuration()+"\" readonly/></td>"+
                "<td><input type='text'  id=\"price\"  value=\""+excursion.getPrice()+"\" readonly/></td>");
        out.println("<td><select  id=\"numberPersons\">\n");
        for (int i = 1; i <= excursion.getAvailable(); i++) {
            out.println("<option  value=\""+i+"\">"+i+"</option>\n");
        }
        out.println("</select></td>");
        out.println("<td colspan=\"2\"><input type=\"button\" id=\"sendRequest\" value=\"Отправить заявку\" onclick=\"reservePlace()\" class=\"demo\" /></td>"+
                "</tr> <input type=\"hidden\" id=\"town\" value=\""+excursion.getTown()+"\" />"+
                "</tr> <input type=\"hidden\" id=\"idExcursion\" value=\""+excursion.getIdExcursion()+"\" />");

    }

    out.println("</table>");

%>
<input type="hidden" id="login" value="${login}" />
</body>
</html>
