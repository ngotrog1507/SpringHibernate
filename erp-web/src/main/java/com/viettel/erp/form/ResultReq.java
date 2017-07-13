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
public class ResultReq {

    private String messageCode;
    private String message;
    private List messageList;

    public ResultReq(String messageCode, String message) {
        this.messageCode = messageCode;
        this.message = message;

    }

    public ResultReq(String messageCode, String message, List messageList) {
        this.messageCode = messageCode;
        this.message = message;
        this.messageList = messageList;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getMessageList() {
        return messageList;
    }

    public void setMessageList(List messageList) {
        this.messageList = messageList;
    }

}
