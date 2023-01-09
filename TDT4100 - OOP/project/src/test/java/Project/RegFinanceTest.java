package Project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RegFinanceTest {
	
	@Test
	public void testCheckValues() throws IllegalArgumentException {
		RegFinance test = new RegFinance(133254, 10, 12, 3);
		test.checkValues(10, 12, 3);
		Assertions.assertEquals(10, test.getEquity());
		// Calculate years to months (12 years are 144 months)
		Assertions.assertEquals(144, test.getRepaymentPeriod());
		// For calculation is 3 turned into 1.03 (3% is the same as multipling by 1.03)
		Assertions.assertEquals(1.03, test.getInterestRate());
	}
	
	@Test
	void testPrice() {
		RegFinance test = new RegFinance(13354, 1000, 10, 3);
		Assertions.assertEquals(13354, test.getPrice());
	}
	@Test
	void testEquity() {
		RegFinance test = new RegFinance(13354, 1000, 10, 3);
		Assertions.assertEquals(1000, test.getEquity());
	}
	@Test
	void testRepaymentPeriod() {
		RegFinance test = new RegFinance(13354, 1000, 10, 3);
		// Calculate years to months (10 years are 120 months)
		Assertions.assertEquals(120, test.getRepaymentPeriod());
		}
	@Test	
	void testInterestRate() {
		RegFinance test = new RegFinance(13354, 1000, 10, 3);
		// For calculation is 3 turned into 1.03 (3% is the same as multipling by 1.03)
		Assertions.assertEquals(1.03, test.getInterestRate());
	}
	
	//equity kan ikke være lavere enn 0.
	@Test
	void testWrongCheckValues() {
		//RegFinance test = new RegFinance(133254, -1, 12, 3);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			RegFinance test = new RegFinance(133254, -1, 12, 3);
	});
	}
	
	//prisen kan ikke være under 0, eller under equity.
	@Test
	void testWrongCheckValues2() {
		//RegFinance test = new RegFinance(133254, -1, 12, 3);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			RegFinance test = new RegFinance(0, 1, 12, 3);
	});
	}
	
	//repaymentPeriod kan ikke være mindre enn eller lik 0.
	@Test
	void testWrongCheckValues3() {
		//RegFinance test = new RegFinance(133254, -1, 12, 3);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			RegFinance test = new RegFinance(133254, 1000, 0, 3);
	});
	}
	
	//interestRate kan ikke være mindre enn eller lik 0.
	@Test
	void testWrongCheckValues4() {
		//RegFinance test = new RegFinance(133254, -1, 12, 3);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			RegFinance test = new RegFinance(133254, 1000, 12, 0);
	});
	}
}
	
