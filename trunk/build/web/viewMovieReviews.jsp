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
        <title>${movieID}</title>
    </head>
    <body>
        <h1>${test}</h1>
        <h2>${movie.name}</h2>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:forEach var="reviews" items="${reviews}">
        ${review.ReviewText}<br>
    </c:forEach>
        test
    </body>
</html>
