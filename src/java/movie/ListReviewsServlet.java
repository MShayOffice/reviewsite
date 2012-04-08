/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import business.Review;
import data.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Kyle
 */public class ListReviewsServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        
        HttpSession session = request.getSession();
        String MovieID = request.getParameter("ID");
        ArrayList<Review> reviews = new ArrayList<Review>(ReviewDB.selectReview(MovieID));
        
        session.setAttribute("reviews", reviews);
        
        String url = "/viewMovieReviews.jsp";
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
