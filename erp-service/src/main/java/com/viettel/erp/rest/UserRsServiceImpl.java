/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.rest;

import com.viettel.erp.business.UserBusinessImpl;
import com.viettel.erp.dto.ActIdUserDTO;
import com.viettel.service.base.dto.DataListDTO;
import java.util.List;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HungLQ9
 */
public class UserRsServiceImpl implements UserRsService {

    protected final Logger log = Logger.getLogger(UserRsService.class);
    @Autowired
    UserBusinessImpl userBusinessImpl;

    @Override
    public Response getUsers() {
        List<ActIdUserDTO> ls = userBusinessImpl.getAll();
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
    public Response getUserById(Long id) {
        ActIdUserDTO usr = (ActIdUserDTO) userBusinessImpl.getOneById(id);
        if (usr == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(usr).build();
        }
    }

    @Override
    public Response updateUser(ActIdUserDTO user) {
        Long id = userBusinessImpl.update(user);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok().build();
        }

    }

    @Override
    public Response addUser(ActIdUserDTO user) {
        Long id = userBusinessImpl.save(user);
        if (id == 0l) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(Response.Status.CREATED).build();
        }
    }

    @Override
    public Response deleteUser(Long id) {
        ActIdUserDTO usr = (ActIdUserDTO) userBusinessImpl.getOneById(id);
        if (usr == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            userBusinessImpl.delete(usr);
            return Response.ok(Response.Status.NO_CONTENT).build();
        }
    }
}
