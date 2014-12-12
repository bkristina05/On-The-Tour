<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style> <%@include file='style.css' %> </style>
    <script type="text/JavaScript" src="jquery-1.9.1.min.js"> </script>
    <script type="text/JavaScript" src="checkLoginIs.js"></script>

</head>
<body>
    <table>
        <tr><h2 id="result"></h2></tr>
        <tr><h1>Авторизация</h1></tr>
        <tr><td>Логин</td><td> <input type='text' maxlength='16' id="login" name="login"/></td></tr>
        <tr><td>Пароль</td><td> <input type='password' maxlength='16' id="password" name="password"/></td></tr>
        <tr><td colspan="2" align="right"><input type="button" name="enter" value="Войти" onclick="checkLoginIs()" class="demo"></tr>
        <tr><td colspan="2" align="right"><input type="button"  id="registration" value="Регистрация" onclick="registration()" class="demo"></td></tr>
    </table>
</body>
</html>