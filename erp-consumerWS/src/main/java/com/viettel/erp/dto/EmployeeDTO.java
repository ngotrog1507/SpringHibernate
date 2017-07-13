/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

/**
 *
 * @author thuannht
 */
public class EmployeeDTO {

    private String defaultSortField;
    private java.lang.Long employeeId;
    private java.lang.String employeeName;
    private java.lang.String description;
    private java.util.Date dateBirth;
    private java.lang.Long status;
    private java.lang.Long position;

    public java.lang.Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(java.lang.Long employeeId) {
        this.employeeId = employeeId;
    }

    public java.lang.String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(java.lang.String employeeName) {
        this.employeeName = employeeName;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public java.util.Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(java.util.Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public java.lang.Long getStatus() {
        return status;
    }

    public void setStatus(java.lang.Long status) {
        this.status = status;
    }

    public java.lang.Long getPosition() {
        return position;
    }

    public void setPosition(java.lang.Long position) {
        this.position = position;
    }

    public String getDefaultSortField() {
        return defaultSortField;
    }

    public void setDefaultSortField(String defaultSortField) {
        this.defaultSortField = defaultSortField;
    }

}
