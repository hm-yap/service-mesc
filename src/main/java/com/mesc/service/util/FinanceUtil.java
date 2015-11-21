package com.mesc.service.util;

import java.math.BigDecimal;
import java.util.List;

/**
 * Finance utility class to handle financial operations, such as tax
 * calculations, round adjustment.
 * 
 * @author Hao Meng Yap
 *
 */
public class FinanceUtil {
	/**
	 * Simple function to calculate tax amount, rounded to 2 decimal
	 * 
	 * @param preTaxAmt
	 *            Amount before tax
	 * @param taxPct
	 *            Tax percentage
	 * @return Taxed amount
	 */
	public static BigDecimal getTaxAmt(BigDecimal preTaxAmt, BigDecimal taxPct) {
		return preTaxAmt.multiply(taxPct).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	private static final BigDecimal increment = new BigDecimal("0.05");

	/**
	 * Round the amount to the nearest 5 cents<br>
	 * For example:<br>
	 * 0.12 ---> 0.10<br>
	 * 0.13 ---> 0.15<br>
	 * 0.17 ---> 0.15<br>
	 * 0.18 ---> 0.20
	 * 
	 * @param notRoundAmt
	 *            Amount before rounded
	 * @return Amount rounded to the nearest 5 cents
	 */
	public static BigDecimal getRoundedAmt(BigDecimal amtBeforeRnd) {
		BigDecimal divided = amtBeforeRnd.divide(increment, 0, BigDecimal.ROUND_HALF_UP);
		BigDecimal roundedAmt = divided.multiply(increment);
		return roundedAmt;
	}

	/**
	 * Sum a list of sub totals to yield a total sum
	 * 
	 * @param subTotals
	 *            A list of sub totals in BigDecimal
	 * @return Total summed amount of the BigDecimal in the given list
	 */
	public static BigDecimal getTotalSum(List<BigDecimal> subTotals) {
		BigDecimal totalSum = new BigDecimal("0.00");
		subTotals.forEach(subTotal -> totalSum.add(subTotal));
		return totalSum;
	}
}
