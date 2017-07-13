package com.viettel.erp.business;
 
import com.viettel.erp.bo.DesignItemPropertyBO;
import com.viettel.erp.dao.DesignItemPropertyDAO;
import com.viettel.erp.dto.DesignItemPropertyDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("designItemPropertyBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DesignItemPropertyBusinessImpl extends BaseFWBusinessImpl<DesignItemPropertyDAO,DesignItemPropertyDTO, DesignItemPropertyBO> implements DesignItemPropertyBusiness {

    @Autowired
    private DesignItemPropertyDAO designItemPropertyDAO;
    

     
    public DesignItemPropertyBusinessImpl() {
        tModel = new DesignItemPropertyBO();
        tDAO = designItemPropertyDAO;
    }

    @Override
    public DesignItemPropertyDAO gettDAO() {
        return designItemPropertyDAO;
    }

    @Override
    public long count() {
        return designItemPropertyDAO.count("DesignItemPropertyBO", null);
    }

    

    
}
