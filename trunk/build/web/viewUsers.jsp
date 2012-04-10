<%-- 
    Document   : viewUsers
    Created on : Apr 9, 2012, 5:14:02 PM
    Author     : Sheldon
--%>

<%@page import="data.*"%>
<%@page import="business.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    
    <body>
        <h1>User Management</h1>
        
        <table cellpadding=5 border=1>
            <tr>
                <td><b>Username</b></td>
                <td><b>User ID</b></td>
                <td><b>Email Address</b></td>
            </tr>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.userName}</td>
                    <td>${user.userID}</td>
                    <td>${user.emailAddress}</td>
                    <td><a href="deleteUser?ID=${user.userID}" onClick="return confirm('Are you sure you want to delete this user?')">Delete This User</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
