/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.controller;

import com.mycompany.ars.ejb.IFlightEJB;
import com.mycompany.ars.entity.Flight;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Sujan
 */
@ManagedBean
@ViewScoped
public class FlightController {
    
@EJB
    private IFlightEJB gejb;
    private Flight flight;
    private List<Flight> flightsList = new ArrayList<>();
    private int airlineId;
    private String selectedId;

    // ======================================
    // =           Public Methods           =
    // ======================================
    
     @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.setSelectedId(this.parameterForEdit(fc));
        if (StringUtils.length(getSelectedId()) > 0) {
            this.flight = this.gejb.findFlight(getSelectedId());
           

        } else {
            this.flight = new Flight();
        }

    }
    
    private String parameterForEdit(FacesContext fc) {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("id");
    }
    public String createFlight() {
        System.out.println("The airline id is"+flight.getId());
        flight = gejb.addOrUpdateFlight(flight);
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

    /**
     * @return the airlineId
     */
    public int getAirlineId() {
        return airlineId;
    }

    /**
     * @param airlineId the airlineId to set
     */
    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
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
