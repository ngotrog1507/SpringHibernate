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
import com.viettel.erp.business.ActIdUserBusinessImpl;
import com.viettel.erp.business.ActIdUserBusinessImpl;
import com.viettel.erp.dto.ActIdUserDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.pojo.ConditionBean;
import com.viettel.service.base.pojo.OrderBean;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.viettel.erp.webservice.ActIdUserWS")

public class ActIdUserWSImpl implements ActIdUserWS {

    @Autowired
    ActIdUserBusinessImpl actIdUserImpl;
    Logger logger = Logger.getLogger(ActIdUserWSImpl.class);

    @Override
    public long getTotal() throws Exception {
        try {
            return actIdUserImpl.count();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<ActIdUserDTO> getAll() throws Exception {
        try {
            return actIdUserImpl.getAll(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    public ActIdUserBusinessImpl getActIdUserBusinessImpl() {
        return actIdUserImpl;

    }

    public void setActIdUserBusinessImpl(ActIdUserBusinessImpl actIdUserImpl) {
        this.actIdUserImpl = actIdUserImpl;
    }

    @Override
    public BaseFWDTOImpl getOneById(Long costCenterId) throws Exception {
        try {
            return this.actIdUserImpl.getOneById(costCenterId);

        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long save(ActIdUserDTO costCenterBO) throws Exception {
        try {
            return this.actIdUserImpl.save(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void delete(ActIdUserDTO costCenterBO) throws Exception {
        try {
            this.actIdUserImpl.delete(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<ActIdUserDTO> searchByHql(String hql, List<ConditionBean> conditionBeans)
            throws Exception {
        try {
            return this.actIdUserImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<ActIdUserDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
            throws Exception {
        try {
            return this.actIdUserImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans) throws Exception {
        try {
            return this.actIdUserImpl.countByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public int executeByHql(String hql, List<ConditionBean> conditionBeans) throws Exception {
        try {
            return this.actIdUserImpl.executeByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Date getSysDate() throws Exception {
        try {
            return this.actIdUserImpl.getSysDate();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long getNextValSequence(String sequense) throws Exception {
        try {
            return this.actIdUserImpl.getNextValSequence(sequense);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

}
