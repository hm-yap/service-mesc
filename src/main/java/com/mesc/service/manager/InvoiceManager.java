package com.mesc.service.manager;

import org.springframework.beans.factory.annotation.Autowired;

import com.mesc.service.entity.Invoice;
import com.mesc.service.repository.InvoiceRepository;

public class InvoiceManager {
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
