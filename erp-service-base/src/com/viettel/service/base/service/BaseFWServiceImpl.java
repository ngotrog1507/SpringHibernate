/*
 * Copyright (C) 2015 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.viettel.service.base.service;

import com.viettel.service.base.dao.BaseFWDAOImpl;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.model.BaseFWModelImpl;
import com.viettel.service.base.pojo.ConditionBean;
import com.viettel.service.base.pojo.ResultDTO;
import com.viettel.service.base.utils.DataUtil;
import com.viettel.util.ParamUtils;
import com.viettel.service.base.utils.ReflectUtils;
import com.viettel.service.base.utils.StringUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author kdvt_binhnt22@viettel.com.vn
 * @version 2.0
 * @since Mar 2015
 */
@Transactional
public class BaseFWServiceImpl<TDAO extends BaseFWDAOImpl, TDTO extends BaseFWDTOImpl, TModel extends BaseFWModelImpl>
        implements BaseFWServiceInterface<TDTO, TModel> {
 

}
