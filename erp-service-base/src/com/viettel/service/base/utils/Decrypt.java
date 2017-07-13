/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.service.base.utils;

import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

/**
 *
 * @author hunglq9
 */
public class Decrypt {

    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("123456a@");
        String plainText1 = textEncryptor.encrypt("jdbc:oracle:thin:@//10.58.71.199:1521/dbpmvt7");
        System.out.println(plainText1);
        String plainText2 = textEncryptor.encrypt("pmtc");
        System.out.println(plainText2);
        String plainText3 = textEncryptor.encrypt("pmtc#123");
        System.out.println(plainText3);
    }

}
