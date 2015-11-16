package com.mesc.service.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.Repository;

import com.mesc.service.entity.Invoice;

@Transactional
public interface InvoiceRepository extends Repository<Invoice, String> {
	void delete(Invoice deleted);
	
	Invoice save(Invoice persisted);
}
