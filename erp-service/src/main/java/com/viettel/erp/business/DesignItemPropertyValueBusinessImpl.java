package com.viettel.erp.business;
 
import com.viettel.erp.bo.DesignItemPropertyValueBO;
import com.viettel.erp.dao.DesignItemPropertyValueDAO;
import com.viettel.erp.dto.DesignItemPropertyValueDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("designItemPropertyValueBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DesignItemPropertyValueBusinessImpl extends BaseFWBusinessImpl<DesignItemPropertyValueDAO,DesignItemPropertyValueDTO, DesignItemPropertyValueBO> implements DesignItemPropertyValueBusiness {

    @Autowired
    private DesignItemPropertyValueDAO designItemPropertyValueDAO;
    

     
    public DesignItemPropertyValueBusinessImpl() {
        tModel = new DesignItemPropertyValueBO();
        tDAO = designItemPropertyValueDAO;
    }

    @Override
    public DesignItemPropertyValueDAO gettDAO() {
        return designItemPropertyValueDAO;
    }

    @Override
    public long count() {
        return designItemPropertyValueDAO.count("DesignItemPropertyValueBO", null);
    }

    

    
}
