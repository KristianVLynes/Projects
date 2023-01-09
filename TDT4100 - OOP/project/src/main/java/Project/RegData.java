package Project;

import java.time.Year;

public class RegData {
	
	private String licencePlate = "";
	private String brand = "";
	private String modell = "";
	private String color = "";
	private int year;
	private double price;
			
	public RegData(String licencePlate, String brand, String modell, String color, int year, double price) throws IllegalArgumentException {
		checkYear(year);
		checkReg(licencePlate);
		checkPrice(price);
		this.licencePlate = licencePlate;
		this.brand = brand;
		this.modell = modell;
		this.color = color;
		this.year = year;
		this.price = price;
	}
	
	public boolean checkReg(String i) throws IllegalArgumentException {		
		if (!(10000 < Integer.parseInt(i.substring(2,7)) &&  99999 > Integer.parseInt(i.substring(2,7)))) throw new IllegalArgumentException("Ugyldig registreringsnummer 2");	
		if(!(Files.getNorskeRegNr().contains(i.substring(0,2)))) throw new IllegalArgumentException("Ugyldig registreringsnummer");
		return true;
	}
	
	public boolean checkPrice(Double i) throws IllegalArgumentException {
		if (!(i > 0)) throw new IllegalArgumentException("Pris kan ikke våre negativ");
		if (!(i<999999999)) throw new IllegalArgumentException("Ugyldig pris");
		return true;
	}
		
	public static int checkYear(int i) throws IllegalArgumentException {
        int thisYear = Year.now().getValue();
        if (i < 1900) {
            throw new IllegalArgumentException("Ugyldig �rsmodell, bilen kan ikke være fra før 1900-tallet.");    }
        if (!(i <= thisYear)) {
            throw new IllegalArgumentException("Ugyldig årsmodell, bil kan ikke være fra fremtiden.");
        }

        return i;
    }

	public String getLicencePlate() {
		return licencePlate;
	}

	public String getBrand() {
		return brand;
	}

	public String getModell() {
		return modell;
	}

	public String getColor() {
		return color;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getPrice() {
		return price;
	}

	public static void main(String[] args) {		
	}	
}
	
