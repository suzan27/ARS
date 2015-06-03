/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ars.controller;

import com.mycompany.ars.ejb.ICancellationEJB;
import com.mycompany.ars.entity.Cancellation;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author sujan
 */
public class CancellationController {
@EJB
    private ICancellationEJB cancellationEJB;
    private Cancellation cancellation= new Cancellation();
    private List<Cancellation> cancellationList= new ArrayList<>();
    
    // ======================================
    // =           Public Methods           =
    // ======================================
    public String createCancellation() {
        cancellation = cancellationEJB.createCancellation(cancellation);
        cancellationList = cancellationEJB.findAllCancellation();
        return "list.xhtml";
    }

    public String doCancel() {
        cancellationList = cancellationEJB.findAllCancellation();
        return "list.xhtml";
        
        
    }
    
    // ======================================
    // =          Getters & Setters         =
    // =====================================

    /**
     * @return the cancellation
     */
    public Cancellation getCancellation() {
        return cancellation;
    }

    /**
     * @param cancellation the cancellation to set
     */
    public void setCancellation(Cancellation cancellation) {
        this.cancellation = cancellation;
    }

    /**
     * @return the cancellationList
     */
    public List<Cancellation> getCancellationList() {
        cancellationList=cancellationEJB.findAllCancellation();
        return cancellationList;
    }

    /**
     * @param cancellationList the cancellationList to set
     */
    public void setCancellationList(List<Cancellation> cancellationList) {
        this.cancellationList = cancellationList;
    }
    
    
}

