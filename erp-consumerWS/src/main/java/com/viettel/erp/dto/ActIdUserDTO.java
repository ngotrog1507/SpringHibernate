/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "ACT_ID_USERBO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActIdUserDTO {

    private String defaultSortField;
//    private String fwmodelId;
    private java.lang.Long id;
    private java.lang.String email;
    private java.lang.String first;
    private java.lang.String last;
    private java.lang.Long pictureId;
    private java.lang.String pwd;
    private java.lang.Long rev;

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getFirst() {
        return first;
    }

    public void setFirst(java.lang.String first) {
        this.first = first;
    }

    public java.lang.String getLast() {
        return last;
    }

    public void setLast(java.lang.String last) {
        this.last = last;
    }

    public java.lang.Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(java.lang.Long pictureId) {
        this.pictureId = pictureId;
    }

    public java.lang.String getPwd() {
        return pwd;
    }

    public void setPwd(java.lang.String pwd) {
        this.pwd = pwd;
    }

    public java.lang.Long getRev() {
        return rev;
    }

    public void setRev(java.lang.Long rev) {
        this.rev = rev;
    }

    public String getDefaultSortField() {
        return defaultSortField;
    }

    public void setDefaultSortField(String defaultSortField) {
        this.defaultSortField = defaultSortField;
    }

}
