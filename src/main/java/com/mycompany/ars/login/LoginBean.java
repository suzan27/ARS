package com.mycompany.ars.login;

import com.mycompany.ars.ejb.IUserEJB;
import com.mycompany.ars.entity.Users;
import com.mycompany.ars.utils.HttpUtils;
import com.mycompany.ars.utils.Identity;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author Sujan
 */
@Named
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private Credential credential;
    @EJB
    private IUserEJB uejb;
    private Users user;
    private String message;
    private String returnMessage;

    @PostConstruct
    private void init() {
        this.credential = new Credential();
        this.user = new Users();
    }

    public String doLogin() {
        HttpUtils.createHttpSession(new Identity(this.credential.getUserName()));
        System.out.println(this.credential.getUserName() + " " + this.credential.getPassword());

        try{
        user = this.uejb.findUsersByParam(this.credential.getUserName(), this.credential.getPassword());
        //System.out.println("The user is : " + user.getUserName() + " " + user.getPassword());
            message = "Valid User";
            setReturnMessage("home.xhtml?faces-redirect=true");
        
        }
        catch (Exception e){
            message="Invalid User";
            setReturnMessage("login.xhtml");
            
        }
        return this.getReturnMessage();
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the returnMessage
     */
    public String getReturnMessage() {
        return returnMessage;
    }

    /**
     * @param returnMessage the returnMessage to set
     */
    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

}
