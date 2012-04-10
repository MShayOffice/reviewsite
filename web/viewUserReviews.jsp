<%-- 
    Document   : viewUserReviews
    Created on : Apr 10, 2012, 3:39:45 AM
    Author     : Sheldon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${user.userName}</title>
    </head>
    <body>
        <h1>${user.userName}</h1>
        <table cellpadding ="5" border="1">
            <tr>
                <td><b>User ID</b></td>
                <td>${user.userID}</td>
            </tr>
            <tr>
                <td><b>Email Address</b></td>
                <td>${user.emailAddress}</td>
            </tr>
        </table>
        
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:forEach var="reviews" items="${reviews}">
        
        <table cellpadding ="5" border="1">
            <tr>
                <td><b>Movie</td>
                <td><b>${reviews.movieName}</td>
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
                <td><b>Who found this review helpful?</b></td>
                <td>${reviews.score} people found it helpful.</td>
            </tr>
            <tr>
                <td><b><a href="deleteReview?ID=${review.reviewID}" onClick="return confirm('Are you sure you want to delete this review?')">Delete This Review</a></b></td>
            </tr>
        </table>
        <br>
    </c:forEach>
        <br>
        <form action="listUsers" method="post">
            <input type="submit" value="Back to User List">
        </form>
    </body>
</html>