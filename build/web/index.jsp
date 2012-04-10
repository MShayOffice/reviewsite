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
        <title>Main Page</title>
    </head>
    <body>
        <h1>Main Page</h1>
        <p>Please select an option: </p>
        <a href="registerUser.jsp" method="get">User Registration</a><br>
        <a href="Secure/index.jsp" method="get">Login</a><br><br>
        <a href="listMovies" method="get">View Movies and Reviews</a><br>
        
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