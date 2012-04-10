package movie;

import business.*;
import data.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Chappy
 */
public class EditMovieServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException
    {
        String movieID = request.getParameter("ID");
        String movieName = request.getParameter("movieName");
        String year = request.getParameter("year");
        String description = request.getParameter("description");
                
        HttpSession session = request.getSession();
        
        
        Movie movie = new Movie();
        movie.setID(movieID);
        movie.setName(movieName);
        movie.setYear(year);
        movie.setDescription(description);
        MovieDB.edit(movie);
        
        
        String url="/listReviews?ID="+movie.getID()+"&s=secure";
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
