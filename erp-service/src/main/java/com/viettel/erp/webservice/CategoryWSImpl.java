/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.webservice;

/**
 *
 * @author hunglq9
 */
import com.viettel.erp.business.CatProvinceGroupBusinessImpl;
import com.viettel.erp.business.ConstrDesignBusinessImpl;
import com.viettel.erp.business.UtilAttachedDocumentsBusinessImpl;
import com.viettel.erp.dto.CatProvinceGroupDTO;
import com.viettel.erp.dto.ConstrDesignDTO;
import com.viettel.erp.dto.ConstrDesignExtDTO;
import com.viettel.erp.dto.UtilAttachedDocumentsDTO;
import com.viettel.service.base.pojo.ConditionBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.viettel.erp.webservice.CategoryWS")
public class CategoryWSImpl implements CategoryWS {

    @Autowired
    CatProvinceGroupBusinessImpl catProvinceGroupImpl;
    @Autowired
    UtilAttachedDocumentsBusinessImpl utilAttachmentImpl;
    @Autowired
    ConstrDesignBusinessImpl constrDesignBusinessImpl;
    Logger logger = Logger.getLogger(CategoryWSImpl.class);

    public CatProvinceGroupBusinessImpl getCatProvinceGroupBusinessImpl() {
        return catProvinceGroupImpl;

    }

    public void setCatProvinceGroupBusinessImpl(CatProvinceGroupBusinessImpl catProvinceGroupImpl) {
        this.catProvinceGroupImpl = catProvinceGroupImpl;
    }

    @Override
    public List<CatProvinceGroupDTO> getAllCatProvinceGroupActive() {
        try {
            return catProvinceGroupImpl.searchByHql("FROM CatProvinceGroupBO where isActive=1", new ArrayList<ConditionBean>()); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }

    }

    @Override
    public Date getSysDate() throws Exception {
        try {
            return this.catProvinceGroupImpl.getSysDate();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long getNextValSequence(String sequense) throws Exception {
        try {
            return this.catProvinceGroupImpl.getNextValSequence(sequense);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long saveAttachment(UtilAttachedDocumentsDTO dto) throws Exception {
        return utilAttachmentImpl.save(dto);
    }

    @Override
    public List<UtilAttachedDocumentsDTO> getAllAttachment(UtilAttachedDocumentsDTO dto) throws Exception {
        String hql="FROM UtilAttachedDocumentsBO where type=:type and parentId=:parentId";
        Map<String,Object> paramterMap=new HashMap<String, Object>();
        paramterMap.put("type", dto.getType());
        paramterMap.put("parentId", dto.getParentId());
        return utilAttachmentImpl.getByHql(hql, paramterMap);        
    }

    @Override
    public UtilAttachedDocumentsDTO getAttachmentById(Long id) throws Exception {
//         String hql="FROM UtilAttachedDocumentsBO where attachId=:attachId";
//         Map<String,Object> paramterMap=new HashMap<String, Object>();
//        paramterMap.put("attachId", id);
        return (UtilAttachedDocumentsDTO)utilAttachmentImpl.getOneById(id);
    }

    @Override
    public List<ConstrDesignDTO> getAllConstrDesignExt() throws Exception {
         
            
          return  constrDesignBusinessImpl.getAllConstrDesignExt();
                    
        
    }

}
