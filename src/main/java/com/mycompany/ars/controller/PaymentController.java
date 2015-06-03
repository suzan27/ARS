/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ars.controller;

import com.mycompany.ars.ejb.IBookingEJB;
import com.mycompany.ars.ejb.IPaymentEJB;
import com.mycompany.ars.entity.Booking;
import com.mycompany.ars.entity.Payment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sujan
 */
@ViewScoped
@ManagedBean
public class PaymentController {
    @EJB
    private IPaymentEJB paymentEJB;
    @EJB
    private IBookingEJB bookingEJB;
    Booking booking;
    private Payment payments;
    private List<Payment> paymentList= new ArrayList<>();
    private String selectedId;
    
    // ======================================
    // =           Public Methods           =
    // ======================================
    
    @PostConstruct
    public void init() {

        FacesContext fc = FacesContext.getCurrentInstance();
        this.setSelectedId(this.parameterForEdit(fc));
        booking=this.bookingEJB.findBooking(this.getSelectedId());
        payments = new Payment();
        System.out.println("Inside Booking Controller");
        System.out.println(this.getSelectedId());
        //System.out.println(this.getCurrentUsers());
    }

    private String parameterForEdit(FacesContext fc) {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("id");
    }
    public String createPayment() {
        this.booking.setIsActive(false);
        booking=this.bookingEJB.updateBooking(booking);
        payments = paymentEJB.createPayment(payments);
        paymentList = paymentEJB.findAllPayment();
        return "list.xhtml";
    }

    public String doCancel() {
        paymentList = paymentEJB.findAllPayment();
        return "list.xhtml";
        
        
    }
    
    // ======================================
    // =          Getters & Setters         =
    // =====================================

    /**
     * @return the payment
     */
    public Payment getPayment() {
        return payments;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(Payment payment) {
        this.payments = payment;
    }

    /**
     * @return the paymentList
     */
    public List<Payment> getPaymentList() {
        paymentList=paymentEJB.findAllPayment();
        return paymentList;
    }

    /**
     * @param paymentList the paymentList to set
     */
    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    /**
     * @return the selectedId
     */
    public String getSelectedId() {
        return selectedId;
    }

    /**
     * @param selectedId the selectedId to set
     */
    public void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }
    
    
}


