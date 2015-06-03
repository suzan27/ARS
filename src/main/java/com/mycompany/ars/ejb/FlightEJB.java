/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Flight;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Sujan
 */
@Stateless
public class FlightEJB implements IFlightEJB {

    @PersistenceContext(unitName = "airlinePU")
    private EntityManager entityManager;

    /**
     * *
     * Create flight and persist into database
     *
     * @param flight
     * @return Flight
     */
    
    public Flight createFlight(Flight flight) {
        entityManager.persist(flight);
        return flight;
    }

    /**
     * *
     * remove flight from database
     *
     * @param flight
     * @return Flight
     */
    @Override
    public Flight deleteFlight(Flight flight) {
        entityManager.remove(entityManager.merge(flight));
        return flight;
    }

    /**
     * *
     * Update Flight
     *
     * @param flight
     * @return Flight
     */
    
    public Flight updateFlight(Flight flight) {

        entityManager.merge(flight);
        return flight;
    }

    /**
     * *
     * find All Flight
     *
     * @return Flight List
     */
    @Override
    public List<Flight> findAllFlight() {
        TypedQuery<Flight> typedQuery = entityManager.createNamedQuery("findAllFlight", Flight.class);
        return typedQuery.getResultList();
    }

    /**
     * *
     * Find Flight by id
     *
     * @param id
     * @return Flight List
     */
    @Override
    public List<Flight> findFlightById(Long id) {
        TypedQuery<Flight> typedQuery = entityManager.createNamedQuery("findFlightWithId", Flight.class);
        typedQuery.setParameter("fId", id);
        return typedQuery.getResultList();
    }

    /**
     * Find Flight By Title
     *
     * @param flightNo
     * @return Flight List
     */
    @Override
    public List<Flight> findFlightByParam(String flightNo) {
        TypedQuery<Flight> typedQuery = entityManager.createNamedQuery("findFlightWithNo", Flight.class);
        typedQuery.setParameter("fNo", flightNo);
        return typedQuery.getResultList();
    }

    @Override
    public Flight findFlight(String code) {
        Flight flight = this.entityManager.find(Flight.class, code);
        return flight;
    }

    @Override
    public Flight addOrUpdateFlight(Flight flight) {
        System.out.println("Inside Manager");
        System.out.println(flight.getId());
       // Flight temp = this.findFlight(flight.getId());
        if (StringUtils.length(flight.getId())>0) {
            return this.updateFlight(flight);
        } else {
            return this.createFlight(flight);
        }
    }

}
