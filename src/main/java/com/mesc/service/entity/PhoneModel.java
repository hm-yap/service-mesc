package com.mesc.service.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phone_model")
@AttributeOverride(name = "guid", column = @Column(name = "pm_id") )
public class PhoneModel extends BaseEntity {
	private static final long serialVersionUID = 7338327104689237614L;
	private String pb_id, model, modelNum;

	public PhoneModel() {
		super();
		pb_id = "Some Random Brand ID";
		model = "Some Model";
		modelNum = "ABC-123-ZZZ";
	}
	
	public PhoneModel(String pb_id, String model) {
		super();
		this.pb_id = pb_id;
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	public String getPb_id() {
		return pb_id;
	}

	public void setPb_id(String pb_id) {
		this.pb_id = pb_id;
	}

}
