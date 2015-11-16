package com.mesc.service.entity;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "repair_parts")
@AttributeOverride(name = "guid", column = @Column(name = "rp_id"))
public class RepairParts extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4667694145138722439L;
	private int quantity;
	private BigDecimal unitPrice, partAmt;

	public RepairParts() {
		super();
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getPartAmt() {
		return partAmt;
	}

	public void setPartAmt(BigDecimal partAmt) {
		this.partAmt = partAmt;
	}

}
