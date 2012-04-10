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
public class DeleteReviewServlet extends HttpServlet 
{
   protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        String reviewID = request.getParameter("ID");
        
        ReviewDB.delete(reviewID);
        
        String url = "/listUsers";
        RequestDispatcher dispatcher =
              getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}
