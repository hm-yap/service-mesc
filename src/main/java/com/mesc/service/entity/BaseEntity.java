package com.mesc.service.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.util.Assert;

/**
 * @version 1.0
 * @author Hao Meng Yap
 * @since 1 Sept 2015
 */
public abstract class BaseEntity implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -4423845106924187650L;
	@Id
	private String guid;
	private int version;
	private Date timeCreated, timeModified;
	
	public BaseEntity() {
        this(UUID.randomUUID());
    }

    public BaseEntity(UUID guid) {
        Assert.notNull(guid, "UUID is required");
        this.guid = guid.toString();
        this.timeCreated = new Date();
        this.timeModified = new Date();
        this.version = 0;
    }

    public String getGUID() {
    	return guid;
    }
    
    public Date getTimeCreated() {
    	return timeCreated;
    }
    
    public Date getTimeModified() {
    	return timeModified;
    }
    
    public void setTimeModified(Date timeModified) {
    	this.timeModified = timeModified;
    }
    
    public int getVersion() {
    	return version;
    }
    
    public void setVersion(int version) {
    	this.version = version;
    }
}
