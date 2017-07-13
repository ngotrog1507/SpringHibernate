package com.viettel.erp.business;
 
import com.viettel.erp.bo.DesignItemTablePropertyBO;
import com.viettel.erp.dao.DesignItemTablePropertyDAO;
import com.viettel.erp.dto.DesignItemTablePropertyDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("designItemTablePropertyBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DesignItemTablePropertyBusinessImpl extends BaseFWBusinessImpl<DesignItemTablePropertyDAO,DesignItemTablePropertyDTO, DesignItemTablePropertyBO> implements DesignItemTablePropertyBusiness {

    @Autowired
    private DesignItemTablePropertyDAO designItemTablePropertyDAO;
    

     
    public DesignItemTablePropertyBusinessImpl() {
        tModel = new DesignItemTablePropertyBO();
        tDAO = designItemTablePropertyDAO;
    }

    @Override
    public DesignItemTablePropertyDAO gettDAO() {
        return designItemTablePropertyDAO;
    }

    @Override
    public long count() {
        return designItemTablePropertyDAO.count("DesignItemTablePropertyBO", null);
    }

    

    
}
