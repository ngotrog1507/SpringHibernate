/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.CatSelectBoxValueDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CAT_SELECT_BOX_VALUE")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class CatSelectBoxValueBO extends BaseFWModelImpl {
     
private java.lang.Long catSelectBoxValueId;
private java.lang.String value;
private java.lang.String label;
private java.lang.Long designItemPropertyId;
private java.lang.Long designItemTablePropertyId;

 public CatSelectBoxValueBO() {
        setColId("catSelectBoxValueId");
        setColName("catSelectBoxValueId");
        setUniqueColumn(new String[]{"catSelectBoxValueId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "CAT_SELECT_BOX_VALUE_SEQ")
            }
    )
@Column(name = "CAT_SELECT_BOX_VALUE_ID", length = 22)
public java.lang.Long getCatSelectBoxValueId(){
return catSelectBoxValueId;
}
public void setCatSelectBoxValueId(java.lang.Long catSelectBoxValueId)
{
this.catSelectBoxValueId = catSelectBoxValueId;
}
@Column(name = "VALUE", length = 50)
public java.lang.String getValue(){
return value;
}
public void setValue(java.lang.String value)
{
this.value = value;
}
@Column(name = "LABEL", length = 100)
public java.lang.String getLabel(){
return label;
}
public void setLabel(java.lang.String label)
{
this.label = label;
}
@Column(name = "DESIGN_ITEM_PROPERTY_ID", length = 22)
public java.lang.Long getDesignItemPropertyId(){
return designItemPropertyId;
}
public void setDesignItemPropertyId(java.lang.Long designItemPropertyId)
{
this.designItemPropertyId = designItemPropertyId;
}
@Column(name = "DESIGN_ITEM_TABLE_PROPERTY_ID", length = 22)
public java.lang.Long getDesignItemTablePropertyId(){
return designItemTablePropertyId;
}
public void setDesignItemTablePropertyId(java.lang.Long designItemTablePropertyId)
{
this.designItemTablePropertyId = designItemTablePropertyId;
}
   

    @Override
    public CatSelectBoxValueDTO toDTO() {
        CatSelectBoxValueDTO catSelectBoxValueDTO = new CatSelectBoxValueDTO();
        //set cac gia tri 
        catSelectBoxValueDTO.setCatSelectBoxValueId(this.catSelectBoxValueId);
        catSelectBoxValueDTO.setValue(this.value);
        catSelectBoxValueDTO.setLabel(this.label);
        catSelectBoxValueDTO.setDesignItemPropertyId(this.designItemPropertyId);
        catSelectBoxValueDTO.setDesignItemTablePropertyId(this.designItemTablePropertyId);
        return catSelectBoxValueDTO;
    }
}
