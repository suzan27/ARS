/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Airlines;
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
public class AirlinesEJB implements IAirlinesEJB {

    @PersistenceContext(unitName = "airlinePU")
    private EntityManager entityManager;

    /**
     * *
     * create Airlines and persist in database
     *
     * @param airline
     * @return Airlines
     */
    @Override
    public Airlines createAirline(Airlines airline) {
        entityManager.persist(airline);
        return airline;
    }

    /**
     * *
     * update airline details
     *
     * @param airline
     * @return airline
     */
    @Override
    public Airlines updateAirline(Airlines airline) {
        entityManager.merge(airline);
        return airline;
    }

    /**
     * *
     * delete airlines from database
     *
     * @param airline
     * @return
     */
    @Override
    public Airlines deleteAirline(Airlines airline) {
        entityManager.remove(entityManager.merge(airline));
        return airline;
    }

    /**
     * *
     * find all airlines list
     *
     * @return list
     */
    @Override
    public List<Airlines> findAllAirline() {
        TypedQuery<Airlines> typedQuery = entityManager.createNamedQuery("findAllAirlines", Airlines.class);
        return typedQuery.getResultList();
    }

    /**
     * *
     * find airline list by its name
     *
     * @param airlineName
     * @return list
     */
    @Override
    public List<Airlines> findAirlineByName(String airlineName) {
        TypedQuery<Airlines> typedQuery = entityManager.createNamedQuery("findAirlineWithName", Airlines.class);
        typedQuery.setParameter("aName", airlineName);
        return typedQuery.getResultList();
    }

    /***
     * find airline with id
     * @param id
     * @return 
     */
    @Override
    public Airlines findAirlineWithId(String id) {
        TypedQuery<Airlines> typedQuery = entityManager.createNamedQuery("findAirlineWithId", Airlines.class);
        typedQuery.setParameter("aId", id);
        return typedQuery.getSingleResult();
    }

    /***
     * find airline with id
     * @param code
     * @return 
     */
    @Override
    public Airlines findAirline(String code) {
        Airlines airlines=this.entityManager.find(Airlines.class,code);
        return airlines;
    }

    @Override
    public Airlines addOrUpdate(Airlines airlines){
        System.out.println(airlines.getId());
       
        if(StringUtils.length(airlines.getId())>0){
             return this.updateAirline(airlines);
        }
        else
            return this.createAirline(airlines);
             
    }
}
