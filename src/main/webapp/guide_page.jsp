<%@ page import="java.util.Date" %>
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
<form method="POST" action="/guide_page">${error}
    <table>
        <tr><h1>Список ваших экскурсий</h1></tr>
        <input type='hidden' name="user_id" value="${user_id}"/>
        <input type="hidden" name="login" value="${login}" />
        <tr><td colspan="2" align="right"><input type="submit" name="goOnTour" value="Записаться на тур"  class="demo" /></td></tr>
        <tr><td colspan="2" align="right"><input type="submit" name="getExcursions" value="Показать экскурсии"  class="demo" /></td>
            <td><select name="select_excursion">
                <c:forEach var="excursion" items="${Excursions}">
                    <option value="${excursion.getKey().seq_excurs_guide}"> <c:out value="${excursion.getValue().place}, ${excursion.getValue().town}, ${excursion.getKey().date_excurs}"/>
                    </option>
                </c:forEach>
            </select></td></tr>
        <tr><td colspan="2" align="right"><input type="submit" name="getTourists" value="Показать туристов"  class="demo" /></td></tr>
        <c:forEach var="tourist" items="${setTourists}">
        <tr><td><c:out value="${tourist.name}, ${tourist.email}, ${tourist.phone}"/></td></tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
