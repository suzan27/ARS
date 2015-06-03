/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ars.controller;

import com.mycompany.ars.ejb.IBookingEJB;
import com.mycompany.ars.ejb.IFlightEJB;
import com.mycompany.ars.entity.Booking;
import com.mycompany.ars.utils.HttpUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author sujan
 */
@Named
@ViewScoped
@SessionScoped
@ManagedBean
public class BookingController implements Serializable {

    @EJB
    private IBookingEJB bookingEJB;

    @EJB
    private IFlightEJB flightEJB;

    private Booking booking;
    private List<Booking> bookingList = new ArrayList<>();
    private String selectedFlightId;
    private String text;
    private String ticketClass;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void handleKeyEvent() {
        System.err.println("Erorr WTF");
        if ("Economy".equals(this.getTicketClass())) {
            System.out.println("Inside Event");
            System.out.println(this.getTicketClass());
            this.setText("200");
        } else {
            System.out.println("Inside Event");
            System.out.println(this.getTicketClass());
            this.setText("200");
        }
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    @PostConstruct
    public void init() {

        FacesContext fc = FacesContext.getCurrentInstance();
        this.setSelectedFlightId(this.parameterForEdit(fc));
        booking = new Booking();
        System.out.println("Inside Booking Controller");
        System.out.println(this.getSelectedFlightId());
        System.out.println(this.getCurrentUsers());
    }

    private String parameterForEdit(FacesContext fc) {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("id");
    }

    public String createBooking() {
        booking.setFlightId(this.selectedFlightId);
        booking.setCustomerId(this.getCurrentUsers());
        booking.setIsActive(true);
        booking = bookingEJB.createBooking(booking);
        bookingList = bookingEJB.findAllBooking();
        return "list.xhtml";
    }

    public String doCancel() {
        bookingList = bookingEJB.findAllBooking();
        return "list.xhtml";

    }

    // ======================================
    // =          Getters & Setters         =
    // =====================================
    /**
     * @return the booking
     */
    public Booking getBooking() {
        return booking;
    }

    /**
     * @param booking the booking to set
     */
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    /**
     * @return the bookingList
     */
    public List<Booking> getBookingList() {
        bookingList = bookingEJB.findBookingByUser(this.getCurrentUsers());
        return bookingList;
    }

    /**
     * @param bookingList the bookingList to set
     */
    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    /**
     * @return the selectedFlightId
     */
    public String getSelectedFlightId() {
        return selectedFlightId;
    }

    /**
     * @param selectedFlightId the selectedFlightId to set
     */
    public void setSelectedFlightId(String selectedFlightId) {
        this.selectedFlightId = selectedFlightId;
    }

    /**
     * @return the currentUsers
     */
    public String getCurrentUsers() {
        return HttpUtils.getSessionIdentity().getUsername();
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
