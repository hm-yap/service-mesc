package com.mesc.service.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "phone_brand")
@AttributeOverride(name = "guid", column = @Column(name = "pb_id") )
public class PhoneBrand extends BaseEntity {
	private static final long serialVersionUID = -5953286373063234410L;
	private String brandName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phoneBrand")
	private Set<PhoneModel> phoneModels = new HashSet<PhoneModel>(0);

	public PhoneBrand() {
		super();
		brandName = "SomeName";
	}
	
	public PhoneBrand(String brandName) {
		super();
		this.brandName = brandName;		
	}
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set<PhoneModel> getPhoneModels() {
		return phoneModels;
	}
}
