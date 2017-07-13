package com.viettel.erp.business;
 
import com.viettel.erp.bo.CatConstrDesignItemBO;
import com.viettel.erp.dao.CatConstrDesignItemDAO;
import com.viettel.erp.dto.CatConstrDesignItemDTO;
import com.viettel.service.base.business.BaseFWBusinessImpl;
import com.viettel.service.base.utils.StringUtils;
import com.viettel.service.dto.wrapper.ResultDTOWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service("catConstrDesignItemBusinessImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CatConstrDesignItemBusinessImpl extends BaseFWBusinessImpl<CatConstrDesignItemDAO,CatConstrDesignItemDTO, CatConstrDesignItemBO> implements CatConstrDesignItemBusiness {

    @Autowired
    private CatConstrDesignItemDAO catConstrDesignItemDAO;
    

     
    public CatConstrDesignItemBusinessImpl() {
        tModel = new CatConstrDesignItemBO();
        tDAO = catConstrDesignItemDAO;
    }

    @Override
    public CatConstrDesignItemDAO gettDAO() {
        return catConstrDesignItemDAO;
    }

    @Override
    public long count() {
        return catConstrDesignItemDAO.count("CatConstrDesignItemBO", null);
    }

    public List<CatConstrDesignItemDTO> searchByForm(CatConstrDesignItemDTO designItemForm, int startIndex, int maxResult) throws Exception {
        return catConstrDesignItemDAO.searchByForm(designItemForm,startIndex,maxResult);
     }

    public List<CatConstrDesignItemDTO> checkConstraint(CatConstrDesignItemDTO form) {
         return catConstrDesignItemDAO.checkConstraint(form);
    }

    public long countByForm(CatConstrDesignItemDTO form) {
        return catConstrDesignItemDAO.countByForm(form);
    }

    public ResultDTOWrapper<Long> saveObject(CatConstrDesignItemDTO costCenterBO) {
        ResultDTOWrapper<Long> result = new ResultDTOWrapper<>();
        if (costCenterBO == null) {
            result.setCode("001");//001: input invalid        
            return result;
        } else if (StringUtils.isNullOrEmpty(costCenterBO.getCatConstrDesignItemName())) {
            result.setCode("101");//ten rong    
             return result;
        } else if (StringUtils.isNullOrEmpty(costCenterBO.getCatConstrDesignItemCode())  ||costCenterBO.getCatConstrDesignItemName().trim().contains(" ") ) {
            result.setCode("102");//code  rong hoac co ky tu rong     
             return result;
        } //kiem tra 
        else if (checkConstraint(costCenterBO).size() > 0l) {
            result.setCode("100");//01: trung ma code
            return result;
        }
        Long id = catConstrDesignItemDAO.saveObject(costCenterBO.toModel());
        result.setCode("200");
        result.setData(id);
        return result;

    }

    public ResultDTOWrapper<Long> updateObject(CatConstrDesignItemDTO costCenterBO) {
        ResultDTOWrapper<Long> result = new ResultDTOWrapper<>();
        if (costCenterBO == null || costCenterBO.getCatConstrDesignItemId() == null || costCenterBO.getCatConstrDesignItemId() < 1) {
            result.setCode("001");//001: input invalid      
            return result;
        } else if (StringUtils.isNullOrEmpty(costCenterBO.getCatConstrDesignItemName())) {
            return result;
        }

        CatConstrDesignItemBO bo=catConstrDesignItemDAO.get(CatConstrDesignItemBO.class,costCenterBO.getCatConstrDesignItemId());
        if (bo.getIsActive() != 1) {
            result.setCode("001");//001: input invalid      
            return result;
        }
        bo.setCatConstrDesignItemName(costCenterBO.getCatConstrDesignItemName());
        bo.setDescription(costCenterBO.getDescription());
        bo.setConstructType(costCenterBO.getConstructType());
        Long id = catConstrDesignItemDAO.updateObject(bo);
        result.setCode("200");
        result.setData(id);
        return result;

    }

    public ResultDTOWrapper<Long> deleteObject(CatConstrDesignItemDTO costCenterBO) {
        ResultDTOWrapper<Long> result = new ResultDTOWrapper<>();
        if (costCenterBO == null || costCenterBO.getCatConstrDesignItemId() == null || costCenterBO.getCatConstrDesignItemId() < 1) {
            result.setCode("001");//001: input invalid      
            return result;
        }
        CatConstrDesignItemBO bo = catConstrDesignItemDAO.get(CatConstrDesignItemBO.class,costCenterBO.getCatConstrDesignItemId());
        if (bo.getIsActive() != 1l) {
            result.setCode("001");//001: input invalid      
            return result;
        }
        bo.setIsActive(0l);
        Long id = catConstrDesignItemDAO.updateObject(bo);
        result.setCode("200");
        result.setData(id);
        return result;

    }
    
}
