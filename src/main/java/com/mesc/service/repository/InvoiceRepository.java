package com.mesc.service.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.mesc.service.entity.Invoice;

@Transactional
public interface InvoiceRepository extends Repository<Invoice, String> {
	void delete(Invoice deleted);

	Invoice save(Invoice persisted);

	/**
	 * Get the number of invoices for current month
	 * 
	 * @return Number of invoices for current month
	 */
	@Query(value = "SELECT COUNT(1) FROM INVOICE WHERE MONTH(date_created) = MONTH(CURDATE())"
			+ " AND YEAR(date_created) = YEAR(CURDATE())", nativeQuery = true)
	int getCurMonInvCount();
}
