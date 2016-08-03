/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theater.cooltheater.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sumama
 */
@Entity
@Table(name = "movietimes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movietimes.findAll", query = "SELECT m FROM Movietimes m"),
    @NamedQuery(name = "Movietimes.findByMovieid", query = "SELECT m FROM Movietimes m WHERE m.movietimesPK.movieid = :movieid"),
    @NamedQuery(name = "Movietimes.findByTime", query = "SELECT m FROM Movietimes m WHERE m.movietimesPK.time = :time")})
public class Movietimes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovietimesPK movietimesPK;
    @JoinColumn(name = "movieid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;

    public Movietimes() {
    }

    public Movietimes(MovietimesPK movietimesPK) {
        this.movietimesPK = movietimesPK;
    }

    public Movietimes(int movieid, Date time) {
        this.movietimesPK = new MovietimesPK(movieid, time);
    }

    public MovietimesPK getMovietimesPK() {
        return movietimesPK;
    }

    public void setMovietimesPK(MovietimesPK movietimesPK) {
        this.movietimesPK = movietimesPK;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movietimesPK != null ? movietimesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movietimes)) {
            return false;
        }
        Movietimes other = (Movietimes) object;
        if ((this.movietimesPK == null && other.movietimesPK != null) || (this.movietimesPK != null && !this.movietimesPK.equals(other.movietimesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "theater.cooltheater.pojo.Movietimes[ movietimesPK=" + movietimesPK + " ]";
    }
    
}
