<%-- 
    Document   : viewUsers
    Created on : Apr 9, 2012, 5:14:02 PM
    Author     : Sheldon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Managing</title>
    </head>
    
    <body>
        <h1>User Management</h1>
        
        <table cellpadding=5 border=0>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><b>User</b></td>
                    <td><b>${user.userID}</td>
                    <td><b>${user.username}</td>
                    <td><a href="deleteUser?ID=${user.userID}" onClick="return confirm('Are you sure you want to delete this user?')">Delete This User</a></td>
                </tr>
            </c:forEach>
                <p>Well then, let's see if this works</p>
        </table>
                
    </body>
</html>
