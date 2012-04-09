/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import business.User;
import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;

import data.MailUtilGmail;
        
/**
 *
 * @author Kyle
 */
public class AddUserServlet extends HttpServlet {

    
   private void sendEmail(String urlcode, String username, String emailAddress){
    // send email to user
        String to = emailAddress;
        String from = "reviewsite.info3120@gmail.com";
        String subject = "Welcome to our Review Movie Site";
        String body = "Dear " + username + ",\n\n" +
            "Thanks for joining our Review Movie Site. " + "\n\n" +
                "Please visit the following link to finish the registration process\n\n" +
                "http://localhost:8080/ReviewSite/ComfirmNewUser?urlcode=" +
                urlcode +
                "\n" +
                "Have a great day and thanks again!\n\n" +
                "Review Movie Site\n";
        boolean isBodyHTML = false;

        try
        {
            //MailUtilLocal.sendMail(to, from, subject, body, isBodyHTML);
            MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);
        }
        catch (MessagingException e)
        {
            String errorMessage = 
                "ERROR: Unable to send email. " + 
                    "Check Tomcat logs for details.<br>" +
                "NOTE: You may need to configure your system " + 
                    "as described in chapter 15.<br>" +
                "ERROR MESSAGE: " + e.getMessage();
            //request.setAttribute("errorMessage", errorMessage);
            this.log(
                "Unable to send email. \n" +
                "Here is the email you tried to send: \n" +
                "=====================================\n" +
                "TO: " + emailAddress + "\n" +
                "FROM: " + from + "\n" +
                "SUBJECT: " + subject + "\n" +
                "\n" +
                body + "\n\n");
        }
    }
    
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String emailAddress = request.getParameter("emailAddress");

        //insert data to pending user table
        String urlcode = UserDB.insertPending(username, password, emailAddress);
               
        //email link to user
        sendEmail(urlcode, username, emailAddress);
        
       
//        User user = new User();
//        user.setUserName(username);
//        user.setPassword(password);
//        user.setEmailAddress(emailAddress);
//        UserDB.insert(user);
               
        String url = "/index.jsp";
        RequestDispatcher dispatcher =
              getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    }


