package com.mesc.service.repository;

import org.springframework.data.repository.Repository;

import com.mesc.service.entity.PhoneModel;

public interface PhoneModelRepository extends Repository<PhoneModel, String> {
	void delete(PhoneModel deleted);
	
	PhoneModel save(PhoneModel persisted);
}
