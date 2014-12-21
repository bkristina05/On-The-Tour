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
<input type="hidden" name="login" value="${login}" />
<form method="POST" action="add_excursion_for_admin">
    <table>
        <tr><td colspan="2" align="left"><input type="submit" name="rewrite" value="Редактировать экскурсию"  class="demo" /></td><td>
        <%
            List<Excursion>excursionList= (List<Excursion>) request.getAttribute("excursionList");
            if(excursionList!=null&&!excursionList.isEmpty()){
                out.print("<select name=\"excursionList\">");
                for(Excursion excursion:excursionList){
                    out.print("<option value=\""+excursion.getExcurs_id()+"\">"+excursion.getPlace()+", "+excursion.getTown()+"</option>");
                }
                out.print("</select </td></tr>");
            }
            Boolean isRedact= (Boolean) request.getAttribute("isRedact");
            if(isRedact!=null&&isRedact){
                Integer id_exc= (Integer) request.getAttribute("id_excursion");
                out.print("<input type=\"hidden\" name=\"id_excursion\" value=\""+id_exc+"\" />");
                out.print("<input type=\"hidden\" name=\"move\" value=\"update\" />");
                out.print("<table border=\"2\"");
                out.print("<tr><td align='center' >Место</td><td align='center' >Город</td><td align='center' >Максимальное количество туристов</td>" +
                        "<td align='center' >Цена</td><td align='center' >Продолжительность</td><td align='center' >Описание</td></tr>");

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
        <tr><td colspan="2" align="left"><input type="submit" name="newExcursion" value="Добавить экскурсию"  class="demo" /></td>
        <%
            if(request.getAttribute("isAddExcursion")!=null&&(Boolean)request.getAttribute("isAddExcursion")){
            out.print("<input type=\"hidden\" name=\"move\" value=\"insert\" />");
            out.print("<table border=\"2\"");
            out.print("<tr><td align='center' >Место</td><td align='center' >Город</td><td align='center' >Максимальное количество туристов</td>" +
                        "<td align='center' >Цена</td><td align='center' >Продолжительность</td><td align='center' >Описание</td></tr>");
            out.print("<tr><td align='center' ><input type='text' maxlength='100'  name=\"place\" /></td>" +
                    "<td align='center' ><input type='text' maxlength='30'  name=\"town\"/></td>" +
                    "<td align='center' ><input type='text' maxlength='2'  name=\"max_tourists\"/></td>" +
                    "<td align='center' ><input type='text' maxlength='5'  name=\"price\"/></td>" +
                    "<td align='center' ><input type='text' maxlength='2'  name=\"duration_tour\"/></td>" +
                    "<td align='center' ><textarea  name=\"description\" cols=\"20\" rows=\"5\"></textarea></td></tr>");
                out.print("</table");
                }
        %>
        <tr><td colspan="2" align="left"><input type="submit" name="save" value="Сохранить изменения"  class="demo" /></td>
    </table>
</form>
</body>
</html>
