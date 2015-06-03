/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.controller;

import com.mycompany.ars.ejb.ICustomerEJB;
import com.mycompany.ars.ejb.IUserEJB;
import com.mycompany.ars.entity.Customer;
import com.mycompany.ars.entity.Users;
import com.mycompany.ars.utils.HttpUtils;
import com.mycompany.ars.utils.Messages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Sujan
 */
@ManagedBean(name="registerBean")
@Named
@SessionScoped
@ViewScoped
public class CustomerController implements Serializable{
    
    @EJB
    private ICustomerEJB cejb;
    @EJB
    private IUserEJB uejb;
    private Customer cust;
    private Users users=new Users();
    private List<Customer> customers= new ArrayList<>();
    private String password;
    private String selectedId;
    
    
    @Inject
    private transient Messages messages;
    
    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.setSelectedId(this.parameterForEdit(fc));
        if (StringUtils.length(getSelectedId()) > 0) {
            this.cust = this.cejb.findCustomerById(getSelectedId());
           

        } else {
            this.cust = new Customer();
        }

    }
    
    public String updateCustomer(){
        cust=this.cejb.updateCustomer(cust);
        return "list.xhtml";
    }
    
    private String parameterForEdit(FacesContext fc) {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("id");
    }
    
    public String createCustomer(){
        System.out.println("sdsd"+cust.getFirstName());
        cust=cejb.createCustomer(cust);
        users=createUser();
        users=uejb.createUsers(users);
        customers=cejb.findAllCustomer();
        return "login.xhtml";
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
        System.out.println("Current User is : "+this.getCurrentUsers());
        return customers= cejb.findCustomerWithUserId(this.getCurrentUsers());
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
        users.setPassword("12345");
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

    /**
     * @return the currentUsers
     */
    public String getCurrentUsers() {
        return HttpUtils.getSessionIdentity().getUsername();
    }

    /**
     * @return the selectedId
     */
    public String getSelectedId() {
        return selectedId;
    }

    /**
     * @param selectedId the selectedId to set
     */
    public void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }
    /**
     * @return the messages
     */
    public Messages getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

}
