/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;


/**
 *
 * @author Kyle
 */

import java.io.Serializable;

public class Review implements Serializable
{
    private String userID;
    private String userName;
    private String movieID;
    private String reviewText;
    private String rating;
    private int score;
    
    public Review()
    {
        userID = "";
        userName = "";
        movieID = "";
        reviewText = "";
        rating = "";
        score = 0;
    }
    
    public Review(String userID, String userName, String movieID, String reviewText, String rating, int score)
    {
        this.userID = userID;
        this.userName = userName;
        this.movieID = movieID;
        this.reviewText = reviewText;
        this.rating = rating;
        this.score = score;
    }
    
    public void setUserID(String u)
    {
        userID = u;
    }
    public String getUserID()
    { 
        return userID; 
    }
    
    public void setMovieID(String m)
    {
        movieID = m;
    }

    public String getMovieID()
    { 
        return movieID; 
    }
    
    public void setReviewText(String r)
    {
        reviewText = r;
    }

    public String getReviewText()
    { 
        return reviewText; 
    }
    public void setRating(String r)
    {
        rating = r;
    }

    public String getRating()
    { 
        return rating; 
    }
    public void setUserName(String u)
    {
        userName = u;
    }
    public String getUserName()
    { 
        return userName; 
    }
    public void setScore(int s)
    {
        score = s;
    }
    public int getScore()
    { 
        return score; 
    }
}
