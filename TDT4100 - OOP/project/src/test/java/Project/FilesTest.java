package Project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//@ParameterizedTest

class FilesTest {
	
	//tester om programmet inneholder denne bilen, den skal ligge inne i appen som en "utstillingsbil",
	//fordi det var den letteste måten for oss å sjekke funksjonaliteten til bilen.
	@Test
	void testLoadDataFromFile() {
		Files test = new Files();
		test.loadDataFromFile();
		Assertions.assertTrue( test.getSavesToHash().containsKey("LJ32048"));
	}
	
	//test value i bilen som funker, HÅKON TEST DENNE.
		@Test
		void testLoadDataFromFile2() {
			Files test = new Files();
			test.loadDataFromFile();
			Assertions.assertTrue( test.getSavesToHash().containsValue("Volvo C30 Sort 2010 79000.0"));
		}
	
		
	//test en ikke-eksisterende bil.	
	@Test
	void testLoadDataFromFile3() {
		Files test = new Files();
		test.loadDataFromFile();
		Assertions.assertFalse( test.getSavesToHash().containsKey("LJ62548"));
	}
	
	//test ikke-eksisterende value (altså info om en bil, der bilen med følgende info ikke eksisterer)
	@Test
	void testLoadDataFromFile4() {
		Files test = new Files();
		test.loadDataFromFile();
		Assertions.assertFalse( test.getSavesToHash().containsValue("info om bil som ikke eksisterer"));
	}
	

}
