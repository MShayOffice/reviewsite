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
//        int id = MovieDB.getID();
        MovieDB.add(movie);
        
//        int idTest = MovieDB.getID();
//        session.setAttribute("idTest", idTest);
        String url = "/listMovies";
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
