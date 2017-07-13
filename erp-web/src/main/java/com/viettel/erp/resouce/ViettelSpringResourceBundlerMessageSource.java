/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.resouce;

import java.util.ResourceBundle;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 *
 * @author hanhls1-local
 */
public class ViettelSpringResourceBundlerMessageSource extends ResourceBundleMessageSource{
    @Override
    protected String   getStringOrNull(ResourceBundle bundle, String key){
        String returnValue=super.getStringOrNull(bundle,key);
//        if(returnValue==null){
//            return key;
//        }
        return returnValue;
        
    }
}
