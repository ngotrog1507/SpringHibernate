/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.DesignItemPropertyDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "DESIGN_ITEM_PROPERTY")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class DesignItemPropertyBO extends BaseFWModelImpl {
     
private java.lang.Long designItemPropertyId;
private java.lang.Long catDesignItemId;
private java.lang.Long checkValidateValue;
private java.lang.String validateValueClass;
private java.lang.String labelKey;
private java.lang.Long catValueTypeId;
private java.lang.Long colspan;

 public DesignItemPropertyBO() {
        setColId("designItemPropertyId");
        setColName("designItemPropertyId");
        setUniqueColumn(new String[]{"designItemPropertyId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "DESIGN_ITEM_PROPERTY_SEQ")
            }
    )
@Column(name = "DESIGN_ITEM_PROPERTY_ID", length = 22)
public java.lang.Long getDesignItemPropertyId(){
return designItemPropertyId;
}
public void setDesignItemPropertyId(java.lang.Long designItemPropertyId)
{
this.designItemPropertyId = designItemPropertyId;
}
@Column(name = "CAT_DESIGN_ITEM_ID", length = 22)
public java.lang.Long getCatDesignItemId(){
return catDesignItemId;
}
public void setCatDesignItemId(java.lang.Long catDesignItemId)
{
this.catDesignItemId = catDesignItemId;
}
@Column(name = "CHECK_VALIDATE_VALUE", length = 22)
public java.lang.Long getCheckValidateValue(){
return checkValidateValue;
}
public void setCheckValidateValue(java.lang.Long checkValidateValue)
{
this.checkValidateValue = checkValidateValue;
}
@Column(name = "VALIDATE_VALUE_CLASS", length = 200)
public java.lang.String getValidateValueClass(){
return validateValueClass;
}
public void setValidateValueClass(java.lang.String validateValueClass)
{
this.validateValueClass = validateValueClass;
}
@Column(name = "LABEL_KEY", length = 50)
public java.lang.String getLabelKey(){
return labelKey;
}
public void setLabelKey(java.lang.String labelKey)
{
this.labelKey = labelKey;
}
@Column(name = "CAT_VALUE_TYPE_ID", length = 22)
public java.lang.Long getCatValueTypeId(){
return catValueTypeId;
}
public void setCatValueTypeId(java.lang.Long catValueTypeId)
{
this.catValueTypeId = catValueTypeId;
}
@Column(name = "COLSPAN", length = 22)
public java.lang.Long getColspan(){
return colspan;
}
public void setColspan(java.lang.Long colspan)
{
this.colspan = colspan;
}
   

    @Override
    public DesignItemPropertyDTO toDTO() {
        DesignItemPropertyDTO designItemPropertyDTO = new DesignItemPropertyDTO();
        //set cac gia tri 
        designItemPropertyDTO.setDesignItemPropertyId(this.designItemPropertyId);
        designItemPropertyDTO.setCatDesignItemId(this.catDesignItemId);
        designItemPropertyDTO.setCheckValidateValue(this.checkValidateValue);
        designItemPropertyDTO.setValidateValueClass(this.validateValueClass);
        designItemPropertyDTO.setLabelKey(this.labelKey);
        designItemPropertyDTO.setCatValueTypeId(this.catValueTypeId);
        designItemPropertyDTO.setColspan(this.colspan);
        return designItemPropertyDTO;
    }
}
