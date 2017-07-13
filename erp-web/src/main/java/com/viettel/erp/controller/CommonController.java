/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.controller;

import com.viettel.erp.base.BaseController;
import com.viettel.erp.dto.UtilAttachedDocumentsDTO;
import com.viettel.erp.webservice.CategoryWS;
import com.viettel.ktts.web.utils.KttsDateUtils;
import com.viettel.ktts.web.utils.KttsFileUtils;
//import com.viettel.service.ktts.CategoryWS;
//import com.viettel.service.ktts.UtilAttachedDocumentsDTO;
import com.viettel.util.Base64Utils;
import com.viettel.util.FileUtils;
import com.viettel.util.ResourceBundleUtils;
import com.viettel.ws.consumer.base.CxfRsClientFactory;
import com.viettel.ws.consumer.base.CxfWsClientFactory;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author hanhls1-local
 */
@Controller
public class CommonController extends BaseController {

    @RequestMapping(method = RequestMethod.POST, value = {"/upload"})
    public @ResponseBody
    UtilAttachedDocumentsDTO handleFileUpload(@RequestParam("file") MultipartFile uploadFile) {
        try {
            String pathToUpload = getConfigByKey("path_to_upload");
            String pathToFolderUpload = getConfigByKey("folder_upload");            

            String uploadPath = pathToFolderUpload + File.separator + pathToUpload;
            Calendar cal = Calendar.getInstance();
            uploadPath += File.separator
                    + cal.get(Calendar.YEAR) + File.separator + (cal.get(Calendar.MONTH) + 1) + File.separator
                    + cal.get(Calendar.DATE) + File.separator + cal.get(Calendar.MILLISECOND);
            File upDir = null;
            upDir = new File(uploadPath);
            if (!upDir.exists()) {
                upDir.mkdirs();
            }

            String encodeFileName = Base64Utils.encodeBytes(KttsFileUtils.extractFileNameNotExt(uploadFile.getName()).getBytes()) + KttsFileUtils.extractFileExt(
                    uploadFile.getName());

            KttsFileUtils.saveFile(uploadFile, encodeFileName, upDir);
            CategoryWS categoryWs=CxfWsClientFactory.createWsClient(CategoryWS.class);
            UtilAttachedDocumentsDTO dto=new UtilAttachedDocumentsDTO();
            dto.setDocumentPath(uploadPath.substring(uploadPath.indexOf(
                        pathToUpload)) + File.separator + encodeFileName);
            dto.setDocumentName(uploadFile.getName());
            dto.setType(0l);
            dto.setParentId(0l);
            dto.setCreatedDate(Calendar.getInstance().getTime());
            
            Long returnValue=categoryWs.saveAttachment(dto);
            dto.setAttachId(returnValue);
            return dto;
        } catch (Exception ex) {
            logger.error(ex);            
        }
        return null;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = {"/downloadFile"})
    public void downloadFile(Long id) {
        try{
             CategoryWS categoryWs=CxfWsClientFactory.createWsClient(CategoryWS.class); 
             //categoryWs.getAttachmentById(id);
        } catch (Exception ex) {
            logger.error(ex);            
        }
        return ;
    }

}
