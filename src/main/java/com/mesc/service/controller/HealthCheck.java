package com.mesc.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
	private static final String STATUS_PATH = "/status";
	
	/**
	 * Health check method
	 * @return
	 */
	@RequestMapping(value = STATUS_PATH, method = RequestMethod.GET)
	public String getStatus() {
		return "MESC RESTful (Service Module) is running...";
	}
}
