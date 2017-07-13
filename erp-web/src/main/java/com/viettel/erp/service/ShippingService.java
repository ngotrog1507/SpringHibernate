/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.service;

import com.viettel.erp.bo.ShippingBO;
import com.viettel.erp.form.ShippingForm;
import java.util.List;

/**
 *
 * @author HungLQ9
 */
public interface ShippingService {

   
    public List<ShippingBO> listShipping(ShippingForm s);

   
}
