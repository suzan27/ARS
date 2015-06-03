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
@NamedQueries({
    @NamedQuery(name = "findAllBooking", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "findBookingWithId", query = "SELECT b from Booking b where b.id = :bId"),
    @NamedQuery(name="findBookingDoneByUser", query = "SELECT b FROM Booking b where b.customerId= :bCustomerId and b.isActive=1")
       

})
/***
 * Booking Entity Class
 */
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String flightId;
    private String customerId;
    private int noOfTicket;
    private boolean isActive;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date bookingDate;
    private String ticketClass;

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
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.ars.entity.Booking[ id=" + id + " ]";
    }

    /**
     * @return the noOfTicket
     */
    public int getNoOfTicket() {
        return noOfTicket;
    }

    /**
     * @param noOfTicket the noOfTicket to set
     */
    public void setNoOfTicket(int noOfTicket) {
        this.noOfTicket = noOfTicket;
    }

    /**
     * @return the bookingDate
     */
    public Date getBookingDate() {
        return bookingDate;
    }

    /**
     * @param bookingDate the bookingDate to set
     */
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     * @return the ticketClass
     */
    public String getTicketClass() {
        return ticketClass;
    }

    /**
     * @param ticketClass the ticketClass to set
     */
    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    /**
     * @return the flightId
     */
    public String getFlightId() {
        return flightId;
    }

    /**
     * @param flightId the flightId to set
     */
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
}
