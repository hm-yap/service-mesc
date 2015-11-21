package com.mesc.service.entity;

import java.math.BigDecimal;

import com.mesc.service.util.FinanceUtil;

/**
 * Class for testing FinanceUtil
 * 
 * @author IceSeven
 *
 */
public class Tax {
	private String invoiceAmt, taxPercent, taxAmt, subTotal, roundAmt, total;

	public Tax(BigDecimal invAmt, BigDecimal taxPct) {
		BigDecimal taxDeci = FinanceUtil.getTaxAmt(invAmt, taxPct);
		BigDecimal subTotalDeci = invAmt.add(taxDeci);
		BigDecimal totalDeci = FinanceUtil.getRoundedAmt(subTotalDeci);
		BigDecimal roundDiffDeci = subTotalDeci.subtract(totalDeci);

		this.setInvoiceAmt(invAmt.toPlainString());
		this.setTaxPercent(taxPct.toPlainString());
		this.setTaxAmt(taxDeci.toPlainString());
		this.setSubTotal(subTotalDeci.toPlainString());
		this.setRoundAmt(roundDiffDeci.toPlainString());
		this.setTotal(totalDeci.toPlainString());
	}

	public String getInvoiceAmt() {
		return invoiceAmt;
	}

	public void setInvoiceAmt(String invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	public String getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(String taxPercent) {
		this.taxPercent = taxPercent;
	}

	public String getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public String getRoundAmt() {
		return roundAmt;
	}

	public void setRoundAmt(String roundAmt) {
		this.roundAmt = roundAmt;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}
