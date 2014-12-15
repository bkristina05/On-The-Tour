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

</head>
<body>

<h1>Добро пожаловать:${login}</h1>
<form method="POST" action="selectTown">
    <table>
    <tr><td>В каком городе хотите посетить экскурсию?</td></tr>
        <%
            List<String> towns = ((List<String>) request.getAttribute("towns"));


            out.println("<tr><td><select  name=\"townsSelect\">\n");
            for (String town : towns) out.println("   <option  value=\""+town+"\">"+town+"</option>\n");

            out.println("</select></td></tr>");

        %>
        <input type="hidden" name="login" value="${login}" />

    <tr><td colspan="2"><input type="submit" id="select" value="Выбрать" class="demo" /></td></tr>
    </table>
</form>
</body>
</html>
