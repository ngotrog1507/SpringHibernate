/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.pojo.ConditionBean;
import java.util.Date;
import java.util.List;
import com.viettel.erp.dto.CatConstrDesignItemDTO;
import com.viettel.service.base.dto.DataListDTO;
import com.viettel.service.dto.wrapper.ResultDTOWrapper;
/**
 *
 * @author hunglq9
 */
@org.apache.cxf.feature.Features(features = "org.apache.cxf.feature.LoggingFeature")
@WebService(targetNamespace = "http://webservice.erp.viettel.com/")
public interface CatConstrDesignItemWS {

    @WebMethod(operationName = "getTotal")
    long getTotal()  throws Exception;
 

    @WebMethod(operationName = "getAll")
    public List<CatConstrDesignItemDTO> getAll()  throws java.lang.Exception;

    @WebMethod(operationName = "getOneById")
    BaseFWDTOImpl getOneById(Long costCenterId)  throws Exception;

    @WebMethod(operationName = "save")
    Long save(CatConstrDesignItemDTO costCenterBO) throws Exception;
    @WebMethod(operationName = "update")
    Long update(CatConstrDesignItemDTO costCenterBO) throws Exception;

    @WebMethod(operationName = "delete")
    void delete(CatConstrDesignItemDTO costCenterBO) throws Exception;

    @WebMethod(operationName = "searchByHql")
    List<CatConstrDesignItemDTO> searchByHql(String hql, List<ConditionBean> conditionBeans) throws Exception;

    @WebMethod(operationName = "searchByHql2")
    List<CatConstrDesignItemDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
    throws Exception;

    @WebMethod(operationName = "countByHql")
    Long countByHql(String hql, List<ConditionBean> conditionBeans) throws Exception;

        @WebMethod(operationName = "executeByHql")
    int executeByHql(String hql, List<ConditionBean> conditionBeans) throws Exception;

    @WebMethod(operationName = "getSysDate")
    Date getSysDate() throws Exception ;

    @WebMethod(operationName = "getNextValSequence")
    Long getNextValSequence(String sequense) throws Exception;
    
    @WebMethod(operationName = "searchByForm")
    List<CatConstrDesignItemDTO> searchByForm(CatConstrDesignItemDTO form) throws Exception;
    
    @WebMethod(operationName = "searchByForm2")
    List<CatConstrDesignItemDTO> searchByForm(CatConstrDesignItemDTO form, int startIndex,int size) throws Exception;
    
    @WebMethod(operationName = "countByForm")
    public long countByForm(CatConstrDesignItemDTO form) throws Exception;
    
    @WebMethod(operationName = "checkConstraint")
    List<CatConstrDesignItemDTO> checkConstraint(CatConstrDesignItemDTO form) throws Exception;
    
    @WebMethod(operationName = "searchByCatForm")
    DataListDTO searchByCatForm(CatConstrDesignItemDTO form,int startIndex, int size) throws Exception;
    
    @WebMethod(operationName = "saveObject")
    ResultDTOWrapper<Long> saveObject(CatConstrDesignItemDTO costCenterBO) throws Exception;
    
    @WebMethod(operationName = "updateObject")
    ResultDTOWrapper<Long> updateObject(CatConstrDesignItemDTO costCenterBO) throws Exception;
    
    @WebMethod(operationName = "deleteObject")
    ResultDTOWrapper<Long> deleteObject(CatConstrDesignItemDTO costCenterBO) throws Exception;
}
