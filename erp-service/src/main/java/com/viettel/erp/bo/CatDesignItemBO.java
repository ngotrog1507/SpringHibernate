/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.CatDesignItemDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CAT_DESIGN_ITEM")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class CatDesignItemBO extends BaseFWModelImpl {
     
private java.lang.Long catDesignItemId;
private java.lang.Long type;
private java.lang.String code;
private java.lang.String name;

 public CatDesignItemBO() {
        setColId("catDesignItemId");
        setColName("catDesignItemId");
        setUniqueColumn(new String[]{"catDesignItemId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "CAT_DESIGN_ITEM_SEQ")
            }
    )
@Column(name = "CAT_DESIGN_ITEM_ID", length = 22)
public java.lang.Long getCatDesignItemId(){
return catDesignItemId;
}
public void setCatDesignItemId(java.lang.Long catDesignItemId)
{
this.catDesignItemId = catDesignItemId;
}
@Column(name = "TYPE", length = 22)
public java.lang.Long getType(){
return type;
}
public void setType(java.lang.Long type)
{
this.type = type;
}
@Column(name = "CODE", length = 50)
public java.lang.String getCode(){
return code;
}
public void setCode(java.lang.String code)
{
this.code = code;
}
@Column(name = "NAME", length = 100)
public java.lang.String getName(){
return name;
}
public void setName(java.lang.String name)
{
this.name = name;
}
   

    @Override
    public CatDesignItemDTO toDTO() {
        CatDesignItemDTO catDesignItemDTO = new CatDesignItemDTO();
        //set cac gia tri 
        catDesignItemDTO.setCatDesignItemId(this.catDesignItemId);
        catDesignItemDTO.setType(this.type);
        catDesignItemDTO.setCode(this.code);
        catDesignItemDTO.setName(this.name);
        return catDesignItemDTO;
    }
}
