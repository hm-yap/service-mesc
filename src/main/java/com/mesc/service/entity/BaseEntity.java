package com.mesc.service.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.Id;

/**
 * @version 1.0
 * @author Hao Meng Yap
 * @since 1 Sept 2015
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -4423845106924187650L;
	@Id
	protected String guid;
	protected int version;
	protected Date dateCreated, dateModified;
	
	public BaseEntity() {
        this(UUID.randomUUID());
    }

    public BaseEntity(UUID guid) {        
        this(guid.toString());
    }
    
    public BaseEntity(String guid) {
    	this.guid = guid;
    	this.dateCreated = new Date();
        this.dateModified = new Date();
        this.version = 0;
    }

    public String getGUID() {
    	return guid;
    }
    
    public Date getTimeCreated() {
    	return dateCreated;
    }
    
    public Date getTimeModified() {
    	return dateModified;
    }
    
    public void setTimeModified(Date timeModified) {
    	this.dateModified = timeModified;
    }
    
    public int getVersion() {
    	return version;
    }
    
    public void setVersion(int version) {
    	this.version = version;
    }
}
