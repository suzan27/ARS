/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ars.utils;

import java.util.Optional;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bikesh
 */
public class HttpUtils {

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static HttpServletRequest getServletRequest() {
        return (HttpServletRequest) HttpUtils.getFacesContext().getExternalContext().getRequest();
    }

    public static void createHttpSession(Identity identity) {
        System.out.println("inside createHttpSession");
        HttpUtils.getServletRequest().getSession(true).setAttribute(Identity.SESSION_KEY, identity);
        System.out.println("SESSION ID:" + HttpUtils.getServletRequest().getSession(false).getId());
    }

    public static Identity getSessionIdentity() {
        Optional<HttpSession> session = Optional.ofNullable(HttpUtils.getServletRequest().getSession(false));
        if (session.isPresent()) {
            Optional<Object> sessionData = Optional.ofNullable(session.get().getAttribute(Identity.SESSION_KEY));
            if (sessionData.isPresent()) {
                return (Identity) sessionData.get();
            }
        }
        return Identity.createDefaultInstacne();
    }

    public static Identity getSessionIdentity(HttpServletRequest request) {
        Optional<HttpSession> session = Optional.ofNullable(request.getSession(false));
        if (session.isPresent()) {
            Optional<Object> sessionData = Optional.ofNullable(session.get().getAttribute(Identity.SESSION_KEY));
            if (sessionData.isPresent()) {
                return (Identity) sessionData.get();
            }
        }
        return Identity.createDefaultInstacne();
    }

}
