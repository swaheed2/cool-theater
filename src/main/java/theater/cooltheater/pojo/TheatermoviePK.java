/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theater.cooltheater.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sumama
 */
@Embeddable
public class TheatermoviePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "theaterid")
    private int theaterid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movieid")
    private int movieid;

    public TheatermoviePK() {
    }

    public TheatermoviePK(int theaterid, int movieid) {
        this.theaterid = theaterid;
        this.movieid = movieid;
    }

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) theaterid;
        hash += (int) movieid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TheatermoviePK)) {
            return false;
        }
        TheatermoviePK other = (TheatermoviePK) object;
        if (this.theaterid != other.theaterid) {
            return false;
        }
        if (this.movieid != other.movieid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "theater.cooltheater.pojo.TheatermoviePK[ theaterid=" + theaterid + ", movieid=" + movieid + " ]";
    }
    
}
