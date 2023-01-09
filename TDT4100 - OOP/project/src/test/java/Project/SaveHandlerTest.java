package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SaveHandlerTest {
	
	public boolean testSaveToFile() throws FileNotFoundException {
		Scanner s;
		s = new Scanner(new File("cardata.txt"));
		while (s.hasNextLine()) {
			System.out.println(s.nextLine());;
			if (s.nextLine().equals("LS64373 Volvo V70 Hvit 2010 79000.0")) {
				return true;
			}
		}			
		return false;
	} 	
	
	@Test
	public void testSave() throws FileNotFoundException {
		Files test = new Files();
		// To verify the savemethod works, you can open cardata.txt and delete the car the line under just added
		// and then run the test code again to see it actually saves car to the file.
		test.save("LS64373", "Volvo V70 Hvit 2010 79000.0") ;
		Assertions.assertTrue(testSaveToFile());
	}

}
