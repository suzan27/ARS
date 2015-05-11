/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sujan
 */
@Entity
public class Airlines implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String airlineName;
    private String contactPersonName;
    private String contactPhoneNo;
    private String emailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airlines)) {
            return false;
        }
        Airlines other = (Airlines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.ars.entity.Airlines[ id=" + id + " ]";
    }

    /**
     * @return the airlineName
     */
    public String getAirlineName() {
        return airlineName;
    }

    /**
     * @param airlineName the airlineName to set
     */
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    /**
     * @return the contactPersonName
     */
    public String getContactPersonName() {
        return contactPersonName;
    }

    /**
     * @param contactPersonName the contactPersonName to set
     */
    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    /**
     * @return the contactPhoneNo
     */
    public String getContactPhoneNo() {
        return contactPhoneNo;
    }

    /**
     * @param contactPhoneNo the contactPhoneNo to set
     */
    public void setContactPhoneNo(String contactPhoneNo) {
        this.contactPhoneNo = contactPhoneNo;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
}
