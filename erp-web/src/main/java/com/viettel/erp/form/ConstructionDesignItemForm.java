/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.form;

//import com.viettel.service.ktts.CatConstrDesignItemDTO;




/**
 *
 * @author hanhls1-local
 */
public class ConstructionDesignItemForm {    
     private java.lang.Long catConstrDesignItemId;
    private java.lang.String catConstrDesignItemName;
    private java.lang.String catConstrDesignItemCode;
    private java.lang.String description;
    private java.lang.Long isActive;
    private java.lang.Long constructType;

    
//    public CatConstrDesignItemDTO toDTO() {
//        CatConstrDesignItemDTO catConstrDesignItemBO = new CatConstrDesignItemDTO();
//        catConstrDesignItemBO.setCatConstrDesignItemId(this.catConstrDesignItemId);
//        catConstrDesignItemBO.setCatConstrDesignItemName(this.catConstrDesignItemName);
//        catConstrDesignItemBO.setCatConstrDesignItemCode(this.catConstrDesignItemCode);
//        catConstrDesignItemBO.setDescription(this.description);
//        catConstrDesignItemBO.setIsActive(this.isActive);
//        catConstrDesignItemBO.setConstructType(this.constructType);
//        return catConstrDesignItemBO;
//    }

 

    public java.lang.Long getCatConstrDesignItemId() {
        return catConstrDesignItemId;
    }

    public void setCatConstrDesignItemId(java.lang.Long catConstrDesignItemId) {
        this.catConstrDesignItemId = catConstrDesignItemId;
    }

    public java.lang.String getCatConstrDesignItemName() {
        return catConstrDesignItemName;
    }

    public void setCatConstrDesignItemName(java.lang.String catConstrDesignItemName) {
        this.catConstrDesignItemName = catConstrDesignItemName;
    }

    public java.lang.String getCatConstrDesignItemCode() {
        return catConstrDesignItemCode;
    }

    public void setCatConstrDesignItemCode(java.lang.String catConstrDesignItemCode) {
        this.catConstrDesignItemCode = catConstrDesignItemCode;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public java.lang.Long getIsActive() {
        return isActive;
    }

    public void setIsActive(java.lang.Long isActive) {
        this.isActive = isActive;
    }

    public java.lang.Long getConstructType() {
        return constructType;
    }

    public void setConstructType(java.lang.Long constructType) {
        this.constructType = constructType;
    }

}
