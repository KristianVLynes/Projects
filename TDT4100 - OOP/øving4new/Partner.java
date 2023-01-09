package objectstructures;

//this.partner er nåværende partner, partner er ny partner og this er meg.


public class Partner {
	
	private String navn;
	
	private Partner partner;
	
	
	//konstruktør
	public Partner(String navn) {
		this.navn = navn;
	}
	
	
	
	
	
	
	//metoder
	/*
	 * metode for å skille et par, først sjekker den om partneren din eksisterer, dersom 
	 * h*n gjør det
	 */
	
	public void setPartner(Partner nypartner) {
		if (this.partner == nypartner) {
			return;
		} 
		// husk den gamle, for Â sette ny
		/*
		 * Her skiller vi slik at dersom den nåværende partnern din ikke er lik den nye partnern,
		 * så gjøres gammel partner til nåværende partner, og så gjøres nåværende partner om
		 * til ny partner.
		 */
		Partner lastpartner = this.partner;
		this.partner = nypartner;
		
		/*(til det under)
		 * hvis den forrige partnern din eksisterer, og den gamle partnern din sin partner var deg
		 * så settes den gamle partnern din sin partnerskapsstatus lik "null". dvs dere
		 * er ikke sammen fra gamle partner sitt perspektiv.
		 */
		if (lastpartner != null && lastpartner.getPartner() == this) {
			lastpartner.setPartner(null);
			
		} 
		// hvis partnern din er ulik "null", så skal partnern din sin partner settes til deg.
		if (this.partner != null) {
			this.partner.setPartner(this);
		}
	}
	
	
	//getter
		public Partner getPartner(){
			return partner;
		}
	
	
	public String getNavn() {
		return navn;
	}
	
	
	
	
	public String toString() {
		return ""+getNavn();
	}
	
	
	public static void main(String[] args) {
		Partner test1 = new Partner("1");
		Partner test2 = new Partner("2");
		Partner test3 = new Partner("3");
		Partner test4 = new Partner("4");
		
		
		test1.setPartner(test2);
		System.out.println(test1.getPartner());
		System.out.println(test2.getPartner());
		System.out.println(test3.getPartner());
		System.out.println();
		
		
		test2.setPartner(test4);
		System.out.println(test1.getPartner());
		System.out.println(test2.getPartner());
		System.out.println(test3.getPartner());
		System.out.println(test4.getPartner());
		
	}

}