package com.viettel.erp.business;
 
import com.viettel.erp.bo.CatDesignItemBO;
import com.viettel.erp.dao.CatDesignItemDAO;
import com.viettel.erp.dto.CatDesignItemDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("catDesignItemBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CatDesignItemBusinessImpl extends BaseFWBusinessImpl<CatDesignItemDAO,CatDesignItemDTO, CatDesignItemBO> implements CatDesignItemBusiness {

    @Autowired
    private CatDesignItemDAO catDesignItemDAO;
    

     
    public CatDesignItemBusinessImpl() {
        tModel = new CatDesignItemBO();
        tDAO = catDesignItemDAO;
    }

    @Override
    public CatDesignItemDAO gettDAO() {
        return catDesignItemDAO;
    }

    @Override
    public long count() {
        return catDesignItemDAO.count("CatDesignItemBO", null);
    }

    

    
}
