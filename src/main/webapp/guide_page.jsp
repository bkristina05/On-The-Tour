<%@ page import="domain.User" %>
<%@ page import="domain.ExcursionGuide" %>
<%@ page import="domain.Excursion" %>
<%@ page import="java.util.*" %>
<%@ page import="domain.ExcursionTourist" %>
<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 17.12.2014
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style> <%@include file='css/style.css' %> </style>
</head>
<body>


<table cellpadding="0" cellspacing="0" width="100%" align="center">
    <tr>
        <td colspan="3" class="header"></td>
    </tr>

    <tr>
        <td colspan="3" class="header1">
            <div align="right"><h1>${login}</h1></div>
        </td>
    </tr>

    <tr>
        <td class="center_col"></td>
        <td class="right_col">

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




            <table>
            <tr><td colspan="2" align="left"><input type="submit" name="addExcursion" value="Добавление/редактирование экскурсий"  class="demo" /></td></tr>
            <tr><td colspan="2" align="left"><input type="submit" name="appointExcursion" value="Назначить экскурсию"  class="demo" /></td></tr>
            </table>

            <%
                List<Excursion>excList= (List<Excursion>) request.getAttribute("listExc");
                Boolean isAppExc= (Boolean) request.getAttribute("isAppExc");

                if(isAppExc!=null){
                    out.println("<table board=\"2\"><tr>");
                    out.println("<td>Экскурсия</td><td>Дата экскурсии</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<select name=\"appExcurs\">");
                    for(Excursion excursion:excList){
                        out.print("<option value=\""+excursion.getExcurs_id()+"\">");
                        out.print(excursion.getPlace()+", "+excursion.getTown());
                        out.println("</option>");
                    }
                    out.println("</select>");
                    out.println("</td>");

                    out.print("<td>");
                    out.print("<input type=\"datetime-local\" name=\"calendar\"/>");
                    out.print("</td>");
                    out.println("</tr>");
                    out.println("<tr><td colspan=\"2\" align=\"left\"><input type=\"submit\" name=\"saveAppointEcursion\" value=\"Сохранить назначенную экскурсию\"  class=\"demo\" /></td></tr></table>");
                }
            %>

</form>
</body>
</html>
