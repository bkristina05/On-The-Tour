<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title>Регистрация</title>
</head>
<body>


<h2>Регистрация</h2>

<form:form method="post" action="add" commandName="user">

	<table>
        <tr><td>ФИО</td><td> <input type='text'  path="name"/></td></tr>
        <tr><td>Логин</td><td> <input type='text' maxlength='16' path="login"/></td></tr>
        <tr><td>Пароль</td><td> <input type='text' maxlength='16' path="password"/></td></tr>
        <tr><td>Возраст</td><td> <input type='text'  path="age"/></td></tr>
        <tr><td>Город</td><td> <input type='text'  path="town"/></td></tr>
        <tr><td>Email</td><td> <input type='text'  path="email"/></td></tr>
        <tr><td>Телефон</td><td> <input type='text'  path="phone"/></td></tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="Зарегистрироваться" /></td>
		</tr>
	</table>
</form:form>

</body>
</html>