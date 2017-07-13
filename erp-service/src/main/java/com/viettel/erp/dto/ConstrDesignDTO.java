/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.ConstrDesignBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "CONSTR_DESIGNBO")
public class ConstrDesignDTO extends BaseFWDTOImpl<ConstrDesignBO> {

private java.lang.Long constrDesignId;
private java.lang.String code;
private java.lang.String name;
private java.lang.Long type;

    @Override
    public ConstrDesignBO toModel() {
        ConstrDesignBO constrDesignBO = new ConstrDesignBO();
        constrDesignBO.setConstrDesignId(this.constrDesignId);
        constrDesignBO.setCode(this.code);
        constrDesignBO.setName(this.name);
        constrDesignBO.setType(this.type);
        return constrDesignBO;
    }

    @Override
     public Long getFWModelId() {
        return constrDesignId;
    }
   
    @Override
    public String catchName() {
        return getConstrDesignId().toString();
    }
    public java.lang.Long getConstrDesignId(){
    return constrDesignId;
    }
    public void setConstrDesignId(java.lang.Long constrDesignId)
    {
    this.constrDesignId = constrDesignId;
    }
    
    public java.lang.String getCode(){
    return code;
    }
    public void setCode(java.lang.String code)
    {
    this.code = code;
    }
    
    public java.lang.String getName(){
    return name;
    }
    public void setName(java.lang.String name)
    {
    this.name = name;
    }
    
    public java.lang.Long getType(){
    return type;
    }
    public void setType(java.lang.Long type)
    {
    this.type = type;
    }
    
   /*
    
    */
    private List<DesignItemDTO> designItems = new ArrayList<>();
    private Map<Long, DesignItemDTO> designItemIdSet = new HashMap<Long, DesignItemDTO>();

    public boolean containKey(Long id) {
        return designItemIdSet.containsKey(id);
    }

    public void addDesignItemDTO(DesignItemDTO dto) {
        designItems.add(dto);
        designItemIdSet.put(dto.getCatDesignItemId(), dto);
    }

    public DesignItemDTO getDesignItemExt(Long id) {
        return designItemIdSet.get(id);
    }

//    public List<DesignItemDTO> getDesignItems() {
//        return designItems;
//    }

    public List<DesignItemDTO> getDesignItems() {
        return designItems;
    }

    public void setDesignItems(List<DesignItemDTO> designItems) {
        this.designItems = designItems;
    }

}
