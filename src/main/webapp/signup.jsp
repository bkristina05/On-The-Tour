<%--
  Created by IntelliJ IDEA.
  User: Daria
  Date: 09.11.2014
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <style><%@include file='css/style.css' %></style>
    <script type="text/JavaScript" src="js/jquery-1.9.1.min.js"> </script>
    <script type="text/JavaScript" src="js/signup.js"></script>
</head>
<body>
    <table>
        <tr><p id="resultSignup"><p></tr>
        <tr><h1>Регистрация</h1></tr>
        <tr><td>ФИО</td><td> <input type='text' id="name" name="name"/></td></tr>
        <tr><td>Логин</td><td> <input type='text' id="login" maxlength='16' name="login"/></td></tr>
        <tr><td>Пароль</td><td> <input type='password' id="password" maxlength='16' name="password"/></td></tr>
        <tr><td>Подтверждение пароля</td><td><input type='password' id="confirmation_password" maxlength='16' name="confirmation_password"/></td></tr>
        <tr><td>Возраст</td><td> <input type='text' id="age" name="age"/></td></tr>
        <tr><td>Город</td><td> <input type='text' id="town" name="town"/></td></tr>
        <tr><td>Email</td><td> <input type='text' id="email" name="email"/></td></tr>
        <tr><td>Телефон</td><td> <input type='text' id="phone"  name="phone"/></td></tr>
        <tr><td colspan="2"><input type="button" name="signup" value="Зарегистрироваться" onclick="signup()" class="demo"/></td></tr>
        <tr><td colspan="2"><input type="button" id="enter" value="Войти" onclick="enter()" class="demo" /></td></tr>
    </table>
</body>
</html>
