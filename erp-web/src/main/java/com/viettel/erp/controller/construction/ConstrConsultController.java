/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.controller.construction;

import com.viettel.base.grid.JsonDataGrid;
import com.viettel.erp.base.BaseController;
import com.viettel.erp.base.JsonSelectBox;
import com.viettel.erp.common.ConvertUtil;
import com.viettel.erp.dto.CatConstrDesignItemDTO;
import com.viettel.erp.dto.CatProvinceGroupDTO;
import com.viettel.erp.webservice.CatConstrDesignItemWS;
import com.viettel.erp.webservice.CategoryWS;
import com.viettel.service.base.dto.DataListDTO;

//import com.viettel.service.ktts.CatProvinceGroupDTO;
//import com.viettel.service.ktts.CategoryWS;

import com.viettel.ws.consumer.base.CxfWsClientFactory;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thuannht
 */
@Controller
public class ConstrConsultController extends BaseController {

    @RequestMapping(value = {"/constrConsult"}, method = RequestMethod.GET)
    public ModelAndView preparePage() {
        try {
            ModelAndView model = new ModelAndView();
            model.setViewName("constrConsult");
            return model;
        } catch (Exception ex) {
            logger.error(ex);
            return errorModel;
        }
    }
  
    
    @RequestMapping(value = {"/selectProvinceGroup"}, method = RequestMethod.GET)
    public @ResponseBody
    List<JsonSelectBox> getProvinceGroups() {
        List<JsonSelectBox> result = new ArrayList<>();

        try {
            //TODO: replace by binding from service
            JsonSelectBox json = new JsonSelectBox();
            CategoryWS catws = CxfWsClientFactory.createWsClient(CategoryWS.class);
            List<CatProvinceGroupDTO> lst = catws.getAllCatProvinceGroupActive();
            json.setValue("-1");
            json.setLabel(getLanguageByKey("label.selectAll"));
            result.add(json);

            for (CatProvinceGroupDTO id : lst) {
                json = new JsonSelectBox();
                json.setValue(id.getCatProvinceGroupId().toString());
                json.setLabel(getLanguageByKey(id.getName()));
                result.add(json);
            }
            return result;
        } catch (Exception ex) {
            logger.error(ex);
            return null;
        }

    }

    @RequestMapping(value = {"/constr/designBTS"}, method = RequestMethod.GET)
    public ModelAndView designBTS() {
        try {
            ModelAndView model = new ModelAndView();
            model.setViewName("designBTS");
            return model;
        } catch (Exception ex) {
            logger.error(ex);
            return errorModel;
        }
    }
    @RequestMapping(value = {"/constr/designHangingTranmission"}, method = RequestMethod.GET)
    public ModelAndView designHangingTranmission() {
        try {
            ModelAndView model = new ModelAndView();
            model.setViewName("designHangingTranmission");
            return model;
        } catch (Exception ex) {
            logger.error(ex);
            return errorModel;
        }
    }
    @RequestMapping(value = {"/constr/designUndergroundTranmission"}, method = RequestMethod.GET)
    public ModelAndView designUndergroundTranmission() {
        try {
            ModelAndView model = new ModelAndView();
            model.setViewName("designUndergroundTranmission");
            return model;
        } catch (Exception ex) {
            logger.error(ex);
            return errorModel;
        }
    }

}
