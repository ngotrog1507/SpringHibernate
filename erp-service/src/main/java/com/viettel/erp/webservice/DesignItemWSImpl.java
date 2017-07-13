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
import com.viettel.erp.business.DesignItemBusinessImpl;
import com.viettel.erp.dto.DesignItemDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.pojo.ConditionBean;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.viettel.erp.webservice.DesignItemWS")

public class DesignItemWSImpl implements DesignItemWS {

    @Autowired
    DesignItemBusinessImpl designItemImpl;
    Logger logger = Logger.getLogger(DesignItemWSImpl.class);

    @Override
    public long getTotal()  throws Exception {
    try{
        return designItemImpl.count();
        } catch (Exception ex) {
                   logger.error(ex);
                   throw ex;
               }
    }

@Override
    public List<DesignItemDTO> getAll()  throws Exception {
    try{
        return designItemImpl.getAll(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    public DesignItemBusinessImpl getDesignItemBusinessImpl()  {
        return designItemImpl;
        
    }

    public void setDesignItemBusinessImpl(DesignItemBusinessImpl designItemImpl) {
        this.designItemImpl = designItemImpl;
    }

    @Override
    public BaseFWDTOImpl getOneById(Long costCenterId)  throws Exception {
    try{
        return this.designItemImpl.getOneById(costCenterId);

        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long save(DesignItemDTO costCenterBO)  throws Exception {
    try{
        return this.designItemImpl.save(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void delete(DesignItemDTO costCenterBO)  throws Exception {
    try{
        this.designItemImpl.delete(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<DesignItemDTO> searchByHql(String hql, List<ConditionBean> conditionBeans)
     throws Exception {
    try{
        return this.designItemImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<DesignItemDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
     throws Exception {
    try{
    return this.designItemImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
        try{        
        return this.designItemImpl.countByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public int executeByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
    try{
        return this.designItemImpl.executeByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Date getSysDate() throws Exception  {
    try{
        return this.designItemImpl.getSysDate();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long getNextValSequence(String sequense)  throws Exception {
    try{
        return this.designItemImpl.getNextValSequence(sequense);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

}
