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
    public static int add(Review review)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT MAX(ReviewID) FROM Reviews";

        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            rs.first();
            int id = (rs.getInt(1)+1);

            query = "INSERT INTO Reviews (ReviewID, UserID, MovieID, ReviewText, Rating)"
                + "VALUES (?, ?, ?, ?, ?)";

            try
            {
                ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                ps.setString(2, review.getUserID());
                ps.setString(3, review.getMovieID());
                ps.setString(4, review.getReviewText());
                ps.setString(5, review.getRating());
                return ps.executeUpdate();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                return 0;
            }
            finally
            {
                DBUtil.closePreparedStatement(ps);
                pool.freeConnection(connection);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }        
    }
    
    
  public static ArrayList<Review> selectReview(String movieID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Review> reviews=new ArrayList<Review>();
        System.out.println(movieID);
        
        //String query = "Select UserID, MovieID, ReviewText, Rating FROM Reviews WHERE MovieID =?";
       String query = "SELECT ReviewID, Reviews.UserID, UserName, Reviews.MovieID,"
                + " ReviewText, Rating, Score "
                + "FROM Reviews "
                + "INNER JOIN Users on Reviews.UserID = Users.UserID "
                + "JOIN Movies on Reviews.MovieID = Movies.MovieID "
                + "WHERE Reviews.MovieID = ?";
        try
        {   
            
            ps = connection.prepareStatement(query);
            ps.setString(1, movieID);
            rs = ps.executeQuery();
            Review review = null;
            while (rs.next())
            {
                review = new Review();
                review.setReviewID(rs.getString("ReviewID"));
                review.setUserID(rs.getString("Reviews.UserID"));
                review.setUserName(rs.getString("UserName"));
                review.setMovieID(rs.getString("Reviews.MovieID"));
                review.setReviewText(rs.getString("ReviewText"));
                review.setRating(rs.getString("Rating"));
                review.setScore(rs.getInt("Score"));
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
  
  
  
  public static ArrayList<Review> selectReviewByUser(String userID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Review> reviews=new ArrayList<Review>();
        System.out.println(userID);
        
        //String query = "Select UserID, MovieID, ReviewText, Rating FROM Reviews WHERE MovieID =?";
       String query = "SELECT ReviewID, Reviews.UserID, MovieName, Reviews.MovieID,"
                + " ReviewText, Rating, Score "
                + "FROM Reviews "
                + "INNER JOIN Movies on Reviews.MovieID = Movies.MovieID "
                + "JOIN Users on Reviews.UserID = Users.UserID " 
                + "WHERE Reviews.UserID = ?";
        try
        {   
            
            ps = connection.prepareStatement(query);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            Review review = null;
            while (rs.next())
            {
                review = new Review();
                review.setReviewID(rs.getString("ReviewID"));
                review.setUserID(rs.getString("Reviews.UserID"));
                review.setMovieName(rs.getString("MovieName"));
                review.setMovieID(rs.getString("Reviews.MovieID"));
                review.setReviewText(rs.getString("ReviewText"));
                review.setRating(rs.getString("Rating"));
                review.setScore(rs.getInt("Score"));
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
  
      public static int delete(String reviewID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String id = reviewID;
        
        String query = "DELETE FROM Reviews WHERE ReviewID = ?";
        
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);

            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
  
}