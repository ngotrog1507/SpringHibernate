package com.viettel.erp.business;
 
import com.viettel.erp.bo.EmployeeBO;
import com.viettel.erp.dao.EmployeeDAO;
import com.viettel.erp.dto.EmployeeDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("employeeBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeBusinessImpl extends BaseFWBusinessImpl<EmployeeDAO,EmployeeDTO, EmployeeBO> implements EmployeeBusiness {

    @Autowired
    private EmployeeDAO employeeDAO;
    

     
    public EmployeeBusinessImpl() {
        tModel = new EmployeeBO();
        tDAO = employeeDAO;
    }

    @Override
    public EmployeeDAO gettDAO() {
        return employeeDAO;
    }

    @Override
    public long count() {
        return employeeDAO.count("EmployeeBO", null);
    }

    

    
}
