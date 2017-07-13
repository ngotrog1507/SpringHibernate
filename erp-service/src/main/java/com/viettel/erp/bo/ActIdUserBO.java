/* 
* Copyright 2011 Viettel Telecom. All rights reserved. 
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.viettel.erp.bo;

import com.viettel.erp.dto.ActIdUserDTO;
import com.viettel.service.base.model.BaseFWModelImpl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "ACT_ID_USER")
/**
 *
 * @author: ThuanNHT
 * @version: 1.0
 * @since: 1.0
 */
public class ActIdUserBO extends BaseFWModelImpl {
     
private java.lang.Long id;
private java.lang.String email;
private java.lang.String first;
private java.lang.String last;
private java.lang.Long pictureId;
private java.lang.String pwd;
private java.lang.Long rev;

 public ActIdUserBO() {
        setColId("id");
        setColName("id");
        setUniqueColumn(new String[]{"id"});
}

@Id
@GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence",
            parameters = {
                @Parameter(name = "sequence", value = "ACT_ID_USER_SEQ")
            }
    )
@Column(name = "ID_", length = 255)
public java.lang.Long getId(){
return id;
}
public void setId(java.lang.Long id)
{
this.id = id;
}
@Column(name = "EMAIL_", length = 255)
public java.lang.String getEmail(){
return email;
}
public void setEmail(java.lang.String email)
{
this.email = email;
}
@Column(name = "FIRST_", length = 255)
public java.lang.String getFirst(){
return first;
}
public void setFirst(java.lang.String first)
{
this.first = first;
}
@Column(name = "LAST_", length = 255)
public java.lang.String getLast(){
return last;
}
public void setLast(java.lang.String last)
{
this.last = last;
}
@Column(name = "PICTURE_ID_", length = 22)
public java.lang.Long getPictureId(){
return pictureId;
}
public void setPictureId(java.lang.Long pictureId)
{
this.pictureId = pictureId;
}
@Column(name = "PWD_", length = 255)
public java.lang.String getPwd(){
return pwd;
}
public void setPwd(java.lang.String pwd)
{
this.pwd = pwd;
}
@Column(name = "REV_", length = 22)
public java.lang.Long getRev(){
return rev;
}
public void setRev(java.lang.Long rev)
{
this.rev = rev;
}
   

    @Override
    public ActIdUserDTO toDTO() {
        ActIdUserDTO actIdUserDTO = new ActIdUserDTO();
        //set cac gia tri 
        actIdUserDTO.setId(this.id);
        actIdUserDTO.setEmail(this.email);
        actIdUserDTO.setFirst(this.first);
        actIdUserDTO.setLast(this.last);
        actIdUserDTO.setPictureId(this.pictureId);
        actIdUserDTO.setPwd(this.pwd);
        actIdUserDTO.setRev(this.rev);
        return actIdUserDTO;
    }
}
