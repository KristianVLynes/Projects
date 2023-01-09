package objectstructures;

import java.util.ArrayList;

public class CardHand {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	
	public int getCardCount() {
		return cards.size();
	}
	
	public Card getCard(int i) {
		if (i < 0 || i >= getCardCount()) {
			throw new IllegalArgumentException(String.format("%s is an illegal card index, when the size of the deck is %s", i, getCardCount()));
		}
		return cards.get(i);
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public Card play(int n) {
		Card playedCard = this.cards.get(n);
		this.cards.remove(n);
		return playedCard;
	}
	public static void main(String[] args) {
		

	}

}
