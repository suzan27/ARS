/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightNo;
    private int noOfSeats;
    private String depatureFrom;
    private String arrivalTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
     * @return the noOfSeats
     */
    public int getNoOfSeats() {
        return noOfSeats;
    }

    /**
     * @param noOfSeats the noOfSeats to set
     */
    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
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
    
}
