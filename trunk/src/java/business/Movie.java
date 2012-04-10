package business;

import java.io.Serializable;
/**
 *
 * @author Chappy
 */
public class Movie implements Serializable
{
    //MovieID, MovieName, Year, Description
    
    private String movieID;
    private String movieName;
    private String year;
    private String description;
    
    
    public Movie()
    {
        movieID = "";
        movieName = "";
        year = "";
        description = "";
        
    }
    
    public Movie(String id, String name, String yr, String desc, double average)
    {
        movieID = id;
        movieName = name;
        year = yr;
        description = desc;
        average = 0;
    }
    
    public void setID(String i)
    {
        movieID = i;
    }
    
    public String getID()
    {
        return movieID;
    }
    
    public void setName(String n)
    {
        movieName = n;
    }
    
    public String getName()
    {
        return movieName;
    }
    
    public void setYear(String y)
    {
        year = y;
    }
    
    public String getYear()
    {
        return year;
    }
    
    public void setDescription(String d)
    {
        description = d;
    }
    
    public String getDescription()
    {
        return description;
    }
    
}
