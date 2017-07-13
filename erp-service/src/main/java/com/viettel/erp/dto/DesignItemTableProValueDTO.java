/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.DesignItemTableProValueBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "DESIGN_ITEM_TABLE_PRO_VALUEBO")
public class DesignItemTableProValueDTO extends BaseFWDTOImpl<DesignItemTableProValueBO> {

private java.lang.Long designItemTableProValueId;
private java.lang.String value;
private java.lang.Long designItemTablePropertyId;
private java.lang.Long designItemId;

    @Override
    public DesignItemTableProValueBO toModel() {
        DesignItemTableProValueBO designItemTableProValueBO = new DesignItemTableProValueBO();
        designItemTableProValueBO.setDesignItemTableProValueId(this.designItemTableProValueId);
        designItemTableProValueBO.setValue(this.value);
        designItemTableProValueBO.setDesignItemTablePropertyId(this.designItemTablePropertyId);
        designItemTableProValueBO.setDesignItemId(this.designItemId);
        return designItemTableProValueBO;
    }

    @Override
     public Long getFWModelId() {
        return designItemTableProValueId;
    }
   
    @Override
    public String catchName() {
        return getDesignItemTableProValueId().toString();
    }
    public java.lang.Long getDesignItemTableProValueId(){
    return designItemTableProValueId;
    }
    public void setDesignItemTableProValueId(java.lang.Long designItemTableProValueId)
    {
    this.designItemTableProValueId = designItemTableProValueId;
    }
    
    public java.lang.String getValue(){
    return value;
    }
    public void setValue(java.lang.String value)
    {
    this.value = value;
    }
    
    public java.lang.Long getDesignItemTablePropertyId(){
    return designItemTablePropertyId;
    }
    public void setDesignItemTablePropertyId(java.lang.Long designItemTablePropertyId)
    {
    this.designItemTablePropertyId = designItemTablePropertyId;
    }
    
    public java.lang.Long getDesignItemId(){
    return designItemId;
    }
    public void setDesignItemId(java.lang.Long designItemId)
    {
    this.designItemId = designItemId;
    }
    
   
}
