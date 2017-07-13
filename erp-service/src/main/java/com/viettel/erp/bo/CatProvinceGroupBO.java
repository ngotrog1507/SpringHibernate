/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.CatProvinceGroupDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CAT_PROVINCE_GROUP")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class CatProvinceGroupBO extends BaseFWModelImpl {
     
private java.lang.Long catProvinceGroupId;
private java.lang.String name;
private java.lang.String description;
private java.lang.Long isActive;
private java.lang.String code;

 public CatProvinceGroupBO() {
        setColId("catProvinceGroupId");
        setColName("catProvinceGroupId");
        setUniqueColumn(new String[]{"catProvinceGroupId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "CAT_PROVINCE_GROUP_SEQ")
            }
    )
@Column(name = "CAT_PROVINCE_GROUP_ID", length = 22)
public java.lang.Long getCatProvinceGroupId(){
return catProvinceGroupId;
}
public void setCatProvinceGroupId(java.lang.Long catProvinceGroupId)
{
this.catProvinceGroupId = catProvinceGroupId;
}
@Column(name = "NAME", length = 90)
public java.lang.String getName(){
return name;
}
public void setName(java.lang.String name)
{
this.name = name;
}
@Column(name = "DESCRIPTION", length = 1500)
public java.lang.String getDescription(){
return description;
}
public void setDescription(java.lang.String description)
{
this.description = description;
}
@Column(name = "IS_ACTIVE", length = 22)
public java.lang.Long getIsActive(){
return isActive;
}
public void setIsActive(java.lang.Long isActive)
{
this.isActive = isActive;
}
@Column(name = "CODE", length = 20)
public java.lang.String getCode(){
return code;
}
public void setCode(java.lang.String code)
{
this.code = code;
}
   

    @Override
    public CatProvinceGroupDTO toDTO() {
        CatProvinceGroupDTO catProvinceGroupDTO = new CatProvinceGroupDTO();
        //set cac gia tri 
        catProvinceGroupDTO.setCatProvinceGroupId(this.catProvinceGroupId);
        catProvinceGroupDTO.setName(this.name);
        catProvinceGroupDTO.setDescription(this.description);
        catProvinceGroupDTO.setIsActive(this.isActive);
        catProvinceGroupDTO.setCode(this.code);
        return catProvinceGroupDTO;
    }
}
