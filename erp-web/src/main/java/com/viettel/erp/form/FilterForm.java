/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.form;

import java.util.List;

/**
 *
 * @author HungLQ9
 */
public class FilterForm {

    private String mode;
    private List<FilConForm> data;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<FilConForm> getData() {
        return data;
    }

    public void setData(List<FilConForm> data) {
        this.data = data;
    }

    

}
