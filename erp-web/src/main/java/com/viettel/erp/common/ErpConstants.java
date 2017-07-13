/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.common;

/**
 *
 * @author thuannht
 */
public class ErpConstants {

    public static final String EXPORT = "exportType";

    public static class EXPORT_TYPE {

        public static final String EXPORT_PROFIT_CENTER = "profitCenter";
        public static final String EXPORT_SHIPPING = "shipping";
    }

    public static class EXT_FILE {

        public static final String XLS = ".xls";
    }
    
    public static class WS_RESPONSE_CODE{
        public static final String SUCCESS="200";
        public static final String INPUT_ERROR="001";
        public static final String UNKNOW_ERROR_CODE="500";
    }
}
