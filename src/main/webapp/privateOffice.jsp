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
    <title>Личный кабинет</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" width="100%" align="center">
    <tr>
        <td colspan="3" class="header"></td>
    </tr>
    <tr>
        <td colspan="3" class="header1">

            <div align="right"><h1>${login}</h1></div>

            <form method="POST" action="excursionPage">
                <input type="hidden" name="login" value="${login}" />
                <div align="right"><input type="submit" name="atHome" value="Домой" class="demo" /></div>
            </form>

                <% out.println("<form method=\"POST\" action=\"rejectionOfTour\">\n" +
                        "            <table align=\"left\" ><caption><font color=\"blue\"><b>Отказ от экскурсии</b></font></caption>\n" +
                        "                <tr><td><font color=\"blue\">Номер заявки</font></td></tr>");
                    List<Excursion> excursions = ((List<Excursion>) request.getAttribute("excursions"));
                    out.println("<tr><td><select name=\"idExcursion\">\n");
                    for (Excursion excursion : excursions){
                            out.println("<option value=\""+excursion.getIdExcursion()+"\">"+excursion.getIdExcursion()+"</option>\n");
                    }
                        out.println("</select></td>" +
                                "<td><input type=\"submit\" name=\"reserve\" value=\"Отказаться от экскурсии\" onclick=\"reservePlace()\" class=\"demo\" /></td></tr>");
                        out.println(" <input type=\"hidden\" name=\"login\" value=\""+request.getAttribute("login")+"\" />\n" +
                                    "            </table>\n" +
                                    "          </form>");
                %>
            <h3 id="resultReservePlace"></h3>
        </td>
    </tr>


    <tr>
        <td class="center_col">
            <%

                if(excursions.isEmpty()) out.print("<h2>Вы не записаны на экскурсии</h2>");
                else{

                    for (Excursion excursion : excursions){
                        out.println("<table>");
                        out.println("<tr><td>Номер заявки</td><td><font color=\"blue\"><b>"+excursion.getIdExcursion()+"</b></font></td></tr> "+
                                "<tr><td>Город</td><td><font color=\"blue\"><b>"+excursion.getTown()+"</b></font></td></tr> "+
                                "<tr><td>Место</td><td><font color=\"blue\"><b>"+excursion.getPlace()+"</b></font></td></tr> "+
                                "<tr><td>Дата</td><td><font color=\"blue\">"+excursion.getDate().toString("dd:MM:yy HH:mm")+"</font></td></tr>"+
                                "<tr><td>Продолжительность\n" + " (дни)</td><td><font color=\"blue\">"+excursion.getDuration()+"</font></td></tr>"+
                                "<tr><td>Стоимость(руб.)</td><td><font color=\"blue\">"+excursion.getPrice()+"</font></td></tr>"+
                                "<tr><td>Количество \n" + "забронированных  \n" + "  мест</td><td><font color=\"blue\">"+excursion.getAvailable()+"</font></td></tr>"+
                                "<tr><td>Гид</td><td><font color=\"blue\">"+excursion.getName()+"</font></td></tr>"+
                                "<tr><td>Email гида</td><td><font color=\"blue\">"+excursion.getEmail()+"</font></td></tr>"+
                                "<tr><td>Телефон гида</td><td><font color=\"blue\">"+excursion.getPhone()+"</font></td></tr>");
                        out.println("</table><br/><br/>");
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

</body>
</html>
