/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author thuannht
 */
public class ProfitCenterBO implements Serializable{

    private String name;
    private String description;
    private Long total;
    private Date dateProfit;
    private Long profit;
    private Boolean isCheck;

    public Boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Boolean isCheck) {
        this.isCheck = isCheck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    //date getter method
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    public Date getDateProfit() {
        return dateProfit;
    }

    public void setDateProfit(Date dateProfit) {
        this.dateProfit = dateProfit;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

}
