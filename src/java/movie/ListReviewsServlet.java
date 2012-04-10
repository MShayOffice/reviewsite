/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import business.*;
import data.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author Kyle
 *
 */public class ListReviewsServlet extends HttpServlet
{
     @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String movieID = request.getParameter("ID");
        
        Movie movie = MovieDB.findMovie(movieID);
        
        ArrayList<Review> reviews = new ArrayList<Review>();
        
        reviews = ReviewDB.selectReview(movieID);
        System.out.println(reviews);
        session.setAttribute("movie", movie);
        session.setAttribute("reviews", reviews);
               
        
        String url;
        String strSecure = request.getParameter("s");
        
        if(strSecure == null)       
            url = "/viewMovieReviews.jsp";
        else if(strSecure.equals("secure"))
            url = "/Secure/viewMovieReviews.jsp";
        else 
            url = "/viewMovieReviews.jsp";
        
        
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
