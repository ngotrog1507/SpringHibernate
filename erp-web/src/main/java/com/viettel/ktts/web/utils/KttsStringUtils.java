/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.ktts.web.utils;

/**
 *
 * @author hanhls1-local
 */
public class KttsStringUtils {

    public static boolean isNullOrEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }
}
