/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.DesignItemBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "DESIGN_ITEMBO")
public class DesignItemDTO extends BaseFWDTOImpl<DesignItemBO> {

private java.lang.Long designItemId;
private java.lang.Long catDesignItemId;
private java.lang.Long designItemNoteId;
private java.lang.Long constructionDesignId;

    @Override
    public DesignItemBO toModel() {
        DesignItemBO designItemBO = new DesignItemBO();
        designItemBO.setDesignItemId(this.designItemId);
        designItemBO.setCatDesignItemId(this.catDesignItemId);
        designItemBO.setDesignItemNoteId(this.designItemNoteId);
        designItemBO.setConstructionDesignId(this.constructionDesignId);
        return designItemBO;
    }

    @Override
     public Long getFWModelId() {
        return designItemId;
    }
   
    @Override
    public String catchName() {
        return getDesignItemId().toString();
    }
    public java.lang.Long getDesignItemId(){
    return designItemId;
    }
    public void setDesignItemId(java.lang.Long designItemId)
    {
    this.designItemId = designItemId;
    }
    
    public java.lang.Long getCatDesignItemId(){
    return catDesignItemId;
    }
    public void setCatDesignItemId(java.lang.Long catDesignItemId)
    {
    this.catDesignItemId = catDesignItemId;
    }
    
    public java.lang.Long getDesignItemNoteId(){
    return designItemNoteId;
    }
    public void setDesignItemNoteId(java.lang.Long designItemNoteId)
    {
    this.designItemNoteId = designItemNoteId;
    }
    
    public java.lang.Long getConstructionDesignId(){
    return constructionDesignId;
    }
    public void setConstructionDesignId(java.lang.Long constructionDesignId)
    {
    this.constructionDesignId = constructionDesignId;
    }
    
   
}
