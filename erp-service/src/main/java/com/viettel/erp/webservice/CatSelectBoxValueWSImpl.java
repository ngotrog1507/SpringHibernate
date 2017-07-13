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
import com.viettel.erp.business.CatSelectBoxValueBusinessImpl;
import com.viettel.erp.dto.CatSelectBoxValueDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.pojo.ConditionBean;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.viettel.erp.webservice.CatSelectBoxValueWS")

public class CatSelectBoxValueWSImpl implements CatSelectBoxValueWS {

    @Autowired
    CatSelectBoxValueBusinessImpl catSelectBoxValueImpl;
    Logger logger = Logger.getLogger(CatSelectBoxValueWSImpl.class);

    @Override
    public long getTotal()  throws Exception {
    try{
        return catSelectBoxValueImpl.count();
        } catch (Exception ex) {
                   logger.error(ex);
                   throw ex;
               }
    }

@Override
    public List<CatSelectBoxValueDTO> getAll()  throws Exception {
    try{
        return catSelectBoxValueImpl.getAll(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    public CatSelectBoxValueBusinessImpl getCatSelectBoxValueBusinessImpl()  {
        return catSelectBoxValueImpl;
        
    }

    public void setCatSelectBoxValueBusinessImpl(CatSelectBoxValueBusinessImpl catSelectBoxValueImpl) {
        this.catSelectBoxValueImpl = catSelectBoxValueImpl;
    }

    @Override
    public BaseFWDTOImpl getOneById(Long costCenterId)  throws Exception {
    try{
        return this.catSelectBoxValueImpl.getOneById(costCenterId);

        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long save(CatSelectBoxValueDTO costCenterBO)  throws Exception {
    try{
        return this.catSelectBoxValueImpl.save(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void delete(CatSelectBoxValueDTO costCenterBO)  throws Exception {
    try{
        this.catSelectBoxValueImpl.delete(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<CatSelectBoxValueDTO> searchByHql(String hql, List<ConditionBean> conditionBeans)
     throws Exception {
    try{
        return this.catSelectBoxValueImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<CatSelectBoxValueDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
     throws Exception {
    try{
    return this.catSelectBoxValueImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
        try{        
        return this.catSelectBoxValueImpl.countByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public int executeByHql(String hql, List<ConditionBean> conditionBeans)  throws Exception {
    try{
        return this.catSelectBoxValueImpl.executeByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Date getSysDate() throws Exception  {
    try{
        return this.catSelectBoxValueImpl.getSysDate();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long getNextValSequence(String sequense)  throws Exception {
    try{
        return this.catSelectBoxValueImpl.getNextValSequence(sequense);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

}
