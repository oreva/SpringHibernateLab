<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 4/13/16
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
    function editUser(clickedId)
    {
        document.getElementById("userInput").value = clickedId;
        document.getElementById("editForm").action = "edit";
        console.log("JavaScript debug:: ");
        console.log(clickedId);
        document.editForm.submit();
    }

    function editUserRoles(clickedId)
    {
        document.getElementById("userInput").value = clickedId;
        document.getElementById("editForm").action = "editUserRoles";
        document.editForm.submit();
    }

    function deleteUser(clickedId)
    {
        document.getElementById("userInput").value = clickedId;
        document.getElementById("editForm").action = "delete";
        document.editForm.submit();
    }
</script>

<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <h3>You can find all stored users below</h3>
        <form id="editForm" name="editForm"  method="GET">
            <input type="hidden" name="user" id="userInput">
            <table border="1">
                <tr>
                    <th width="50">User ID</th>
                    <th width="150">First Name</th>
                    <th width="150">Last Name</th>
                    <th width="150">Mail</th>
                    <th width="150">Phone</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${users}" var="user1" varStatus="loop">
                    <tr>
                        <td>${user1.id}</td>
                        <td>${user1.firstName}</td>
                        <td>${user1.lastName}</td>
                        <td>${user1.mail}</td>
                        <td>${user1.phone}</td>
                        <td>
                            <input type="submit" value="Edit User" onclick="editUser(${user1.id})">
                        </td>
                        <td>
                            <input type="submit" value="Edit User Roles" onclick="editUserRoles(${user1.id})">
                        </td>
                        <td>
                            <input type="submit" value="Delete User" onclick="deleteUser(${user1.id})">
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
</body>
</html>