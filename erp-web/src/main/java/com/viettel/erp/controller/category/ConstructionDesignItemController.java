/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.controller.category;

import com.viettel.base.grid.JsonDataGrid;
import com.viettel.erp.base.BaseController;
import com.viettel.erp.common.ConvertUtil;
import com.viettel.erp.common.ErpConstants;
import com.viettel.erp.dto.CatConstrDesignItemDTO;
import com.viettel.erp.form.ResultReq;
import com.viettel.erp.webservice.CatConstrDesignItemWS;
import com.viettel.service.base.dto.DataListDTO;
import com.viettel.service.dto.wrapper.ResultDTOWrapper;

import com.viettel.ws.consumer.base.CxfWsClientFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thuannht
 */
@Controller
public class ConstructionDesignItemController extends BaseController {

    @RequestMapping(value = {"/constructionDesignItem"}, method = RequestMethod.GET)
    public ModelAndView preparePage() {
        try {
            ModelAndView model = new ModelAndView();
            model.setViewName("catConstrDesignItem");
//            model.setViewName("catConstrDesignItem");
            return model;
        } catch (Exception ex) {
            logger.error(ex);
            return errorModel;
        }
    }

    @RequestMapping(value = {"/searchConstructionDesignItem"}, method = RequestMethod.GET)
    public @ResponseBody
    JsonDataGrid search(CatConstrDesignItemDTO designItemForm) {
        try {
            CatConstrDesignItemWS catws = CxfWsClientFactory.createWsClient(CatConstrDesignItemWS.class);
            DataListDTO result = catws.searchByCatForm(designItemForm,(getCurrentPage()) *getTotalRecordPerPage(), getTotalRecordPerPage());
            JsonDataGrid dataGrid = ConvertUtil.gridFromDataListDTO(result, getCurrentPage());
            return dataGrid;
        } catch (Exception ex) {
            logger.error(ex);
            return null;
        }
    }
    
    //Thực thi việc insert, update bản ghi
    @RequestMapping(value = "/constructionDesignItem/add", method = RequestMethod.POST)
    public @ResponseBody
    ResultReq addConstructionDesignItems(CatConstrDesignItemDTO form) {
        ResultReq ret = null;
        try {
            //lay wsClient
            CatConstrDesignItemWS catws = CxfWsClientFactory.createWsClient(CatConstrDesignItemWS.class);
            if (form.getCatConstrDesignItemId() == null || form.getCatConstrDesignItemId() == 0) {
                //trường hợp insert
                form.setIsActive(1l);
                ResultDTOWrapper result= catws.saveObject(form);
                if(null != result.getCode())switch (result.getCode()) {
                    case ErpConstants.WS_RESPONSE_CODE.SUCCESS://case thanh cong                        
                        return new ResultReq(ErpConstants.WS_RESPONSE_CODE.SUCCESS, getLanguageByKey("msg.insert.success"));
                    case ErpConstants.WS_RESPONSE_CODE.INPUT_ERROR:
                        return new ResultReq(ErpConstants.WS_RESPONSE_CODE.SUCCESS, getLanguageByKey("msg.error.invalidInput"));
                    case "101":
                        return new ResultReq(result.getCode(), getLanguageByKey("catConstrDesignItem.error.name"));
                    case "102":
                        return new ResultReq(result.getCode(), getLanguageByKey("catConstrDesignItem.error.code"));
                    case "100":
                        return new ResultReq(result.getCode(), getLanguageByKey("catConstrDesignItem.error.codeDuplicate"));
                    default:
                        return new ResultReq(ErpConstants.WS_RESPONSE_CODE.UNKNOW_ERROR_CODE, getLanguageByKey("msg.error.unknow"));
                }
                //                boolean isValid = checkInsertConstraint(catws,form);// checkInsertConstraint(catws, form);
//                if (isValid) {
//                    Long returnValue = catws.save(form);
//                    if (returnValue > 0) {
//                        ret = new ResultReq("SUCCESS", getLanguageByKey("msg.insert.success"));
//                    } else {
//                        ret = new ResultReq("FAIL", "msg.insert.fail");
//                    }
//                } else {
//                    ret = new ResultReq("FAIL", "msg.insert.fail");
//                }
            } else {
                //trường hợp update
//                //validate form
//                //Check form name:
//                
//                if(form.getCatConstrDesignItemCode()==null||"".equals(form.getCatConstrDesignItemName().trim())){
//                    ret = new ResultReq("FAIL", getLanguageByKey("msg.update.input.eroor"));
//                    return ret;
//                }
                //lay ban ghi tu db
                ResultDTOWrapper result= catws.updateObject(form);
                if(null != result.getCode())switch (result.getCode()) {
                    case ErpConstants.WS_RESPONSE_CODE.SUCCESS://case thanh cong                        
                        return new ResultReq(ErpConstants.WS_RESPONSE_CODE.SUCCESS, getLanguageByKey("msg.update.success"));
                    case ErpConstants.WS_RESPONSE_CODE.INPUT_ERROR:
                        return new ResultReq(ErpConstants.WS_RESPONSE_CODE.SUCCESS, getLanguageByKey("msg.error.invalidInput"));
                    case "101":
                        return new ResultReq(result.getCode(), getLanguageByKey("catConstrDesignItem.error.name"));
                    case "103":
                        return new ResultReq(result.getCode(), getLanguageByKey("catConstrDesignItem.error.type"));
                    default:
                        return new ResultReq(ErpConstants.WS_RESPONSE_CODE.SUCCESS, getLanguageByKey("catConstrDesignItem.error.codeDuplicate"));
                }
                
                  
//                CatConstrDesignItemDTO dto = (CatConstrDesignItemDTO) catws.getOneById(form.getCatConstrDesignItemId());
//                if (dto.getIsActive() > 0) {
//                    dto.setDescription(form.getDescription());
//                    dto.setConstructType(form.getConstructType());
//                    dto.setCatConstrDesignItemName(form.getCatConstrDesignItemName());
//
//                    Long returnValue = catws.update(dto);
//
//                    if (returnValue > 0) {
//                        ret = new ResultReq("SUCCESS", getLanguageByKey("msg.update.success"));
//                    } else {
//                        ret = new ResultReq("FAIL", getLanguageByKey("msg.update.fail"));
//                    }
//                } else {                    
//                    ret = new ResultReq("FAIL", getLanguageByKey("msg.update.fail"));
//                }
//                
            }
        } catch (Exception ex) {
            logger.error(ex);
            ret = new ResultReq("FAIL", "ERROR");
        }
        return ret;
    }

    @RequestMapping(value = {"constructionDesignItem/delete/{id}"}, method = RequestMethod.DELETE)
    public @ResponseBody
    ResultReq removeConstrDesignItem(@PathVariable("id") int id) {
        ResultReq ret = null;
        try {
            CatConstrDesignItemWS catws = CxfWsClientFactory.createWsClient(CatConstrDesignItemWS.class);
            CatConstrDesignItemDTO form=new CatConstrDesignItemDTO();
            form.setCatConstrDesignItemId((long)id);
             ResultDTOWrapper result= catws.deleteObject(form);
             
             if(null != result.getCode())switch (result.getCode()) {
                    case ErpConstants.WS_RESPONSE_CODE.SUCCESS://case thanh cong                        
                        return new ResultReq(ErpConstants.WS_RESPONSE_CODE.SUCCESS, getLanguageByKey("msg.delete.success"));
                    case ErpConstants.WS_RESPONSE_CODE.INPUT_ERROR:
                        return new ResultReq(ErpConstants.WS_RESPONSE_CODE.SUCCESS, getLanguageByKey("msg.error.invalidInput"));
                    default:
                        return new ResultReq(ErpConstants.WS_RESPONSE_CODE.SUCCESS, getLanguageByKey("catConstrDesignItem.error.codeDuplicate"));
                }
//            CatConstrDesignItemDTO dto = (CatConstrDesignItemDTO) catws.getOneById((long) id);
//            if (dto != null && dto.getIsActive() == 1) {
//                dto.setIsActive(0l);
//                Long returnValue = catws.update(dto);
//                if (returnValue > 0) {
//                    ret = new ResultReq("SUCCESS", getLanguageByKey("msg.delete.success"));
//                } else {
//                    ret = new ResultReq("FAIL", "msg.delete.fail");
//                }
//            }

        } catch (Exception ex) {
            logger.error(ex);
            ret = new ResultReq("FAIL", "ERROR");
        }
        return ret;
    }

    private boolean checkInsertConstraint(CatConstrDesignItemWS catws, CatConstrDesignItemDTO form) throws Exception {
        if (form == null) {
            return false;
        }
        if (form.getConstructType() <= 0) {
            return false;
        }
        if (form.getCatConstrDesignItemName() == null || "".equals(form.getCatConstrDesignItemName().trim())) {
            return false;
        }

        long total = catws.checkConstraint(form).size();
        if (total > 0) {
            return false;
        }
        return true;

    }
}
