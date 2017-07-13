/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.CostCenterDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "COST_CENTER")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class CostCenterBO extends BaseFWModelImpl {

    private java.lang.Long costCenterId;
    private java.lang.String costCenterName;
    private java.lang.String description;
    private java.util.Date exportDate;

    public CostCenterBO() {
        setColId("costCenterId");
        setColName("costCenterId");
        setUniqueColumn(new String[]{"costCenterId"});
    }

    @Id
    @GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "COST_CENTER_SEQ")
            }
    )
    @Column(name = "COST_CENTER_ID", length = 22)
    public java.lang.Long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(java.lang.Long costCenterId) {
        this.costCenterId = costCenterId;
    }

    @Column(name = "COST_CENTER_NAME", length = 100)
    public java.lang.String getCostCenterName() {
        return costCenterName;
    }

    public void setCostCenterName(java.lang.String costCenterName) {
        this.costCenterName = costCenterName;
    }

    @Column(name = "DESCRIPTION", length = 1000)
    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    @Column(name = "EXPORT_DATE", length = 7)
    public java.util.Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(java.util.Date exportDate) {
        this.exportDate = exportDate;
    }

    @Override
    public CostCenterDTO toDTO() {
        CostCenterDTO costCenterDTO = new CostCenterDTO();
        //set cac gia tri 
        costCenterDTO.setCostCenterId(this.costCenterId);
        costCenterDTO.setCostCenterName(this.costCenterName);
        costCenterDTO.setDescription(this.description);
        costCenterDTO.setExportDate(this.exportDate);
        return costCenterDTO;
    }
}
