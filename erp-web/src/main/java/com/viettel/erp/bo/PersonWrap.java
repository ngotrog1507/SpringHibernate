/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.bo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HungLQ9
 */
public class PersonWrap {

    private List<Integer> ids = new ArrayList<Integer>();

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
