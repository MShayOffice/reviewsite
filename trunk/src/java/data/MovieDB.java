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
            rs.first();
            int id = (rs.getInt(1)+1);

            query = "INSERT INTO Movies (MovieID, MovieName, Year, Description)"
                + "VALUES (?, ?, ?, ?)";

            try
            {
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
    
    public static int delete(String movieID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String id = movieID;
        
        String query = "DELETE FROM Movies WHERE MovieID = ?";
        
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
//    
//    public static int edit(String movieID)
//    {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        
//        String id = movieID;
//    }            
//    
    public static int getID()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT MAX(MovieID) FROM movies";
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            rs.first();
            int id = (rs.getInt(1)+1);
            return id;
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
        public static Movie findMovie(String movieID)
        {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT * FROM Movie WHERE MovieID = ?";
            
            try
            {
                ps = connection.prepareStatement(query);
                ps.setString(1, movieID);
                rs = ps.executeQuery();
                Movie movie = null;
                if (rs.next())
                {
                    movie = new Movie();
                    movie.setID(rs.getString("MovieID"));
                    movie.setName(rs.getString("MovieName"));
                    movie.setYear(rs.getString("Year"));
                    movie.setDescription(rs.getString("Description"));
                }
                return movie;
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
        }
}
