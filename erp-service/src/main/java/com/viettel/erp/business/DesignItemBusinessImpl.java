package com.viettel.erp.business;
 
import com.viettel.erp.bo.DesignItemBO;
import com.viettel.erp.dao.DesignItemDAO;
import com.viettel.erp.dto.DesignItemDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("designItemBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DesignItemBusinessImpl extends BaseFWBusinessImpl<DesignItemDAO,DesignItemDTO, DesignItemBO> implements DesignItemBusiness {

    @Autowired
    private DesignItemDAO designItemDAO;
    

     
    public DesignItemBusinessImpl() {
        tModel = new DesignItemBO();
        tDAO = designItemDAO;
    }

    @Override
    public DesignItemDAO gettDAO() {
        return designItemDAO;
    }

    @Override
    public long count() {
        return designItemDAO.count("DesignItemBO", null);
    }

    

    
}
