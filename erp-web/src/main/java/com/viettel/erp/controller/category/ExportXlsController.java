/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.controller.category;

import com.viettel.erp.base.BaseController;
import com.viettel.erp.bo.ProfitCenterBO;
import com.viettel.erp.common.ErpConstants;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thuannht
 */
@Controller
public class ExportXlsController extends BaseController {

    /**
     * Handle request to download an Excel document
     *
     * @param exportType
     * @return
     */
    @RequestMapping(value = "/downloadExcel/{exportType}", method = RequestMethod.GET)
    public ModelAndView downloadExcel(@PathVariable String exportType) {
        try {
            // create some sample data
            List<ProfitCenterBO> listProfitCenterBOs = createListForTest(ProfitCenterBO.class, 100);
            ModelAndView modelAndView = new ModelAndView("excelView");
            modelAndView.addObject("listProfitCenterBOs", listProfitCenterBOs);
            modelAndView.addObject(ErpConstants.EXPORT, exportType);
            String fileName = "yourFile.xls";
            switch (exportType) {
                case ErpConstants.EXPORT_TYPE.EXPORT_PROFIT_CENTER:
                    fileName = ErpConstants.EXPORT_TYPE.EXPORT_PROFIT_CENTER + ErpConstants.EXT_FILE.XLS;
                    break;
            }
            getResponse().setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            // return a view which will be resolved by an excel view resolver
            return modelAndView;
        } catch (Exception ex) {
            logger.error(ex);
            return errorModel;
        }
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET)
    public ModelAndView export(@PathVariable String exportType, @RequestParam Map<String, String> allRequestParams) {
        try {
            // create some sample data
            ModelAndView modelAndView = new ModelAndView("excelView");
            modelAndView.addObject("param", allRequestParams);
            modelAndView.addObject(ErpConstants.EXPORT, exportType);
            String fileName = "yourFile.xls";
            switch (exportType) {
                case ErpConstants.EXPORT_TYPE.EXPORT_SHIPPING:
                    fileName = ErpConstants.EXPORT_TYPE.EXPORT_SHIPPING + ErpConstants.EXT_FILE.XLS;
                    break;
            }
            getResponse().setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            // return a view which will be resolved by an excel view resolver
            return modelAndView;
        } catch (Exception ex) {
            logger.error(ex);
            return errorModel;
        }
    }

}
