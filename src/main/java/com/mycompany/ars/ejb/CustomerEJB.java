/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Customer;
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
public class CustomerEJB implements ICustomerEJB {
    @PersistenceContext(unitName = "airlinePU")
    private EntityManager entityManager;
    private UserEJB uejb;
    
    /***
     * find All Customer
     * @return Customer List
     */
    @Override
    public List<Customer> findAllCustomer(){
        TypedQuery<Customer> typedQuery=entityManager.createNamedQuery("findAllCustomer",Customer.class);
        return typedQuery.getResultList();
    }

    /***
     * Find Customer by id
     * @param id
     * @return Customer List
     */
    @Override
    public Customer findCustomerById(String id){
        Customer customer=this.entityManager.find(Customer.class, id);
        return customer;
    }
    /***
     * Create customer and persist into database
     * @param customer
     * @return Customer
     */
    @Override
    public Customer createCustomer(Customer customer) {
//        Users user = uejb.findUserByUsername(customer.getEmailId());
//        if (user != null) {
//            throw new NotFoundException("User name already exist.");
//        }
        entityManager.persist(customer);
        return customer;
    }
    
    /**
     *
     * @param userId
     * @return
     */
    @Override
    public List<Customer> findCustomerWithUserId(String userId){
        TypedQuery<Customer> typedQuery=entityManager.createNamedQuery("findByUserId",Customer.class);
        typedQuery.setParameter("userId", userId);
        List<Customer> list=typedQuery.getResultList();
        for(Customer c:list){
            System.out.println("Inside Customer");
            System.out.println(c.getFirstName());
            System.out.println(c.getId()+c.getCity()+c.getEmailId());
        }
            
        return typedQuery.getResultList();
        
    }

    /***
     * remove customer from database
     * @param customer
     * @return Customer
     */
    @Override
    public Customer deleteCustomer(Customer customer) {
        entityManager.remove(entityManager.merge(customer));
        return customer;
    }

    /***
     * Update Customer
     * @param customer
     * @return Customer
     */
    @Override
    public Customer updateCustomer(Customer customer) {
        this.entityManager.merge(customer);
        return customer;
    }

  

}