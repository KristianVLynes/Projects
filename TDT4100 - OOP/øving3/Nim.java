package encapsulation;

public class Nim {

	//private static Nim test;
	
	private int pileZero;
	private int pileOne;
	private int pileTwo;
	
	//konstruktører
	
	public Nim(int pileSize) {
		checkValueNum(pileSize);
		this.pileZero = pileSize;
		this.pileOne = pileSize;
		this.pileTwo = pileSize;
	}
	
	public Nim() {
		this.pileZero = 10;
		this.pileOne = 10;
		this.pileTwo = 10;
	}
	
	
	
	
	
	
	
	// 2 valideringsmetoder
	public void checkValueNum(int number) {
		if (number < 1) {
			throw new IllegalStateException("Number cant be less than 1");
		}
	}
	
	public void checkValuePile(int targetPile) {
		if (!(targetPile > -1) || !(targetPile < 3)) {
			throw new IllegalStateException("there are 3 piles");
		}
	}
	
	
	
	//Klassens metoder
	public void removePieces(int number, int targetPile) {
		checkValueNum(number);
		checkValuePile(targetPile);
		
		if (targetPile == 1) {
			this.pileZero -= number;
		}
		if (targetPile == 2) {
			this.pileOne -= number;
		}
		if (targetPile == 3) {
			this.pileTwo -= number;
		}
	}
	
	

	
	public boolean isValidMove(int number, int targetPile) {
		if (targetPile == 1 & number >= this.pileZero) {
			return true;
		}
		if (targetPile == 2 & number >= this.pileOne) {
			return true;
		}
		if (targetPile == 3 & number >= this.pileTwo) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public boolean isGameOver(int pileZero, int pileOne, int pileTwo){
		if (pileZero == 0 || pileOne == 0 || pileTwo == 0) {
			return true;
		}
		
		return false;
	}
	
	
	public int getPile(int targetPile) {
		return targetPile;
	}
	
	
	public String toString() {
		String condition =   			"pile 1 has: " + pileZero + "objects. \n" 
											+ "Pile 2 has: " + pileOne + " objects. \n" 
											+ "Pile 3 has: " + pileTwo + "objects. \n" + "The game is currently over: " 
											+ isGameOver(pileZero, pileOne, pileTwo); 
											
		return condition; 
	} 
	
	public static void main(String[] args) {
		Nim test1 = new Nim();
		/*game1.removePieces(5, 1);*/
		System.out.println(test1);
		test1.removePieces(5, 1);
		System.out.println(test1);
		/*game1.removePieces(20, 5);*/
		System.out.println(test1);
		test1.removePieces(8, 2);
		System.out.println(test1);
		test1.removePieces(2, 2);
		System.out.println(test1);
		

		
		

	}

}
