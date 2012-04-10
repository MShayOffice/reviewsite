<%-- 
    Document   : editMovie
    Created on : Apr 9, 2012, 12:49:52 PM
    Author     : Chappy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editing ${movie.name}</title>
    </head>
    
    <script language="JavaScript">
        function validate(form) {
            if (form.movieName.value=="") {
                alert("Please provide the movie's name.");
                form.movieName.focus();
            }
            else if (form.year.value=="") {
                alert("Please enter the year of release.");
                form.year.focus();
            }
            else if (form.description.value=="") {
                alert("Please enter a description.");
                form.description.focus();
            }
            else {
                form.submit();
            }
        }
    </script>
    
    <body>
        <h1>Editing ${movie.name}</h1>

        <form action="editMovie?ID=${movie.ID}" method="post">
            <table cellspacing="5" border="0">
                <tr>
                    <td align="right">Movie name:</td>
                    <td><input type="text" name="movieName" 
                            value="${movie.name}">
                    </td>
                </tr>
                <tr>
                    <td align="right">Year of release:</td>
                    <td><input type="text" name="year" 
                            value="${movie.year}">
                    </td>
                </tr>
                <tr>
                    <td align="right" valign="top">Description:</td>
                    <td><textarea name="description" rows=3 cols=30>${movie.description}</textarea>
                    </td>
                </tr>
                    <td></td>
                    <td><input type="button" value="Save" 
                            onClick="validate(this.form)"></td>
                </tr>
            </table>
        </form>
            <form action="listReviews?ID=${movie.ID}&s=secure" method="post">
            <input type="submit" value="Cancel" onClick="return confirm('Leave this page without saving changes?')">
        </form>
    </body>
</html>
