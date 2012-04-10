/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import data.MovieDB;
import business.MovieItem;

/**
 *
 * @author Chappy
 */
public class ListMoviesServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        ArrayList<MovieItem> movies = new ArrayList<MovieItem>(MovieDB.listMovies());
        
        session.setAttribute("movies", movies);
        
        String url;
        String strSecure = request.getParameter("s");
        
        if(strSecure == null)       
            url = "/viewEntries.jsp";
        else if(strSecure.equals("secure"))
            url = "/Secure/viewEntries.jsp";    
        else 
            url = "/viewEntries.jsp";
        
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
