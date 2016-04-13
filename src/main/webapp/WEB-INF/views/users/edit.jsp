<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 4/13/16
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <h3>Edit user information</h3>
        <sf:form method="POST" modelAttribute="userStub">
            <fieldset>
                <table cellspacing="0">
                    <tr>
                        <th><label for="user_name">First Name</label></th>
                        <td><sf:input path="firstName" size="50" id="user_name"
                                      maxlength="100"/>
                            <small>Enter your first name</small><br/>
                            <sf:errors path="firstName" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="user_last_name">Last Name</label></th>
                        <td><sf:input path="lastName" size="50" id="user_last_name"
                                      maxlength="100"/>
                            <small>Enter your last name</small><br/>
                            <sf:errors path="lastName" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="user_email">Email Address</label></th>
                        <td><sf:input path="mail" type="email" id="user_email"/>
                            <small>Enter your email address</small><br/>
                            <sf:errors path="mail" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="user_phone">Phone Number</label></th>
                        <td><sf:input path="phone" size="10" id="user_phone"/>
                            <small>Enter your phone number</small><br/>
                            <sf:errors path="phone" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:button value="">Save</sf:button>
                        </td>
                    </tr>
                 </table>
             </fieldset>
         </sf:form>
    </div>
</body>
</html>