<%--
  Created by IntelliJ IDEA.
  User: Daria
  Date: 14.11.2014
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
    <%@include file='css/style.css' %>
    </style>
    <title>Домашняя страница</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" width="100%" align="center">
    <tr>
        <td colspan="3" class="header"></td>
    </tr>
    <tr>
        <td colspan="3" class="header1">
            <form method="POST" action="selectTown">
                <table>
                    <tr><td><h1>В каком городе хотите посетить экскурсию?</h1></td>
                    <%
                        List<String> towns = ((List<String>) request.getAttribute("towns"));


                        out.println("<td><select  name=\"townsSelect\">\n");
                        for (String town : towns) out.println("   <option  value=\""+town+"\">"+town+"</option>\n");

                        out.println("</select></td>");

                    %>
                    <input type="hidden" name="login" value="${login}" />

                    <td colspan="2"><input type="submit" id="select" value="Выбрать" class="demo" /></td></tr>
                </table>
            </form>

            <div align="right"><h1>${login}</h1></div>

            <form method="POST" action="privateOffice">
                <input type="hidden" name="login" value="${login}" />
                <div align="right"><input type="submit" name="privateOffice" value="Личный кабинет" class="demo" /></div>
            </form>


        </td>
    </tr>
    
    <tr>
        <td class="center_col">
            <p class="thumb">

                <img src="images/1.jpg" width="320" height="175" alt="Красная площадь" title="Красная площадь">
                <img src="images/2.JPG" width="320" height="175" alt="Оружейная палата" title="Оружейная палата">
                <img src="images/3.jpg" width="320" height="175" alt="Третьяковская галерея" title="Третьяковская галерея">
                <img src="images/5.jpg" width="320" height="175" alt="Псковский кремль" title="Псковский кремль">
                <img src="images/6.jpg" width="320" height="175" alt="Троицкий собор" title="Троицкий собор Псков">
                <img src="images/7.gif" width="320" height="175" alt="Новгородский кремль" title="Новгородский кремль">
                <img src="images/8.jpg" width="320" height="175" alt="Великий Новгород" title="Памятник Тысячелетие России Великий Новгород">
                <img src="images/9.jpg" width="320" height="175" alt="Нижний Новгород" title="Нижегородский Кремль Нижний Новгород">
                <img src="images/11.jpg" width="320" height="175" alt="Крым" title="Крым">
            </p>
        </td>
        <td class="right_col2">
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
