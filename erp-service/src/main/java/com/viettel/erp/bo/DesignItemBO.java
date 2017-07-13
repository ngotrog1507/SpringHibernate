/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.DesignItemDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "DESIGN_ITEM")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class DesignItemBO extends BaseFWModelImpl {
     
private java.lang.Long designItemId;
private java.lang.Long catDesignItemId;
private java.lang.Long designItemNoteId;
private java.lang.Long constructionDesignId;

 public DesignItemBO() {
        setColId("designItemId");
        setColName("designItemId");
        setUniqueColumn(new String[]{"designItemId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "DESIGN_ITEM_SEQ")
            }
    )
@Column(name = "DESIGN_ITEM_ID", length = 22)
public java.lang.Long getDesignItemId(){
return designItemId;
}
public void setDesignItemId(java.lang.Long designItemId)
{
this.designItemId = designItemId;
}
@Column(name = "CAT_DESIGN_ITEM_ID", length = 22)
public java.lang.Long getCatDesignItemId(){
return catDesignItemId;
}
public void setCatDesignItemId(java.lang.Long catDesignItemId)
{
this.catDesignItemId = catDesignItemId;
}
@Column(name = "DESIGN_ITEM_NOTE_ID", length = 22)
public java.lang.Long getDesignItemNoteId(){
return designItemNoteId;
}
public void setDesignItemNoteId(java.lang.Long designItemNoteId)
{
this.designItemNoteId = designItemNoteId;
}
@Column(name = "CONSTRUCTION_DESIGN_ID", length = 22)
public java.lang.Long getConstructionDesignId(){
return constructionDesignId;
}
public void setConstructionDesignId(java.lang.Long constructionDesignId)
{
this.constructionDesignId = constructionDesignId;
}
   

    @Override
    public DesignItemDTO toDTO() {
        DesignItemDTO designItemDTO = new DesignItemDTO();
        //set cac gia tri 
        designItemDTO.setDesignItemId(this.designItemId);
        designItemDTO.setCatDesignItemId(this.catDesignItemId);
        designItemDTO.setDesignItemNoteId(this.designItemNoteId);
        designItemDTO.setConstructionDesignId(this.constructionDesignId);
        return designItemDTO;
    }
}
