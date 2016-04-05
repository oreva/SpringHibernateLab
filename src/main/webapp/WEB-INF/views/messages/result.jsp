<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 3/8/16
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <h3>Please, select one of the following actions:</h3>

        <form action="messages" method="GET">
            <input type="hidden" name="new" value="">
            <input type="submit" value="Create New Message">
        </form>
        <form action="messages" method="GET">
            <input type="hidden" name="listCurrent" value="">
            <input type="submit" value="Read Your Messages">
        </form>
        <form action="messages" method="GET">
            <input type="hidden" name="list" value="">
            <input type="submit" value="Read All Messages">
        </form>
        <form action="messages" method="GET">
            <table cellspacing="0">
                <tr>
                    <jsp:text>Read Messages for user with id =</jsp:text>
                    <input name="list" type="text" value=""/>
                    <input type="submit" value="Read"/>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>