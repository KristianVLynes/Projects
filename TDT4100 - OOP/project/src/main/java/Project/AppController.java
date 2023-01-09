package Project;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
    
public class AppController implements Initializable{
	
	private Files files = new Files();
	private double carPriceDouble;
	
	@FXML 
	private Button btnAddCar;
	
	@FXML
	private Button btnLoan;
	
	@FXML
	private TextField tfRegNr;
	
	@FXML
	private TextField tfBrand;
	
	@FXML
	private TextField tfCarModel;
	
	@FXML
	private TextField tfColor;
	
	@FXML
	private TextField tfYear;
	
	@FXML
	private TextField tfPrice;
	
	@FXML
	private TextField tfLoan;
	
	@FXML
	private TextField tfIntrestRate;
	
	@FXML
	private TextField tfRepaymentPeriod;
	
	@FXML
	private TextField tfEquity;
	
	@FXML
	private TextArea taCars;
	
	@FXML
	private TextArea taLoan;
	
	@FXML
	private TextField tfCarInfo;
	
	@FXML
	private TextArea taErrors;
	
	@FXML
	private ListView<String> lvCars;
	
	@FXML
	private void displaySelected() {
		String selectedCar = lvCars.getSelectionModel().getSelectedItem();		
		for (Entry<String, String> x: files.getSavesToHash().entrySet()) {
		    if(x.getKey().equals(selectedCar)) {
		    	tfCarInfo.setText(x.getValue());
		    	String[] retrivePriceFromCar = x.getValue().split(" ");
		    	String carPriceString = retrivePriceFromCar[4];
		    	this.carPriceDouble = Double.parseDouble(carPriceString);
		    }   
		}
	}
	
	@FXML
	public void addCar() {				
		if (tfRegNr.getText().length() == 0 || tfBrand.getText().length() == 0 || tfCarModel.getText().length() == 0 || tfColor.getText().length() == 0 || tfYear.getText().length() == 0 || tfPrice.getText().length() == 0) {
			taErrors.setText("Alle felter må være fylt ut");
			return;
		}				
		if (tfRegNr.getText().length() != 7) {
			taErrors.setText("Ugyldig registreringsnummer");
			return;
		}		
		try {				
			RegData testReg = new RegData(tfRegNr.getText(), tfBrand.getText(), tfCarModel.getText(), tfColor.getText(), Integer. valueOf(tfYear.getText()), Double. parseDouble(tfPrice.getText()));
			String carReg = testReg.getLicencePlate();
			String carInfo = testReg.getBrand() + " " + testReg.getModell() + " " + testReg.getColor() + " " + testReg.getYear() + " " + testReg.getPrice();
			files.getCarRegister().put(carReg, carInfo);
			taErrors.setText("");
			try {
				files.save(carReg, carInfo);
				
			}
			catch (FileNotFoundException i) {
				taErrors.setText(i.getMessage());
			}
		}		
		catch (IllegalArgumentException e){
			taErrors.setText(e.getMessage());
		}
		lvCars.getItems().clear();
		files.loadDataFromFile();
		Set<String> keys = files.getSavesToHash().keySet();
		lvCars.getItems().addAll(keys);
		}	
	
	@FXML
	public void addFinance() {
		if (tfEquity.getText().length() == 0 || tfRepaymentPeriod.getText().length() == 0 || tfIntrestRate.getText().length() == 0) {
			taErrors.setText("Alle felter må være fylt ut");
			return;
		}
		
		try { 
			RegFinance testFin = new RegFinance(carPriceDouble, Double. parseDouble(tfEquity.getText()), Integer. valueOf(tfRepaymentPeriod.getText()), Double. parseDouble(tfIntrestRate.getText()));
			taLoan.setText("Terminbeløpet per måned blir: " + RegFinance.getTermAmount()+"kr");		
		} catch (IllegalArgumentException e){ 
			taErrors.setText(e.getMessage());
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		files.readRegNrFile();
		files.loadDataFromFile();		
		Set<String> keys = files.getSavesToHash().keySet();
		lvCars.getItems().addAll(keys);
	}	
}
