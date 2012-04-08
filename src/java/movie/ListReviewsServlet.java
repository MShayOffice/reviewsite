/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import business.Review;
import data.MovieDB;
import data.ReviewDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kyle
 */public class ListReviewsServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        String movie = request.getParameter("movie");
        HttpSession session = request.getSession();
        ArrayList<Review> reviews = new ArrayList<Review>(ReviewDB.selectReview(movie));
        
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
