<%-- 
    Document   : addMovie
    Created on : Apr 6, 2012, 7:25:17 PM
    Author     : Chappy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <script language="JavaScript">
        function validate(form) {
            if (form.movieName.value=="") {
                alert("Please provide the movie's name");
                form.movieName.focus();
            }
            else if (form.year.value=="") {
                alert("Please enter the year of release");
                form.year.focus();
            }
            else if (form.description.value=="") {
                alert("Please enter a description");
                form.description.focus();
            }
            else {
                form.submit();
            }
        }
        </script>

        <body>

        <h1>Please fill the fields to add a new movie.</h1>

        <form action="addMovie" method="post">
            <table cellspacing="5" border="0">
                <tr>
                    <td align="right">Movie name:</td>
                    <td><input type="text" name="movieName" 
                            value="">
                    </td>
                </tr>
                <tr>
                    <td align="right">Year of release:</td>
                    <td><input type="text" name="year" 
                            value="">
                    </td>
                </tr>
                <tr>
                    <td align="right" valign="top">Description:</td>
                    <td><textarea name="description" rows=3 cols=30 
                            value=""></textarea>
                    </td>
                </tr>
                    <td></td>
                    <td><input type="button" value="Submit" 
                            onClick="validate(this.form)"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
