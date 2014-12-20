<%@ page import="java.util.List" %>
<%@ page import="domain.Excursion" %>
<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 20.12.2014
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style> <%@include file='css/style.css' %> </style>
</head>
<body>
<form method="POST" action="add_excursion">

    <table>
        <tr><td colspan="2" align="left"><input type="submit" name="rewrite" value="Редактировать экскурсию"  class="demo" /></td><td>
        <%
            List<Excursion>excursionList= (List<Excursion>) request.getAttribute("excursionList");
            if(excursionList!=null&&!excursionList.isEmpty()){
                out.print("<select name=\"excursionList\">");
                for(Excursion excursion:excursionList){
                    out.print("<option value=\""+excursion.getExcurs_id()+"\">"+excursion.getPlace()+", "+excursion.getTown()+"</option>");
                }
                out.print("</select </td></tr></table>");
            }
            Boolean isRedact= (Boolean) request.getAttribute("isRedact");
            if(isRedact!=null&&isRedact){
                out.print("<table border=\"2\"");
                out.print("<tr><td>Место</td><td>Город</td><td>Максимальное количество туристов</td>" +
                        "<td>Цена</td><td>Продолжительность</td><td>Описание</td></tr>");

            Excursion excursion= (Excursion) request.getAttribute("excursion");
            if(excursion!=null)
            out.print("<tr><td align='center' ><input type='text' maxlength='100'  name=\"place\" value=\""+excursion.getPlace()+"\"/></td>" +
                    "<td align='center' ><input type='text' maxlength='30'  name=\"town\" value=\""+excursion.getTown()+"\"/></td>" +
                    "<td align='center' ><input type='text' maxlength='2'  name=\"max_tourists\"value=\""+excursion.getMax_tourists()+"\"/></td>" +
                    "<td align='center' ><input type='text' maxlength='5'  name=\"price\"value=\""+excursion.getPrice()+"\"/></td>" +
                    "<td align='center' ><input type='text' maxlength='2'  name=\"duration_tour\"value=\""+excursion.getDuration_tour()+"\"/></td>" +
                    "<td align='center' ><textarea  name=\"description\" cols=\"20\" rows=\"5\">"+excursion.getDescription()+"</textarea></td></tr>");
                out.print("</table");
            }
        %>
        </td></tr>
    </table>
</form>

<tr><td colspan="2" align="left"><input type="submit" name="newExcursion" value="Добавить экскурсию"  class="demo" /></td>

</body>
</html>