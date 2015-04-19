/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.entity;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Sujan
 */
@ManagedBean
@RequestScoped
public class FlightController {
    
@EJB
    private FlightEJB gejb;
    private Flight flight = new Flight();
    private List<Flight> flightsList = new ArrayList<>();

    // ======================================
    // =           Public Methods           =
    // ======================================
    public String createFlight() {
        flight = gejb.createFlight(flight);
        flightsList = gejb.findAllFlight();
        return "list.xhtml";
    }

    public String doCancel() {
        flightsList = gejb.findAllFlight();
        return "list.xhtml";
    }

    // ======================================
    // =          Getters & Setters         =
    // =====================================

    public void setFlight(Flight g) {
        this.flight = g;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlightList(List<Flight> list) {
        this.flightsList = list;
    }

    public List<Flight> getFlightList() {
        flightsList=gejb.findAllFlight();
        return flightsList;
    }

}
