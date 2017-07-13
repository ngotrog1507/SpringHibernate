/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.viettel.erp.dao;

import com.viettel.erp.bo.CatValueTypeBO;
import com.viettel.service.base.dao.BaseFWDAOImpl;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author TruongBX3
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("catValueTypeDAO")
public class CatValueTypeDAO extends BaseFWDAOImpl<CatValueTypeBO, Long> {

    public CatValueTypeDAO() {
        this.model = new CatValueTypeBO();
    }

    public CatValueTypeDAO(Session session) {
        this.session = session;
    }
}
