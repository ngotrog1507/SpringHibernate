/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.dto;

import com.viettel.erp.bo.UtilAttachedDocumentsBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import com.viettel.service.base.utils.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thuannht
 */
@XmlRootElement(name = "UTIL_ATTACHED_DOCUMENTSBO")
public class UtilAttachedDocumentsDTO extends BaseFWDTOImpl<UtilAttachedDocumentsBO> {

private java.lang.Long attachId;
private java.lang.String documentName;
private java.lang.String documentPath;
private java.lang.Long type;
private java.lang.Long parentId;
private java.util.Date createdDate;
private java.lang.Long levelId;
private java.lang.String signer;
private java.lang.String code;
private java.util.Date signedDate;
private java.lang.String description;
private java.lang.Long userId;
private java.lang.Long fileType;

    @Override
    public UtilAttachedDocumentsBO toModel() {
        UtilAttachedDocumentsBO utilAttachedDocumentsBO = new UtilAttachedDocumentsBO();
        utilAttachedDocumentsBO.setAttachId(this.attachId);
        utilAttachedDocumentsBO.setDocumentName(this.documentName);
        utilAttachedDocumentsBO.setDocumentPath(this.documentPath);
        utilAttachedDocumentsBO.setType(this.type);
        utilAttachedDocumentsBO.setParentId(this.parentId);
        utilAttachedDocumentsBO.setCreatedDate(this.createdDate);
        utilAttachedDocumentsBO.setLevelId(this.levelId);
        utilAttachedDocumentsBO.setSigner(this.signer);
        utilAttachedDocumentsBO.setCode(this.code);
        utilAttachedDocumentsBO.setSignedDate(this.signedDate);
        utilAttachedDocumentsBO.setDescription(this.description);
        utilAttachedDocumentsBO.setUserId(this.userId);
        utilAttachedDocumentsBO.setFileType(this.fileType);
        return utilAttachedDocumentsBO;
    }

    @Override
     public Long getFWModelId() {
        return attachId;
    }
   
    @Override
    public String catchName() {
        return getAttachId().toString();
    }
    public java.lang.Long getAttachId(){
    return attachId;
    }
    public void setAttachId(java.lang.Long attachId)
    {
    this.attachId = attachId;
    }
    
    public java.lang.String getDocumentName(){
    return documentName;
    }
    public void setDocumentName(java.lang.String documentName)
    {
    this.documentName = documentName;
    }
    
    public java.lang.String getDocumentPath(){
    return documentPath;
    }
    public void setDocumentPath(java.lang.String documentPath)
    {
    this.documentPath = documentPath;
    }
    
    public java.lang.Long getType(){
    return type;
    }
    public void setType(java.lang.Long type)
    {
    this.type = type;
    }
    
    public java.lang.Long getParentId(){
    return parentId;
    }
    public void setParentId(java.lang.Long parentId)
    {
    this.parentId = parentId;
    }
    
    public java.util.Date getCreatedDate(){
    return createdDate;
    }
    public void setCreatedDate(java.util.Date createdDate)
    {
    this.createdDate = createdDate;
    }
    
    public java.lang.Long getLevelId(){
    return levelId;
    }
    public void setLevelId(java.lang.Long levelId)
    {
    this.levelId = levelId;
    }
    
    public java.lang.String getSigner(){
    return signer;
    }
    public void setSigner(java.lang.String signer)
    {
    this.signer = signer;
    }
    
    public java.lang.String getCode(){
    return code;
    }
    public void setCode(java.lang.String code)
    {
    this.code = code;
    }
    
    public java.util.Date getSignedDate(){
    return signedDate;
    }
    public void setSignedDate(java.util.Date signedDate)
    {
    this.signedDate = signedDate;
    }
    
    public java.lang.String getDescription(){
    return description;
    }
    public void setDescription(java.lang.String description)
    {
    this.description = description;
    }
    
    public java.lang.Long getUserId(){
    return userId;
    }
    public void setUserId(java.lang.Long userId)
    {
    this.userId = userId;
    }
    
    public java.lang.Long getFileType(){
    return fileType;
    }
    public void setFileType(java.lang.Long fileType)
    {
    this.fileType = fileType;
    }
    
   
}
