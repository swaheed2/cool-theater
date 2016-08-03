/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theater.cooltheater.beans.theater;

import java.io.Serializable; 
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;  
import javax.inject.Inject;

/**
 *
 * @author Sumama
 */
@ManagedBean(name = "theaterBean")
@ApplicationScoped
public class TheaterBean implements Serializable{

    String name;
    int id;
    String address;
    String city;
    String state;
    Integer zipcode;
    String posterurl; 
    
    /**
     * Creates a new instance of TheaterBean
     */
    public TheaterBean() { 
        name = "Cool Theater";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getPosterurl() {
        return posterurl;
    }

    public void setPosterurl(String posterurl) {
        this.posterurl = posterurl;
    }
 
    
    
}
