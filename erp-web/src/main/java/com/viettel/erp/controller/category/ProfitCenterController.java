
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.controller.category;

import com.viettel.base.grid.JsonDataGrid;
import com.viettel.erp.base.BaseController;
import com.viettel.erp.base.JsonAutoComplete;
import com.viettel.erp.base.JsonTree;
import com.viettel.erp.bo.ProfitCenterBO;
import com.viettel.erp.form.BaseForm;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thuannht
 */
@Controller
public class ProfitCenterController extends BaseController {

    @RequestMapping(value = {"/profitCenter"}, method = RequestMethod.GET)
    public ModelAndView preparePage() {
        try {
            ModelAndView model = new ModelAndView();
            model.setViewName("constrConsult");
            List<ProfitCenterBO> lst;
            if (getHttpSession().getAttribute("lst") == null) {
                lst = createListForTest(ProfitCenterBO.class, 100);
                getHttpSession().setAttribute("lst", lst);
            }
            return model;
        } catch (Exception ex) {
            logger.error(ex);
            return errorModel;
        }
    }

    @RequestMapping(value = {"/insertProfitCenter"}, method = RequestMethod.POST)
    public ModelAndView insert() {
        try {
            ModelAndView model = new ModelAndView();
            model.setViewName("profitCenter");
            return model;
        } catch (Exception ex) {
            logger.error(ex);
            return errorModel;
        }
    }

    @RequestMapping(value = {"/searchProfitCenter"}, method = RequestMethod.GET)
    public @ResponseBody
    JsonDataGrid search(@ModelAttribute("name") String name, @ModelAttribute BaseForm baseform) {
        try {
//Neu co ws thi goi
//            PassportWS passportWS = this.createWsClient(PassportWS.class); 
            JsonDataGrid dataGrid = new JsonDataGrid();
            List<ProfitCenterBO> lst = createListForTest(ProfitCenterBO.class, getTotalRecordPerPage());
            
            dataGrid.setCurPage(getCurrentPage());
            dataGrid.setTotalRecords(1000000);
            dataGrid.setData(lst);
            return dataGrid;
        } catch (Exception ex) {
                logger.error(ex);
                return null;
        }
    }

    @RequestMapping(value = {"/searchAutoComplete"}, method = RequestMethod.GET)
    public @ResponseBody
    List<JsonAutoComplete> searchAutoComplete() {
        try {
//Neu co ws thi goi
            List<JsonAutoComplete> result = new ArrayList<>();
            List<ProfitCenterBO> lst;
            if (getHttpSession().getAttribute("lst") != null) {
                lst = (List<ProfitCenterBO>) getHttpSession().getAttribute("lst");
            } else {
                lst = createListForTest(ProfitCenterBO.class, 100);
                getHttpSession().setAttribute("lst", lst);
            }
            String q = getParamAutoComplete();
            int maxRow=getParamMaxRowAutoComplete();
            int count=0;
            for (ProfitCenterBO obj : lst) {
                if (!obj.getName().contains(q)) {
                    continue;
                }
                
                JsonAutoComplete complete = new JsonAutoComplete();
                count++;
                complete.setLabel(obj.getName());
                complete.setValue(String.valueOf(count));
                complete.setDesc(obj.getDescription());
                result.add(complete);
                
                if(count==maxRow){
                    break;
                }
            }
            
            return result;
        } catch (Exception ex) {
            logger.error(ex);
            return null;
        }
    }

    @RequestMapping(value = {"/getDataForTree"}, method = RequestMethod.GET)
    public @ResponseBody
    List<JsonTree> getDataForTree() {
        try {
//Neu co ws thi goi
//Lay node cha de load cac node con tuong ung
            String parentValue = getParam(TREE_PARAM);
            List<JsonTree> result = new ArrayList<>();
            List<ProfitCenterBO> lst;
            if (getHttpSession().getAttribute("lst") != null) {
                lst = ((List<ProfitCenterBO>) getHttpSession().getAttribute("lst")).subList(0, 10);
            } else {
                lst = createListForTest(ProfitCenterBO.class, 10);
                getHttpSession().setAttribute("lst", lst);
            }
            for (ProfitCenterBO obj : lst) {
                JsonTree complete = new JsonTree();
                complete.setLabel(obj.getName());
                complete.setValue(obj.getName());
                complete.setExpanded(false);
                result.add(complete);
                //Doan code lam cho node nay khong tu expand
                JsonTree.convert2LazyNode(complete);
            }

            return result;
        } catch (Exception ex) {
            logger.error(ex);
            return null;
        }
    }
}
