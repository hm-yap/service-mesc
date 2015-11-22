package com.mesc.service.services;

import com.mesc.service.entity.PhoneBrand;
import com.mesc.service.entity.PhoneModel;

public interface PhoneCRUDService {
	PhoneModel insertModel();
	
	PhoneBrand insertBrand();
}
