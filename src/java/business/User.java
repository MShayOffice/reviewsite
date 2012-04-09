package business;

import java.io.Serializable;

public class User implements Serializable
{
    private String username;
    private String password;
    private String emailAddress;
    //private String userrole;
    
    public User()
    {
        username = "";
        password = "";
        emailAddress = "";
        //userrole = "";
    }
    
    public User(String username, String password, String emailAddress)
    {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

//    public User(String username, String password, String emailAddress, String userRole)
//    {
//        this.username = username;
//        this.password = password;
//        this.emailAddress = emailAddress;
//        this.userrole = userRole;
//    }
    
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
