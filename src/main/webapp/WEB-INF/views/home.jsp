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
            <form action="users/list" method="GET">
                <input type="submit" value="View Users"/>
            </form>

            <h4>Tags</h4>
            <form action="tags/list" method="GET">
                <input type="submit" value="View All Tags"/>
            </form>
        </div>

        <!--<form method="get" action="messages/result">
            <input type="submit" value="Go on">
        </form>-->

        <!-- Old code, ignore this -->
        <!--<h3>Enter user id to login</h3>
        <sf:form method="POST" modelAttribute="userStub">
            <input type="hidden" name="login" value=""/>
            <fieldset>
                <table cellspacing="0">
                    <tr>
                        <th><label for="user_id">User ID</label></th>
                        <td><sf:input path="id" size="10" id="user_id" maxlength="10"/>
                            <small>Enter existing user id</small><br>
                            <small>${errorStr}</small>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:button value="">Login</sf:button>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </sf:form>
        <form method="GET" action="users/register">
            <fieldset>
                <table cellspacing="0" border="0">
                    <tr>
                        <td>
                            <h4>Or register new account:</h4>
                            <button value="">Create account</button>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>-->
    </div>
</body>
</html>