/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.CatDesignItemBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "CAT_DESIGN_ITEMBO")
public class CatDesignItemDTO extends BaseFWDTOImpl<CatDesignItemBO> {

private java.lang.Long catDesignItemId;
private java.lang.Long type;
private java.lang.String code;
private java.lang.String name;

    @Override
    public CatDesignItemBO toModel() {
        CatDesignItemBO catDesignItemBO = new CatDesignItemBO();
        catDesignItemBO.setCatDesignItemId(this.catDesignItemId);
        catDesignItemBO.setType(this.type);
        catDesignItemBO.setCode(this.code);
        catDesignItemBO.setName(this.name);
        return catDesignItemBO;
    }

    @Override
     public Long getFWModelId() {
        return catDesignItemId;
    }
   
    @Override
    public String catchName() {
        return getCatDesignItemId().toString();
    }
    public java.lang.Long getCatDesignItemId(){
    return catDesignItemId;
    }
    public void setCatDesignItemId(java.lang.Long catDesignItemId)
    {
    this.catDesignItemId = catDesignItemId;
    }
    
    public java.lang.Long getType(){
    return type;
    }
    public void setType(java.lang.Long type)
    {
    this.type = type;
    }
    
    public java.lang.String getCode(){
    return code;
    }
    public void setCode(java.lang.String code)
    {
    this.code = code;
    }
    
    public java.lang.String getName(){
    return name;
    }
    public void setName(java.lang.String name)
    {
    this.name = name;
    }
    
   
}
