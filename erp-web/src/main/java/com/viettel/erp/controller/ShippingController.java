/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.controller;

import com.viettel.base.grid.JsonDataGrid;
import com.viettel.erp.base.BaseController;
import com.viettel.erp.bo.ShippingBO;
import com.viettel.erp.form.FilterForm;
import com.viettel.erp.form.ShippingForm;
import com.viettel.erp.form.SortForm;
import com.viettel.erp.service.ShippingService;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author HungLQ9
 */
@Controller
public class ShippingController extends BaseController {

    private ShippingService service;

    @Autowired(required = true)
    @Qualifier(value = "shippingService")
    public void setShippingService(ShippingService service) {
        this.service = service;
    }

    @RequestMapping(value = "/shipping", method = RequestMethod.GET)
    public String viewFirstPage(Model model) {
        return "shipping";
    }

    @RequestMapping(value = {"/shipping/list"}, method = RequestMethod.GET)
    public @ResponseBody
    JsonDataGrid list(@RequestParam Map<String, String> allRequestParams, ShippingForm form) {
        JsonDataGrid dataGrid = new JsonDataGrid();
        try {
            System.out.println(form.getSortdatafield() + " " + form.getSortorder());
            System.out.println(allRequestParams.size());
            for (Map.Entry<String, String> entry : allRequestParams.entrySet()) {
                System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            }

            FilterForm filForm = form.getFilterForm();
            // implement sort, filter in service
            List<ShippingBO> lst = service.listShipping(form);
            List<ShippingBO> lstRet = lst;
            if (!lst.isEmpty()) {
                // pagination
                int curPage = form.getPagenum() + 1;
                int rPP = form.getPagesize();
                // 
                int from = (curPage - 1) * rPP;
                int to = curPage * rPP;
                if (to > lst.size() - 1) {
                    to = lst.size() - 1;
                }
                lstRet = lst.subList(from, to);
            }
            dataGrid.setCurPage(form.getPagenum() + 1);
            dataGrid.setTotalRecords(lst.size());
            dataGrid.setData(lstRet);
        } catch (Exception ex) {
            logger.error(ex);
            return null;
        }
        return dataGrid;
    }

}
