package com.mesc.service.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phone_service")
public class PhoneService extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4399685719299942278L;
	private String imei;
	private int jobNo;
	private BigDecimal svcCharge;
	private Date dateIn, dateOut;

	public PhoneService(String imei, int jobNo) {
		super();
		this.imei = imei;
		this.jobNo = jobNo;
		this.svcCharge = new BigDecimal("0.00");
		this.dateIn = new Date();
	}
	
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public BigDecimal getSvcCharge() {
		return svcCharge;
	}

	public void setSvcCharge(BigDecimal svcCharge) {
		this.svcCharge = svcCharge;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
}
