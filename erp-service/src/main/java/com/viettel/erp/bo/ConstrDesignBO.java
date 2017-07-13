/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.ConstrDesignDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CONSTR_DESIGN")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class ConstrDesignBO extends BaseFWModelImpl {
     
private java.lang.Long constrDesignId;
private java.lang.String code;
private java.lang.String name;
private java.lang.Long type;

 public ConstrDesignBO() {
        setColId("constrDesignId");
        setColName("constrDesignId");
        setUniqueColumn(new String[]{"constrDesignId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "CONSTR_DESIGN_SEQ")
            }
    )
@Column(name = "CONSTR_DESIGN_ID", length = 22)
public java.lang.Long getConstrDesignId(){
return constrDesignId;
}
public void setConstrDesignId(java.lang.Long constrDesignId)
{
this.constrDesignId = constrDesignId;
}
@Column(name = "CODE", length = 50)
public java.lang.String getCode(){
return code;
}
public void setCode(java.lang.String code)
{
this.code = code;
}
@Column(name = "NAME", length = 200)
public java.lang.String getName(){
return name;
}
public void setName(java.lang.String name)
{
this.name = name;
}
@Column(name = "TYPE", length = 22)
public java.lang.Long getType(){
return type;
}
public void setType(java.lang.Long type)
{
this.type = type;
}
   

    @Override
    public ConstrDesignDTO toDTO() {
        ConstrDesignDTO constrDesignDTO = new ConstrDesignDTO();
        //set cac gia tri 
        constrDesignDTO.setConstrDesignId(this.constrDesignId);
        constrDesignDTO.setCode(this.code);
        constrDesignDTO.setName(this.name);
        constrDesignDTO.setType(this.type);
        return constrDesignDTO;
    }
}
