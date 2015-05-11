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
import javax.persistence.Temporal;

/**
 *
 * @author Sujan
 */
@Entity
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int noOfTicket;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date bookingDate;
    private String ticketClass;

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
    
}
