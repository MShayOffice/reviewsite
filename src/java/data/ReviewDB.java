/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Kyle
 */
public class ReviewDB extends HttpServlet {

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
    
  public static ArrayList<Review> selectReview(String movieID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Review> reviews=new ArrayList<Review>();
        
        String query = "SELECT Reviews.UserID, UserName, Reviews.MovieID,"
                + " MovieName, Year, Description, ReviewText, Rating"
                + "FROM Reviews"
                + "INNER JOIN Users on Reviews.UserID = Users.UserID "
                + "JOIN Movies on Reviews.MovieID = Movies.MovieID;"
                + "WHERE MovieID = ?";
        
        try
        {   
            ps = connection.prepareStatement(query);
            ps.setString(1, movieID);
            rs = ps.executeQuery();
            Review review = null;
            
            while (rs.next())
            {
                review = new Review();
                review.setUserID(rs.getString("UserID"));
                review.setMovieID(rs.getString("MovieID"));
                review.setReviewText(rs.getString("ReviewText"));
                review.setRating(rs.getString("Rating"));
                reviews.add(review);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        return reviews;
    }
}