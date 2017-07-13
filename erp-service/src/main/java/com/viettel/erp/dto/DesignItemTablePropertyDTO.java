/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.DesignItemTablePropertyBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "DESIGN_ITEM_TABLE_PROPERTYBO")
public class DesignItemTablePropertyDTO extends BaseFWDTOImpl<DesignItemTablePropertyBO> {

private java.lang.Long designItemTablePropertyId;
private java.lang.String labelKey;
private java.lang.Long catValueTypeId;
private java.lang.Long designItemPropertyId;
private java.lang.Long checkValidateValue;
private java.lang.String validateValueType;

    @Override
    public DesignItemTablePropertyBO toModel() {
        DesignItemTablePropertyBO designItemTablePropertyBO = new DesignItemTablePropertyBO();
        designItemTablePropertyBO.setDesignItemTablePropertyId(this.designItemTablePropertyId);
        designItemTablePropertyBO.setLabelKey(this.labelKey);
        designItemTablePropertyBO.setCatValueTypeId(this.catValueTypeId);
        designItemTablePropertyBO.setDesignItemPropertyId(this.designItemPropertyId);
        designItemTablePropertyBO.setCheckValidateValue(this.checkValidateValue);
        designItemTablePropertyBO.setValidateValueType(this.validateValueType);
        return designItemTablePropertyBO;
    }

    @Override
     public Long getFWModelId() {
        return designItemTablePropertyId;
    }
   
    @Override
    public String catchName() {
        return getDesignItemTablePropertyId().toString();
    }
    public java.lang.Long getDesignItemTablePropertyId(){
    return designItemTablePropertyId;
    }
    public void setDesignItemTablePropertyId(java.lang.Long designItemTablePropertyId)
    {
    this.designItemTablePropertyId = designItemTablePropertyId;
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
    
    public java.lang.Long getDesignItemPropertyId(){
    return designItemPropertyId;
    }
    public void setDesignItemPropertyId(java.lang.Long designItemPropertyId)
    {
    this.designItemPropertyId = designItemPropertyId;
    }
    
    public java.lang.Long getCheckValidateValue(){
    return checkValidateValue;
    }
    public void setCheckValidateValue(java.lang.Long checkValidateValue)
    {
    this.checkValidateValue = checkValidateValue;
    }
    
    public java.lang.String getValidateValueType(){
    return validateValueType;
    }
    public void setValidateValueType(java.lang.String validateValueType)
    {
    this.validateValueType = validateValueType;
    }
    
   
}
