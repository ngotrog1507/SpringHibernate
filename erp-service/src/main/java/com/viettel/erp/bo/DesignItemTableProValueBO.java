/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.DesignItemTableProValueDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "DESIGN_ITEM_TABLE_PRO_VALUE")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class DesignItemTableProValueBO extends BaseFWModelImpl {
     
private java.lang.Long designItemTableProValueId;
private java.lang.String value;
private java.lang.Long designItemTablePropertyId;
private java.lang.Long designItemId;

 public DesignItemTableProValueBO() {
        setColId("designItemTableProValueId");
        setColName("designItemTableProValueId");
        setUniqueColumn(new String[]{"designItemTableProValueId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "DESIGN_ITEM_TABLE_PRO_VALUE_SEQ")
            }
    )
@Column(name = "DESIGN_ITEM_TABLE_PRO_VALUE_ID", length = 22)
public java.lang.Long getDesignItemTableProValueId(){
return designItemTableProValueId;
}
public void setDesignItemTableProValueId(java.lang.Long designItemTableProValueId)
{
this.designItemTableProValueId = designItemTableProValueId;
}
@Column(name = "VALUE", length = 200)
public java.lang.String getValue(){
return value;
}
public void setValue(java.lang.String value)
{
this.value = value;
}
@Column(name = "DESIGN_ITEM_TABLE_PROPERTY_ID", length = 22)
public java.lang.Long getDesignItemTablePropertyId(){
return designItemTablePropertyId;
}
public void setDesignItemTablePropertyId(java.lang.Long designItemTablePropertyId)
{
this.designItemTablePropertyId = designItemTablePropertyId;
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
    public DesignItemTableProValueDTO toDTO() {
        DesignItemTableProValueDTO designItemTableProValueDTO = new DesignItemTableProValueDTO();
        //set cac gia tri 
        designItemTableProValueDTO.setDesignItemTableProValueId(this.designItemTableProValueId);
        designItemTableProValueDTO.setValue(this.value);
        designItemTableProValueDTO.setDesignItemTablePropertyId(this.designItemTablePropertyId);
        designItemTableProValueDTO.setDesignItemId(this.designItemId);
        return designItemTableProValueDTO;
    }
}
