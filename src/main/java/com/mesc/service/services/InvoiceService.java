package com.mesc.service.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.mesc.service.entity.Invoice;
import com.mesc.service.repository.InvoiceRepository;

public class InvoiceService {
	@Autowired
	private InvoiceRepository invRepo;
	
	public void createInvoice() {
		//invRepo.save(newInvoice());
	}
	
	private Invoice newInvoice() {
		Invoice newInvoice = new Invoice();
		return newInvoice;
	}
}
