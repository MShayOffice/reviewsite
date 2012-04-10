package business;

import java.io.Serializable;

public class User implements Serializable
{
    private String userID;
    private String username;
    private String password;
    private String emailAddress;
    //private String userrole;
    
    public User()
    {
        userID = "";
        username = "";
        password = "";
        emailAddress = "";
        //userrole = "";
    }
    
    public User(String id, String name, String pass, String email)
    {
        userID = id;
        username = name;
        password = pass;
        emailAddress = email;
//        userrole = role;
    }

    public void setUserID(String i)
    {
        userID = i;
    }
    public String getUserID()
    {
        return userID;
    }
    
    public void setUserName(String u)
    {
        username = u;
    }
    public String getUserName()
    { 
        return username; 
    }
    
    public void setPassword(String p)
    {
        password = p;
    }

    public String getPassword()
    { 
        return password; 
    }
    
    public void setEmailAddress(String e)
    {
        emailAddress = e;
    }

    public String getEmailAddress()
    { 
        return emailAddress; 
    }
    
//    public void setUserRole(String ur)
//    {
//        userrole = ur;
//    }
//
//    public String getUserRole()
//    { 
//        return userrole; 
//    }
}
