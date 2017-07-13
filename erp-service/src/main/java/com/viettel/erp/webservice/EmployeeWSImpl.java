/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.webservice;

/**
 *
 * @author hunglq9
 */
import com.viettel.erp.business.EmployeeBusinessImpl;
import com.viettel.erp.business.UserBusinessImpl;
import com.viettel.erp.dto.EmployeeDTO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.pojo.ConditionBean;
import com.viettel.service.base.utils.StringUtils;
import com.viettel.util.Stopwatch;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;

@WebService(endpointInterface = "com.viettel.erp.webservice.EmployeeWS")

public class EmployeeWSImpl implements EmployeeWS {

    @Autowired
    EmployeeBusinessImpl employeeImpl;
    @Autowired
    UserBusinessImpl userBusinessImpl;
    Logger logger = Logger.getLogger(EmployeeWSImpl.class);

    @Override
    public long getTotal() throws Exception {
        try {
//            Stopwatch stopwatch = new Stopwatch();
//            //Vi du ve cache
            List lst = employeeImpl.getCacheByKey(ArrayList.class, "lst4");
            if (lst != null) {
                System.out.println(lst);
            } else {
                List<EmployeeDTO> lst2 = getAll();
                lst = new ArrayList();
                for (int i = 0; i < 1000; i++) {                   
                    lst.add(lst2.get(i));
                }
                employeeImpl.setCache("lst4", lst);
            }

            //Test cau query
//            System.out.println(stopwatch.elapsedTime() + "---------------" + lst);
//            List<String> lst = new ArrayList<>();
//            for (int i = 0; i < 100000; i++) {
//                lst.add("Sothu" + i + "  ");
//            }
//            userBusinessImpl.wordCount1(lst);
            return 1;
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<EmployeeDTO> getAll() throws Exception {
        try {
            return employeeImpl.getAll(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public int getLengthOfStr(String str) throws Exception {
        try {
            return str.length(); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public String genRandomStr(int length) throws Exception {
        try {
            Random ran = new Random();
            char data = ' ';
            String dat = "";

            for (int i = 0; i <= length; i++) {
                data = (char) (ran.nextInt(10) + 97);
                dat = data + dat;
            }
            return dat;
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    public EmployeeBusinessImpl getEmployeeBusinessImpl() {
        return employeeImpl;

    }

    public void setEmployeeBusinessImpl(EmployeeBusinessImpl employeeImpl) {
        this.employeeImpl = employeeImpl;
    }

    @Override
    public BaseFWDTOImpl getOneById(Long costCenterId) throws Exception {
        try {
            return this.employeeImpl.getOneById(costCenterId);

        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long save(EmployeeDTO costCenterBO) throws Exception {
        try {
            return this.employeeImpl.save(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void delete(EmployeeDTO costCenterBO) throws Exception {
        try {
            this.employeeImpl.delete(costCenterBO);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<EmployeeDTO> searchByHql(String hql, List<ConditionBean> conditionBeans)
            throws Exception {
        try {
            return this.employeeImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public List<EmployeeDTO> searchByHql(String hql, List<ConditionBean> conditionBeans, int startIdx, int endIdx)
            throws Exception {
        try {
            return this.employeeImpl.searchByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long countByHql(String hql, List<ConditionBean> conditionBeans) throws Exception {
        try {
            return this.employeeImpl.countByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public int executeByHql(String hql, List<ConditionBean> conditionBeans) throws Exception {
        try {
            return this.employeeImpl.executeByHql(hql, conditionBeans);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Date getSysDate() throws Exception {
        try {
            return this.employeeImpl.getSysDate();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

    @Override
    public Long getNextValSequence(String sequense) throws Exception {
        try {
            return this.employeeImpl.getNextValSequence(sequense);
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }

}
