package com.mesc.service.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone_model")
@AttributeOverride(name = "guid", column = @Column(name = "pm_id") )
public class PhoneModel extends BaseEntity {
	private static final long serialVersionUID = 7338327104689237614L;
	private String model, modelNum;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pb_id", nullable = false)
	private PhoneBrand phoneBrand;

	public PhoneModel() {
		super();		
		model = "Some Model";
		modelNum = "ABC-123-ZZZ";
		phoneBrand = new PhoneBrand("Default");
	}
	
	public PhoneModel(String model, PhoneBrand phoneBrand) {
		super();		
		this.model = model;
		this.phoneBrand = phoneBrand;
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

	public PhoneBrand getPhoneBrand() {
		return phoneBrand;
	}

	public void setPhoneBrand(PhoneBrand phoneBrand) {
		this.phoneBrand = phoneBrand;
	}

}
