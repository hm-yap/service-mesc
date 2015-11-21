package com.mesc.service.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
	private static final String SERVICE_PATH = "/service";

	/**
	 * Temporary placeholder - Work in Progress
	 * 
	 * @return
	 */
	@RequestMapping(value = SERVICE_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getLatestInvoice() {
		return "Service Path running! - Coming Soon";
	}
}
