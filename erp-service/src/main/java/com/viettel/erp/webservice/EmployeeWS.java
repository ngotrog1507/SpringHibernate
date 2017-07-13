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
import com.viettel.erp.dto.EmployeeDTO;

/**
 *
 * @author hunglq9
 */
@org.apache.cxf.feature.Features(features = "org.apache.cxf.feature.LoggingFeature")
@WebService(targetNamespace = "http://webservice.erp.viettel.com/")
public interface EmployeeWS {

    @WebMethod(operationName = "getTotal")
    long getTotal() throws Exception;

    @WebMethod(operationName = "getAll")
    public List<EmployeeDTO> getAll() throws Exception;

    @WebMethod(operationName = "getOneById")
    BaseFWDTOImpl getOneById(Long costCenterId) throws Exception;

    @WebMethod(operationName = "save")
    Long save(EmployeeDTO costCenterBO) throws Exception;

    @WebMethod(operationName = "delete")
    void delete(EmployeeDTO costCenterBO) throws Exception;

    @WebMethod(operationName = "searchByHql")
    List<EmployeeDTO> searchByHql(String hql, List<ConditionBean> conditionBeans) throws Exception;

    @WebMethod(operationName = "searchByHql2")
    List<EmployeeDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx) throws Exception;

    @WebMethod(operationName = "countByHql")
    Long countByHql(String hql, List<ConditionBean> conditionBeans) throws Exception;

    @WebMethod(operationName = "executeByHql")
    int executeByHql(String hql, List<ConditionBean> conditionBeans) throws Exception;

    @WebMethod(operationName = "getSysDate")
    Date getSysDate() throws Exception;

    @WebMethod(operationName = "getNextValSequence")
    Long getNextValSequence(String sequense) throws Exception;

    @WebMethod(operationName = "getLengthOfStr")
    public int getLengthOfStr(String str) throws Exception;

    @WebMethod(operationName = "genRandomStr")
    public String genRandomStr(int length) throws Exception;
}
