/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.entity;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Sujan
 */
@ManagedBean(name="registerBean")
@RequestScoped
public class CustomerController {
    
    @EJB
    private CustomerEJB cejb;
    @EJB
    private UserEJB uejb;
    private Customer cust=new Customer();
    private Users users=new Users();
    private List<Customer> customers= new ArrayList<>();
    private String password;
    
    
    public void createCustomer(){
        System.out.println("sdsd"+cust.getFirstName());
        cust=cejb.createCustomer(cust);
        users=createUser();
        users=uejb.createUsers(users);
        customers=cejb.findAllCustomer();
        
//        return "list.xhtml";
    }

    /**
     * @return the cust
     */
    public Customer getCust() {
        return cust;
    }

    /**
     * @param cust the cust to set
     */
    public void setCust(Customer cust) {
        this.cust = cust;
    }

    /**
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * @param customers the customers to set
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    /**
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    private Users createUser() {
        users.setUserName(cust.getEmailId());
        users.setPassword(this.getPassword());
        users.setRoles("customer");
        return users;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
