package com.mesc.service.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phone_model")
public class PhoneModel extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7338327104689237614L;
	private String brand, model;

	public PhoneModel(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
