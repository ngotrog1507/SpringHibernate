/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.rest;

import com.viettel.erp.business.CatConstrDesignItemBusinessImpl;
import com.viettel.erp.dto.CatConstrDesignItemDTO;
import com.viettel.service.base.dto.DataListDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HungLQ9
 */
public class CatConstrDesignItemRsServiceImpl implements CatConstrDesignItemRsService {

    protected final Logger log = Logger.getLogger(UserRsService.class);
    @Autowired
    CatConstrDesignItemBusinessImpl catConstrDesignItemBusinessImpl;

    @Override
    public Response getCatConstrDesignItem() {
        List<CatConstrDesignItemDTO> ls = catConstrDesignItemBusinessImpl.getAll();
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
    public Response getCatConstrDesignItemById(Long id) {
        CatConstrDesignItemDTO obj = (CatConstrDesignItemDTO) catConstrDesignItemBusinessImpl.getOneById(id);
        if (obj == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(obj).build();
        }
    }

    @Override
    public Response updateCatConstrDesignItem(CatConstrDesignItemDTO obj) {
        Long id = catConstrDesignItemBusinessImpl.update(obj);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok().build();
        }

    }

    @Override
    public Response addCatConstrDesignItem(CatConstrDesignItemDTO obj) {
        Long id = catConstrDesignItemBusinessImpl.save(obj);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(Response.Status.CREATED).build();
        }
    }

    @Override
    public Response deleteCatConstrDesignItem(Long id) {
        CatConstrDesignItemDTO obj = (CatConstrDesignItemDTO) catConstrDesignItemBusinessImpl.getOneById(id);
        if (obj == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            catConstrDesignItemBusinessImpl.delete(obj);
            return Response.ok(Response.Status.NO_CONTENT).build();
        }
    }
}
