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

    <script>
        $(function() {
            $( "#datepicker" ).datepicker();
        });
    </script>
</head>
<body>
<h1>Добро пожаловать: ${login}</h1>

<form>
   <p>Куда едем:</p>
    <select multiple="multiple">
        <option>Санкт-Петербург</option>
        <option>Москва</option>
        <option>Псков</option>
        <option>Тула</option>
    </select>
    <p>Дата отправления:</p>
    <input type="text" id="datepicker">
</form>
</body>
</html>
