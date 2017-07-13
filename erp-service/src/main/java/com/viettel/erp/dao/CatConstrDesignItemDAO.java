/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.viettel.erp.dao;

import com.viettel.erp.bo.CatConstrDesignItemBO;
import com.viettel.erp.dto.CatConstrDesignItemDTO;
import com.viettel.service.base.dao.BaseFWDAOImpl;
import com.viettel.service.base.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author TruongBX3
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("catConstrDesignItemDAO")
public class CatConstrDesignItemDAO extends BaseFWDAOImpl<CatConstrDesignItemBO, Long> {

    public CatConstrDesignItemDAO() {
        this.model = new CatConstrDesignItemBO();
    }

    public CatConstrDesignItemDAO(Session session) {
        this.session = session;
    }
    public List<CatConstrDesignItemDTO> searchByForm(CatConstrDesignItemDTO designItemForm,int startIndex,int maxResult) throws Exception {
        List<CatConstrDesignItemDTO> result=new ArrayList<>();
        List<CatConstrDesignItemBO> queryResult=null;
        StringBuilder hqlBuilder = new StringBuilder("From CatConstrDesignItemBO cat where cat.isActive=1 ");
        List<Object> params = new ArrayList<>();
        Map<String,Object> mapParam=new HashMap<>();
        if (designItemForm != null) {
            if (!StringUtils.isNullOrEmpty(designItemForm.getCatConstrDesignItemName())) {
                hqlBuilder.append(" and cat.catConstrDesignItemName like :catConstrDesignItemName ");
                mapParam.put("catConstrDesignItemName","%" + designItemForm.getCatConstrDesignItemName().trim() + "%");
//                params.add("%" + designItemForm.getCatConstrDesignItemName().trim() + "%");
            }
            if (!StringUtils.isNullOrEmpty(designItemForm.getCatConstrDesignItemCode())) {
                hqlBuilder.append(" and cat.catConstrDesignItemCode like :catConstrDesignItemCode ");
                mapParam.put("catConstrDesignItemCode","%" + designItemForm.getCatConstrDesignItemCode().trim() + "%");
//                params.add("%" + designItemForm.getCatConstrDesignItemCode().trim() + "%");
            }
            if (designItemForm.getConstructType() != null && designItemForm.getConstructType() > 0) {
                hqlBuilder.append(" and cat.constructType = :constructType ");
                mapParam.put("constructType",designItemForm.getConstructType());
                params.add(designItemForm.getConstructType());
            }
        }
         Query query = getSession().createQuery(hqlBuilder.toString());
         for(String key:mapParam.keySet()){
             query.setParameter(key, mapParam.get(key));
         }
         if(maxResult!=0){
                query.setFirstResult(startIndex);
                query.setMaxResults(maxResult);
         }
        queryResult= query.list();
        for( CatConstrDesignItemBO bo:queryResult){
            if(bo!=null){
                result.add(bo.toDTO());
            }
        }
        return result;
    }

    public List<CatConstrDesignItemDTO> checkConstraint(CatConstrDesignItemDTO designItemForm) {
        List<CatConstrDesignItemDTO> result=new ArrayList<>();
         List<CatConstrDesignItemBO> queryResult=null;
        StringBuilder hqlBuilder = new StringBuilder("From CatConstrDesignItemBO cat where cat.isActive=1 ");
        Map<String,Object> mapParam=new HashMap<>();
        if (designItemForm != null) {
            if (!StringUtils.isNullOrEmpty(designItemForm.getCatConstrDesignItemCode())) {
                hqlBuilder.append(" and cat.catConstrDesignItemCode = :catConstrDesignItemCode ");
                mapParam.put("catConstrDesignItemCode",  designItemForm.getCatConstrDesignItemCode().trim() );
            }
        }
        Query query = getSession().createQuery(hqlBuilder.toString());
        for (String key:mapParam.keySet()) {
            query.setParameter(key, mapParam.get(key));
        }

        query.setMaxResults(1);
        queryResult = query.list();
        for( CatConstrDesignItemBO bo:queryResult){
            if(bo!=null){
                result.add(bo.toDTO());
            }
        }
        return result;
    }

    public long countByForm(CatConstrDesignItemDTO designItemForm) {
        long result = 0l;
        StringBuilder hqlBuilder = new StringBuilder("select count(*) From CatConstrDesignItemBO cat where cat.isActive=1 ");
        
        Map<String,Object> mapParam=new HashMap<>();
        if (designItemForm != null) {
            if (!StringUtils.isNullOrEmpty(designItemForm.getCatConstrDesignItemName())) {
                hqlBuilder.append(" and cat.catConstrDesignItemName like :catConstrDesignItemName ");
                mapParam.put("catConstrDesignItemName", "%" + designItemForm.getCatConstrDesignItemName().trim() + "%");
//                params.add("%" + designItemForm.getCatConstrDesignItemName().trim() + "%");
            }
            if (!StringUtils.isNullOrEmpty(designItemForm.getCatConstrDesignItemCode())) {
                hqlBuilder.append(" and cat.catConstrDesignItemCode like :catConstrDesignItemCode ");
                mapParam.put("catConstrDesignItemCode", "%" + designItemForm.getCatConstrDesignItemCode().trim() + "%");
            }
            if (designItemForm.getConstructType() != null && designItemForm.getConstructType() > 0) {
                hqlBuilder.append(" and cat.constructType = :constructType ");
                mapParam.put("constructType",designItemForm.getConstructType());
            }
        }
        Query query = getSession().createQuery(hqlBuilder.toString());
         for (String key:mapParam.keySet()) {
            query.setParameter(key, mapParam.get(key));
        }
        result = (Long) query.list().get(0);
        return result;
    }
}
