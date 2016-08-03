/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theater.cooltheater.beans;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import theater.cooltheater.beans.theater.TheaterBean;
import theater.cooltheater.pojo.Movie;
import theater.cooltheater.pojo.Theatermovie;

/**
 *
 * @author Sumama
 */
@ManagedBean(name = "movieController")
@ApplicationScoped
public class MovieController implements Serializable {

    private EntityManagerFactory emf;
    EntityManager em;

    @ManagedProperty(value = "#{movieBean}")
    MovieBean movieBean;

    @ManagedProperty(value = "#{theaterBean}")
    TheaterBean theaterBean;

    List<Movie> movies = null;

    Boolean isShowingMovies = false;

    /**
     * Creates a new instance of TheaterBean
     */
    public MovieController() {
        emf = getEntityManagerFactory();
        if (movies == null) {
            movies = getAll();
        }
    }

    //must povide the setter method
    public void setMovieBean(MovieBean movieBean) {
        this.movieBean = movieBean;
    }

    public TheaterBean getTheaterBean() {
        return theaterBean;
    }

    public void setTheaterBean(TheaterBean theaterBean) {
        this.theaterBean = theaterBean;
    }

    public Movie getMovie(long id) {
        return em.find(Movie.class, id);
    }

    public List<Movie> getAll() {
        em = getEntityManager();
        try {
            movies = em.createNamedQuery("Movie.findAll", Movie.class).getResultList();
            isShowingMovies = false;
            return movies;
        } finally {
            em.close();
        }
    } 

    public Boolean getIsShowingMovies() {
        return isShowingMovies;
    }

    public void setIsShowingMovies(Boolean isShowingMovies) {
        this.isShowingMovies = isShowingMovies;
    }
    

    public void delete(Movie m) {
        em = getEntityManager();
        try {
            em.remove(m);
        } finally {
            em.close();
        }
    }

    public void addMovie() {
        Movie m = new Movie();
        m.setTitle(movieBean.getTitle());
        m.setDescription(movieBean.getDescription());
        m.setDuration(movieBean.getDuration());
        m.setMpaa(movieBean.getMpaa());
        m.setRating(movieBean.getRating());
        m.setReleaseYear(movieBean.getReleaseYear());
        em = getEntityManager();
        try {
            em.persist(m);
        } finally {
            em.close();
        }
    }

    public void editMovie() {
        Movie m = new Movie();
        movieBean.setDescription(m.getDescription());
        movieBean.setDuration(m.getDuration());
        movieBean.setId(m.getId());
        movieBean.setMpaa(m.getMpaa());
        movieBean.setRating(m.getRating());
        movieBean.setReleaseYear(m.getReleaseYear());
        movieBean.setTitle(m.getTitle());
        em = getEntityManager();
        try {
            em.merge(m);
        } finally {
            em.close();
        }
    }

    private EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("theaterPU");
        }
        return emf;
    }

    private EntityManager getEntityManager() {
        EntityManager entityManager = null;
        if (null != emf) {
            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String findAll() {
        isShowingMovies = true;
        return "movies?faces-redirect=true&amp;includeViewParams=true";
    }

}
