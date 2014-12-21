<%@ page import="domain.User" %>
<%@ page import="domain.ExcursionGuide" %>
<%@ page import="domain.Excursion" %>
<%@ page import="java.util.*" %>
<%@ page import="domain.ExcursionTourist" %>
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
        <tr>
        <table border="2">
        <%
            List<ExcursionTourist>excTourists= (List<ExcursionTourist>) request.getAttribute("listExcursionTourist");
            if(excTourists!=null)
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

                    out.println("<tr><td>Номер заявки</td><td>Количество человек</td><td>Имя туриста</td><td>Номер телефона</td><td>адрес электронной почты</td></tr>");
                    User tourist=new User();
                    for(ExcursionTourist excursionTourist:excTourists){
                        for(User user:setTourists){
                            if((int)excursionTourist.getUser_id()==(int)user.getUser_id()){
                                tourist=user;
                            }
                            if(excursionTourist.getUser_id()==user.getUser_id())break;
                        }
                        out.println("<tr><td>"+excursionTourist.getSequence_id()+"</td><td>"+excursionTourist.getTourist_quantity()+"</td><td>"+tourist.getName()+"</td><td>"+tourist.getPhone()+"</td><td>"+tourist.getEmail()+"</td></tr>");
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

        </table></tr>
            <table>
            <tr><td colspan="2" align="left"><input type="submit" name="addExcursion" value="Добавление/редактирование экскурсий"  class="demo" /></td></tr>
            <tr><td colspan="2" align="left"><input type="submit" name="appointExcursion" value="Назначить экскурсию"  class="demo" /></td></tr>
            </table>
            <%
                List<Excursion>excList= (List<Excursion>) request.getAttribute("listExc");
                Boolean isAppExc= (Boolean) request.getAttribute("isAppExc");

                if(isAppExc!=null){
                    out.println("<table board=\"2\"><tr>");
                    out.println("<td>Экскурсия</td><td>Дата экскурсии</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<select name=\"appExcurs\">");
                    for(Excursion excursion:excList){
                        out.print("<option value=\""+excursion.getExcurs_id()+"\">");
                        out.print(excursion.getPlace()+", "+excursion.getTown());
                        out.println("</option>");
                    }
                    out.println("</select>");
                    out.println("</td>");
                    out.print("<td>");
                    out.print("<input type=\"datetime-local\" name=\"calendar\"/>");
                    out.print("</td>");
                    out.println("</tr></table>");
                    out.println("<tr><td colspan=\"2\" align=\"left\"><input type=\"submit\" name=\"saveAppointEcursion\" value=\"Сохранить назначенную экскурсию\"  class=\"demo\" /></td></tr>");
                }
            %>
    </table>
</form>
</body>
</html>
