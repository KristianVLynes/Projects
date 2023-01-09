package Project;

import java.lang.Math;

public class RegFinance {
	
	private double price;
    private double equity; //egenkapital
    //private int repaymentPeriod; //payment period i år
    private double interestRate;
    //private double carLoan;
    private double montlyPayment;     
    private int repaymentPeriod;
    private static double termAmount;
        
    public RegFinance(double price, double equity, int repaymentPeriod, double interestRate) throws IllegalArgumentException{
    	this.price = price;
    	checkValues(equity, repaymentPeriod, interestRate);
    	System.out.println("Låneverdier godkjent");
    	this.price = price;
        this.equity = equity;
        this.repaymentPeriod = repaymentPeriod*12;
        this.interestRate = 1 + interestRate/100;
        calculateLoan(this.price, this.equity, this.repaymentPeriod, this.interestRate);
        System.out.println("Beregning av lån fullført");        
    }

    public void checkValues(double equity, int repaymentPeriod, double interestRate) throws IllegalArgumentException{
    	System.out.println("Nå skjekkes låneverdiene");
    	if (equity < 0) {
    		throw new IllegalArgumentException("Egenkapital kan ikke være mindre enn 0,-");
    	}if (repaymentPeriod < 0) {
    		throw new IllegalArgumentException("Nedbetalingstid kan ikke være mindre en ett �r");
    	}if (interestRate < 0) {
    		throw new IllegalArgumentException("Renten kan ikke være mindre enn 0.5%");
    	}if (repaymentPeriod <= 0 || interestRate <= 0) {
    		throw new IllegalArgumentException("Nedbetalingstiden eller retnen er ikke gyldig");
    	}if (equity >= price) {
			throw new IllegalArgumentException("Egenkapital kan ikke v�re større enn bilprisen");
		}
    	return;    	
    }
    
    public void calculateLoan(double price, double equity, int repaymentPeriod, double interestRate) {
    	System.out.println("Begynner kalkulasjon av lån");
    	//Using math for calculating annuity loan, this consist of a geometrical row
    	double loan = price - equity;
    	double repaymentPeriodDouble = repaymentPeriod;
    	double numPowerOf = Math.pow((1)/(interestRate),(repaymentPeriodDouble));
    	double termAmount = (-loan*interestRate+loan)/(numPowerOf-1);
    	this.termAmount = Math.round(termAmount);
    }
        
    public static double getTermAmount() {
		return termAmount;
	}
    
    public double getPrice() {
    	return price;
    }
    
    public double getEquity() {
    	return equity;
    }
    
    public int getRepaymentPeriod() {
    	return repaymentPeriod;
    }
    
    public double getInterestRate() {
    	return interestRate;
    }
    
    public double getMontlyPayment() {
    	return montlyPayment;
    }

	public static void main(String[] args) {    	
    }

}

