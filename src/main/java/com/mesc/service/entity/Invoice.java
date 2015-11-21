package com.mesc.service.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
@AttributeOverride(name = "guid", column = @Column(name = "inv_id") )
public class Invoice extends BaseEntity {
	private static final long serialVersionUID = -840296853662944895L;
	private BigDecimal invoiceAmt, taxPct, taxAmt, subTotal, roundAdj, totalAmt;
	private String invoiceNum;
	private Date invoiceDate;

	public Invoice() {
		super();
		this.invoiceDate = new Date();
		this.invoiceAmt = new BigDecimal("0.00");
		this.taxPct = new BigDecimal("0.00");
		this.taxAmt = new BigDecimal("0.00");
		this.subTotal = new BigDecimal("0.00");
		this.roundAdj = new BigDecimal("0.00");
		this.totalAmt = new BigDecimal("0.00");
	}

	public Invoice(String guid) {
		super(guid);
		this.invoiceDate = new Date();
		this.invoiceAmt = new BigDecimal("0.00");
		this.taxPct = new BigDecimal("0.00");
		this.taxAmt = new BigDecimal("0.00");
		this.subTotal = new BigDecimal("0.00");
		this.roundAdj = new BigDecimal("0.00");
		this.totalAmt = new BigDecimal("0.00");
	}

	public BigDecimal getInvoiceAmt() {
		return invoiceAmt;
	}

	public void setInvoiceAmt(BigDecimal invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	public BigDecimal getTaxPct() {
		return taxPct;
	}

	public void setTaxPct(BigDecimal taxPct) {
		this.taxPct = taxPct;
	}

	public BigDecimal getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(BigDecimal taxAmt) {
		this.taxAmt = taxAmt;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getRoundAdj() {
		return roundAdj;
	}

	public void setRoundAdj(BigDecimal roundAdj) {
		this.roundAdj = roundAdj;
	}

	public BigDecimal getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
}
