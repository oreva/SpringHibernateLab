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
                <p style="color:red">
                    <c:out value="Invalid username and password."/>
                    <br>
                </p>
            </c:if>

            <!-- Logged Out section -->
            <c:if test="${param.logout != null}">
                <p style="font-weight:bold">
                    <c:out value="You have been logged out."/>
                    <br>
                </p>
            </c:if>
            <p/>
            <p>
                <table cellspacing="2" cellpadding="2">
                    <thead>Enter your email address and password to login:</thead>
                    <br/>
                    <tr>
                        <th align="left"><label for="username">Username (email)</label></th>
                        <td><input type="text" id="username" name="username"/></td>
                    </tr>
                    <tr>
                        <th align="left"><label for="password">Password</label></th>
                        <td><input type="password" id="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td align="right"><input type="submit" value="Log in"></td>
                    </tr>
                </table>
            </p>

            <!--<b>Enter your email address and password to login:</b>
            <p>
                <label for="username">Username (email)</label>
                <input type="text" id="username" name="username"/>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
            </p>
            <input type="submit" value="Log in">-->
        </form>
        <form action="users/register" method="get">
            <b>Or register new account:</b>
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
