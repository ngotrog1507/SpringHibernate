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
import com.viettel.erp.business.DesignItemPropertyValueBusinessImpl;
import com.viettel.erp.dto.DesignItemPropertyValueDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.pojo.ConditionBean;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.viettel.erp.webservice.DesignItemPropertyValueWS")

public class DesignItemPropertyValueWSImpl implements DesignItemPropertyValueWS {

    @Autowired
    DesignItemPropertyValueBusinessImpl designItemPropertyValueImpl;
    Logger logger = Logger.getLogger(DesignItemPropertyValueWSImpl.class);

    @Override
    public long getTotal()  throws Exception {
    try{
        return designItemPropertyValueImpl.count();
        } catch (Exception ex) {
                   logger.error(ex);
                   throw ex;
               }
    }

@Override
    public List<DesignItemPropertyValueDTO> getAll()  throws Exception {
    try{
        return designItemPropertyValueImpl.getAll(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    public DesignItemPropertyValueBusinessImpl getDesignItemPropertyValueBusinessImpl()  {
        return designItemPropertyValueImpl;
        
    }

    public void setDesignItemPropertyValueBusinessImpl(DesignItemPropertyValueBusinessImpl designItemPropertyValueImpl) {
        this.designItemPropertyValueImpl = designItemPropertyValueImpl;
    }

    @Override
    public BaseFWDTOImpl getOneById(Long costCenterId)  throws Exception {
    try{
        return this.designItemPropertyValueImpl.getOneById(costCenterId);

        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long save(DesignItemPropertyValueDTO costCenterBO)  throws Exception {
    try{
        return this.designItemPropertyValueImpl.save(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void delete(DesignItemPropertyValueDTO costCenterBO)  throws Exception {
    try{
        this.designItemPropertyValueImpl.delete(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<DesignItemPropertyValueDTO> searchByHql(String hql, List<ConditionBean> conditionBeans)
     throws Exception {
    try{
        return this.designItemPropertyValueImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<DesignItemPropertyValueDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
     throws Exception {
    try{
    return this.designItemPropertyValueImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
        try{        
        return this.designItemPropertyValueImpl.countByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public int executeByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
    try{
        return this.designItemPropertyValueImpl.executeByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Date getSysDate() throws Exception  {
    try{
        return this.designItemPropertyValueImpl.getSysDate();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long getNextValSequence(String sequense)  throws Exception {
    try{
        return this.designItemPropertyValueImpl.getNextValSequence(sequense);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

}
