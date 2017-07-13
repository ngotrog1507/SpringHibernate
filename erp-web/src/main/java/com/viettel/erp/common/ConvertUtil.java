/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.common;

import com.viettel.base.grid.JsonDataGrid;
import com.viettel.service.base.dto.DataListDTO;

/**
 *
 * @author hanhls1-local
 */
public class ConvertUtil {
    public static JsonDataGrid gridFromDataListDTO(DataListDTO dto,int curPage){
        if(dto==null){
            return null;
        }
        JsonDataGrid grid=new JsonDataGrid();
        grid.setTotalRecords(dto.getTotal());
        grid.setData(dto.getData());
        grid.setCurPage(curPage);        
        return grid;
    }
}
