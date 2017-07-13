/*
 * Copyright (C) 2011 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.viettel.erp.dao;

import com.viettel.erp.bo.DesignItemTablePropertyBO;
import com.viettel.service.base.dao.BaseFWDAOImpl;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author TruongBX3
 * @version 1.0
 * @since 08-May-15 4:07 PM
 */
@Repository("designItemTablePropertyDAO")
public class DesignItemTablePropertyDAO extends BaseFWDAOImpl<DesignItemTablePropertyBO, Long> {

    public DesignItemTablePropertyDAO() {
        this.model = new DesignItemTablePropertyBO();
    }

    public DesignItemTablePropertyDAO(Session session) {
        this.session = session;
    }
}
