/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.ignite.base;

import java.lang.reflect.Method;
import org.apache.ignite.lang.IgniteClosure;

/**
 *
 * @author HungLQ9
 */
public class VtIgniteClosure implements IgniteClosure<DataBean, Object> {

    private BusinessBean bizBean;

    public VtIgniteClosure(BusinessBean bizBean) {
        this.bizBean = bizBean;
    }

    @Override
    public Object apply(DataBean e) {
        try {
            Class classObj = Class.forName(bizBean.getClassName());
            Method method = classObj.getDeclaredMethod(bizBean.getMethodName(), bizBean.getMethodParam());
            return method.invoke(classObj.newInstance(), e.getData());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
