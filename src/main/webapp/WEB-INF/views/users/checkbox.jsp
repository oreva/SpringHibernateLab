<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 7/11/2016
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<h2>Select Languages:</h2>

<form ACTION="jspCheckBox.jsp">
    <input type="checkbox" name="id" value="Java"> Java<BR>
    <input type="checkbox" name="id" value=".NET"> .NET<BR>
    <input type="checkbox" name="id" value="PHP"> PHP<BR>
    <input type="checkbox" name="id" value="C/C++"> C/C++<BR>
    <input type="checkbox" name="id" value="PERL"> PERL <BR>
    <input type="submit" value="Submit">
</form>
<%

    String select[] = request.getParameterValues("id");
    if (select != null && select.length != 0) {
        out.println("You have selected: ");
        for (int i = 0; i < select.length; i++) {
            out.println(select[i]);
        }
    }
%>
</html>
