/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theater.cooltheater.beans;

import javax.inject.Named; 
import java.io.Serializable;
import java.util.List;  
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import theater.cooltheater.pojo.Movie;

/**
 *
 * @author Sumama
 */
@ManagedBean(name = "movieController")
@ApplicationScoped
public class MovieController implements Serializable {

    @PersistenceContext(unitName = "theaterPU")
    private EntityManager em;

    @Inject
    MovieBean movieBean;

    /**
     * Creates a new instance of TheaterBean
     */
    public MovieController() {

    }

    public Movie getMovie(long id) {
        return em.find(Movie.class, id);
    }

    public List<Movie> getAll() {
        return em.createNamedQuery("Movie.findAll", Movie.class).getResultList();

    }

    public int count() {
        List<Movie> movies = em.createNamedQuery("Movie.findAll", Movie.class).getResultList();
        return movies.size();
    }

    public void delete(Movie m) {
        em.remove(m);
    }

    public void addMovie() {
        Movie m = new Movie();
        m.setTitle(movieBean.getTitle());
        m.setDescription(movieBean.getDescription());
        m.setDuration(movieBean.getDuration());
        m.setMpaa(movieBean.getMpaa());
        m.setRating(movieBean.getRating());
        m.setReleaseYear(movieBean.getReleaseYear());
        em.persist(m);
    }

    public int editMovie() {
        Movie m = new Movie();
        movieBean.setDescription(m.getDescription());
        movieBean.setDuration(m.getDuration());
        movieBean.setId(m.getId());
        movieBean.setMpaa(m.getMpaa());
        movieBean.setRating(m.getRating());
        movieBean.setReleaseYear(m.getReleaseYear());
        movieBean.setTitle(m.getTitle());
        em.merge(m);
        return 0;
    } 
}
