/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theater.cooltheater.beans;

import java.io.Serializable; 
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Sumama
 */
@ManagedBean(name = "movieBean")
@ApplicationScoped
public class MovieBean implements Serializable {
 
    private Integer id; 
    private String title; 
    private String description;  
    private int releaseYear; 
    private String duration; 
    private int rating; 
    private String mpaa;
    String posterurl;
    
    
    List<Date> movieTimes;
    
    public MovieBean() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMpaa() {
        return mpaa;
    }

    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    public String getPosterurl() {
        return posterurl;
    }

    public void setPosterurl(String posterurl) {
        this.posterurl = posterurl;
    } 

    public List<Date> getMovieTimes() {
        return movieTimes;
    }

    public void setMovieTimes(List<Date> movieTimes) {
        this.movieTimes = movieTimes;
    } 
    
}
