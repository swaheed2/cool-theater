/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theater.cooltheater.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sumama
 */
@Entity
@Table(name = "theatermovie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theatermovie.findAll", query = "SELECT t FROM Theatermovie t"),
    @NamedQuery(name = "Theatermovie.findByTheaterid", query = "SELECT t FROM Theatermovie t WHERE t.theatermoviePK.theaterid = :theaterid"),
    @NamedQuery(name = "Theatermovie.findByMovieid", query = "SELECT t FROM Theatermovie t WHERE t.theatermoviePK.movieid = :movieid"),
    @NamedQuery(name = "Theatermovie.findByNotes", query = "SELECT t FROM Theatermovie t WHERE t.notes = :notes")})

@SecondaryTable(name = "Movie", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "movieid"))
public class Theatermovie implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TheatermoviePK theatermoviePK;
    @Size(max = 50)
    @Column(name = "notes")
    private String notes;
    @JoinColumn(name = "movieid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;
    @JoinColumn(name = "theaterid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Theater theater;

    @Column(table = "Movie", name = "id")
    private String id;

    @Column(table = "Movie", name = "posterurl")
    private String posterurl;

    @Column(table = "Movie", name = "title")
    private String title;

    @Column(table = "Movie", name = "description")
    private String description;

    @Column(table = "Movie", name = "release_year")
    private int releaseYear;

    @Column(table = "Movie", name = "duration")
    private String duration;

    @Column(table = "Movie", name = "rating")
    private int rating;

    @Column(table = "Movie", name = "mpaa")
    private String mpaa;

    public Theatermovie() {
    }

    public Theatermovie(TheatermoviePK theatermoviePK) {
        this.theatermoviePK = theatermoviePK;
    }

    public Theatermovie(int theaterid, int movieid) {
        this.theatermoviePK = new TheatermoviePK(theaterid, movieid);
    }

    public TheatermoviePK getTheatermoviePK() {
        return theatermoviePK;
    }

    public void setTheatermoviePK(TheatermoviePK theatermoviePK) {
        this.theatermoviePK = theatermoviePK;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theatermoviePK != null ? theatermoviePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theatermovie)) {
            return false;
        }
        Theatermovie other = (Theatermovie) object;
        if ((this.theatermoviePK == null && other.theatermoviePK != null) || (this.theatermoviePK != null && !this.theatermoviePK.equals(other.theatermoviePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "theater.cooltheater.pojo.Theatermovie[ theatermoviePK=" + theatermoviePK + " ]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosterurl() {
        return posterurl;
    }

    public void setPosterurl(String posterurl) {
        this.posterurl = posterurl;
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
    
    

}
