package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Files implements FileManagement{
	private static ArrayList<String> norskeRegNr = readRegNrFile();
	private HashMap<String, String> carRegister = new HashMap<String, String>();
	private HashMap<String, String> savesToHash = new HashMap<String, String>();
	public final static String FILENAME = "cardata.txt";
	
	public static ArrayList<String> readRegNrFile() {
		Scanner s;
		try {
			s = new Scanner(new File("norskeRegNr.txt"));
			ArrayList<String> fileToList = new ArrayList<String>();
			while (s.hasNextLine()) {
				fileToList.add(s.nextLine());
			}			
			return fileToList;		
		}		
		catch (FileNotFoundException e) {
		return null;
		}
	}
	
	@Override
	public void loadDataFromFile() {
		Scanner cardata;
		try {
			cardata = new Scanner(new File("cardata.txt"));						
			while (cardata.hasNextLine()) {
				String carString = cardata.nextLine();
				String[] carStringList = carString.split(" ");				
				String hashKey = carStringList[0];
				String hashValue = carStringList[1] + " " + carStringList[2] + " " + carStringList[3] + " " + carStringList[4] + " " + carStringList[5];
				savesToHash.put(hashKey, hashValue);				
			}
		}		
		catch (Exception e){
			e.getMessage();
		}	
	}
	
	@Override
	public void save(String key, String value) throws FileNotFoundException {
		FileWriter filewriter;
		try {
			filewriter = new FileWriter(FILENAME, true);
			PrintWriter outFile = new PrintWriter(filewriter);
			outFile.println(key + " " + value);
			outFile.close();
		}
		catch (Exception e){
			e.getMessage();
		}
	}	

	public static ArrayList<String> getNorskeRegNr() {
		return norskeRegNr;
	}
	
	public HashMap<String, String> getCarRegister() {		
		return carRegister;
	}
	
	public HashMap<String, String> getSavesToHash() {
		return savesToHash;
	}
	
	public Double getInterestRate() {
		return null;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
	}

}
