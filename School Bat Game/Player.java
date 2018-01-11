/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2016/9/20
 */

import java.util.Scanner;
public class Player {
	Deck playerHand;
	int status;
	

    public Player(int where, Deck play) {
    	playerHand = Deck.subDeck(play,where,where+2);
    	this.status = 0;
    }
    
//    public  void pickUpCard(Deck pick, ArrayList<Card> discard, Card c1, int where){
//    	
//    	discard.add(c1);
//    	this.cards[this.cards.indexof[c1]] = new Card(pick.cards[where].suit, pick.cards[where].rank);
//    }
    
//    public int  playCard(int oldTotal){
//    	System.out.println ("These are your cards: \n What card would you like to play?: " );
//    	//Card[] hands = new Card[this.playerHand.cards.length];
//    	
//    	this.playerHand.printDeck();
//    	String atemp = new Scanner(System.in).nextLine();
//    	int answer = Integer.parseInt(atemp);
//    	int newTotal = 0;
//    	if (answer == 1){
//    		newTotal = Bat.checkCard(this.playerHand.cards[answer-1],oldTotal);
//    		
//    	}
//    	else if (answer == 2){
//    		newTotal = Bat.checkCard(this.playerHand.cards[answer-1],oldTotal);
//    	}
//    	else if (answer == 3){
//    		newTotal = Bat.checkCard(this.playerHand.cards[answer-1],oldTotal);
//    	}
//    	else{
//    		 System.out.println ("Please enter valid number");
//    	}
// 		System.out.println ("The total is now: " + newTotal);
// 		
// 		return newTotal;
//    }
//    
}