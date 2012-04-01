<%-- 
    Document   : registerUser
    Created on : Apr 1, 2012, 1:56:14 PM
    Author     : Kyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Register User</h1>
        
        <form action="registerUser" method="post">
  <table cellspacing="5" border="0">

    <tr>
      <td align="right">Username:</td>
      <td><input type="text" name="usertName"></td>
    </tr>
    <tr>
      <td align="right">Email address:</td>
      <td><input type="text" name="emailAddress"></td>
    </tr>
    <tr>
        <td align="right">Confirm Email:</td>
        <td><input type="text" name="confirmEmailAddress"></td>
    </tr>
    <tr>
        <td align="right">Password:</td>
        <td><input type="text" name="password"></td>
    </tr>
    <tr>
        <td align="right">Confirm Password:</td>
        <td><input type="text" name="confirmPassword"></td>
    </tr>
    <tr>
      <td></td>
      <td><br><input type="submit" value="Submit"></td>
    </tr>
  </table>
  </form>
        
    </body>
</html>
