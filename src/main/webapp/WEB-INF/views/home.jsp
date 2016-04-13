<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 1/19/16
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <div>
        <h3>Enter user id to login</h3>
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
        <form method="GET" action="users/edit">
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
        </form>
    </div>
</body>
</html>