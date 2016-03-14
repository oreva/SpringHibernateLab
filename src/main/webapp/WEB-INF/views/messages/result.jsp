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
        <h3>Your message has been successfully sent to our administrator. Thank you!</h3>

        <form action="messages">
            <input type="hidden" name="new" value="">
            <input type="submit" value="Create New Message">
        </form>
        <form action="messages/list">
            <input type="submit" value="Read All Messages">
        </form>
    </div>

</body>
</html>