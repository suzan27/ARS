/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sujan
 */
@Stateless
public class FlightEJB {
    @PersistenceContext(unitName = "airlinePU")
    private EntityManager entityManager;
    
    /***
     * find All Flight
     * @return Flight List
     */
    public List<Flight> findAllFlight(){
        TypedQuery<Flight> typedQuery=entityManager.createNamedQuery("findAllFlight",Flight.class);
        return typedQuery.getResultList();
    }

    /***
     * Find Flight by id
     * @param id
     * @return Flight List
     */
    public List<Flight> findFlightById(Long id){
        TypedQuery<Flight> typedQuery=entityManager.createNamedQuery("findFlightWithId",Flight.class);
        typedQuery.setParameter("fId", id);
        return typedQuery.getResultList();
    }
    /***
     * Find Flight By Title
     * @param title
     * @return Flight List
     */
    
    public List<Flight> findFlightByTitle(String flightNo){
        TypedQuery<Flight> typedQuery= entityManager.createNamedQuery("findFlightWithNo",Flight.class);
        typedQuery.setParameter("fNo", flightNo);
        return typedQuery.getResultList();
    }
    /***
     * Create game and persist into database
     * @param flight
     * @return Flight
     */

    public Flight createFlight(Flight flight) {
        entityManager.persist(flight);
        return flight;
    }

    /***
     * remove game from database
     * @param flight
     * @return Flight
     */
    public Flight deleteFlight(Flight flight) {
        entityManager.remove(entityManager.merge(flight));
        return flight;
    }

    /***
     * Update Flight
     * @param flight
     * @return Flight
     */
    public Flight updateFlight(Flight flight) {

        entityManager.merge(flight);
        return flight;
    }

}
    
