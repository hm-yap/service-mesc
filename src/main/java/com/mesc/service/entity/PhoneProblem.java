package com.mesc.service.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="phone_problem")
public class PhoneProblem extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1472030457662135436L;
	private String detail;
	private BigDecimal partsAmt;
	
	public PhoneProblem() {
		super();
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public BigDecimal getPartsAmt() {
		return partsAmt;
	}

	public void setPartsAmt(BigDecimal partsAmt) {
		this.partsAmt = partsAmt;
	}

}
