package com.mesc.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mesc.service.entity.PhoneBrand;
import com.mesc.service.entity.PhoneModel;
import com.mesc.service.services.PhoneCRUDService;
import com.mesc.service.util.GsonUtil;

@RestController
public class PhoneController {
	/* Path for Phone related services */
	private static final String PHONE_PATH = "/phone";
	private static final String PHONE_MODEL_PATH = PHONE_PATH + "/model";
	private static final String PHONE_BRAND_PATH = PHONE_PATH + "/brand";
	private final PhoneCRUDService phoneCRUDServ;

	@Autowired
	PhoneController(PhoneCRUDService phoneCRUDServ) {
		this.phoneCRUDServ = phoneCRUDServ;
	}

	@RequestMapping(value = PHONE_BRAND_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createPhoneBrand() {
		return GsonUtil.objToJson(phoneCRUDServ.insertBrand(), PhoneBrand.class);
	}

	@RequestMapping(value = PHONE_MODEL_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createPhoneModel() {
		return GsonUtil.objToJson(phoneCRUDServ.insertModel(), PhoneModel.class);
	}

}
