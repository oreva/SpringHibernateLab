<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 4/27/2016
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
    <div>
        <form action="login" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <!-- Login Error section -->
            <c:if test="${param.error != null}">
                <c:out value="Invalid username and password."/>
                <br>
            </c:if>
            <!-- Logged Out section -->
            <c:if test="${param.logout != null}">
                <c:out value="You have been logged out."/>
                <br>
            </c:if>
            <p>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
            </p>
            <input type="submit" value="Log in">
        </form>
    </div>
</body>
</html>
