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
import com.viettel.erp.business.CatConstrDesignItemBusinessImpl;
import com.viettel.erp.dto.CatConstrDesignItemDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.dto.DataListDTO;
import com.viettel.service.base.pojo.ConditionBean;
import com.viettel.service.dto.wrapper.ResultDTOWrapper;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.viettel.erp.webservice.CatConstrDesignItemWS")
public class CatConstrDesignItemWSImpl implements CatConstrDesignItemWS {

    @Autowired
    CatConstrDesignItemBusinessImpl catConstrDesignItemImpl;
    Logger logger = Logger.getLogger(CatConstrDesignItemWSImpl.class);

    @Override
    public long getTotal()  throws Exception {
    try{
        return catConstrDesignItemImpl.count();
        } catch (Exception ex) {
                   logger.error(ex);
                   throw ex;
               }
    }

@Override
    public List<CatConstrDesignItemDTO> getAll()  throws Exception {
    try{
        return catConstrDesignItemImpl.getAll(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    public CatConstrDesignItemBusinessImpl getCatConstrDesignItemBusinessImpl()  {
        return catConstrDesignItemImpl;
        
    }

    public void setCatConstrDesignItemBusinessImpl(CatConstrDesignItemBusinessImpl catConstrDesignItemImpl) {
        this.catConstrDesignItemImpl = catConstrDesignItemImpl;
    }

    @Override
    public BaseFWDTOImpl getOneById(Long costCenterId)  throws Exception {
    try{
        return this.catConstrDesignItemImpl.getOneById(costCenterId);

        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }
    
    

    @Override
    public Long save(CatConstrDesignItemDTO costCenterBO)  throws Exception {
    try{
        
        return this.catConstrDesignItemImpl.save(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }
     @Override
    public Long update(CatConstrDesignItemDTO costCenterBO)  throws Exception {
    try{
        return this.catConstrDesignItemImpl.update(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void delete(CatConstrDesignItemDTO costCenterBO)  throws Exception {
    try{
        this.catConstrDesignItemImpl.delete(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<CatConstrDesignItemDTO> searchByHql(String hql, List<ConditionBean> conditionBeans)
     throws Exception {
    try{
        return this.catConstrDesignItemImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<CatConstrDesignItemDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
     throws Exception {
    try{
    return this.catConstrDesignItemImpl.searchByHql(hql, conditionBeans,startIdx,endIdx);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
        try{        
        return this.catConstrDesignItemImpl.countByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public int executeByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
    try{
        return this.catConstrDesignItemImpl.executeByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Date getSysDate() throws Exception  {
    try{
        return this.catConstrDesignItemImpl.getSysDate();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long getNextValSequence(String sequense)  throws Exception {
    try{
        return this.catConstrDesignItemImpl.getNextValSequence(sequense);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<CatConstrDesignItemDTO> searchByForm(CatConstrDesignItemDTO designItemForm) throws Exception {
           try{
        return catConstrDesignItemImpl.searchByForm(designItemForm, 0, 0);
           } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<CatConstrDesignItemDTO> searchByForm(CatConstrDesignItemDTO form, int startIndex, int size) throws Exception {
           try{
        return catConstrDesignItemImpl.searchByForm(form, startIndex, size);
         } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }
    @Override
    public long countByForm(CatConstrDesignItemDTO form) throws Exception{
           try{
        return catConstrDesignItemImpl.countByForm(form);
 } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }
     @Override
    public List<CatConstrDesignItemDTO> checkConstraint(CatConstrDesignItemDTO form) throws Exception {
        try {
            return catConstrDesignItemImpl.checkConstraint(form);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }
    @Override
    public DataListDTO searchByCatForm(CatConstrDesignItemDTO form,int startIndex, int size) throws Exception{
        try {
            DataListDTO dataList=new DataListDTO();
            List<CatConstrDesignItemDTO> lst=catConstrDesignItemImpl.searchByForm(form, startIndex, size);
            long total=catConstrDesignItemImpl.countByForm(form);
            dataList.setData(lst);
            dataList.setTotal((int)total);
            dataList.setStart(startIndex);
            dataList.setSize(size);
            return dataList;
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public ResultDTOWrapper<Long> saveObject(CatConstrDesignItemDTO costCenterBO) throws Exception {
        try {
            return catConstrDesignItemImpl.saveObject(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public ResultDTOWrapper<Long> updateObject(CatConstrDesignItemDTO costCenterBO) throws Exception {
        try {
            return catConstrDesignItemImpl.updateObject(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public ResultDTOWrapper<Long> deleteObject(CatConstrDesignItemDTO costCenterBO) throws Exception {
       try {
            return catConstrDesignItemImpl.deleteObject(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    

}
