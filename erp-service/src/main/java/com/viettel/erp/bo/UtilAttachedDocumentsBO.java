/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.UtilAttachedDocumentsDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "UTIL_ATTACHED_DOCUMENTS")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class UtilAttachedDocumentsBO extends BaseFWModelImpl {
     
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

 public UtilAttachedDocumentsBO() {
        setColId("attachId");
        setColName("attachId");
        setUniqueColumn(new String[]{"attachId"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "UTIL_ATTACHED_DOCUMENTS_SEQ")
            }
    )
@Column(name = "ATTACH_ID", length = 22)
public java.lang.Long getAttachId(){
return attachId;
}
public void setAttachId(java.lang.Long attachId)
{
this.attachId = attachId;
}
@Column(name = "DOCUMENT_NAME", length = 900)
public java.lang.String getDocumentName(){
return documentName;
}
public void setDocumentName(java.lang.String documentName)
{
this.documentName = documentName;
}
@Column(name = "DOCUMENT_PATH", length = 1800)
public java.lang.String getDocumentPath(){
return documentPath;
}
public void setDocumentPath(java.lang.String documentPath)
{
this.documentPath = documentPath;
}
@Column(name = "TYPE", length = 22)
public java.lang.Long getType(){
return type;
}
public void setType(java.lang.Long type)
{
this.type = type;
}
@Column(name = "PARENT_ID", length = 22)
public java.lang.Long getParentId(){
return parentId;
}
public void setParentId(java.lang.Long parentId)
{
this.parentId = parentId;
}
@Column(name = "CREATED_DATE", length = 7)
public java.util.Date getCreatedDate(){
return createdDate;
}
public void setCreatedDate(java.util.Date createdDate)
{
this.createdDate = createdDate;
}
@Column(name = "LEVEL_ID", length = 22)
public java.lang.Long getLevelId(){
return levelId;
}
public void setLevelId(java.lang.Long levelId)
{
this.levelId = levelId;
}
@Column(name = "SIGNER", length = 897)
public java.lang.String getSigner(){
return signer;
}
public void setSigner(java.lang.String signer)
{
this.signer = signer;
}
@Column(name = "CODE", length = 1077)
public java.lang.String getCode(){
return code;
}
public void setCode(java.lang.String code)
{
this.code = code;
}
@Column(name = "SIGNED_DATE", length = 7)
public java.util.Date getSignedDate(){
return signedDate;
}
public void setSignedDate(java.util.Date signedDate)
{
this.signedDate = signedDate;
}
@Column(name = "DESCRIPTION", length = 1050)
public java.lang.String getDescription(){
return description;
}
public void setDescription(java.lang.String description)
{
this.description = description;
}
@Column(name = "USER_ID", length = 22)
public java.lang.Long getUserId(){
return userId;
}
public void setUserId(java.lang.Long userId)
{
this.userId = userId;
}
@Column(name = "FILE_TYPE", length = 22)
public java.lang.Long getFileType(){
return fileType;
}
public void setFileType(java.lang.Long fileType)
{
this.fileType = fileType;
}
   

    @Override
    public UtilAttachedDocumentsDTO toDTO() {
        UtilAttachedDocumentsDTO utilAttachedDocumentsDTO = new UtilAttachedDocumentsDTO();
        //set cac gia tri 
        utilAttachedDocumentsDTO.setAttachId(this.attachId);
        utilAttachedDocumentsDTO.setDocumentName(this.documentName);
        utilAttachedDocumentsDTO.setDocumentPath(this.documentPath);
        utilAttachedDocumentsDTO.setType(this.type);
        utilAttachedDocumentsDTO.setParentId(this.parentId);
        utilAttachedDocumentsDTO.setCreatedDate(this.createdDate);
        utilAttachedDocumentsDTO.setLevelId(this.levelId);
        utilAttachedDocumentsDTO.setSigner(this.signer);
        utilAttachedDocumentsDTO.setCode(this.code);
        utilAttachedDocumentsDTO.setSignedDate(this.signedDate);
        utilAttachedDocumentsDTO.setDescription(this.description);
        utilAttachedDocumentsDTO.setUserId(this.userId);
        utilAttachedDocumentsDTO.setFileType(this.fileType);
        return utilAttachedDocumentsDTO;
    }
}
