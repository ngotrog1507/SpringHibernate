/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.controller;

import com.viettel.base.grid.JsonDataGrid;
import com.viettel.erp.base.BaseController;
import com.viettel.erp.bo.Person;
import com.viettel.erp.bo.PersonWrap;
import com.viettel.erp.form.PersonForm;
import com.viettel.erp.form.ResultReq;
import com.viettel.erp.service.PersonService;
//import com.viettel.service.ChiaoWS;
import com.viettel.ws.consumer.base.CxfWsClientFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author HungLQ9
 */
@Controller
public class PersonController extends BaseController {

    private PersonService personService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService ps) {
        this.personService = ps;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("personSearch", new PersonForm());

        return "person";
    }

    //For add and update person both
    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public @ResponseBody
    ResultReq addPerson(@ModelAttribute("person") Person p) {
        ResultReq ret = null;
        if (p.getId() == 0) {
            if (personService.isUserExist(p)) {
                System.out.println("A User with name " + p.getName() + " already exist");
                ret = new ResultReq("DUBLICATE", "A User with name " + p.getName() + " already exist");
                return ret;
            }
            //new person, add it

            this.personService.addPerson(p);
            ret = new ResultReq("SUCCESS", "Create person sucessfull");
        } else {
            //existing person, call update
            this.personService.updatePerson(p);
            ret = new ResultReq("SUCCESS", "Update person sucessfull");
        }
        return ret;

    }

    @RequestMapping(value = {"/person"}, method = RequestMethod.GET)
    public @ResponseBody
    JsonDataGrid listPersons(@ModelAttribute("person") PersonForm p) {
        try {
            //
//            ChiaoWS helloService = CxfWsClientFactory.createWsClient(ChiaoWS.class);
//            System.out.println(helloService.chiao("hunglq9"));
            //
            
            JsonDataGrid dataGrid = new JsonDataGrid();
            List<Person> lst = personService.listPersons(p);
            List<Person> lstRet = lst;
            if (!lst.isEmpty()) {
                // pagination
                int curPage =  p.getPagenum();
                int rPP = p.getPagesize();
                // 
                int from = curPage * rPP;
                int to = (curPage+ 1) * rPP;
                if (to > lst.size() - 1) {
                    to = lst.size() - 1;
                }
                lstRet = lst.subList(from, to);
            }
            dataGrid.setCurPage(getCurrentPage());
            dataGrid.setTotalRecords(lst.size());
            dataGrid.setData(lstRet);
            return dataGrid;
        } catch (Exception ex) {
            logger.error(ex);
            return null;
        }
    }

    @RequestMapping("/person/{id}")
    public @ResponseBody
    Person getPersonById(@PathVariable("id") int id) {
        return this.personService.getPersonById(id);
    }

    @RequestMapping(value = {"person/{id}"}, method = RequestMethod.DELETE)
    public @ResponseBody
    ResultReq removePerson(@PathVariable("id") int id) {
        ResultReq ret = null;
        this.personService.removePerson(id);
        ret = new ResultReq("SUCESS", "Delete peron sucessfull ");
        return ret;
    }

    @RequestMapping(value = {"/person/delete"}, method = RequestMethod.POST)
    public @ResponseBody
    ResultReq removeMultiPerson(@ModelAttribute("postObj") PersonWrap postObj) {
        ResultReq ret = null;
        if (postObj != null && postObj.getIds() != null && !postObj.getIds().isEmpty()) {
            for (Integer id : postObj.getIds()) {
                this.personService.removePerson(id);
            }
        }
        ret = new ResultReq("SUCESS", "Delete peron sucessfull ");
        return ret;
    }

}
