/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.rest;

import com.viettel.erp.business.DesignItemPropertyBusinessImpl;
import com.viettel.erp.dto.DesignItemPropertyDTO;
import com.viettel.service.base.dto.DataListDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HungLQ9
 */
public class DesignItemPropertyRsServiceImpl implements DesignItemPropertyRsService {

    protected final Logger log = Logger.getLogger(UserRsService.class);
    @Autowired
    DesignItemPropertyBusinessImpl designItemPropertyBusinessImpl;

    @Override
    public Response getDesignItemProperty() {
        List<DesignItemPropertyDTO> ls = designItemPropertyBusinessImpl.getAll();
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
    public Response getDesignItemPropertyById(Long id) {
        DesignItemPropertyDTO obj = (DesignItemPropertyDTO) designItemPropertyBusinessImpl.getOneById(id);
        if (obj == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(obj).build();
        }
    }

    @Override
    public Response updateDesignItemProperty(DesignItemPropertyDTO obj) {
        Long id = designItemPropertyBusinessImpl.update(obj);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok().build();
        }

    }

    @Override
    public Response addDesignItemProperty(DesignItemPropertyDTO obj) {
        Long id = designItemPropertyBusinessImpl.save(obj);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(Response.Status.CREATED).build();
        }
    }

    @Override
    public Response deleteDesignItemProperty(Long id) {
        DesignItemPropertyDTO obj = (DesignItemPropertyDTO) designItemPropertyBusinessImpl.getOneById(id);
        if (obj == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            designItemPropertyBusinessImpl.delete(obj);
            return Response.ok(Response.Status.NO_CONTENT).build();
        }
    }
}
