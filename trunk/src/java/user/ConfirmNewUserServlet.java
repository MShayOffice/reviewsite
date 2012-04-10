/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jason Wong
 */
public class ComfirmNewUserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String urlcode = request.getParameter("urlcode");
        
        try {
            String err = UserDB.checkPending(urlcode);
            
            if(err == null){               
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();        
                out.println(
                "<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n"
                + "<html>\n"
                + "<head>\n"
                + "  <title>Murach's Java Servlets and JSP</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>You've successfully joined Review Movie Site. Thanks for joining</h1>\n\n\n"
                + "<form action=\"index.jsp\" "
                + "      method=\"post\">\n"
                + "  <input type=\"submit\" value=\"Return\">\n"
                + "</form>\n"
                + "</body>\n"
                + "</html>\n");
                out.close();
            }
            else{
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();        
                out.println(
                "<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n"
                + "<html>\n"
                + "<head>\n"
                + "  <title>Murach's Java Servlets and JSP</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Error</h1>\n\n"
                + err + "\n\n"
                + "<form action=\"login.jsp\" "
                + "      method=\"post\">\n"
                + "  <input type=\"submit\" value=\"Return\">\n"
                + "</form>\n"
                + "</body>\n"
                + "</html>\n");
                out.close();
            }
                
        } 
        finally {            
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
