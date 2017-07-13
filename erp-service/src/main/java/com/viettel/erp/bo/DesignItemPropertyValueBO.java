/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.DesignItemPropertyValueDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "DESIGN_ITEM_PROPERTY_VALUE")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class DesignItemPropertyValueBO extends BaseFWModelImpl {
     
private java.lang.Long designItemPropertyValueId;
private java.lang.String value;
private java.lang.Long designItemPropertyId;
private java.lang.Long designItemId;

 public DesignItemPropertyValueBO() {
        setColId("designItemPropertyValueId");
        setColName("designItemPropertyValueId");
        setUniqueColumn(new String[]{"designItemPropertyValueId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "DESIGN_ITEM_PROPERTY_VALUE_SEQ")
            }
    )
@Column(name = "DESIGN_ITEM_PROPERTY_VALUE_ID", length = 22)
public java.lang.Long getDesignItemPropertyValueId(){
return designItemPropertyValueId;
}
public void setDesignItemPropertyValueId(java.lang.Long designItemPropertyValueId)
{
this.designItemPropertyValueId = designItemPropertyValueId;
}
@Column(name = "VALUE", length = 200)
public java.lang.String getValue(){
return value;
}
public void setValue(java.lang.String value)
{
this.value = value;
}
@Column(name = "DESIGN_ITEM_PROPERTY_ID", length = 22)
public java.lang.Long getDesignItemPropertyId(){
return designItemPropertyId;
}
public void setDesignItemPropertyId(java.lang.Long designItemPropertyId)
{
this.designItemPropertyId = designItemPropertyId;
}
@Column(name = "DESIGN_ITEM_ID", length = 22)
public java.lang.Long getDesignItemId(){
return designItemId;
}
public void setDesignItemId(java.lang.Long designItemId)
{
this.designItemId = designItemId;
}
   

    @Override
    public DesignItemPropertyValueDTO toDTO() {
        DesignItemPropertyValueDTO designItemPropertyValueDTO = new DesignItemPropertyValueDTO();
        //set cac gia tri 
        designItemPropertyValueDTO.setDesignItemPropertyValueId(this.designItemPropertyValueId);
        designItemPropertyValueDTO.setValue(this.value);
        designItemPropertyValueDTO.setDesignItemPropertyId(this.designItemPropertyId);
        designItemPropertyValueDTO.setDesignItemId(this.designItemId);
        return designItemPropertyValueDTO;
    }
}
