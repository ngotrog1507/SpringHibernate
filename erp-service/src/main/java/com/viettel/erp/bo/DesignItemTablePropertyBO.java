/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.DesignItemTablePropertyDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "DESIGN_ITEM_TABLE_PROPERTY")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class DesignItemTablePropertyBO extends BaseFWModelImpl {
     
private java.lang.Long designItemTablePropertyId;
private java.lang.String labelKey;
private java.lang.Long catValueTypeId;
private java.lang.Long designItemPropertyId;
private java.lang.Long checkValidateValue;
private java.lang.String validateValueType;

 public DesignItemTablePropertyBO() {
        setColId("designItemTablePropertyId");
        setColName("designItemTablePropertyId");
        setUniqueColumn(new String[]{"designItemTablePropertyId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "DESIGN_ITEM_TABLE_PROPERTY_SEQ")
            }
    )
@Column(name = "DESIGN_ITEM_TABLE_PROPERTY_ID", length = 22)
public java.lang.Long getDesignItemTablePropertyId(){
return designItemTablePropertyId;
}
public void setDesignItemTablePropertyId(java.lang.Long designItemTablePropertyId)
{
this.designItemTablePropertyId = designItemTablePropertyId;
}
@Column(name = "LABEL_KEY", length = 100)
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
@Column(name = "DESIGN_ITEM_PROPERTY_ID", length = 22)
public java.lang.Long getDesignItemPropertyId(){
return designItemPropertyId;
}
public void setDesignItemPropertyId(java.lang.Long designItemPropertyId)
{
this.designItemPropertyId = designItemPropertyId;
}
@Column(name = "CHECK_VALIDATE_VALUE", length = 22)
public java.lang.Long getCheckValidateValue(){
return checkValidateValue;
}
public void setCheckValidateValue(java.lang.Long checkValidateValue)
{
this.checkValidateValue = checkValidateValue;
}
@Column(name = "VALIDATE_VALUE_TYPE", length = 100)
public java.lang.String getValidateValueType(){
return validateValueType;
}
public void setValidateValueType(java.lang.String validateValueType)
{
this.validateValueType = validateValueType;
}
   

    @Override
    public DesignItemTablePropertyDTO toDTO() {
        DesignItemTablePropertyDTO designItemTablePropertyDTO = new DesignItemTablePropertyDTO();
        //set cac gia tri 
        designItemTablePropertyDTO.setDesignItemTablePropertyId(this.designItemTablePropertyId);
        designItemTablePropertyDTO.setLabelKey(this.labelKey);
        designItemTablePropertyDTO.setCatValueTypeId(this.catValueTypeId);
        designItemTablePropertyDTO.setDesignItemPropertyId(this.designItemPropertyId);
        designItemTablePropertyDTO.setCheckValidateValue(this.checkValidateValue);
        designItemTablePropertyDTO.setValidateValueType(this.validateValueType);
        return designItemTablePropertyDTO;
    }
}
