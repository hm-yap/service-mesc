package com.mesc.service.controller;

import java.math.BigDecimal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mesc.service.entity.Invoice;
import com.mesc.service.entity.PhoneProblem;
import com.mesc.service.entity.Tax;

@RestController
public class ServiceController {
	private static final String INVOICE_PATH = "/invoice";
	private static final String STATUS_PATH = "/status";
	private static Gson gson = new GsonBuilder().create();

	/**
	 * Health check method
	 * @return
	 */
	@RequestMapping(value = STATUS_PATH, method = RequestMethod.GET)
	public String getStatus() {
		return "MESC RESTful Service is running...";
	}

	/**
	 * Create new invoice
	 * @return
	 */
	@RequestMapping(value = INVOICE_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createInvoice() {
		return gson.toJson(new Invoice(), Invoice.class);
	}

	/**
	 * Preview invoice, before creation
	 * @return
	 */
	@RequestMapping(value = INVOICE_PATH, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String invoicePreview() {
		return gson.toJson(new Invoice(), Invoice.class);
	}

	/**
	 * Get the latest 100 invoices
	 * @return
	 */
	@RequestMapping(value = INVOICE_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getLatestInvoice() {
		return gson.toJson(new PhoneProblem(), PhoneProblem.class);
	}

	/**
	 * Work in progress
	 * These functions is entry point for other filters
	 * For example - invoices for a particular date / containing particular phone, etc
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = INVOICE_PATH + "/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String findOrder(@PathVariable("orderId") String orderId) {
		//return gson.toJson(new Order(orderId), Order.class);
		BigDecimal invAmt = new BigDecimal(orderId);
		invAmt = invAmt.divide(new BigDecimal("100"));
		BigDecimal taxPct = new BigDecimal("0.06");		
		return gson.toJson(new Tax(invAmt, taxPct), Tax.class);
	}
}
