/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.CatValueTypeBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "CAT_VALUE_TYPEBO")
public class CatValueTypeDTO extends BaseFWDTOImpl<CatValueTypeBO> {

private java.lang.Long catValueTypeId;
private java.lang.String name;
private java.lang.String code;

    @Override
    public CatValueTypeBO toModel() {
        CatValueTypeBO catValueTypeBO = new CatValueTypeBO();
        catValueTypeBO.setCatValueTypeId(this.catValueTypeId);
        catValueTypeBO.setName(this.name);
        catValueTypeBO.setCode(this.code);
        return catValueTypeBO;
    }

    @Override
     public Long getFWModelId() {
        return catValueTypeId;
    }
   
    @Override
    public String catchName() {
        return getCatValueTypeId().toString();
    }
    public java.lang.Long getCatValueTypeId(){
    return catValueTypeId;
    }
    public void setCatValueTypeId(java.lang.Long catValueTypeId)
    {
    this.catValueTypeId = catValueTypeId;
    }
    
    public java.lang.String getName(){
    return name;
    }
    public void setName(java.lang.String name)
    {
    this.name = name;
    }
    
    public java.lang.String getCode(){
    return code;
    }
    public void setCode(java.lang.String code)
    {
    this.code = code;
    }
    
   
}
