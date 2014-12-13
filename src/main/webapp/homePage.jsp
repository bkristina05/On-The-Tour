<%--
  Created by IntelliJ IDEA.
  User: Daria
  Date: 14.11.2014
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
    <%@include file='css/style.css' %>
    <%@include file='css/bootstrap.min.css' %>
    <%@include file='css/jquery-ui.css' %>
    </style>
    <script type="text/JavaScript" src="js/jquery-1.10.2.js"></script>
    <script type="text/JavaScript" src="js/jquery-ui.js"></script>
    <script type="text/JavaScript" src="js/changeFormSelect.js"></script>
    <script>
        $(function() {
            $( "#datepicker" ).datepicker();
        });
    </script>
</head>
<body>
<h1>Добро пожаловать: ${login}</h1>

    <table>
    <tr><td>Куда едем:</td>
    <td><select name="select1" onchange="change(this)">
        <option value="Санкт-Петербург">Санкт-Петербург</option>
        <option value="Москва">Москва</option>
        <option value="Псков">Псков</option>
        <option value="Тула">Тула</option>
    </select></td></tr>
    <tr><td><select name="select2" id="select2" style="display:none">
            <option value="100">100 часов</option>
            <option value="200">200 часов</option>
    </select></td><tr>
    <tr><td>Дата отправления:</td>
    <td><input type="text" id="datepicker" /></td></tr>
    </table>

</body>
</html>
