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
import com.viettel.erp.business.CatValueTypeBusinessImpl;
import com.viettel.erp.dto.CatValueTypeDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.pojo.ConditionBean;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.viettel.erp.webservice.CatValueTypeWS")

public class CatValueTypeWSImpl implements CatValueTypeWS {

    @Autowired
    CatValueTypeBusinessImpl catValueTypeImpl;
    Logger logger = Logger.getLogger(CatValueTypeWSImpl.class);

    @Override
    public long getTotal()  throws Exception {
    try{
        return catValueTypeImpl.count();
        } catch (Exception ex) {
                   logger.error(ex);
                   throw ex;
               }
    }

@Override
    public List<CatValueTypeDTO> getAll()  throws Exception {
    try{
        return catValueTypeImpl.getAll(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    public CatValueTypeBusinessImpl getCatValueTypeBusinessImpl()  {
        return catValueTypeImpl;
        
    }

    public void setCatValueTypeBusinessImpl(CatValueTypeBusinessImpl catValueTypeImpl) {
        this.catValueTypeImpl = catValueTypeImpl;
    }

    @Override
    public BaseFWDTOImpl getOneById(Long costCenterId)  throws Exception {
    try{
        return this.catValueTypeImpl.getOneById(costCenterId);

        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long save(CatValueTypeDTO costCenterBO)  throws Exception {
    try{
        return this.catValueTypeImpl.save(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void delete(CatValueTypeDTO costCenterBO)  throws Exception {
    try{
        this.catValueTypeImpl.delete(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<CatValueTypeDTO> searchByHql(String hql, List<ConditionBean> conditionBeans)
     throws Exception {
    try{
        return this.catValueTypeImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<CatValueTypeDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
     throws Exception {
    try{
    return this.catValueTypeImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
        try{        
        return this.catValueTypeImpl.countByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public int executeByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
    try{
        return this.catValueTypeImpl.executeByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Date getSysDate() throws Exception  {
    try{
        return this.catValueTypeImpl.getSysDate();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long getNextValSequence(String sequense)  throws Exception {
    try{
        return this.catValueTypeImpl.getNextValSequence(sequense);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

}
