<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 17.12.2014
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="domain.TypeName" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.User" %>
<%@ page import="domain.UserType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <style> <%@include file='css/style.css' %> </style>
    <title>Домашняя страница администратора</title>
</head>

<body>

<table cellpadding="0" cellspacing="0" width="100%" align="center">
    <tr>
        <td colspan="3" class="header"></td>
    </tr>

    <tr>
        <td colspan="3" class="header1">
            <h1>${login}</h1>
            <form method="POST" action="admin_page">
                <input type="hidden" name="login" value="${login}" />
                <input type="submit" name="goOnTour" value=" Записаться на тур"  class="demo" />
            </form>
        </td>
    </tr>

    <tr>
        <td class="center_col">
            <form method="POST" action="admin_page">
                <input type="hidden" name="login" value="${login}" />
               <table>
                <tr><td colspan="2" align="left"><input type="submit" name="outAllUsers" value="Показать всеx пользователей"  class="demo" /></td></tr>
                </table>
                <%

                    out.println("<table border=\"2\">");
                    List<TypeName> listTypes= (List<TypeName>) request.getAttribute("listTypes");
                    List<UserType>userTypeList= (List<UserType>) request.getAttribute("userTypeList");
                    List<User>users= (List<User>) request.getAttribute("users");
                    String success= (String) request.getAttribute("success");
                    if (users!=null){
                        out.print("<tr><td>Имя пользователя</td><td>Возраст</td><td>E-mail</td><td>Телефон</td><td>Статус</td></tr>");
                        for(User findUser:users){
                            out.print("<tr><td>"+findUser.getName()+"</td><td>"+findUser.getAge()+"</td><td>"+findUser.getEmail()+"</td><td>"+findUser.getPhone()+"</td>");
                            out.print("<td><select name=\""+findUser.getUser_id()+"\">");
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
                    out.print("</table>");
                %>

                <div align="left"><input type="submit" name="saveUsers" width="20" value=" сохранить изменения"  class="demo" /></div>
                <%
                    if(success!=null)out.print("<h3>"+success+"</h3>");
                %>
            </form>
        </td>
        <td class="right_col2"></td>
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
