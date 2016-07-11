<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 7/6/2016
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Assign Roles for the User</title>
</head>

<body>
    <div>
        <h3>Select roles for user ${userDTO.firstName} ${userDTO.lastName}:</h3>

        <sf:form modelAttribute="userDTO" method="POST">
            <sf:hidden path="id"/>
            <table>
                <tr>
                    <td></td>
                </tr>
                <c:forEach items="${roles}" var="currentRole">
                    <tr>
                        <td><sf:checkbox path="roles" value="${currentRole}" label="${currentRole}"/></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>
                        <sf:button value="save">Save</sf:button>
                        <sf:button value="cancel">Cancel</sf:button>
                    </td>
                </tr>
            </table>
        </sf:form>
    </div>
</body>
</html>
