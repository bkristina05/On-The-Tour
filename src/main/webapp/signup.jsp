<%--
  Created by IntelliJ IDEA.
  User: Daria
  Date: 09.11.2014
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
   <style>
   <%@include file='style.css' %>
   </style>
</head>
<body>
<form method="POST" action="signup"> <h3>${message}</h3>  <h2>${messageError}</h2>
    <table>
        <tr><h1>Регистрация</h1></tr>
        <tr><td>ФИО</td><td> <input type='text'  name="name"/></td></tr>
        <tr><td>Логин</td><td> <input type='text' maxlength='16' name="login"/></td></tr>
        <tr><td>Пароль</td><td> <input type='password' maxlength='16' name="password"/></td></tr>
        <tr><td>Подтверждение пароля</td><td><input type='password' maxlength='16' name="confirmation_password"/></td></tr>
        <tr><td>Возраст</td><td> <input type='text'  name="age"/></td></tr>
        <tr><td>Город</td><td> <input type='text'  name="town"/></td></tr>
        <tr><td>Email</td><td> <input type='text'  name="email"/></td></tr>
        <tr><td>Телефон</td><td> <input type='text'  name="phone"/></td></tr>
        <tr><td colspan="2"><input type="submit" name="signup" value="Зарегистрироваться" class="demo"/></td></tr>
        <tr><td colspan="2"><input type="submit" name="enter" value="Войти" class="demo"></td></tr>
    </table>
</form>
</body>
</html>
