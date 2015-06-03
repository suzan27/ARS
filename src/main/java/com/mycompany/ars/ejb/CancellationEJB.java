/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Cancellation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sujan
 */
public class CancellationEJB implements ICancellationEJB{
    
     @PersistenceContext(unitName = "airlinePU")
    private EntityManager entityManager;

    /**
     * *
     * create Cancellation and persist in database
     *
     * @param cancellation
     * @return Cancellation
     */
    @Override
    public Cancellation createCancellation(Cancellation cancellation) {
        entityManager.persist(cancellation);
        return cancellation;
    }

    /**
     * *
     * update cancellation details
     *
     * @param cancellation
     * @return cancellation
     */
    @Override
    public Cancellation updateCancellation(Cancellation cancellation) {
        entityManager.merge(cancellation);
        return cancellation;
    }

    /**
     * *
     * delete cancellations from database
     *
     * @param cancellation
     * @return
     */
    @Override
    public Cancellation deleteCancellation(Cancellation cancellation) {
        entityManager.remove(entityManager.merge(cancellation));
        return cancellation;
    }

    /**
     * *
     * find all cancellations list
     *
     * @return list
     */
    @Override
    public List<Cancellation> findAllCancellation() {
        TypedQuery<Cancellation> typedQuery = entityManager.createNamedQuery("findAllCancellation", Cancellation.class);
        return typedQuery.getResultList();
    }

    /***
     * find cancellation with id
     * @param id
     * @return 
     */
    @Override
    public Cancellation findCancellationWithId(Long id) {
        TypedQuery<Cancellation> typedQuery = entityManager.createNamedQuery("findCancellationWithId", Cancellation.class);
        typedQuery.setParameter("cId", id);
        return typedQuery.getSingleResult();
    }

}