/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.controller;

import com.mycompany.ars.ejb.IAirlinesEJB;
import com.mycompany.ars.entity.Airlines;
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
public class AirlineController {
    
    @EJB
    private IAirlinesEJB airlinesEJB;
    private Airlines airlines;
    private List<Airlines> airlineList= new ArrayList<>();
    private String selectedAirlineId = "";
    
    // ======================================
    // =           Public Methods           =
    // ======================================
    
    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.setSelectedAirlineId(this.parameterForEdit(fc));
        if (StringUtils.length(getSelectedAirlineId()) > 0) {
            this.airlines = this.airlinesEJB.findAirline(getSelectedAirlineId());
           

        } else {
            this.airlines = new Airlines();
        }

    }
    
    private String parameterForEdit(FacesContext fc) {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("id");
    }
    public String createAirline() {
        
        System.out.println("The airline id is"+airlines.getId());
        airlines = airlinesEJB.addOrUpdate(airlines);
        airlineList = airlinesEJB.findAllAirline();
        return "list.xhtml";
    }

    public String doCancel() {
        airlineList = airlinesEJB.findAllAirline();
        return "list.xhtml";
        
        
    }
    
    // ======================================
    // =          Getters & Setters         =
    // =====================================

    /**
     * @return the airlines
     */
    public Airlines getAirlines() {
        return airlines;
    }

    /**
     * @param airlines the airlines to set
     */
    public void setAirlines(Airlines airlines) {
        this.airlines = airlines;
    }

    /**
     * @return the airlineList
     */
    public List<Airlines> getAirlineList() {
        airlineList=airlinesEJB.findAllAirline();
        return airlineList;
    }

    /**
     * @param airlineList the airlineList to set
     */
    public void setAirlineList(List<Airlines> airlineList) {
        this.airlineList = airlineList;
    }

    /**
     * @return the selectedAirlineId
     */
    public String getSelectedAirlineId() {
        return selectedAirlineId;
    }

    /**
     * @param selectedAirlineId the selectedAirlineId to set
     */
    public void setSelectedAirlineId(String selectedAirlineId) {
        this.selectedAirlineId = selectedAirlineId;
    }
    
    
}
