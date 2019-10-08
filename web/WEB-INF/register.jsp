<%-- 
    Document   : register
    Created on : 7-Oct-2019, 9:48:41 PM
    Author     : 657306
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List!</h1>
        <form method="POST">
            <div>Username:&nbsp;
                <input type="text" value="${username}">&nbsp;
                <input type="submit" value="Register name">
                <input type="hidden" name="action" value="register">
            </div><br>
            ${sysMsg}
        </form>
    </body>
</html>
