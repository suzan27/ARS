package com.mycompany.ars.login;

import com.mycompany.ars.utils.HttpUtils;
import com.mycompany.ars.utils.Identity;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 *
 * @author bikesh
 */
@Named
@javax.enterprise.context.SessionScoped
public class LoginBean implements Serializable{

    private Credential credential;

    @PostConstruct
    private void init() {
        this.credential = new Credential();
    }

    public String doLogin() {
        HttpUtils.createHttpSession(new Identity(this.credential.getUserName()));
        return "home.xhtml?faces-redirect=true";
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

}
