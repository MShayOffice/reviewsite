/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import java.util.*;

import business.MovieItem;
/**
 *
 * @author Chappy
 */
public class MovieDB {
    public static ArrayList<MovieItem> listMovies()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<MovieItem> movies=new ArrayList<MovieItem>();
        
        String query = "SELECT MovieName, MovieID FROM Movies ORDER BY MovieName ASC";
        
        try
        {   
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            MovieItem movie = null;
            
            while (rs.next())
            {
                movie = new MovieItem();
                movie.setID(rs.getString("MovieID"));
                movie.setName(rs.getString("MovieName"));
                movies.add(movie);
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
        
        return movies;
    }
}
