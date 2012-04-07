<%-- 
    Document   : viewEntries
    Created on : Apr 1, 2012, 2:19:33 PM
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies</title>
    </head>
    <body>
        <h1>Click a movie for details, ratings, and reviews!</h1>
        
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
    <c:forEach var="movie" items="${movies}">
    ${movie.name}<br>
    </c:forEach>
        
    </body>
</html>
