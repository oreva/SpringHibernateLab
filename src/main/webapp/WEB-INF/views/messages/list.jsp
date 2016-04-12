<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 3/11/16
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <!--<form action="messages/result" method="GET">
            <input type="submit" value="Back"/>
        </form>-->
        <h3>You can find all stored messages below</h3>
        <table border="1">
            <tr>
                <th width="50">User ID</th>
                <th width="150">User Name</th>
                <th width="150">User Mail</th>
                <th width="150">User Phone</th>
                <th width="250">Message</th>
                <th width="350">Tags</th>
            </tr>
            <c:forEach items="${messages}" var="message">
                <tr>
                    <td>${message.userId}</td>
                    <td>${message.userName}</td>
                    <td>${message.userMail}</td>
                    <td>${message.userPhone}</td>
                    <td>${message.text}</td>
                    <td>${message.tagString}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>