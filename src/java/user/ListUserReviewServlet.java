/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

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
 */public class ListUserReviewServlet extends HttpServlet
{
     @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        
        String userID = request.getParameter("ID");
        User user = UserDB.selectUserByUserID(userID);
        
 
        ArrayList<Review> reviews = new ArrayList<Review>();
        reviews = ReviewDB.selectReviewByUser(userID);
        
        session.setAttribute("user", user);
        session.setAttribute("reviews", reviews);
               
        
        String url;
        String strSecure = request.getParameter("s");
        
        if(strSecure == null)       
            url = "/viewUserReviews.jsp";
        else if(strSecure.equals("secure"))
            url = "/Secure/viewUserReviews.jsp";
        else 
            url = "/viewUserReviews.jsp";
        
        
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