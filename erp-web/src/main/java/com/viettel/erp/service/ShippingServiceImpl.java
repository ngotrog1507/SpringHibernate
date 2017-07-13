/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.service;

import com.viettel.erp.bo.ShippingBO;
import com.viettel.erp.form.ShippingForm;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author HungLQ9
 */
@Service("shippingService")
public class ShippingServiceImpl implements ShippingService {

    private static final Logger logger = Logger.getLogger(ShippingServiceImpl.class);
    private static final AtomicInteger counter = new AtomicInteger();

    private static final List<ShippingBO> ship = new ArrayList<>();
    private static final List<String> shipCountries = new ArrayList<>();
    private static final List<String> name = new ArrayList<>();
    private static final List<String> shipRegion = new ArrayList<>();
    private static final List<String> shipVia = new ArrayList<>();

    static {
        // 
        shipCountries.add("Germany");
        shipCountries.add("France");
        shipCountries.add("Vietnam");
        shipCountries.add("Brasil");
        shipCountries.add("Sweden");
        shipCountries.add("Finland");
        shipCountries.add("Austria");
        shipCountries.add("USA");
        shipCountries.add("China");
        //
        shipRegion.add("Muchen");
        shipRegion.add("Paris");
        shipRegion.add("Rio");
        shipRegion.add("Cali");
        shipRegion.add("Hongkong");
        shipRegion.add("Stockholm");
        shipRegion.add("Vien");
        shipRegion.add("Hanoi");
        // 
        name.add("Obama");
        name.add("Michael");
        name.add("Jack");
        name.add("Rose");
        name.add("Brad");
        name.add("Wolverin");
        name.add("Jean");
        //
        shipVia.add("Federal Shipping");
        shipVia.add("United Package");
        shipVia.add("Speedy Express");

        for (int i = 0; i < 1000; i++) {
            ship.add(new ShippingBO(getRandomInList(shipCountries),// shippingCountry
                    getRandomInList(name), //contactName
                    getRandomInt(1000, 2000), // orderId
                    getRandomDate(2014, 2016), //orderDate
                    getRandomDate(2014, 2016), // requiredDate
                    getRandomDate(2014, 2016), // shippingDate
                    getRandomInList(shipVia), //shipVia
                    getRandomDouble(1000, 2000), //freight
                    getRandomInList(name), //shipName
                    getRandomInList(shipRegion) + ", " + getRandomInList(shipCountries), //shipAddress
                    getRandomInList(shipRegion), // shipCity
                    getRandomInList(shipRegion), //shipRegion
                    getRandomInt(100000, 999999) + "")); //shipPostalCode
        }
    }

    private static String getRandomInList(List<String> list) {
        int index = ThreadLocalRandom.current().nextInt(list.size());
        return list.get(index);
    }

    private static Date getRandomDate(int startYear, int endYear) {
        GregorianCalendar gc = new GregorianCalendar();
        int year = getRandomInt(startYear, endYear);
        gc.set(gc.YEAR, year);
        int dayOfYear = getRandomInt(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.getTime();

    }

    private static int getRandomInt(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static Double getRandomDouble(int start, int end) {
        Random r = new Random();
        double randomValue = start + (end - start) * r.nextDouble();
        return randomValue;
    }

    @Override
    public List<ShippingBO> listShipping(ShippingForm s) {
        return ship;
    }

}
