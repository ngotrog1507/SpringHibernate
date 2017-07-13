package com.viettel.erp.business;

import com.viettel.erp.bo.CostCenterBO;
import com.viettel.erp.dao.CostCenterDAO;
import com.viettel.erp.dto.CostCenterDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("costCenterBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CostCenterBusinessImpl extends BaseFWBusinessImpl<CostCenterDAO, CostCenterDTO, CostCenterBO> implements CostCenterBusiness {

    @Autowired
    private CostCenterDAO costCenterDAO;

    public CostCenterBusinessImpl() {
        tModel = new CostCenterBO();
        tDAO = costCenterDAO;
    }

    @Override
    public long count() {
        return costCenterDAO.count("CostCenterBO", null);
    }
//
       @Override
    public CostCenterDAO gettDAO() {
        return costCenterDAO;
    }

}
