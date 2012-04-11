<%-- 
    Document   : viewMovieReviews
    Created on : Apr 7, 2012, 8:08:27 PM
    Author     : Kyle
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
                <style type="text/css">
h1, h2, h3{
color:#E0E01B;
}

p{
color:black;
}

th{
color:#E0E01B;
}

table{
wdith:100%;
align:center;
}
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${movie.name}</title>
    </head>
    <body>
        <h1>${movie.name}</h1>
        <table cellpadding ="5" border="1" width="50%">
            <tr align="left">
                <td><b>Year of Release</b></td>
                <td>${movie.year}</td>
            </tr>
            <tr>
                <td><b>Summary</b></td>
                <td>${movie.description}</td>
            </tr>
            <tr>
                <td><b>Average Rating</b></td>
                <td>
                    <%= request.getParameter("average") %>
                </td>
            </tr>
        </table>
                <br>
            <form action="listMovies" method="post">
            <input type="submit" value="Back to Movie List">
            </form>
                <br><br>
                <h2>Reviews of ${movie.name}</h2>
                <br>

        
                
                
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:forEach var="reviews" items="${reviews}">
        
        <table cellpadding ="5" border="1" width="70%" align="left">
            <tr align="left" width=70px>
                <td align="left" width=70px><b>User</td>
                <td align="left" width=70px><b>${reviews.userName}</td>
            </tr>
            <tr align="left">
                <td align="left" width=70px><b>Review</b></td>
                <td align="left" width=70px>${reviews.reviewText}</td>
            </tr>
            <tr align="left">
                <td align="left" width=70px><b>Rating</b></td>
                <td align="left" width=70px>${reviews.rating}</td>
            </tr>
            <tr align="left">
                <td align="left" width=70px><b>Did you find this review helpful?</b></td>
                <td align="left" width=70px>${reviews.score} people say YES!</td>
            </tr>
            <br>
        </table>
        <br><br><br>
    </c:forEach>
        
    </body>
</html>
