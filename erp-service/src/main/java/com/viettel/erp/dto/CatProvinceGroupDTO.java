/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.CatProvinceGroupBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "CAT_PROVINCE_GROUPBO")
public class CatProvinceGroupDTO extends BaseFWDTOImpl<CatProvinceGroupBO> {

private java.lang.Long catProvinceGroupId;
private java.lang.String name;
private java.lang.String description;
private java.lang.Long isActive;
private java.lang.String code;

    @Override
    public CatProvinceGroupBO toModel() {
        CatProvinceGroupBO catProvinceGroupBO = new CatProvinceGroupBO();
        catProvinceGroupBO.setCatProvinceGroupId(this.catProvinceGroupId);
        catProvinceGroupBO.setName(this.name);
        catProvinceGroupBO.setDescription(this.description);
        catProvinceGroupBO.setIsActive(this.isActive);
        catProvinceGroupBO.setCode(this.code);
        return catProvinceGroupBO;
    }

    @Override
     public Long getFWModelId() {
        return catProvinceGroupId;
    }
   
    @Override
    public String catchName() {
        return getCatProvinceGroupId().toString();
    }
    public java.lang.Long getCatProvinceGroupId(){
    return catProvinceGroupId;
    }
    public void setCatProvinceGroupId(java.lang.Long catProvinceGroupId)
    {
    this.catProvinceGroupId = catProvinceGroupId;
    }
    
    public java.lang.String getName(){
    return name;
    }
    public void setName(java.lang.String name)
    {
    this.name = name;
    }
    
    public java.lang.String getDescription(){
    return description;
    }
    public void setDescription(java.lang.String description)
    {
    this.description = description;
    }
    
    public java.lang.Long getIsActive(){
    return isActive;
    }
    public void setIsActive(java.lang.Long isActive)
    {
    this.isActive = isActive;
    }
    
    public java.lang.String getCode(){
    return code;
    }
    public void setCode(java.lang.String code)
    {
    this.code = code;
    }
    
   
}
