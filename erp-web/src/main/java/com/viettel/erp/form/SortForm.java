/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.form;

/**
 *
 * @author HungLQ9
 */
public class SortForm {

    private String dataIndx;
    private String dir;

    public String getDataIndx() {
        return dataIndx;
    }

    public void setDataIndx(String dataIndx) {
        this.dataIndx = dataIndx;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "sort by "+ dataIndx + " "+ dir; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
