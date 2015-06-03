package com.mycompany.ars.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author SurajChhetry
 */
@Named
public class Messages {

   
    private void addMessage(FacesMessage.Severity severity, String clinetId, String title, String message) {
        FacesContext.getCurrentInstance().addMessage(clinetId,new FacesMessage(severity,title, message));
    }

    public void addInfo(String clinetId, String title, String message) {
        addMessage(FacesMessage.SEVERITY_INFO, clinetId, title, message);
    }

    public void addWarn(String clinetId, String title, String message) {
        addMessage(FacesMessage.SEVERITY_WARN, clinetId, title, message);
    }

    public void addError(String clinetId, String title, String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, clinetId, title, message);
    }
}
