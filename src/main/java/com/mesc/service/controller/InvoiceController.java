package com.mesc.service.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mesc.service.entity.Invoice;
import com.mesc.service.entity.Tax;
import com.mesc.service.services.InvoiceService;
import com.mesc.service.util.GsonUtil;

@RestController
public class InvoiceController {
	/* Path for Invoice related services */
	private static final String INVOICE_PATH = "/invoice";

	private final InvoiceService invService;

	@Autowired
	InvoiceController(InvoiceService invService) {
		this.invService = invService;
	}

	/**
	 * Create new invoice
	 * 
	 * @return
	 */
	@RequestMapping(value = INVOICE_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createInvoice() {
		return GsonUtil.objToJson(invService.create(), Invoice.class);
	}

	/**
	 * Preview invoice, before creation
	 * 
	 * @return
	 */
	@RequestMapping(value = INVOICE_PATH, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String invoicePreview() {
		return GsonUtil.objToJson(new Invoice(), Invoice.class);
	}

	/**
	 * Get the latest 100 invoices
	 * 
	 * @return
	 */
	@RequestMapping(value = INVOICE_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getLatestInvoice() {
		return GsonUtil.objToJson(new Invoice(), Invoice.class);
	}

	/**
	 * Work in progress These functions is entry point for other filters For
	 * example - invoices for a particular date / containing particular phone,
	 * etc
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = INVOICE_PATH
			+ "/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String findOrder(@PathVariable("orderId") String orderId) {
		// return gson.toJson(new Order(orderId), Order.class);
		BigDecimal invAmt = new BigDecimal(orderId);
		invAmt = invAmt.divide(new BigDecimal("100"));
		BigDecimal taxPct = new BigDecimal("0.06");
		return GsonUtil.objToJson(new Tax(invAmt, taxPct), Tax.class);
	}
}
