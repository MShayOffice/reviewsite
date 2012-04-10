/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import data.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Sheldon
 */
public class DeleteUserServlet extends HttpServlet 
{
   protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        String userID = request.getParameter("ID");
        
        UserDB.delete(userID);
        
        String url = "/listUsers";
        RequestDispatcher dispatcher =
              getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}
