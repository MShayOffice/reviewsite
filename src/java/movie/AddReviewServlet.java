/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import business.*;
import data.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Sheldon
 */
public class AddReviewServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException
    {
        String userID = request.getParameter("userID");
        String movieID = request.getParameter("movieID");
        String reviewText = request.getParameter("reviewText");
        String rating = request.getParameter("rating");
        
        
        HttpSession session = request.getSession();
        
        Review review = new Review();
        review.setUserID(userID);
        review.setMovieID(movieID);
        review.setReviewText(reviewText);
        review.setRating(rating);
        ReviewDB.add(review);
        
        String url = "/Secure/index.jsp";
        RequestDispatcher dispatcher =
              getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        doPost(request, response);
    }    

}
