package com.mesc.service.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "service_status")
public class ServiceStatus extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6056396766392771212L;
	private String statusName, description;

	public ServiceStatus(String statusName, String description) {
		super();
		this.statusName = statusName;
		this.description = description;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
