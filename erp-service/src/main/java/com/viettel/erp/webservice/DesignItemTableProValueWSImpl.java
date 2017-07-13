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
import com.viettel.erp.business.DesignItemTableProValueBusinessImpl;
import com.viettel.erp.dto.DesignItemTableProValueDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.pojo.ConditionBean;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.viettel.erp.webservice.DesignItemTableProValueWS")

public class DesignItemTableProValueWSImpl implements DesignItemTableProValueWS {

    @Autowired
    DesignItemTableProValueBusinessImpl designItemTableProValueImpl;
    Logger logger = Logger.getLogger(DesignItemTableProValueWSImpl.class);

    @Override
    public long getTotal()  throws Exception {
    try{
        return designItemTableProValueImpl.count();
        } catch (Exception ex) {
                   logger.error(ex);
                   throw ex;
               }
    }

@Override
    public List<DesignItemTableProValueDTO> getAll()  throws Exception {
    try{
        return designItemTableProValueImpl.getAll(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    public DesignItemTableProValueBusinessImpl getDesignItemTableProValueBusinessImpl()  {
        return designItemTableProValueImpl;
        
    }

    public void setDesignItemTableProValueBusinessImpl(DesignItemTableProValueBusinessImpl designItemTableProValueImpl) {
        this.designItemTableProValueImpl = designItemTableProValueImpl;
    }

    @Override
    public BaseFWDTOImpl getOneById(Long costCenterId)  throws Exception {
    try{
        return this.designItemTableProValueImpl.getOneById(costCenterId);

        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long save(DesignItemTableProValueDTO costCenterBO)  throws Exception {
    try{
        return this.designItemTableProValueImpl.save(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void delete(DesignItemTableProValueDTO costCenterBO)  throws Exception {
    try{
        this.designItemTableProValueImpl.delete(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<DesignItemTableProValueDTO> searchByHql(String hql, List<ConditionBean> conditionBeans)
     throws Exception {
    try{
        return this.designItemTableProValueImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<DesignItemTableProValueDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
     throws Exception {
    try{
    return this.designItemTableProValueImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
        try{        
        return this.designItemTableProValueImpl.countByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public int executeByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
    try{
        return this.designItemTableProValueImpl.executeByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Date getSysDate() throws Exception  {
    try{
        return this.designItemTableProValueImpl.getSysDate();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long getNextValSequence(String sequense)  throws Exception {
    try{
        return this.designItemTableProValueImpl.getNextValSequence(sequense);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

}
