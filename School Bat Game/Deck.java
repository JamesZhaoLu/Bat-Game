import java.util.*;

public class Deck{
	Card[] cards;

	public Deck(int n) {
		this.cards = new Card[n];
	}    
	public Deck(){
		this.cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit <=3; suit++){
			for (int rank = 1; rank<=13; rank++){
				cards[index] = new Card(suit,rank);
				index++;
			}
		}
	}
	public void printDeck(){
		for (int i=0;i<this.cards.length; i++){
			System.out.println ((i+1) + " " + this.cards[i].toString());
		}
	}
	public static int findCard (Deck deck, Card card) {

		for (int i = 0; i< deck.cards.length; i++) {
			if ( deck.cards[i].equals(card)) return i;
		}

		return -1;

	}
	public static int randomInt ( int low, int high){

		Random rand = new Random();
		int randNum = rand.nextInt(high-low)+low;
		//int random = Math.random()*(high-low) + low;
		return randNum;
	}
	public static void swapCards(Card c1, Card c2){
		Card temp = new Card(c1.suit, c1.rank);
		c1.rank=c2.rank;
		c1.suit = c2.suit;
		c2.rank = temp.rank;
		c2.suit = temp.suit;
	}
	public void shuffleDeck(){
		for (int i = 0; i< this.cards.length; i++){
			Deck.swapCards(this.cards[Deck.randomInt(i, this.cards.length)], this.cards[i]);
		}
	}
	

	public void Remove(Card aCard, Hand theHand){
		for (int i =0; i<this.cards.length; i++){
			if(aCard.equals(this.cards[i])){
				 this.cards[i] =null;
				 
			}		
		}
	}
	public static void pickUp(Deck dplayer, Deck d2, int counter){
		for (int i = 0; i<dplayer.cards.length; i++){
			if(dplayer.cards[i] == null){
				dplayer.cards[i] = new Card(d2.cards[counter].suit, d2.cards[i].rank); 
			}
		}
	}
	public static Deck subDeck(Deck deck, int low, int high){

		Deck sub = new Deck(high-low+1);
		for (int i =0; i<sub.cards.length; i++){
			sub.cards[i] = new Card( deck.cards[low+i].suit, deck.cards[low+i].rank);	

		}
		return sub;
	}
	public void sortLinDeck(){
		for (int i=0; i<this.cards.length ; i++){
			for (int j=0; j<=i; j ++){
				if (Card.compareCards(this.cards[j], this.cards[i]) == 1){
					Deck.swapCards(this.cards[j],this.cards[i]);
				}
			}
		}
	}
	public static Deck merge (Deck d1, Deck d2){
		Deck dtot = new Deck(d1.cards.length+d2.cards.length);
		int i =0;
		int j =0;
		for (int k= 0; k<dtot.cards.length; k++){
			if(i >= d1.cards.length){
				for (int l=j; l< d2.cards.length; l++)
					dtot.cards[k++] = new Card(d2.cards[l].suit, d2.cards[l].rank);
			
				}
			else if (j >= d2.cards.length){
				for (int m=i; m< d1.cards.length; m++)
					dtot.cards[k++] = new Card(d1.cards[m].suit, d1.cards[m].rank);
		
				}
			else{
				if (i < d1.cards.length && j<d2.cards.length){
					int comp =	Card.compareCards(d1.cards[i], d2.cards[j]);
					if (comp >0) {
					
						dtot.cards[k] = new Card(d2.cards[j].suit, d2.cards[j].rank);
						j++;
					}
					else if (comp <= 0){
					
						dtot.cards[k] = new Card(d1.cards[i].suit, d1.cards[i].rank);
						i++;
					}
				}
			}

		}
		return dtot;
	}
	public static Deck mergeSort (Deck deck){
		if (deck.cards.length <= 1){
			return deck;
		}
		
		int mid = deck.cards.length/2;

		Deck dlow = subDeck(deck, 0, mid -1);
	
		Deck dhigh = subDeck(deck, mid, deck.cards.length-1);
		
		Deck dlowSorted = mergeSort(dlow);
	
		Deck dHighSorted = mergeSort(dhigh);
		return merge(dlowSorted, dHighSorted);
	}
	
//	public static int (Deck deck, Card card1){
//		int mid = (deck.cards.length-1)/2;
//		
//		Card card2 = new Card(card1.suit, card1.rank);
//		int comp = Card.compareCards(deck.cards[mid], card2);
//		if (comp == 0) {
//			return mid;
//		} else if (comp > 0) {
//			return findBisect (deck, card1, 0, mid-1);
//		} else {
//			return findBisect (deck, card1, mid+1, deck.cards.length-1);
//
//		}
//	}

	public static void main (String[] args) {
		//		Card t1 = new Card(0,1);
		//		Card t2 = new Card(3,13);
		//		Deck.swapCards(t1,t2);
		//		System.out.println(t1);
		//		System.out.println(t2);
		Deck d1 = new Deck();
		//d1.printDeck();
		//System.out.println (" ");
		d1.shuffleDeck();
		d1.printDeck();
		//d1.printDeck();
		//Deck dsort = mergeSort(d1);
	
		System.out.println (" ");
		//		d1.sortLinDeck();
		//		d1.printDeck();
		//		System.out.println (" ");
		//		Deck hand1 = subDeck(d1,0,4);
		//		Deck hand2 = subDeck(d1,5,9);
		//		Deck hand3 = subDeck(d1,10,51);
	}
}


