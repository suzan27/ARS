/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Sujan
 */
@Entity
//jpql query
@NamedQueries({
    @NamedQuery(name = "findAllFlight", query = "SELECT f FROM Flight f"),
    @NamedQuery(name = "findFlightWithNo", query = "select f from Flight f where f.flightNo = :fNo"),
    @NamedQuery(name = "findFlightWithId", query = "select f from Flight f where f.id = :fId")

})
/***
 * Flight Entity Class
 */
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String airlinesId;
    private String flightNo;
    private int capacity;
    private String depatureFrom;
    private String arrivalTo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departureDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arrivalDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date takeOffTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date landingTime;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.ars.Flight[ id=" + id + " ]";
    }

    /**
     * @return the flightNo
     */
    public String getFlightNo() {
        return flightNo;
    }

    /**
     * @param flightNo the flightNo to set
     */
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param noOfSeats the capacity to set
     */
    public void setCapacity(int noOfSeats) {
        this.capacity = noOfSeats;
    }

    /**
     * @return the depatureFrom
     */
    public String getDepatureFrom() {
        return depatureFrom;
    }

    /**
     * @param depatureFrom the depatureFrom to set
     */
    public void setDepatureFrom(String depatureFrom) {
        this.depatureFrom = depatureFrom;
    }

    /**
     * @return the arrivalTo
     */
    public String getArrivalTo() {
        return arrivalTo;
    }

    /**
     * @param arrivalTo the arrivalTo to set
     */
    public void setArrivalTo(String arrivalTo) {
        this.arrivalTo = arrivalTo;
    }

    /**
     * @return the departureDate
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return the arrivalDate
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate the arrivalDate to set
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return the takeOffTime
     */
    public Date getTakeOffTime() {
        return takeOffTime;
    }

    /**
     * @param takeOffTime the takeOffTime to set
     */
    public void setTakeOffTime(Date takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    /**
     * @return the landingTime
     */
    public Date getLandingTime() {
        return landingTime;
    }

    /**
     * @param landingTime the landingTime to set
     */
    public void setLandingTime(Date landingTime) {
        this.landingTime = landingTime;
    }

    /**
     * @return the airlinesId
     */
    public String getAirlinesId() {
        return airlinesId;
    }

    /**
     * @param airlinesId the airlinesId to set
     */
    public void setAirlinesId(String airlinesId) {
        this.airlinesId = airlinesId;
    }
    
}
