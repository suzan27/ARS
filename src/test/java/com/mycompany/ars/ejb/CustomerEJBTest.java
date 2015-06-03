/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Customer;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sujan
 */
public class CustomerEJBTest {
    
//    private static EJBContainer ec;
//    private static Context ctx;
//    
//    public CustomerEJBTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() throws Exception{
//        ec=EJBContainer.createEJBContainer();
//        ctx=ec.getContext();
//    }
//    
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//        ec.close();
//    }
//
//    /**
//     * Test of findAllCustomer method, of class CustomerEJB.
//     */
////    @Test
////    public void testFindAllCustomer() throws Exception {
////        System.out.println("findAllCustomer");
////        CustomerEJB instance = new CustomerEJB();
////        List<Customer> expResult = null;
////        List<Customer> result = instance.findAllCustomer();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of findCustomerById method, of class CustomerEJB.
//     */
////    @Test
////    public void testFindCustomerById() throws Exception {
////        System.out.println("findCustomerById");
////        Long id = null;
////        CustomerEJB instance = new CustomerEJB();
////        List<Customer> expResult = null;
////        List<Customer> result = instance.findCustomerById(id);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//    /**
//     * Test of createCustomer method, of class CustomerEJB.
//     */
//    @Test
//    public void testCreateCustomer() throws Exception {
//        System.out.println("createCustomer");
//        //Creates instance of Customer
//        Customer customer = new Customer();
//        customer.setCity("Brisbane");
//        customer.setEmailId("suzan.2014@gmail.com");
//        customer.setFirstName("Sujan");
//        customer.setLastName("Shrestha");
//        customer.setPhoneNo("0452366923");
//        customer.setPostCode("4068");
//        customer.setStates("Qld");
//        customer.setStreetName("sdsd");
//        customer.setSuburb("Indoo");
//        
//        //Looks up the EJB
//        CustomerEJB customerEJB=(CustomerEJB) ctx.lookup("java:global/classes/CustomerEJB");
//        
//        //Pesrsist the Customer to the database
//        customer=customerEJB.createCustomer(customer);
//        assertNotNull("ID should not be null", customer.getId());
//        
//        //Retrieves all the customer from database
//        
//        List<Customer> customers=customerEJB.findAllCustomer();
//        assertNotNull(customers);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteCustomer method, of class CustomerEJB.
//     */
////    @Test
////    public void testDeleteCustomer() throws Exception {
////        System.out.println("deleteCustomer");
////        Customer customer = null;
////        CustomerEJB instance = new CustomerEJB();
////        Customer expResult = null;
////        Customer result = instance.deleteCustomer(customer);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of updateCustomer method, of class CustomerEJB.
////     */
////    @Test
////    public void testUpdateCustomer() throws Exception {
////        System.out.println("updateCustomer");
////        Customer customer = null;
////        CustomerEJB instance = new CustomerEJB();
////        Customer expResult = null;
////        Customer result = instance.updateCustomer(customer);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//    
}
