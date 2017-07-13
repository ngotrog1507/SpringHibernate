/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.rest;

import com.viettel.erp.business.CatProvinceGroupBusinessImpl;
import com.viettel.erp.dto.CatProvinceGroupDTO;
import com.viettel.service.base.dto.DataListDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HungLQ9
 */
public class CatProvinceGroupRsServiceImpl implements CatProvinceGroupRsService {

    protected final Logger log = Logger.getLogger(UserRsService.class);
    @Autowired
    CatProvinceGroupBusinessImpl catProvinceGroupBusinessImpl;

    @Override
    public Response getCatProvinceGroup() {
        List<CatProvinceGroupDTO> ls = catProvinceGroupBusinessImpl.getAll();
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
    public Response getCatProvinceGroupById(Long id) {
        CatProvinceGroupDTO obj = (CatProvinceGroupDTO) catProvinceGroupBusinessImpl.getOneById(id);
        if (obj == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(obj).build();
        }
    }

    @Override
    public Response updateCatProvinceGroup(CatProvinceGroupDTO obj) {
        Long id = catProvinceGroupBusinessImpl.update(obj);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok().build();
        }

    }

    @Override
    public Response addCatProvinceGroup(CatProvinceGroupDTO obj) {
        Long id = catProvinceGroupBusinessImpl.save(obj);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(Response.Status.CREATED).build();
        }
    }

    @Override
    public Response deleteCatProvinceGroup(Long id) {
        CatProvinceGroupDTO obj = (CatProvinceGroupDTO) catProvinceGroupBusinessImpl.getOneById(id);
        if (obj == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            catProvinceGroupBusinessImpl.delete(obj);
            return Response.ok(Response.Status.NO_CONTENT).build();
        }
    }
}
