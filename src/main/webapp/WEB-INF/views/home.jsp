<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 1/19/16
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <div>
        <c:choose>
            <c:when test="${pageContext.request.remoteUser != null}">
                <h2>Spring Security User Logged In: <c:out value="${pageContext.request.remoteUser}"/></h2>
            </c:when>
            <c:otherwise>
                <h2>No Remote User</h2>
            </c:otherwise>
        </c:choose>
        <div>
            <form action="logout" method="post">
                <input type="submit" value="Log out" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>

        <div>
            <h3>You can select one of the following actions and proceed:</h3>

            <h4>Messages</h4>
            <form action="messages/new" method="GET">
                <input type="submit" value="Create New Message">
            </form>
            <form action="messages/list" method="GET">
                <input type="hidden" name="listCurrent" value="">
                <input type="submit" value="Read Your Messages">
            </form>
            <form action="messages/list" method="GET">
                <input type="hidden" name="list" value="">
                <input type="submit" value="Read All Messages">
            </form>

            <h4>Users</h4>
            <form action="users/editProfile" method="GET">
                <input type="submit" value="Edit Your Profile"/>
            </form>
            <form action="users/list" method="GET">
                <input type="submit" value="View Users"/>
            </form>

            <h4>Tags</h4>
            <form action="tags/list" method="GET">
                <input type="submit" value="View All Tags"/>
            </form>
        </div>
    </div>
</body>
</html>