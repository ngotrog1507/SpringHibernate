/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.ktts.web.utils;

import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author hanhls1-local
 */
public class KttsDateUtils {
    public static XMLGregorianCalendar getXMLGregorianCalendar(){
        try {
            GregorianCalendar gcal = new GregorianCalendar();
            XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            return xgcal;
        } catch (DatatypeConfigurationException ex) {
            return null;
        }
    }
}
