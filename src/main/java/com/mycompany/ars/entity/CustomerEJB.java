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
public class CustomerEJB {
    @PersistenceContext(unitName = "airlinePU")
    private EntityManager entityManager;
    
    /***
     * find All Customer
     * @return Customer List
     */
    public List<Customer> findAllCustomer(){
        TypedQuery<Customer> typedQuery=entityManager.createNamedQuery("findAllCustomer",Customer.class);
        return typedQuery.getResultList();
    }

    /***
     * Find Customer by id
     * @param id
     * @return Customer List
     */
    public List<Customer> findCustomerById(Long id){
        TypedQuery<Customer> typedQuery=entityManager.createNamedQuery("findCustomerWithId",Customer.class);
        typedQuery.setParameter("cId", id);
        createUser();
        return typedQuery.getResultList();
    }
    /***
     * Create game and persist into database
     * @param customer
     * @return Customer
     */

    public Customer createCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    /***
     * remove game from database
     * @param customer
     * @return Customer
     */
    public Customer deleteCustomer(Customer customer) {
        entityManager.remove(entityManager.merge(customer));
        return customer;
    }

    /***
     * Update Customer
     * @param customer
     * @return Customer
     */
    public Customer updateCustomer(Customer customer) {

        entityManager.merge(customer);
        return customer;
    }

    private void createUser() {
        
    }

}