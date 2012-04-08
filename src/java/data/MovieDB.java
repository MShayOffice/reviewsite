/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.*;
import java.sql.*;
import java.util.*;

import business.MovieItem;
/**
 *
 * @author Chappy
 */
public class MovieDB {
    public static int add(Movie movie)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;


        String query = "SELECT MAX(MovieID) FROM Movies";
        
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            int id = 0;
            
            id = rs.getInt("MovieID")+1;
            
            query = "INSERT INTO Movies (MovieID, MovieName, Year, Description)"
                    + "VALUES (?, ?, ?, ?)";

            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, movie.getName());
            ps.setString(3, movie.getYear());
            ps.setString(4, movie.getDescription());
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
