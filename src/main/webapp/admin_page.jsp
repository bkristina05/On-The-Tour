<%@ page import="domain.TypeName" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.User" %>
<%@ page import="domain.UserType" %>
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
        <tr></tr><tr><td colspan="2" align="left"><input type="submit" name="outAllUsers" value="Показать всеx пользователей"  class="demo" /></td></tr>
        <tr>
            <table border="2">
                <%
                    List<TypeName> listTypes= (List<TypeName>) request.getAttribute("listTypes");
                    List<UserType>userTypeList= (List<UserType>) request.getAttribute("userTypeList");
                    List<User>users= (List<User>) request.getAttribute("users");
                    if (users!=null){
                        out.print("<tr><td>Имя пользователя</td><td>Возраст</td><td>E-mail</td><td>Телефон</td><td>Статус</td></tr>");
                        for(User findUser:users){
                            out.print("<tr><td>"+findUser.getName()+"</td><td>"+findUser.getAge()+"</td><td>"+findUser.getEmail()+"</td><td>"+findUser.getPhone()+"</td><td>");
                            out.print("<select name=\""+findUser.getUser_id()+"\">");
                            Integer id_type_user=0;
                            for(UserType userType:userTypeList){
                                if(userType.getUser_id().intValue()==findUser.getUser_id().intValue())id_type_user=userType.getType_id();
                                if(userType.getUser_id().intValue()==findUser.getUser_id().intValue())break;
                            }
                            for(TypeName typeName:listTypes){
                                if(id_type_user.intValue()==typeName.getType_id().intValue()){
                                    out.print("<option selected value=\""+typeName.getType_id()+"\">"+typeName.getType_name()+"</option>\n");
                                }
                                else out.print("<option value=\""+typeName.getType_id()+"\">"+typeName.getType_name()+"</option>\n");
                            }
                            out.print("</select>");
                            out.print("</td></tr>");
                        }

                    }
                %>
            </table>
        <tr><td colspan="2" align="left"><input type="submit" name="saveUsers" width="20" value=" сохранить изменения"  class="demo" /></td></tr>
        </tr>
    </table>
</form>
</body>
</html>
