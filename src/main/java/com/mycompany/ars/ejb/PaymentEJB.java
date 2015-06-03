/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Payment;
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
public class PaymentEJB implements IPaymentEJB{
    
     @PersistenceContext(unitName = "airlinePU")
    private EntityManager entityManager;

    /**
     * *
     * create Payment and persist in database
     *
     * @param payment
     * @return Payment
     */
    @Override
    public Payment createPayment(Payment payment) {
        entityManager.persist(payment);
        return payment;
    }

    /**
     * *
     * update payment details
     *
     * @param payment
     * @return payment
     */
    @Override
    public Payment updatePayment(Payment payment) {
        entityManager.merge(payment);
        return payment;
    }

    /**
     * *
     * delete payments from database
     *
     * @param payment
     * @return
     */
    @Override
    public Payment deletePayment(Payment payment) {
        entityManager.remove(entityManager.merge(payment));
        return payment;
    }

    /**
     * *
     * find all payments list
     *
     * @return list
     */
    @Override
    public List<Payment> findAllPayment() {
        TypedQuery<Payment> typedQuery = entityManager.createNamedQuery("findAllPayment", Payment.class);
        return typedQuery.getResultList();
    }

    /***
     * find payment with id
     * @param id
     * @return payment
     */
    @Override
    public Payment findPaymentWithId(Long id) {
        TypedQuery<Payment> typedQuery = entityManager.createNamedQuery("findPaymentWithId", Payment.class);
        typedQuery.setParameter("pId", id);
        return typedQuery.getSingleResult();
    }

}