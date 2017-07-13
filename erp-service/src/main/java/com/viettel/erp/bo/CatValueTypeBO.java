/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.CatValueTypeDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CAT_VALUE_TYPE")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class CatValueTypeBO extends BaseFWModelImpl {
     
private java.lang.Long catValueTypeId;
private java.lang.String name;
private java.lang.String code;

 public CatValueTypeBO() {
        setColId("catValueTypeId");
        setColName("catValueTypeId");
        setUniqueColumn(new String[]{"catValueTypeId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "CAT_VALUE_TYPE_SEQ")
            }
    )
@Column(name = "CAT_VALUE_TYPE_ID", length = 22)
public java.lang.Long getCatValueTypeId(){
return catValueTypeId;
}
public void setCatValueTypeId(java.lang.Long catValueTypeId)
{
this.catValueTypeId = catValueTypeId;
}
@Column(name = "NAME", length = 100)
public java.lang.String getName(){
return name;
}
public void setName(java.lang.String name)
{
this.name = name;
}
@Column(name = "CODE", length = 50)
public java.lang.String getCode(){
return code;
}
public void setCode(java.lang.String code)
{
this.code = code;
}
   

    @Override
    public CatValueTypeDTO toDTO() {
        CatValueTypeDTO catValueTypeDTO = new CatValueTypeDTO();
        //set cac gia tri 
        catValueTypeDTO.setCatValueTypeId(this.catValueTypeId);
        catValueTypeDTO.setName(this.name);
        catValueTypeDTO.setCode(this.code);
        return catValueTypeDTO;
    }
}
