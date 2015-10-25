package com.mesc.service.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "spareparts")
public class SpareParts extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4603277043710673841L;
	private String partName;
	private BigDecimal unitPrice;

	public SpareParts(String partName, BigDecimal unitPrice) {
		super();
		this.partName = partName;
		this.unitPrice = unitPrice;
	}
	
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}
