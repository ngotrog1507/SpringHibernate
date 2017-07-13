/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.DesignItemPropertyValueBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "DESIGN_ITEM_PROPERTY_VALUEBO")
public class DesignItemPropertyValueDTO extends BaseFWDTOImpl<DesignItemPropertyValueBO> {

private java.lang.Long designItemPropertyValueId;
private java.lang.String value;
private java.lang.Long designItemPropertyId;
private java.lang.Long designItemId;

    @Override
    public DesignItemPropertyValueBO toModel() {
        DesignItemPropertyValueBO designItemPropertyValueBO = new DesignItemPropertyValueBO();
        designItemPropertyValueBO.setDesignItemPropertyValueId(this.designItemPropertyValueId);
        designItemPropertyValueBO.setValue(this.value);
        designItemPropertyValueBO.setDesignItemPropertyId(this.designItemPropertyId);
        designItemPropertyValueBO.setDesignItemId(this.designItemId);
        return designItemPropertyValueBO;
    }

    @Override
     public Long getFWModelId() {
        return designItemPropertyValueId;
    }
   
    @Override
    public String catchName() {
        return getDesignItemPropertyValueId().toString();
    }
    public java.lang.Long getDesignItemPropertyValueId(){
    return designItemPropertyValueId;
    }
    public void setDesignItemPropertyValueId(java.lang.Long designItemPropertyValueId)
    {
    this.designItemPropertyValueId = designItemPropertyValueId;
    }
    
    public java.lang.String getValue(){
    return value;
    }
    public void setValue(java.lang.String value)
    {
    this.value = value;
    }
    
    public java.lang.Long getDesignItemPropertyId(){
    return designItemPropertyId;
    }
    public void setDesignItemPropertyId(java.lang.Long designItemPropertyId)
    {
    this.designItemPropertyId = designItemPropertyId;
    }
    
    public java.lang.Long getDesignItemId(){
    return designItemId;
    }
    public void setDesignItemId(java.lang.Long designItemId)
    {
    this.designItemId = designItemId;
    }
    
   
}
