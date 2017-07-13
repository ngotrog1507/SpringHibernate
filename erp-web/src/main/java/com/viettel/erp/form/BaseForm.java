/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.form;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

/**
 *
 * @author HungLQ9
 */
public class BaseForm {

    private String sortdatafield;
    private String sortorder;
    private int pagenum;
    private int pagesize;
    private String pq_filter;

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getPq_filter() {
        return pq_filter;
    }

    public void setPq_filter(String pq_filter) {
        this.pq_filter = pq_filter;
    }

    public String getSortdatafield() {
        return sortdatafield;
    }

    public void setSortdatafield(String sortdatafield) {
        this.sortdatafield = sortdatafield;
    }

    public String getSortorder() {
        return sortorder;
    }

    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }

    public FilterForm getFilterForm() {
        FilterForm form = null;
        if (pq_filter != null && !pq_filter.isEmpty()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                form = mapper.readValue(pq_filter, FilterForm.class);
            } catch (IOException ex) {
                Logger.getLogger(BaseForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return form;
    }
}
