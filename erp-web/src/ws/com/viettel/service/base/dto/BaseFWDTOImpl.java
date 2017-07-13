/*
 * Copyright (C) 2012 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.viettel.service.base.dto;

import com.viettel.service.base.model.BaseFWModelImpl;
import java.io.Serializable;

/**
 *
 * @author kdvt_binhnt22@viettel.com.vn
 * @version 1.0
 * @param <TBO>
 * @since May 2012
 */
public abstract class BaseFWDTOImpl implements  Serializable {

    protected String defaultSortField = "name";

    public String getDefaultSortField() {
        return defaultSortField;
    }

    public void setDefaultSortField(String defaultSortField) {
        this.defaultSortField = defaultSortField;
    }

 

}
