<%-- 
    Document   : viewMovieReviews
    Created on : Apr 7, 2012, 8:08:27 PM
    Author     : Kyle
--%>

<%@page import="data.UserDB"%>
<%@page import="business.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${movie.name}</title>
    </head>
    <body>
        <h1>${movie.name}</h1>
        <table cellpadding ="5" border="1">
            <tr>
                <td><b>Year of Release</b></td>
                <td>${movie.year}</td>
            </tr>
            <tr>
                <td><b>Summary</b></td>
                <td>${movie.description}</td>
            </tr>
            <tr>
                <td><b>Average Rating</b></td>
                <td></td>
            </tr>
        </table>
        <br><a href="editMovie.jsp" method="get">Edit this movie</a>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:forEach var="reviews" items="${reviews}">
        
        <table cellpadding ="5" border="1">
            <tr>
                <td><b>User</td>
                <td><b>${reviews.userName}</td>
            </tr>
            <tr>
                <td><b>Review</b></td>
                <td>${reviews.reviewText}</td>
            </tr>
            <tr>
                <td><b>Rating</b></td>
                <td>${reviews.rating}</td>
            </tr>
            <tr>
                <td><b>Did you find this review helpful?</b></td>
                <td>${reviews.score} people say YES!</td>
            </tr>
        </table>
        <br>
    </c:forEach>
        <br>
        <form action="viewEntries.jsp" method="post">
            <input type="submit" value="Back to Movie List">
        </form>
    </body>
</html>
