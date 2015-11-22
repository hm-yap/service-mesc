package com.mesc.service.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.Repository;

import com.mesc.service.entity.PhoneBrand;

public interface PhoneBrandRepository extends Repository<PhoneBrand, String> {
	@Transactional
	void delete(PhoneBrand deleted);
	
	@Transactional
	PhoneBrand save(PhoneBrand persisted);
}
