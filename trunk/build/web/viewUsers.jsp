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
        <title>User Managing</title>
    </head>
    
    <body>
        <h1>User Management</h1>
        
        <table cellpadding=10 border=1>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:forEach var="users" items="${users}">
                <tr>
                    <td><b>User</b></td>
                    <td><b>${users.userID}</td>
                   
                    <td><a href="deleteUser?ID=${users.userID}" onClick="return confirm('Are you sure you want to delete this user?')">Delete This User</a></td>
                </tr>
            </c:forEach>
        </table>
            Well it works. Just not names. <br>
                user.username works, but it doesn't actually give names<br>
                users.username just fucking makes it mad
                
    </body>
</html>
