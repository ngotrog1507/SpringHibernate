package com.viettel.erp.business;
 
import com.viettel.erp.bo.ConstrDesignBO;
import com.viettel.erp.dao.ConstrDesignDAO;
import com.viettel.erp.dto.ConstrDesignDTO;
import com.viettel.erp.dto.ConstrDesignExtDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("constrDesignBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ConstrDesignBusinessImpl extends BaseFWBusinessImpl<ConstrDesignDAO,ConstrDesignDTO, ConstrDesignBO> implements ConstrDesignBusiness {

    @Autowired
    private ConstrDesignDAO constrDesignDAO;
    

     
    public ConstrDesignBusinessImpl() {
        tModel = new ConstrDesignBO();
        tDAO = constrDesignDAO;
    }

    @Override
    public ConstrDesignDAO gettDAO() {
        return constrDesignDAO;
    }

    @Override
    public long count() {
        return constrDesignDAO.count("ConstrDesignBO", null);
    }

    public List<ConstrDesignDTO> getAllConstrDesignExt() {
        return constrDesignDAO.getAllConstrDesignExt();
    }

    

    
}
