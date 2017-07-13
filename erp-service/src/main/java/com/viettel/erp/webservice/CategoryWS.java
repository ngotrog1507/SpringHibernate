/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.webservice;

import com.viettel.erp.bo.UtilAttachedDocumentsBO;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Date;
import com.viettel.erp.dto.CatProvinceGroupDTO;
import com.viettel.erp.dto.ConstrDesignDTO;
import com.viettel.erp.dto.ConstrDesignExtDTO;
import com.viettel.erp.dto.UtilAttachedDocumentsDTO;
import com.viettel.service.base.pojo.ConditionBean;
import java.util.List;

/**
 *
 * @author hunglq9
 */
@org.apache.cxf.feature.Features(features = "org.apache.cxf.feature.LoggingFeature")
@WebService(targetNamespace = "http://webservice.erp.viettel.com/")
public interface CategoryWS {

    @WebMethod(operationName = "getAllCatProvinceGroupActive")
    List<CatProvinceGroupDTO> getAllCatProvinceGroupActive() throws Exception;
     @WebMethod(operationName = "countByHql")
    Long countByHql(String hql, List<ConditionBean> conditionBeans) throws Exception;

    @WebMethod(operationName = "getSysDate")
    Date getSysDate() throws Exception;

    @WebMethod(operationName = "getNextValSequence")
    Long getNextValSequence(String sequense) throws Exception;
    
    @WebMethod(operationName = "saveAttachment")
    Long saveAttachment(UtilAttachedDocumentsDTO dto) throws Exception;
    
    @WebMethod(operationName = "getAttachmentById")
    UtilAttachedDocumentsDTO getAttachmentById(Long id) throws Exception;
    
    @WebMethod(operationName = "getAllAttachment")
    List<UtilAttachedDocumentsDTO> getAllAttachment(UtilAttachedDocumentsDTO dto) throws Exception;
        
    
    @WebMethod(operationName = "test")
    List<ConstrDesignDTO> getAllConstrDesignExt() throws Exception;
}
