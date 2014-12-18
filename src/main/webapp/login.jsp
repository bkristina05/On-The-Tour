<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style> <%@include file='css/style.css' %> </style>

</head>
<body>
<form method="POST" action="login">${messageError}
    <table>
        <tr><h1>Авторизация</h1></tr>
        <tr><td>Логин</td><td> <input type='text' maxlength='16'  name="login"/></td></tr>
        <tr><td>Пароль</td><td> <input type='password' maxlength='16'  name="password"/></td></tr>
        <tr><td colspan="2" align="right"><input type="submit" name="enter" value="Войти"  class="demo" /></td></tr>
        <tr><td colspan="2" align="right"><input type="submit" name="registration" value="Регистрация" class="demo" /></td></tr>
    </table>
</form>
</body>
</html>
