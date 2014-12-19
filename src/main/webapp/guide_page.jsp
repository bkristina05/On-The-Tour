<%@ page import="domain.User" %>
<%@ page import="domain.ExcursionGuide" %>
<%@ page import="domain.Excursion" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 17.12.2014
  Time: 20:04
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
<form method="POST" action="guide_page">
        <input type='hidden' name="user_id" value="${user_id}"/>
        <input type="hidden" name="login" value="${login}" />
    <table>
        <tr><td colspan="2" align="right"><input type="submit" name="goOnTour" value=" Записаться на тур"  class="demo" /></td></tr>
        <tr><td colspan="2" align="right"><input type="submit" name="getExcursions" value="Показать экскурсии"  class="demo" /></td>
        <td><%
                Map<ExcursionGuide, Excursion> setExcursions=(HashMap<ExcursionGuide, Excursion>)request.getAttribute("Excursions");
                Set<User> setTourists=(HashSet<User>)request.getAttribute("setTourists");
                Integer id=(Integer)request.getAttribute("id_excursion");
                out.println("<select name=\"select_excursion\">");
                if(setExcursions!=null)
                for (Map.Entry<ExcursionGuide, Excursion> exc: setExcursions.entrySet()){
                    Date date=new Date(exc.getKey().getDate_excurs());
                    GregorianCalendar calendar=new GregorianCalendar();
                    calendar.setTime(date);
                    Formatter f=new Formatter();
		            String stringDate=f.format(", %tR %tD", date,date).toString();
                   out.print("<option value=\""+exc.getKey().getSeq_excurs_guide()+"\">"+exc.getValue().getPlace()+", "+exc.getValue().getTown()+  stringDate+"</option>\n");

                }
            %>
        </td></tr>
        <tr><td colspan="2" align="right"><input type="submit" name="getTourists" value=" Показать туристов"  class="demo" /></td></tr>
        </table>
        <table border="2">
        <%
            if(setTourists!=null)
                if(!setTourists.isEmpty()){
                    if(id!=null)
                    for (Map.Entry<ExcursionGuide, Excursion> exc: setExcursions.entrySet()){
                        Date date=new Date(exc.getKey().getDate_excurs());
                        GregorianCalendar calendar=new GregorianCalendar();
                        calendar.setTime(date);
                        Formatter f=new Formatter();
                        String stringDate=f.format("%tR %tD", date,date).toString();
                        if(id.equals(exc.getKey().getSeq_excurs_guide()))out.println("<tr>Заявки на экскурсию \""+exc.getValue().getPlace()+", "+exc.getValue().getTown()+"\" на "+stringDate+"</tr>");
                    }


                    out.println("<tr><td>Имя туриста</td><td>Номер телефона</td><td>адрес электронной почты</td></tr>");
                    for(User tourist:setTourists){
                        out.println("<tr><td>"+tourist.getName()+"</td><td>"+tourist.getPhone()+"</td><td>"+tourist.getEmail()+"</td></tr>");
                    }
                }else {
                    if(id!=null)
                        for (Map.Entry<ExcursionGuide, Excursion> exc: setExcursions.entrySet()){
                            Date date=new Date(exc.getKey().getDate_excurs());
                            GregorianCalendar calendar=new GregorianCalendar();
                            calendar.setTime(date);
                            Formatter f=new Formatter();
                            String stringDate=f.format("%tR %tD", date,date).toString();
                            if(id.equals(exc.getKey().getSeq_excurs_guide()))out.println("<tr>Заявок на экскурсию \""+exc.getValue().getPlace()+", "+exc.getValue().getTown()+"\" на "+stringDate+" нет</tr>");
                        }
                }
        %>
    </table>
</form>

</body>
</html>
