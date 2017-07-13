/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.DesignItemPropertyBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "DESIGN_ITEM_PROPERTYBO")
public class DesignItemPropertyDTO extends BaseFWDTOImpl<DesignItemPropertyBO> {

private java.lang.Long designItemPropertyId;
private java.lang.Long catDesignItemId;
private java.lang.Long checkValidateValue;
private java.lang.String validateValueClass;
private java.lang.String labelKey;
private java.lang.Long catValueTypeId;
private java.lang.Long colspan;

    @Override
    public DesignItemPropertyBO toModel() {
        DesignItemPropertyBO designItemPropertyBO = new DesignItemPropertyBO();
        designItemPropertyBO.setDesignItemPropertyId(this.designItemPropertyId);
        designItemPropertyBO.setCatDesignItemId(this.catDesignItemId);
        designItemPropertyBO.setCheckValidateValue(this.checkValidateValue);
        designItemPropertyBO.setValidateValueClass(this.validateValueClass);
        designItemPropertyBO.setLabelKey(this.labelKey);
        designItemPropertyBO.setCatValueTypeId(this.catValueTypeId);
        designItemPropertyBO.setColspan(this.colspan);
        return designItemPropertyBO;
    }

    @Override
     public Long getFWModelId() {
        return designItemPropertyId;
    }
   
    @Override
    public String catchName() {
        return getDesignItemPropertyId().toString();
    }
    public java.lang.Long getDesignItemPropertyId(){
    return designItemPropertyId;
    }
    public void setDesignItemPropertyId(java.lang.Long designItemPropertyId)
    {
    this.designItemPropertyId = designItemPropertyId;
    }
    
    public java.lang.Long getCatDesignItemId(){
    return catDesignItemId;
    }
    public void setCatDesignItemId(java.lang.Long catDesignItemId)
    {
    this.catDesignItemId = catDesignItemId;
    }
    
    public java.lang.Long getCheckValidateValue(){
    return checkValidateValue;
    }
    public void setCheckValidateValue(java.lang.Long checkValidateValue)
    {
    this.checkValidateValue = checkValidateValue;
    }
    
    public java.lang.String getValidateValueClass(){
    return validateValueClass;
    }
    public void setValidateValueClass(java.lang.String validateValueClass)
    {
    this.validateValueClass = validateValueClass;
    }
    
    public java.lang.String getLabelKey(){
    return labelKey;
    }
    public void setLabelKey(java.lang.String labelKey)
    {
    this.labelKey = labelKey;
    }
    
    public java.lang.Long getCatValueTypeId(){
    return catValueTypeId;
    }
    public void setCatValueTypeId(java.lang.Long catValueTypeId)
    {
    this.catValueTypeId = catValueTypeId;
    }
    
    public java.lang.Long getColspan(){
    return colspan;
    }
    public void setColspan(java.lang.Long colspan)
    {
    this.colspan = colspan;
    }
    
   
}
