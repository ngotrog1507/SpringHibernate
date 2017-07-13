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
import com.viettel.erp.dto.CostCenterDTO;

/**
 *
 * @author hunglq9
 */
@org.apache.cxf.feature.Features(features = "org.apache.cxf.feature.LoggingFeature")
@WebService(targetNamespace = "http://webservice.erp.viettel.com/")
public interface CostCenterWS {

    @WebMethod(operationName = "getTotal")
    long getTotal();

    @WebMethod(operationName = "getAll")
    public List<CostCenterDTO> getAll();

    @WebMethod(operationName = "getOneById")
    BaseFWDTOImpl getOneById(Long costCenterId);

    @WebMethod(operationName = "save")
    Long save(CostCenterDTO costCenterBO);

    @WebMethod(operationName = "delete")
    void delete(CostCenterDTO costCenterBO);

    @WebMethod(operationName = "searchByHql")
    List<CostCenterDTO> searchByHql(String hql, List<ConditionBean> conditionBeans);

    @WebMethod(operationName = "searchByHql2")
    List<CostCenterDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx);

    @WebMethod(operationName = "countByHql")
    Long countByHql(String hql, List<ConditionBean> conditionBeans);

    @WebMethod(operationName = "executeByHql")
    int executeByHql(String hql, List<ConditionBean> conditionBeans);

    @WebMethod(operationName = "getSysDate")
    Date getSysDate() throws Exception;

    @WebMethod(operationName = "getNextValSequence")
    Long getNextValSequence(String sequense);
}
