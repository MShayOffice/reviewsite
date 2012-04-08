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
public class AddMovieServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException
    {
        String movieName = request.getParameter("movieName");
        String year = request.getParameter("year");
        String description = request.getParameter("description");
        
        HttpSession session = request.getSession();
        
        Movie movie = new Movie();
        movie.setName(movieName);
        movie.setYear(year);
        movie.setDescription(description);
        MovieDB.add(movie);
        
        String url = "/listMovies";
        RequestDispatcher dispatcher =
              getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
