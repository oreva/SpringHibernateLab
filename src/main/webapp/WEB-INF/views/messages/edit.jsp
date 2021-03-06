<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 3/8/16
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <h3>Create new message</h3>

        <sf:form method="POST" modelAttribute="messageStub">
            <sf:hidden path="id"/>
            <fieldset>
                <table cellspacing="0">
                    <tr>
                        <th><label for="user_message">Message:</label></th>
                        <td><sf:textarea path="text" maxlength="250"
                                         rows="5" cols="80"
                                         id="user_message"/>
                            <small id="msg_area">Enter you message</small><br/>
                            <sf:errors path="text" cssStyle="color:red;font-size:small"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="message_tags">Tags:</label></th>
                        <td><sf:textarea path="tagString" maxlength="1000"
                                         rows="5" cols="80"
                                         id="message_tags"/>
                            <small id="tags_area">Enter message tags</small><br/>
                            <sf:errors path="tagString" cssStyle="color:red;font-size:small"/>
                        </td>
                    </tr>
                    <tr>
                        <td><sf:button value="">Send Message</sf:button>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </sf:form>

        <!--<form action="edit">
            <input type="input" name="phone" value="">
            <input type="input" name="mail" value="">
            <input type="input" name="textMessage" value="">
        </form>     -->
    </div>
</body>
</html>