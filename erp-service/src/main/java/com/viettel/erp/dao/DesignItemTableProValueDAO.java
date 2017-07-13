/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.viettel.erp.dao;

import com.viettel.erp.bo.DesignItemTableProValueBO;
import com.viettel.service.base.dao.BaseFWDAOImpl;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author TruongBX3
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("designItemTableProValueDAO")
public class DesignItemTableProValueDAO extends BaseFWDAOImpl<DesignItemTableProValueBO, Long> {

    public DesignItemTableProValueDAO() {
        this.model = new DesignItemTableProValueBO();
    }

    public DesignItemTableProValueDAO(Session session) {
        this.session = session;
    }
}
