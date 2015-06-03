/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.controller;


import com.mycompany.ars.ejb.IUserEJB;
import com.mycompany.ars.entity.Users;
import com.mycompany.ars.utils.Messages;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Sujan
 */
@ManagedBean
@ViewScoped
public class UserController {
    
    @EJB
    private IUserEJB uejb;
    private Users users;
    private List<Users> userList= new ArrayList<>();
    private String selectedId;
    private String newPassword;
    private String confirmPassword;
    
    @Inject
    private Messages messages;
    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.setSelectedId(this.parameterForEdit(fc));
        System.out.println("Inside UserController");
        System.out.println(this.getSelectedId());
        if (StringUtils.length(getSelectedId()) > 0) {
            this.users = this.uejb.findUserByUsername(getSelectedId());
           

        } else {
            this.users = new Users();
        }

    }
     private String parameterForEdit(FacesContext fc) {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("userid");
    }
    
    
    public void changePasswordUpdate(){
        if(this.getNewPassword() == null ? this.getConfirmPassword() != null : !this.getNewPassword().equals(this.getConfirmPassword())){
            messages.addError(getSelectedId(), "password", "Password doesnt match");
        }
        else
            this.users.setPassword(this.confirmPassword);
            users=this.uejb.updateUsers(users);
    }
    
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
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
