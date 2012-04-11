<%-- 
    Document   : index
    Created on : Apr 1, 2012, 1:47:01 PM
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Control Panel</title>
    </head>
    <body>
        <h1>User Control Panel</h1>
        <p>Choose: </p>
        <%@ page import="business.User" %>
        <%@ page import="data.UserDB" %>
        
        <%          
            String  username = request.getUserPrincipal().getName();
            User u = new User();
            u = UserDB.selectUserByUsername(username);
            session.setAttribute("user", u);
        %>
        <a href="listMovies?s=secure" method="get">Manage Movies and Reviews</a><br>
        <a href="listUsers" method="get">Manage Users</a><br>
    </body>
</html>


<%-- 
    servlet for:
-logging in
-logged out
-registering (verify registration)
-connecting pool
-create database, connect database, write to database
-deleting users
-deleting movies
-check if user wrote review
-calculate movie score
--%>