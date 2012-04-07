/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import business.User;
import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kyle
 */
public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       
        HttpSession session = request.getSession();

        // TODO: add code that gets the User object from the session and updates the database
        String emailAddress = request.getParameter("emailAddress");

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmailAddress(emailAddress);
        UserDB.insert(user);
               
        String url = "/index.jsp";
        RequestDispatcher dispatcher =
              getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    }


