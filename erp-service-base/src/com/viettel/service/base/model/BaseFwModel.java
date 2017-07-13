/*
* Copyright (C) 2012 Viettel Telecom. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.viettel.service.base.model;

import com.viettel.service.base.dto.BaseFWDTOImpl;

/**
*
* @author kdvt_binhnt22@viettel.com.vn
* @version 1.0
* @since May 2012
*/
public interface BaseFwModel<TDTO extends BaseFWDTOImpl> extends java.io.Serializable {
    public TDTO toDTO();
}
