package com.viettel.erp.business;
 
import com.viettel.erp.bo.DesignItemTableProValueBO;
import com.viettel.erp.dao.DesignItemTableProValueDAO;
import com.viettel.erp.dto.DesignItemTableProValueDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("designItemTableProValueBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DesignItemTableProValueBusinessImpl extends BaseFWBusinessImpl<DesignItemTableProValueDAO,DesignItemTableProValueDTO, DesignItemTableProValueBO> implements DesignItemTableProValueBusiness {

    @Autowired
    private DesignItemTableProValueDAO designItemTableProValueDAO;
    

     
    public DesignItemTableProValueBusinessImpl() {
        tModel = new DesignItemTableProValueBO();
        tDAO = designItemTableProValueDAO;
    }

    @Override
    public DesignItemTableProValueDAO gettDAO() {
        return designItemTableProValueDAO;
    }

    @Override
    public long count() {
        return designItemTableProValueDAO.count("DesignItemTableProValueBO", null);
    }

    

    
}
