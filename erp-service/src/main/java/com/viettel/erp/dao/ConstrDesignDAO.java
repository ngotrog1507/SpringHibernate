/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.viettel.erp.dao;

import com.viettel.erp.bo.ConstrDesignBO;
import com.viettel.erp.bo.DesignItemBO;
import com.viettel.erp.dto.ConstrDesignDTO;
import com.viettel.erp.dto.ConstrDesignExtDTO;
import com.viettel.erp.dto.DesignItemDTO;
import com.viettel.erp.dto.DesignItemExtDTO;
import com.viettel.service.base.dao.BaseFWDAOImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 * @author TruongBX3
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("constrDesignDAO")
public class ConstrDesignDAO extends BaseFWDAOImpl<ConstrDesignBO, Long> {

    public ConstrDesignDAO() {
        this.model = new ConstrDesignBO();
    }

    public ConstrDesignDAO(Session session) {
        this.session = session;
    }

    public List<ConstrDesignDTO> getAllConstrDesignExt() {
        try {
            String sql = " SELECT cs.*,di.* FROM CONSTR_DESIGN cs "
                    + "INNER JOIN DESIGN_ITEM di on cs.constr_design_id=di.construction_design_id";

            Query query = getSession().createSQLQuery(sql)
                    .addEntity(ConstrDesignBO.class)
                    .addEntity(DesignItemBO.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//           SQLQuery query2=new SQLQuery();
//           query2.addJoin("cs", "di",)

                   //.setR(Transformers.aliasToBean(ConstrDesignExtDTO.class));
//           query.addRoot("cs", D.class);
//           query.addFetch("di", "cs", "designItems");
            List<java.util.Map> yourList = query.list();
            Map<Long, ConstrDesignDTO> map = new HashMap<Long, ConstrDesignDTO>();
            yourList.stream().forEach((row) -> {
                //value of ConstrDessign
                ConstrDesignBO cd = (ConstrDesignBO) row.get("ConstrDesignBO");
                ConstrDesignDTO tempCd = null;

                DesignItemBO diBo = (DesignItemBO) row.get("DesignItemBO");

                DesignItemDTO tempdiExt = null;

                if (map.containsKey(cd.getConstrDesignId())) {
                    tempCd = map.get(cd.getConstrDesignId());
                } else {
                    tempCd = cd.toDTO();
                    map.put(cd.getConstrDesignId(), tempCd);
                }
                if (tempCd.containKey(diBo.getCatDesignItemId())) {
                    tempdiExt = tempCd.getDesignItemExt(diBo.getCatDesignItemId());
                } else {
                    tempdiExt = diBo.toDTO();
                    tempCd.addDesignItemDTO(tempdiExt);
                }

                //with key as alias and property as value
            });
            return new java.util.ArrayList<>(map.values());
//           List list = query.list();
//           return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
