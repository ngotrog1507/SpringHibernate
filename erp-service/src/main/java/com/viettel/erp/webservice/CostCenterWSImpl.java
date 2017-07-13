/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.webservice;

/**
 *
 * @author hunglq9
 */
import com.viettel.erp.business.CostCenterBusinessImpl;
import com.viettel.erp.dto.CostCenterDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.pojo.ConditionBean;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;

@WebService(endpointInterface = "com.viettel.erp.webservice.CostCenterWS")

public class CostCenterWSImpl implements CostCenterWS {

    @Autowired
    CostCenterBusinessImpl costCenterImpl;

    @Override
    public long getTotal() {
        return costCenterImpl.count();
    }

    @Override
    public List<CostCenterDTO> getAll() {
        return costCenterImpl.getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    public CostCenterBusinessImpl getCostCenterBusinessImpl() {
        return costCenterImpl;
    }

    public void setCostCenterBusinessImpl(CostCenterBusinessImpl costCenterImpl) {
        this.costCenterImpl = costCenterImpl;
    }

    @Override
    public BaseFWDTOImpl getOneById(Long costCenterId) {
        return this.costCenterImpl.getOneById(costCenterId);
    }

    @Override
    public Long save(CostCenterDTO costCenterBO) {
        return this.costCenterImpl.save(costCenterBO);
    }

    @Override
    public void delete(CostCenterDTO costCenterBO) {
        this.costCenterImpl.delete(costCenterBO);
    }

    @Override
    public List<CostCenterDTO> searchByHql(String hql, List<ConditionBean> conditionBeans) {
        return this.costCenterImpl.searchByHql(hql, conditionBeans);
    }

    @Override
    public List<CostCenterDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx) {
        return this.costCenterImpl.searchByHql(hql, conditionBeans);
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans) {
        return this.costCenterImpl.countByHql(hql, conditionBeans);
    }

    @Override
    public int executeByHql(String hql, List<ConditionBean> conditionBeans) {
        return this.costCenterImpl.executeByHql(hql, conditionBeans);
    }

    @Override
    public Date getSysDate() throws Exception {
        return this.costCenterImpl.getSysDate();
    }

    @Override
    public Long getNextValSequence(String sequense) {
        return this.costCenterImpl.getNextValSequence(sequense);
    }

}
