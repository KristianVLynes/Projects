package debugging;

import java.util.Random;

public class CoffeeCupProgram {

	private CoffeeCup cup;
	private Random r;
	
	public void init(){
		cup = new CoffeeCup();
		r = new Random(123456789L);
	}
	
	public void run(){
		//part1();
		part2();
	}
	
	
	
	//på linje 28 (linje 40 etter jeg har skrevet denne paragrafen.
	//utløses en feil i del 1. ved bruk av debuggeren
	//finner vi at volume har currentVolume-verdien er 5.0, mens
	//capacity er 57.0, begge disse er like før programmet utløser et unntak.
	
	//I CoffeeCup er det metoden drinkCoffee(double) på linje 61
	//som utløser unntaket.
	
	
	
	private void part1(){
		cup.increaseCupSize(40.0);
		cup.fillCoffee(20.5);
		cup.drinkCoffee(Math.floor(r.nextDouble()*20.5));
		cup.fillCoffee(32.5);
		cup.drinkCoffee(Math.ceil(r.nextDouble()*38.9));
		cup.drinkCoffee(Math.ceil(r.nextDouble()*42));
		cup.increaseCupSize(17);
		cup.drinkCoffee(40); 
		cup.drinkCoffee(Math.ceil(r.nextDouble()*42));
		cup.drinkCoffee(Math.floor(r.nextDouble()*20.5));
		cup.fillCoffee(32.5);
		cup.drinkCoffee(Math.ceil(r.nextDouble()*38.9));
		cup.drinkCoffee(Math.ceil(r.nextDouble()*42));
		cup.increaseCupSize(17);
	}
	
	
	//currentVolumeList = [0, 6.5, 6.5, 6.5, 6.5] er alle verdiene før unntaket kommer
	//på linje 68, var 60 før jeg edita. 
	/*Denne gangen er det metoden fillCoffee(double) i CoffeCup
	 * som utløser unntaket, unntaket som utløses er av typen 
	 * IllegalArgumentException, og advarer om at vi helte kaffe
	 * over hele bordet. 
	 * 
	 * spør om hvorfor volumet ikke endres i listen over før feilmeldingen.
	 */
	
	private void part2(){
		cup = new CoffeeCup(40.0, 20.5);
		r = new Random(987654321L);
		cup.drinkCoffee(Math.floor(r.nextDouble()*20.5));
		cup.fillCoffee(Math.floor(r.nextDouble()*30));
		cup.drinkCoffee(Math.ceil(r.nextDouble()*38.9));
		cup.drinkCoffee(Math.ceil(r.nextDouble()*42));
		cup.increaseCupSize(Math.floor(r.nextDouble()*26));
		cup.fillCoffee(Math.ceil(r.nextDouble()*59));
		cup.drinkCoffee(Math.ceil(r.nextDouble()*42));
		cup.increaseCupSize(Math.floor(r.nextDouble()*35));
		cup.fillCoffee(Math.floor(r.nextDouble()*30));
		cup.increaseCupSize(Math.floor(r.nextDouble()*26));
	}
	
	
	public static void main(String[] args) {
		CoffeeCupProgram program = new CoffeeCupProgram();
		program.init();
		program.run();
	}

}
