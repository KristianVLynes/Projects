package Project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class regDataTester {
	
	
	@Test
	public void testLegalLicencePlate() throws IllegalArgumentException{
		RegData test = new RegData("AB53420", "Nissan", "leaf", "Sort", 2010, 100543);
		boolean output = test.checkReg("AB53420");
		assertEquals(true, output);
	}
	
	@Test
	public void testIllegalLicencePlate() {
		RegData test = new RegData("AB53420", "Nissan", "leaf", "grå", 2010, 1005436);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.checkReg("ABC13253");
		});
	}
	
	@Test
	public void testIllegalLicencePlate2() throws IllegalArgumentException{
		RegData test = new RegData("AB53420", "Nissan", "leaf", "grå", 2010, 1005436);
		Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
			test.checkReg("AB536");
		});
		/*Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
			test.checkReg("AB534526");
		});*/
	}
	
	@Test
	public void testGetters(){
		RegData test = new RegData("BR64738", "Mondeo", "Ford", "Sort", 2001, 149000);
		Assertions.assertEquals("BR64738", test.getLicencePlate());
		Assertions.assertEquals("Mondeo", test.getBrand());
		Assertions.assertEquals("Ford", test.getModell());
		Assertions.assertEquals("Sort", test.getColor());
		Assertions.assertEquals(2001, test.getYear());
		Assertions.assertEquals(149000, test.getPrice());
	}
	
	
	
	@Test
	public void testLegalYear() throws IllegalArgumentException {
		//RegData test = new RegData("AB53420", "Nissan", "leaf", "grå", 2010, 1005436);
		Assertions.assertEquals(2012, RegData.checkYear(2012));
	}
	
	@Test
	public void testIllegalYear() throws IllegalArgumentException{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			RegData.checkYear(1899);
		});
	}
	
	@Test
	public void testIllegalYear2() throws IllegalArgumentException{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			RegData.checkYear(10000);
		});
	}
	
	
}
