<%--
  Created by IntelliJ IDEA.
  User: Daria
  Date: 14.11.2014
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
    <%@include file='css/style.css' %>
    <%@include file='css/jquery-ui.css' %>
    </style>
    <script type="text/JavaScript" src="js/jquery-1.10.2.js"></script>
    <script type="text/JavaScript" src="js/jquery-ui.js"></script>
    <script type="text/JavaScript" src="js/linkedselect.js"></script>

    <script>
        $(function() {
            $( "#datepicker" ).datepicker();
        });
    </script>

</head>
<body>

<h1>Добро пожаловать:${login}</h1>
    <table>

    <tr><td>Куда едем:</td>
    <td><select  id="select1">
        <option value="Санкт-Петербург">Санкт-Петербург</option>
        <option value="Москва">Москва</option>

    </select></td></tr>

    <tr><td>Место:</td><td><select  id="select2"></select></td><tr>

    <tr><td>Дата отправления:</td>
    <td><input type="text" id="datepicker" /></td></tr>

    </table>
<script type="text/JavaScript" src="js/changeFormSelect.js"></script>
</body>
</html>
