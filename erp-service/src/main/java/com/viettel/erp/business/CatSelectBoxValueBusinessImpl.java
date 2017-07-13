package com.viettel.erp.business;
 
import com.viettel.erp.bo.CatSelectBoxValueBO;
import com.viettel.erp.dao.CatSelectBoxValueDAO;
import com.viettel.erp.dto.CatSelectBoxValueDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("catSelectBoxValueBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CatSelectBoxValueBusinessImpl extends BaseFWBusinessImpl<CatSelectBoxValueDAO,CatSelectBoxValueDTO, CatSelectBoxValueBO> implements CatSelectBoxValueBusiness {

    @Autowired
    private CatSelectBoxValueDAO catSelectBoxValueDAO;
    

     
    public CatSelectBoxValueBusinessImpl() {
        tModel = new CatSelectBoxValueBO();
        tDAO = catSelectBoxValueDAO;
    }

    @Override
    public CatSelectBoxValueDAO gettDAO() {
        return catSelectBoxValueDAO;
    }

    @Override
    public long count() {
        return catSelectBoxValueDAO.count("CatSelectBoxValueBO", null);
    }

    

    
}
