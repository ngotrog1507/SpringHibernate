/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.CatSelectBoxValueBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "CAT_SELECT_BOX_VALUEBO")
public class CatSelectBoxValueDTO extends BaseFWDTOImpl<CatSelectBoxValueBO> {

private java.lang.Long catSelectBoxValueId;
private java.lang.String value;
private java.lang.String label;
private java.lang.Long designItemPropertyId;
private java.lang.Long designItemTablePropertyId;

    @Override
    public CatSelectBoxValueBO toModel() {
        CatSelectBoxValueBO catSelectBoxValueBO = new CatSelectBoxValueBO();
        catSelectBoxValueBO.setCatSelectBoxValueId(this.catSelectBoxValueId);
        catSelectBoxValueBO.setValue(this.value);
        catSelectBoxValueBO.setLabel(this.label);
        catSelectBoxValueBO.setDesignItemPropertyId(this.designItemPropertyId);
        catSelectBoxValueBO.setDesignItemTablePropertyId(this.designItemTablePropertyId);
        return catSelectBoxValueBO;
    }

    @Override
     public Long getFWModelId() {
        return catSelectBoxValueId;
    }
   
    @Override
    public String catchName() {
        return getCatSelectBoxValueId().toString();
    }
    public java.lang.Long getCatSelectBoxValueId(){
    return catSelectBoxValueId;
    }
    public void setCatSelectBoxValueId(java.lang.Long catSelectBoxValueId)
    {
    this.catSelectBoxValueId = catSelectBoxValueId;
    }
    
    public java.lang.String getValue(){
    return value;
    }
    public void setValue(java.lang.String value)
    {
    this.value = value;
    }
    
    public java.lang.String getLabel(){
    return label;
    }
    public void setLabel(java.lang.String label)
    {
    this.label = label;
    }
    
    public java.lang.Long getDesignItemPropertyId(){
    return designItemPropertyId;
    }
    public void setDesignItemPropertyId(java.lang.Long designItemPropertyId)
    {
    this.designItemPropertyId = designItemPropertyId;
    }
    
    public java.lang.Long getDesignItemTablePropertyId(){
    return designItemTablePropertyId;
    }
    public void setDesignItemTablePropertyId(java.lang.Long designItemTablePropertyId)
    {
    this.designItemTablePropertyId = designItemTablePropertyId;
    }
    
   
}
