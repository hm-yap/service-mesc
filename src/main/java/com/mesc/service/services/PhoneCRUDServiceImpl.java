package com.mesc.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mesc.service.entity.PhoneBrand;
import com.mesc.service.entity.PhoneModel;
import com.mesc.service.repository.PhoneBrandRepository;
import com.mesc.service.repository.PhoneModelRepository;

@Service
public class PhoneCRUDServiceImpl implements PhoneCRUDService {

	private final PhoneBrandRepository phoneBrandRepo;
	private final PhoneModelRepository phoneModelRepo;

	@Autowired
	public PhoneCRUDServiceImpl(PhoneBrandRepository phoneBrandRepo, PhoneModelRepository phoneModelRepo) {
		this.phoneBrandRepo = phoneBrandRepo;
		this.phoneModelRepo = phoneModelRepo;
	}

	@Override
	public PhoneBrand insertBrand() {
		PhoneBrand newPhoneBrand = new PhoneBrand("Some Brand");
		return phoneBrandRepo.save(newPhoneBrand);
	}

	@Override
	public PhoneModel insertModel() {
		PhoneModel newPhoneModel = new PhoneModel("Brand ID Here", "Some Model");
		return phoneModelRepo.save(newPhoneModel);
	}

}
