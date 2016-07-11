<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 7/5/2016
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Confirm User Deletion</title>

    <script type="text/javascript">
        function proceed(actionToDo)
        {
            document.getElementById("action").value = actionToDo;
            document.userForm.submit();
        }
    </script>
</head>
<body>
    <h3>Are you sure you want to delete this user? </h3>
    <div>
        <sf:form modelAttribute="userStub" method="POST" id="userForm" name="userForm">
            <sf:hidden path="id"/>
            <sf:hidden path="firstName" id="action"/> <!-- we use firstName field here only as a string field to send 'delete' or 'cancel' action parameter -->
            <table style="text-align: right">
                <tr>
                    <th>User's First Name: </th>
                    <td style="text-align: left">${userStub.firstName}</td>
                </tr>
                <tr>
                    <th>User's Last Name: </th>
                    <td style="text-align: left">${userStub.lastName}</td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td style="text-align: left">${userStub.mail}</td>
                </tr>
                <tr>
                    <td>
                        <!--<button value="delete">Delete</button>-->
                        <input type="button" onclick="proceed('delete')" value="Delete">
                    </td>
                    <td style="text-align: left">
                        <!--<button value="cancel">Cancel</button>-->
                        <input type="button" onclick="proceed('cancel')" value="Cancel">
                    </td>
                </tr>
            </table>
        </sf:form>
    </div>
</body>
</html>
