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
        <h3>Enter user information</h3>
        <sf:form method="POST" modelAttribute="userStub">
            <sf:hidden path="id"/>
            <fieldset>
                <table cellspacing="0">
                    <tr>
                        <th><label for="user_name">First Name</label></th>
                        <td><sf:input path="firstName" size="50" id="user_name"
                                      maxlength="100"/>
                            <small>Enter first name</small><br/>
                            <sf:errors path="firstName" cssStyle="color:red;font-size:small"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="user_last_name">Last Name</label></th>
                        <td><sf:input path="lastName" size="50" id="user_last_name"
                                      maxlength="100"/>
                            <small>Enter last name</small><br/>
                            <sf:errors path="lastName" cssStyle="color:red;font-size:small"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="user_email">Email Address</label></th>
                        <td><sf:input path="mail" type="email" id="user_email"/>
                            <small>Enter email address</small><br/>
                            <sf:errors path="mail" cssStyle="color:red;font-size:small"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="user_phone">Phone Number</label></th>
                        <td><sf:input path="phone" size="10" id="user_phone"/>
                            <small>Enter phone number</small><br/>
                            <sf:errors path="phone" cssStyle="color:red;font-size:small"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="user_password">Password</label> </th>
                        <td><sf:input path="password" size="20" id="user_password"/>
                            <small>Password should be 5 to 20 characters long</small><br/>
                            <sf:errors path="password" cssStyle="color:red;font-size:small"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="user_confirmPassword">Confirm Password</label> </th>
                        <td><sf:input path="confirmPassword" size="20" id="user_confirmPassword"/>
                            <small>Enter your password again</small><br/>
                            <sf:errors path="confirmPassword" cssStyle="color:red;font-size:small"/>
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