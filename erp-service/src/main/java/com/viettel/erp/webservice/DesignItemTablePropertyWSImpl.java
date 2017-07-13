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
import com.viettel.erp.business.DesignItemTablePropertyBusinessImpl;
import com.viettel.erp.dto.DesignItemTablePropertyDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.pojo.ConditionBean;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.viettel.erp.webservice.DesignItemTablePropertyWS")

public class DesignItemTablePropertyWSImpl implements DesignItemTablePropertyWS {

    @Autowired
    DesignItemTablePropertyBusinessImpl designItemTablePropertyImpl;
    Logger logger = Logger.getLogger(DesignItemTablePropertyWSImpl.class);

    @Override
    public long getTotal()  throws Exception {
    try{
        return designItemTablePropertyImpl.count();
        } catch (Exception ex) {
                   logger.error(ex);
                   throw ex;
               }
    }

@Override
    public List<DesignItemTablePropertyDTO> getAll()  throws Exception {
    try{
        return designItemTablePropertyImpl.getAll(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    public DesignItemTablePropertyBusinessImpl getDesignItemTablePropertyBusinessImpl()  {
        return designItemTablePropertyImpl;
        
    }

    public void setDesignItemTablePropertyBusinessImpl(DesignItemTablePropertyBusinessImpl designItemTablePropertyImpl) {
        this.designItemTablePropertyImpl = designItemTablePropertyImpl;
    }

    @Override
    public BaseFWDTOImpl getOneById(Long costCenterId)  throws Exception {
    try{
        return this.designItemTablePropertyImpl.getOneById(costCenterId);

        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long save(DesignItemTablePropertyDTO costCenterBO)  throws Exception {
    try{
        return this.designItemTablePropertyImpl.save(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void delete(DesignItemTablePropertyDTO costCenterBO)  throws Exception {
    try{
        this.designItemTablePropertyImpl.delete(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<DesignItemTablePropertyDTO> searchByHql(String hql, List<ConditionBean> conditionBeans)
     throws Exception {
    try{
        return this.designItemTablePropertyImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<DesignItemTablePropertyDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
     throws Exception {
    try{
    return this.designItemTablePropertyImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
        try{        
        return this.designItemTablePropertyImpl.countByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public int executeByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
    try{
        return this.designItemTablePropertyImpl.executeByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Date getSysDate() throws Exception  {
    try{
        return this.designItemTablePropertyImpl.getSysDate();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long getNextValSequence(String sequense)  throws Exception {
    try{
        return this.designItemTablePropertyImpl.getNextValSequence(sequense);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

}
