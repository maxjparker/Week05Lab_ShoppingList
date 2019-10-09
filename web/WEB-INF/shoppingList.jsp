<%-- 
    Document   : shoppingList
    Created on : 7-Oct-2019, 9:48:50 PM
    Author     : 657306
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List!</h1>
        <div>
            Hello, ${username}&nbsp;
        </div>
        <div>
            <a href="shoppingList?logout">Logout</a>
        </div>
        
        <h2>List</h2>
        <form method="POST">
            <div>Add item: <input type="text" name="item" value="">
                <input type="submit" value="Add">
                <input type="hidden" name="action" value="add">
            </div><br>
        </form>
        <!--    for (String item : items) {
                    sout(item)
                }
        -->
        <c:forEach var="item" items="${items}">
            ${item}
        </c:forEach>
    </body>
</html>
