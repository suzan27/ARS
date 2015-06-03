package com.mycompany.ars.utils;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Sujan
 */
@Named
@SessionScoped
public class TemplateController implements Serializable{

    public String getUserName() {
        return HttpUtils.getSessionIdentity().getUsername();
    }
}
