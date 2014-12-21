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
<table cellpadding="0" cellspacing="0" width="100%" align="center">
    <tr>
        <td colspan="3" class="header"></td>
    </tr>
    <tr>
        <td class="center_col"><font color="blue">
            <p>У нас есть <b>ЦЕЛЬ!</b></p>
            <p>Цель – открыть Россию. Россию, которую мы <b>ТАК МАЛО </b> знаем!</p>
            <p>Россию, которую не разглядишь из окна автобуса или лежа на пляже.</p>
            <p>Она в Москве, Золотом кольце, Санкт-Петербурге, Кижах и Соловках.</p>
            <p>Она в живописных карельских деревеньках, на берегу озер Марийского края, в кедровых лесах Сибири…</p>
            <p>Она в шуме Северного Ледовитого океана на Кольском полуострове, в стойбищах оленеводов на Чукотке, в горах Кавказа и вулканах
                Камчатки, в селах Алтая… Разные регионы, непохожие народы, разнообразные культуры. И совершенно разная природа.</p>
            <p>Но, чтобы увидеть <b>ЭТУ</b> Россию, нужно проявить чуть больше инициативы.</p>
            <p>И мы готовы быть Вашей инициативой, открыть для Вас Россию!</p></font></td>
        <td class="right_col">

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
        </td>

    </tr>
    <tr>
        <td colspan="3" class="footer">
            <b>Экскурсионные туры по России<br/>&copy; 2014</b>

            <b><div align="right">Мы стараемся хорошо работать, чтобы вы хорошо отдыхали.</div>
                <div align="right">Тел.: (495) 782-30-76, 514-71-00<br/></div>
                <div align="right">e-mail: inforostour@mail.ru</div></b>
        </td>
    </tr>
</table>
</body>
</html>
