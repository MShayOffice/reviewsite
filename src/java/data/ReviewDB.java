/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.MovieItem;
import business.Review;
import business.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kyle
 */
public class ReviewDB{

    
  public static ArrayList<Review> selectReview(String movie)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Review> reviews=new ArrayList<Review>();
        
        String query = "SELECT Reviews.UserID, UserName, Reviews.MovieID,"
                + " MovieName, Year, Description, ReviewText, Rating FROM "
                + "Reviews INNER JOIN Users on Reviews.UserID = Users.UserID "
                + " JOIN Movies on Reviews.MovieID = Movies.MovieID;" +
                       "WHERE MovieName = ?";
        
        try
        {   
            ps = connection.prepareStatement(query);
            ps.setString(1, movie);
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