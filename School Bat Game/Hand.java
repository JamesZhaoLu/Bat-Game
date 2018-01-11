/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2016/9/20
 */


public class Hand {
	int total;
	Deck deck;

    public Hand() {
    	this.total =0;
    	deck = new Deck();
    }
    public static void checkCard(Card aCard, int next, Hand hand){
   
    	hand.total += aCard.suit;
    	next++;
    	
    	if (aCard.suit == 12){
    		hand.total = 99;
    	}
    	if (aCard.suit == 11){
    		hand.total -=21;
    	}
    	if (aCard.suit == 13){
    		hand.total += 7;
    	}
    	if (aCard.suit == 9){
    	next -=2;
    	}
    	if (aCard.suit == 4){
    		next ++;
    	}
    	
    }
    
    
    
    
}