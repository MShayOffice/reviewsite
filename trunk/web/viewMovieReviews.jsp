<%-- 
    Document   : viewMovieReviews
    Created on : Apr 7, 2012, 8:08:27 PM
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:forEach var="reviews" items="${reviews}">
        ${Review.ReviewText}<br>
    </c:forEach>
    </body>
</html>
