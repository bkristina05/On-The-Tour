<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title></title>
</head>
<body>

<form:form method="post" action="" >
    <table>
        <tr>
            <td><form:label path="login">
                Логин
            </form:label></td>
            <td><form:input path="login" /></td>
        </tr>
        <tr>
            <td align="right"><spring:message code="label.password" /></td>
            <td><input type="password" name="j_password" /></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="Войти" />
                <input type="reset" value="Reset" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>