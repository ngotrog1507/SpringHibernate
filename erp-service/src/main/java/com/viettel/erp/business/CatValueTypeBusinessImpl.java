package com.viettel.erp.business;
 
import com.viettel.erp.bo.CatValueTypeBO;
import com.viettel.erp.dao.CatValueTypeDAO;
import com.viettel.erp.dto.CatValueTypeDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("catValueTypeBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CatValueTypeBusinessImpl extends BaseFWBusinessImpl<CatValueTypeDAO,CatValueTypeDTO, CatValueTypeBO> implements CatValueTypeBusiness {

    @Autowired
    private CatValueTypeDAO catValueTypeDAO;
    

     
    public CatValueTypeBusinessImpl() {
        tModel = new CatValueTypeBO();
        tDAO = catValueTypeDAO;
    }

    @Override
    public CatValueTypeDAO gettDAO() {
        return catValueTypeDAO;
    }

    @Override
    public long count() {
        return catValueTypeDAO.count("CatValueTypeBO", null);
    }

    

    
}
