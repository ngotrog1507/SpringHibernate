package com.viettel.erp.business;
 
import com.viettel.erp.bo.ActIdUserBO;
import com.viettel.erp.dao.ActIdUserDAO;
import com.viettel.erp.dto.ActIdUserDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("actIdUserBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ActIdUserBusinessImpl extends BaseFWBusinessImpl<ActIdUserDAO,ActIdUserDTO, ActIdUserBO> implements ActIdUserBusiness {

    @Autowired
    private ActIdUserDAO actIdUserDAO;
    

     
    public ActIdUserBusinessImpl() {
        tModel = new ActIdUserBO();
        tDAO = actIdUserDAO;
    }

    @Override
    public ActIdUserDAO gettDAO() {
        return actIdUserDAO;
    }

    @Override
    public long count() {
        return actIdUserDAO.count("ActIdUserBO", null);
    }

    

    
}
