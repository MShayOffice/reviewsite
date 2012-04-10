/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import business.User;
import data.UserDB;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Sheldon
 */
public class ListUsersServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        ArrayList<User> users = new ArrayList<User>(UserDB.selectUsers());
        
        session.setAttribute("users", users);
        
        String url = "/Secure/viewUsers.jsp";
        RequestDispatcher dispatcher =
              getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);                
    }
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        doGet(request, response);
    }    

}
