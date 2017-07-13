package com.viettel.erp.business;
 
import com.viettel.erp.bo.UtilAttachedDocumentsBO;
import com.viettel.erp.dao.UtilAttachedDocumentsDAO;
import com.viettel.erp.dto.UtilAttachedDocumentsDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("utilAttachedDocumentsBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UtilAttachedDocumentsBusinessImpl extends BaseFWBusinessImpl<UtilAttachedDocumentsDAO,UtilAttachedDocumentsDTO, UtilAttachedDocumentsBO> implements UtilAttachedDocumentsBusiness {

    @Autowired
    private UtilAttachedDocumentsDAO utilAttachedDocumentsDAO;
    

     
    public UtilAttachedDocumentsBusinessImpl() {
        tModel = new UtilAttachedDocumentsBO();
        tDAO = utilAttachedDocumentsDAO;
    }

    @Override
    public UtilAttachedDocumentsDAO gettDAO() {
        return utilAttachedDocumentsDAO;
    }

    @Override
    public long count() {
        return utilAttachedDocumentsDAO.count("UtilAttachedDocumentsBO", null);
    }

    

    
}
