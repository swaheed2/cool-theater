/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theater.cooltheater.beans.theater;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import theater.cooltheater.pojo.Movie;
import theater.cooltheater.pojo.Theater;
import theater.cooltheater.pojo.Theatermovie;

/**
 *
 * @author Sumama
 */
@ManagedBean(name = "theaterController")
@ApplicationScoped
public class TheaterController {

    private EntityManagerFactory emf;
    EntityManager em;

    @ManagedProperty(value = "#{theaterBean}")
    TheaterBean theaterBean;

    String name;

    Boolean findByTheater = false;

    List<Theater> theaters = null;

    /**
     * Creates a new instance of TheaterBean
     */
    public TheaterController() {
        emf = getEntityManagerFactory();
        if (theaters == null) {
            theaters = getAll();
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

    //must povide the setter method
    public void setTheaterBean(TheaterBean theaterBean) {
        this.theaterBean = theaterBean;
    }

    public Theater getTheater(long id) {
        return em.find(Theater.class, id);
    }

    public Boolean getFindByTheater() {
        return findByTheater;
    }

    public void setFindByTheater(Boolean findByTheater) {
        this.findByTheater = findByTheater;
    }

    public List<Theater> getAll() {
        em = getEntityManager();
        try {
            return em.createNamedQuery("Theater.findAll", Theater.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Theater> findTheatersByZip(int zipcode) {
        em = getEntityManager();
        try {
            return em.createNamedQuery("Theater.findByZipcode", Theater.class).setParameter("zipcode", zipcode).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Theatermovie> getMoviesByTheater() {
        em = getEntityManager();
        try {
            List<Theatermovie> mv = em.createNamedQuery("Theatermovie.findByTheaterid", Theatermovie.class)
                    .setParameter("theaterid",theaterBean.getId()).getResultList();  
            findByTheater = false;
            return mv;
        } finally {
            em.close();
        }
    }

    public int count() {
        List<Theater> theaters = em.createNamedQuery("Theater.findAll", Theater.class).getResultList();
        return theaters.size();
    }

    public void delete(Theater m) {
        em.remove(m);
    }

    public void addTheater() {
        Theater m = new Theater();
        m.setAddress(theaterBean.getAddress());
        m.setCity(theaterBean.getCity());
        m.setState(theaterBean.getState());
        m.setZipcode(theaterBean.getZipcode());
        m.setPosterurl(theaterBean.getPosterurl());
        em.persist(m);
    }

    public int editTheater() {
        Theater m = new Theater();
        theaterBean.setId(m.getId());
        theaterBean.setAddress(m.getAddress());
        theaterBean.setCity(m.getCity());
        theaterBean.setState(m.getState());
        theaterBean.setZipcode(m.getZipcode());
        theaterBean.setPosterurl(m.getPosterurl());
        em.merge(m);
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }

    public String findTheaters() {
        System.out.println("zipcode: " + theaterBean.getZipcode());
        theaters = findTheatersByZip(theaterBean.getZipcode());
        return "theaters?faces-redirect=true&amp;includeViewParams=true";
    }

    public String findAll() {
        theaterBean.setZipcode(null);
        theaters = getAll();
        return "theaters?faces-redirect=true&amp";
    }

    public String findMoviesByTheater(int theaterid) {
        findByTheater = true;
        theaterBean.setId(theaterid);
        return "movies?faces-redirect=true&amp";
    }

    @PreDestroy
    public void onDestroy() {
        em.close();
    }
}
