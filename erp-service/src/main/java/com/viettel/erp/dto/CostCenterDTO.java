/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.CostCenterBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "COST_CENTERBO")
public class CostCenterDTO extends BaseFWDTOImpl<CostCenterBO> {

private java.lang.Long costCenterId;
private java.lang.String costCenterName;
private java.lang.String description;
private java.util.Date exportDate;

    @Override
    public CostCenterBO toModel() {
        CostCenterBO costCenterBO = new CostCenterBO();
        costCenterBO.setCostCenterId(this.costCenterId);
        costCenterBO.setCostCenterName(this.costCenterName);
        costCenterBO.setDescription(this.description);
        costCenterBO.setExportDate(this.exportDate);
        return costCenterBO;
    }

    @Override
     public Long getFWModelId() {
        return costCenterId;
    }
   
    @Override
    public String catchName() {
        return getCostCenterId().toString();
    }
    public java.lang.Long getCostCenterId(){
    return costCenterId;
    }
    public void setCostCenterId(java.lang.Long costCenterId)
    {
    this.costCenterId = costCenterId;
    }
    
    public java.lang.String getCostCenterName(){
    return costCenterName;
    }
    public void setCostCenterName(java.lang.String costCenterName)
    {
    this.costCenterName = costCenterName;
    }
    
    public java.lang.String getDescription(){
    return description;
    }
    public void setDescription(java.lang.String description)
    {
    this.description = description;
    }
    
    public java.util.Date getExportDate(){
    return exportDate;
    }
    public void setExportDate(java.util.Date exportDate)
    {
    this.exportDate = exportDate;
    }
    
   
}
