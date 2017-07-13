/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.rest;

import com.viettel.erp.business.CatSelectBoxValueBusinessImpl;
import com.viettel.erp.dto.CatSelectBoxValueDTO;
import com.viettel.service.base.dto.DataListDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HungLQ9
 */
public class CatSelectBoxValueRsServiceImpl implements CatSelectBoxValueRsService {

    protected final Logger log = Logger.getLogger(UserRsService.class);
    @Autowired
    CatSelectBoxValueBusinessImpl catSelectBoxValueBusinessImpl;

    @Override
    public Response getCatSelectBoxValue() {
        List<CatSelectBoxValueDTO> ls = catSelectBoxValueBusinessImpl.getAll();
        if (ls == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            DataListDTO data = new DataListDTO();
            data.setData(ls);
            data.setTotal(ls.size());
            data.setSize(ls.size());
            data.setStart(1);
            return Response.ok(data).build();
        }
    }

    @Override
    public Response getCatSelectBoxValueById(Long id) {
        CatSelectBoxValueDTO obj = (CatSelectBoxValueDTO) catSelectBoxValueBusinessImpl.getOneById(id);
        if (obj == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(obj).build();
        }
    }

    @Override
    public Response updateCatSelectBoxValue(CatSelectBoxValueDTO obj) {
        Long id = catSelectBoxValueBusinessImpl.update(obj);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok().build();
        }

    }

    @Override
    public Response addCatSelectBoxValue(CatSelectBoxValueDTO obj) {
        Long id = catSelectBoxValueBusinessImpl.save(obj);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(Response.Status.CREATED).build();
        }
    }

    @Override
    public Response deleteCatSelectBoxValue(Long id) {
        CatSelectBoxValueDTO obj = (CatSelectBoxValueDTO) catSelectBoxValueBusinessImpl.getOneById(id);
        if (obj == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            catSelectBoxValueBusinessImpl.delete(obj);
            return Response.ok(Response.Status.NO_CONTENT).build();
        }
    }
}
