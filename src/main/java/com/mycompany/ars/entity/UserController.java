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
@ManagedBean
@RequestScoped
public class UserController {
    
    @EJB
    private UserEJB uejb;
    private Users users;
    private List<Users> userList= new ArrayList<>();

    /**
     * @return the users
     */
    
    public void doCreateUser(){
        users=uejb.createUsers(users);
        
    }
    public Users getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * @return the userList
     */
    public List<Users> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }
    
}
