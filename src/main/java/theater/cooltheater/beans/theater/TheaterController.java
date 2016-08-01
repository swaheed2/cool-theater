/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theater.cooltheater.beans.theater;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean; 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext; 
import theater.cooltheater.pojo.Theater;

/**
 *
 * @author Sumama
 */
@ManagedBean(name = "theaterController")
@ApplicationScoped
public class TheaterController {

    @PersistenceContext(unitName = "theaterPU")
    private EntityManager em;

    @Inject
    TheaterBean theaterBean; 
    
    String name;
    
    List<Theater> theaters = new ArrayList<>();

    /**
     * Creates a new instance of TheaterBean
     */
    public TheaterController() {

    }
    
    

    public Theater getTheater(long id) {
        return em.find(Theater.class, id);
    }

    public List<Theater> getAll() {
        return em.createNamedQuery("Theater.findAll", Theater.class).getResultList();

    }

    public List<Theater> findTheaters(int zipcode) {
        return em.createNamedQuery("Theater.findByZipcode", Theater.class).setParameter("zipcode",zipcode).getResultList();
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
    
    public String findTheaters(){
        System.out.println("zipcode: " + theaterBean.getZipcode());
        theaters = findTheaters(theaterBean.getZipcode()); 
        return "find-theaters?faces-redirect=true&amp;includeViewParams=true"; 
    }
    
    public String findAll(){
        System.out.println("zipcode: " + theaterBean.getZipcode());
        theaterBean.setZipcode(null);
        theaters = getAll(); 
        return "find-theaters?faces-redirect=true&amp"; 
    }
}
