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
        
        
<style type="text/css">
h1{
color:#E0E01B;
}

p{
color:black;
}

th{
color:#E0E01B;
}

table{
table-layout:fixed;
wdith:90%;
align:center;
}

</style>
        
        
        
        <title>Movies</title>
    </head>
    
    <body>
        <!-- banner -->

        <h1>Click a movie for details, ratings, and reviews!</h1>
        
        <table cellpadding=5 border=2>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td><a href="listReviews?ID=${movie.ID}&average=${movie.average}" method="get">${movie.name}</a></td>
                    
                    <!--<td><a href="deleteMovie?ID=${movie.ID}" onClick="return confirm('Do you want to delete this movie?')">X</a></td>-->
                </tr>
            </c:forEach>
        </table>
        <!--<br><a href="addMovie.jsp" method="get">Add a New Movie</a>-->
        
    </body>
</html>
