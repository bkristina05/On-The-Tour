<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style> <%@include file='css/style.css' %> </style>
    <title>Главная страница</title>
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
            <form method="POST" action="login">${messageError}
                <table>
                    <tr><h1>Авторизация</h1></tr>
                    <tr><td>Логин</td><td><input type='text' maxlength='16'  name="login"/></td></tr>
                    <tr><td>Пароль</td><td><input type='password' maxlength='16'  name="password"/></td></tr>
                    <tr><td colspan="2" align="right"><input type="submit" name="enter" value="Войти"  class="demo" /></td></tr>
                    <tr><td colspan="2" align="right"><input type="submit" name="registration" value="Регистрация" class="demo" /></td></tr>
                </table>
            </form>
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
