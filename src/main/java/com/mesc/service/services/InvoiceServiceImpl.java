package com.mesc.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mesc.service.entity.Invoice;
import com.mesc.service.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	private final InvoiceRepository invRepo;
	
	@Autowired
	public InvoiceServiceImpl(InvoiceRepository invRepo) {
		this.invRepo = invRepo;
	}
	
	@Transactional
	public Invoice createInvoice() {
		Invoice newInvoice = new Invoice();
		return invRepo.save(newInvoice);
	}
}
