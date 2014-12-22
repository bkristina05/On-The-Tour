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

<table cellpadding="0" cellspacing="0" width="100%" align="center">
    <tr>
        <td colspan="3" class="header"></td>
    </tr>

    <tr>
        <td colspan="3" class="header1">
            <table>
                <tr><td><div align="right"><h1>${login}</h1></div></td>
                    <td></td><td></td><td></td>
                    <td>
                        <form method="POST" action="privateOffice">
                            <input type="hidden" name="login" value="${login}" />
                            <input type="submit" name="privateOffice" value="Личный кабинет" class="demo" />
                        </form>
                    </td>

                    <td>
                        <form method="POST" action="excursionPage">
                            <input type="hidden" name="login" value="${login}" />
                            <input type="submit" name="atHome" value="Домой" class="demo" />
                         </form>
                    </td>

                </tr></table>
        </td>
    </tr>

    <tr>
        <td class="center_col">
            <h3 id="resultReservePlace"></h3>
            <%
            List<Excursion> excursions = ((List<Excursion>) request.getAttribute("excursions"));

                if(excursions.isEmpty()) out.println("<h2>Экскурсий в этот город временно нету</h2>");
                else{
                    for (Excursion excursion : excursions){
                        out.println("<table>");
                        out.println("<tr><td>Город</td><td><font color=\"blue\">" +excursion.getTown()+"</font></td></tr>"+
                                "<tr><td>Место</td><td><font color=\"blue\">" +excursion.getPlace()+"</font></td></tr> "+
                                "<tr><td>Описание</td><td><font color=\"blue\">" +excursion.getDescription()+"</font></td></tr> "+
                                "<tr><td>Дата</td><td><font color=\"blue\">"+excursion.getDate().toString("dd:MM:yy HH:mm")+"</font></td></tr>"+
                                "<tr><td>Продолжительность(дни)</td><td><font color=\"blue\">"+excursion.getDuration()+"</font></td></tr>"+
                                "<tr><td>Цена(руб.)</td><td><font color=\"blue\">"+excursion.getPrice()+"</font></td></tr>");
                        out.println("<tr><td>Количество мест</td>");
                        if (excursion.getAvailable()==0) out.println("<td><h2>Нет свободных мест</h2>");
                        else
                        { out.println("<td><select  id=\"numberPersons\">\n");
                            for (int i = 1; i <= excursion.getAvailable(); i++) {
                                out.println("<option  value=\""+i+"\">"+i+"</option>\n");
                            }
                            out.println("</select></td></tr>");
                        }
                        out.println("<tr><td colspan=\"2\"><input type=\"button\" id=\"sendRequest\" value=\"Отправить заявку\" onclick=\"reservePlace()\" class=\"demo\" /></td></tr>");
                        out.println("</table><br/><br/>");
                        out.println(" <input type=\"hidden\" id=\"town\" value=\""+excursion.getTown()+"\" />"+
                                    " <input type=\"hidden\" id=\"idExcursion\" value=\""+excursion.getIdExcursion()+"\" />");

                    }

                }

        %>
        </td>

        <td class="right_col2">

        </td>

    </tr>
    <tr>
        <td colspan="3" class="footer">
            <b>Экскурсионные туры по России<br/>&copy; 2014</b>

            <b><div align="right">Мы стараемся хорошо работать, чтобы вы хорошо отдыхали.</div>
                <div align="right">Тел.: (495) 782-30-76, 514-71-00<br/></div>
                <div align="right">e-mail: inforostour@mail.ru</div></b>
        </td>
    </tr>
</table>


<input type="hidden" id="login" value="${login}" />

</body>
</html>
