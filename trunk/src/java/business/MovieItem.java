package business;

import java.io.Serializable;
/**
 *
 * @author Chappy
 */
public class MovieItem implements Serializable
{
    //MovieID, MovieName, Year, Description
    
    private String movieID;
    private String movieName;
    private double average;
    
    public MovieItem()
    {
        movieID = "";
        movieName = "";
        average = 0;
    }
    
    public MovieItem(String id, String name)
    {
        movieID = id;
        movieName = name;
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
    public void setAverage(double a)
    {
        average = a;
    }
    public double getAverage()
    { 
        return average; 
    }
}
