package com.mesc.service.services;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mesc.service.entity.Invoice;
import com.mesc.service.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	// Latest invoice number for current month
	private static int CUR_MON_INV_NUM = -1;
	private static final DateFormat INV_DATE_FORMAT = new SimpleDateFormat("yyyyMM");
	private static final DecimalFormat INV_NUM_FORMAT = new DecimalFormat("0000");
	// String value for current month, in YYYYMM format
	private static String CUR_MONTH = "";

	private final InvoiceRepository invRepo;

	@Autowired
	public InvoiceServiceImpl(InvoiceRepository invRepo) {
		this.invRepo = invRepo;
	}

	@Transactional
	public Invoice create() {
		Invoice newInvoice = new Invoice();
		newInvoice.setInvoiceNum(getInvoiceNumber());
		return invRepo.save(newInvoice);
	}

	private String getInvoiceNumber() {
		resetInvNum();
		// Retrieves the latest count if the INV NUM resets to -1
		if (CUR_MON_INV_NUM == -1) {
			CUR_MON_INV_NUM = invRepo.getCurMonInvCount();
		}
		++CUR_MON_INV_NUM;
		return CUR_MONTH + "-" + INV_NUM_FORMAT.format(CUR_MON_INV_NUM);
	}

	private void resetInvNum() {
		Date now = new Date();
		// Resets invoice number if the month changed
		// Also updates CUR_MONTH to latest month 
		if (!CUR_MONTH.equals(INV_DATE_FORMAT.format(now))) {
			CUR_MON_INV_NUM = -1;
			CUR_MONTH = INV_DATE_FORMAT.format(now);
		}
	}
}
