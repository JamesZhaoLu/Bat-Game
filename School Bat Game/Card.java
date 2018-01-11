package cardgame;


public class Card {

	int suit, rank;

	public Card () {
		this.suit = 0; this.rank = 0;
	}

	public Card (int suit, int rank) {
		this.suit = suit; this.rank = rank;
	}    

	public String toString() {
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] ranks = { "narf", "Ace", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "Jack", "Queen", "King" };
		return (ranks[this.rank] + " of " + suits[this.suit]);
	}

	public boolean equals(Card C1){
		if (this.rank == C1.rank && this.suit == C1.suit){
			return true;
		}
		return false;
	}

	public static int compareCards (Card c1, Card c2){

		if (c1.suit > c2.suit) return 1;
		if (c1.suit < c2.suit) return -1;
		if (c1.rank>c2.rank) return 1;
		if (c1.rank<c2.rank) return -1;
		return 0;


	}
	public static int findCard (Card[] deck, Card card) {

		for (int i = 0; i< deck.length; i++) {
			if ( deck[i].equals(card)) return i;
		}

		return -1;

	}
	public static int findBisect (Card[] deck, Card card, int low, int high) {
		if (low >= high) return low;
		int mid = (high + low) / 2;
		int comp = compareCards (deck[mid], card);
		if (comp == 0) {
			return mid;
		} else if (comp > 0) {
			return findBisect (deck, card, low, mid-1);
		} else {
			return findBisect (deck, card, mid+1, high);
		}
	}
	public int findBisect(Deck deck1, Card card){
		return findBisect(deck1.cards, card, 0, deck1.cards.length - 1);
	}
	public static void printDeck (Card[] deck) {

		for (int i=0; i<deck.length; i++) {
			System.out.println (deck[i].toString());
		}

	}

	public static Card parseCard(String cName){
		//	"Clubs", "Diamonds", "Hearts", "Spades"
		Card c1 = new Card();

		//cName.toLowerCase();

		if (cName.indexOf("Clubs")>= 0){
			c1.suit= 0;
		}
		if (cName.indexOf("Diamonds")>= 0){
			c1.suit= 1;
		}	
		if (cName.indexOf("Hearts")>= 0){
			c1.suit= 2;
		}	
		if (cName.indexOf("Spades")>= 0){
			c1.suit= 3;
		}
		for (int i=1; i<13; i++){

			if(i<=10){
				if(cName.indexOf((String.valueOf(i))) >=0){
					c1.rank = i;
				}
			}
			else{
				if (cName.indexOf("Jack") >= 0){
					c1.rank = 11;
				}
				else if (cName.indexOf("Queen") >= 0){
					c1.rank =12;
				} 
				else if (cName.indexOf("King") >= 0){
					c1.rank =13;
				}

			}

		}
		return c1;
	}
	public static String suitHist(Card[] tDeck){
		//Card[] cDeck = new Card[4];
		//int spades=0,clubs=0,diamonds=0,hearts=0;
		int[] suitHist = new int[4];
		for (int i=0; i< tDeck.length; i++){
			suitHist[tDeck[i].suit]+=1;
			
//			if (tDeck[i].suit == 0){
//				clubs++;
//			}
//			else if (tDeck[i].suit == 1){
//				diamonds++;
//			}
//			else if (tDeck[i].suit == 2){
//				hearts++;
//			}
//			else if (tDeck[i].suit == 3){
//				spades++;
//			}
		}
		String hist = (" Number of clubs = " + suitHist[0] + ", Number of Diamonds = " + suitHist[1] + ", Number of Hearts = "  + suitHist[2]  + ", Number of Spades = " + suitHist[3]);
		return hist;
	}
	public static boolean isFlush( Card[] tDeck){
		boolean flush = false;
		int count = 0;
		for (int i = 0; i <tDeck.length -1; i++){
			if(tDeck[i].suit == tDeck[i+1].suit){
				count ++;
			}
		}
		if(count == tDeck.length-1){
			flush=true;
		}
		return flush;
	}
	public static void swapCards(Card c1, Card c2){
		Card temp = new Card();
		temp = c1;
		c1=c2;
		c2 = temp;

		//		System.out.println (c1.toString());
		//		System.out.println(c2.toString());
	}

	public static void main (String[] args) {
//		Card[] deck = new Card [52];
//		Card test = new Card();
//		Card[] deck2 = new Card[]{new Card(0,1), new Card(0,13), new Card(0,5)};
//		int index = 0;
//		for (int suit =0; suit <=3; suit ++){
//			for (int rank = 1; rank<= 13; rank++){
//				deck[index] = new Card (suit, rank);
//				index++;
//
//			}
//		}
		//printDeck(deck);
		//System.out.println (test.toString());
		Card c1 = new Card(1,3);
		System.out.println (c1);
//		System.out.println (Card.parseCard("Jack of Spades").toString());
//		System.out.println (Card.suitHist(deck));
//		System.out.println ("Deck is Flush " + Card.isFlush(deck2));
	}

}