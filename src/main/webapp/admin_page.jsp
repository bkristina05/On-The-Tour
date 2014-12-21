<%@ page import="domain.TypeName" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 17.12.2014
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style> <%@include file='css/style.css' %> </style>
</head>
<body>
<div align="left"><h1>Здравствуйте, ${login}</h1></div>
<form method="POST" action="admin_page">
    <input type="hidden" name="login" value="${login}" />
    <table>
        <tr><td colspan="2" align="left"><input type="submit" name="goOnTour" value=" Записаться на тур"  class="demo" /></td></tr>
        <tr><td colspan="2" align="left"><input type="submit" name="findUser" value=" Найти по логину:"  class="demo" /></td>
            <td> <input type='text' maxlength='16'  name="login_find"/></td>
            <td colspan="2" align="left"><input type="submit" name="saveUser" width="20" value=" сохранить изменение"  class="demo" /></td>
        </tr>
        <tr>
            <table border="2">
                <%
                    List<TypeName> listTypes= (List<TypeName>) request.getAttribute("listTypes");
                    User findUser= (User) request.getAttribute("findUser");
                    String error= (String) request.getAttribute("error");
                    Integer id_type_user=(Integer) request.getAttribute("id_type_user");
                    if (findUser!=null){
                        out.print("<tr><td>Имя пользователя</td><td>Возраст</td><td>E-mail</td><td>Телефон</td><td>Статус</td></tr>");
                        out.print("<input type='hidden' name=\"user_id\" value=\""+findUser.getUser_id()+"\"/>");
                        out.print("<td>"+findUser.getName()+"</td><td>"+findUser.getAge()+"</td><td>"+findUser.getEmail()+"</td><td>"+findUser.getPhone()+"</td><td>");
                        if(id_type_user.intValue()==1)out.print("<input type=\"hidden\" name=\"nowType\" value=\""+id_type_user.intValue()+"\" />");
                        out.print("<select name=\"set_type\">");
                        for(TypeName typeName:listTypes){
                            if(id_type_user.intValue()==typeName.getType_id()){
                                out.print("<option selected value=\""+typeName.getType_id()+"\">"+typeName.getType_name()+"</option>\n");
                            }
                            else out.print("<option value=\""+typeName.getType_id()+"\">"+typeName.getType_name()+"</option>\n");
                        }
                        out.print("</select>");
                        out.print("</td>");
                    }
                    else {
                        Boolean afReq= (Boolean) request.getAttribute("afterRequest");
                        if(afReq!=null&&afReq)out.print("<td>Такой пользователь не зарегистрирован</td>");
                    }
                %>
            </table>
        </tr>
        <tr></tr><tr><td colspan="2" align="left"><input type="submit" name="outAllUsers" value="Показать всеx пользователей"  class="demo" /></td></tr>
        <tr>
            <%
                List<User>users= (List<User>) request.getAttribute("listUsers");
                if(users!=null){
                    out.println("<tr><table border=\"2\"><tr><td>Логин</td><td>Имя пользователя</td><td>Возраст</td><td>E-mail</td><td>Телефон</td></tr>");
                    for(User user:users){
                        out.println("<tr><td>"+user.getLogin()+"</td><td>"+user.getName()+"</td><td>"+user.getAge()+"</td><td>"+user.getEmail()+"</td><td>"+user.getPhone()+"</td></tr>");
                    }
                    out.println("</table>");
                    out.println("</tr>");
                }
            %>
        </tr>
        <tr><%
            if(error!=null)out.print("<h2>Ошибка: "+error+"</h2");
        %></tr>
    </table>
</form>
</body>
</html>
