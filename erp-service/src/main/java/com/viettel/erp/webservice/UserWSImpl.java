///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.viettel.erp.webservice;
//
//import com.viettel.erp.business.UserBusinessImpl;
//import com.viettel.erp.dto.ActIdUserDTO;
//import java.util.List;
//import javax.jws.WebService;
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// *
// * @author hunglq9
// */
//@WebService(endpointInterface = "com.viettel.erp.webservice.UserWS")
//public class UserWSImpl implements UserWS {
//
//    @Autowired
//    UserBusinessImpl userBusinessImpl;
//
//    @Override
//    @Transactional
//    public long getUserCount(String txt) {
//        long l = 10;
//        try {
//            System.out.println("hunglq1");
//            l = userBusinessImpl.getUserCount();
//        } catch (Exception ex) {
//            System.out.println("hunglq2");
//            ex.printStackTrace();
//        }
//        return l;
//    }
//
//    @Override
//    @Transactional
//    public List<ActIdUserDTO> getAllUsers() {
//        return userBusinessImpl.getAll();
//    }
//
//    @Override
//    @Transactional
//    public Integer countWord(String word) {
//        return userBusinessImpl.wordCount(word);
//    }
//}
