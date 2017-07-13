package com.viettel.erp.business;
 
import com.viettel.erp.bo.CatProvinceGroupBO;
import com.viettel.erp.dao.CatProvinceGroupDAO;
import com.viettel.erp.dto.CatProvinceGroupDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("catProvinceGroupBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CatProvinceGroupBusinessImpl extends BaseFWBusinessImpl<CatProvinceGroupDAO,CatProvinceGroupDTO, CatProvinceGroupBO> implements CatProvinceGroupBusiness {

    @Autowired
    private CatProvinceGroupDAO catProvinceGroupDAO;
    

     
    public CatProvinceGroupBusinessImpl() {
        tModel = new CatProvinceGroupBO();
        tDAO = catProvinceGroupDAO;
    }

    @Override
    public CatProvinceGroupDAO gettDAO() {
        return catProvinceGroupDAO;
    }

    @Override
    public long count() {
        return catProvinceGroupDAO.count("CatProvinceGroupBO", null);
    }

    

    
}
