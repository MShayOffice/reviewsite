/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public MovieItem()
    {
        movieID = "";
        movieName = "";
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
}
