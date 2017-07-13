/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.CatConstrDesignItemDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CAT_CONSTR_DESIGN_ITEM")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class CatConstrDesignItemBO extends BaseFWModelImpl {
     
private java.lang.Long catConstrDesignItemId;
private java.lang.String catConstrDesignItemName;
private java.lang.String catConstrDesignItemCode;
private java.lang.String description;
private java.lang.Long isActive;
private java.lang.Long constructType;

 public CatConstrDesignItemBO() {
        setColId("catConstrDesignItemId");
        setColName("catConstrDesignItemId");
        setUniqueColumn(new String[]{"catConstrDesignItemId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "CAT_CONSTR_DESIGN_ITEM_SEQ")
            }
    )
@Column(name = "CAT_CONSTR_DESIGN_ITEM_ID", length = 22)
public java.lang.Long getCatConstrDesignItemId(){
return catConstrDesignItemId;
}
public void setCatConstrDesignItemId(java.lang.Long catConstrDesignItemId)
{
this.catConstrDesignItemId = catConstrDesignItemId;
}
@Column(name = "CAT_CONSTR_DESIGN_ITEM_NAME", length = 50)
public java.lang.String getCatConstrDesignItemName(){
return catConstrDesignItemName;
}
public void setCatConstrDesignItemName(java.lang.String catConstrDesignItemName)
{
this.catConstrDesignItemName = catConstrDesignItemName;
}
@Column(name = "CAT_CONSTR_DESIGN_ITEM_CODE", length = 50)
public java.lang.String getCatConstrDesignItemCode(){
return catConstrDesignItemCode;
}
public void setCatConstrDesignItemCode(java.lang.String catConstrDesignItemCode)
{
this.catConstrDesignItemCode = catConstrDesignItemCode;
}
@Column(name = "DESCRIPTION", length = 500)
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
@Column(name = "CONSTRUCT_TYPE", length = 22)
public java.lang.Long getConstructType(){
return constructType;
}
public void setConstructType(java.lang.Long constructType)
{
this.constructType = constructType;
}
   

    @Override
    public CatConstrDesignItemDTO toDTO() {
        CatConstrDesignItemDTO catConstrDesignItemDTO = new CatConstrDesignItemDTO();
        //set cac gia tri 
        catConstrDesignItemDTO.setCatConstrDesignItemId(this.catConstrDesignItemId);
        catConstrDesignItemDTO.setCatConstrDesignItemName(this.catConstrDesignItemName);
        catConstrDesignItemDTO.setCatConstrDesignItemCode(this.catConstrDesignItemCode);
        catConstrDesignItemDTO.setDescription(this.description);
        catConstrDesignItemDTO.setIsActive(this.isActive);
        catConstrDesignItemDTO.setConstructType(this.constructType);
        return catConstrDesignItemDTO;
    }
}
