/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Customer;
import java.util.List;

/**
 *
 * @author Sujan
 */
public interface ICustomerEJB {
    
    public Customer findCustomerById(String id);
    
    public List<Customer> findCustomerWithUserId(String userId);
   
    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);
    
    public Customer deleteCustomer(Customer customer);

    public List<Customer> findAllCustomer();
    
}
