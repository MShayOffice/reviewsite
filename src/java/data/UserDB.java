package data;

import java.sql.*;
import java.util.*;
import java.math.BigInteger;
import java.security.SecureRandom;

import business.User;

public class UserDB
{
    
    public static String insertPending(String username,
            String password,
            String emailaddress)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        SecureRandom random = new SecureRandom();
        String urlcode = new BigInteger(130, random).toString(32);
            
        String query = 
                "INSERT INTO pendinguser (Username, Password, EmailAddress, URL) " +
                "VALUES (?, ?, ?, ?)";
        
        try
        {           
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, emailaddress);
            ps.setString(4, urlcode);
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            return e.getMessage();
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        return urlcode;
    }
    
       public static int deletePending(String urlcode) throws SQLException
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "DELETE FROM pendinguser " +
                "WHERE URL = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, urlcode);

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
    
        /**
     
     * Handles the HTTP
     * <code>checkPending</code> method.
     *
     * @param urlcode string
     * @throws SQLException if a SQL-specific error occurs
     */
      public static String checkPending(String urlcode)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "Select * FROM pendinguser " +
                "WHERE URL = ?";
        
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, urlcode);
            rs = ps.executeQuery();
            
            User objUser = null;
            if (rs.next())
            {
                objUser = new User();
                objUser.setUserName(rs.getString("Username"));
                objUser.setPassword(rs.getString("Password"));
                objUser.setEmailAddress(rs.getString("EmailAddress"));
                insert(objUser);
                insertRole(objUser, "ReviewCreator");
                deletePending(rs.getString("URL"));
            }            
        }
        catch (SQLException e){
            
            return e.getMessage();
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return null;
    }
    
    private static int insertRole(User user, String userrole) throws SQLException
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO UserRole (UserName, RoleName) " +
                "VALUES (?, ?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, userrole);
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
      
      
    public static int insert(User user) throws SQLException
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO Users (UserName, Password, EmailAddress) " +
                "VALUES (?, ?, ?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmailAddress());
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
    
    public static int update(User user)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE Users SET " +
                "UserName = ?, " +
                "Password = ? " +
                "WHERE EmailAddress = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmailAddress());

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
    
    public static int delete(String userID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String id = userID;
        
        String query = "DELETE FROM Users WHERE UserID = ?";
        
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
    
    public static boolean emailExists(String emailAddress)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT EmailAddress FROM Users " +
                "WHERE EmailAddress = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
        public static User selectUserByUsername(String username)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Users " +
                       "WHERE Username = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next())
            {
                user = new User();
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmailAddress(rs.getString("emailAddress"));
            }
            return user;
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
    
    public static User selectUser(String emailAddress)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Users " +
                       "WHERE EmailAddress = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next())
            {
                user = new User();
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmailAddress(rs.getString("emailAddress"));
            }
            return user;
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

    public static ArrayList<User> selectUsers()
    {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<User> users=new ArrayList<User>();
        
        String query = "SELECT * FROM Users ORDER BY Username ASC";

        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            
            while (rs.next())
            {
                user = new User();
                user.setUserID(rs.getString("userID"));
                user.setUserName(rs.getString("Username"));
                user.setEmailAddress(rs.getString("EmailAddress"));
                user.setPassword(rs.getString("Password"));
                users.add(user);
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
        return users;
    }
    
    /*public static ArrayList<User> listUsers()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<User> users=new ArrayList<User>();
        
        String query = "SELECT * FROM Users ORDER BY UserName ASC";
        
        try
        {   
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            
            while (rs.next())
            {
                user = new User();
                user.setUserID(rs.getString("userID"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmailAddress(rs.getString("emailAddress"));
                users.add(user);
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
        return users;
        
    }
    */
    
    public static User selectUserByUserID(String userID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Users " +
                       "WHERE UserID = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next())
            {
                user = new User();
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmailAddress(rs.getString("emailAddress"));
            }
            return user;
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